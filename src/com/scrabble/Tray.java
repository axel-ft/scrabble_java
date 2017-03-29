package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * The Class Tray.
 * 
 * Modified by Axel on 3/27/17 : added graphical elements from GTray class
 */
public class Tray extends JPanel{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6176490152889300350L;

	/**  Number of ELEMENTS by row or column. */
	private static final int ELEMENTS = 15;

	/**  WIDTH of a square. */
	private static final int WIDTH = 46;

	/**  HEIGHT of a square. */
	private static final int HEIGHT = WIDTH;

	/**  PREFERED_WIDTH for the tray. */
	private static final int PREF_W = ELEMENTS * WIDTH + 2;

	/**  PREFERED_HEIGHT for the tray. */
	private static final int PREF_H = ELEMENTS * HEIGHT + 2;
    
    /** The x square coordinate */
    private int x;
    
    /** The y square coordinate */
    private int y;
    
    /** The first letter coordinates of a word being placed, -1 if no word is being placed*/
    private int Xorigin, Yorigin;
    
    /** The first letter coordinates of a word being placed, -1 if no word is being placed*/
    private int XLastPlaced, YLastPlaced;
    
    /** The tray. */
    private Square[][] tray = new Square[15][15];
    
	/** Triple Letter color constant */
	public static final Color TL = new Color(48,192,240);
    
    /** Double Letter color constant */
    public static final Color DL = new Color(166,233,241);
    
    /** Triple Word color constant */
    public static final Color TW = new Color(211,14,7);
    
    /** Double Letter color constant */
    public static final Color DW = new Color(238,180,179);
    
    /** Standard square color constant */
    public static final Color STD = new Color(201,209,204);

