package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

public class GPlayer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5779496330520012975L;
	private static final int PREF_W = 100;
	private static final int PREF_H = 100;
	private Player playerTargeted;
	
	public GPlayer(Player playerTargeted) {
		this.playerTargeted = playerTargeted;
	}
	
	/**
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}
	
	/**
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		Font roboto = null;
		try {
			roboto = new Font(Font.createFont(Font.TRUETYPE_FONT, new File("weblysleek.ttf")).getFontName(), Font.BOLD,
					15);
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}

		g2.setFont(roboto);

		for (int i = 0; i < Player.MAXLETTERS; i++) {
			for (int y = 0; y < 15; y++) {
				g2.setColor(Color.WHITE);
				g2.fillRect(100,100,10,10);
				g2.setColor(Color.black);
				//g2.drawRect(10,10,10,10);
				g2.drawString(playerTargeted.getSpecificTile(i).getAlpha(), 10, 10);
			}
		}
	}
}
