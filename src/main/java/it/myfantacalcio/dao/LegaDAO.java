package it.myfantacalcio.dao;

import it.myfantacalcio.dataobject.Lega;

import java.util.List;

public interface LegaDAO {

	public void addLega(Lega lega);
	
	public List<Lega> listLeghe();
	
	public void deleteLega(Long id);
	
	public void updateLega(Lega lega);
	
	public Lega getLega(Long id);
}
