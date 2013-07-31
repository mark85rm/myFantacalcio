package it.myfantacalcio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.myfantacalcio.dao.LegaDAO;
import it.myfantacalcio.dao.SquadraDAO;
import it.myfantacalcio.dataobject.Lega;
import it.myfantacalcio.dataobject.Utente;
import it.myfantacalcio.service.LegaService;

@Service
public class LegaServiceImpl implements LegaService {

	@Autowired
	private LegaDAO legaDAO;
	
	@Transactional
	public void addLega(Lega lega) {
		legaDAO.addLega(lega);
	}
	
	@Transactional
	public Lega getLega(Long id){
		return legaDAO.getLega(id);
	}

	@Transactional
	public List<Lega> listLeghe() {
		return legaDAO.listLeghe();
	}

	@Transactional
	public void deleteLega(Long id) {
		legaDAO.deleteLega(id);
	}

	@Transactional
	public void updateLega(Lega lega) {
		legaDAO.updateLega(lega);
	}

	@Transactional
	public void addLega(Utente utente, String nomeLega) {
		
		if (getLega(nomeLega) == null){
			Lega lega = new Lega();
			lega.setNome(nomeLega);
			lega.setUtenteAmministratore(utente);
			legaDAO.updateLega(lega);
		} 
		
	}

	@Transactional
	public Lega getLega(String nome) {
		List<Lega> listLeghe = listLeghe();
		Lega legaEsistente = null;
		for (Lega l : listLeghe){
			if (l.getNome().equalsIgnoreCase(nome)){
				legaEsistente = l;
			}
		}
		
		return legaEsistente;
	}

}
