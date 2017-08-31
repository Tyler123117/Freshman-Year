/**
 * This class holds all of the logic behind converting the numerical values of characters into their
 * word forms. It utilizes a constructor method that then calls the convert method. From there, it assigns
 * the returned value to convertedSentence which is accessible through the getConvertedSentence method.
 * 
 * @author Michael Slaton
 * @version 03/28/2017
 */
public class Converter
{
    private StringBuilder sentence;
    private String convertedSentence;
    
    /**
     * This method constructs an object based on a string that the user sends in. It then calls the
     * convert method to fill the convertedSentence field.
     * 
     * @param String inString: This is the string that is sent in by another class to be converted.
     */
    public Converter(String inString)
    {
        sentence = new StringBuilder(inString);
        convertedSentence = new String(convert(sentence));
    }
    
    /**
     * This method holds all the logic behind converting the numerical forms of numbers into their
     * word forms. It loops through the entire sentence field to see what needs to be changed.
     * 
     * @param StringBuilder inBuilder: This is the string that is sent in to be evaluated and converted.
     * @return New String: This is a reference to a newly consturcted String object that holds the converted
     * sentence.
     */
    public String convert(StringBuilder inBuilder)
    {
        boolean exit = false; //boolean value to end second for loop
        
        // For loop runs through each element of inBuilder to determine what needs to be changed
        for(int i = 0; i < inBuilder.length(); i++)
        {
            /* If statement determines if the character at i is between 0 and 9. If it is, it proceeds. If it
            /* is not, then it checks to see if it is a period and continues from there.
             */
            if(Character.isDigit(inBuilder.charAt(i)) && inBuilder.charAt(i) >= 48 && inBuilder.charAt(i) <= 57)
            {
                /* If statement checks to make sure that the length is greater than one, if it isn't, then it
                 * replaces the current number.
                 */
                if(inBuilder.length() > 1)
                {
                  /* If statement to see where the current i is at. If it is at the 0 or at the length -1, then
                   * it executes special code to make sure it does not go out of array bounds. Otherwise, the 
                   * if statement proceeds to the next if.
                   */
                   if(i != inBuilder.length() - 1 && i != 0)
                   {
                      // If statement checks to make sure that there is not a digit before or after the current number
                       if(!Character.isDigit(inBuilder.charAt(i+1)) && !Character.isDigit(inBuilder.charAt(i-1)))
                       {
                             // Switch statement evaluates inBuilder.charAt(i) to see what it needs to be replaced with
                             switch(inBuilder.charAt(i))
                             {
                                   case '0': 
                                       inBuilder.replace(i, i+1, "zero");
                                       break;
                                   case '1':
                                       inBuilder.replace(i, i+1, "one");
                                       break;
                                   case '2':
                                       inBuilder = inBuilder.replace(i, i+1, "two");
                                       break;
                                   case '3':
                                       inBuilder = inBuilder.replace(i, i+1, "three");
                                       break;
                                   case '4':
                                       inBuilder = inBuilder.replace(i, i+1, "four");
                                       break;
                                   case '5':
                                       inBuilder = inBuilder.replace(i, i+1, "five");
                                       break;
                                   case '6':
                                       inBuilder = inBuilder.replace(i, i+1, "six");
                                       break;
                                   case '7':
                                       inBuilder = inBuilder.replace(i, i+1, "seven");
                                       break;
                                   case '8':
                                       inBuilder = inBuilder.replace(i, i+1, "eight");
                                       break;
                                   case '9':
                                       inBuilder = inBuilder.replace(i, i+1, "nine");
                                       break;
                             }
                      }
                  }
                  
                  // If the current i is equal to 0 and there is not a digit in front of it
                  else if((i == 0 && !Character.isDigit(inBuilder.charAt(i+1))))
                  {
                     // Switch statement evaluates inBuilder.charAt(i) to see what it needs to be replaced and capitalizes it
                     switch(inBuilder.charAt(i))
                     {
                                case '0': 
                                    inBuilder.replace(i, i+1, "Zero");
                                    break;
                                case '1':
                                    inBuilder.replace(i, i+1, "One");
                                    break;
                                case '2':
                                    inBuilder = inBuilder.replace(i, i+1, "Two");
                                    break;
                                case '3':
                                    inBuilder = inBuilder.replace(i, i+1, "Three");
                                    break;
                                case '4':
                                    inBuilder = inBuilder.replace(i, i+1, "Four");
                                    break;
                                case '5':                               
                                    inBuilder = inBuilder.replace(i, i+1, "Five");
                                    break;
                                case '6':
                                    inBuilder = inBuilder.replace(i, i+1, "Six");
                                    break;
                                case '7':
                                    inBuilder = inBuilder.replace(i, i+1, "Seven");
                                    break;
                                case '8':
                                    inBuilder = inBuilder.replace(i, i+1, "Eight");
                                    break;
                                case '9':
                                     inBuilder = inBuilder.replace(i, i+1, "Nine");
                                     break;
                     } 
                  }
                  
                  // If the current i is equal to inBuilder.length -1 and there is not another number in front of it
                  else if(i == inBuilder.length() -1 && !Character.isDigit(inBuilder.charAt(i-1)))
                  {
                     // Switch statement evaluates inBuilder.charAt(i) to see what it needs to be replaced with
                     switch(inBuilder.charAt(i))
                     {
                                case '0': 
                                    inBuilder.replace(i, i+1, "zero");
                                case '1':
                                    inBuilder.replace(i, i+1, "one");
                                    break;
                                case '2':
                                    inBuilder = inBuilder.replace(i, i+1, "two");
                                    break;
                                case '3':
                                    inBuilder = inBuilder.replace(i, i+1, "three");
                                    break;
                                case '4':
                                    inBuilder = inBuilder.replace(i, i+1, "four");
                                    break;
                                case '5':                               
                                    inBuilder = inBuilder.replace(i, i+1, "five");
                                    break;
                                case '6':
                                    inBuilder = inBuilder.replace(i, i+1, "six");
                                    break;
                                case '7':
                                    inBuilder = inBuilder.replace(i, i+1, "seven");
                                    break;
                                case '8':
                                    inBuilder = inBuilder.replace(i, i+1, "eight");
                                    break;
                                case '9':
                                     inBuilder = inBuilder.replace(i, i+1, "nine");
                                     break;
                     }
                  }
                }
                
                else
                {
                    // Switch statement evaluates inBuilder.charAt(i) to see what it needs to be replaced with and capitalizes it
                    switch(inBuilder.charAt(i))
                     {
                                case '0': 
                                    inBuilder.replace(i, i+1, "Zero");
                                case '1':
                                    inBuilder.replace(i, i+1, "One");
                                    break;
                                case '2':
                                    inBuilder = inBuilder.replace(i, i+1, "Two");
                                    break;
                                case '3':
                                    inBuilder = inBuilder.replace(i, i+1, "Three");
                                    break;
                                case '4':
                                    inBuilder = inBuilder.replace(i, i+1, "Four");
                                    break;
                                case '5':                               
                                    inBuilder = inBuilder.replace(i, i+1, "Five");
                                    break;
                                case '6':
                                    inBuilder = inBuilder.replace(i, i+1, "Six");
                                    break;
                                case '7':
                                    inBuilder = inBuilder.replace(i, i+1, "Seven");
                                    break;
                                case '8':
                                    inBuilder = inBuilder.replace(i, i+1, "Eight");
                                    break;
                                case '9':
                                     inBuilder = inBuilder.replace(i, i+1, "Nine");
                                     break;
                    }
                }
            }
            
            /* If a sentence is ended with a period, then it runs a for loop to determine what needs to be replaced 
             * with a capitalized word.
             */
            else if(inBuilder.charAt(i) == '.')
            {
                // For loop runs through each element after the current i
                for(int j = i + 1; j < inBuilder.length(); j++)
                {
                    // If statement assures that the loop should continue to run
                    if(exit == false)
                    {
                        // If statement makes sure that inBuilder.charAt(j) is not a space
                        if(inBuilder.charAt(j) != ' ')
                        {
                            // If statement makes sure that there is not a digit before or after the current number
                            if(!Character.isDigit(inBuilder.charAt(i+1)) && !Character.isDigit(inBuilder.charAt(i-1)))
                            {
                                // Switch statement evaluates inBuilder.charAt(i) to see what it needs to be replaced and capitalizes it
                                switch(inBuilder.charAt(j))
                                {
                                    case '0': 
                                        inBuilder.replace(j, j+1, "Zero");
                                        break;
                                    case '1':
                                        inBuilder.replace(j, j+1, "One");
                                        break;
                                    case '2':
                                        inBuilder = inBuilder.replace(j, j+1, "Two");
                                        break;
                                    case '3':
                                        inBuilder = inBuilder.replace(j, j+1, "Three");
                                        break;
                                    case '4':
                                        inBuilder = inBuilder.replace(j, j+1, "Four");
                                        break;
                                    case '5':                               
                                        inBuilder = inBuilder.replace(j, j+1, "Five");
                                        break;
                                    case '6':
                                        inBuilder = inBuilder.replace(j, j+1, "Six");
                                        break;
                                    case '7':
                                        inBuilder = inBuilder.replace(j, j+1, "Seven");
                                        break;
                                    case '8':
                                        inBuilder = inBuilder.replace(j, j+1, "Eight");
                                        break;
                                    case '9':
                                         inBuilder = inBuilder.replace(j, j+1, "Nine");
                                         break;
                                }
                                
                                // Exits the loop once a number is found
                                exit = true;
                            }
                        }
                    }
                }
            }
        }   
        
        return new String(inBuilder);
    }
    
    /**
     * This method allows for outside classes to access the convertedSentence field.
     * 
     * @return String convertedSentence: This is a the current value of the field convertedSentence.
     */
    public String getConvertedSentence()
    {
        return convertedSentence;
    }
}
