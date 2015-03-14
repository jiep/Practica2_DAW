package tiendapox;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TablonController {

	private List<Anuncio> anuncios = new CopyOnWriteArrayList<>();

	@RequestMapping("/")
	public ModelAndView tablon() {

		return new ModelAndView("tablon").addObject("anuncios", anuncios);
	}

	@RequestMapping("/insertar")
	public ModelAndView insertar(Anuncio anuncio) {

		anuncios.add(anuncio);

		return new ModelAndView("insertar");
	}

	@RequestMapping("/mostrar")
	public ModelAndView mostrar(@RequestParam int numAnuncio) {

		Anuncio anuncio = anuncios.get(numAnuncio-1);

		return new ModelAndView("mostrar").addObject("anuncio", anuncio);
	}
}