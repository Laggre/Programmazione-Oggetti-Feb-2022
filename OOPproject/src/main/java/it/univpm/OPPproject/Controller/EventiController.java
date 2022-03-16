package it.univpm.OPPproject.Controller;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.OPPproject.Filters.FiltroGenere;
import it.univpm.OPPproject.Filters.FiltroMinMaxMedia;
import it.univpm.OPPproject.Filters.FiltroStato;
import it.univpm.OPPproject.Stats.StatsData;
import it.univpm.OPPproject.Stats.MinMaxMedia;
import it.univpm.OPPproject.api.ChiamataEventi;
import it.univpm.OPPproject.exception.EventiException;
import it.univpm.OPPproject.model.Eventi;
import it.univpm.OPPproject.model.EventiBody;
import it.univpm.OPPproject.scanner.GeneriScanner;
import it.univpm.OPPproject.scanner.StatiScanner;

/**
 * Controller della rotta eventi
 * 
 * @author LorenzoScortichini
 * @author NicolaPieraslisi
 */
@RestController
public class EventiController {

	private  Vector<String> generi;
	private  Vector<String> statiScanner;
	private  Vector<String> generiScanner;
	private static Vector<String> periodo;
	
	/**
	 *  Variabile che descrive la chiave nelle eccezioni
	 */
	private static String key;

	/** 
	 * Variabile che descrive il valore delle chiavi nelle eccezioni
	 */
	private static String value;

	/**
	 * Variabile che descrive il responso ottenuto a partire dal body fornito dall'utente
	 */
	private static JSONObject responso;

	/**
	 * Variabile che immagazzina il vettore stati dell'oggetto EventiBody
	 */
	private static Vector<String> statiPaesi;

	/**
	 * la coppia descrive il numero totale di eventi per ogni stato inserito nel body
	 */
	private static LinkedHashMap<String, Integer> contatoreEventiPerStati;
	private static LinkedHashMap<String, Integer> contatoreEventiPerGeneri;
	private static Vector<String> stati;
	private static Vector<String> paesi;

	/**
	 * Variabile che contiene tutti gli stati dell'Australia con l'aggiunta del codice nazionale
	 */
	private static Vector<String> America;
	private static Vector<String> Canada;

	/**
	 * Variabile che contiene i vettori di eventi 
	 */
	private static Vector<Vector<Eventi>> chiamateEv;
	private static Vector<Eventi> eventiFiltratiPerStati;
	private static LinkedHashMap<String, MinMaxMedia> minMaxAverage;
	private static LinkedHashMap<String, MinMaxMedia> minMaxAverageFilter;
	private static Vector<Eventi> evFiltratiPerStato;

	/**
	 * variabili che descrivono le statistiche mensili minimo, massimo e media 
	 */
	private static MinMaxMedia mMA;
	private static int[] numberArray;	
	private static Vector<Eventi> eventiFiltratiPerGeneri;
	private static Vector<Eventi> evFiltratiPerGenere;
	
