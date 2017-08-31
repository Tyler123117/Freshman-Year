
/**
 * This class holds the methods and fields that allow for a user to manipulate and evaluate various 
 * aspects of Strings. It contains several methods that change the physical string to reflect a new
 * one based on user input. In these instances, the class does not change the physical fields of the
 * object but instead creates a new object to store the mutated value.
 * 
 * @author Michael Slaton
 * @version 03/11/2017
 */
public class MyString
{
   private String originalString;
   private char[] characterArray;
   
   /**
    * This is the default constructor that constructs the original string and character array
    * based on input sent in the form of a string.
    * 
    * @param String inString: The string sent in that sets the values of the fields.
    */
   public MyString(String inString)
   {
       originalString = inString;
       characterArray = originalString.toCharArray();
   }
   
   /**
    * This is the default constructor that constucts the orginal string and character array
    * base on input sent in the form of a character array.
    * 
    * @param char[] inCharArray: The character array sent in that sets the values of the fields.
    */
   public MyString(char[] inCharArray)
   {
       originalString = new String(inCharArray);
       characterArray = originalString.toCharArray();
   }
   
   /**
    * This is the copy constructor that takes in a MyString instance and copies the values
    * to originalString and charaterArray.
    * 
    * @param String inInstance: The MyString instance sent in that is used to copy its values to 
    * the current object's fields.
    */
   public MyString(MyString inInstance)
   {
       originalString = inInstance.originalString;
       characterArray = originalString.toCharArray();
   }
   
   /**
    * This method takes in an index to search for, and returns the character found at that
    * index. 
    * 
    * @param int index: The value sent in for the index to find a character at.
    * @return returnChar: The character that was found at the index sent in.
    */
   public char charAt(int index)
   {
       char returnChar = ' ';
       
       // If statement assures that the index is in the correct range. If it isn't prints an error.
       if(index >= 0 && index <= characterArray.length)
       {
           returnChar = characterArray[index];
       }
       
       else
       {
           System.err.print("Invalid input! Index is out of bounds.");
       }
       return returnChar;
   }
   
   /**
    * This method takes in a MyString instance to compare to the current object. It returns a 
    * integer value based on what lexicographical order the two strings should be in.
    * 
    * @param MyString inInstance: The MyString instance that is sent in to be compared to the current object
    * @return returnInt: The integer returned is based on what order the two strings should be in 
    * lexicographically. If it is -1, then the instance sent in is comes after the current object. If it is
    * 1, then the current object comes after the instance sent in. Lastly, if it is 0, the two instances are
    * equal.
    *   
    */
   public int compareTo(MyString inInstance)
   {
       int returnInt = 0;
       boolean exit = false;
       
       /* If statement determines which instance is longer than the other,
        * thus making sure that the comparison logic does not go beyond
        * the bounds of any character array.
        */
       if(this.characterArray.length > inInstance.characterArray.length)
       {
           // For loop runs through each element of the characterArray to compare the values.
           for(int i = 0; i < inInstance.characterArray.length; i++)
           {
               // If statement determines if the for loop should end or not.
               if(exit == false)
               {
                   /* If statement evaluates if the character at this.characterArray[i]
                    * is greater than the character found at inInstance.characterArray[i].
                    * If it is not, then the it sets returnInt to -1, otherwise it sets 
                    * returnInt to 1.
                    */
                   if(this.characterArray[i] > inInstance.characterArray[i])
                   {
                       returnInt = 1;
                       exit = true;
                   }
                   
                   else if(this.characterArray[i] < inInstance.characterArray[i])
                   {
                       returnInt = -1;
                       exit = true;
                   }  
               }
               
               /* If the returnInt is still equal to 0 after the loop, it should now be
                * 1 since the current characterArray is longer than the instance sent in's
                * characterArray.
                */
               if(returnInt == 0)
               {
                   returnInt = 1; 
               }
           } 
       }

       else if(this.characterArray.length < inInstance.characterArray.length)
       {
           // For loop runs though each element of characterArray to compare the values.
           for(int i = 0;i < this.characterArray.length; i++)
           {
               // If statement evaluates if the loop should end or not.
               if(exit == false)
               {
                   /* If statement evaluates if the character at this.characterArray[i]
                    * is greater than the character found at inInstance.characterArray[i].
                    * If it is not, then the it sets returnInt to -1, otherwise it sets 
                    * returnInt to 1.
                    */
                   if(this.characterArray[i] > inInstance.characterArray[i])
                   {
                       returnInt = 1;
                       exit = true;
                   }
                   
                   else if(this.characterArray[i] < inInstance.characterArray[i])
                   {
                       returnInt = -1;
                       exit = true;
                   }  
               }
               
               /* If the returnInt is still equal to 0 after the loop, it should now be
                * -1 since the current inInstance is longer than the current object's
                * characterArray.
                */
               if(returnInt == 0)
               {
                   returnInt = -1; 
               }
           } 
       }
       
       // Else statement runs when the two arrays are of equal length
       else
       {
           // For loop runs through each element of the characterArray to compare the values.
           for(int i = 0; i < this.characterArray.length; i++)
           {
               // If statement evalutes if the loop should end or not.
               if(exit == false)
               {
                   /* If statement evaluates if the character at this.characterArray[i]
                    * is greater than the character found at inInstance.characterArray[i].
                    * If it is not, then the it sets returnInt to -1, otherwise it sets 
                    * returnInt to 1.
                    */
                   if(this.characterArray[i] > inInstance.characterArray[i])
                   {
                       returnInt = 1;
                       exit = true;
                   }
                   
                   else if(this.characterArray[i] < inInstance.characterArray[i])
                   {
                       returnInt = -1;
                       exit = true;
                   }  
               }
           } 
       } 
       
       return returnInt;  
   }       
    
