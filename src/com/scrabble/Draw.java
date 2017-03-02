package com.scrabble;

import java.util.Random;

/**
 * Created by pault on 23/02/2017.
 */

public class Draw {
	Letter[] pawn = new Letter[27];
	private String caseLetter;
	private int caseIndice;



	public Draw() { // D�finition de l'alphabet avec c'est points et qte
		this.pawn[0] = new Letter("*", 0, 2);
		this.pawn[1] = new Letter("A", 1, 9);
		this.pawn[2] = new Letter("B", 3, 2);
		this.pawn[3] = new Letter("C", 3, 2);
		this.pawn[4] = new Letter("D", 2, 3);
		this.pawn[5] = new Letter("E", 1, 15);
		this.pawn[6] = new Letter("F", 4, 2);
		this.pawn[7] = new Letter("G", 2, 2);
		this.pawn[8] = new Letter("H", 4, 2);
		this.pawn[9] = new Letter("I", 1, 8);
		this.pawn[10] = new Letter("J", 8, 1);
		this.pawn[11] = new Letter("K", 10, 1);
		this.pawn[12] = new Letter("L", 1, 5);
		this.pawn[13] = new Letter("M", 2, 3);
		this.pawn[14] = new Letter("N", 1, 6);
		this.pawn[15] = new Letter("O", 1, 6);
		this.pawn[16] = new Letter("P", 3, 2);
		this.pawn[17] = new Letter("Q", 8, 1);
		this.pawn[18] = new Letter("R", 1, 6);
		this.pawn[19] = new Letter("S", 1, 6);
		this.pawn[20] = new Letter("T", 1, 6);
		this.pawn[21] = new Letter("U", 1, 6);
		this.pawn[22] = new Letter("V", 4, 2);
		this.pawn[23] = new Letter("W", 10, 1);
		this.pawn[24] = new Letter("X", 10, 1);
		this.pawn[25] = new Letter("Y", 10, 1);
		this.pawn[26] = new Letter("Z", 10, 1);


		this.pawn[23].getPoint();
	}




	public void displayPawns() { // Afficher l'alphabet
		for (int i = 0; i < this.pawn.length; i++) {
			System.out.printf(this.pawn[i].info());
			System.out.printf("\r\n");
		}

	}




	public Letter draw() { // Pioche al�atoire
		Random randoml = new Random();
		int n = randoml.nextInt(27);
		while(this.pawn[n].getQty() <= 0){
		n = randoml.nextInt(27);	
	}
		Letter draw = this.pawn[n];
		this.pawn[n].decQty();
		return draw;
	}




	public int remainingPawns() {
		int remainingPawns = 0;
		for (int i = 0; i < this.pawn.length; i++) {
			remainingPawns += this.pawn[i].getQty();
		}
		return remainingPawns;
	}





	public int returnCaseIndice(String wordLetter){

		int i;

		for (i=0;i<26;i++){

			this.caseLetter = this.pawn[i].getAlpha();

		   	if (this.caseLetter!=wordLetter){
		   		this.caseIndice = i;
		   	}
		}

		return this.caseIndice;
	}





	public int returnPoint() {

		int i = this.caseIndice;

		int pointLetter =this.pawn[i].getPoint();

		return pointLetter;
	}
}
