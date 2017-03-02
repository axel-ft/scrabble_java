package com.scrabble;

import java.util.Arrays;
import java.util.Scanner;

public class Words {
	
	public String mots;

	private String[] words;

	private static Scanner scan;

	public Words()
	{
		System.out.println("Ajouter Votre Mot");
		scan = new Scanner(System.in);
		this.mots = scan.nextLine();
		System.out.println("Votre Mot est " + this.mots);
		this.words = this.mots.split("");
		System.out.println(Arrays.deepToString(this.words));
	}


	/**
	 * @author Valentin, Calcul du score avec l'aide de 2 autres méthodes dans Draw
	 * returnCaseIndice() & returnPoint();
	 * @return
	 *
	 * Fonctionnement:
	 *
	 * Le mot saisie par l'utilisateur scindé en tableau est récupérer.
	 * Une boucle for permet de réaliser l'action de comptage de point pour chaque lettre du mot posé.
	 * la lettre récupérer va être comparé dans le tableau alphabétique (Draw.java) et resortira le numéro de case du tableau contenant la lettre.
	 * Puis avec le numéro de case, on cherche le point correspondant à la lettre.
	 * On retourne la valeur et on incrémente cette valeur dans la variable score.
	 * On recommence pour la lettre suivante du mot.
	 */
	public int calScore() {

		Draw newDraw = new Draw();
        int arrayLenght;
        int i = 0;
        int score = 0;
        String wordLetter;

        arrayLenght = this.words.length;

        for (i=0;i != arrayLenght;i++){

        	wordLetter = this.words[i];
        	newDraw.returnCaseIndice(wordLetter);
			int scoreLetter = newDraw.returnPoint();

			score += scoreLetter;
			return score;
        }
		
	return score;
	}

}