	/**
	 * Metodo associato alla rotta post /eventi
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/eventi")
	public JSONObject eventi(@RequestBody EventiBody Event) {

		responso = new JSONObject();
		generi = Event.getGeneri();
		periodo = Event.getPeriodo();
		statiScanner = StatiScanner.getStati();
		generiScanner = GeneriScanner.getGeneri();
		contatoreEventiPerStati = new LinkedHashMap<String, Integer>();
		contatoreEventiPerGeneri = new LinkedHashMap<String, Integer>();
		stati = new Vector<String>();
		paesi = new Vector<String>();
		America = new Vector<String>();
		Canada = new Vector<String>();
		chiamateEv = new Vector<Vector<Eventi>>();
		eventiFiltratiPerStati = new Vector<Eventi>();
		minMaxAverage = new LinkedHashMap<String, MinMaxMedia>();
		minMaxAverageFilter = new LinkedHashMap<String, MinMaxMedia>();
		eventiFiltratiPerGeneri = new Vector<Eventi>();
		
		try {

			controlloStatiEventiBody(Event);
			FillerStati();						
			FillerPaesi();
			FillerUS();
			FillerCA();		
			CallEvents();			
			filtroStati();			
			DateController();			
			StateController();

			if (generi.isEmpty()) {

				controlloGeneriEventiBody();
				return responso;
			}

			filtroGeneri();			
			controlloFiltroGeneri();
			responso.put("numero totale eventi", contatoreEventiPerStati);			
			responso.put("numero eventi per il genere", contatoreEventiPerGeneri);
			
			if (periodo.isEmpty())
				responso.put("statistiche mensili di eventi", minMaxAverage);
			else {
				responso.put("statistiche periodiche di eventi", minMaxAverageFilter);
			}
			responso.put("eventi", eventiFiltratiPerGeneri);

		} catch (EventiException e) {
			responso = e.generaJSON(key, value);
		}
		return responso;
	}

	
	/**
	 * Metodo associato alla rotta get /eventi, che è in grado di generare
	 * filtri e statistiche in base ai parametri forniti dall'utente
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/eventi")
	public JSONObject eventi(@RequestParam(value = "stati") Vector<String> statiGet,
							 @RequestParam(value = "paesi") Vector<String> paesiGet,
							 @RequestParam(value = "generi") Vector<String> generiGet,
							 @RequestParam(value = "periodo") Vector<String> periodoGet) {

		Vector<String> statiPaesiGet = new Vector<String>();
		
		for(int i = 0; i < statiGet.size(); i++) {
			String temp = statiGet.elementAt(i) + ", " + paesiGet.elementAt(i);
			statiPaesiGet.add(temp);
		}
		EventiBody Events = new EventiBody(statiPaesiGet, generiGet, periodoGet);
		
		responso = new JSONObject();
		generi = Events.getGeneri();
		periodo = Events.getPeriodo();
		statiScanner = StatiScanner.getStati();
		generiScanner = GeneriScanner.getGeneri();
		contatoreEventiPerStati = new LinkedHashMap<String, Integer>();
		contatoreEventiPerGeneri = new LinkedHashMap<String, Integer>();
		stati = new Vector<String>();
		paesi = new Vector<String>();
		America = new Vector<String>();
		Canada = new Vector<String>();
		chiamateEv = new Vector<Vector<Eventi>>();
		eventiFiltratiPerStati = new Vector<Eventi>();
		minMaxAverage = new LinkedHashMap<String, MinMaxMedia>();
		minMaxAverageFilter = new LinkedHashMap<String, MinMaxMedia>();
		eventiFiltratiPerGeneri = new Vector<Eventi>();
		
		try {

			controlloStatiEventiBody(Events);
			FillerStati();					
			FillerPaesi();
			FillerUS();			
			FillerCA();			
			CallEvents();			
			filtroStati();			
			DateController();			
			StateController();

			if (generi.isEmpty()) {
				controlloGeneriEventiBody();
				return responso;
			}

			filtroGeneri();			
			controlloFiltroGeneri();
			responso.put("numero totale eventi", contatoreEventiPerStati);
			responso.put("numero eventi per il genere", contatoreEventiPerGeneri);
			
			if (periodo.isEmpty())
				responso.put("statistiche mensili di eventi", minMaxAverage);
			else {
				responso.put("statistiche periodiche di eventi", minMaxAverageFilter);
			}
				
			
			responso.put("eventi", eventiFiltratiPerGeneri);
		} catch (EventiException e) {
			responso = e.generaJSON(key, value);
		}

		return responso;

	}
	
	
	/**
	 * Metodo ausiliario che effettua un controllo sul vettore di stati dell'oggetto
	 * eB, vedendo se è vuoto
	 */
	private void controlloStatiEventiBody(EventiBody Events) throws EventiException {

		if (!Events.getStati().isEmpty())
			statiPaesi = Events.getStati();
		else {
			key = "Attenzione";
			value = "Non è stato inserito nessuno stato. Lista stati: " + statiScanner;
			throw new EventiException();
		}

	}

	/**
	 * Metodo ausiliario che popola il vettore stati
	 */
	private void FillerStati() throws EventiException {

		for (int i = 0; i < statiPaesi.size(); i++) {
			String s = statiPaesi.elementAt(i);
			stati.add(s.substring(0, s.indexOf(",")));
		}
	}

	/**
	 * Metodo ausiliario che popola il vettore paesi
	 */
	private void FillerPaesi() throws EventiException {
		for (int i = 0; i < statiPaesi.size(); i++) {
			String p = statiPaesi.elementAt(i);
			paesi.add(p.substring(p.length() - 2, p.length()));
		}
	}

	/**
	 * Metodo che popola il vettore australia
	 */
	private void FillerUS() {
		America.addAll(statiScanner);
		America.remove(America.size() - 1);
		America.add("US");
	}

	/**
	 * Metodo ausiliario che popola il vettore newZealand
	 */
	private  void FillerCA() {
		Canada.add(statiScanner.elementAt(statiScanner.size() - 1));
		Canada.add("CA");
	}
	
	/**
	 * Metodo ausiliario che effettua l'algoritmo per la chiamata alla rotta
	 * events dell'API di ticketmaster.
	 */
	private void CallEvents() throws EventiException {

		for (int i = 0; i < paesi.size(); i++) {
			String p = paesi.elementAt(i);
			String s = stati.elementAt(i);
			
			if (p.equals("US") || p.equals("CA")) {

				if ((America.contains(p) && America.contains(s))
						|| (Canada.contains(p) && Canada.contains(s))) {
					
					Vector<String> subPaesi = new Vector<String>();
					for (int h = 0; h < i; h++) {
						String subP = paesi.elementAt(h);
						subPaesi.add(subP);
					}

					if (!subPaesi.contains(p)) {
						chiamateEv.add(ChiamataEventi.chiamata(p));
					} else
						chiamateEv.add(chiamateEv.elementAt(subPaesi.indexOf(p)));
				} else {
					key = "Errore";
					value = "Lo stato " + s + " non appartiene a " + p;
					throw new EventiException();
				}
			} else {
				key = "Errore";
				value = "Lo stato " + p + " non è disponibile";
				throw new EventiException();
			}
		}
	}

