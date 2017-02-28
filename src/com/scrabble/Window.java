package com.scrabble;

import javax.swing.JFrame;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3015881863463738361L;
	
	public Window() {
		this.setTitle("Scrabble");
	    this.setSize(700, 700);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    this.setVisible(true);
	}

}
