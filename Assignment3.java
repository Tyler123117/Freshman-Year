/*Name: Michael Slaton
 *Program Name: Assignment 3
 *Lab Section: 002
 *Purpose: This program is intended to loop through random matrices of values until it has assembled a magic square, which is defined by
 *		   having an equal sum for all of the rows, columns, and diagonals. 
 *Pseudo Code:  1. Welcomes user and asks if they would like to generate a random magic square, or input one themselves
 *					A. If the user chose enter, program calls fillMatrix method and allows user to input values for the array
 *					B. If the user chose random, the program calls fillMatrix method and fills it with unique random integers between 1 and 9
 *				2. Program calls isMagicSquare method to determine if is a magic square or not.
 *					A. isMagicSquare method calls upon:
 *						-sumRow method, which determines if the sums of the rows are equal. If they are, returns the sum, otherwise returns -1.
 *						-sumColumn method, which determines if the sums of the columns are equal. If they are, returns the sum, otherwise returns -1.
 *						-sumDiagonal, which calls upon sumLeftDiag and sumRightDiag, which returns totals from left and right. If they are equal
 *						 then the sumDiagonal method returns their sums, otherwise it returns -1.
 *						-isUnique method, which further assures that the integers in the array are all unique.
 *					B. If these values are all equal to each other, and they're all greater than -1, then the method returns true, otherwise, false.
 *				3. If the isMagicSquare returns:
 *					A. True and it was a random array- calls upon displayMagicSquare array which prints the array
 * 					   and asks if they would like to try again. If they reply 'Y' then the program loops back to step 1.
 * 					B. False and it was a random array- program loops through fillMatrix method until it finds a magic square. 
 * 				       The program then calls displayMagicSquare method and asks the user if they would like to try again.
 * 					   If they reply 'Y' then the program loops back to step 1.
 * 					C. True and it was an entered array- calls upon displayMagicSquare array which prints the array
 *					   and asks if they would like to try again. If they reply 'Y' then the program loops back to step 1.
 *					D. False and it was an entered array- tells user that the array is not a magic square.
 *					   The program then asks if they would like to try again. If they reply 'Y' then the program loops back to step 1.
 *				4. Goodbye statement 
 *				5. Program terminates
 */

import java.util.Scanner;
public class Assignment3 {

	// Main Method
	public static void main(String[] args) {
		// Variable declaration
		Scanner input = new Scanner(System.in);
		int[][] array = new int[3][3];
		char userChoice1 = ' ', userChoice2 = ' ';
		boolean magicSquare;
		// Introductory statement
		System.out.print("Welcome to Magic Square!\n");
		// First do loop allows user to input another value if the original one
		// is not a magic square
		do {
			// Second do loop allows user to input another value if they did not
			// chose a valid input
			do {
				// Prompts the user if they would like to enter an array, or
				// generate a random one
				System.out.print("\nWould you like to input values, or generate a random?\nE or R: ");
				userChoice1 = input.next().toUpperCase().charAt(0);
				if (userChoice1 != 'E' && userChoice1 != 'R')
					System.out.print("\nInvalid input. Please try again.\n");
			} while (userChoice1 != 'E' && userChoice1 != 'R');
			// Sends the declared array and the user's choice to the fillMatrix
			// method to fill it
			array = fillMatrix(array, userChoice1);
			// boolean magic square is filled by the isMagicSqaure method, which
			// determines if the array is a magic square
			magicSquare = isMagicSquare(array);
			// If the user chose random, and the magic square method returned
			// false, then this loops until it generates a magic square
			if (userChoice1 == 'R' && !magicSquare) {
				while (!magicSquare) {
					array = fillMatrix(array, userChoice1);
					magicSquare = isMagicSquare(array);
				}

				displayMagicSquare(array);
				System.out.print("\nWould you like to try again? Y or N: ");
				userChoice2 = input.next().toUpperCase().charAt(0);
			}
			// If userChoice1 is a E and it is not a magic square, this asks the
			// user if they would like to try another array
			else if (userChoice1 == 'E' && !magicSquare) {
				System.out.print("\nThis is not a magic square.\n\nWould you like to try again?\nY or N: ");
				userChoice2 = input.next().toUpperCase().charAt(0);
			}
			// If the array is a magic square, ask the user if they would like
			// to try again
			else if (magicSquare && userChoice1 != 'R') {
				displayMagicSquare(array);
				System.out.print("\nWould you like to try again? Y or N: ");
				userChoice2 = input.next().toUpperCase().charAt(0);
			}
		} while (userChoice2 == 'Y');

		// Goodbye message
		System.out.print("\nGoodbye!");
	}

