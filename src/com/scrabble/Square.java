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
 * <h1>Created by Valentin on 2/27/17 for the java school project</h1> <br>
 * <p>
 * The Square class goal is to know all about the square selected :
 * </p>
 * <ul>
 * <li>The word multiplier;</li>
 * <li>The letter multiplier;</li>
 * <li>And the content on the square.</li>
 * </ul>
 * <p>
 * Modified by Axel on 3/1/17 : added color attribute
 * Modified by Axel on 3/27/17 : added graphical elements from GSquare class
 * Modified by Axel on 3/28/17 : added updatePlayingNow() and boolean pending
 */
public class Square extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -889675045163967544L;
	
	private int wordMultiplier;
	private int letterMultiplier;
	private Letter content;
	private boolean used;
	private boolean pending = false;
	private Color color;
	private MyDropTargetListener mdtl;
	
	/** The row coordinate of the square */
	private int x;
	
	/** The column coordinate of the square */
	private int y;

	/**
	 * <h2>Constructor</h2><br>
	 * <p>
	 * ... which define attributes for the selected square
	 * 
	 * @param wordMultiplier
	 * @param letterMultiplier
	 *            And set the 'content' variable as null
	 *            </p>
	 */
	public Square(int wordMultiplier, int letterMultiplier, Color color, int x, int y) {

		this.wordMultiplier = wordMultiplier;
		this.letterMultiplier = letterMultiplier;
		this.content = null;
		this.color = color;
		
		this.x = x;
		this.y = y;
		
		this.setBackground(this.color);
		this.setBorder(new LineBorder(Color.black, 1));
		this.setLayout(new GridLayout(1,1));

        this.mdtl = new MyDropTargetListener(this);
	}

	/**
	 * <h3>Function setSquareContent :</h3><br>
	 * <p>
	 * Allow a char content on the selected square
	 * </p>
	 */
	public void setSquareContent(Letter content) {
		this.content = content;
	}
	
	public void cancelContent() {
		this.content = null;
	}
	
	public void setPendingFalse() {
		this.pending = false;
	}
	
	public void setPendingTrue() {
		this.pending = true;
	}
	
	public boolean getPendingState() {
		return this.pending;
	}
	
	public int getXSquare() {
		return this.x;
	}
	
	public int getYSquare() {
		return this.y;
	}
	
	public int getLetterMultiplier() {
		return this.letterMultiplier;
	}
	
	public int getWordMultiplier() {
		return this.wordMultiplier;
	}

	/**
	 * <h3>Function getSquareContent :</h3>
	 * <p>
	 * return the square content if the needOut variable is true
	 *
	 * @return the square's content
	 * </p>
	 */
	public Letter getSquareContent() {
		return this.content;	
	}
	
	/**
	 * <h3>Function getColor :</h3><br>
	 * <p>
	 * Return the color of the square
	 * </p>
	 * 
	 * @return
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * <h3>Function isSquareUsed :</h3><br>
	 * <p>
	 * Boolean test to know if the Square is used, if it's true variable needOut
	 * is true
	 * </p>
	 * 
	 * @return
	 */
	public boolean isSquareUsed() {
		if (this.content == null) {
			return false;
		} else {
			this.used = true;
			return true;
		}
	}
	
	/**
	 * <h3>Function updatePlayingNow :</h3><br>
	 * <p>
	 * Updates the now playing character, method used to delete tile from player when dropped on the tray
	 * </p>
	 * @param tray 
	 * @param playingNow
	 * 
	 * @return
	 */
	public void updatePlayingNowAndTray(Player playingNow, Tray tray) {
		mdtl.updatePlayingNowAndTray(playingNow, tray);
	}

	/**
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Tray.getWIDTH(), Tray.getHEIGHT());
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

		if (this.color.equals(Tray.TW)) {
			g2.drawString("MOT", 12, 21);
			g2.drawString("TRIPLE", 5, 33);
		} else if (this.color.equals(Tray.DW) && (this.y != 7 && this.x != 7)) {
			g2.drawString("MOT", 12, 21);
			g2.drawString("DOUBLE", 2, 33);
		} else if (this.color.equals(Tray.TL)) {
			g2.drawString("LETTRE", 5, 21);
			g2.drawString("TRIPLE", 5, 33);
		} else if (this.color.equals(Tray.DL)) {
			g2.drawString("LETTRE", 5, 21);
			g2.drawString("DOUBLE", 2, 33);
		} else if (this.x == 7 && this.y == 7) {
			try {
				Image img = ImageIO.read(new File("content/star.png"));
				g2.drawImage(img, 6, 6, 34, 34, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