    /**
    * This method takes in a MyString instance to compare to the current object. It returns a 
    * integer value based on what lexicographical order the two strings should be in. However,
    * it does all of this by ignoring the current case of the letters in each instance.
    * 
    * @param MyString inInstance: The MyString instance that is sent in to be compared to the current object
    * @return returnInt: The integer returned is based on what order the two strings should be in 
    * lexicographically. If it is -1, then the instance sent in is comes after the current object. If it is
    * 1, then the current object comes after the instance sent in. Lastly, if it is 0, the two instances are
    * equal.
    *   
    */
   public int compareToIgnoreCase(MyString inInstance)
   {
       int returnInt = 0;
       boolean exit = false;
       
       MyString newInstance = inInstance.toUpperCase();
       MyString newCharArray = this.toUpperCase();
       
       /* If statement determines which instance is longer than the other,
        * thus making sure that the comparison logic does not go beyond
        * the bounds of any character array.
        */
       if(newCharArray.characterArray.length > newInstance.characterArray.length)
       {
           // For loop runs through each element of the characterArray to compare the values.
           for(int i = 0; i < newInstance.characterArray.length; i++)
           {
              
               // If statement evaluates if the loop should end or not.
               if(exit == false)
               {
                   /* If statement evaluates if the character at this.characterArray[i]
                    * is greater than the character found at inInstance.characterArray[i].
                    * If it is not, then the it sets returnInt to -1, otherwise it sets 
                    * returnInt to 1.
                    */
                   if(newCharArray.characterArray[i] > newInstance.characterArray[i])
                   {
                       returnInt = 1;
                       exit = true;
                   }
                   
                   else if(newCharArray.characterArray[i] < newInstance.characterArray[i])
                   {
                       returnInt = -1;
                       exit = true;
                   }  
               }
               
               /* If the returnInt is still equal to 0 after the loop, it should now be
                * 1 since the current characterArray is longer than the instance sent in's
                * characterArray.
                */
               if(returnInt == 0)
               {
                   returnInt = 1; 
               }
           } 
       }
       
       else if(newCharArray.characterArray.length < newInstance.characterArray.length)
       {
           // For loop runs through each element of the characterArray to compare the values.
           for(int i = 0; i < newCharArray.characterArray.length; i++)
           {
               // If statement evaluates if the loop should end or not.
               if(exit == false)
               {
                   /* If statement evaluates if the character at this.characterArray[i]
                    * is greater than the character found at inInstance.characterArray[i].
                    * If it is not, then the it sets returnInt to -1, otherwise it sets 
                    * returnInt to 1.
                    */
                   if(newCharArray.characterArray[i] > newInstance.characterArray[i])
                   {
                       returnInt = 1;
                       exit = true;
                   }
                   
                   else if(newCharArray.characterArray[i] < newInstance.characterArray[i])
                   {
                       returnInt = -1;
                       exit = true;
                   }  
               }
               
               /* If the returnInt is still equal to 0 after the loop, it should now be
                * -1 since the current inInstance is longer than the current object's
                * characterArray.
                */
               if(returnInt == 0)
               {
                   returnInt = -1; 
               }
           } 
       }
       
       else
       {
           // For loop runs through each element of the characterArray to compare the values.
           for(int i = 0; i < newCharArray.characterArray.length; i++)
           {
               // If statement evaluates if the loop should end or not
               if(exit == false)
               {
                   /* If statement evaluates if the character at this.characterArray[i]
                    * is greater than the character found at inInstance.characterArray[i].
                    * If it is not, then the it sets returnInt to -1, otherwise it sets 
                    * returnInt to 1.
                    */
                   if(newCharArray.characterArray[i] > newInstance.characterArray[i])
                   {
                       returnInt = 1;
                       exit = true;
                   }
                   
                   else if(newCharArray.characterArray[i] < newInstance.characterArray[i])
                   {
                       returnInt = -1;
                       exit = true;
                   }  
               }
           } 
       } 
       
       return returnInt;  
   }
   
