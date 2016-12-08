/**@Michael_Slaton
 * Lab_002
 * Assignment4
 * 
 * Purpose: This program gets the user to make a selection from a menu of options, which are as follows: 
 * 			1. Linear Search, 2. Binary Search, 3. Bubble Sort, 4. Selection Sort, 5. Quit. Based on which
 * 			option the user chooses, the program will either reference a set of parallel arrays (options 1-2)
 * 			or will reference a randomly generated array of 10 numbers (option 3-4). The point is to exemplify
 * 			the differences of efficiency between linear/binary searching and bubble/selection sorting. 
 * 
 * Pseudo_code: 1. Generates a random array of 10 integers between 1 and 500 for sorting.
 * 				2. Prints out the menu for the user to chose from.
 * 					- If the user chooses: 
 * 
 * 						1. Linear Search
 * 							A. Ask the user what value they would like to find in the array by using book IDs
 * 							B. Call upon linearSearch method to search through each element of the array until
 * 							   the book ID is found, or there are no more indexes to search.
 * 								- If the value is not found, loop back to A.
 * 							C. Ask the user how many of the book, with the ID just found, they would like to purchase.
 * 							D. Calculate the total that user has due and print it to them.
 * 							E. Loop back to step 2.
 * 
 * 						2. Binary Search
 * 							A. Ask the user what value they would like to find in the array by using book IDs.
 * 							B. Call upon binarySearch method to split the array into low and high, determine
 * 							   which half the search item is, then repeat until the book ID is found or there 
 * 							   are no more indexes to search.
 * 								- If the value is not found, loop back to A.
 * 							C. Ask the user how many of the book, with the ID just found, they would like to purchase.
 * 							D. Calculate the total that user has due and print it to them.
 * 							E. Loop back to step 2.
 * 
 * 						3. Bubble Sort
 * 							A. Print the unsorted random array, which we generated in step 1, to the user.
 * 							B. Call upon bubbleSort method and send it the random array, the method then
 * 							   goes through each element individually, finds it's correct location, swaps
 * 							   it with the current value, then repeats until all elements of the array are
 * 							   sorted through
 * 							C. Print the newly sorted array to the user.
 * 							D. Loop back to step 2.
 * 
 * 						4. Selection Sort
 * 							A. Print the unsorted random array, which we generated in step 1, to the user.
 * 							B. Call upon selectionSort method and send it the random array, the method then
 * 							   finds the minimum of the array and places it in the correct location at the starting 
 * 							   point of that iteration. The starting point is calculated to be the beginning of the 
 * 							   array and is increased by one each time, until all elements are sorted.
 * 							C. Print the newly sorted array to the user.
 * 							D. Loop back to step 2.
 * 						5. Exit
 * 							A. Proceed to step 3
 * 				3. Goodbye message
 * 				4. Exit program
 */
import java.util.Scanner;

