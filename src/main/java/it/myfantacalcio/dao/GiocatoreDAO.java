package it.myfantacalcio.dao;

import it.myfantacalcio.dataobject.Giocatore;

import java.util.List;

public interface GiocatoreDAO {

	public void addGiocatore(Giocatore giocatore);
	
	public List<Giocatore> listGiocatore();
	
	public void deleteGiocatore(Long id);
	
	public void updateGiocatore(Giocatore giocatore);
	
	public void mergeGiocatore(Giocatore giocatore);
	
	public Giocatore getGiocatore(Long id);
	
}