   /**
    * This method takes a MyString instance and puts it on the end of the current object's string. 
    * 
    * @param MyString inInstance: This is the MyString instance that will be used to add its characterArray
    * on to the end of the current objects characterArray.
    * @return A New MyString: A new instance of a MyString that is current characterArray with inInstance's character on the end.
    */
   public MyString concat(MyString inInstance)
   {
       /* The length integer is made by adding the length of both characterArrays
        * and is then used to construct a new array.
        */
       int length = this.characterArray.length + inInstance.characterArray.length;
       char[]newArray = new char[length];
       int j = 0;
       
       // For loop runs through each element of newArray.
       for(int i = 0; i < newArray.length; i++)
       {
           /* If statement determines where the for loop is at.
            * If it is below the length of characterArray, it
            * assigns the values of newArray to be that of
            * characterArray. Otherwise, it does the same thing
            * except for inInstance's array.
            */
           if(i < characterArray.length)
           {
               newArray[i] = characterArray[i];
           }
           
           else
           {
               newArray[i] = inInstance.characterArray[j];
               j++;
           }
       }
       
       return new MyString(newArray);
   }
   
   /**
    * This method takes in a character and searches for it in an array and returns the last case of it.
    * 
    * @param char inChar: The character that is searched for in the current characterArray.
    * @return returnInt: The index that the character was found at.
    */
   public int lastIndexOf(char inChar)
   {
       int returnInt = -1; 
       
       // For loop runs through each element of characterArray.
       for(int i = 0; i < characterArray.length; i++)
       {
           /* If statement determines if characterArray[i] is equal to the character sent in.
            * If it is, then it sets returnInt to the current i.
            */
           if(characterArray[i] == inChar)
                returnInt = i;   
       }
       
       return returnInt;
   }
   