public class Assignment4 {
	public static void main(String[] args) {

	// Declaration of variables and arrays
		Scanner input = new Scanner(System.in);
		int x = 0, ID = 0, index = 0, amount = 0;
		String[] bookTitle = { "Starting out with Java", "Java Programming", "Software Structures",
				"Design and Analysis of Algorithms", "Computer Graphics", "Artificial Intelligence: A Modern Approach",
				"Probability and Statistics", "Cognitive Science", "Modern Information Retrieval",
				"Speech and Language Processing" };
		int[] bookID = { 1101, 1211, 1333, 1456, 1567, 1642, 1699, 1755, 1800, 1999 };
		int[] randomArray = new int[10];
		double[] bookPrice = { 112.32, 73.25, 54.00, 67.32, 135.00, 173.22, 120.00, 42.25, 32.11, 123.75 };
	// Calls upon fillArray method to generate a random array of integers
		randomArray = fillArray(randomArray);	
	// Do loop runs until the user quits the program 
		do {	
			// Prints out the main menu of the program and gets input for it 
				System.out.print("**** MENU ****\n1.Linear Search\n2.Binary Search\n3.Bubble Sort\n4.Selection Sort\n5.Quit\n"+ 
						"Please select a number 1-5: ");
				x = input.nextInt();
		// Invalid input
			if (((x < 1) || (x > 5))) 
				System.out.print("\nInvalid input. Please try again\n");
		// Linear Search
			else if (x == 1) {
			// Prints out the options the user has to select from
				System.out.print("\n**** LINEAR SEARCH ****");
				display(bookID, bookTitle, bookPrice);
				long startTime = 0;
			// Do loop runs while the user's search selection is not found	
				do {
				// Gets the time at the start of execution 
					startTime = System.currentTimeMillis();
				// Calls linearSearch method to run a linear search
					index = linearSearch(bookID);
					if (index == -1)
						System.out.println("\nBook not found. PLease try again!");
				} while (index == -1);
				// Get the time at the end of execution and subtracts the start time from it 
					long stopTime = System.currentTimeMillis();
					double elapsedTime = stopTime - startTime;
			// Ask the user how many books they would like to buy, then prints their total due back to them 
			// and the amount of time that passed during execution
				System.out.print("\nHow many books would you like to purchase: ");
					amount = input.nextInt();
				System.out.printf(
						"\nBook ID: " + bookID[index] + "\nBook Title: " + bookTitle[index]
						+ "\nNumber of Books Bought: " + amount + "\nTotal: $" + "%.2f" + "\n\nElapsed Time: "
						+ (elapsedTime/1000) + " seconds\n",(bookPrice[index] * amount));
			}

		// Binary Search
			else if (x == 2) {
			// Prints out the options the user has to select from
				System.out.print("\n**** BINARY SEARCH ****");
				display(bookID, bookTitle, bookPrice);
			// Do loop runs while the user's search selection is not found
					long startTime = 0;
				do {
				// Gets the time at the start of execution 
					startTime = System.currentTimeMillis();
				// Calls binarySearch method to run a binary search
					index = binarySearch(bookID);
					if (index == -1) {
						System.out.println("\nBook not found. PLease try again!");
					}
				} while (index == -1);
				// Gets the time at the end of execution and subtracts the start time from it
					long stopTime = System.currentTimeMillis();
					double elapsedTime = stopTime - startTime;
			// Ask the user how many books they would like to buy, then prints their total due back to them
			// and the amount of time that passed during execution
				System.out.print("\nHow many books would you like to purchase: ");
				amount = input.nextInt();
				System.out.print("\nBook ID: " + bookID[index] + "\nBook Title: " + bookTitle[index]
						+ "\nNumber of Books Bought: " + amount + "\nTotal: $" + (bookPrice[index] * amount) + 
						"\n\nElapsed Time: " + (elapsedTime/1000) + " seconds\n");
			}

		// Bubble Sort
			else if (x == 3) {
			//Prints the unsorted array to the user
				System.out.println("\n**** BUBBLE SORT ****");
				System.out.print("Unsorted Array: ");
					displayArray(randomArray);
				System.out.println();
			//Calls bubbleSort method, then prints the sorted array to the user 
					bubbleSort(randomArray);
					System.out.print("\nSorted Array: ");
					displayArray(randomArray);
				System.out.println();
			}

		// Selection Sort
			else if (x == 4) {
			//  Prints the unsorted array to the user 
				System.out.println("\n**** SELECTION SORT ****");
				System.out.print("Unsorted Array: ");
					displayArray(randomArray);
				System.out.println();
			// Calls selectionSort method then prints the sorted array to the user
					selectionSort(randomArray);
				System.out.print("\nSorted Array: ");
					displayArray(randomArray);
				System.out.println();
			}

			System.out.print("\n");
		} while (x != 5);

	// Goodbye statement 
		System.out.print("\nGoodbye!");

	}

// Displays the parallel arrays in the correct format for the user 
	public static void display(int[] x, String[] y, double[] z) {
		System.out.printf("\nBook ID %30s Title %30s Cost\n", " ", " ");
	// Using printf, the for loop prints the parallel arrays in the correct format
		for (int i = 0; i < x.length; i++) {
			if (y[i].equals("Artificial Intelligence: A Modern Approach")) {
				System.out.printf("%d               %30s %18.2f\n", x[i], y[i], z[i]);
			} else if (y[i].equals("Design and Analysis of Algorithms")) {
				System.out.printf("%d               %30s %27.2f\n", x[i], y[i], z[i]);
			} else {
				System.out.printf("%d               %30s %30.2f\n", x[i], y[i], z[i]);
			}
		}
	}
	
// Linear Search Method 
	public static int linearSearch(int[] x) {
		Scanner input = new Scanner(System.in);
		System.out.print("\nPlease enter the book ID you would like to buy from the list above: ");
			int ID = input.nextInt();
		int index = -1;
	// For loop runs through all elements of the array to find the search item provided by the user 
		for (int i = 0; i < x.length; i++) {
			if (x[i] == ID) {
				index = i;
			}
		}
		return index;
	}

// Binary Search Method 
	public static int binarySearch(int[] x) {
		int low = 0;
		int high = x.length - 1;
		int mid = 0;
		Scanner input = new Scanner(System.in);

		System.out.print("\nPlease enter the book ID you would like to buy from the list above: ");
		int ID = input.nextInt();
	// Splits the array in half, then determines which portion the search item is in. It repeats this
	// with each half until the item has been found, or no more halves can be done.
		while (low <= high) {
			mid = (low + high) / 2;
			int index = x[mid];

			if (ID == index) {
				return mid;
			} else if (ID < index) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

// Fill Array Method fills the array with 10 random integers between 1 and 500
	public static int[] fillArray(int[] x) {
		for (int i = 0; i < x.length; i++) {
			x[i] = ((int) (Math.random() * 500) + 1);
		}
		return x;
	}
	
// Bubble Sort Method 
	public static int[] bubbleSort(int[] x) {
		int temp = 0;
	// For loop runs through each value, and determines which value it should be swapped with.
	// Once the loop ends, all numbers should be accounted for and sorted.Further, it finds 
	// a start and end time to determine how long execution took.
		long startTime = System.nanoTime();
		for (int i = 0; i < x.length; i++) {
			for (int j = 1; j < (x.length - i); j++) {
				if (x[j - 1] > x[j]) {
					temp = x[j - 1];
					x[j - 1] = x[j];
					x[j] = temp;
				}
			}
		}
		
		long endTime = System.nanoTime();
		double elapsedTime = endTime - startTime;
		System.out.printf("\nTime to Sort: %.3f seconds.\n", elapsedTime/100000);
		return x;
	}

// Selection Sort Method 
	public static int[] selectionSort(int[] x) {
	// For loop runs through each element of the array, determines the minimum, and places it at the
	// current iteration's starting point. Once the loop ends, all numbers should be accounted for and
	// sorted. Further, it finds a start and end time to determine how long execution took
		long startTime = System.nanoTime();
		for (int i = 0; i < x.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < x.length; j++) {
				if (x[j] < x[index])
					index = j;
			}
		// Swaps the value of the minimum with the current starting point 
			int temp = x[index];
			x[index] = x[i];
			x[i] = temp;
		}
		
		long endTime = System.nanoTime();
		double elapsedTime = endTime - startTime;
		System.out.printf("\nTime to Sort: %.3f seconds.\n", elapsedTime/100000);
		return x;

	}
// Display Array Method prints out the array to the user 
	public static void displayArray(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}

}
