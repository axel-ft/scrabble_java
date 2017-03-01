package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tray {
    private int x;
    private int y;
    private Square[][] tray = new Square[15][15];
    
	public static final Color TL = new Color(48,192,240);
    public static final Color DL = new Color(166,233,241);
    public static final Color TW = new Color(211,14,7);
    public static final Color DW = new Color(238,180,179);
    public static final Color STD = new Color(201,209,204);

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
    
    public Square getSpecificSquare(int x, int y) {
    	if (x < 15 && y < 15) {
    		return tray[x][y];
    	} else {
    		return null;
    	}
    }
}

class GTray extends JPanel {
	private static final long serialVersionUID = 6176490152889300350L;
	private static final int WIDTH = 40;
	private static final int HEIGHT = WIDTH;
	private static final int PREF_W = 15 * 40 + 1;
	private static final int PREF_H = 15 * 40 + 1;
	private Rectangle[][] squares = new Rectangle[15][15];
	private Color[][] colors = new Color[15][15];
	
	public GTray(Tray tray) {
		for (int x = 0; x < 15; x++) {
	    	  for (int y = 0; y < 15; y++) {
	    		  squares[x][y] = new Rectangle(x * WIDTH, y * HEIGHT, WIDTH, HEIGHT);
	    		  colors[x][y] = tray.getSpecificSquare(x, y).getColor();
	      	}
	    }
	}

	@Override
	public Dimension getPreferredSize() {
	      return new Dimension(PREF_W, PREF_H);
	}

	@Override
	protected void paintComponent(Graphics g) {
	   super.paintComponent(g);
	   Graphics2D g2 = (Graphics2D) g;
	   for (int x = 0; x < 15; x++) {
	    	  for (int y = 0; y < 15; y++) {
	    		  g2.setColor(colors[x][y]);
	    		  g2.fill(squares[x][y]);
	    		  g2.setColor(Color.black);
	    		  g2.draw(squares[x][y]);
	      	}
	   }
	   
	  	g2.setFont(new Font("Arial", Font.PLAIN, 9));

	   for (int x = 0; x < 15; x++) {
	    	  for (int y = 0; y < 15; y++) {
	    		  	if (colors[x][y].equals(new Color(211,14,7))) {
	    		  		g2.drawString("MOT", y * WIDTH + 12, x * HEIGHT + 18);
	    		  		g2.drawString("TRIPLE", y * WIDTH + 4 , x * HEIGHT + 30);
	    		  	} else if (colors[x][y].equals(new Color(238,180,179)) && (x != 7 && y != 7)) {
	    		  		g2.drawString("MOT", y * WIDTH + 12, x * HEIGHT + 18);
	    		  		g2.drawString("DOUBLE", y * WIDTH + 1 , x * HEIGHT + 30);
	    		  	} else if (colors[x][y].equals(new Color(48,192,240))) {
	    		  		g2.drawString("LETTRE", y * WIDTH + 4, x * HEIGHT + 18);
	    		  		g2.drawString("TRIPLE", y * WIDTH + 4 , x * HEIGHT + 30);
	    		  	} else if (colors[x][y].equals(new Color(166,233,241))) {
	    		  		g2.drawString("LETTRE", y * WIDTH + 4, x * HEIGHT + 18);
	    		  		g2.drawString("DOUBLE", y * WIDTH + 1 , x * HEIGHT + 30);
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
}