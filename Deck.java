
/**
 * Write a description of class Deck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Deck
{
    private Card[] deck = new Card[52];
    private int topCard;
    public Deck()
    {
        int value = 0;
        String suit = "";
        String face = "";
        int counter = 0;
        for(int i = 2; i < 15; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                switch(j)
                {
                    case 0:
                        suit = "S";
                        value = i;
                        face = getFace(value);
                        break;
                    case 1:
                        suit = "H";
                        value = i;
                        face = getFace(value);
                        break;
                    case 2:
                        suit = "C";
                        value = i;
                        face = getFace(value);
                        break;
                    case 3:
                        suit = "D";
                        value = i;
                        face = getFace(value);
                        break;
                }
                deck[counter] = new Card(value, suit, face);
                counter++;
            }
        }   
        shuffle();
    }
    
    public Card[] dealPlayer()
    {
        Card [] array = new Card[26];
        for(int i = 0; i < 26; i++)
        {
            array[i] = deck[i];
        }
        return array;
    }
    
    public Card[] dealComputer()
    {
       Card [] array = new Card[26];
       for(int i = 26; i < 52; i++)
       {
           array[i-26] = deck[i];
       } 
       return array;
    }
    
    public Card getTopCard()
    {
        return deck[0];
    }
    
    public void shuffle()
    {
        Random rand = new Random();
        for(int i = 0; i < 1000;i++)
        {
            int swap1 = rand.nextInt(52);
            int swap2 = rand.nextInt(52);
            
            Card temp = deck[swap1];
            deck[swap1] = deck[swap2];
            deck[swap2] = temp;
        } 
    }
    
    private String getFace(int value)
    {
         String face = "";
         if(value > 10)
         {
                switch(value)
                {
                    case 11:
                        face = "J";
                        break;
                    case 12:
                        face = "Q";
                        break;
                    case 13:
                        face = "K";
                        break;
                    case 14:
                        face = "A";
                        break;
                }
         }
         else
         {
             face = Integer.toString(value);
         }
         
         return face;
    }
}
