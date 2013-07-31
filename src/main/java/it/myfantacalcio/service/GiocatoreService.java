package it.myfantacalcio.service;

import it.myfantacalcio.dataobject.Giocatore;

import java.util.List;

public interface GiocatoreService {
	
	public void addGiocatore(Giocatore giocatore);
	
	public List<Giocatore> listGiocatore();
	
	public void deleteGiocatore(Long id);
	
	public Giocatore getGiocatore(Long id);
	
	public void assegnaSquadra(Giocatore giocatore, Long idSquadra);
	
	public void aggiornaListaGiocatori(List<Giocatore> giocatori);

}
