package it.myfantacalcio.controller;

import it.myfantacalcio.dataobject.Utente;
import it.myfantacalcio.service.GiocatoreService;
import it.myfantacalcio.service.SquadraService;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("command")
public class RosaController {

	@Autowired
	private GiocatoreService giocatoreService;


	@Autowired
	private SquadraService squadraService;

	@RequestMapping("/user/rosaManager")
	public ModelAndView listRosa(Map<String, Object> map, HttpSession session) {
		ModelAndView mav = new ModelAndView("user/rosaManager");

		map.put("giocatoriList", giocatoreService.listGiocatore());
		
		return mav;
	}
	
	

//	@RequestMapping(value = "/user/addGiocatoreRosa/{idgiocatore}")
	@RequestMapping(value = "/user/addGiocatoreRosa")
	public String aggiungiGiocatoreRosa(@RequestParam("giocatoreid") Long giocatoreId, HttpSession session) {
//	public String aggiungiGiocatoreRosa(@PathVariable("idgiocatore") Long giocatoreId, HttpSession session) {

		Utente user = (Utente) session.getAttribute("utente");
		if (user != null){
			squadraService.aggiungiGiocatore(user.getSquadra(), giocatoreId);
		}

		return "redirect:/user/rosaManager";
	}
	
	@RequestMapping(value = "/user/eliminaGiocatoreRosa/{idgiocatore}")
	public String eliminaGiocatoreRosa(@PathVariable("idgiocatore") Long giocatoreId, HttpSession session) {

		Utente user = (Utente) session.getAttribute("utente");
		if (user != null){
			squadraService.eliminaGiocatore(user.getSquadra(), giocatoreId);
		}

		return "redirect:/user/rosaManager";
	}

}
