package it.myfantacalcio.dao;

import it.myfantacalcio.dataobject.Squadra;

import java.util.List;

public interface SquadraDAO {
	
	public void addSquadra(Squadra squadra);
	
	public List<Squadra> listSquadre();
	
	public void deleteSquadra(Long codice);
	
	public Squadra getSquadra(Long codice);
	
	public void updateSquadra(Squadra squadra);
	
	public void mergeSquadra(Squadra squadra);

}
