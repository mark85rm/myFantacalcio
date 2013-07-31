package it.myfantacalcio.dao.impl;

import it.myfantacalcio.dao.GiocatoreDAO;
import it.myfantacalcio.dataobject.Giocatore;
import it.myfantacalcio.dataobject.Lega;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GiocatoreDAOImpl implements GiocatoreDAO {
	
	@Autowired
    private SessionFactory sessionFactory;

	public void addGiocatore(Giocatore giocatore) {
		 sessionFactory.getCurrentSession().save(giocatore);
	}

	public List<Giocatore> listGiocatore() {
		return sessionFactory.getCurrentSession().createQuery("from Giocatore").list();
	}

	public void deleteGiocatore(Long id) {
		Giocatore giocatore = getGiocatore(id);
        if (null != giocatore) {
            sessionFactory.getCurrentSession().delete(giocatore);
        }

	}

	public void updateGiocatore(Giocatore giocatore) {
		 sessionFactory.getCurrentSession().saveOrUpdate(giocatore);
	}
	
	public void mergeGiocatore(Giocatore giocatore) {
		 sessionFactory.getCurrentSession().merge(giocatore);
	}
	
	public Giocatore getGiocatore(Long id) {
		List<Giocatore> listGiocatore = sessionFactory.getCurrentSession().createQuery("from Giocatore where id="+ id).list();
		if (listGiocatore != null && listGiocatore.size() > 0){
			return listGiocatore.get(0);
		}
		return null;
	}

}