	/**
	 * Metodo ausiliario che effettua un filtro per stati sul vettore chiamateEv
	 */
	private static void filtroStati() {

		for (int i = 0; i < chiamateEv.size(); i++) {

			Vector<Eventi> evTemp = chiamateEv.elementAt(i);
			evFiltratiPerStato = FiltroStato.filtroPerStato(stati.elementAt(i), evTemp);
			eventiFiltratiPerStati.addAll(evFiltratiPerStato);
			contatoreEventiPerStati.put("in " + stati.elementAt(i), evFiltratiPerStato.size());
			StatsData dS = new StatsData();
			statisticheMensili(dS, i);	
			int dimVectorCounter = 2;
			if (!periodo.isEmpty() && dimVectorCounter == periodo.size())
				filtroStatistichePeriodiche(mMA, numberArray, i);
		}
	}
	
	/**
	 * Metodo ausiliario che effettua le statistiche minimo, massimo e media 
	 */
	private static void statisticheMensili(StatsData dS, int i) {

		mMA = new MinMaxMedia();
		numberArray = dS.numeroEventi(evFiltratiPerStato);
		mMA.sortEventi(numberArray);
		mMA.minEventi(numberArray);
		mMA.maxEventi(numberArray);
		mMA.mediaEventi(numberArray);
		minMaxAverage.put("in " + stati.elementAt(i), mMA);
	}

	/**
	 * Metodo ausiliario che effettua un filtro sulle statistiche minimo, massimo e
	 * media in un periodo di tempo personalizzato
	 */
	private static void filtroStatistichePeriodiche(MinMaxMedia mMA, int[] numberArray, int i) {
		
		FiltroMinMaxMedia mma = new FiltroMinMaxMedia();

		int[] numArray = mma.mMAFilter(evFiltratiPerStato, periodo);
		numberArray = numArray;
		mMA.sortEventi(numberArray);
		mMA.minEventi(numberArray);
		mMA.maxEventi(numberArray);
		mMA.mediaEventi(numberArray);

		minMaxAverageFilter.put("in " + stati.elementAt(i), mMA);
	}
	
	/**
	 * Controllo che le date siano inserite nel modo corretto
	 */
	private void DateController() throws EventiException {
		
		if(!periodo.isEmpty()) {
			int controllerSize = 2;
			if (controllerSize != periodo.size()) {

				key = "Attenzione";
				value = "inserire solo la data di inizio e la data di fine evento";
				throw new EventiException();
			}		
		}
	}
	
	/**
	 * Controllo che ci siano eventi disponibili dopo il filtro per stati
	 */
	private void StateController() throws EventiException {

		if (eventiFiltratiPerStati.isEmpty()) {

			key = "Attenzione";
			value = "Nessun evento disponibili";
			throw new EventiException();
		}
	}

	/**
	 * Metodo ausiliario che effettua un controllo sul vettore di generi
	 * vedendo se è vuoto e ritornando un responso alternativo
	 */
	
	@SuppressWarnings("unchecked")
	private void controlloGeneriEventiBody() {

		HashSet<String> generiHash = new HashSet<String>();

		for (Eventi e : eventiFiltratiPerStati)
			generiHash.add(e.getGenere());

		for (String g : generiHash) {
			int cont = FiltroGenere.FGenere(g, eventiFiltratiPerStati).size();
			contatoreEventiPerGeneri.put(g, cont);
		}

		responso.put("n totale eventi", contatoreEventiPerStati);

		responso.put("n eventi per genere", contatoreEventiPerGeneri);

		if (periodo.isEmpty())
			responso.put("statistiche mensili di eventi", minMaxAverage);
		else
			responso.put("statistiche periodiche di eventi", minMaxAverageFilter);

		responso.put("eventi", eventiFiltratiPerStati);

	}

	/**
	 * Metodo ausiliario che effettua un filtro per generi sul vettore eventiFiltratiPerStati 
	 */
	
	private void filtroGeneri() {
		
		for (int i = 0; i < generi.size(); i++) {

			String g = generi.elementAt(i);
			evFiltratiPerGenere = FiltroGenere.FGenere(g, eventiFiltratiPerStati);
			
			eventiFiltratiPerGeneri.addAll(evFiltratiPerGenere);
			
			contatoreEventiPerGeneri.put(generi.elementAt(i), evFiltratiPerGenere.size());

		}		
	}
	
	/**
	 * Metodo ausiliario che effettua un controllo nel caso in cui non ci fossero
	 * eventi disponibili dopo il filtro per generi
	 */
	
	private void controlloFiltroGeneri() throws EventiException {
		
		if (eventiFiltratiPerGeneri.isEmpty()) {
			
			key = "Attenzione";
			value = "Nessun evento disponibile";
			throw new EventiException();
		}		
	}
}