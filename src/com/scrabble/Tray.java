package com.scrabble;

import java.awt.Color;

/**
 * The Class Tray.
 */
public class Tray {
    
    /** The x square coordinate */
    private int x;
    
    /** The y square coordinate */
    private int y;
    
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
                                this.tray[x][y] = new Square(3, 1, TW);
                                break;
                            case 3: case 11:
                                this.tray[x][y] = new Square(1, 2, DL);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                    case 1:
                        switch (y) {
                            case 1: case 13:
                                this.tray[x][y] = new Square(2, 1, DW);
                                break;
                            case 5: case 9:
                                this.tray[x][y] = new Square(1, 3, TL);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                    case 2:
                        switch (y) {
                            case 2: case 12:
                                this.tray[x][y] = new Square(2, 1, DW);
                                break;
                            case 6: case 8:
                                this.tray[x][y] = new Square(1, 2, DL);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                    case 3:
                        switch (y) {
                            case 3: case 11:
                                this.tray[x][y] = new Square(2, 1, DW);
                                break;
                            case 0: case 7: case 14:
                                this.tray[x][y] = new Square(1, 2, DL);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                    case 4:
                        switch (y) {
                            case 4: case 10:
                                this.tray[x][y] = new Square(2, 1, DW);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                    case 5:
                        switch (y) {
                            case 1: case 5: case 9: case 13:
                                this.tray[x][y] = new Square(1, 3, TL);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                    case 6:
                        switch (y) {
                            case 2: case 6: case 8: case 12:
                                this.tray[x][y] = new Square(1, 2, DL);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                    case 7:
                        switch (y) {
                            case 0: case 14:
                                this.tray[x][y] = new Square(3, 1, TW);
                                break;
                            case 3: case 11:
                                this.tray[x][y] = new Square(1, 2, DL);
                                break;
                            case 7:
                            	this.tray[x][y] = new Square(2,1, DW);
                            	break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                    case 8:
                        switch (y) {
                            case 2: case 6: case 8: case 12:
                                this.tray[x][y] = new Square(1, 2, DL);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                    case 9:
                        switch (y) {
                            case 1: case 5: case 9: case 13:
                                this.tray[x][y] = new Square(1, 3, TL);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                    case 10:
                        switch (y) {
                            case 4: case 10:
                                this.tray[x][y] = new Square(2, 1, DW);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                    case 11:
                        switch (y) {
                            case 3: case 11:
                                this.tray[x][y] = new Square(2, 1, DW);
                                break;
                            case 0: case 7: case 14:
                                this.tray[x][y] = new Square(1, 2, DL);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                    case 12:
                        switch (y) {
                            case 2: case 12:
                                this.tray[x][y] = new Square(2, 1, DW);
                                break;
                            case 6: case 8:
                                this.tray[x][y] = new Square(1, 2, DL);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                    case 13:
                        switch (y) {
                            case 1: case 13:
                                this.tray[x][y] = new Square(2, 1, DW);
                                break;
                            case 5: case 9:
                                this.tray[x][y] = new Square(1, 3, TL);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                    case 14:
                        switch (y) {
                            case 0: case 7: case 14:
                                this.tray[x][y] = new Square(3, 1, TW);
                                break;
                            case 3: case 11:
                                this.tray[x][y] = new Square(1, 2, DL);
                                break;
                            default:
                                this.tray[x][y] = new Square(1, 1, STD);
                                break;
                        }
                        break;
                }
            }
        }
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
}