	// Fill Matrix Method
	public static int[][] fillMatrix(int[][] array, char userChoice) {
		// Declaration of variables
		Scanner input = new Scanner(System.in);
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int random, x = 0;

		// If userChoice equals E, run for loop to fill array
		if (userChoice == 'E') {
			System.out.print("\nEnter 3 values per row, each seperated by a space.\n\n");
			for (int i = 0; i < array.length; i++) {
				System.out.print("Input row " + i + ": ");
				for (int j = 0; j < array[i].length; j++) {
					array[i][j] = input.nextInt();
				}
			}
		}
		// If userChoice equals R, run for loop to fill array
		if (userChoice == 'R') {

			// For loop runs to make sure that it generates all numbers between
			// 1-9 once, with no repeats
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					// While loop runs inside the for loop until a valid number
					// is selected for the array
					while (x == 0) {
						random = (int) ((Math.random() * 9) + 1);
						// For loop runs through all the possible numbers in
						// numbers, if the random is equal to one
						// of them it assigns it to the array position, and
						// replaces the numbers' location with 0
						for (int k = 0; k < numbers.length; k++) {
							if (numbers[k] == random) {
								array[i][j] = random;
								numbers[k] = 0;
								x = 1;
								break;
							}
						}
					}
					x = 0;
				}
			}
		}
		// Returns the newly filled array
		return array;
	}

	// Sum Rows method
	public static int sumRows(int[][] array) {
		// Declare parallel array to hold sums of the rows
		int[] row = new int[array.length];
		// Declare variables to hold totals here
		int total = 0;
		// For loop evaluates that which row to start on
		for (int i = 0; i < array.length; i++) {
			// For loop evaluates which column of the row to evaluate
			for (int j = 0; j < array[i].length; j++) {
				// Adds the number at row/column i,j to total
				row[i] += array[i][j];
			}
		}
		// Initializes the first value of last to row[0]
		int last = row[0];
		// For loop evaluates if the totals of array row are all equal,
		// if they are not, it terminates the loop and returns total = 0
		for (int i = 0; i < row.length; i++) {
			if (row[i] == last)
				total = row[i];
			else {
				total = -1;
				break;
			}
			last = row[i];
		}

		// Returns total of rows
		return total;
	}

	// Sum Columns Method
	public static int sumColumns(int[][] array) {
		// Declaration of variables
		int[] column = new int[array.length];
		int total = 0;

		// For loop adds up all parts of the columns and stores them in column
		// array
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				column[i] += array[j][i];
			}
		}
		// Initializes the first value of last to column[0]
		int last = column[0];

		// For loop evaluates if the totals of array column are all equal,
		// if they are not, it terminates the loop and returns total = 0
		for (int i = 0; i < column.length; i++) {
			if ((column[i] == last) && (last != 0))
				total = column[i];
			else {
				total = -1;
				break;
			}
			last = column[i];
		}
		// Returns total of columns
		return total;
	}

	// Sums the diagonal from the left
	public static int sumLeftDiag(int[][] array) {
		// Declaration of variables
		int[] row = new int[array.length];
		int last = 0, c = 0;
		int total = 0;
		// For loop runs through all parts of the left diagonal and adds them
		// together into total
		for (int i = 0; i < array.length; i++) {
			row[i] += array[i][c];
			total += array[i][c];
			c++;
		}

		// Returns the total of left diagonal
		return total;
	}

	// Sums the diagonal from the right
	public static int sumRightDiag(int[][] array) {
		// Declaration of variables
		int[] row = new int[array.length];
		int last = 0, c = array.length - 1;
		int total = 0;
		// Runs through all parts of the right diagonal and adds them
		// together into total
		for (int i = 0; i < array.length; i++) {
			row[i] += array[i][c];
			total += array[i][c];
			c--;
		}

		// Returns the total of right diagonal
		return total;
	}

	// Compare the two sums and determines if they are equal
	public static int sumDiagonal(int[][] array) {
		// Declaration of variables
		int[] row = new int[array.length];
		int last = 0, c = 0;
		int total1 = sumRightDiag(array), total2 = sumLeftDiag(array);
		int finalTotal = 0;

		// If the totals from the left and right are equal, the final total is
		// equal to
		// their value. Otherwise, the method returns -1
		if (total1 == total2) {
			finalTotal = total1;
		} else {
			finalTotal = -1;
		}
		// Returns the total of the diagonals
		return finalTotal;
	}

	// Makes sure that the array is currently unique
	public static boolean isUnique(int[][] array) {
		boolean isUnique = true;
		// Runs through all values of the array and makes sure that they are
		// unique
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				for (int x = 0; x < array.length; x++) {
					for (int y = 0; y < array[i].length; y++) {
						if (i != x && j != y && array[i][j] == array[x][y])
							return false;
					}
				}
			}
		}
		return isUnique;
	}

	// Displays the array to the user
	public static void displayMagicSquare(int[][] array) {
		// Simple for loop displays all contents of the array to the user
		System.out.println("\nThis is a magic square: \n");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Takes all of the above methods and determines if array is a magic square
	public static boolean isMagicSquare(int[][] array) {
		// If the sums of the columns, rows, and diagonals are all equal and
		// they are unique values, return true. Other wise, return false
		if (sumRows(array) > 0 && sumColumns(array) > 0 && sumDiagonal(array) > 0) {
			if ((sumRows(array) == sumColumns(array)) && (sumDiagonal(array) == sumRows(array)) && isUnique(array))
				return true;
		}
		return false;
	}
}
