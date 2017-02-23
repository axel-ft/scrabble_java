package com.scrabble;

/**
 * Created by pault on 23/02/2017.
 */
public class Player {

            private String playerName;

            public Player(String name) {
                playerName = name;
            }
            public void setName(String name) {
                this.playerName = name;
            }
            public void getName() {
                System.out.println("Votre pseudo est " + this.playerName);
            }
}