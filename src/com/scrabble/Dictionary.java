package com.scrabble;

import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

/**
 * 	<b>Dictionary class</b>
 * 	<p>Created on 27/02/2017 and modified on 27/02/2017</p>
 * 	<p>This class contains a dictionary extracted from a txt file.<br>
 * 	It can also check whether a word is included in that dictionary or not.<br>
 * 	All the words are normalized to prevent false results.</p>
 * 	
 *  @author Axel Floquet-Trillot 
 *  @version 0.2
 */
public class Dictionary {
	
	private static final int SIZEOF_DICTIONARY = 22740;
	private List<String> dictionary;
	
	/**
	 * <b>Dictionary constructor</b>
	 * <p>Extract the txt file to keep it in list variable</p>
	 * 
	 * @author Axel Floquet-Trillot
	 * @since 0.1
	 */
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
	
	/**
	 * <p>This method transforms an input string in an uppercase without accents<p>
	 * 
	 * @param input
	 * 			The input unnormalized string
	 * @return String normalized
	 * 
	 * @author Axel Floquet-Trillot
	 * @since 0.2
	 */
	private String normalizeWord(String input) {
		input = Normalizer.normalize(input.toUpperCase(), Normalizer.Form.NFD);
		input = input.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return input;
	}
	
	/**
	 * <p>Check if a word exists in the dictionary or not</p>
	 * 
	 * @param input
	 * 			The input, normalized within this method
	 * @return 
	 * 			true if the word is found, or false if not
	 * 
	 * @author Axel Floquet-Trillot
	 * @since 0.1
	 */
	public boolean checkWord(String input) {
		input = normalizeWord(input);
		if (this.dictionary.indexOf(input) == -1) {
			return false;
		} else if (this.dictionary.indexOf(input) >= 0 && this.dictionary.indexOf(input) <= SIZEOF_DICTIONARY) {
			return true;
		} else {
			return false;
		}
	}
}
