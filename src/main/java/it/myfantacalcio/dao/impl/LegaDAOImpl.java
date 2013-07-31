package it.myfantacalcio.dao.impl;

import it.myfantacalcio.dao.LegaDAO;
import it.myfantacalcio.dataobject.Lega;
import it.myfantacalcio.dataobject.Utente;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LegaDAOImpl implements LegaDAO {
	
	@Autowired
    private SessionFactory sessionFactory;

	public void addLega(Lega lega) {
		sessionFactory.getCurrentSession().save(lega);
	}

	public List<Lega> listLeghe() {
		return sessionFactory.getCurrentSession().createQuery("from Lega").list();
	}

	public void deleteLega(Long id) {
		Lega lega = getLega(id);
        if (null != lega) {
            sessionFactory.getCurrentSession().delete(lega);
        }
	}

	public void updateLega(Lega lega) {
		sessionFactory.getCurrentSession().saveOrUpdate(lega);
	}

	public Lega getLega(Long id) {
		List<Lega> listLega = sessionFactory.getCurrentSession().createQuery("from Lega where id="+ id).list();
		if (listLega != null && listLega.size() > 0){
			return listLega.get(0);
		}
		return null;
	}

}
