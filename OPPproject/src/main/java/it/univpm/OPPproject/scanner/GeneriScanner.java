package it.univpm.OPPproject.scanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

/**
 * Classe che scannerizza in lettura il file Generi.csv
 * 
 * @author LorenzoScortichini
 * @author NicolaPieralisi
 */
public class GeneriScanner {

	public static Vector<String> getGeneri() {
		
		Vector<String> GVettore = new Vector<String>();
		
		try {
			
			Scanner Generi = new Scanner(new BufferedReader(new FileReader("resources/Generi.csv")));
			
			while (Generi.hasNext())
				GVettore.add(Generi.nextLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return GVettore;
		
	}

}
