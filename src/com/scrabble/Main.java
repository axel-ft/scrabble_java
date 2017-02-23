package com.scrabble;
import java.util.*;
import java.lang.String;

/**
 * Created by pault on 23/02/2017.
 */
public class Main {

    public static void main(String[] args) {
        Letter lettres = new Letter();
        lettres.displayLettre();
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillir remplir votre pseudo");
        String name = sc.nextLine();
        Player playerName = new Player(name);
        playerName.getName();
        lettres.handPlayer();
    }
    
    
}
