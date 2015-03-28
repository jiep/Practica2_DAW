package tiendapox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;
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
				products.findAll()).addObject("order", cart);
	}

	@RequestMapping("/order")
	public ModelAndView order(HttpSession session) {
		ModelAndView mv = new ModelAndView(); 
		mv = new ModelAndView("order").addObject("products", (Cart) session.getAttribute("cart"));

		return mv;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public ModelAndView admin(HttpSession session, @RequestParam String user,
			@RequestParam String pass) {

		final String USER = "admin";
		final String PASS = "1234";

		System.out.println("usuario: " + user);
		System.out.println("pass: " + pass);
		Integer permiso = (Integer) session.getAttribute("permisos");
		ModelAndView mv = new ModelAndView();

		if (user.equals(USER) && pass.equals(PASS)) {
			mv = new ModelAndView("admin").addObject("products",
					products.findAll());
			session.setAttribute("permisos", 1);
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Login no válido")
					.addObject("products", products.findAll())
					.addObject("order", (Cart) session.getAttribute("cart"));
		}
		return mv;
	}

	@RequestMapping("/admin")
	public ModelAndView admin(HttpSession session) {

		ModelAndView mv = new ModelAndView();
		Integer permiso = (Integer) session.getAttribute("permisos");
		if (permiso != null) {
			if (permiso == 1) {
				mv = new ModelAndView("admin").addObject("products",
						products.findAll());
			} else {
				mv = new ModelAndView("index")
						.addObject("error", "Acceso no permitido")
						.addObject("products", products.findAll())
						.addObject("order", (Cart) session.getAttribute("cart"));
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Acceso no permitido")
					.addObject("products", products.findAll())
					.addObject("order", (Cart) session.getAttribute("cart"));
		}
		return mv;
	}
	
	@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
	public ModelAndView confirmOrder(HttpSession session,
	@RequestParam("userName") String userName,
	@RequestParam("surname") String surname) {
 
		Cart cart = (Cart) session.getAttribute("cart");

		Order order = new Order(cart,userName,surname);

		Cart newCart = new Cart();
		session.setAttribute("cart", newCart);

		orders.save(order);

		return new ModelAndView("index").addObject("products",
				products.findAll()).addObject("order", newCart)
				.addObject("completed", "Pedido realizado correctamente.");
	}

	@RequestMapping(value="/add")
	public ModelAndView add(HttpSession session,
			@RequestParam("name") String name,
			@RequestParam("category") String category,
			@RequestParam("image") MultipartFile image,
			@RequestParam("description") String description,
			@RequestParam("price") double price) {

		Integer permiso = (Integer) session.getAttribute("permisos");
		ModelAndView mv = new ModelAndView();
		if (permiso != null) {
			if (permiso == 1) {

				String fileName = products.count() + ".png";

				if (!image.isEmpty()) {

					try {

						File filesFolder = new File(FILES_FOLDER);
						if (!filesFolder.exists()) {
							filesFolder.mkdirs();
						}

						File uploadedFile = new File(
								filesFolder.getAbsolutePath(), fileName);
						image.transferTo(uploadedFile);

					} catch (Exception e) {
						mv = new ModelAndView("index").addObject("fileName",
								fileName).addObject("error",
								e.getClass().getName() + ":" + e.getMessage());
					}
				} else {
					// return new ModelAndView("index").addObject("error",
					// "El archivo está");
				}

				Product product = new Product(name, category, fileName,
						description, price);

				System.out.println("Nombre: " + product.getName());
				System.out.println("Categoría: " + product.getCategory());
				System.out.println("Imagen: " + product.getImage());
				System.out.println("Descripción: " + product.getDescription());
				System.out.println("Precio: " + product.getPrice());

				products.save(product);

				mv = new ModelAndView("admin").addObject("products",
						products.findAll());
			} else {
				mv = new ModelAndView("index")
						.addObject("error", "Acceso no permitido")
						.addObject("products", products.findAll())
						.addObject("order", (Cart) session.getAttribute("cart"));

			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Login no válido")
					.addObject("products", products.findAll())
					.addObject("order", (Cart) session.getAttribute("cart"));
		}
		return mv;

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
				products.findAll()).addObject("order", cart);
	}

	@RequestMapping(value = "/moreInformation")
	public ModelAndView moreInformation(@RequestParam int product_id,
			HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		return new ModelAndView("product").addObject("product",
				products.findOne(product_id)).addObject("order", cart);
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(@RequestParam("cuantity") int cuantity,
			@RequestParam("product_id") int product_id, HttpSession session) {

		System.out.println(cuantity);
		System.out.println(product_id);
		Cart cart = (Cart) session.getAttribute("cart");
		ProductWithCuantity ac = new ProductWithCuantity(products.findOne(product_id), 1);
		cart.getProducts().get(cart.getProducts().indexOf(ac))
				.setCuantity(cuantity);

		return new ModelAndView("cart").addObject("order", cart);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView edit(HttpSession session,
			@RequestParam("product_id") int id) {
		Cart cart = (Cart) session.getAttribute("cart");
		Integer permiso = (Integer) session.getAttribute("permisos");
		ModelAndView mv = new ModelAndView();
		if (permiso != null) {
			if (permiso == 1) {
				mv = new ModelAndView("edit").addObject("product",
						products.findOne(id));
			} else {
				mv = new ModelAndView("index")
						.addObject("error", "Acceso no permitido")
						.addObject("products", products.findAll())
						.addObject("order", cart);
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Acceso no permitido")
					.addObject("products", products.findAll())
					.addObject("order", cart);
		}
		return mv;
	}
	
	@RequestMapping(value = "/edit")
	public ModelAndView edi(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		Integer permiso = (Integer) session.getAttribute("permisos");
		ModelAndView mv = new ModelAndView();
		if (permiso != null) {
			if (permiso == 1) {
				mv = new ModelAndView("admin").addObject("products", products.findAll());
			} else {
				mv = new ModelAndView("index")
						.addObject("error", "Acceso no permitido")
						.addObject("products", products.findAll())
						.addObject("order", cart);
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Acceso no permitido")
					.addObject("products", products.findAll())
					.addObject("order", cart);
		}
		return mv;
	}

	@RequestMapping(value = "/edition", method = RequestMethod.POST)
	public ModelAndView edition(HttpSession session,
			@RequestParam("name") String name,
			@RequestParam("category") String category,
			@RequestParam("description") String description,
			@RequestParam("image") MultipartFile image,
			@RequestParam("price") double price,
			@RequestParam(value = "product_id") int id) {

		Cart cart = (Cart) session.getAttribute("cart");
		Integer permiso = (Integer) session.getAttribute("permisos");
		ModelAndView mv = new ModelAndView();
		if (permiso != null) {
			if (permiso == 1) {
				products.findOne(id).setCategory(category);
				products.findOne(id).setDescription(description);
				products.findOne(id).setName(name);
				products.findOne(id).setPrice(price);

				String fileName = id + ".png";
				
				System.out.println("El nombre del fichero nuevo es: " + fileName);

				if (!image.isEmpty()) {
					
					System.out.println("No está vacía");


					try {
						
						System.out.println("Entra en el try");


						File filesFolder = new File(FILES_FOLDER);
						if (!filesFolder.exists()) {
							filesFolder.mkdirs();
						}

						File uploadedFile = new File(
								filesFolder.getAbsolutePath(), fileName);
						image.transferTo(uploadedFile);
						
						products.findOne(id).setImage(fileName);

					} catch (Exception e) {
						return new ModelAndView("index").addObject("fileName",
								fileName).addObject("error",
								e.getClass().getName() + ":" + e.getMessage());
					}
				} else {
					System.out.println("Está vacía");
					// return new ModelAndView("index").addObject("error",
					// "El archivo está");
				}

				mv = new ModelAndView("admin").addObject("products",
						products.findAll());
			} else {
				mv = new ModelAndView("index")
						.addObject("error", "Acceso no permitido")
						.addObject("products", products.findAll())
						.addObject("order", cart);
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Acceso no permitido")
					.addObject("products", products.findAll())
					.addObject("order", cart);
		}
		return mv;
	}

	@RequestMapping("/cart")
	public ModelAndView cart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		return new ModelAndView("cart").addObject("order", cart).addObject(
				"products", products);
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
					"No se encuentra la categoría").addObject("order", cart);
		}

		List<Product> category_products = products.findByCategory(cat);

		if (category_products.isEmpty()) {
			mv = new ModelAndView("index").addObject("category_error",
					"No existen productos en esta categoría").addObject(
					"order", cart);
		} else {
			mv = new ModelAndView("index").addObject("products",
					category_products).addObject("order", cart);
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
					"order", cart);
		} else {
			mv = new ModelAndView("index").addObject("products",
					search_products).addObject("order", cart);
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

	@RequestMapping(value="/admin/remove",  method = RequestMethod.POST)
	public ModelAndView removeProductFromAdmin(HttpSession session,
			@RequestParam(value = "product_id") int id) {

		Cart cart = (Cart) session.getAttribute("cart");

		Integer permiso = (Integer) session.getAttribute("permisos");
		ModelAndView mv = new ModelAndView();
		if (permiso != null) {
			if (permiso == 1) {
				products.delete(id);
				mv = new ModelAndView("admin").addObject("products",
						products.findAll());
			} else {
				mv = new ModelAndView("index")
						.addObject("error", "Acceso no permitido")
						.addObject("products", products.findAll())
						.addObject("order", cart);
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Acceso no permitido")
					.addObject("products", products.findAll())
					.addObject("order", cart);
		}
		return mv;
	}
	
	@RequestMapping("/admin/remove")
	public ModelAndView removeAdmin(HttpSession session, @RequestParam(value = "product_id") int id) {

		Cart cart = (Cart) session.getAttribute("cart");
		Integer permiso = (Integer) session.getAttribute("permisos");
		ModelAndView mv = new ModelAndView();
		if (permiso != null) {
			if (permiso == 1) {
				products.delete(id);
				mv = new ModelAndView("admin").addObject("products",
						products.findAll());
			} else {
				mv = new ModelAndView("index")
						.addObject("error", "Acceso no permitido")
						.addObject("products", products.findAll())
						.addObject("order", cart);
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Acceso no permitido")
					.addObject("products", products.findAll())
					.addObject("order", cart);
		}
		return mv;
	}

	@RequestMapping("/removeFromCart")
	public ModelAndView removeProductFromCart(
			@RequestParam(value = "product_id") int id, HttpSession session) {

		Cart cart = (Cart) session.getAttribute("cart");

		cart.getProducts().remove(id - 1);

		return new ModelAndView("cart").addObject("order", cart);
	}

	@RequestMapping("/admin/orders")
	public ModelAndView orders(HttpSession session) {
		
		Cart cart = (Cart) session.getAttribute("cart");
		Integer permiso = (Integer) session.getAttribute("permisos");
		ModelAndView mv = new ModelAndView();
		if (permiso != null) {
			if (permiso == 1) {
				ArrayList<Order> order = (ArrayList<Order>) orders.findAll();
				
				if(order.isEmpty()){
					mv = new ModelAndView("orders").addObject("error", "No existen pedidos");
				}else{
					mv = new ModelAndView("orders").addObject("orders", order);
				}
			} else {
				mv = new ModelAndView("index")
						.addObject("error", "Acceso no permitido")
						.addObject("products", products.findAll())
						.addObject("order", cart);
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Acceso no permitido")
					.addObject("products", products.findAll())
					.addObject("order", cart);
		}
		return mv;
	}
	
	@RequestMapping("/admin/search/{state}")
	public ModelAndView adminSearch(HttpSession session,
			@PathVariable String state) {

		String st = "";
		
		ModelAndView mv = new ModelAndView();

		switch (state) {
		case "pendiente":
			st = "Pendiente";
			break;
		case "preparado":
			st = "Preparado";
			break;
		}
		
		if(orders.findByState(st).isEmpty()){
			mv = new ModelAndView("orders").addObject("error", "No se encontraron pedidos con el estado solicitado");
		}else{
			mv = new ModelAndView("orders").addObject("orders", orders.findByState(st));
		}

		return mv; 

	}
	
	@RequestMapping("/admin/removeOrder")
	public ModelAndView removeOrder(@RequestParam(value = "order_id") int id, HttpSession session){
		
		orders.delete(id);
		
		ModelAndView mv = new ModelAndView();
		
		if(((ArrayList<Order>) orders.findAll()).isEmpty()){
			mv = new ModelAndView("orders").addObject("error", "No existen pedidos");
		}else{
			mv = new ModelAndView("orders").addObject("orders", orders.findAll());
		}
		
		return mv;
		
	}
	
	@RequestMapping("/new")
	public ModelAndView newProduct(HttpSession session){
		
		
		ModelAndView mv = new ModelAndView();
		
		Integer permiso = (Integer) session.getAttribute("permisos");
		if (permiso != null) {
			if (permiso == 1) {
				mv = new ModelAndView("new");
			}
		}else{
			mv = new ModelAndView("index").addObject("error", "Ruta no permitida");
		}
		
		return mv;
		
	}
	

}