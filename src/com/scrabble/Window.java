package com.scrabble;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3015881863463738361L;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 700;
	
	Draw pioche = new Draw();

	public Window() {
		super("Scrabble");
		this.setIconImage(new ImageIcon("icon16.png").getImage());
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel content = new JPanel();
		content.setLayout(new GridBagLayout());
		content.setBackground(Color.LIGHT_GRAY);
		this.setContentPane(content);
	}

	public void addMenu() {
		GridBagConstraints c = new GridBagConstraints();
		JPanel menu = new JPanel();
		menu.setBackground(Color.LIGHT_GRAY);
		JButton newGame = new JButton("Nouvelle partie");
		c.weightx = 0.2;
		c.weighty = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.insets = new Insets(0, 0, 10, 0);
		menu.add(newGame);
		getContentPane().add(menu, c);
	}

	public void addGameButtons() {
		GridBagConstraints c = new GridBagConstraints();
		JPanel leftBar = new JPanel();
		leftBar.setLayout(new BoxLayout(leftBar, BoxLayout.Y_AXIS));
		leftBar.setBackground(Color.LIGHT_GRAY);
		JButton pick = new JButton("Changer mes lettres");
		pick.setAlignmentX(CENTER_ALIGNMENT);
		pick.addActionListener(this);
		leftBar.add(pick);
		
		leftBar.add(Box.createRigidArea(new Dimension(0, 10)));

		JButton validate = new JButton("Valider");
		validate.setAlignmentX(CENTER_ALIGNMENT);
		leftBar.add(validate);
		
		c.weightx = 0.1;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		getContentPane().add(leftBar, c);
	}
	
	public void addHandPlayer(Player player) {
		GridBagConstraints c = new GridBagConstraints();
		GPlayer gplayer = new GPlayer(player);
		gplayer.setBackground(Color.LIGHT_GRAY);
		c.weightx = 0.2;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridheight = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		getContentPane().add(gplayer, c);
	}

	public void actionPerformed(ActionEvent e){
		
		Letter uneLettre = pioche.draw();
		System.out.println(uneLettre.info());
	}

	public void addTray() {
		GridBagConstraints c = new GridBagConstraints();
		Tray tray = new Tray();
		GTray squares = new GTray(tray);
		c.weightx = 0.8;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridheight = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		getContentPane().add(squares, c);
	}

	public void display() {
		pack();
		this.setVisible(true);
	}
}
