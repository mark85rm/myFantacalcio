package it.myfantacalcio.controller.anagrafica;

import it.myfantacalcio.dataobject.Utente;
import it.myfantacalcio.service.LegaService;
import it.myfantacalcio.service.SquadraService;
import it.myfantacalcio.service.UtenteService;

import java.util.Map;

import javax.validation.Valid;

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
public class UtenteController {

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private LegaService legaService;

	@Autowired
	private SquadraService squadraService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/admin/userManager")
	public ModelAndView listUtente(Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("admin/userManager");
		map.put("utenteList", utenteService.listUtente());

		return mav;
	}

	@RequestMapping("/user/register")
	public ModelAndView registerUser(Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("registerUser");

		map.put("utente", new Utente());

		return mav;
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUtente(@ModelAttribute("utente") Utente utente,
			BindingResult result) {

		utente.setEnabled(false);
		utenteService.addUtente(utente);

		return "redirect:/login";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/adminControl/deleteUtente/{utenteId}")
	public String deleteContact(@PathVariable("utenteId") Long utenteId) {

		utenteService.removeUtente(utenteId);

		return "redirect:/admin/userManager";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/adminControl/attivaUtente/{utenteId}")
	public String attivaUtente(@PathVariable("utenteId") Long utenteId) {


		Utente utente = utenteService.getUtente(utenteId);
		if (utente != null) {
			utente.setEnabled(true);
			utenteService.updateUtente(utente);
		}

		return "redirect:/admin/userManager";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/adminControl/disattivaUtente/{utenteId}")
	public String disattivaUtente(@PathVariable("utenteId") Long utenteId) {

		Utente utente = utenteService.getUtente(utenteId);
		if (utente != null) {
			utente.setEnabled(false);
			utenteService.updateUtente(utente);
		}

		return "redirect:/admin/userManager";
	}

}
