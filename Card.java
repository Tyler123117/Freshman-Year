
/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card
{
   private int value;
   private String suit;
   private String face;
   
   public Card(int inValue, String inSuit, String inFace)
   {
       value = inValue;
       suit = inSuit;
       face = inFace;
   }
   
   public int getValue()
   {
       return value;
   }
   
   public String getSuit()
   {
       return suit;
   }
   
   public String getFace()
   {
       return face;
   }
   
   public String toString()
   {
       return face + suit;
   }
   
   public int compareTo(Card other)
   {
       if(this.value > other.value)
       {
           return 1;
       }
       else if(this.value < other.value)
       {
           return -1;
       }
       else
       {
           return 0;
       }
   }
   
   public boolean equals(Card other)
   {
       if(this.suit.equals(other.suit) && this.face.equals(other.face))
       {
           return true;
       }
       else
       {
           return false;
       }
   }
}
