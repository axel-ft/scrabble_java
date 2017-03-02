package com.scrabble;

public class Letter {
	private String alpha;
	private int point;
	private int qty;

	public Letter() {
	}

	public Letter(String alpha, int point, int qty) {
		this.alpha = alpha;
		this.qty = qty;
		this.point = point;
	}

	public void decQty() {
		this.qty--;
	}

	public String getAlpha() {
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
