package com.scrabble;

import java.lang.String;
import javax.swing.JFrame;
import java.awt.Color; 
import javax.swing.JPanel;

/**
 * Created by pault on 23/02/2017.
 */
public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setUndecorated(false);
	    window.setTitle("Scrabble");
	    window.setSize(700, 700);
	    window.setLocationRelativeTo(null);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setVisible(true);
	    
	    JPanel pane = new JPanel();
	    pane.setBackground(Color.LIGHT_GRAY);        
	    window.setContentPane(pane);
	    
		Draw pioche = new Draw();
		pioche.displayPawns();
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
