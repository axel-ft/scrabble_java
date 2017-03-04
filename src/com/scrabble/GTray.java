package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * All the graphics for the Tray. Created on 3/1/17 and modified on 3/3/17
 * 
 * @author Axel FLOQUET-TRILLOT
 * @version 1.0
 */
public class GTray extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6176490152889300350L;

	/**  Number of ELEMENTS by row or column. */
	private static final int ELEMENTS = 15;

	/**  WIDTH of a square. */
	private static final int WIDTH = 40;

	/**  HEIGHT of a square. */
	private static final int HEIGHT = WIDTH;

	/**  PREFERED_WIDTH for the tray. */
	private static final int PREF_W = ELEMENTS * WIDTH + 2;

	/**  PREFERED_HEIGHT for the tray. */
	private static final int PREF_H = ELEMENTS * HEIGHT + 2;

	/** The list of GSquares. */
	private GSquare[][] squares = new GSquare[15][15];

	/**
	 * Instantiates a new g tray. Fills the squares and colors arrays
	 *
	 * @author Axel FLOQUET-TRILLOT
	 * 
	 * @param tray
	 *            The tray object instantiated for the game
	 * @since 0.1
	 */
	public GTray(Tray tray) {
		this.setLayout(new GridLayout(ELEMENTS, ELEMENTS));
		this.setBorder(new LineBorder(Color.black, 1));
		for (int i = 0; i < ELEMENTS * ELEMENTS; i++) {
			int x = i / ELEMENTS;
			int y = i % ELEMENTS;
			squares[x][y] = new GSquare(x, y, tray);
			this.add(squares[x][y]);
		}
	}

	/**
	 * Gets the preferred width for the tray.
	 *
	 * @return
	 */
	public static int getPREF_W() {
		return PREF_W;
	}

	/**
	 * Gets the preferred height.
	 *
	 * @return
	 */
	public static int getPREF_H() {
		return PREF_H;
	}

	/**
	 * Gets the width of a square.
	 * 
	 * @author Axel Floquet-Trillot
	 * @return
	 * @since 1.0
	 */
	public static int getWIDTH() {
		return WIDTH;
	}

	/**
	 * Gets the height of a square.
	 * 
	 * @author Axel Floquet-Trillot
	 * @return
	 * @since 1.0
	 */
	public static int getHEIGHT() {
		return HEIGHT;
	}

	/**
	 * Gets the g square.
	 *
	 * @param r the r
	 * @param c the c
	 * @return the g square
	 */
	public GSquare getGSquare(int x, int y) {
		return squares[x][y];
	}

	/**
	 * Gets the preferred size.
	 *
	 * @return the preferred size
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}
	
	/**
	 * Paint component.
	 *
	 * @param g the graphics
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.drawRect(0, 0, PREF_W + 2, PREF_H + 2);
	}

	/**
	 * The Class GSquare represents a square of the tray.
	 * 
	 * @author Axel Floquet-Trillot
	 * @since 1.0
	 */
	private class GSquare extends JPanel {

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = -889675045163967544L;
		
		/** The row coordinate of the square */
		private int x;
		
		/** The column coordinate of the square */
		private int y;

		/**
		 * @see javax.swing.JComponent#getPreferredSize()
		 */
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(GTray.getWIDTH(), GTray.getHEIGHT());
		}

		/**
		 * Instantiates a new GSquare using coordinates and the game Tray.
		 *
		 * @param x the row
		 * @param y the column
		 * @param tray the tray used for the game
		 * @author Axel Floquet-Trillot
		 * @since 1.0
		 */
		public GSquare(int x, int y, Tray tray) {
			this.x = x;
			this.y = y;
			this.setBackground(tray.getSpecificSquare(x, y).getColor());
			this.setBorder(new LineBorder(Color.black, 1));

			this.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
				}

				@Override
				public void mousePressed(MouseEvent e) {
					GSquare.this.setBackground(Color.cyan);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					GSquare.this.setBackground(tray.getSpecificSquare(x, y).getColor());
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					if (tray.getSpecificSquare(GSquare.this.x, GSquare.this.y).getSquareContent() != '\u0000')
					System.out.println(tray.getSpecificSquare(GSquare.this.x, GSquare.this.y).getSquareContent());
				}

				@Override
				public void mouseExited(MouseEvent e) {
					GSquare.this.setBackground(tray.getSpecificSquare(x, y).getColor());
				}
			});

		}

		/**
		 * Paint component.
		 *
		 * @param g the graphics
		 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
		 */
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			this.addLabels(g2);
		}

		/**
		 * Adds the labels to the squares depending to their color.
		 *
		 * @author Axel FLOQUET-TRILLOT
		 * @param g2 the g 2
		 * @since 0.2
		 */
		private void addLabels(Graphics2D g2) {
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			Font weblysleek = null;
			try {
				weblysleek = new Font(
						Font.createFont(Font.TRUETYPE_FONT, new File("content/weblysleek.ttf")).getFontName(),
						Font.BOLD, 10);
			} catch (FontFormatException | IOException e1) {
				e1.printStackTrace();
			}

			g2.setFont(weblysleek);
			g2.setColor(Color.black);

			if (this.getBackground().equals(Tray.TW)) {
				g2.drawString("MOT", 9, 18);
				g2.drawString("TRIPLE", 4, 30);
			} else if (this.getBackground().equals(Tray.DW) && (this.y != 7 && this.x != 7)) {
				g2.drawString("MOT", 9, 18);
				g2.drawString("DOUBLE", 1, 30);
			} else if (this.getBackground().equals(Tray.TL)) {
				g2.drawString("LETTRE", 3, 18);
				g2.drawString("TRIPLE", 4, 30);
			} else if (this.getBackground().equals(Tray.DL)) {
				g2.drawString("LETTRE", 3, 18);
				g2.drawString("DOUBLE", 1, 30);
			} else if (this.x == 7 && this.y == 7) {
				try {
					Image img = ImageIO.read(new File("content/star.png"));
					g2.drawImage(img, 3, 3, 34, 34, this);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

	}
}