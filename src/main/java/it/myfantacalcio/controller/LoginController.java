package it.myfantacalcio.controller;

import it.myfantacalcio.common.MyException;
import it.myfantacalcio.dataobject.Squadra;
import it.myfantacalcio.dataobject.Utente;
import it.myfantacalcio.service.MailService;
import it.myfantacalcio.service.SquadraService;
import it.myfantacalcio.service.UtenteService;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("command")
public class LoginController {

	@Autowired
	private MailService mailService;

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private SquadraService squadraService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(ModelMap model, Principal principal,
			HttpSession session) {
		ModelAndView mav = new ModelAndView("home");
		try {
			
			if (principal != null) {

				Utente user = utenteService.getUtente(principal.getName());
				session.setAttribute("utente", user);
		
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage(), this.getClass().getName());
		}

		model.addAttribute("message", "Spring Security Custom Form example");
		return mav;
	}

	@RequestMapping(value = "/inviamail", method = RequestMethod.GET)
	public String inviaMail() {
		try {
			mailService.sendMail("prova@gmail.com", "marcell.ricci@gmail.com",
					"Prova di invio",
					"Questo messaggio è stato inviato da Spring");

		} catch (Exception e) {
			throw new MyException(e.getMessage(), this.getClass().getName());
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "redirect:/home";
	}

	@RequestMapping(value = "/loginfailed")
	public ModelAndView loginerror(ModelMap model) {
		ModelAndView mav = new ModelAndView("login", "command", new Utente());

		model.addAttribute("error", "true");
		return mav;
	}

	@RequestMapping(value = "/accessonegato")
	public ModelAndView accessonegato(ModelMap model) {
		ModelAndView mav = new ModelAndView("login", "command", new Utente());

		model.addAttribute("error", "true");
		model.addAttribute("accessonegato", "true");
		return mav;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login", "command", new Utente());

		return mav;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView("login", "command", new Utente());

		return mav;
	}

}
