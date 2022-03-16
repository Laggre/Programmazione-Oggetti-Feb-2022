package it.univpm.OPPproject.Stats;

import java.time.LocalDate;
import java.util.Vector;

import it.univpm.OPPproject.model.Eventi;

/**
 * Classe che consente di determinare il numero totale di 
 * eventi che si svolgono in uno specifico mese
 *
 * @author NicolaPieralisi
 * @author LorenzoScortichini
 */
public class StatsData {

	public int[] numeroEventi(Vector<Eventi> lista) {
				
			int[] monthsEvents = new int[12];
			
			for(int i = 0; i < lista.size(); i++) {
				
				Eventi eventoProv = new Eventi();
				eventoProv = lista.get(i);
				LocalDate mese1 = eventoProv.getData(); 

				for(int j = 1; j <= 12; j++) {
					
					LocalDate mese2 = mese1.withMonth(j);
					
					if(mese1.equals(mese2)) {
						
						int pre_counter = j - 1;
						monthsEvents[pre_counter] += 1;
					
					} else {
						
						int pre_counter = j - 1;
						monthsEvents[pre_counter]+=0;
					
					}
					
					int accumulatore = j + 1;
					mese2.plusMonths(accumulatore);		
				}
			}
			return monthsEvents;
		}
}
