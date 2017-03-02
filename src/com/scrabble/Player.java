package com.scrabble;

import java.util.Date;
import java.util.Scanner;

public class Player{
	
	private static Scanner sc;
	
	public static final int MAXLETTERS = 7;	
	private String name;
	private int score;
	private Letter[] pawnSet = new Letter[MAXLETTERS];
	private Date timeByRound ;
	private Date remainingTime;
	
	public Player (){
		System.out.println("Veuillir remplir votre pseudo");
		sc = new Scanner(System.in);
		this.name = sc.nextLine();
		this.score = 0;
		
		for (int i=0; i < MAXLETTERS; i++) {
			pawnSet[i] = null;
		}
	}
	
	public void setName(String name){
		this.name=name;
	}
	public void getName(){
		System.out.println("Votre pseudo est " + this.name);
	}
	
	public void getHand(){
		System.out.println("Votre main est "); // A COMPLETER
	}
	
	public void setHand(Draw draw) {
		for (int i = 0; i < MAXLETTERS; i++) {
			if(pawnSet[i] == null && draw.remainingPawns() > 0) {
				this.pawnSet[i] = draw.draw();
			}
		}
	}
	
	public void displayHand() {
		System.out.println("Lettre Quantité Points");
		for (int i = 0; i < MAXLETTERS; i++) {
			if(pawnSet[i] != null) {
				System.out.println(this.pawnSet[i].info());
			}
		}
	}
}