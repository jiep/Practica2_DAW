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
				"1.png",
				"El Galaxy S5 es una auténtica proeza técnica y es un smartphone Samsung de última generación equipado con las mejores tecnologías de telefonía móvil. Este teléfono portátil ultra conectado te permite disfrutar de la alta velocidad con la 4G y el Wifi-ac MIMO. Funciona con Android KitKat 4.4.2 y con un potente procesador Quad Core 2,5 GHz y dispone de 2 Gb de memoria RAM. Su línea con una fineza increíble pone de realce una magnífica pantalla Full HD de 5,1. Esta pantalla táctil  ultra luminosa con una fluidez alucinante garantiza una calidad de imagen excepcional gracias a la tecnología Super AMOLED. Gracias a ésta las imágenes se subliman y tus ojos disfrutarán a lo grande con nada más y nada menos que de 16 millones de colores.Una cámara de fotos  de 16 megapíxeles en la parte trasera del teléfono capta incluso las escenas más efímeras gracias a su enfoque automático de 0,3 segundos. Cuenta también con diversos modos fotográficos que mejoran tus tomas. La captura de vídeo es de calidad Ultra HD 2160p y no tiene nada que envidiarle a las mejores videocámaras digitales. Incluye también una cámara frontal de 2 megapíxeles para tus videoconferencias y videochats en particular.",
				435));
		products.save(new Product(
				"MOULINEX Masterchef 5000 FP513110 - Robot multifunción",
				"Pequeños electrodomésticos",
				"2.png",
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
				"4.png",
				"Este pack se compone de la depiladora Silk-epil 7 7281 de Braun, que se puede utilizar en la ducha, y de la depiladora de precisión SilkFinish FG1000.La depiladora Silk-epil 7 de Braun proporciona una depilación suave y completa. Está especialmente diseñada para utilizar bajo el agua caliente para atenuar el dolor.  La Silk-épil 7 Wet&Dry extrae los pelos más cortos y finos. La luz SmartLight permite que ningún pelo pase desapercibido. Su sistema de masaje de alta frecuencia estimula la piel y calma eficazmente la sensación de tirantez.Extremadamente precisa, la depiladora SilkFinish FG1000 de Braun dispone de una gran polivalencia de acabado gracias a sus 2 cabezales y 2 peines-guía.La depiladora SilkFinish FG1000 tiene el tamaño de un lápiz, funciona con pilas y permite eliminar y cortar de forma precisa  los pelos de las cejas, el rostro en general, la ingle y cualquier zona sensible. ",
				89.90));
		products.save(new Product(
				"PHILIPS 3000 Series HQ6927/16 - Máquina de afeitar",
				"Pequeños electrodomésticos",
				"5.png",
				"La máquina de afeitar HQ6927/16 de Philips está diseñada para proporcionar un afeitado apurado y preciso.Su sistema \"Flex & Float\" garantiza un afeitado confortable ajustándose automáticamente a los contornos de la cara. máquina de afeitar HQ6927 de Philips es inalámbrica y tiene una autonomía de 35 minutos... ¡Ideal para el afeitado diario!",
				36.91));

		products.save(new Product(
				"LG 42UB820V - Televisión LED Smart TV Ultra HD",
				"Televisores",
				"6.png",
				"La LG 42UB820V tiene un diseño Cinema Screen que cede todo el protagonismo a la Ultra Alta Definición 4K. Cuenta con una resolución 4 veces superior a la del Full HD 1080p y con una pantalla TV de 42 pulgadas (107 cm) con bordes ultrafinos que reproduce unas imágenes perfectas con un nivel de detalle incomparable tanto de cerca como de lejos. La inmersión en el cine nunca había sido tan intensa.Para vivir esta nueva experiencia en las mejores condiciones, el televisor 42-UB820V incorpora un motor de tratamiento de imagen Triple XD Engine que optimiza el contraste, la claridad y los colores. La tecnología LED Plus, que asocia una retroiluminación de tipo Edge LED a la gestión Local Dimming, garantiza una imagen especialmente luminosa con un tratamiento por zonas para una finura incomparable. Si a esto le añadimos una frecuencia de refresco mejorada UCI 900Hz, obtendremos una imagen con una resolución de 3840 x 2160 píxeles con un realismo asombroso. ",
				541.52));
		products.save(new Product(
				"SAMSUNG UE40H6400 - Televisor LED 3D Smart TV",
				"Televisores",
				"7.png",
				"El interactivo e intuitivo televisor Samsung UE40H6400 te permite navegar rápida y fácilmente en su interfaz Smart TV. Este televisor LED Full HD viene con el nuevo mando a distancia Smart Touch. Utilizando el giroscopio o interacción de voz, podrás pedir y obtener -con un simple gesto o con la voz sobre la programación- consejos sobre la programación basados en tus preferencias de visionado. De este modo, tu televisor UE40-H6400 te propondrá una selección personalizada de contenidos para contentar a toda la familia.",
				477.78));
		products.save(new Product(
				"LG 55UB850V - Televisor LED 3D Smart TV Ultra HD",
				"Televisores",
				"17.png",
				"El LG 55UB850V dispone de un diseño Cinema Screen para disfrutar al máximo de la Ultra Alta Definición de 4K. Cuenta con una resolución 4 veces superior a la de la Full HD 1080p y con pantalla de 55 pulgadas (139 cm) con bordes ultrafinos para ofrecer imágenes perfectas con un nivel de detalle inigualado tanto de cerca como de lejos.  El televisor 55-UB850V incluye el motor de tratamiento de imagenTriple XD Engine que optimiza el contraste, la nitidez y los colores. La tecnología LED Plus, que asocia una retroiluminación de tipo Edge LED con la gestión Local Dimming, garantiza por su parte una imagen particularmente luminosa con un tratamiento por zonas para una fineza incomparable. Gracias a una frecuencia de barrido mejorada UCI 1000Hz obtendrás una imagen de 3840 x 2160 píxeles con un realismo increíble.",
				1149.00));
		products.save(new Product(
				"Samsung UE65F8000 LED 65'' Full HD 3D Smart TV",
				"Televisores",
				"8.png",
				"Smart TV Serie 8 es el televisor más avanzado que existe. Con increíbles características, como Smart Interaction, nunca te aburrirás. Smart TV te sumerge en una experiencia de entretenimiento totalmente futurista. Saca un mayor provecho a todas las características con una calidad de imagen superior y unos colores más realistas. Sumérgete en una experiencia audiovisual única. Gracias a un sistema de reconocimiento de voz y a un intuitivo sistema de detección de movimiento, Samsung Smart TV te sumergirá sin esfuerzo en una experiencia de entretenimiento totalmente futurista. Cuando quieras relajarte y no encuentres el mando a distancia, todo lo que necesitas es decir “Hola tele” o saludar con tu mano, para que Smart TV F8000 te permita acceder a una gran variedad de opciones, como cambiar de canal o subir / bajar el volumen.",
				3999));

		products.save(new Product(
				"Nintendo 2DS White - Red",
				"Videoconsolas",
				"9.png",
				"He aquí Nintendo 2DS, un nuevo miembro de la familia de consolas Nintendo 3DS!. Nintendo 2DS es tu puerta de entrada portátil a un mundo de maravillosos juegos y servicios; podrás conectar con amigos y con la comunidad global de Nintendo con las opciones para compartir. Lleva la experiencia de juego portátil a un nivel superior con Nintendo 2DS... Atrévete con las sagas de Nintendo que no encontrarás en ningún otro sitio y vive la experiencia de jugar entre otros a Zelda, Mario y Star Fox. Al ser parte de la gama de consolas Nintendo 3DS, con Nintendo 2DS podrás jugar todos los juegos de Nintendo 3DS en 2D. Con el impresionante catálogo de Nintendo 3DS en constante crecimiento, hay juegos para todos los gustos.",
				89));

		products.save(new Product(
				"PlayStation 4 (500 GB)",
				"Videoconsolas",
				"10.png",
				"El sistema PlayStation4 es el centro neurálgico donde podrás disfrutar de dinámicos videojuegos conectados a la red, gráficos potentes y velocidad, personalización inteligente, capacidades sociales integradas e innovadoras funciones de segunda pantalla. Combinando contenidos sin parangón, experiencias de juego envolventes, tus aplicaciones de entretenimiento digitales preferidas y los mejores títulos exclusivos para PlayStation, PS4 es el sistema diseñado para los amantes de los videojuegos. El sistema PS4 se centra en el jugador, garantizando la máxima calidad y las experiencias más atmosféricas en esta plataforma. PS4 permite a los mejores desarrolladores del planeta dar rienda suelta a su creatividad y poner a prueba los límites de los videojuegos con un sistema diseñado específicamente para satisfacer sus necesidades. ",
				379));

		products.save(new Product(
				"Xbox One 500GB + Kinect",
				"Videoconsolas",
				"11.png",
				"Te presentamos Xbox One, donde los mejores juegos, modos multijugador y tus películas, música, deportes y televisión en vivo favoritas confluyen en un único lugar. Los juegos de Xbox One tienen un aspecto y dan una sensación de realismo increíble, con un juego con escenas a la altura de Hollywood. Mira la televisión o charla por Skype a la vez que juegas o continúa jugando mientras un matchmaking más inteligente funciona en un segundo plano.* Con Xbox One, puedes acoplar dos cosas a la vez en tu televisión, y cambiar de una a otra al instante. Con el poder de la nube y creada para la era digital, Xbox One está diseñada para seguir mejorando con el tiempo.",
				474.99));

		products.save(new Product(
				"Nintendo Wii U Premium Pack 32GB + Super Smash Bros",
				"Videoconsolas",
				"12.png",
				"Un pack limitado que incluye la consola básica Wii U blanca de 8 GB junto con el juego Super Smash Bros. Wii U es una nueva consola de sobremesa de Nintendo que redefine la relación entre tu televisor y tú, y cómo te conectas con tus amigos y familiares. Es una potente máquina de alta definición con un sorprendente nuevo mando que redefine los videojuegos en compañía: el Wii U GamePad. Super Smash Bros.: grandes nombres de las franquicias más populares de Nintendo y personajes invitados se reúnen en un juego de lucha en alta definición rebosante de acción espectacular. Con modos únicos, multijugador online, la posibilidad de personalizar a tu jugador y el mayor elenco de personajes jugables hasta la fecha, Super Smash Bros. para Wii U es un auténtico duelo de titanes.",
				284.99));

		products.save(new Product(
				"Samsung Galaxy Tab 4 10.1 16 GB 4G color blanco",
				"Informatica",
				"13.png",
				"El nuevo Samsung Galaxy Tab 4 (10.1'') te sorprenderá en cuanto lo veas por su diseño sofisticado y extraordinariamente práctico. La trasera con aspecto de cuero tiene un toque clásico y elegante, un detalle que resalta aún más la línea Premium de este tablet. Su pantalla WXGA (1.280 x 800) de 10.1 pulgadas y formato 16:10 te permite disfrutar de una imagen totalmente nítida. Realiza multitareas reales gracias a la función “Multi Window”, con la que podrás ver una película, comprobar tu correo, comprar en una tienda online y hablar con tus amigos al mismo tiempo. Además, gracias a su procesador Quad Core de 1,2 GHz trabajarás de una forma rápida y fluida. *  Also enjoy a free, one-year digital subscription to Bloomberg Businessweek+ optimized for the 10.1'' screen.",
				349));

		products.save(new Product(
				"Pendrive Sandisk USB Cruzer Glide 128 GB",
				"Informatica",
				"14.png",
				"La memoria flash USB Cruzer Glide™ de 128 GB* está diseñada para ofrecer niveles considerablemente altos de fiabilidad y seguridad. Te permite llevar numerosas hojas de cálculo, presentaciones y otros archivos de trabajo, así como divertirte con grandes cantidades de música, fotografías, vídeos caseros o películas, listos para que accedas a ellos cuando lo desees. Tus archivos privados también estarán seguros gracias a la protección con contraseña y el cifrado ofrecidos por el software SecureAccess™ de SanDisk.  SanDisk ofrece gran variedad de niveles de rendimiento en sus memorias flash USB, que se han diseñado para cubrir las distintas necesidades de los clientes. Si la memoria flash USB Cruzer Glide no te ofrece la solución adecuada a tus necesidades, a continuación te mostramos varias alternativas que puedes examinar.",
				57.70));

		products.save(new Product(
				"Asus F555LD-XX909H 15,6 negro y plata",
				"Informatica",
				"15.png",
				"Asus siempre es sinónimo de calidad, y el Portátil Asus F555LD-XX117H es una nueva muestra de ello. Esta máquina tiene un potente procesador Intel Core i7-4510U y RAM de 4GB. Y por si fuera poco, también cuenta con la gráfica NVIDIA GeForce GT 820M dedicada de 2GB con la que podrás disfrutar de una visualización excelente en tus vídeos, imágenes o de tus juegos, sin necesidad de sufrir demasiado por si se cuelga nada. Podrás sacarle el máximo rendimiento a la capacidad de almacenamiento de 1TB, así como a los 16GB de almacenamiento gratuito durante un año en WebStorage, y si no tienes suficiente conecta tus discos duros con los puertos USB 3.0 y 2.0. El entorno virtual Windows 8.1 es el espacio ideal para disfrutar al máximo de la pantalla HD de 15.6 pulgadas, y si quieres mejor tu experiencia visual, siempre podrás conectar tu portátil a un televisor o un monitor de mayor calidad con las salidas de vídeo HDMI y VGA.",
				649));

		products.save(new Product(
				"Apple MacBook Pro 15 pulgadas, i7-4600M, 16 GB RAM, 256 GB flash, Iris Pro Graphics",
				"Informatica",
				"16.png",
				"Apple ha vuelto a superarse dentro del mundo de los ordenadores portátiles. Y lo hace con su nueva gama de MacBook Pro con pantalla Retina, una auténtica revolución, cuidada hasta el más mínimo detalle. ¿Te atreves a descubrirlo?. Alucinarás con su espectacular pantalla Retina, de 15 pulgadas. Mediante sus más de 5 millones de píxeles, verás las imágenes con un realismo jamás visto, al tiempo que cualquier texto lo leerás como si de un papel se tratase. Una verdadera delicia para tus ojos. Asimismo, el nuevo MacBook Pro Retina esconde en su interior los componentes más avanzados en lo que a procesador, almacenamiento, memoria y gráficos se refiere: procesador de cuatro núcleos i7 a 2,2 GHz, 16 GB de memoria RAM DDR3L integrada a 1600 MHz, 256 GB de almacenamiento flash y gráficos Iris Pro Graphics de Intel son sólo algunas de sus increíbles prestaciones.",
				2187));

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
