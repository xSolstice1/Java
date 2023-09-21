/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab10;
import java.util.*;
import java.io.*;
/**
 *
 * @author jinweiang
 */
public class babyClient {
    public static void main(String[] args) {
        Baby obj = new Baby("Default", 0); //create new Baby class obj
        ArrayList<Baby> Babies = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int choice = 0;
        
        obj.inputBaby(Babies);
        while (choice != 6){
            choice = obj.menu();
            if (choice == 1){
                System.out.println("The average age of all babies are: " + obj.getAverageAge(Babies));
            }
            if (choice == 2){
                obj.removeBaby(Babies);
            }
            if (choice == 3){
                obj.inputBaby(Babies);
            }
            if (choice == 4){
                System.out.println(obj.displayBaby(Babies));
            }
            if (choice == 5){
                obj.outputBaby(Babies);
            }
        }
    }  
}