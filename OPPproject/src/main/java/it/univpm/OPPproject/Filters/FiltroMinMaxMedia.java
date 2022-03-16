package it.univpm.OPPproject.Filters;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Vector;

import it.univpm.OPPproject.model.Eventi;

/**
 * Classe che consente di determinare il numero totale di eventi svolti in uno
 * specifico periodo di tempo inserito dall'user
 *
 * @author NicolaPieralisi
 * @author NLorenzoScortichini
 */
public class FiltroMinMaxMedia {

	/**
	 * Metodo che consente di determinare il numero totale di
	 * eventi relativi ad uno specifico stato che si svolgono in uno specifico mese
	 * 
	 */
	public int[] mMAFilter(Vector<Eventi> listaEventi, Vector<String> datePeriodo) {

int[] numeroEventi = null;
		
		LocalDate dataIniziale = dateConverter(datePeriodo.elementAt(0));
		
		LocalDate dataFinale = dateConverter(datePeriodo.elementAt(1));

		long periodo = ChronoUnit.DAYS.between(dataIniziale, dataFinale);

		Eventi eventoScelto = new Eventi();
		
		int[] maxRipPeriodo= new int[1];
		maxRipPeriodo= maxRipDelPeriodo(periodo, dataFinale, dataIniziale);
		
		long[] periodiAdder = new long[1];
		periodiAdder[0] = 0;

		numeroEventi = new int[maxRipPeriodo[0]];
			
		for (int j = 0; j < maxRipPeriodo[0]; j++) {

			LocalDate dataAggiornataIniz = dataIniziale.plusDays(periodiAdder[0]);
			LocalDate dataAggiornataFin = dataFinale.plusDays(periodiAdder[0]);

			for (int i = 0; i < listaEventi.size(); i++) {

				eventoScelto = listaEventi.get(i);
				LocalDate dataEvento = eventoScelto.getData();
					
				if ( ( (dataEvento.isAfter(dataAggiornataIniz)) ||  (dataEvento.equals(dataAggiornataIniz)) ) && ( (dataEvento.isBefore(dataAggiornataFin)) || (dataEvento.equals(dataAggiornataFin))) ) {
						numeroEventi[j] += 1;
					} else {
						numeroEventi[j] += 0;
					}
				
			}
			
			
			periodiAdder[0] += periodo;
		}
		return numeroEventi;
	}

	/**
	 * Metodo che converte una Stringa con
	 * la data dell'evento in un oggetto LocalDate
	 */
	public static LocalDate dateConverter(String date) {

		LocalDate locD = LocalDate.parse((CharSequence) date);
		
		return locD;
	
	}
	
	/**
	 * Metodo che calcola il numero massimo di ripetizioni del periodo
	 * del periodo inserito dall'utente
	 */
	 
	public int[] maxRipDelPeriodo(long PLength, LocalDate dataF, LocalDate dataI) {
		
		int[] massimaRip = new int[1];
		massimaRip[0] = 1;
		
		int annoLimite = dataF.getYear();;
		
		long[] periodiAdder = new long[1];
		periodiAdder[0] = 0;
		
		periodiAdder[0] += PLength;
			
		for(long k = 0; k<365 ;k++) {
			if (periodiAdder[0] < 364) {	
				LocalDate dataAggiornata = dataI.plusDays(periodiAdder[0]);
				LocalDate dataLimite = LocalDate.of(annoLimite, Month.DECEMBER, 31);

					if (dataAggiornata.isBefore(dataLimite)) {
						massimaRip[0] += 1;
					} else
						massimaRip[0] += 0;
					
			}
			periodiAdder[0] += PLength;
			k = periodiAdder[0];
		}
		
		return massimaRip;
	}

}
