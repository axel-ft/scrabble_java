package com.scrabble;

import java.util.Random;

/**
 * Created by pault on 23/02/2017.
 */

public class Draw {
	Letter[] tiles = new Letter[27];
	int[] probas;
	private int remainingPawns = 0;

	public Draw() { // Définition de l'alphabet avec c'est points et qte
		this.tiles[0] = new Letter("*", 0, 2);
		this.tiles[1] = new Letter("A", 1, 9);
		this.tiles[2] = new Letter("B", 3, 2);
		this.tiles[3] = new Letter("C", 3, 2);
		this.tiles[4] = new Letter("D", 2, 3);
		this.tiles[5] = new Letter("E", 1, 15);
		this.tiles[6] = new Letter("F", 4, 2);
		this.tiles[7] = new Letter("G", 2, 2);
		this.tiles[8] = new Letter("H", 4, 2);
		this.tiles[9] = new Letter("I", 1, 8);
		this.tiles[10] = new Letter("J", 8, 1);
		this.tiles[11] = new Letter("K", 10, 1);
		this.tiles[12] = new Letter("L", 1, 5);
		this.tiles[13] = new Letter("M", 2, 3);
		this.tiles[14] = new Letter("N", 1, 6);
		this.tiles[15] = new Letter("O", 1, 6);
		this.tiles[16] = new Letter("P", 3, 2);
		this.tiles[17] = new Letter("Q", 8, 1);
		this.tiles[18] = new Letter("R", 1, 6);
		this.tiles[19] = new Letter("S", 1, 6);
		this.tiles[20] = new Letter("T", 1, 6);
		this.tiles[21] = new Letter("U", 1, 6);
		this.tiles[22] = new Letter("V", 4, 2);
		this.tiles[23] = new Letter("W", 10, 1);
		this.tiles[24] = new Letter("X", 10, 1);
		this.tiles[25] = new Letter("Y", 10, 1);
		this.tiles[26] = new Letter("Z", 10, 1);
		this.probas = new int[]{0,0,1,1,1,1,1,1,1,1,1,2,2,3,3,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,6,6,7,7,8,8,9,9,9,9,9,9,9,9,10,11,12,12,12,12,12,13,13,13,14,14,14,14,14,14,15,15,15,15,15,15,16,16,17,18,18,18,18,18,18,19,19,19,19,19,19,20,20,20,20,20,20,21,21,21,21,21,21,22,22,23,24,25,26};
	}

	public Letter drawTile() { // Pioche aléatoire
		Random randoml = new Random();
		int n = randoml.nextInt(102);
		while (probas[n] == -1 || this.tiles[probas[n]].getQtyInDraw() <= 0) {
			n = randoml.nextInt(102);
		}
		Letter draw = this.tiles[probas[n]];
		this.tiles[probas[n]].decQtyInDraw();
		probas[n] = -1;
		return draw;
	}

	public int remainingTiles() {
		this.remainingPawns = 0;
		for (int i = 0; i < this.tiles.length; i++) {
			this.remainingPawns += this.tiles[i].getQtyInDraw();
		}
		return this.remainingPawns;
	}

	public Letter returnCaseIndice(String wordLetter) {
		for (int i = 0; i < 27; i++) {
			if (wordLetter.toUpperCase().equals(this.tiles[i].getAlpha())) {
				return this.tiles[i];
			}
		}
		return null;
	}
}
