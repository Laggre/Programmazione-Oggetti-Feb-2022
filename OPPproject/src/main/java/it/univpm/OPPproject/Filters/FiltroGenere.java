package it.univpm.OPPproject.Filters;

import java.util.Vector;

import it.univpm.OPPproject.model.Eventi;

/**
 * filtro i generi
 * 
 * @author NicolaPieralisi
 * @author NLorenzoScortichini
 */
public class FiltroGenere {
	/**
	 * filtro per generi gli eventi
	 */
public static Vector<Eventi>  FGenere(String genere, Vector<Eventi> eventiDaFiltrare) {
		
		Vector<Eventi> eventiFiltrati = new Vector<Eventi>();
		
		for (Eventi eventiTemp : eventiDaFiltrare) {
			
			if(genere.equals(eventiTemp.getGenere()))
				eventiFiltrati.add(eventiTemp);
			
		}
		return eventiFiltrati;	
	}




}
