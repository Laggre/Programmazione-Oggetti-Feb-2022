package it.univpm.OPPproject.Parser;

import java.time.LocalDate;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.univpm.OPPproject.Filters.FiltroMinMaxMedia;
import it.univpm.OPPproject.model.Eventi;

/**
 * Classe che analizza il codice json di /eventi
 * 
 * @author LorenzoScortichini
 * @author PieralisiNicola
 */
public class EventiParser {
	/**
	 * Vettore di Eventi nel quale vengono inseriti gli eventi creati
	 * a partire dal JSON
	 */
	private Vector<Eventi> listaEventi;
	
	/**
	 * Metodo che analizza il json della chiamata events e restituisce un vettore di eventi
	 */
	public Vector<Eventi> parse(String chiamata) {
		
		listaEventi = new Vector<Eventi>();
		
		try {
			
			JSONParser parser = new JSONParser();
			
			JSONObject jO = (JSONObject) parser.parse(chiamata);
			
			JSONObject embedded1 = (JSONObject) jO.get("_embedded");
			
			JSONArray events = (JSONArray) embedded1.get("events");
			
			for (int i = 0; i < events.size(); i++) {
				
				JSONObject eventoTemp = (JSONObject) events.get(i);
				String name = (String) eventoTemp.get("name");
				String url = (String) eventoTemp.get("url");
				
				JSONObject dates = (JSONObject) eventoTemp.get("dates");
				
				JSONObject start = (JSONObject) dates.get("start");
				String localDate = (String) start.get("localDate");
				
				LocalDate locDt = FiltroMinMaxMedia.dateConverter(localDate);
				String localTime = (String) start.get("localTime");
				
				JSONArray classifications = (JSONArray) eventoTemp.get("classifications");
				
				JSONObject classificationsTemp = (JSONObject) classifications.get(0);
				
				JSONObject genre = (JSONObject) classificationsTemp.get("genre");
				String nameGenre = (String) genre.get("name");
				
				JSONObject subGenre = (JSONObject) classificationsTemp.get("subGenre");
				String nameSubGenre = (String) subGenre.get("name");
				
				JSONObject embedded2 = (JSONObject) eventoTemp.get("_embedded");
				
				JSONArray venues = (JSONArray) embedded2.get("venues");
				
				JSONObject venuesTemp = (JSONObject) venues.get(0);
				
				JSONObject city = (JSONObject) venuesTemp.get("city");
				String cityName = (String) city.get("name");
				
				JSONObject state = (JSONObject) venuesTemp.get("state");
				String stateName = (String) state.get("name");
				
				JSONObject country = (JSONObject) venuesTemp.get("country");
				String countryName = (String) country.get("name");
				
				Eventi e = new Eventi(name, url, cityName, stateName, countryName, locDt, localTime, 
						nameGenre, nameSubGenre);

				listaEventi.add(e);
			
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return listaEventi;
		
	}


}
