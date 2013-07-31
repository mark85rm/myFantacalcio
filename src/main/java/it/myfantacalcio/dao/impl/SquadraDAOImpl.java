package it.myfantacalcio.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.myfantacalcio.dao.SquadraDAO;
import it.myfantacalcio.dataobject.Ruolo;
import it.myfantacalcio.dataobject.Squadra;

@Repository
public class SquadraDAOImpl implements SquadraDAO{
	

	@Autowired
    private SessionFactory sessionFactory;

	public void addSquadra(Squadra squadra) {
		sessionFactory.getCurrentSession().save(squadra);
	}

	public List<Squadra> listSquadre() {
		return sessionFactory.getCurrentSession().createQuery("from Squadra").list();
	}

	public void deleteSquadra(Long codice) {
		Squadra squadra = getSquadra(codice);
        if (null != squadra) {
            sessionFactory.getCurrentSession().delete(squadra);
        }
	}

	public Squadra getSquadra(Long codice) {
		List<Squadra> listSquadre = sessionFactory.getCurrentSession().createQuery("from Squadra where codice="+ codice).list();
		if (listSquadre != null && listSquadre.size() > 0){
			return listSquadre.get(0);
		}
		return null;
	}

	public void updateSquadra(Squadra squadra) {
		sessionFactory.getCurrentSession().saveOrUpdate(squadra);
	}
	
	public void mergeSquadra(Squadra squadra) {
		sessionFactory.getCurrentSession().merge(squadra);
	}
	
}
