package it.myfantacalcio.dao;

import it.myfantacalcio.dataobject.Ruolo;

import java.util.List;

public interface RuoloDAO {
	
	public void addRuolo(Ruolo ruolo);
	
	public List<Ruolo> listRuoli();
	
	public void deleteRuolo(Integer id);
	
	public Ruolo getRuolo(Integer id);
	
	public void updateRuolo(Ruolo ruolo);

}
