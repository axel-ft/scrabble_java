package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JPanel;

/**
 * 
 * 
 * Modified by Axel on 3/27/17 : added graphical elements from GLetter class
 */
public class Letter extends JPanel  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2428140169992149810L;
	private String alpha;
	private int point;
	private int qtyInDraw;

	private static final Color SAND = new Color(204, 205, 169);

	public Letter() {
	}

	public Letter(String alpha, int point, int qty) {
		this.alpha = alpha;
		this.qtyInDraw = qty;
		this.point = point;
		
		this.setBackground(null);

		MyDragGestureListener dlistener = new MyDragGestureListener();
        DragSource ds = new DragSource();
        ds.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE, dlistener);
	}

	public void decQtyInDraw() {
		this.qtyInDraw--;
	}
	
	public void addQtyInDraw() {
		this.qtyInDraw++;
	}

	public String getAlpha() {
		return this.alpha;
	}

	public int getPoint() {
		return this.point;
	}

	public int getQtyInDraw() {
		return this.qtyInDraw;
	}
	public String info(){
		return this.alpha + "   "  + this.qtyInDraw + "   " +  this.point;
	}
	
	/**
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Tray.getWIDTH() - 4, Tray.getHEIGHT() - 4);
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
				g2.fillRoundRect(0, 0, Tray.getWIDTH(), Tray.getHEIGHT(), 5, 5);
				g2.setColor(Color.black);
				g2.drawRoundRect(0, 0, 40, 40, 5, 5);
				g2.setFont(weblysleek);
				g2.drawString(this.getAlpha(), 5, 30);
				g2.setFont(weblysleekSmall);
				g2.drawString(String.valueOf(this.getPoint()), 27, 38);
	}
}
