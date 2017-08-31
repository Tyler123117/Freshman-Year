
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Driver
{
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        Deck instance = new Deck();
        Card [] playerCards = instance.dealPlayer();
        Card [] computerCards = instance.dealComputer();
        int playerScore = 0;
        int playerCount = 0;
        int computerScore = 0;
        int computerCount = 0;
        char choice = 'Y';
        System.out.print("--- Game of War ---\n\nType anything to start: ");
            input.next();
        while(choice == 'Y')
        {
            for(int i = 0; i < 26; i++)
            {
                System.out.println("\nPlayer drew: " + playerCards[i].toString() + "\nComputer Drew: " + computerCards[i].toString());
                
                if(playerCards[i].getValue() == computerCards[i].getValue())
                {
                    if(i != 26 && i != 25)
                    {
                        while(playerCards[i].getValue() == computerCards[i].getValue())
                        {
                            if(i != 26 && i != 25)
                            {
                                System.out.println("The two cards are equal. War!");
                                i++;
                                System.out.println("\nPlayer drew: " + playerCards[i].toString() + "\nComputer Drew: " + computerCards[i].toString());
                                if(playerCards[i].compareTo(computerCards[i])< 0)
                                {
                                    System.out.println("Computer wins!");
                                    computerScore++;
                                }
                                else if(playerCards[i].compareTo(computerCards[i]) > 0)
                                {
                                    System.out.println("Player wins!");
                                    playerScore++;
                                }
                            }
                            else
                            {
                                 System.out.println("Both players ran out of cards. Thus, there is no winner of the war!");
                            }
                        }
                    }
                    else
                    {
                       System.out.println("Both players ran out of cards. Thus, there is no winner of the war!");
                    }
                }
            
                else
                {
                    if(playerCards[i].compareTo(computerCards[i])< 0)
                        {
                            System.out.println("Computer wins!");
                            computerScore++;
                        }
                        else if(playerCards[i].compareTo(computerCards[i]) > 0)
                        {
                            System.out.println("Player wins!");
                            playerScore++;
                        }
                }     
            }
    
            if(playerScore > computerScore)
            {
                System.out.println("\nPlayer wins with " + playerScore + " points.");
                playerCount++;
            }
            else if(playerScore < computerScore)
            {
                System.out.println("\nComputer wins with " + playerScore + " points.");
                computerCount++;
            }
            else
            {
                System.out.println("\nBoth players tied with " + playerScore + " points each.");
            }
            
            System.out.print("\nPlayer Wins: " + playerCount + "\nComputer Wins: " + computerCount + "\n\nWould you like to play again? (Y or N): ");
                choice = input.next().toUpperCase().charAt(0);
                instance.shuffle();
                playerCards = instance.dealPlayer();
                computerCards = instance.dealComputer();
                playerScore = 0;
                computerScore = 0;
        }
        
        System.out.print("\nThank you for playing, goodbye!");
    }
}
   

