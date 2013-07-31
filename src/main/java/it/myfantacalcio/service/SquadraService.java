package it.myfantacalcio.service;

import it.myfantacalcio.dataobject.Squadra;

import java.util.List;

public interface SquadraService {
	
	public void addSquadra(Squadra squadra);
	
	public List<Squadra> listSquadre();
	
	public void deleteSquadra(Long codice);
	
	public void updateSquadra(Squadra squadra);
	
	public void aggiungiGiocatore(Squadra squadra, Long idGiocatore);
	
	public void eliminaGiocatore(Squadra squadra, Long idGiocatore);
	
	public Squadra getSquadra(Long codice);

}
