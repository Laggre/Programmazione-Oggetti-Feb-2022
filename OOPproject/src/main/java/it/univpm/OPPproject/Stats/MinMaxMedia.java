package it.univpm.OPPproject.Stats;

import java.text.DecimalFormat;

/**
 * Classe che consente di svolgere la statistica  
 * massimo, minimo e media degli eventi
 *
 * @author LorenzoScortichini
 * @author NicolaPieralisi
 */
public class MinMaxMedia {
	/**
	 * Variabile che contiene la statistica mensile
	 */
	private int minimo;

	private int massimo;

	private double media;

	public MinMaxMedia() {}
	
	/**
	 * Sort di eventi dal piu piccolo al piu grande
	 */
public int[] sortEventi(int[] numEventi) {
		
		int n = numEventi.length; 
		
        int temp = 0;  
        
         for(int i = 0; i < n; i++){  
        	 
        	 for(int j = 1; j < (n - i); j++){  
        		 
        		 if(numEventi[j - 1] > numEventi[j]){ 
        			 
                     temp = numEventi[j - 1];  
                     numEventi[j - 1] = numEventi[j];  
                     numEventi[j] = temp;                   
        		 }             
        	 }          
         }
         return numEventi;
	}
	
	/**
	 * Determino il minimo numero di eventi
	 */
	public void minEventi(int[] nEventi) {
		this.minimo = nEventi[0];
	}
	
	/**
	 * Determino il max numero di eventi
	 */
	public void maxEventi(int[] nEventi) {
		int maxLength = nEventi.length-1;
		this.massimo = nEventi[maxLength];
	}
	
	/**
	 * Determino la media degli eventi
	 */
	public void mediaEventi(int[] nEventi) {
		
int[] accumulatore = new int[1];
		
		for(int i = 0; i < nEventi.length; i++)
			accumulatore[0] += nEventi[i];
		
		int lunghezzaArray = nEventi.length;
		
		this.media = Double.parseDouble(new DecimalFormat("##.##").format((double)accumulatore[0] 
										/ (double)lunghezzaArray).replace(",", "."));
	
	}


	public int getMinimo() {
		return minimo;
	}

	public int getMassimo() {
		return massimo;
	}

	public double getMedia() {
		return media;
	}

}
