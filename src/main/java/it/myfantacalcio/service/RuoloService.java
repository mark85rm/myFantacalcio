package it.myfantacalcio.service;

import it.myfantacalcio.dataobject.Ruolo;

import java.util.List;

public interface RuoloService {
	
	public void addRuolo(Ruolo ruolo);
	
	public List<Ruolo> listRuoli();
	
	public void deleteRuolo(Integer id);
	
	public void updateRuolo(Ruolo ruolo);
	
	public Ruolo getRuolo(Integer id);

}
