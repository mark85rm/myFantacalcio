package it.myfantacalcio.common;

import it.myfantacalcio.dataobject.Giocatore;
import it.myfantacalcio.dataobject.RuoloGiocatore;
import it.myfantacalcio.service.RuoloService;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;

public class ParseUtils {
	
	@Autowired
	RuoloService ruoloService;

	public static List<Giocatore> getGiocatori(String path, Integer giornata) {
		try {
			URL website = new URL(
					"http://www.pianetafantacalcio.it/Giocatori_QuotazioniExcel.asp?giornata="
							+ giornata
							+ "&Nome=&Squadre=&Ruolo=&Quota=&Quota1=");

			String file = path + "/QuotazioniExcel.html";

			File fileGiocatori = new File(file);

			org.apache.commons.io.FileUtils.copyURLToFile(website,
					fileGiocatori);

			List<Giocatore> giocatori = parseGiocatori(fileGiocatori);

			return giocatori;

		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage(), ParseUtils.class.getName());
		}

	}

	public static void main(String[] args) {
		File fileGiocatori = new File(
				"C:/Users/MAricci/Desktop/QuotazioniExcel.html");
		try {
			List<Giocatore> giocatori = parseGiocatori(fileGiocatori);
			System.out.println("Size giocatori: " + giocatori.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static RuoloGiocatore getRuoloFromString(String s) {
		s = s.toUpperCase();
		RuoloGiocatore r = new RuoloGiocatore();
		
		if (s.startsWith("P")) {
			r.setId(1);
			r.setNome("Portiere");
		} else if (s.startsWith("D")) {
			r.setId(2);
			r.setNome("Difensore");
		} else if (s.startsWith("C")) {
			r.setId(3);
			r.setNome("Centrocampista");
		} else if (s.startsWith("A")) {
			r.setId(4);
			r.setNome("Attaccante");
		}
		return r;
	}

	public static List<Giocatore> parseGiocatori(File fileIn) throws Exception {
		List<Giocatore> giocatori = new ArrayList<Giocatore>();

		Document doc = Jsoup.parse(fileIn, "UTF-8");

		Element table = doc.select("table").first();

		Iterator<Element> elementi = table.select("tr").iterator();
		elementi.next();
		elementi.next();
		elementi.next();

		while (elementi.hasNext()) {
			Giocatore giocatore = new Giocatore();

			Iterator<Element> colonne = elementi.next().select("td").iterator();

			Element idGiocatore = colonne.next();
			// System.out.println("Colonna: "+ idGiocatore.text());
			String id = idGiocatore.text();
			giocatore.setId(new Long(id));

			Element giocatoreEl = colonne.next();
			// System.out.println("Colonna: "+ giocatoreEl.text());
			giocatore.setNome(giocatoreEl.text().replace("'", ""));

			Element ruoloEl = colonne.next();
			// System.out.println("Colonna: "+ ruoloEl.text());
			RuoloGiocatore r = getRuoloFromString(ruoloEl.text());
			giocatore.setRuoloGiocatore(r);

			Element squadraEl = colonne.next();
			giocatore.setSquadraCalcio(squadraEl.text());

			giocatori.add(giocatore);

		}

		return giocatori;

	}

}
