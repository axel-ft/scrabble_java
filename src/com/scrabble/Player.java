package com.scrabble;

import java.util.Date;
import java.util.Scanner;

public class Player {

	private static Scanner sc;
	
	public static final int MAXLETTERS = 7;	
	private String name;
	private int score;
	private Letter[] tileSet = new Letter[MAXLETTERS];
	private Date timeByRound;
	private Date remainingTime;
	
	public Player (){
		System.out.println("Veuillir remplir votre pseudo");
		sc = new Scanner(System.in);
		this.name = sc.nextLine();
		this.score = 0;
		
		for (int i=0; i < MAXLETTERS; i++) {
			tileSet[i] = null;
		}
	}
	
	public void setName(String name){
		this.name=name;
	}
	public void getPlayerName(){
		System.out.println("Votre pseudo est " + this.name);
	}
	
	public void getHand(){
		System.out.println("Votre main est "); // A COMPLETER
	}
	
	/**
	 * Gets a specific tile from the player game
	 * 
	 * @author Axel Floquet-Trillot
	 * 
	 * @param i The index of the targeted letter in the player set
	 * @return
	 */
	public Letter getPlayerSpecificTile(int i) {
		if (i < MAXLETTERS) {
			return this.tileSet[i];
		} else {
			return null;
		}
	}
	
	public void setHand(Draw draw) {
		for (int i = 0; i < MAXLETTERS; i++) {
			if(tileSet[i] == null && draw.remainingTiles() > 0) {
				this.tileSet[i] = draw.drawTile();
			}
		}
	}
	
	public void displayHand() {
		System.out.println("Lettre Quantité Points");
		for (int i = 0; i < MAXLETTERS; i++) {
			if(tileSet[i] != null) {
				System.out.println(this.tileSet[i].info());
			}
		}
	}
}