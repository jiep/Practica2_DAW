package tiendapox;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tiendapox.Product.Category;

@Controller
public class ProductController {

	private List<Product> products = new CopyOnWriteArrayList<>();

	@RequestMapping("/")
	public ModelAndView index() {
		
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "0.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "1.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "2.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "0.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "1.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "2.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "0.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "1.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "2.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "0.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "1.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "2.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "0.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "1.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "2.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "0.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "1.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", Category.PEQUEÑOS_ELECTRODOMESTICOS, "2.png", "Descripción de prueba", 100));


		
		return new ModelAndView("index").addObject("products", products);
	}

	@RequestMapping("/cart")
	public ModelAndView cart() {
		return new ModelAndView("cart").addObject("products", products);
	}
	
	@RequestMapping("/order")
	public ModelAndView order(){
		return new ModelAndView("order").addObject("products", products);
	}
	
	@RequestMapping("/admin")
	public ModelAndView admin(){
		return new ModelAndView("admin").addObject("products", products);
	}
	
	@RequestMapping("/add")
	public ModelAndView add(){
		return new ModelAndView("add").addObject("products", products);
	}

	/*@RequestMapping("/mostrar")
	public ModelAndView mostrar(@RequestParam int numAnuncio) {

		Anuncio anuncio = anuncios.get(numAnuncio-1);

		return new ModelAndView("mostrar").addObject("anuncio", anuncio);
	}*/
}