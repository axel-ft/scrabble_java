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
	private static final int PREF_W = 220;
	private static final int PREF_H = 400;
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
		Font weblysleek = null;
		Font robotoSmall = null;
		try {
			weblysleek = new Font(Font.createFont(Font.TRUETYPE_FONT, new File("content/weblysleek.ttf")).getFontName(), Font.BOLD,
					35);
			robotoSmall = weblysleek.deriveFont((float) 10);
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < Player.MAXLETTERS; i++) {
			if (i % 2 == 0) {
				g2.setColor(new Color(204, 205, 169));
				g2.fillRect(i * 25 + 8, 10,40,40);
				g2.setColor(Color.black);
				g2.drawRoundRect(i * 25 + 8, 10, 40, 40, 5, 5);
				g2.setFont(weblysleek);
				g2.drawString(playerTargeted.getSpecificTile(i).getAlpha(), i * 25 + 15, 40);
				g2.setFont(robotoSmall);
				g2.drawString(String.valueOf(playerTargeted.getSpecificTile(i).getPoint()), i * 25 + 36, 48);
			} else {
				g2.setColor(new Color(204, 205, 169));
				g2.fillRect(i * 25 + 8, 70,40,40);
				g2.setColor(Color.black);
				g2.drawRoundRect(i * 25 + 8, 70, 40, 40, 5, 5);
				g2.setFont(weblysleek);
				g2.drawString(playerTargeted.getSpecificTile(i).getAlpha(), i * 25 + 15, 100);
				g2.setFont(robotoSmall);
				g2.drawString(String.valueOf(playerTargeted.getSpecificTile(i).getPoint()), i * 25 + 36, 108);
			}
		}
	}
}
