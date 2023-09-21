/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author jinweiang
 */
public class babyClient {
    public static void main(String[] args) {
        PrintWriter outputStream = null;
        Baby obj = new Baby("Default", 0); //create new Baby class obj
        Baby arr[] = new Baby[4];
        Scanner input = new Scanner(System.in);
        String name;
        int age;
        boolean equal = false;
        
        //fill array with objects
        for (int i = 0; i< arr.length; i++){
            arr[i] = new Baby("Default", 0);
        }
        
        //get input and set name and age, looping through the array
        for (int i = 0; i < 4; i++){
            System.out.println("Enter baby name: ");
            name = input.nextLine();
            System.out.println("Enter baby age: ");
            age = input.nextInt();
            input.nextLine();
            if (i==0){
                System.out.println("Enter patient id: ");
                int id = input.nextInt();
                input.nextLine();
                arr[i] = new Patient(name,age,id);
            }
            if (i==1 || i==3){
                arr[i] = new Baby(name,age);
            }
            if (i==2){
                arr[i] = new Playgroup(name,age);
            }
        }
        try {
            outputStream = new PrintWriter(new File("baby.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Can't open file baby.txt");
        }
        System.out.println(obj.displayBaby(arr));
        outputStream.write(obj.displayBaby(arr));
        System.out.println("The average age of all babies is: " + obj.getAverageAge(arr));
        outputStream.write("The average age of all babies is: " + obj.getAverageAge(arr));
        //loop through the array and check for identical babies
        for (int i = 0; i < arr.length; i++){
            if (arr[i].equals(arr[0]) == true || arr[i].equals(arr[1]) == true || arr[i].equals(arr[2]) == true || arr[i].equals(arr[3]) == true){
                equal = true;
            }
        }
        if (equal == true){
            System.out.println("\nThere are identical babies.");
            outputStream.write("\nThere are identical babies.");
        }
        else{
            System.out.println("\nThere isn't any identical babies.");
            outputStream.write("\nThere isn't any identical babies.");
        }
        outputStream.close();
        System.out.println("\nThe above information have been saved to baby.txt.");
    }
    
}
