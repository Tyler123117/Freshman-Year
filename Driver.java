
/*
 * This is the driver that tests all the methods in the MyString class
 * using a looped menu.
 * 
 * @author Michael Slaton
 * @version 03/11/2017
 */
import java.util.*;
public class Driver
{
    public static void main(String[]args)
    {
       // Declariation of variables
       Scanner input = new Scanner(System.in);
       MyString instance; 
       MyString charInstance;
       MyString stringInstance;
       MyString newInstance;
       String userString = " ";
       String sendString = " ";
       char sendChar = ' ';
       char newChar= ' ';
       char choiceChar = ' ';
       int choice = -1;
       int index = 0;
       int secondIndex = 0;
       
      //Project Title
      System.out.println("----------------------------------\n Take Home Test 2: Michael Slaton\n----------------------------------\n");
      // Introductory statement to get the String to use in the program.
      System.out.print("Please enter the string you would like to evaluate: ");
           userString = input.nextLine();
           instance = new MyString(userString);
           
      // While loop runs through the menu until the user inputs 15
       while(choice != 15)
      {
           System.out.print("\n------------\n    Menu\n------------\n\n1.  Char At\n2.  Compare To\n3.  Compare To Ignore Case\n4.  Concat" +
                            "\n5.  Starts with\n6.  Ends With\n7.  Equals\n8.  Equals Ignore Case \n9.  Index Of\n10. Length" +
                            "\n11. Replace\n12. Substring\n13. To Upper Case\n14. To Lower Case\n15. Exit\n\nChoose one: "); 
                choice = input.nextInt();
                
           // Switch statement evaluates the user's choice and determines which method to execute
           switch(choice)
           {
               case 1: // Char At
                System.out.print("\nPlease enter the index you would like to find a character at: ");
                    index = input.nextInt();
                System.out.println("\nThe character at " + index + " is '" + instance.charAt(index) + "'.");
                    break; 
                       
               case 2: // Compare To
                System.out.print("\nPlease enter a string you would like to compare with: ");
                    newInstance = new MyString(nextLine());
                    
                /* If statement determines what to say based on what compareTo sent back
                 * If -1, the current string comes before the new one. If 0, the two are equal. If
                 * 1, then the new string comes before the current on.
                 */
                if(instance.compareTo(newInstance) == -1)
                {
                    System.out.println("\nThe string \"" + instance.toString() + "\" comes before \"" + newInstance.toString() + "\".");
                }
                
                else if(instance.compareTo(newInstance) == 1)
                {
                     System.out.println("\nThe string \"" + newInstance.toString() + "\" comes before \"" + instance.toString() + "\".");
                }
                
                else
                {
                    System.out.println("\nThe two strings are equal.");
                }
                    break;
                
               case 3: // Compare To Ignore Case
                
                System.out.print("\nPlease enter a string you would like to compare with: ");
                    newInstance = new MyString(nextLine());
                    
                /* If statement determines what to say based on what compareToIgnoreCase sent back
                 * If -1, the current string comes before the new one. If 0, the two are equal. If
                 * 1, then the new string comes before the current on.
                 */
                if(instance.compareToIgnoreCase(newInstance) == -1)
                {
                    System.out.println("\nThe string \"" + instance.toString() + "\" comes before \"" + newInstance.toString() + "\".");
                }
                
                else if(instance.compareToIgnoreCase(newInstance) == 1)
                {
                     System.out.println("\nThe string \"" + newInstance.toString() + "\" comes before \"" + instance.toString() + "\".");
                }
                
                else
                {
                    System.out.println("\nThe two strings are equal.");
                }
                    break;
                
               case 4: // Concat
                MyString concatInstance;
                MyString sendInstance;
                System.out.print("\nPlease enter the String that you would like to concat with: ");
                    sendInstance = new MyString(nextLine());
                    concatInstance = instance.concat(sendInstance); 
                System.out.println("\nThe concated string is \"" + concatInstance.toString() + "\".");
                    break;
                    
               case 5: // Starts With
                System.out.print("\nPlease enter the prefix you would like to search for: ");
                    newInstance = new MyString(nextLine());
                System.out.println("\nStarts With \"" + newInstance.toString() + "\": " + instance.startsWith(newInstance));
                    break; 
                
               case 6: //Ends With
                MyString endInstance;
                System.out.print("\nPlease enter the suffix you would like to search for: ");
                    endInstance = new MyString(nextLine());
                System.out.println("\nEnds With \"" + endInstance.toString() + "\": " + instance.endsWith(endInstance));
                    break;
                
               case 7: // Equals
                System.out.print("\nPlease enter the String that you would like to compare: ");
                    newInstance = new MyString(nextLine());
                System.out.println("\nEquality: " + instance.equals(newInstance));
                    break;
                
               case 8: // Equals Ignore Case
                System.out.print("\nPlease enter the String that you would like to compare: ");
                    newInstance = new MyString(nextLine()); 
                System.out.println("\nEquality: " + instance.equalsIgnoreCase(newInstance));          
                    break;
                
               case 9: // Index Of
               System.out.print("\nFind the Index Of, From Index Of," 
                               + " or the Last Index Of? (I, F, or L): ");
                    charInstance = new MyString(input.next());
                    choiceChar = charInstance.charAt(0);
               /* If statement determines if the user would like to use the index of,
                * from index of, or last index of method.
                */
               if(choiceChar == 'i' || choiceChar == 'I')
               {
                    System.out.print("\nPlease enter the character to find the index of: ");
                        charInstance = new MyString(input.next());
                        sendChar = charInstance.charAt(0);
                    System.out.println("\nThe index of " + sendChar + " is at index " + instance.indexOf(sendChar) + ".");
               }
                    
               else if(choiceChar == 'f' || choiceChar == 'F')
               {
                   System.out.print("\nPlease enter the character to find the index of: ");
                       charInstance = new MyString(input.next());
                       sendChar = charInstance.charAt(0); 
                   System.out.print("\nPlease enter the index to start from: ");
                       index = input.nextInt();
                   System.out.println("\nThe index of " + sendChar + " is at index " + instance.indexOf(sendChar, index) + ".");
               }
               
               else if(choiceChar == 'l' || choiceChar == 'L')
               {
                   System.out.print("\nPlease enter the character to find the last index of: ");
                       charInstance = new MyString(input.next());
                       sendChar = charInstance.charAt(0);
                   System.out.println("\nThe last index of " + sendChar + " is at index " + instance.lastIndexOf(sendChar) + ".");
               }
                    
               else
               {
                   System.out.println("\nInvalid input. " + choiceChar + " is not valid. Try I, F, or L.");
               }         
                    break;
                    
               case 10: // Length
                System.out.println("\nThe length is " + instance.length() + ".");
                    break;
                    
               case 11: // Replace
                System.out.print("\nPlease enter the character to be replaced: ");
                    charInstance = new MyString(input.next());
                    sendChar = charInstance.charAt(0);
                System.out.print("\nPlease enter the new character: ");
                    charInstance = new MyString(input.next());
                    newChar = charInstance.charAt(0);
                    System.out.println(newChar + "  " + sendChar);
                    newInstance = instance.replace(sendChar, newChar);
                System.out.println("\nThe String with replacements is \"" + newInstance.toString() + "\"."); 
                    break;
                    
               case 12: // Substring
                System.out.print("\nAre you sending in 1 index, or 2?: ");
                    index = input.nextInt();
                // If statement determines if the user wants to send in 1 index, or 2.
                if(index == 1)
                {
                    System.out.print("\nPlease enter the index to get a substring from: ");
                        index = input.nextInt();
                        newInstance = instance.substring(index);
                    System.out.println("\nThe substring is \"" + newInstance.toString() + "\".");
                }   
                
                else if(index == 2)
                {
                    System.out.print("\nPlease enter the start index to get a substring from: ");
                        index = input.nextInt();
                    System.out.print("\nPlease enter the end index to get a substring from: ");
                        secondIndex = input.nextInt();
                        newInstance = instance.substring(index, secondIndex);
                    System.out.println("\nThe substring is \"" + newInstance.toString() + "\".");
                }
                
                else
                {
                    System.out.println(index + " is not a valid input! Try 1 or 2.");
                }
                    break;
                    
               case 13: // To Upper Case 
                newInstance = instance.toUpperCase();
                System.out.println("\nThe current string to upper case is \"" + newInstance.toString() + "\".");
                    break; 
                    
               case 14: // To Lower Case
                newInstance = instance.toLowerCase();
                System.out.println("\nThe current string to lower case is \"" + newInstance.toString() + "\".");
                    break;
           }
      }    
      
      System.out.print("\nThank you! Goodbye.");
    }
    
    // This method allows for the user to input a string the includes spaces
    public static String nextLine()
    {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
