package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * All the graphics for the Tray.
 * Created on 3/1/17 and modified on 3/1/17
 * 
 * @author Axel FLOQUET-TRILLOT
 * @version 0.4
 */
public class GTray extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6176490152889300350L;
	
	/** WIDTH of a square */
	private static final int WIDTH = 40;
	
	/** HEIGHT of a square */
	private static final int HEIGHT = WIDTH;
	
	/** PREFERED_WIDTH for the tray */
	private static final int PREF_W = 15 * WIDTH + 1;
	
	/** PREFERED_HEIGHT for the tray */
	private static final int PREF_H = 15 * HEIGHT + 1;
	
	/** The squares in a 2D array */
	private Rectangle[][] squares = new Rectangle[15][15];
	
	/** The colors in a 2D array */
	private Color[][] colors = new Color[15][15];

	/**
	 * Instantiates a new g tray.
	 * Fills the squares and colors arrays
	 *
	 * @author Axel FLOQUET-TRILLOT
	 * 
	 * @param tray The tray object instantiated for the game
	 * @since 0.1
	 */
	public GTray(Tray tray) {
		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 15; y++) {
				squares[x][y] = new Rectangle(x * WIDTH, y * HEIGHT, WIDTH, HEIGHT);
				colors[x][y] = tray.getSpecificSquare(x, y).getColor();
			}
		}
	}
	
	/**
	 * Adds the labels to the squares depending to their color.
	 *
	 * @author Axel FLOQUET-TRILLOT
	 * 
	 * @param g2
	 * @since 0.2
	 */
	public void addLabels(Graphics2D g2) {
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		Font roboto = null;
		try {
			roboto = new Font(Font.createFont(Font.TRUETYPE_FONT, new File("weblysleek.ttf")).getFontName(), Font.BOLD,
					10);
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}

		g2.setFont(roboto);

		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 15; y++) {
				if (colors[x][y].equals(new Color(211, 14, 7))) {
					g2.drawString("MOT", y * WIDTH + 10, x * HEIGHT + 18);
					g2.drawString("TRIPLE", y * WIDTH + 5, x * HEIGHT + 30);
				} else if (colors[x][y].equals(new Color(238, 180, 179)) && (x != 7 && y != 7)) {
					g2.drawString("MOT", y * WIDTH + 10, x * HEIGHT + 18);
					g2.drawString("DOUBLE", y * WIDTH + 1, x * HEIGHT + 30);
				} else if (colors[x][y].equals(new Color(48, 192, 240))) {
					g2.drawString("LETTRE", y * WIDTH + 4, x * HEIGHT + 18);
					g2.drawString("TRIPLE", y * WIDTH + 5, x * HEIGHT + 30);
				} else if (colors[x][y].equals(new Color(166, 233, 241))) {
					g2.drawString("LETTRE", y * WIDTH + 4, x * HEIGHT + 18);
					g2.drawString("DOUBLE", y * WIDTH + 1, x * HEIGHT + 30);
				} else if (x == 7 && y == 7) {
					try {
						Image img = ImageIO.read(new File("star.png"));
						g2.drawImage(img, WIDTH * 15 / 2 - 15, HEIGHT * 15 / 2 - 15, WIDTH - 10, HEIGHT - 10, this);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
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
		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 15; y++) {
				g2.setColor(colors[x][y]);
				g2.fill(squares[x][y]);
				g2.setColor(Color.black);
				g2.draw(squares[x][y]);
			}
		}
		
		this.addLabels(g2);
	}
}