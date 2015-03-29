package marketpox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository products;

	@Autowired
	private OrderRepository orders;

	private static final String FILES_FOLDER = "files";

	@RequestMapping("/")
	public ModelAndView index(HttpSession session) {

		if (session.isNew()) {
			session.setAttribute("cart", new Cart());
			session.setAttribute("permisos", 0);
		}

		Cart cart = (Cart) session.getAttribute("cart");

		return new ModelAndView("index").addObject("products",
				products.findAll()).addObject("order", cart).addObject("permiso", session.getAttribute("permisos"));
	}
	
	
	@RequestMapping(value = "/addToCart")
	public ModelAndView addToCart(@RequestParam int product_id,
			HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		ProductWithCuantity ac = new ProductWithCuantity(products.findOne(product_id), 1);
		if (cart.getProducts().contains(ac)) {
			cart.getProducts().get(cart.getProducts().indexOf(ac)).add();
		} else {
			cart.getProducts().add(ac);
		}

		return new ModelAndView("index").addObject("products",
				products.findAll()).addObject("order", cart).addObject("permiso", session.getAttribute("permisos"));
	}

	@RequestMapping(value = "/moreInformation")
	public ModelAndView moreInformation(@RequestParam int product_id,
			HttpSession session) {

		Cart cart = (Cart) session.getAttribute("cart");
		return new ModelAndView("product").addObject("product",
				products.findOne(product_id)).addObject("order", cart).addObject("permiso", session.getAttribute("permisos"));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(@RequestParam("cuantity") int cuantity,
			@RequestParam("product_id") int product_id, HttpSession session) {

		Cart cart = (Cart) session.getAttribute("cart");
		ProductWithCuantity ac = new ProductWithCuantity(products.findOne(product_id), 1);
		cart.getProducts().get(cart.getProducts().indexOf(ac))
				.setCuantity(cuantity);

		return new ModelAndView("cart").addObject("order", cart).addObject("permiso", session.getAttribute("permisos"));
	}
	

	@RequestMapping("/cart")
	public ModelAndView cart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		return new ModelAndView("cart").addObject("order", cart).addObject(
				"products", products).addObject("permiso", session.getAttribute("permisos"));
	}

	@RequestMapping("category/{category}")
	public ModelAndView searchCategory(@PathVariable String category,
			HttpSession session) {

		Cart cart = (Cart) session.getAttribute("cart");

		String cat = "";

		ModelAndView mv = new ModelAndView();

		switch (category) {
		case "electrodomesticos":
			cat = "Pequeños electrodomésticos";
			break;
		case "televisores":
			cat = "Televisores";
			break;
		case "videoconsolas":
			cat = "Videoconsolas";
			break;
		case "informatica":
			cat = "Informática";
			break;
		default:
			return new ModelAndView("index").addObject("error",
					"No se encuentra la categoría").addObject("order", cart).addObject("permiso", session.getAttribute("permisos"));
		}

		List<Product> category_products = products.findByCategory(cat);

		if (category_products.isEmpty()) {
			mv = new ModelAndView("index").addObject("category_error",
					"No existen productos en esta categoría").addObject(
					"order", cart).addObject("permiso", session.getAttribute("permisos"));
		} else {
			mv = new ModelAndView("index").addObject("products",
					category_products).addObject("order", cart).addObject("permiso", session.getAttribute("permisos"));
		}

		return mv;
	}

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam(required = false) String name,
			@RequestParam(required = false) Double from,
			@RequestParam(required = false) Double to, HttpSession session) {

		List<Product> search_products = null;

		Cart cart = (Cart) session.getAttribute("cart");

		if (name != null) {
			search_products = products.findByNameContainingIgnoreCase(name);
		} else if (from != null && to != null) {
			search_products = products.findByPriceBetweenOrderByPriceAsc(from,
					to);
		}

		ModelAndView mv = new ModelAndView();


		if (search_products.isEmpty()) {
			mv = new ModelAndView("index").addObject("category_error",
					"No existen productos con el nombre de " + name).addObject(
					"order", cart).addObject("permiso", session.getAttribute("permisos"));
		} else {
			mv = new ModelAndView("index").addObject("products",
					search_products).addObject("order", cart).addObject("permiso", session.getAttribute("permisos"));
		}

		return mv;
	}

	@RequestMapping("/image/{fileName}")
	public void handleFileDownload(HttpSession session,
			@PathVariable String fileName, HttpServletResponse res)
			throws FileNotFoundException, IOException {

		File file = new File(FILES_FOLDER, fileName + ".png");

		if (file.exists()) {
			res.setContentType("image/png");
			res.setContentLength(new Long(file.length()).intValue());
			FileCopyUtils
					.copy(new FileInputStream(file), res.getOutputStream());
		} else {
			res.sendError(404, "File" + fileName + "(" + file.getAbsolutePath()
					+ ") does not exist");
		}
	}

	@RequestMapping("/removeFromCart")
	public ModelAndView removeProductFromCart(
			@RequestParam(value = "product_id") int id, HttpSession session) {

		
		Cart cart = (Cart) session.getAttribute("cart");

		cart.getProducts().remove(id - 1);

		return new ModelAndView("cart").addObject("order", cart).addObject("permiso", session.getAttribute("permisos"));
	}

}