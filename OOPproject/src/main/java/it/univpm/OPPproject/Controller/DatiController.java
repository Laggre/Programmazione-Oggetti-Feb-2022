package it.univpm.OPPproject.Controller;

import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.OPPproject.scanner.GeneriScanner;
import it.univpm.OPPproject.scanner.StatiScanner;

/**
 * Le rotte /stati e /generi che restituiscono
 * valori sui file Generi.csv e Stati.csv (Comma Separated Values)
 * 
 * @author LorenzoScortichini
 * @author NicolaPieralisi
 */
@RestController
public class DatiController {
	
	@GetMapping("/stati")
	public Vector<String> stati() {
		return StatiScanner.getStati();	
	}

	@GetMapping("/generi")
	public Vector<String> generi() {
		return GeneriScanner.getGeneri();
	}
	

}
