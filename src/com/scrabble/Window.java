package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3015881863463738361L;
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 800;
	
	private JPanel content = new JPanel();
	private JPanel menu = new JPanel();
	
	private Draw pioche = new Draw();
	private Tray tray = new Tray();
	private Word word;
	private Player playingNow;
	
	private Font weblysleek = null;
	private JLabel remainingLetters = new JLabel("Lettres restantes : " + pioche.remainingTiles());
	private int lastPoints = -1;
	private String lastWord = null;

	public Window() {
		super("Scrabble");
		this.setIconImage(new ImageIcon("content/icon32.png").getImage());
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.content.setLayout(new GridBagLayout());
		this.content.setBackground(Color.LIGHT_GRAY);
		this.setContentPane(this.content);
		this.loadFont();
	}
	
	protected void loadFont () {
		try {
			weblysleek = new Font(
					Font.createFont(Font.TRUETYPE_FONT, new File("content/weblysleek.ttf")).getFontName(),
					Font.BOLD, 20);
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}
	}

	public Draw getDraw() {
		return this.pioche;
	}
	
	public void addMenu() {
		GridBagConstraints c = new GridBagConstraints();
		this.menu.setBackground(Color.LIGHT_GRAY);
		JButton newGame = new JButton("Nouvelle partie");
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		c.weightx = 0.2;
		c.weighty = 0.15;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.insets = new Insets(0, 0, 10, 0);
		this.menu.add(newGame);
		getContentPane().add(menu, c);
	}

	public void addGameButtons() {
		GridBagConstraints c = new GridBagConstraints();
		JPanel leftBar = new JPanel();
		leftBar.setLayout(new BoxLayout(leftBar, BoxLayout.Y_AXIS));
		leftBar.setBackground(Color.LIGHT_GRAY);
		JButton pick = new JButton("Changer mes lettres");
		pick.setAlignmentX(CENTER_ALIGNMENT);
		pick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tray.isWordInProgress()) playingNow.changeLetters(pioche);
			}
		});
		leftBar.add(pick);
		
		leftBar.add(Box.createRigidArea(new Dimension(0, 10)));

		JButton validate = new JButton("Valider");
		validate.setAlignmentX(CENTER_ALIGNMENT);
		validate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tray.isWordInProgress()) {
					word = new Word(tray);
					tray.wordValidated();
					playingNow.setHand(pioche);
					System.out.println("valider");
					Window.this.update();
				}
				
			}
		});
		leftBar.add(validate);
		
		c.weightx = 0.1;
		c.weighty = 0.25;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 2;
		getContentPane().add(leftBar, c);
	}
	
	public void setPlayingNow(Player playingNow) {
		this.playingNow = playingNow;
		for (int i=0; i < 15; i++) {
			for (int j=0; j < 15; j++) {
				tray.getSpecificSquare(i, j).updatePlayingNowAndTray(playingNow, tray);
			}
		}
	}
	
	public void addPlayerInfo() {
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.2;
		c.weighty = 0.25;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridheight = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		getContentPane().add(this.playingNow, c);
	}
	
	public void addHandPlayer() {
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.2;
		c.weighty = 0.25;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridheight = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		getContentPane().add(playingNow.getHand(), c);
	}
	
	public void addTurnInfo() {
		getContentPane().remove(remainingLetters);
		remainingLetters = new JLabel("Lettres restantes : " + pioche.remainingTiles());
		remainingLetters.setFont(weblysleek);
		remainingLetters.setHorizontalAlignment(JLabel.CENTER);
		remainingLetters.setVerticalAlignment(JLabel.CENTER);
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.2;
		c.weighty = 0.25;
		c.fill = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridheight = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		getContentPane().add(remainingLetters, c);
		if (this.lastPoints != -1 && this.lastWord != null) {
			getContentPane().add(new JLabel("Dernier mot joué : "), c);
			getContentPane().add(new JLabel(lastWord + "pour" + lastPoints), c);
		}			
	}

	public void addTray() {
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.8;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridheight = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		getContentPane().add(tray, c);
	}

	public void display() {
		pack();
		this.setVisible(true);
	}
	
	public void update() {
		this.addTurnInfo();
		this.repaint();
		this.revalidate();
	}
}
