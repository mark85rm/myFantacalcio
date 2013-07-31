package it.myfantacalcio.service;

import it.myfantacalcio.dataobject.Lega;
import it.myfantacalcio.dataobject.Utente;

import java.util.List;

public interface LegaService {

	public void addLega(Lega lega);
	
	public List<Lega> listLeghe();
	
	public void deleteLega(Long id);
	
	public void updateLega(Lega lega);
	
	public Lega getLega(Long id);
	
	public Lega getLega(String nome);
	
	public void addLega(Utente utente, String nomeLega);
}
