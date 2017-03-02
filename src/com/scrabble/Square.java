package com.scrabble;

import java.awt.Color;

/**
 *      <h1>Created by Valentin on 2/27/17 for the java school project</h1> <br>
 * <p>The Square class goal is to know all about the square selected : </p>
 * <ul>
 *     <li>The word multiplier;</li>
 *     <li>The letter multiplier;</li>
 *     <li>And the content on the square.</li>
 * </ul>
 * <p>Modified by Axel on 3/1/17 : added color attribute
 */
public class Square {

    private int wordMultiplier;
    private int letterMultiplier;
    private char content;
    private boolean needOut;
    private Color color;

    /**
     * <h2>Constructor</h2><br><p>... which define attributes for the selected square
     * @param wordMultiplier
     * @param letterMultiplier
     * And set the 'content' variable as null</p>
     */
    public Square(int wordMultiplier, int letterMultiplier, Color color) {

        this.wordMultiplier = wordMultiplier;
        this.letterMultiplier = letterMultiplier;
        this.content = '\u0000';
        this.color = color;
    }

    /**
     * <h3>Function setSquareContent : </h3><br>
     * <p> Allow a char content on the selected square </p>
     */
    public void setSquareContent(char content) {
        this.content = content;
    }

    /**
     * <h3> Function getSquareContent : </h3><br>
     * <p> @return the square's content </p>
     */
    public char getSquareContent(){
        return this.content;
    }


    public Color getColor() {
        return this.color;
    }

    /**
     * <h3> Function isSquareUsed : </h3><br>
     * <p> Boolean test to know if the Square is used, if it's true variable needOut is true </p>
     * @return
     */
    public boolean isSquareUsed(){
        if (this.content=='\u0000'){
            return false;
        }else{
            this.needOut = true;
            return true;
        }
    }

    /**
     * <h3>Function SquareIsUsed :</h3>
     * <p>return the square content if the needOut variable is true</p>
     * @return
     */
    public char SquareIsUsed(){
        if (this.needOut){
            return this.content;
        } else {
            return '\u0000';
        }
    }
}
