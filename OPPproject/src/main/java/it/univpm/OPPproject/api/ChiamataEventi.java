package it.univpm.OPPproject.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import it.univpm.OPPproject.Parser.EventiParser;
import it.univpm.OPPproject.model.Eventi;
import it.univpm.OPPproject.scanner.ApiKeyScanner;

/**
 * Classe contenente la connessione all'Api
 * 
 * @author LorenzoScortichini
 * @author NicolaPieralisi
 */

public class ChiamataEventi {
	/**
	 * Metodo static che effettua la chiamata alla rotta events 
	 * e passa il json ella classe EventiParser
	 */
	public static Vector<Eventi> chiamata(String paese) {
		
		Vector<Eventi> listaEventi = new Vector<Eventi>();
		String key = ApiKeyScanner.getKey();
		
		try {
			
			URL url = new URL("https://app.ticketmaster.com/discovery/v2/events.json?countryCode=" 
								+ paese + "&apikey=" + key);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					
			BufferedReader stream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String J = stream.readLine();
			
			EventiParser eventParse = new EventiParser();
			
			listaEventi = eventParse.parse(J);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listaEventi;
	
	}


}
