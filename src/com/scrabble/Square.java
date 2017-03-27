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
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
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
 */
public class Square extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -889675045163967544L;
	
	private int wordMultiplier;
	private int letterMultiplier;
	private char content;
	private boolean needOut;
	private Color color;
	
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
		this.content = '\u0000';
		this.color = color;
		
		this.x = x;
		this.y = y;
		
		this.setBackground(this.color);
		this.setBorder(new LineBorder(Color.black, 1));
		this.setLayout(new GridLayout(1,1));
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("test");
				if (Square.this.content != '\u0000')
				System.out.println(Square.this.content);
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

		TransferHandler dnd = new TransferHandler() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 4917754222628905865L;

			@Override
            public boolean canImport(TransferSupport support) {
                if (!support.isDrop()) {
                    return false;
                }
                if (!support.isDataFlavorSupported(new DataFlavor(Letter.class, "Letter"))) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean importData(TransferSupport support) {
                if (!canImport(support)) {
                    return false;
                }

                Transferable tansferable = support.getTransferable();
                Letter letter;
                try {
                    letter = (Letter) tansferable.getTransferData(new DataFlavor(Letter.class, "Letter"));
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
                Square.this.add(letter);
                return true;
            }
        };

        this.setTransferHandler(dnd);
        new MyDropTargetListener(this);
	}

	/**
	 * <h3>Function setSquareContent :</h3><br>
	 * <p>
	 * Allow a char content on the selected square
	 * </p>
	 */
	public void setSquareContent(char content) {
		this.content = content;
	}

	/**
	 * <h3>Function getSquareContent :</h3><br>
	 * <p>
	 * @return the square's content
	 * </p>
	 */
	public char getSquareContent() {
		return this.content;
	}

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
		if (this.content == '\u0000') {
			return false;
		} else {
			this.needOut = true;
			return true;
		}
	}

	/**
	 * <h3>Function SquareIsUsed :</h3>
	 * <p>
	 * return the square content if the needOut variable is true
	 * </p>
	 * 
	 * @return
	 */
	public char SquareIsUsed() {
		if (this.needOut) {
			return this.content;
		} else {
			return '\u0000';
		}
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
			g2.drawString("TRIPLE", 7, 33);
		} else if (this.color.equals(Tray.DW) && (this.y != 7 && this.x != 7)) {
			g2.drawString("MOT", 12, 21);
			g2.drawString("DOUBLE", 4, 33);
		} else if (this.color.equals(Tray.TL)) {
			g2.drawString("LETTRE", 6, 21);
			g2.drawString("TRIPLE", 7, 33);
		} else if (this.color.equals(Tray.DL)) {
			g2.drawString("LETTRE", 6, 21);
			g2.drawString("DOUBLE", 4, 33);
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
