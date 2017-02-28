package com.scrabble;

public class Letter {
	private char alpha;
	private int point;
	private int qty;

	public Letter() {
	}

	public Letter(char alpha, int point, int qty) {
		this.alpha = alpha;
		this.qty = qty;
		this.point = point;
	}

	public void decQty() {
		this.qty--;
	}

	public char getAlpha() {
		return this.alpha;
	}

	public int getPoint() {
		return this.point;
	}

	public int getQty() {
		return this.qty;
	}
	public String info(){
		return this.alpha + "   "  + this.qty + "   " +  this.point;
	}

}
