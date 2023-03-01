package lab7;

import java.util.*;
import java.io.*;

/**
 *
 * @author jinweiang
 */
public class Q2 {
    public static void main(String[] args) {
        PrintWriter outputStream = null;
        Score obj = new Score("default",0);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name of input file: ");
        String inputFile = input.nextLine();
        Score records[] = new Score[10];
        int count = 0;
        try {
            Scanner inputStream = new Scanner(new File(inputFile));
            while (inputStream.hasNextLine()){
                String str[] = inputStream.nextLine().split(" "); //split nextLine in array
                records[count] = new Score(str[0],Integer.parseInt(str[1])); //create and store new score object
                count+=1;
            }
            inputStream.close(); //close inputStream
            
            double average = obj.getAverage(records);
            int highest = obj.getHighest(records);
            int lowest = obj.getLowest(records);
            
            outputStream = new PrintWriter(new File("output.csv")); //create new output.csv
            outputStream.write("Record Size,Average Score,Highest Score,Lowest Score\n"); //headers
            String result = records.length + "," + average + "," + highest + "," + lowest + "\n";
            outputStream.write(result); //write in csv the length,average,highest,lowest scores
            outputStream.write("Name,Score\n"); //headers
            String data = obj.getData(records);
            outputStream.write(data); //write in csv the data according to the input txt file
            outputStream.close(); //close outputStream
            System.out.println("\nThe record size is "+records.length+"\nThe average score is "+average+""
                    + "\nThe highest score is "+highest+"\nThe lowest score is "+lowest+"\nThe data have been output to output.csv.");
        }
        catch(FileNotFoundException e){
            System.out.println("Can't open file " + inputFile);
        }
        
    }
}
