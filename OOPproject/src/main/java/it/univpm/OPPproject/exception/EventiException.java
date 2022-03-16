package it.univpm.OPPproject.exception;

import org.json.simple.JSONObject;

/**
 * Classe che descrive le eccezioni 
 * 
 * @author LorenzoScortichini
 * @author NicolaPieralisi
 */

public class EventiException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public EventiException() {
		super();
	}
	
	 //Assegno alla risposta una coppia di chiave/valore,
	@SuppressWarnings("unchecked")
	public JSONObject generaJSON(String key, String value) {
		JSONObject resp = new JSONObject();
		resp.put(key, value);
		return resp;
	}
}