   /**
    * This method takes in a character and searches for it in an array and returns the first case of it.
    * 
    * @param char inChar: The character that is searched for in the current characterArray
    * @return returnInt: The index that the character was found at
    */
   public int indexOf(char inChar)
   {
       int returnInt = -1;
       boolean exit = false;
       
       // For loop runs through each element of the characterArray.
       for(int i = 0; i < characterArray.length; i++)
       {
           // If statement determines if the loop should exit or not.
           if(exit == false)
           {
               /* If statement determines if characterArray[i] is equal to the char sent in.
                * If it is, then it sets returnInt to the current i and sets exit to true. 
                */
               if(characterArray[i] == inChar)
               {
                   returnInt = i;
                   exit = true;
               }
           }
       }
       
       return returnInt;
   }
   
   /**
    * This method takes in a character and searches for it in an array and returns the first case of it.
    * However, it does so by starting at the fromIndex that was sent in.
    * 
    * @param char inChar: The character that is searched for in the current characterArray.
    * @param int fromIndex: The integer that is sent in to start the search from.
    * @return returnInt: The index that the character was found at.
    */
   public int indexOf(char inChar, int fromIndex)
   {
       int returnInt = -1;
       boolean exit = false;
       
       //For loop runs through each element of the characterArray starting at the index sent in.
       for(int i = fromIndex; i < characterArray.length; i++)
       {    
           // If statement determines if the loop should exit or not.
           if(exit == false)
            {
               /* If statement determines if characterArray[i] is equal to the char sent in.
                * If it is, then it sets returnInt to the current i and sets exit to true.
                */
               if(characterArray[i] == inChar)
               {
                   returnInt = i;
                   exit = true;
               }
            }
       }
       
       return returnInt;
   }
   
   /**
    * This method returns the length of the current characterArray.
    * 
    * @return int: The current length of the characterArray.
    */
   public int length()
   {
       return characterArray.length;
   }
   
   /**
    * This method takes in two characters, one that is used to determine what should
    * be replaced, and another to stand as the replacement. The program then returns
    * a refernce to a newly constructed MyString Object that replaced the old character 
    * with the new character.
    * 
    * @param char oldChar: Character that will be replaced in the current instance of MyString.
    * @param char newChar: Character that will replace the oldChar in the current instance of MyString.
    * @return New MyString: A reference to a newly constructed MyString object.
    */
   public MyString replace(char oldChar, char newChar) 
   {
       char[] newArray = new char[characterArray.length];
       
       // For loop initializes the values of newArray to the current object's characterArray.
       for(int i = 0; i < characterArray.length; i++)
       {
               newArray[i] = characterArray[i];
       }
       
       // For loop runs through each element of newArray.
       for(int i = 0; i < newArray.length; i++)
       {
           /* If statement determines if newArray[i] is equal to the old character sent in.
            * If it is, then it sets newArray[i] to be the new character sent in.
            */
           if(newArray[i] == oldChar)
           {
               newArray[i] = newChar;
           }
       }
       
       return new MyString(newArray);
   }
 
   /**
    * This method takes in an instance of MyString and evaluates it to the current object to determine
    * if the two objects are equal.
    * 
    * @param MyString inInstance: This is the instance that is sent in to be compared to the current object.
    * @return boolean isEqual: This is the boolean that is manipulated based on if the two objects are equal.
    */
   public boolean equals(MyString inInstance)
   {
       boolean isEqual = false;
       boolean exit = false;
       
       // If statement determines if the two characterArray's are of equal length.
       if(inInstance.characterArray.length == characterArray.length)
       {
           // For loop runs through each element of the current object's characterArray.
           for(int i = 0; i < characterArray.length; i++)
           {    
               // If statement determines if the loop should end.
               if(exit == false)
                {
                   /* If statement determines if two array's character at i are equal.
                    * If the two are equal, it sets isEqual to true. If not, then it
                    * sets isEqual to false and sets exit to true.
                    */
                   if(characterArray[i] == inInstance.characterArray[i])
                   {
                       isEqual = true;
                   }
                   
                   else
                   {
                       isEqual = false;
                       exit = true;
                   }
                }
            }
       }
       
       return isEqual;
   }
       
