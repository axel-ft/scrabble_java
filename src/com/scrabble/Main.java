package com.scrabble;

import java.lang.String;

/**
 * Created by pault on 23/02/2017.
 */
public class Main {
	public static void main(String[] args) {
		Window fenetre = new Window();
		fenetre.addMenu();
		fenetre.addGameButtons();
		fenetre.addTray();
		
		Draw pioche = new Draw();
		//Words word = new Words();
		//pioche.displayPawns();
		Player player1 = new Player();
		player1.getPlayerName();
		System.out.println(pioche.remainingPawns());
		player1.setHand(pioche);
		player1.displayHand();
		System.out.println(pioche.remainingPawns());
		fenetre.addHandPlayer(player1);
		System.out.println(pioche.remainingPawns());
		//System.out.println(word.mots);
		
		fenetre.display();
	}
}
