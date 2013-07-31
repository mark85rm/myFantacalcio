package it.myfantacalcio.service.impl;

import it.myfantacalcio.dao.UtenteDAO;
import it.myfantacalcio.dataobject.Utente;
import it.myfantacalcio.service.UtenteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteDAO utenteDAO;
	
	@Transactional
	public void addUtente(Utente utente) {
		utenteDAO.addUtente(utente);
	}

	@Transactional
	public List<Utente> listUtente() {
		return utenteDAO.listUtente();
	}

	@Transactional
	public void removeUtente(Long id) {
		utenteDAO.removeUtente(id);
	}

	@Transactional
	public void updateUtente(Utente utente) {
		utenteDAO.updateUtente(utente);
		
	}

	@Transactional
	public Utente getUtente(Long id) {
		return utenteDAO.getUtente(id);
	}

	@Transactional
	public Utente getUtente(String username) {
		return utenteDAO.getUtente(username);
	}

}
