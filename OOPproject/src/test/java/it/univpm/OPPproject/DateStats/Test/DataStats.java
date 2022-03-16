package it.univpm.OPPproject.DateStats.Test;

import java.time.LocalDate;
import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.univpm.OPPproject.model.Eventi;
import it.univpm.OPPproject.Stats.*;

/**
 * Classe che effettua un test sul  metodo numeroEventi
 * 
 * @author LorenzoScortichini
 * @author NicolaPieralisi
 */
public class DataStats {

	/**
	 * oggetto della classe StatsData
	 */
	private StatsData test;
	private LocalDate dataEv1;
	private LocalDate dataEv2;
	private Eventi evento1;
	private Eventi evento2;
	private Vector<Eventi> listaEventi;
	
	/**
	 * Array rappresentante la soluzione corretta che deve essere 
	 * ottenuta dall'esecuzione del metodo "numeroEventi"
	 */
	private int [] numeroEventi = {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0};
	
	/**
	 * Array risultante dall'esecuzione di "numeroEventi"
	 */
	private int[] risultato;
	
	/**
	 * inizializzo ogni attributo nella classe di test "dateStatsTest"
	 */
	@BeforeEach
	public void setup() {
		
		listaEventi = new Vector<Eventi>();
		test = new StatsData();
	
		dataEv1 = LocalDate.of(2021,05,03);
		dataEv2 = LocalDate.of(2021,10,26);
		
		evento1 = new Eventi("LA Clippers vs. Toronto Raptors", "https://www.ticketmaster.com/event/Z7r9jZ1AdFUbP", "Los Angeles", "California", "United States Of America", 
					dataEv1,  "19:30:00", "NBA", "Basketball");
		
		evento2 = new Eventi("PAUL McCARTNEY GOT BACK", "https://www.ticketmaster.com/paul-mccartney-got-back-inglewood-california-05-13-2022/event/0A005C49D9E42D60", "Inglewood", "California", "United States Of America", 
				dataEv2,  "19:30:00", "Pop", "Rock");
		
		listaEventi.add(0, evento1);
		listaEventi.add(1, evento2);
		
		risultato = test.numeroEventi(listaEventi);
	}
	
	/**
	 * metodo eseguito al fine di ogni test per liberare risorse
	 */
	@AfterEach
	public void TearDown() {}
	
	/**
	 * Metodo per testing del metodo numeroEventi() che controlla se l'array di interi preso come parametro
	 * dalla funzione numeroEventi della classe DatesStatistics assegna, in maniera
	 * corretta, ogni evento del vettore listaEventi al relativo mese, in modo che
	 * ogni elemento dell'array di interi, che può essere inteso come un mese, 
	 * indichi il numero di eventi svolti in tale mese.
	 */
	@Test
	void dateStatsTest() {
		
		for(int i = 0; i < 12; i++) {
			Assertions.assertEquals(numeroEventi[i], risultato[i]);
		}
	}
	
	/**
	 * Metodo per testing del che controlla se il vettore
	 * contenente gli eventi non sia sia vuoto in modo da poter eseguire correttamete
	 * il metodo numeroEventi()
	 */
	@Test
	void dateStatsTestNN() {
		Assertions.assertNotNull(listaEventi.elementAt(0));
	}
}

