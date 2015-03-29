package tiendapox;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@Autowired
	private ProductRepository products;

	@Autowired
	private OrderRepository orders;

	private static final String FILES_FOLDER = "files";

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public ModelAndView admin(HttpSession session, @RequestParam String user,
			@RequestParam String pass) {

		final String USER = "admin";
		final String PASS = "1234";

		ModelAndView mv = new ModelAndView();

		if (user.equals(USER) && pass.equals(PASS)) {
			mv = new ModelAndView("admin").addObject("products",
					products.findAll());
			session.setAttribute("permisos", 1);
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Login no válido")
					.addObject("products", products.findAll())
					.addObject("order", (Cart) session.getAttribute("cart"))
					.addObject("permiso", session.getAttribute("permisos"));
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
						.addObject("order", (Cart) session.getAttribute("cart"))
						.addObject("permiso", session.getAttribute("permisos"));
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Acceso no permitido")
					.addObject("products", products.findAll())
					.addObject("order", (Cart) session.getAttribute("cart"))
					.addObject("permiso", session.getAttribute("permisos"));
		}
		return mv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpSession session,
			@RequestParam("order_id") int id,
			@RequestParam("state") String state) {
		Integer permiso = (Integer) session.getAttribute("permisos");
		ModelAndView mv = new ModelAndView();
		if (permiso != null) {
			if (permiso == 1) {
				orders.findOne(id).setState(state);

				Order oaux = orders.findOne(id);
				orders.save(oaux);

				mv = new ModelAndView("orders").addObject("orders",
						orders.findAll());
			} else {
				mv = new ModelAndView("index")
						.addObject("error", "Acceso no permitido")
						.addObject("products", products.findAll())
						.addObject("order", (Cart) session.getAttribute("cart"))
						.addObject("permiso", session.getAttribute("permisos"));
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Login no válido")
					.addObject("products", products.findAll())
					.addObject("order", (Cart) session.getAttribute("cart"))
					.addObject("permiso", session.getAttribute("permisos"));
		}
		return mv;
	}

	@RequestMapping(value = "/add")
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

				products.save(product);

				mv = new ModelAndView("admin").addObject("products",
						products.findAll());
			} else {
				mv = new ModelAndView("index")
						.addObject("error", "Acceso no permitido")
						.addObject("products", products.findAll())
						.addObject("order", (Cart) session.getAttribute("cart"))
						.addObject("permiso", session.getAttribute("permisos"));

			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Login no válido")
					.addObject("products", products.findAll())
					.addObject("order", (Cart) session.getAttribute("cart"))
					.addObject("permiso", session.getAttribute("permisos"));
		}
		return mv;

	}

	@RequestMapping(value = "/edit")
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
						.addObject("order", cart)
						.addObject("permiso", session.getAttribute("permisos"));
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Acceso no permitido")
					.addObject("products", products.findAll())
					.addObject("order", cart)
					.addObject("permiso", session.getAttribute("permisos"));
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
				if(products.findOne(id).getDescription().length() < 250){
					products.findOne(id).setMinidescription(description);
				}else{
					products.findOne(id).setMinidescription(description.substring(0,250));
				}

				String fileName = id + ".png";

				if (!image.isEmpty()) {

					try {

						File filesFolder = new File(FILES_FOLDER);
						if (!filesFolder.exists()) {
							filesFolder.mkdirs();
						}

						File uploadedFile = new File(
								filesFolder.getAbsolutePath(), fileName);
						image.transferTo(uploadedFile);

						products.findOne(id).setImage(fileName);

					} catch (Exception e) {
						return new ModelAndView("index")
								.addObject("fileName", fileName)
								.addObject(
										"error",
										e.getClass().getName() + ":"
												+ e.getMessage())
								.addObject("permiso",
										session.getAttribute("permisos"));
					}
				} else {
					// return new ModelAndView("index").addObject("error",
					// "El archivo está");
				}

				Product paux = products.findOne(id);
				products.save(paux);
				mv = new ModelAndView("admin").addObject("products",
						products.findAll());
			} else {
				mv = new ModelAndView("index")
						.addObject("error", "Acceso no permitido")
						.addObject("products", products.findAll())
						.addObject("order", cart)
						.addObject("permiso", session.getAttribute("permisos"));
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Acceso no permitido")
					.addObject("products", products.findAll())
					.addObject("order", cart)
					.addObject("permiso", session.getAttribute("permisos"));
		}
		return mv;
	}

	@RequestMapping(value = "/admin/remove", method = RequestMethod.POST)
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
						.addObject("order", cart)
						.addObject("permiso", session.getAttribute("permisos"));
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Acceso no permitido")
					.addObject("products", products.findAll())
					.addObject("order", cart)
					.addObject("permiso", session.getAttribute("permisos"));
		}
		return mv;
	}

	@RequestMapping("/admin/remove")
	public ModelAndView removeAdmin(HttpSession session,
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
						.addObject("order", cart)
						.addObject("permiso", session.getAttribute("permisos"));
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Acceso no permitido")
					.addObject("products", products.findAll())
					.addObject("order", cart)
					.addObject("permiso", session.getAttribute("permisos"));
		}
		return mv;
	}

	@RequestMapping("/admin/orders")
	public ModelAndView orders(HttpSession session) {

		Cart cart = (Cart) session.getAttribute("cart");
		Integer permiso = (Integer) session.getAttribute("permisos");
		ModelAndView mv = new ModelAndView();
		if (permiso != null) {
			if (permiso == 1) {
				ArrayList<Order> order = (ArrayList<Order>) orders.findAll();

				if (order.isEmpty()) {
					mv = new ModelAndView("orders").addObject("error",
							"No existen pedidos");
				} else {
					mv = new ModelAndView("orders").addObject("orders", order);
				}
			} else {
				mv = new ModelAndView("index")
						.addObject("error", "Acceso no permitido")
						.addObject("products", products.findAll())
						.addObject("order", cart)
						.addObject("permiso", session.getAttribute("permisos"));
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Acceso no permitido")
					.addObject("products", products.findAll())
					.addObject("order", cart)
					.addObject("permiso", session.getAttribute("permisos"));
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

		if (orders.findByState(st).isEmpty()) {
			mv = new ModelAndView("orders").addObject("error",
					"No se encontraron pedidos con el estado solicitado");
		} else {
			mv = new ModelAndView("orders").addObject("orders",
					orders.findByState(st));
		}

		return mv;

	}

	@RequestMapping("/admin/removeOrder")
	public ModelAndView removeOrder(@RequestParam(value = "order_id") int id,
			HttpSession session) {

		orders.delete(id);

		ModelAndView mv = new ModelAndView();

		if (((ArrayList<Order>) orders.findAll()).isEmpty()) {
			mv = new ModelAndView("orders").addObject("error",
					"No existen pedidos");
		} else {
			mv = new ModelAndView("orders").addObject("orders",
					orders.findAll());
		}

		return mv;

	}

	@RequestMapping("/new")
	public ModelAndView newProduct(HttpSession session) {

		ModelAndView mv = new ModelAndView();

		Integer permiso = (Integer) session.getAttribute("permisos");
		if (permiso != null) {
			if (permiso == 1) {
				mv = new ModelAndView("new");
			}
		} else {
			mv = new ModelAndView("index").addObject("error",
					"Ruta no permitida").addObject("permiso",
					session.getAttribute("permisos"));
		}

		return mv;

	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {

		ModelAndView mv = new ModelAndView();
		Cart cart = (Cart) session.getAttribute("cart");
		Integer permiso = (Integer) session.getAttribute("permisos");
		if (permiso != null) {
			if (permiso == 1) {
				session.setAttribute("permisos", 0);
				mv = new ModelAndView("index")
						.addObject("completed",
								"La sesión se ha cerrado correctamente")
						.addObject("products", products.findAll())
						.addObject("order", cart).addObject("permiso", 0);
			} else {
				mv = new ModelAndView("index")
						.addObject("error", "Ruta no permitida")
						.addObject("products", products.findAll())
						.addObject("order", cart)
						.addObject("permiso", session.getAttribute("permisos"));
			}
		} else {
			mv = new ModelAndView("index")
					.addObject("error", "Ruta no permitida")
					.addObject("products", products.findAll())
					.addObject("order", cart)
					.addObject("permiso", session.getAttribute("permisos"));
		}

		return mv;

	}

}
