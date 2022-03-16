package it.univpm.OPPproject.scanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

/**
 * Classe che scannerizza in lettura il file Stati.csv
 * 
 * @author LorenzoScortichini
 * @author NicolaPieralisi
 */
public class StatiScanner {

	public static Vector<String> getStati() {
		
		Vector<String> statiVecttore = new Vector<String>();
		
		try {
			
			Scanner Stati = new Scanner(new BufferedReader(new FileReader("resources/Stati.csv")));
			
			while (Stati.hasNext())
				statiVecttore.add(Stati.nextLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return statiVecttore;
		
	}
	

}
