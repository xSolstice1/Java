/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;
import java.util.Scanner;

/**
 *
 * @author jinweiang
 */
public class TestFraction {
    public static void main(String[] args) {
        Fraction newFraction = new Fraction();
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        
        while(flag){
            System.out.println("Enter numerator:");
            int choice = input.nextInt();
            if(choice < 0){ //check if numerator entered is negative
                break; //stops when numerator is negative
            }
            else{
                newFraction.setNumerator(choice);
            }
            System.out.println("Enter denominator:");
            choice = input.nextInt();
            newFraction.setDenominator(choice);
            if(newFraction.getDenominator() < 0){ //check if denominator is negative
                newFraction.setNumerator(newFraction.getNumerator()*-1); //change numerator to -
                newFraction.setDenominator(newFraction.getDenominator()*-1); //change denominator to +
            }
            newFraction.getFraction(); //output as fraction
        }
        
        
        
        
    }
}
