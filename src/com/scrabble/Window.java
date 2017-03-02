package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3015881863463738361L;
	private static final int WIDTH = 900;
	private static final int HEIGHT = 700;
	
	public Window() {
		super("Scrabble");
		this.setIconImage(new ImageIcon("icon16.png").getImage());
	    this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
	    this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel content = new JPanel();
	    content.setLayout(new GridBagLayout());
	    content.setBackground(Color.LIGHT_GRAY);
	    this.setContentPane(content);	    
	}
	
	public void addMenu() {
		GridBagConstraints c = new GridBagConstraints();
		JPanel menu = new JPanel();
		JButton newGame = new JButton("Nouvelle partie");
		c.weightx = 0.2;
		c.weighty = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.insets = new Insets(0,0,10,0);
		menu.add(newGame);
		getContentPane().add(menu, c);
	}
	
	public void addLeftBar() {
		GridBagConstraints c = new GridBagConstraints();
		JPanel leftBar = new JPanel();
		JButton pick = new JButton("Piocher");
		leftBar.add(pick);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 1;
		getContentPane().add(leftBar, c);
	}
	
	public void addTray() {
		GridBagConstraints c = new GridBagConstraints();
		Tray tray = new Tray();
	    GTray squares = new GTray(tray);
		c.weightx = 0.8;
		c.weighty = 1;
	    c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 1;
	    getContentPane().add(squares, c);
	}
	
	public void display() {
		pack();
	    this.setVisible(true);
	}
}