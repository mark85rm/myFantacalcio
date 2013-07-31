package it.myfantacalcio.dao;

import it.myfantacalcio.dataobject.Utente;

import java.util.List;

public interface UtenteDAO {
	
	public void addUtente(Utente utente);
	
	public List<Utente> listUtente();
	
	public void removeUtente(Long id);
	
	public void updateUtente(Utente utente);
	
	public Utente getUtente(Long id);
	
	public Utente getUtente(String username);

}
