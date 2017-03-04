package com.scrabble;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GPlayer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5236598157451041948L;
	
	private static final JLabel votreTour = new JLabel("A vous de jouer");
	
	private Font weblysleek = null;
	private JLabel nameLabel = new JLabel();
	private JLabel timer = new JLabel();

	public GPlayer(Player playing) {
		this.loadFont();
		this.setBackground(null);
		this.setLayout(new GridLayout(3, 1));
		
		votreTour.setFont(weblysleek.deriveFont(20f));
		votreTour.setHorizontalAlignment(JLabel.CENTER);
		votreTour.setVerticalAlignment(JLabel.CENTER);
		this.add(votreTour);
		
		this.nameLabel.setFont(weblysleek);
		this.nameLabel.setText(playing.getPlayerName());
		this.nameLabel.setHorizontalAlignment(JLabel.CENTER);
		this.nameLabel.setVerticalAlignment(JLabel.CENTER);

		this.add(nameLabel);
		
		this.timer.setFont(weblysleek);
		this.timer.setText("timer");
		this.timer.setHorizontalAlignment(JLabel.CENTER);
		this.timer.setVerticalAlignment(JLabel.CENTER);
		this.add(timer);
	}
	
	protected void loadFont () {
		try {
			weblysleek = new Font(
					Font.createFont(Font.TRUETYPE_FONT, new File("content/weblysleek.ttf")).getFontName(),
					Font.BOLD, 30);
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}
	}
}
