package it.myfantacalcio.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.myfantacalcio.dao.RuoloDAO;
import it.myfantacalcio.dataobject.Giocatore;
import it.myfantacalcio.dataobject.Lega;
import it.myfantacalcio.dataobject.Ruolo;

@Repository
public class RuoloDAOImpl implements RuoloDAO {
	
	@Autowired
    private SessionFactory sessionFactory;

	public void addRuolo(Ruolo ruolo) {
		sessionFactory.getCurrentSession().save(ruolo);
	}

	public List<Ruolo> listRuoli() {
		return sessionFactory.getCurrentSession().createQuery("from Ruolo").list();
	}

	public void deleteRuolo(Integer id) {
		Ruolo ruolo = getRuolo(id);
        if (null != ruolo) {
            sessionFactory.getCurrentSession().delete(ruolo);
        }

	}

	public Ruolo getRuolo(Integer id) {
		List<Ruolo> listRuoli = sessionFactory.getCurrentSession().createQuery("from Ruolo where id="+ id).list();
		if (listRuoli != null && listRuoli.size() > 0){
			return listRuoli.get(0);
		}
		return null;
	}

	public void updateRuolo(Ruolo ruolo) {
		sessionFactory.getCurrentSession().saveOrUpdate(ruolo);
	}

}
