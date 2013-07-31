package it.myfantacalcio.service.impl;

import it.myfantacalcio.dao.GiocatoreDAO;
import it.myfantacalcio.dao.SquadraDAO;
import it.myfantacalcio.dataobject.Giocatore;
import it.myfantacalcio.dataobject.Squadra;
import it.myfantacalcio.service.SquadraService;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SquadraServiceImpl implements SquadraService {

	@Autowired
	private SquadraDAO squadraDAO;

	@Autowired
	private GiocatoreDAO giocatoreDAO;

	@Transactional
	public void addSquadra(Squadra squadra) {
		squadraDAO.addSquadra(squadra);

	}

	@Transactional
	public List<Squadra> listSquadre() {
		return squadraDAO.listSquadre();
	}

	@Transactional
	public void deleteSquadra(Long codice) {
		squadraDAO.deleteSquadra(codice);
	}

	@Transactional
	public void updateSquadra(Squadra squadra) {
		squadraDAO.updateSquadra(squadra);

	}

	@Transactional
	public Squadra getSquadra(Long codice) {
		Squadra s = squadraDAO.getSquadra(codice);
//		Hibernate.initialize(s.getGiocatori());
		return s;
	}

	@Transactional
	public void aggiungiGiocatore(Squadra squadra, Long idGiocatore) {
		Giocatore g = giocatoreDAO.getGiocatore(idGiocatore);
		Set<Giocatore> giocatori = squadra.getGiocatori();
		if (g!= null && !giocatori.contains(g)){
			System.out.println("Entrato aggiungi");
			squadra.getGiocatori().add(g);
			squadraDAO.mergeSquadra(squadra);
		}
	}
	
	@Transactional
	public void eliminaGiocatore(Squadra squadra, Long idGiocatore) {
		Giocatore g = giocatoreDAO.getGiocatore(idGiocatore);
		Set<Giocatore> giocatori = squadra.getGiocatori();
		if (g!= null && giocatori.contains(g)){
			System.out.println("Entrato elimina");
			squadra.getGiocatori().remove(g);
			squadraDAO.mergeSquadra(squadra);
		}
	}

}
