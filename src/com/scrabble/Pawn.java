package com.scrabble;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by pault on 23/02/2017.
 */
public class Letter {

	String[][] letter = new String[27][3];
	String[][] handPlayer = new String[7][3];

	public Letter() {
		this.letter[0] = new String[] { "*", "0", String.valueOf(2)};
		this.letter[1] = new String[] { "a", "1", String.valueOf(9)};
		this.letter[2] = new String[] { "b", "3", String.valueOf(2)};
		this.letter[3] = new String[] { "c", "3", String.valueOf(2)};
		this.letter[4] = new String[] { "d", "2", String.valueOf(2) };
		this.letter[5] = new String[] { "e", "1", String.valueOf(2) };
		this.letter[6] = new String[] { "f", "4", String.valueOf(2)};
		this.letter[7] = new String[] { "g", "2", String.valueOf(2)};
		this.letter[8] = new String[] { "h", "4", String.valueOf(2) };
		this.letter[9] = new String[] { "i", "1", "8" };
		this.letter[10] = new String[] { "j", "8", "1" };
		this.letter[11] = new String[] { "k", "10", "1" };
		this.letter[12] = new String[] { "l", "1", "5" };
		this.letter[13] = new String[] { "m", "2", "3" };
		this.letter[14] = new String[] { "n", "1", "6" };
		this.letter[15] = new String[] { "o", "1", "6" };
		this.letter[16] = new String[] { "p", "3", "2" };
		this.letter[17] = new String[] { "q", "8", "1" };
		this.letter[18] = new String[] { "r", "1", "6" };
		this.letter[19] = new String[] { "s", "1", "6" };
		this.letter[20] = new String[] { "t", "1", "6" };
		this.letter[21] = new String[] { "u", "1", "6" };
		this.letter[22] = new String[] { "v", "4", "2" };
		this.letter[23] = new String[] { "w", "10", "1" };
		this.letter[24] = new String[] { "x", "10", "1" };
		this.letter[25] = new String[] { "y", "10", "1" };
		this.letter[26] = new String[] { "z", "10", "1" };
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

	public String[][] letterHand() {
		Random randoml = new Random();
		for (int r = 0; r < this.handPlayer.length; r++) {
			int n = randoml.nextInt(26) + 1;
			if (this.letter[n][2] > 0){
			for (int t = 0; t < this.handPlayer[r].length; t++) {
				this.handPlayer[r][t] = this.letter[n][t];
			}

			}
		}
		return this.handPlayer;

	}

	public void getHand(String handPlayer[][]) {
		System.out.println("Votre Main est : \n");
		System.out.println("Alpha  Number  Points");
				System.out.println(Arrays.deepToString(this.handPlayer));
		System.out.printf("\r\n");
	}

	/*
	 * private void createUIComponents() { // TODO: place custom component
	 * creation code here }
	 */
}