    /**
     * Instantiates a new tray.
     */
    public Tray() {
        //[line], [column], (word, letter)
        //8 TWS, 24 DLS, 12 TLS, 16 DWS
        for (x=0;x<15;x++) {
            for (y=0;y<15;y++) {
                switch (x) {
                    case 0:
                        switch (y) {
                            case 0: case 7: case 14:
                                this.tray[x][y] = new Square(3, 1, TW, x, y);
                                break;
                            case 3: case 11:
                                this.tray[x][y] = new Square(1, 2, DL, x, y);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                    case 1:
                        switch (y) {
                            case 1: case 13:
                                this.tray[x][y] = new Square(2, 1, DW, x, y);
                                break;
                            case 5: case 9:
                                this.tray[x][y] = new Square(1, 3, TL, x, y);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                    case 2:
                        switch (y) {
                            case 2: case 12:
                                this.tray[x][y] = new Square(2, 1, DW, x, y);
                                break;
                            case 6: case 8:
                                this.tray[x][y] = new Square(1, 2, DL, x, y);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                    case 3:
                        switch (y) {
                            case 3: case 11:
                                this.tray[x][y] = new Square(2, 1, DW, x, y);
                                break;
                            case 0: case 7: case 14:
                                this.tray[x][y] = new Square(1, 2, DL, x, y);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                    case 4:
                        switch (y) {
                            case 4: case 10:
                                this.tray[x][y] = new Square(2, 1, DW, x, y);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                    case 5:
                        switch (y) {
                            case 1: case 5: case 9: case 13:
                                this.tray[x][y] = new Square(1, 3, TL, x, y);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                    case 6:
                        switch (y) {
                            case 2: case 6: case 8: case 12:
                                this.tray[x][y] = new Square(1, 2, DL, x, y);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                    case 7:
                        switch (y) {
                            case 0: case 14:
                                this.tray[x][y] = new Square(3, 1, TW, x, y);
                                break;
                            case 3: case 11:
                                this.tray[x][y] = new Square(1, 2, DL, x, y);
                                break;
                            case 7:
                            	this.tray[x][y] = new Square(2,1, DW, x, y);
                            	break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                    case 8:
                        switch (y) {
                            case 2: case 6: case 8: case 12:
                                this.tray[x][y] = new Square(1, 2, DL, x, y);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                    case 9:
                        switch (y) {
                            case 1: case 5: case 9: case 13:
                                this.tray[x][y] = new Square(1, 3, TL, x, y);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                    case 10:
                        switch (y) {
                            case 4: case 10:
                                this.tray[x][y] = new Square(2, 1, DW, x, y);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                    case 11:
                        switch (y) {
                            case 3: case 11:
                                this.tray[x][y] = new Square(2, 1, DW, x, y);
                                break;
                            case 0: case 7: case 14:
                                this.tray[x][y] = new Square(1, 2, DL, x, y);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                    case 12:
                        switch (y) {
                            case 2: case 12:
                                this.tray[x][y] = new Square(2, 1, DW, x, y);
                                break;
                            case 6: case 8:
                                this.tray[x][y] = new Square(1, 2, DL, x, y);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                    case 13:
                        switch (y) {
                            case 1: case 13:
                                this.tray[x][y] = new Square(2, 1, DW, x, y);
                                break;
                            case 5: case 9:
                                this.tray[x][y] = new Square(1, 3, TL, x, y);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                    case 14:
                        switch (y) {
                            case 0: case 7: case 14:
                                this.tray[x][y] = new Square(3, 1, TW, x, y);
                                break;
                            case 3: case 11:
                                this.tray[x][y] = new Square(1, 2, DL, x, y);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD, x, y);
                                break;
                        }
                        break;
                }
            }
        }
        
        this.setLayout(new GridLayout(ELEMENTS, ELEMENTS));
		this.setBorder(new LineBorder(Color.black, 1));
		for (int i = 0; i < ELEMENTS * ELEMENTS; i++) {
			int x = i / ELEMENTS;
			int y = i % ELEMENTS;
			this.add(this.tray[x][y]);
		}
    }
    
    public boolean isWordInProgress() {
    	for (int i=0; i<ELEMENTS; i++) {
    		for (int j=0; j<ELEMENTS; j++) {
    			if (this.tray[i][j].getPendingState()) {
    				this.Xorigin = this.tray[i][j].getXSquare();
    				this.Yorigin = this.tray[i][j].getYSquare();
    				return true;
    			}
    		}
    	}
    	this.Xorigin = -1;
    	this.Yorigin = -1;
    	return false;
    }
    
    public boolean isWordHorizontal() {
    	for (int i=0; i<ELEMENTS; i++) {
    		for (int j=0; j<ELEMENTS; j++) {
    			if (j == 0 && this.tray[i][j].getPendingState() && this.tray[i][j+1].getPendingState()) {
    				return true;
    			}
    			if ((j != 0 && j != ELEMENTS-1) && this.tray[i][j].getPendingState() && (this.tray[i][j+1].getPendingState() || this.tray[i][j-1].getPendingState())) {
    				return true;
    			}
    			if (j == ELEMENTS && this.tray[i][j].getPendingState() && this.tray[i][j-1].getPendingState()) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public boolean isWordVertical() {
    	for (int i=0; i<ELEMENTS; i++) {
    		for (int j=0; j<ELEMENTS; j++) {
    			if (i == 0 && this.tray[i][j].getPendingState() && this.tray[i+1][j].getPendingState()) {
    				return true;
    			}
    			if ((i != 0 && i != ELEMENTS-1) && this.tray[i][j].getPendingState() && (this.tray[i+1][j].getPendingState() || this.tray[i-1][j].getPendingState())) {
    				return true;
    			}
    			if (i == ELEMENTS && this.tray[i][j].getPendingState() && this.tray[i-1][j].getPendingState()) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public void wordValidated() {
    	for (int i=0; i<ELEMENTS; i++) {
    		for (int j=0; j<ELEMENTS; j++) {
    			this.tray[i][j].setPendingFalse();
    		}
    	}
    }
    
    public int getXorigin() {
    	return Xorigin;
    }
    
    public int getYorigin() {
    	return Yorigin;
    }
    
    public void setXLastPlaced(int x) {
    	this.XLastPlaced = x;
    }
    
    public void setYLastPlaced(int y) {
    	this.YLastPlaced = y;
    }

    public int getXLastPlaced() {
    	return this.XLastPlaced;
    }
    
    public int getYLastPlaced() {
    	return this.YLastPlaced;
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
     * Gets a specific square.
     * 
     * @author Axel FLOQUET-TRILLOT
     * 
     * @param x
     * @param y
     * @return the specific square
     */
    public Square getSpecificSquare(int x, int y) {
    	if (x < 15 && y < 15) {
    		return tray[x][y];
    	} else {
    		return null;
    	}
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
}