package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
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
	
	private JLabel votreTour = new JLabel("A vous de jouer");
	
	private Font weblysleek = null;
	private JLabel nameLabel = new JLabel();
	private JLabel scoreLabel = new JLabel();
	
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
		
		this.updateScoreLabel();
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
	
	public void updateScoreLabel() {
		this.remove(scoreLabel);
		this.scoreLabel.setFont(weblysleek);
		this.scoreLabel.setText(String.valueOf(this.score));
		this.scoreLabel.setHorizontalAlignment(JLabel.CENTER);
		this.scoreLabel.setVerticalAlignment(JLabel.CENTER);
		this.add(scoreLabel);
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getPlayerName(){
		return this.name;
	}
	
	public void addScore(int scoreToAdd) {
		this.score += scoreToAdd;
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
	
	public void removeSpecificTile(Letter letter) {
		int index = -1;
		for (int i=0; i<MAXLETTERS; i++) {
			if (this.tileSet[i] != null && letter.getAlpha().equals(this.tileSet[i].getAlpha()))  {
				index = i;
			}
		}
		if (index<MAXLETTERS && index != -1 && this.tileSet[index] != null) {
			this.tileSet[index] = null;
			this.updateHand();
		}
	}
	
	public void resetTile(Letter letter) {
		for (int i=0; i<MAXLETTERS; i++) {
			if (this.tileSet[i] == null) {
				this.tileSet[i] = letter;
				this.updateHand();
				return;
			}
		}
	}
	
	public void setHand(Draw draw) {
		for (int i = 0; i < MAXLETTERS; i++) {
			if(tileSet[i] == null && draw.remainingTiles() > 0) {
				this.tileSet[i] = draw.drawTile();
			}
		}

		this.updateHand();
	}
	
	private JPanel Hand = new JPanel() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5779496330520012975L;
		private static final int PREF_W = 220;
		private static final int PREF_H = 400;
		
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
	
	public void changeLetters(Draw pioche) {
		for (int i=0; i<this.tileSet.length; i++) {
			if (this.tileSet[i] != null) {
				this.tileSet[i].addQtyInDraw();
				this.tileSet[i] = null;
			}
		}
		this.setHand(pioche);
		this.updateHand();
	}
	
	private void updateHand() {
		this.Hand.removeAll();
		this.Hand.setLayout(new FlowLayout());
		this.Hand.setBackground(Color.LIGHT_GRAY);
			
		for (int i = 0; i < Player.this.tileSet.length; i++) {
			if (this.tileSet[i] != null) this.Hand.add(this.tileSet[i]);
		}
		
		this.Hand.repaint();
		this.Hand.revalidate();
	}
}