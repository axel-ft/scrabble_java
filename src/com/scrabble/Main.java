package com.scrabble;

import java.lang.String;

// TODO: Auto-generated Javadoc
/**
 * Created by pault on 23/02/2017.
 */
public class Main {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Window fenetre = new Window();
		fenetre.addMenu();
		fenetre.addTray();
		fenetre.display();
		
		Draw pioche = new Draw();
		//pioche.displayPawns();
		Player player1 = new Player();
		player1.getName();
		System.out.println(pioche.remainingPawns());
		player1.setHand(pioche);
		player1.displayHand();
		System.out.println(pioche.remainingPawns());
		Letter uneLettre = pioche.draw();
		System.out.println(uneLettre.info());
		System.out.println(pioche.remainingPawns());
	}
}
