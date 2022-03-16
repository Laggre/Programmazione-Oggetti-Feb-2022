package it.univpm.OPPproject.model;

import java.util.Vector;
/**
 * Classe che descrive il body della chiamata post /eventi
 * 
 * @author NicolaPieralisi
 * @author LorenzoScortichini
 */

public class EventiBody {
	/**
	 * Attributo che memorizza gli stati inseriti
	 */
	private Vector<String> stati;

	private Vector<String> generi;

	private Vector<String> periodo;
	

	public EventiBody() {} //costruttore 

	public EventiBody(Vector<String> stato, Vector<String> genere, Vector<String> periodo) {
		this.stati = stato;
		this.generi = genere;
		this.periodo = periodo;
	}

	/**
	 * Getter dell'attributo stati
	 */
	public Vector<String> getStati() {
		return stati;
	}

	/**
	 * Setter dell'attributo stati
	 */
	public void setStati(Vector<String> s) {
		this.stati = s;
	}

	public Vector<String> getGeneri() {
		return generi;
	}

	public void setGeneri(Vector<String> g) {
		this.generi = g;
	}
	
	public Vector<String> getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Vector<String> p) {
		this.periodo = p;
	}

}
