package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	private static final int HEIGHT = 1000;
	
	private JPanel content = new JPanel();
	private JPanel menu = new JPanel();
	private JPanel turnInfo = new JPanel();
	private JPanel leftBar = new JPanel();
	
	private Draw pioche = new Draw();
	private Tray tray = new Tray();
	private Word word;
	private Player playingNow;
	
	private Font weblysleek = null;
	private JLabel remainingLetters = new JLabel("Lettres restantes : " + pioche.remainingTiles());
	private int lastPoints = -1;
	private List<String> lastWords = new ArrayList<>();

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
		leftBar.setLayout(new BoxLayout(leftBar, BoxLayout.Y_AXIS));
		leftBar.setBackground(Color.LIGHT_GRAY);
		JButton pick = new JButton("Changer mes lettres");
		pick.setAlignmentX(CENTER_ALIGNMENT);
		pick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tray.isOneSquarePending() != null) return;
				if (!tray.isWordInProgress()) playingNow.changeLetters(pioche);
			}
		});
		leftBar.add(pick);
		
		leftBar.add(Box.createRigidArea(new Dimension(0, 20)));

		JButton validate = new JButton("Valider");
		validate.setAlignmentX(CENTER_ALIGNMENT);
		validate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tray.isWordInProgress() || tray.isLetterValid()) {
					word = new Word(tray, pioche, playingNow);
					if (word.scanTray()) {
						Window.this.lastPoints = word.getWordScore();
						Window.this.lastWords = word.getWords();
						tray.wordValidated();
						playingNow.setHand(pioche);
						Window.this.update();
						return;
					} else {
						for (int i=0; i<15; i++) {
							for (int j=0; j<15; j++) {
								if (tray.getSpecificSquare(i, j).getPendingState()) {
									playingNow.resetTile(tray.getSpecificSquare(i, j).getSquareContent());
									tray.getSpecificSquare(i, j).getSquareContent().resetDrag();
									tray.getSpecificSquare(i, j).removeAll();
									tray.getSpecificSquare(i, j).cancelContent();
								    tray.getSpecificSquare(i, j).revalidate();
					                tray.getSpecificSquare(i, j).repaint();
					            }
							}
						}
						tray.wordValidated();
						tray.resetPlacing();
						Window.this.update();
						return;
					}
				}
				
			}
		});
		leftBar.add(validate);
		
		leftBar.add(Box.createRigidArea(new Dimension(0, 20)));
		
		JButton cancel = new JButton("Annuler");
		cancel.setAlignmentX(CENTER_ALIGNMENT);
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tray.isWordInProgress() || tray.isOneSquarePending() != null) {
					for (int i=0; i<15; i++) {
						for (int j=0; j<15; j++) {
							if (tray.getSpecificSquare(i, j).getPendingState()) {
								playingNow.resetTile(tray.getSpecificSquare(i, j).getSquareContent());
								tray.getSpecificSquare(i, j).getSquareContent().resetDrag();
								tray.getSpecificSquare(i, j).removeAll();
								tray.getSpecificSquare(i, j).cancelContent();
							    tray.getSpecificSquare(i, j).revalidate();
				                tray.getSpecificSquare(i, j).repaint();
				            }
						}
					}
					tray.wordValidated();
					tray.resetPlacing();
					Window.this.update();
				}
				
			}
		});
		leftBar.add(cancel);
		
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(50, 0, 50, 0);
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
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridheight = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.insets = new Insets(50, 0, 0, 0);
		getContentPane().add(this.playingNow, c);
	}
	
	public void addHandPlayer() {
		getContentPane().remove(playingNow.getHand());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridheight = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		getContentPane().add(playingNow.getHand(), c);
	}
	
	public void addTurnInfo() {
		turnInfo.setBackground(null);
		getContentPane().remove(turnInfo);
		turnInfo.removeAll();
		turnInfo.setLayout(new GridLayout(4, 1));
		remainingLetters = new JLabel("Lettres restantes : " + pioche.remainingTiles());
		remainingLetters.setFont(weblysleek);
		remainingLetters.setHorizontalAlignment(JLabel.CENTER);
		remainingLetters.setVerticalAlignment(JLabel.CENTER);
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridheight = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		turnInfo.add(remainingLetters);
		if (this.lastPoints != -1 && !this.lastWords.isEmpty()) {
			JLabel last = new JLabel("Derniers mots joués : ");
			last.setFont(weblysleek);
			last.setHorizontalAlignment(JLabel.CENTER);
			last.setVerticalAlignment(JLabel.CENTER);
			turnInfo.add(last);
			for (String word: lastWords) {
				JLabel wordLabel = new JLabel(word);
				wordLabel.setFont(weblysleek);
				wordLabel.setHorizontalAlignment(JLabel.CENTER);
				wordLabel.setVerticalAlignment(JLabel.CENTER);
				turnInfo.add(wordLabel);
			}
			JLabel points = new JLabel("Pour " + lastPoints + " points");
			points.setFont(weblysleek);
			points.setHorizontalAlignment(JLabel.CENTER);
			points.setVerticalAlignment(JLabel.CENTER);
			turnInfo.add(points);
		}
		getContentPane().add(turnInfo, c);
	}

	public void addTray() {
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		c.weighty = 0.5;
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
		this.addHandPlayer();
		this.repaint();
		this.revalidate();
	}
}
