package tiendapox;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	private List<Product> products = new CopyOnWriteArrayList<>();
	private List<Product> order = new ArrayList<>();

	@RequestMapping("/")
	public ModelAndView index() {
		
		products.add(new Product("SAMSUNG Galaxy S5 - negro - Smartphone", "PEQUEÑOS_ELECTRODOMESTICOS", "0.png", "El Galaxy S5 es una auténtica proeza técnica y es un smartphone Samsung de última generación equipado con las mejores tecnologías de telefonía móvil. Este teléfono portátil ultra conectado te permite disfrutar de la alta velocidad con la 4G y el Wifi-ac MIMO. Funciona con Android KitKat 4.4.2 y con un potente procesador Quad Core 2,5 GHz y dispone de 2 Gb de memoria RAM. Su línea con una fineza increíble pone de realce una magnífica pantalla Full HD de 5,1. Esta pantalla táctil  ultra luminosa con una fluidez alucinante garantiza una calidad de imagen excepcional gracias a la tecnología Super AMOLED. Gracias a ésta las imágenes se subliman y tus ojos disfrutarán a lo grande con nada más y nada menos que de 16 millones de colores.Una cámara de fotos  de 16 megapíxeles en la parte trasera del teléfono capta incluso las escenas más efímeras gracias a su enfoque automático de 0,3 segundos. Cuenta también con diversos modos fotográficos que mejoran tus tomas. La captura de vídeo es de calidad Ultra HD 2160p y no tiene nada que envidiarle a las mejores videocámaras digitales. Incluye también una cámara frontal de 2 megapíxeles para tus videoconferencias y videochats en particular.", 435));
		products.add(new Product("Pepe", "PEQUEÑOS_ELECTRODOMESTICOS", "1.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", "PEQUEÑOS_ELECTRODOMESTICOS", "2.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", "PEQUEÑOS_ELECTRODOMESTICOS", "0.png", "Descripción de prueba", 100));
		products.add(new Product("Pepe", "PEQUEÑOS_ELECTRODOMESTICOS", "1.png", "Descripción de prueba", 100));
		
		
		return new ModelAndView("index").addObject("products", products).addObject("order", order);
	}

	@RequestMapping("/order")
	public ModelAndView order() {
		return new ModelAndView("order").addObject("products", products);
	}

	@RequestMapping("/admin")
	public ModelAndView admin() {
		return new ModelAndView("admin").addObject("products", products);
	}

	@RequestMapping("/add")
	public ModelAndView add(Product product) {
		
		products.add(product);
		
		return new ModelAndView("admin").addObject("products", products);
	}
		
	@RequestMapping("/addToCart")
	public ModelAndView addToCart(@RequestParam int product_id){
		
		order.add(products.get(product_id-1));
		
		return new ModelAndView("index").addObject("products", products).addObject("order", order);
	}
	
	@RequestMapping("/cart")
	public ModelAndView cart() {
				
		return new ModelAndView("cart").addObject("order", order);
	}
	
	/*
	 * @RequestMapping("/mostrar") public ModelAndView mostrar(@RequestParam int
	 * numAnuncio) {
	 * 
	 * Anuncio anuncio = anuncios.get(numAnuncio-1);
	 * 
	 * return new ModelAndView("mostrar").addObject("anuncio", anuncio); }
	 */
}