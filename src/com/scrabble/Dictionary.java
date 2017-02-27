package com.scrabble;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	
	private List<String> dictionary;
	
	public Dictionary() {
		    this.dictionary = new ArrayList<>();
		    try {
		        // Lecteur du fichier
		        BufferedReader dicoFile = new BufferedReader(new FileReader("dictionnaire.txt"));

		        String dicoLine = dicoFile.readLine();
		        while (dicoLine != null) {
		            dictionary.add(dicoLine.toUpperCase());
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
	
	public boolean isWordInDico(String input) {
		if (this.dictionary.indexOf(input) == -1) {
			return false;
		} else if (this.dictionary.indexOf(input) >= 0 && this.dictionary.indexOf(input) <= 22740) {
			return true;
		} else {
			return false;
		}
	}
}
