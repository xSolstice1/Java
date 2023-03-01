/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;
import java.util.Scanner;
/**
 *
 * @author jinweiang
 */
public class babyClient {
    public static void main(String[] args) {
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
        for (int i = 0; i < arr.length; i++){
            System.out.println("Enter baby name: ");
            name = input.nextLine();
            System.out.println("Enter baby age: ");
            age = input.nextInt();
            input.nextLine();
            arr[i].setName(name);
            arr[i].setAge(age);
        }
        System.out.println(obj.displayBaby(arr));
        System.out.println("The average age of all babies is: " + obj.getAverageAge(arr));
        //loop through the array and check for identical babies
        for (int i = 0; i < arr.length; i++){
            if (arr[i].equals(arr[0]) == true || arr[i].equals(arr[1]) == true || arr[i].equals(arr[2]) == true || arr[i].equals(arr[3]) == true){
                equal = true;
            }
        }
        if (equal == true){
            System.out.println("\nThere are identical babies.");
        }
        else{
            System.out.println("\nThere isn't any identical babies.");
        }
    }
    
}
