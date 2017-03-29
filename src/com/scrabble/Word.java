package com.scrabble;

import java.util.Arrays;

public class Word {

	public String word;
	private String[] splittedWord;

	public Word(Tray tray) {
		this.scanTray(tray);
		//this.splittedWord = this.word.split("");
		//System.out.println(Arrays.deepToString(this.splittedWord));
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

		for (int i = 0; i < this.splittedWord.length; i++) {
			if (gameDraw.returnCaseIndice(this.splittedWord[i]) != null) {
				wordScore += gameDraw.returnCaseIndice(this.splittedWord[i]).getPoint();
			}
		}
		return wordScore;
	}
	
	public void scanTray(Tray tray) {
		String word = null;
		for (int i=0; i<15; i++) {
			for (int j=0; j<15; j++) {
				if (tray.getSpecificSquare(i, j).getPendingState()) {
					System.out.println(String.valueOf(i) + String.valueOf(j) + " - " + tray.getSpecificSquare(i, j).getSquareContent());
				}
			}
		}
		this.word = word;
	}

}
