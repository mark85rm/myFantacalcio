package it.myfantacalcio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.myfantacalcio.dao.LegaDAO;
import it.myfantacalcio.dao.RuoloDAO;
import it.myfantacalcio.dataobject.Ruolo;
import it.myfantacalcio.service.RuoloService;

@Service
public class RuoloServiceImpl implements RuoloService {
	
	@Autowired
	private RuoloDAO ruoloDAO;

	public void addRuolo(Ruolo ruolo) {
		ruoloDAO.addRuolo(ruolo);
	}

	public List<Ruolo> listRuoli() {
		return ruoloDAO.listRuoli();
	}

	public void deleteRuolo(Integer id) {
		ruoloDAO.deleteRuolo(id);
	}

	public void updateRuolo(Ruolo ruolo) {
		ruoloDAO.updateRuolo(ruolo);
	}

	public Ruolo getRuolo(Integer id) {
		return ruoloDAO.getRuolo(id);
	}

}
