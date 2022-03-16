package it.univpm.OPPproject.scanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Classe che scannerizza in lettura il file APIKey.txt
 * 
 * @author LorenzoScortichini
 * @author NicolaPieralisi
 */
public class ApiKeyScanner {

	public static String getKey() {
		
		String key = new String();
		
		try {
			
			Scanner APIKey = new Scanner(new BufferedReader(new FileReader("resources/APIKey.txt")));
			
			while (APIKey.hasNext())
				key = APIKey.nextLine();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return key;
		
	}

}
