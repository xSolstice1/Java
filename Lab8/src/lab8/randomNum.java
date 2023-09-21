/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author jinweiang
 */
public class randomNum {

    //we can use static methods because the methods is in the same class
    public static void main(String[] args) {
        int amount = getNumber();
        int[] numbers = new int[amount];
        fillArr(numbers);
        sortNumbers(numbers);
        System.out.println(displayNumbers(numbers));
        System.out.println("\nThe smallest number is: " + getSmallest(numbers));
        System.out.println("The largest number is " + getLargest(numbers));
        System.out.println("The average is: " + getAverage(numbers));
    }
    
    //get user input on how many numbers they want to store
    public static int getNumber(){
        int amount;
        Scanner input = new Scanner(System.in);
        System.out.println("How many numbers do you want to store?");
        amount = input.nextInt();
        return amount;
    }
    
    //fill the array with random numbers 1 to 999
    public static void fillArr(int[] arr){
        Random generator = new Random(); //create random number generator;
        int randNum;
        for (int i = 0; i < arr.length; i++){
            randNum = generator.nextInt(999); //random number from 0 to 998
            randNum += 1; //add 1 to randNum so range is 1 to 999
            arr[i] = randNum; //store randNum in array
        }
    }
    
    //loop through array and display numbers in lines of 5
    public static String displayNumbers(int[] arr){
        int count = 0;
        String msg = "\n";
        for (int i = 0; i < arr.length; i++){
            if(count<5){
                msg += arr[i] + " ";
                count += 1;
            }
            else{
                msg += "\n" + arr[i] + " ";
                count = 1;
            }
        }
        return msg;
    }
    
    //loop through array to find smallest number
    public static int getSmallest(int[] arr){
        int smallestNum = arr[0];
        for (int i = 0; i< arr.length; i++){
            if (arr[i] < smallestNum){
                smallestNum = arr[i];
            }
        }
        return smallestNum;
    }
    
    //loop through array to find largest number
    public static int getLargest(int[] arr){
        int largestNum = arr[0];
        for (int i = 0; i< arr.length; i++){
            if (arr[i] > largestNum){
                largestNum = arr[i];
            }
        }
        return largestNum;
    }
    
    //loop through array to find average of the numbers
    public static double getAverage(int[] arr){
        int total = 0;
        int count = 0;
        double average;
        for (int i = 0; i < arr.length; i++){
            total += arr[i];
            count += 1;
        }
        average = (double) total/count;
        return average;
    }
    
    public static void sortNumbers(int arr[]) {    
        for (int i = 1; i < arr.length; i++) {  
            int num = arr[i];  
            int next = i-1;  
            while (next > -1 && arr[next] > num) {  
                arr[next+1] = arr[next];  
                next--;  
            }  
            arr[next+1] = num;  
        }  
    }   
}