   /**
    * This method takes in an instance of Mystring and evaluates it to the current object to determine
    * if the two objects are equal. However, it does so by ignoring the cases of letters found within
    * each of the object's character arrays.
    * 
    * @param MyString inInstance: This is the instance that is sent in to be compared to the current object
    * @return boolean isEqual: This is the boolean that is manipulated based on if the two objects are equal
    */
   public boolean equalsIgnoreCase(MyString inInstance)
   {
       // Create new instances for each charArray to compare ignoring case
       MyString newInstance = inInstance.toUpperCase();
       MyString newCharArray = this.toUpperCase();
       boolean isEqual = false;
       boolean exit = false;
       
       // If statement determines if the two characterArray's are of equal length.
       if(newInstance.characterArray.length == newCharArray.characterArray.length)
       {
           // For loop runs through each element of the current object's characterArray.
           for(int i = 0; i < newCharArray.characterArray.length; i++)
           {
               // If statement determines if the loop should end.
               if(exit == false)
               {
                   /* If statement determines if two array's character at i are equal.
                    * If the two are equal, it sets isEqual to true. If not, then it
                    * sets isEqual to false and sets exit to true.
                    */
                   if(newCharArray.characterArray[i] == newInstance.characterArray[i])
                   {
                       isEqual = true;
                   }
                   
                   else
                   {
                       isEqual = false;
                       exit = true;
                   }
                }
            }
       }
       
       return isEqual;
   }
   
   /**
    * This method builds a new String object based on the value of the current characterArray
    * 
    * @return New String: This is a reference to a newly consturcted String object built using the 
    * characerArray field
    */
   public String toString()
   {
       return new String(characterArray);
   }
   
   /**
    * This method takes the current object's characterArray and converts it to a MyString instance
    * where all of the letters found within are convereted to upper case.
    * 
    * @return New MyString: This is a reference to a newly constructed MyString object composed of
    * the object's characterArray with all uppercase letters.
    */
   public MyString toUpperCase()
   {
       int unicode = 0;
       char[] newArray = new char[characterArray.length];
       
       // For loop initializes newArray to the values of characterArray's values
       for(int i = 0; i < characterArray.length; i++)
       {
               newArray[i] = characterArray[i];
       }
       
       // For loop goes through each element of newArray
       for(int i = 0; i < newArray.length; i++)
       {
           unicode = newArray[i];
           
           /* If statement determines if newArray[i] is a lower case letter based on unicode value.
            * If it is, then it subtracts 32 from it to make it an upper case letter.
            * 
            */
           if(unicode >= 97 && unicode <= 122)
           {
               unicode -= 32;
               newArray[i] = (char)unicode;
           }
       }
       
       return new MyString(newArray);
   }
  
   /**
    * This method takes the current object's characterArray and converts it to a MyString instance
    * where all of the letters found within are convereted to upper case.
    * 
    * @return New MyString: This is a reference to a newly constructed MyString object composed of
    * the object's characterArray with all uppercase letters.
    */
   public MyString toLowerCase()
   {
       int unicode = 0;
       char[] newArray = new char[characterArray.length];
       
       // For loop initializes newArray to the values of characterArray's values.
       for(int i = 0; i < characterArray.length; i++)
       {
               newArray[i] = characterArray[i];
       }
       
       // For loop goes through each element of newArray.
       for(int i = 0; i < newArray.length; i++)
       {
           unicode = newArray[i];
           
           /* If statement determines if newArray[i] is a upper case letter based on unicode value.
            * If it is, then it adds 32 from it to make it an lower case letter.
            * 
            */
           if(unicode >= 65 && unicode <= 90)
           {
               unicode += 32;
               newArray[i] = (char)unicode;
           }
       }
       
       return new MyString(newArray);
   }
   
