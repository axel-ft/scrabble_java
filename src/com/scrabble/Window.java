package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3015881863463738361L;
	
	public Window() {
		super("Scrabble");
		this.setIconImage(new ImageIcon("icon16.png").getImage());
	    this.setPreferredSize(new Dimension(1000,700));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.LIGHT_GRAY);
	    this.setContentPane(panel);
	    
	    Tray tray = new Tray();
	    GTray square = new GTray(tray);
	    getContentPane().add(square);
	    JLabel TEST = new JLabel("TEST");
	    TEST.setLocation(0, 0);
	    getContentPane().add(TEST);
	    
	    
	    pack();
	    
	    this.setVisible(true);
	}
}
