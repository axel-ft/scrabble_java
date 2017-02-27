package com.scrabble;

import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 	<b>Classe Dictionnaire</b>
 * 	<p>Créée le 27/02/2017 et modifiée le 27/02/2017</p>
 * 	<p>Cette classe contient un dictionnaire parsé depuis un fichier texte et permet de vérifier la présence d'un mot dans celui-ci</p>
 * 	
 *  @author Axel Floquet-Trillot 
 *  @version 0.2
 * 
 */
public class Dictionary {
	
	private List<String> dictionary;
	
	public Dictionary() {
		    this.dictionary = new ArrayList<>();
		    try {
		        // Lecteur du fichier
		        BufferedReader dicoFile = new BufferedReader(new FileReader("dictionnaire.txt"));

		        String dicoLine = dicoFile.readLine();
		        while (dicoLine != null) {
		            dictionary.add(Normalizer.normalize(normalizeWord(dicoLine), Normalizer.Form.NFD));
		            dicoLine = dicoFile.readLine();
		        }

		        dicoFile.close();
	        }

	        // Gestion d'erreurs
		    catch (FileNotFoundException fnfe) {
		    	System.out.println("Impossible de trouver le dictionnaire");
		    } catch (IOException ioe) {
		        ioe.printStackTrace();
		    }
	}
	
	public String normalizeWord(String input) {
		input = Normalizer.normalize(input.toUpperCase(), Normalizer.Form.NFD);
		input = input.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return input;
	}
	
	public boolean checkWord(String input) {
		input = normalizeWord(input);
		if (this.dictionary.indexOf(input) == -1) {
			return false;
		} else if (this.dictionary.indexOf(input) >= 0 && this.dictionary.indexOf(input) <= 22740) {
			return true;
		} else {
			return false;
		}
	}
}
