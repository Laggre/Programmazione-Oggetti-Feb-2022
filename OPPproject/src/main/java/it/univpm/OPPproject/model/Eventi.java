package it.univpm.OPPproject.model;

import java.time.LocalDate;

/**
 * Classe che definisce gli eventi 
 * 
 * @author NicolaPieralisi
 * @author LorenzoScortichini
 */

public class Eventi {
	/**
	 * Variabile che descrive il nome dell'evento
	 */
	private String nome;	
	private String url;
	private String citta;
	private String stato;
	private String paese;
	private LocalDate data;
	private String ora;
	private String genere;
	private String categoria;
	
	/**
	 * Costruttore utile a inizializzare gli eventi
	 */
	public Eventi() {}
	public Eventi(String nome, String url, String citta, String stato, String paese, LocalDate dara, 
			String ora, String genere, String categoria) {
		this.nome = nome;
		this.url = url;
		this.citta = citta;
		this.stato = stato;
		this.paese = paese;
		this.data = dara;
		this.ora = ora;
		this.genere = genere;
		this.categoria = categoria;
	}
	
	/**
	 * Getter dell'attributo nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Setter dell'attributo nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate localDate) {
		this.data = localDate;
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}
	
	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	

}
