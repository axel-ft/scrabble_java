package com.scrabble;

import java.util.ArrayList;
import java.util.List;

public class Word {

	private Dictionary dico = new Dictionary();
	private String word;
	private List<String> words = new ArrayList<>();
	private int wordScore = 0;
	private int wordMult = 1;
	private Tray tray;
	private Draw draw;
	private int xCursor, yCursor;

	public Word(Tray tray, Draw draw) {
		this.xCursor = tray.getXorigin();
		this.yCursor = tray.getYorigin();
		this.tray = tray;
		this.draw = draw;
	}
	
	public List<String> getWords() {
		return this.words;
	}
	
	public int getWordScore() {
		return this.wordScore;
	}

	/**
	 * @author Valentin et Axel, Calcul du score avec l'aide de 2 autres méthodes dans
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
	 *         
	 *  Modification par Axel le 28/03/2017 et 29/03/2017 : réécriture complète
	 */
	public String scanHorizontalWord() {
		this.word = "";
		
		if (tray.getYorigin() != 0 && tray.getSpecificSquare(tray.getXorigin(), tray.getYorigin()-1).getSquareContent() != null) {
			while(yCursor > 0 && tray.getSpecificSquare(xCursor, yCursor-1).getSquareContent() != null) {
				yCursor--;
			}
		}
		while(yCursor < 15 && tray.getSpecificSquare(xCursor, yCursor).getSquareContent() != null) {
			this.word += tray.getSpecificSquare(xCursor, yCursor).getSquareContent().getAlpha();
			this.wordScore += draw.returnCaseIndice(tray.getSpecificSquare(xCursor, yCursor).getSquareContent().getAlpha()).getPoint() * tray.getSpecificSquare(xCursor, yCursor).getLetterMultiplier();
			this.wordMult *= tray.getSpecificSquare(xCursor, yCursor).getWordMultiplier();
			yCursor++;
		}
		return word;
	}
	
	public String scanVerticalWord() {
		this.word = "";
		if (tray.getXorigin() != 0 && tray.getSpecificSquare(tray.getXorigin()-1, tray.getYorigin()).getSquareContent() != null) {
			while(xCursor > 0 && tray.getSpecificSquare(xCursor-1, yCursor).getSquareContent() != null) {
				xCursor--;
			}
		}
		while(xCursor < 15 && tray.getSpecificSquare(xCursor, yCursor).getSquareContent() != null) {
			this.word += tray.getSpecificSquare(xCursor, yCursor).getSquareContent().getAlpha();
			this.wordScore += draw.returnCaseIndice(tray.getSpecificSquare(xCursor, yCursor).getSquareContent().getAlpha()).getPoint() * tray.getSpecificSquare(xCursor, yCursor).getLetterMultiplier();
			this.wordMult *= tray.getSpecificSquare(xCursor, yCursor).getWordMultiplier();
			xCursor++;
		}

		return word;
	}
	
	public boolean scanTray() {
		
		if (tray.isWordHorizontal()) {
			word = this.scanHorizontalWord();
		}
		
		if (tray.isWordVertical()) {
			word = this.scanVerticalWord();
		}
		
		if (word!=null) {
			if (dico.checkWord(word)) {
				this.wordScore *= this.wordMult;
				this.words.add(this.word);
				return true;
			}
		}
		return false;
		
	}

}
