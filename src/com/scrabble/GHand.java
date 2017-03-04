package com.scrabble;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class GHand extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5779496330520012975L;
	private static final int PREF_W = 220;
	private static final int PREF_H = 400;
	private Player playerTargeted;
	private GLetter[] gTiles = new GLetter[7];

	public GHand(Player playerTargeted) {
		this.setLayout(new FlowLayout());
		this.playerTargeted = playerTargeted;
		
		for (int i = 0; i < gTiles.length; i++) {
			gTiles[i] = new GLetter(this.playerTargeted.getPlayerSpecificTile(i));
			this.add(gTiles[i]);
		}
	}

	/**
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}
}
