/**
 * @author pault
 */
package com.scrabble;

/**
 * The Class Letter.
 */
public class Letter {
	
	/** The alpha. */
	private char alpha;
	
	/** The point. */
	private int point;
	
	/** The qty. */
	private int qty;

	/**
	 * Instantiates a new letter.
	 */
	public Letter() {
	}

	/**
	 * Instantiates a new letter.
	 *
	 * @param alpha the alpha
	 * @param point the point
	 * @param qty the qty
	 */
	public Letter(char alpha, int point, int qty) {
		this.alpha = alpha;
		this.qty = qty;
		this.point = point;
	}

	/**
	 * Dec qty.
	 */
	public void decQty() {
		this.qty--;
	}

	/**
	 * Gets the alpha.
	 *
	 * @return the alpha
	 */
	public char getAlpha() {
		return this.alpha;
	}

	/**
	 * Gets the point.
	 *
	 * @return the point
	 */
	public int getPoint() {
		return this.point;
	}

	/**
	 * Gets the qty.
	 *
	 * @return the qty
	 */
	public int getQty() {
		return this.qty;
	}
	
	/**
	 * Info.
	 *
	 * @return the string
	 */
	public String info(){
		return this.alpha + "   "  + this.qty + "   " +  this.point;
	}

}
