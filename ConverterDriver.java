
/*
 * This is the driver for the project and runs all of the code to get user
 * input for the file extensions for the files to be read and written to.
 * 
 * @author Michael Slaton
 * @version 03/28/2017
 */
import java.util.*;
import java.io.*;
public class ConverterDriver
{
    public static void main(String[]args) throws IOException
    {
        // Creation of a Scanner object for the keyboard
        Scanner keyboard = new Scanner(System.in);
        
        // Declaration of variables
        Converter instance;
        String inputExtension;
        String outputExtension;
        String sentence = " ";
        PrintWriter output;
        Scanner input;
        
        // Gets the file extension of the input file
        System.out.print("Please enter the file extension and name for input: ");
            inputExtension = keyboard.nextLine();
        // Gets the file extension of the output file
        System.out.print("\nPlease enter the file extension and name for output: ");
            outputExtension = keyboard.nextLine();
        // Creation of two new objects. One scanner using inputExtension and 
        // one PrintWriter using outputExtension
            input = new Scanner(new File(inputExtension));
            output = new PrintWriter(new File(outputExtension));  
        
        // While loop runs while the input file continues to have data to be read
        while(input.hasNext())
        {
            // Gets the current line of input
            sentence = input.nextLine();
            // Creates a new object to convert sentence
            instance = new Converter(sentence);
            // Writes the newly converted sentence to the output file
            output.println(instance.getConvertedSentence());
        }
        
        // Closes the Scanner and PrintWriter objects
        input.close();
        output.close();
 
        // Informs the user the the file was successfully convereted
        System.out.print("\nFile written");
    }
}
