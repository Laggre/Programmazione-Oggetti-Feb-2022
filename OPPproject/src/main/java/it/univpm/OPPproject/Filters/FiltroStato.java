package it.univpm.OPPproject.Filters;

import java.util.Vector;

import it.univpm.OPPproject.model.Eventi;

public class FiltroStato {
	/**
	 * Metodo che filtra per stati gli eventi
	 * @author LorenzoScortichini
	 * @author NicolaPieralisi
	 */

	public static Vector<Eventi> filtroPerStato(String stato, Vector<Eventi> eventiDaFilt) {
		// TODO Auto-generated method stub
		Vector<Eventi> eventiFiltrati = new Vector<Eventi>();
		
		for (Eventi eventiTemp : eventiDaFilt) {
			
			if(stato.equals(eventiTemp.getStato()))
				eventiFiltrati.add(eventiTemp);
			
		}
		
		return eventiFiltrati;
		
	}

}
