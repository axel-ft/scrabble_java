package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Player extends JPanel {

	private static Scanner sc;
	
	public static final int MAXLETTERS = 7;	
	private String name;
	private int score;
	private Letter[] tileSet = new Letter[MAXLETTERS];
	private Date timeByRound;
	private Date remainingTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5236598157451041948L;
	
	private static final JLabel votreTour = new JLabel("A vous de jouer");
	
	private Font weblysleek = null;
	private JLabel nameLabel = new JLabel();
	private JLabel timer = new JLabel();
	
	public Player (){
		System.out.println("Veuillir remplir votre pseudo");
		sc = new Scanner(System.in);
		this.name = sc.nextLine();
		this.score = 0;
		
		for (int i=0; i < MAXLETTERS; i++) {
			tileSet[i] = null;
		}
		
		this.loadFont();
		this.setBackground(null);
		this.setLayout(new GridLayout(3, 1));
		
		votreTour.setFont(weblysleek.deriveFont(20f));
		votreTour.setHorizontalAlignment(JLabel.CENTER);
		votreTour.setVerticalAlignment(JLabel.CENTER);
		this.add(votreTour);
		
		this.nameLabel.setFont(weblysleek);
		this.nameLabel.setText(this.name);
		this.nameLabel.setHorizontalAlignment(JLabel.CENTER);
		this.nameLabel.setVerticalAlignment(JLabel.CENTER);
		this.add(nameLabel);
		
		this.timer.setFont(weblysleek);
		this.timer.setText("timer");
		this.timer.setHorizontalAlignment(JLabel.CENTER);
		this.timer.setVerticalAlignment(JLabel.CENTER);
		this.add(timer);
	}
	
	protected void loadFont () {
		try {
			weblysleek = new Font(
					Font.createFont(Font.TRUETYPE_FONT, new File("content/weblysleek.ttf")).getFontName(),
					Font.BOLD, 30);
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getPlayerName(){
		return this.name;
	}
	
	/**
	 * Gets a specific tile from the player game
	 * 
	 * @author Axel Floquet-Trillot
	 * 
	 * @param i The index of the targeted letter in the player set
	 * @return
	 */
	public Letter getPlayerSpecificTile(int i) {
		if (i < MAXLETTERS) {
			return this.tileSet[i];
		} else {
			return null;
		}
	}
	
	public void setHand(Draw draw) {
		for (int i = 0; i < MAXLETTERS; i++) {
			if(tileSet[i] == null && draw.remainingTiles() > 0) {
				this.tileSet[i] = draw.drawTile();
			}
		}
	}
	
	public void displayHand() {
		System.out.println("Lettre Quantité Points");
		for (int i = 0; i < MAXLETTERS; i++) {
			if(tileSet[i] != null) {
				System.out.println(this.tileSet[i].info());
			}
		}
	}
	
	private JPanel Hand = new JPanel() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5779496330520012975L;
		private static final int PREF_W = 220;
		private static final int PREF_H = 400;

		/**
		 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
		 */
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			this.setLayout(new FlowLayout());
			this.setBackground(Color.LIGHT_GRAY);
				
			for (int i = 0; i < Player.this.tileSet.length; i++) {
				this.add(Player.this.tileSet[i]);
			}
		}
		
		/**
		 * @see javax.swing.JComponent#getPreferredSize()
		 */
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(PREF_W, PREF_H);
		}
	};
	
	public JPanel getHand () {
		return this.Hand;
	}
}