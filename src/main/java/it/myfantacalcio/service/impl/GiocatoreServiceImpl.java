package it.myfantacalcio.service.impl;

import it.myfantacalcio.dao.GiocatoreDAO;
import it.myfantacalcio.dao.SquadraDAO;
import it.myfantacalcio.dataobject.Giocatore;
import it.myfantacalcio.dataobject.Squadra;
import it.myfantacalcio.service.GiocatoreService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GiocatoreServiceImpl implements GiocatoreService {
	
	@Autowired
	private GiocatoreDAO giocatoreDAO;
	
	@Autowired
	private SquadraDAO squadraDAO;

	@Transactional
	public void addGiocatore(Giocatore giocatore) {
		giocatoreDAO.addGiocatore(giocatore);

	}

	@Transactional
	public List<Giocatore> listGiocatore() {
		return giocatoreDAO.listGiocatore();
	}

	@Transactional
	public void deleteGiocatore(Long id) {
		giocatoreDAO.deleteGiocatore(id);
	}

	@Transactional
	public Giocatore getGiocatore(Long id) {
		return giocatoreDAO.getGiocatore(id);
	}

	@Transactional
	public void assegnaSquadra(Giocatore giocatore, Long idSquadra) {
		Squadra squadra = squadraDAO.getSquadra(idSquadra);
		giocatore.getSquadre().add(squadra);
		giocatoreDAO.updateGiocatore(giocatore);
	}

	@Transactional
	public void aggiornaListaGiocatori(List<Giocatore> giocatori) {
		for (Giocatore g : giocatori){
			Giocatore gi = this.getGiocatore(g.getId());
			if (gi != null){
				giocatoreDAO.mergeGiocatore(g);
			} else  {
				giocatoreDAO.addGiocatore(g);
			}
		}
	}

}
