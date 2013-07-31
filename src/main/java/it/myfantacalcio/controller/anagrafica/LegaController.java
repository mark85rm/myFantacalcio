package it.myfantacalcio.controller.anagrafica;

import it.myfantacalcio.dataobject.Lega;
import it.myfantacalcio.dataobject.Utente;
import it.myfantacalcio.service.LegaService;
import it.myfantacalcio.service.SquadraService;
import it.myfantacalcio.service.UtenteService;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LegaController {

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private LegaService legaService;

	@Autowired
	private SquadraService squadraService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/admin/legaManager")
	public ModelAndView listLega(Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("admin/legaManager");
		map.put("legaList", legaService.listLeghe());

		return mav;
	}

	@RequestMapping("/admin/creaLega")
	public ModelAndView creaLega(Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("admin/creaLega");

		map.put("lega", new Lega());
		Utente u = utenteService.getUtente("yellow");
		System.out.println("Utente: " + u);

		return mav;
	}

	@RequestMapping(value = "/admin/addLega", method = RequestMethod.POST)
	public String addUtente(@ModelAttribute("lega") Lega lega,
			BindingResult result, Principal principal) {

		if (principal != null) {
			Utente amministratoreLega = utenteService.getUtente(principal
					.getName());
			lega.setUtenteAmministratore(amministratoreLega);
		}
		legaService.addLega(lega);

		return "redirect:/home";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/admin/disattivaLega/{legaId}")
	public String disattivaLega(@PathVariable("legaId") Long legaId) {
		Lega lega = legaService.getLega(legaId);
		if (lega != null) {
			lega.setEnabled(false);
			legaService.updateLega(lega);
		}

		return "redirect:/admin/legaManager";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/admin/attivaLega/{legaId}")
	public String attivaLega(@PathVariable("legaId") Long legaId) {
		Lega lega = legaService.getLega(legaId);
		if (lega != null) {
			lega.setEnabled(true);
			legaService.updateLega(lega);
		}

		return "redirect:/admin/legaManager";
	}

}
