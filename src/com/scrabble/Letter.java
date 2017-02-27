package com.scrabble;

import java.util.Random;

/**
 * Created by pault on 23/02/2017.
 */
public class Letter {

	String[][] letter = new String[27][3];
	String[][] handPlayer = new String[7][4];
	public Letter() {
		this.letter[0] = new String[] { "*", "2", "0" };
		this.letter[1] = new String[] { "a", "9", "1" };
		this.letter[2] = new String[] { "b", "2", "3" };
		this.letter[3] = new String[] { "c", "2", "3" };
		this.letter[4] = new String[] { "d", "3", "2" };
		this.letter[5] = new String[] { "e", "15", "1" };
		this.letter[6] = new String[] { "f", "2", "4" };
		this.letter[7] = new String[] { "g", "2", "2" };
		this.letter[8] = new String[] { "h", "2", "4" };
		this.letter[9] = new String[] { "i", "8", "1" };
		this.letter[10] = new String[] { "j", "1", "8" };
		this.letter[11] = new String[] { "k", "1", "10" };
		this.letter[12] = new String[] { "l", "5", "1" };
		this.letter[13] = new String[] { "m", "3", "2" };
		this.letter[14] = new String[] { "n", "6", "1" };
		this.letter[15] = new String[] { "o", "6", "1" };
		this.letter[16] = new String[] { "p", "2", "3" };
		this.letter[17] = new String[] { "q", "1", "8" };
		this.letter[18] = new String[] { "r", "6", "1" };
		this.letter[19] = new String[] { "s", "6", "1" };
		this.letter[20] = new String[] { "t", "6", "1" };
		this.letter[21] = new String[] { "u", "6", "1" };
		this.letter[22] = new String[] { "v", "2", "4" };
		this.letter[23] = new String[] { "w", "1", "10" };
		this.letter[24] = new String[] { "x", "1", "10" };
		this.letter[25] = new String[] { "y", "1", "10" };
		this.letter[26] = new String[] { "z", "1", "10" };
	}

	public void displayLettre() {
		System.out.println("Alpha  Number  Points");
		for (int i = 0; i < this.letter.length; i++) {
			for (int j = 0; j < this.letter[i].length; j++) {
				System.out.printf(this.letter[i][j] + "       ");
			}
			System.out.printf("\r\n");
		}

	}

	public void LetterHand() {
		Random randoml = new Random();
		for (int r = 0; r < this.handPlayer.length; r++) {
			int n = randoml.nextInt(26) + 1;
			for (int t = 0; t < this.handPlayer[r].length; t++) {
				this.handPlayer[r] = new String[] { this.letter[n][t] };
			}
		}
	}

	public void getHand() {
		System.out.println("Votre Main est : \n");
		System.out.println("Alpha  Number  Points");
		for (int p = 0; p < this.handPlayer.length; p++) {
			for (int i = 0; i < 3; i++) {
				System.out.printf(this.handPlayer[p][i] + "    ");
			}
			System.out.printf("\r\n");
		}
	}

	/*
	 * private void createUIComponents() { // TODO: place custom component
	 * creation code here }
	 */
}
