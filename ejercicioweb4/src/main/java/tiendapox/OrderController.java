package tiendapox;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

	@Autowired
	private ProductRepository products;

	@Autowired
	private OrderRepository orders;

	@RequestMapping("/order")
	public ModelAndView order(HttpSession session) {

		ModelAndView mv = new ModelAndView();
		mv = new ModelAndView("order").addObject("order",
				(Cart) session.getAttribute("cart")).addObject("permiso",
				session.getAttribute("permisos"));

		return mv;
	}

	@RequestMapping(value = "/viewOrders")
	public ModelAndView viewOrders() {

		return new ModelAndView("orders").addObject("orders", orders.findAll());
	}

	@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
	public ModelAndView confirmOrder(HttpSession session,
			@RequestParam("userName") String userName,
			@RequestParam("surname") String surname) {

		Cart cart = (Cart) session.getAttribute("cart");

		Order order = new Order(cart, userName, surname);

		Cart newCart = new Cart();
		session.setAttribute("cart", newCart);

		orders.save(order);

		return new ModelAndView("index")
				.addObject("products", products.findAll())
				.addObject("order", newCart)
				.addObject("completed", "Pedido realizado correctamente.")
				.addObject("permiso", session.getAttribute("permisos"));
	}
}
