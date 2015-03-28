package tiendapox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class StartController implements CommandLineRunner {
	@Autowired
	private ProductRepository products;
	
	@Autowired
	private OrderRepository orders;

	@Override
	public void run(String... args) throws Exception {
		products.save(new Product(
				"SAMSUNG Galaxy S5 - negro - Smartphone",
				"Pequeños electrodomésticos",
				"0.png",
				"El Galaxy S5 es una auténtica proeza técnica y es un smartphone Samsung de última generación equipado con las mejores tecnologías de telefonía móvil. Este teléfono portátil ultra conectado te permite disfrutar de la alta velocidad con la 4G y el Wifi-ac MIMO. Funciona con Android KitKat 4.4.2 y con un potente procesador Quad Core 2,5 GHz y dispone de 2 Gb de memoria RAM. Su línea con una fineza increíble pone de realce una magnífica pantalla Full HD de 5,1. Esta pantalla táctil  ultra luminosa con una fluidez alucinante garantiza una calidad de imagen excepcional gracias a la tecnología Super AMOLED. Gracias a ésta las imágenes se subliman y tus ojos disfrutarán a lo grande con nada más y nada menos que de 16 millones de colores.Una cámara de fotos  de 16 megapíxeles en la parte trasera del teléfono capta incluso las escenas más efímeras gracias a su enfoque automático de 0,3 segundos. Cuenta también con diversos modos fotográficos que mejoran tus tomas. La captura de vídeo es de calidad Ultra HD 2160p y no tiene nada que envidiarle a las mejores videocámaras digitales. Incluye también una cámara frontal de 2 megapíxeles para tus videoconferencias y videochats en particular.",
				435));
		products.save(new Product(
				"MOULINEX Masterchef 5000 FP513110 - Robot multifunción",
				"Pequeños electrodomésticos",
				"3.png",
				"El Masterchef 5000 FP513110 pone sus 750 vatios al servicio de tu creatividad culinaria. Este robot multifunción diseñado por Moulinex dispone de un bol picadora y de una licuadora para adaptarse a todas tus necesidades. El Masterchef 5000 sabe picar, mezclar, rallar, cortar en lonchas y emulsionar. Su bol cuenta con una capacidad de 2.2 litros y puede acoger hasta 600 gramos de pasta ligera o espesa, 500 gramos de pasta para panes especiales y medio litro de pasta para crepes o gofres.  Ni que decir tiene que el Masterchef 5000 FP513110 es perfecto para las necesidades familiares.",
				60.23));
		products.save(new Product(
				"DYSON Aspiradora de mano DC34",
				"Pequeños electrodomésticos",
				"4.png",
				"Dyson ha creado la aspiradora de mano DC34 que funciona con una tecnología propia el Root Cylcone, y permite utilizarle en cualquier circunstancia.La aspiradora de mano DC34 es higiénica y fácil de vaciar con su colector de polvo transparente de 0.35 L. Con un clic se saca para vaciarlo evitando el contacto con el polvo.La DC34 incluye una batería litio ion de 22.2 con potencia de 38 o 65 AW. El tiempo de carga completo es de aproximadamente 3h30. Su autonomía es de 6 minutos con una potencia de 65W y hasta 15 minutos con la potencia normal de 38 AW.",
				151.44));
		products.save(new Product(
				"BRAUN Silk-epil 7 7281 - Depiladora eléctrica estanca + SilkFinish FG1000",
				"Pequeños electrodomésticos",
				"5.png",
				"Este pack se compone de la depiladora Silk-epil 7 7281 de Braun, que se puede utilizar en la ducha, y de la depiladora de precisión SilkFinish FG1000.La depiladora Silk-epil 7 de Braun proporciona una depilación suave y completa. Está especialmente diseñada para utilizar bajo el agua caliente para atenuar el dolor.  La Silk-épil 7 Wet&Dry extrae los pelos más cortos y finos. La luz SmartLight permite que ningún pelo pase desapercibido. Su sistema de masaje de alta frecuencia estimula la piel y calma eficazmente la sensación de tirantez.Extremadamente precisa, la depiladora SilkFinish FG1000 de Braun dispone de una gran polivalencia de acabado gracias a sus 2 cabezales y 2 peines-guía.La depiladora SilkFinish FG1000 tiene el tamaño de un lápiz, funciona con pilas y permite eliminar y cortar de forma precisa  los pelos de las cejas, el rostro en general, la ingle y cualquier zona sensible. ",
				89.90));
		products.save(new Product(
				"PHILIPS 3000 Series HQ6927/16 - Máquina de afeitar",
				"Pequeños electrodomésticos",
				"6.png",
				"La máquina de afeitar HQ6927/16 de Philips está diseñada para proporcionar un afeitado apurado y preciso.Su sistema \"Flex & Float\" garantiza un afeitado confortable ajustándose automáticamente a los contornos de la cara. máquina de afeitar HQ6927 de Philips es inalámbrica y tiene una autonomía de 35 minutos... ¡Ideal para el afeitado diario!",
				36.91));

		products.save(new Product(
				"LG 42UB820V - Televisión LED Smart TV Ultra HD",
				"Televisores",
				"7.png",
				"La LG 42UB820V tiene un diseño Cinema Screen que cede todo el protagonismo a la Ultra Alta Definición 4K. Cuenta con una resolución 4 veces superior a la del Full HD 1080p y con una pantalla TV de 42 pulgadas (107 cm) con bordes ultrafinos que reproduce unas imágenes perfectas con un nivel de detalle incomparable tanto de cerca como de lejos. La inmersión en el cine nunca había sido tan intensa.Para vivir esta nueva experiencia en las mejores condiciones, el televisor 42-UB820V incorpora un motor de tratamiento de imagen Triple XD Engine que optimiza el contraste, la claridad y los colores. La tecnología LED Plus, que asocia una retroiluminación de tipo Edge LED a la gestión Local Dimming, garantiza una imagen especialmente luminosa con un tratamiento por zonas para una finura incomparable. Si a esto le añadimos una frecuencia de refresco mejorada UCI 900Hz, obtendremos una imagen con una resolución de 3840 x 2160 píxeles con un realismo asombroso. ",
				541.52));
		products.save(new Product(
				"SAMSUNG UE40H6400 - Televisor LED 3D Smart TV",
				"Televisores",
				"8.png",
				"El interactivo e intuitivo televisor Samsung UE40H6400 te permite navegar rápida y fácilmente en su interfaz Smart TV. Este televisor LED Full HD viene con el nuevo mando a distancia Smart Touch. Utilizando el giroscopio o interacción de voz, podrás pedir y obtener -con un simple gesto o con la voz sobre la programación- consejos sobre la programación basados en tus preferencias de visionado. De este modo, tu televisor UE40-H6400 te propondrá una selección personalizada de contenidos para contentar a toda la familia.",
				477.78));
		products.save(new Product(
				"LG 55UB850V - Televisor LED 3D Smart TV Ultra HD",
				"Televisores",
				"9.png",
				"El LG 55UB850V dispone de un diseño Cinema Screen para disfrutar al máximo de la Ultra Alta Definición de 4K. Cuenta con una resolución 4 veces superior a la de la Full HD 1080p y con pantalla de 55 pulgadas (139 cm) con bordes ultrafinos para ofrecer imágenes perfectas con un nivel de detalle inigualado tanto de cerca como de lejos.  El televisor 55-UB850V incluye el motor de tratamiento de imagenTriple XD Engine que optimiza el contraste, la nitidez y los colores. La tecnología LED Plus, que asocia una retroiluminación de tipo Edge LED con la gestión Local Dimming, garantiza por su parte una imagen particularmente luminosa con un tratamiento por zonas para una fineza incomparable. Gracias a una frecuencia de barrido mejorada UCI 1000Hz obtendrás una imagen de 3840 x 2160 píxeles con un realismo increíble.",
				1149.00));

		Product p1 = new Product(
				"LG 55UB850V - Televisor LED 3D Smart TV Ultra HD",
				"Televisores",
				"9.png",
				"El LG 55UB850V dispone de un diseño Cinema Screen para disfrutar al máximo de la Ultra Alta Definición de 4K. Cuenta con una resolución 4 veces superior a la de la Full HD 1080p y con pantalla de 55 pulgadas (139 cm) con bordes ultrafinos para ofrecer imágenes perfectas con un nivel de detalle inigualado tanto de cerca como de lejos.  El televisor 55-UB850V incluye el motor de tratamiento de imagenTriple XD Engine que optimiza el contraste, la nitidez y los colores. La tecnología LED Plus, que asocia una retroiluminación de tipo Edge LED con la gestión Local Dimming, garantiza por su parte una imagen particularmente luminosa con un tratamiento por zonas para una fineza incomparable. Gracias a una frecuencia de barrido mejorada UCI 1000Hz obtendrás una imagen de 3840 x 2160 píxeles con un realismo increíble.",
				1149.00);

		Product p2 = new Product(
				"SAMSUNG UE40H6400 - Televisor LED 3D Smart TV",
				"Televisores",
				"8.png",
				"El interactivo e intuitivo televisor Samsung UE40H6400 te permite navegar rápida y fácilmente en su interfaz Smart TV. Este televisor LED Full HD viene con el nuevo mando a distancia Smart Touch. Utilizando el giroscopio o interacción de voz, podrás pedir y obtener -con un simple gesto o con la voz sobre la programación- consejos sobre la programación basados en tus preferencias de visionado. De este modo, tu televisor UE40-H6400 te propondrá una selección personalizada de contenidos para contentar a toda la familia.",
				477.78);

		Cart cart = new Cart();
		Cart cart1 = new Cart();

		ProductWithCuantity almostCart1 = new ProductWithCuantity(p1, 2);
		ProductWithCuantity almostCart2 = new ProductWithCuantity(p2, 5);
		cart.getProducts().add(almostCart1);
		cart.getProducts().add(almostCart2);
		cart1.getProducts().add(almostCart1);
		cart1.getProducts().add(almostCart2);

		orders.save(new Order(cart));
		orders.save(new Order(cart1));
	}

}