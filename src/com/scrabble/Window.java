package com.scrabble;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3015881863463738361L;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 700;
	
	public Window() {
		super("Scrabble");
		this.setIconImage(new ImageIcon("icon16.png").getImage());
	    this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel content = new JPanel();
	    content.setLayout(new BorderLayout());
	    content.setBackground(Color.LIGHT_GRAY);
	    this.setContentPane(content);	    
	}
	
	public void addMenu() {
		JPanel menu = new JPanel();
		JButton newGame = new JButton("Nouvelle partie");
		menu.add(newGame);
		getContentPane().add(menu, BorderLayout.NORTH);
	}
	
	public void addTray() {
		Tray tray = new Tray();
	    GTray squares = new GTray(tray);
	    getContentPane().add(squares, BorderLayout.CENTER);
	}
	
	public void display() {
		pack();
	    this.setVisible(true);
	}
}