/* Program Name: Armstrong Number
 * Author Name: Michael Slaton
 * Version Date: 09/23/2016 
 * Purpose: Prompt the user to enter a number or if they would rather generate a random number. If they select a random number,
 * 			it prompts them to enter the max range. After that, both selections will determine if the number is an Armstrong number.
 * 			To figure this out, the program finds the character at each position and then parses them into an integer. From there
 * 			the program cubes each integer and adds them all together to evaluate if the program is Armstrong number.
 */
import java.util.Scanner;
public class ArmStrongNumber {
		public static void main(String [] args){
			Scanner input = new Scanner(System.in);
			
			//Introductory print welcoming the user and asking for input
			System.out.print("Welcome! This program will determine an armstrong number.\nWould you like to enter a number or " +
					"generate a random number?" );
			//Defines strings that account for user input to be used in the if statement
				String userDecision;
				String decisionEnter = "ENTER";
				String decisionRandom = "RANDOM";
				String ProceedDecision = "";
			//Defines strings that will be used to manipulate the number later in the program
				String numberEntered,number1, number2, number3, number4;
			//Defines integers that will be used in the program
				int randomNumber, numberOfDigits,numberLiteral1,numberLiteral2,numberLiteral3,numberLiteral4;
			//Defines boolean variable to be used in program
				boolean isValidInput, isValidNumber;
			//Defines decision structure for user's choices
				do { 
				
				//Prompts user to enter their decision
					System.out.print("\nType enter or random for your decision: ");
					userDecision= input.nextLine();
				
				//Determines what boolean isValidInput equals to be evaluated later by the while statement
					isValidInput = decisionEnter.equals(userDecision.toUpperCase()) || decisionRandom.equals(userDecision.toUpperCase());
			
			//Determines if the user input is enter or random
				if (decisionEnter.equals(userDecision.toUpperCase())){
						
					//Prompts user to enter their number
						System.out.print("What number would you like to enter?: ");
						
						//Do loop to allow user to reenter a value if they enter 
							do{
								//Gets user input for number use would like to enter
									numberEntered = input.next();
								//Evaluates the user value given and finds out how many digits there are
									numberOfDigits = numberEntered.length();
								//Evaluates if the user input is greater than 5 digits or that it isn't a letter for while statement to use later
									isValidNumber = (numberOfDigits > 4) || (numberOfDigits == 1? Character.isLetter(numberEntered.charAt(0)):
								    numberOfDigits == 2? Character.isLetter(numberEntered.charAt(0)) || Character.isLetter(numberEntered.charAt(1)):
									numberOfDigits == 3? Character.isLetter(numberEntered.charAt(0)) || Character.isLetter(numberEntered.charAt(1))
									|| Character.isLetter(numberEntered.charAt(2)): numberOfDigits ==4? Character.isLetter(numberEntered.charAt(0))
									|| Character.isLetter(numberEntered.charAt(1)) || Character.isLetter(numberEntered.charAt(2))
									|| Character.isLetter(numberEntered.charAt(3)):false);
									
							//Switch statement to evaluate what to do based on the number of digits
								switch (numberOfDigits){
								//If there is 1 digit
									case 1: 
									//Prevents user from entering a letter by checking to see if any of characters are letters
										if (Character.isLetter(numberEntered.charAt(0)))
											System.out.print("Do not enter letters. Please try again: ");
										else{
									//Converts the number entered into a integer using the parse method and stores in numberLiteral1
										numberLiteral1 = Integer.parseInt(numberEntered);
									
									//If numberLiteral1 is equal to the integer of numberEntered, then it is an Armstrong number
										if (numberLiteral1 == Integer.parseInt(numberEntered))
											System.out.print("The number " + numberEntered + " is an armstrong number.");
										else 
											System.out.print("The number " + numberEntered + " is not an armstrong number.");
										}
										break;
								//If there is 2 digits
									case 2:
									//Prevents user from entering a letter by checking to see if any of characters are letters
										if (Character.isLetter(numberEntered.charAt(0))||Character.isLetter(numberEntered.charAt(1)))
											System.out.print("Do not enter letters. Please try again: ");
										else{
									//Finds the first digit of the number by finding the substring at the first position 
										number1 = numberEntered.substring(0,1);
									//Converts that substring into an integer using parse method and stores in numberLiteral1
										numberLiteral1 = Integer.parseInt(number1);
									//Squares numberLiteral1
										numberLiteral1= numberLiteral1 * numberLiteral1;
									
									//Finds the second digit of the number by finding the substring at the second position
										number2= numberEntered.substring(1,2);
									//Converts that substring into an integer using parse method and stores in numberLiteral2
										numberLiteral2 = Integer.parseInt(number2);
									//Squares numberLiteral2
										numberLiteral2= numberLiteral2 * numberLiteral2;
									
									//If numberLiteral1's square + numberLiteral2's square is equal to the integer of numberEntered, it is an Armstrong number
										if (numberLiteral1 + numberLiteral2 == Integer.parseInt(numberEntered))
											System.out.print("The number "+ numberEntered + "is an armstrong number.");
										else
											System.out.print("The number " + numberEntered + " is not an armstrong number.");	
										}
										break;
								//If there are 3 digits
									case 3:
									//Prevents user from entering a letter by checking to see if any of characters are letters
										if (Character.isLetter(numberEntered.charAt(0))||Character.isLetter(numberEntered.charAt(1))||
												Character.isLetter(numberEntered.charAt(2)))
											System.out.print("Do not enter letters. Please try again: ");
										else{
									//Finds the first digit of the number by finding the substring at the first position
										number1 = numberEntered.substring(0,1);
									//Converts that substring into an integer using parse method and stores in numberLiteral1
										numberLiteral1 = Integer.parseInt(number1);
									//Cubes numberLiteral1
										numberLiteral1= numberLiteral1 * numberLiteral1 * numberLiteral1;
									
									//Finds the second digit of the number by finding the substring at the second position
										number2= numberEntered.substring(1,2);
									//Converts that substring into an integer using parse method and stores in numberLiteral2
										numberLiteral2 = Integer.parseInt(number2);
									//Cubes numberLiteral2
										numberLiteral2= numberLiteral2 * numberLiteral2 * numberLiteral2;
									
									//Finds the third digit of the number by finding the substring at the third position 
										number3= numberEntered.substring(2,3);
									//Converts that substring into an integer using parse method and stores in numberLiteral3
										numberLiteral3= Integer.parseInt(number3);
									//Cubes numberLiteral3
										numberLiteral3= numberLiteral3 * numberLiteral3 * numberLiteral3;
									
									//If numberLiteral1's cube + numberLiteral2's cube + numberLiteral3's cube equals numberEntered then the number is Armstrong
										if (numberLiteral1 + numberLiteral2 + numberLiteral3== Integer.parseInt(numberEntered))
											System.out.print("The number "+ numberEntered + " is an armstrong number.");
										else
											System.out.print("The number " + numberEntered + " is not an armstrong number.");
										}
										break;
								//If there are 4 digits 
									case 4:
									//Prevents user from entering a letter by checking to see if any of characters are letters
										if (Character.isLetter(numberEntered.charAt(0))||Character.isLetter(numberEntered.charAt(1))||
												Character.isLetter(numberEntered.charAt(2))||Character.isLetter(numberEntered.charAt(3)))
											System.out.print("Do not enter letters. Please try again: ");
										else{
									//Finds the first digit of the number by finding the substring at the first position
										number1 = numberEntered.substring(0,1);
									//Converts that substring into an integer using parse method and stores in numberLiteral1
										numberLiteral1 = Integer.parseInt(number1);
									//Raises numberLiteral1 to the fourth power
										numberLiteral1= numberLiteral1 * numberLiteral1 * numberLiteral1 * numberLiteral1;
										
									//Finds the second digit of the number by finding the substring at the second position
										number2= numberEntered.substring(1,2);
									//Converts that substring into an integer using parse method and stores in numberLiteral2
										numberLiteral2 = Integer.parseInt(number2);
									//Raises numberLiteral2 to the fourth power
										numberLiteral2= numberLiteral2 * numberLiteral2 * numberLiteral2 * numberLiteral2;
										
									//Finds the third digit of the number by finding the substring at the third position
										number3= numberEntered.substring(2,3);
									//Converts that substring into an integer using parse method and stores in numberLiteral3
										numberLiteral3= Integer.parseInt(number3);
									//Raises numberLiteral3 to the fourth power
										numberLiteral3= numberLiteral3 * numberLiteral3 * numberLiteral3 * numberLiteral3;
										
									//Finds the fourth digit of the number by finding the substring at the fourth position
										number4= numberEntered.substring(3,4);
									//Converts that substring into an integer using parse method and stores in numberLiteral4
										numberLiteral4= Integer.parseInt(number4);
									//Raises numberLiteral4 to the fourth power
										numberLiteral4= numberLiteral4 * numberLiteral4 * numberLiteral4 * numberLiteral4;
										
									/*If numberLiteral1's ^ 4 + numberLiteral2's ^ 4 + numberLiteral3's ^ 4 + numberLiteral4's ^ 4
									 equals the number entered, then the number is Armstrong*/			 
										if (numberLiteral1 + numberLiteral2 + numberLiteral3 + numberLiteral4== Integer.parseInt(numberEntered))
											System.out.print("The number "+ numberEntered + " is an armstrong number.");
										else
											System.out.print("The number " + numberEntered + " is not an armstrong number.");
										}
										 break;
								//If the user enters in a value outside of 1-9999, the program prompts the user here. 
									default: 
										System.out.print("The number is not between 1-9999. Please try again: ");
							}
						}while(isValidNumber == true);
							//Goodbye message
								System.out.print("\nGoodbye!");
				}
								
		

				
			else if (decisionRandom.equals(userDecision.toUpperCase())){
				//Do while loop allows for user to decide if they like the random number assigned. Runs again if they do not.
					do{
							//Generates the random number with the max value being from user input
								randomNumber = (int)((Math.random() * 9999)+1);
							//Prompts user if they would like to keep the number chosen or not.
								System.out.print("The number chosen is " + randomNumber + ".\nWould you like to proceed with this value?"+
											"\nEnter Yes or No to decide: ");
								ProceedDecision = input.next(); 
				
				}while("NO".equals(ProceedDecision.toUpperCase()));
				
				//Converts the random number into a string to be evaluated 
					numberEntered= Integer.toString(randomNumber);
				//Finds how many digits are in the program by evaluating length
					numberOfDigits= numberEntered.length();
				//Switch statement decides what to do based on the number of digits
					switch (numberOfDigits){
					//If there is 1 digit
						case 1: 
						//Converts the number entered into a integer using the parse method and stores in numberLiteral1
							numberLiteral1 = Integer.parseInt(numberEntered);
						
						//If numberLiteral1 is equal to the integer of numberEntered, then it is an Armstrong number
							if (numberLiteral1 == Integer.parseInt(numberEntered))
								System.out.print("The number " + numberEntered + " is an armstrong number.");
							else 
								System.out.print("The number " + numberEntered + " is not an armstrong number.");
							
							break;
					//If there is 2 digits
						case 2:
						//Finds the first digit of the number by finding the substring at the first position 
							number1 = numberEntered.substring(0,1);
						//Converts that substring into an integer using parse method and stores in numberLiteral1
							numberLiteral1 = Integer.parseInt(number1);
						//Squares numberLiteral1
							numberLiteral1= numberLiteral1 * numberLiteral1;
						
						//Finds the second digit of the number by finding the substring at the second position
							number2= numberEntered.substring(1,2);
						//Converts that substring into an integer using parse method and stores in numberLiteral2
							numberLiteral2 = Integer.parseInt(number2);
						//Squares numberLiteral2
							numberLiteral2= numberLiteral2*numberLiteral2;
							
						//If numberLiteral1's cube + numberLiteral2's cube is equal to the integer of numberEntered, it is an Armstrong number
							if (numberLiteral1 + numberLiteral2 == Integer.parseInt(numberEntered))
								System.out.print("The number "+ numberEntered + "is an armstrong number.");
							else
								System.out.print("The number " + numberEntered + " is not an armstrong number.");	
							break;
					//If there are 3 digits
						case 3:
						//Finds the first digit of the number by finding the substring at the first position
							number1 = numberEntered.substring(0,1);
						//Converts that substring into an integer using parse method and stores in numberLiteral1
							numberLiteral1 = Integer.parseInt(number1);
						//Cubes numberLiteral1
							numberLiteral1= numberLiteral1 * numberLiteral1 * numberLiteral1;
						
						//Finds the second digit of the number by finding the substring at the second position
							number2= numberEntered.substring(1,2);
						//Converts that substring into an integer using parse method and stores in numberLiteral2
							numberLiteral2 = Integer.parseInt(number2);
						//Cubes numberLiteral2
							numberLiteral2= numberLiteral2 * numberLiteral2 * numberLiteral2;
						
						//Finds the third digit of the number by finding the substring at the third position 
							number3= numberEntered.substring(2,3);
						//Converts that substring into an integer using parse method and stores in numberLiteral3
							numberLiteral3= Integer.parseInt(number3);
						//Cubes numberLiteral3
							numberLiteral3= numberLiteral3 * numberLiteral3 * numberLiteral3;
						
						//If numberLiteral1's cube + numberLiteral2's cube + numberLiteral3's cube equals numberEntered then the number is Armstrong
							if (numberLiteral1 + numberLiteral2 + numberLiteral3== Integer.parseInt(numberEntered))
								System.out.print("The number "+ numberEntered + " is an armstrong number.");
							else
								System.out.print("The number " + numberEntered + " is not an armstrong number.");
							break;
					//If there are 4 digits 
						case 4:
						//Finds the first digit of the number by finding the substring at the first position
							number1 = numberEntered.substring(0,1);
						//Converts that substring into an integer using parse method and stores in numberLiteral1
							numberLiteral1 = Integer.parseInt(number1);
						//Raises numberLiteral1 to the fourth power
							numberLiteral1= numberLiteral1 * numberLiteral1 * numberLiteral1*numberLiteral1;
							
						//Finds the second digit of the number by finding the substring at the second position
							number2= numberEntered.substring(1,2);
						//Converts that substring into an integer using parse method and stores in numberLiteral2
							numberLiteral2 = Integer.parseInt(number2);
						//Raises numberLiteral2 to the fourth power
							numberLiteral2= numberLiteral2 * numberLiteral2 * numberLiteral2 * numberLiteral2;
							
						//Finds the third digit of the number by finding the substring at the third position
							number3= numberEntered.substring(2,3);
						//Converts that substring into an integer using parse method and stores in numberLiteral3
							numberLiteral3= Integer.parseInt(number3);
						//Raises numberLiteral3 to the fourth power
							numberLiteral3= numberLiteral3 * numberLiteral3 * numberLiteral3 * numberLiteral3;
							
						//Finds the fourth digit of the number by finding the substring at the fourth position
							number4= numberEntered.substring(3,4);
						//Converts that substring into an integer using parse method and stores in numberLiteral4
							numberLiteral4= Integer.parseInt(number4);
						//Raises numberLiteral4 to the fourth power
							numberLiteral4= numberLiteral4 * numberLiteral4 * numberLiteral4 * numberLiteral4;
						
						/*If numberLiteral1's ^ 4 + numberLiteral2's ^ 4 + numberLiteral3's ^ 4 + numberLiteral4's ^ 4
						equals the number entered, then the number is Armstrong*/			 	 
							if (numberLiteral1 + numberLiteral2 + numberLiteral3 + numberLiteral4== Integer.parseInt(numberEntered))
								System.out.print("The number "+ numberEntered + " is an armstrong number.");
							else
								System.out.print("The number " + numberEntered + " is not an armstrong number.");
							 break;
				}
		//Goodbye message
			System.out.print("\nGoodbye!");
			}
		//Accounts for when the user does not enter "enter" or "random"
			else
			        
					System.out.print(userDecision + " is not a valid input."); 
			}while(isValidInput==false);
		}
}