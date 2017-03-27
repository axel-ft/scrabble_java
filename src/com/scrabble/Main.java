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
		Player player1 = new Player();
		fenetre.setPlayingNow(player1);
		fenetre.addTray();
		
		Draw pioche = new Draw();
		//Words word = new Words();
		player1.setHand(pioche);
		fenetre.addPlayerInfo();
		fenetre.addHandPlayer();
		player1.updateHand();
		//System.out.println(word.mot);
		//System.out.println(word.calScore(pioche));
		
		fenetre.display();
	}
}
