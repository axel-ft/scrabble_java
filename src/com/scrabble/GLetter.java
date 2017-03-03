package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

public class GLetter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3456590007130414843L;

	private static final Color SAND = new Color(204, 205, 169);
	
	private Letter letter;

	/**
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(GTray.getWIDTH() + 1, GTray.getHEIGHT() + 1);
	}

	/**
	 * Instantiates a new GLetter using coordinates and the game Tray.
	 *
	 * @param x
	 *            the row
	 * @param y
	 *            the column
	 * @param tray
	 *            the tray used for the game
	 * @author Axel Floquet-Trillot
	 * @since 1.0
	 */
	public GLetter(Letter letter) {
		this.setBackground(null);
		this.letter = letter;

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(GLetter.this.letter.getAlpha());
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

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
		Font weblysleekSmall = null;
		try {
			weblysleek = new Font(Font.createFont(Font.TRUETYPE_FONT, new File("content/weblysleek.ttf")).getFontName(), Font.BOLD,
					35);
			weblysleekSmall = weblysleek.deriveFont((float) 10);
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}
				g2.setColor(SAND);
				g2.fillRoundRect(0, 0, GTray.getWIDTH(), GTray.getHEIGHT(), 5, 5);
				g2.setColor(Color.black);
				g2.drawRoundRect(0, 0, 40, 40, 5, 5);
				g2.setFont(weblysleek);
				g2.drawString(this.letter.getAlpha(), 5, 30);
				g2.setFont(weblysleekSmall);
				g2.drawString(String.valueOf(this.letter.getPoint()), 30, 38);
	}

}
