package com.scrabble;

/**
 *      <h1>Created by Valentin on 2/27/17 for the java school project</h1>
 * The Square class goal is to
 *
 */
public class Square {

    private int wordMultiplier;
    private int letterMultiplier;
    private char content;

    /**
     * Constructor which define attributes for the selected square
     * @param wordMultiplier
     * @param letterMultiplier
     * And set the 'content' variable as null
     */
    public Square(int wordMultiplier, int letterMultiplier) {

        this.wordMultiplier = wordMultiplier;
        this.letterMultiplier = letterMultiplier;
        this.content = '\u0000';

    //methode -> inscrit un contenu dans la case
    public void setSquareContent(char content) {
        this.content = content;
    }

    //methode -> retourne le contenu de la case
    public char getSquareContent(){
        return content;
    }

    //methode -> savoir si la case est utilisee
    public boolean isSquareUsed(){
        if (this.content=='\u0000')){
            return false;
        }else{
            return true;
        }
    }
}
