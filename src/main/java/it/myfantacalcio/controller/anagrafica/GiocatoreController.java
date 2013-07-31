package it.myfantacalcio.controller.anagrafica;

import it.myfantacalcio.common.MyException;
import it.myfantacalcio.common.ParseUtils;
import it.myfantacalcio.dataobject.Giocatore;
import it.myfantacalcio.service.GiocatoreService;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GiocatoreController {

	@Autowired
	private GiocatoreService giocatoreService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/admin/aggiornaListaGiocatore")
	public String addUtente(HttpServletRequest request) {

		String path = request.getSession().getServletContext().getContextPath();
		try {
			List<Giocatore> giocatori = ParseUtils.getGiocatori(path, 1);
			giocatoreService.aggiornaListaGiocatori(giocatori);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage(), this.getClass().getName());
		}

		return "redirect:/home";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/admin/giocatoriManager")
	public ModelAndView listLega(Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("admin/giocatoriManager");
		map.put("giocatori", giocatoreService.listGiocatore());
		System.out.println("Size giocatori:" + giocatoreService.listGiocatore().size());

		return mav;
	}

}
