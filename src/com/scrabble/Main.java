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
		
		Player player1 = new Player();
		fenetre.setPlayingNow(player1);
		player1.setHand(fenetre.getDraw());
		fenetre.addPlayerInfo();
		fenetre.addHandPlayer();
		fenetre.addTurnInfo();
		
		fenetre.display();
	}
}