   /**
    * This is the method that takes an integer for the index to start at and builds a MyString
    * instance from that index.
    * 
    * @param int inIndex: This is the index that the method will use to start at when building
    * a new MyString instance
    * @return New MyString: This is a reference to a newly constructed MyString object composed 
    * of the original string starting at the index that was sent in.
    */
   public MyString substring(int inIndex)
   {
       char[]newArray = new char[characterArray.length];
       
       /* For loop goes through each element of characterArray and assings values to newArray
        * based on characterArrays values from the starting index.
        */
       for(int i = 0; inIndex < characterArray.length; inIndex++)
       {
           newArray[i] = characterArray[inIndex];
           i++;
       }
       
       return new MyString(newArray);
   }
   
   /**
    * This is the method that takes an integer for the index to start and another integer to end at.
    * It then builds a new MyString between the two indexes. 
    * 
    * @param int startIndex: This is the index that the method will use to start at when building 
    * a new MyString instance
    * @param int endIndex: This is the index that the method will use to end at when building. It
    * then builds a new MyString between the two indexes. 
    * @return New MyString: This is a reference to a newly constructed MyString object composed 
    * of the original string start at the index that was sent in and ending at the other index 
    * sent in.
    */
   public MyString substring(int startIndex, int endIndex)
   {
       char[]newArray = new char[characterArray.length];
       
       /* For loop goes through each element of characterArray and assings values to newArray
        * based on characterArrays values from the starting index and ending at the end index.
        */
       for(int i = 0; startIndex < endIndex; startIndex++)
       {
           newArray[i] = characterArray[startIndex];
           i++;
       }
       
       return new MyString(newArray);
   }
   
   /**
    * This is the method that determines if the current object's character array ends with the MyString
    * instance that was sent in.
    * 
    * @param MyString inInstance: This is the instance that is sent in to be searched for at the end of the
    * current object's characterArray
    */
   public boolean endsWith(MyString inInstance)
   {
       boolean endsWith = false;
       boolean isNowFalse = false;
       int startIndex = this.characterArray.length - inInstance.characterArray.length;
       int j = 0;
       
       /* If statement determines if inInstance's characterArray.length is the greater than or equal to
        * the current object's characterArray.length.
        */  
       if(this.characterArray.length >= inInstance.characterArray.length)
       {
           // For loop runs through each element of characterArray
           for(int i = startIndex; i < this.characterArray.length; i++)
           {
             /* If statement determines if the two characters are equal.
              * If they are, it continues to the next if statement. If not
              * then it sets isNowFalse to true.
              */
             if( this.characterArray[i] == inInstance.characterArray[j] )
             {
                 /* If statement determines if the isNowFalse is true.
                  * If it is, then it sets endsWith to false.
                  */
                 if(isNowFalse == false)
                 {
                    endsWith = true;
                 }
                 
                 else
                 {
                    endsWith = false;
                 }
                 
             }
             
             else
             {
                 isNowFalse = true;
             }
             j++;
           }   
       }
       
       return endsWith;
   }
   
   /**
    * This is the method that determines if the current object's character array ends with the MyString
    * instance that was sent in.
    * 
    * @param MyString inInstance: This is the instance that is sent in to be searched for at the start of the
    * current object's characterArray.
    */
   public boolean startsWith(MyString inInstance)
   {
       boolean startsWith = false;
       boolean isNowFalse = false;
       
       /* If statement determines if inInstance's characterArray.length is the greater than or equal to
        * the current object's characterArray.length.
        */
       if(this.characterArray.length >= inInstance.characterArray.length)
       {
           // For loop runs through each element of characterArray
           for(int i = 0; i < inInstance.characterArray.length; i++)
           {
               /* If statement determines if the two characters are equal.
                * If they are, it continues to the next if statement. If not
                * then it sets isNowFalse to true.
                */ 
               if( this.characterArray[i] == inInstance.characterArray[i] )
               {
                   /* If statement determines if the isNowFalse is true.
                    * If it is, then it sets endsWith to false.
                    */
                   if(isNowFalse == false)
                   {
                       startsWith = true;
                   }
                     
                   else
                   {
                       startsWith = false;
                   }
                     
               }
                 
               else
               {
                   isNowFalse = true;
               }
           }
       }

       return startsWith;
   }
}