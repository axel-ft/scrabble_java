package com.scrabble;

import java.io.Serializable;

public class Letter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2428140169992149810L;
	private String alpha;
	private int point;
	private int qtyInDraw;

	public Letter() {
	}

	public Letter(String alpha, int point, int qty) {
		this.alpha = alpha;
		this.qtyInDraw = qty;
		this.point = point;
	}

	public void decQtyInDraw() {
		this.qtyInDraw--;
	}

	public String getAlpha() {
		return this.alpha;
	}

	public int getPoint() {
		return this.point;
	}

	public int getQtyInDraw() {
		return this.qtyInDraw;
	}
	public String info(){
		return this.alpha + "   "  + this.qtyInDraw + "   " +  this.point;
	}

}
