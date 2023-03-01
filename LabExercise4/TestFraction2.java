/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;
import java.util.Scanner;

/**
 *
 * @author jinweiang
 */
public class TestFraction2 {
    public static void main(String[] args){
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        Fraction totalFraction = new Fraction();
        int num;
        int den;
        int count = 0;

        while(flag){
            Fraction newFraction = new Fraction();
            if (count==0){ //check if first fraction entered
                System.out.println("Enter numerator or 0 to quit:");
                num = input.nextInt();
                if (num == 0){ //check for zero fraction
                    flag=false;
                    break;
                }
                System.out.println("Enter denominator:");
                den = input.nextInt();
                totalFraction.setNumerator(num);
                totalFraction.setDenominator(den);
                System.out.println("The total fraction is:");
                totalFraction.getFraction();
                count=1;
            }
            System.out.println("Enter numerator or 0 to quit:");
            num = input.nextInt();
            if (num == 0){ //check for zero fraction
                flag=false;
                break;
            }
            System.out.println("Enter denominator:");
            den = input.nextInt();
            newFraction.setNumerator(num);
            newFraction.setDenominator(den);
            newFraction.add(totalFraction); //add new fraction to total fraction
            System.out.println("The total fraction is:");
            totalFraction.getFraction();
        }
    }
}
