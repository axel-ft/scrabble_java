package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
	
	Draw pioche = new Draw();
	private Player playingNow;

	public Window() {
		super("Scrabble");
		this.setIconImage(new ImageIcon("content/icon32.png").getImage());
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.content.setLayout(new GridBagLayout());
		this.content.setBackground(Color.LIGHT_GRAY);
		this.setContentPane(this.content);
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
		c.weighty = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.insets = new Insets(0, 0, 10, 0);
		this.menu.add(newGame);
		getContentPane().add(this.menu, c);
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
				Letter uneLettre = pioche.drawTile();
				System.out.println(uneLettre.info());
			}
		});
		leftBar.add(pick);
		
		leftBar.add(Box.createRigidArea(new Dimension(0, 10)));

		JButton validate = new JButton("Valider");
		validate.setAlignmentX(CENTER_ALIGNMENT);
		validate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		leftBar.add(validate);
		
		c.weightx = 0.1;
		c.weighty = 0.333;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 2;
		getContentPane().add(leftBar, c);
	}
	
	public void setPlayingNow(Player playingNow) {
		this.playingNow = playingNow;
	}
	
	public Player getPlayingNow() {
		return this.playingNow;
	}
	
	public void addPlayerInfo() {
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.2;
		c.weighty = 0.333;
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
		c.weighty = 0.333;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridheight = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		playingNow.displayHand();
		getContentPane().add(playingNow.getHand(), c);
	}

	public void addTray() {
		GridBagConstraints c = new GridBagConstraints();
		Tray tray = new Tray(this);
		c.weightx = 0.8;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridheight = 3;
		c.gridy = 1;
		c.gridwidth = 1;
		getContentPane().add(tray, c);
	}

	public void display() {
		pack();
		this.setVisible(true);
	}
}
