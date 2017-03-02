package com.scrabble;

import java.util.Arrays;
import java.util.Scanner;

public class Words {
	
	public String mots;

	private String[] words;

	private static Scanner scan;

	public Words()
	{
		System.out.println("Ajouter Votre Mot");
		scan = new Scanner(System.in);
		this.mots = scan.nextLine();
		System.out.println("Votre Mot est " + this.mots);
		this.words = this.mots.split("");
		System.out.println(Arrays.deepToString(this.words));
	}
	
	
	
	public int calScore()
	{
		
		
		
		
	return calScore();
	}

}
