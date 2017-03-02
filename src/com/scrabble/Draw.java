package com.scrabble;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * Created by pault on 23/02/2017.
 */

public class Draw {
	
	/** The pawn. */
	Letter[] pawn = new Letter[27];

	/**
	 * Instantiates a new draw.
	 */
	public Draw() { // Définition de l'alphabet avec c'est points et qte
		this.pawn[0] = new Letter('*', 0, 2);
		this.pawn[1] = new Letter('a', 1, 9);
		this.pawn[2] = new Letter('b', 3, 2);
		this.pawn[3] = new Letter('c', 3, 2);
		this.pawn[4] = new Letter('d', 2, 3);
		this.pawn[5] = new Letter('e', 1, 15);
		this.pawn[6] = new Letter('f', 4, 2);
		this.pawn[7] = new Letter('g', 2, 2);
		this.pawn[8] = new Letter('h', 4, 2);
		this.pawn[9] = new Letter('i', 1, 8);
		this.pawn[10] = new Letter('j', 8, 1);
		this.pawn[11] = new Letter('k', 10, 1);
		this.pawn[12] = new Letter('l', 1, 5);
		this.pawn[13] = new Letter('m', 2, 3);
		this.pawn[14] = new Letter('n', 1, 6);
		this.pawn[15] = new Letter('o', 1, 6);
		this.pawn[16] = new Letter('p', 3, 2);
		this.pawn[17] = new Letter('q', 8, 1);
		this.pawn[18] = new Letter('r', 1, 6);
		this.pawn[19] = new Letter('s', 1, 6);
		this.pawn[20] = new Letter('t', 1, 6);
		this.pawn[21] = new Letter('u', 1, 6);
		this.pawn[22] = new Letter('v', 4, 2);
		this.pawn[23] = new Letter('w', 10, 1);
		this.pawn[24] = new Letter('x', 10, 1);
		this.pawn[25] = new Letter('y', 10, 1);
		this.pawn[26] = new Letter('z', 10, 1);
	}

	/**
	 * Display pawns.
	 */
	public void displayPawns() { // Afficher l'alphabet
		for (int i = 0; i < this.pawn.length; i++) {
			System.out.printf(this.pawn[i].info());
			System.out.printf("\r\n");
		}

	}

	/**
	 * Draw.
	 *
	 * @return the letter
	 */
	public Letter draw() { // Pioche aléatoire
		Random randoml = new Random();
		int n = randoml.nextInt(27);
		while(this.pawn[n].getQty() <= 0){
		n = randoml.nextInt(27);	
	}
		Letter draw = this.pawn[n];
		this.pawn[n].decQty();
		return draw;
	}
	
	/**
	 * Remaining pawns.
	 *
	 * @return the int
	 */
	public int remainingPawns() {
		int remainingPawns = 0;
		for (int i = 0; i < this.pawn.length; i++) {
			remainingPawns += this.pawn[i].getQty();
		}
		return remainingPawns;
	}
}
