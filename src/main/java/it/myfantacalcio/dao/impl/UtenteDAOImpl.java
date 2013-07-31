package it.myfantacalcio.dao.impl;

import it.myfantacalcio.dao.UtenteDAO;
import it.myfantacalcio.dataobject.Utente;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UtenteDAOImpl implements UtenteDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public void addUtente(Utente utente) {
		String password = utente.getPassword();
		String encodedPassword = passwordEncoder.encodePassword(password, null);
		utente.setPassword(encodedPassword);
		sessionFactory.getCurrentSession().save(utente);
	}

	public List<Utente> listUtente() {
		 return sessionFactory.getCurrentSession().createQuery("from Utente").list();
	}

	public void removeUtente(Long id) {
		Utente utente = getUtente(id);
        if (null != utente) {
            sessionFactory.getCurrentSession().delete(utente);
        }
	}

	public void updateUtente(Utente utente) {
		sessionFactory.getCurrentSession().saveOrUpdate(utente);
	}

	public Utente getUtente(Long id) {
	List<Utente> listUtenti = sessionFactory.getCurrentSession().createQuery("from Utente where id="+ id).list();
		
		if (listUtenti != null && listUtenti.size() > 0){
			return listUtenti.get(0);
		}
		
		return null;
	}

	@Override
	public Utente getUtente(String username) {
	
		List<Utente> listUtenti = sessionFactory.getCurrentSession().createQuery("from Utente where username='"+ username+"'").list();
		
		if (listUtenti != null && listUtenti.size() > 0){
			return listUtenti.get(0);
		}
		
		return null;
		
	}

}
