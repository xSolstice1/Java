package lab7;

import java.util.*;
import java.io.*;

/**
 *
 * @author jinweiang
 */
public class Q1 {
    public static void main(String[] args) {
        PrintWriter outputStream = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter input file name: ");
        String inputFile = input.nextLine(); //get input file (example:file.txt)
        System.out.println("Enter output file name: ");
        String outputFile = input.nextLine(); //get output file (example:fileout.txt)
        System.out.println("Enter your name: ");
        String userName = input.nextLine(); //get user's name
        try {
            Scanner inputStream = new Scanner(new File(inputFile));
            outputStream = new PrintWriter(outputFile);
            int count = 1;
            int charCount = 0;
            int wordCount = 0;
            while (inputStream.hasNextLine()){ //check if input file has nextline
                String temp = inputStream.nextLine();
                String line = count + " " + temp;
                charCount += temp.length(); //count number of characters in nextLine
                String str [] = temp.split(" "); //split nextLine into array of words
                for (int i = 0; i < str.length; i++){
                    if(str[i].length()>0){ //check if array is empty
                        wordCount+=1; //add 1 to wordCount
                    }
                }
                count += 1;
                outputStream.println(line);
            }
            outputStream.close(); //close outputStream
            count -= 1; //minus one from line count
            System.out.println("\nMy name = " + userName);
            System.out.println("Name of output file = " + outputFile);
            System.out.println("Total number of lines in " + inputFile + " = " + count);
            System.out.println("Total number of words in " + inputFile + " = " + wordCount);
            System.out.println("Total number of characters in " + inputFile + " = " + charCount);
        }
        catch(FileNotFoundException e){
            System.out.println("Error opening file.");
        }
    }
    
}
