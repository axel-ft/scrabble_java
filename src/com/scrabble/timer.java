package com.scrabble;


// création d un  timer pour chaque tour de jeu 
public class timer{
     
    public static void main(String [] args){
         
        
         //coutdown
        for (int i=60;i>=0;i--) {
            try {
            
                Thread.sleep (1000);
                if	(i==0){
                	System.out.print("vous passez votre tour");
                }
            }
            catch (InterruptedException e) {
                System.out.print("Erreur");
            }
            System.out.print(""+i+" sec ");
        }
    }
}

