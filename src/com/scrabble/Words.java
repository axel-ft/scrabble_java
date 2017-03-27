package com.scrabble;

import java.util.Arrays;
import java.util.Scanner;

public class Words {

	public String mot;

	private String[] words;

	private static Scanner scan;

	public Words() {
		System.out.println("Ajouter Votre Mot");
		scan = new Scanner(System.in);
		this.mot = scan.nextLine();
		System.out.println("Votre Mot est " + this.mot);
		this.words = this.mot.split("");
		System.out.println(Arrays.deepToString(this.words));
	}

	/**
	 * @author Valentin, Calcul du score avec l'aide de 2 autres méthodes dans
	 *         Draw returnCaseIndice() & returnPoint();
	 * @return
	 *
	 * 		Fonctionnement:
	 *
	 *         Le mot saisi par l'utilisateur est scindé en tableau est
	 *         récupéré. Une boucle for permet de réaliser l'action de comptage
	 *         de points pour chaque lettre du mot posé. la lettre récupérée va
	 *         être comparée dans le tableau alphabétique (Draw.java) et
	 *         ressortira le numéro de case du tableau contenant la lettre. Puis
	 *         avec le numéro de case, on cherche le nombre de points
	 *         correspondant à la lettre. On retourne la valeur et on incrémente
	 *         cette valeur dans la variable score. On recommence pour la lettre
	 *         suivante du mot.
	 */
	public int calScore(Draw gameDraw) {
		int wordScore = 0;

		for (int i = 0; i < this.words.length; i++) {
			if (gameDraw.returnCaseIndice(this.words[i]) != null) {
				wordScore += gameDraw.returnCaseIndice(this.words[i]).getPoint();
			}
		}
		return wordScore;
	}

}
