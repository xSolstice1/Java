/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

/**
 *
 * @author jinweiang
 */
public class Fraction {
    private int numerator;
    private int denominator;
    
    //output as fraction
    public void getFraction(){
        System.out.println(numerator+" / "+denominator);
    }
    
    //get numerator
    public int getNumerator(){
        return this.numerator;
    }
    
    //get denominator
    public int getDenominator(){
        return this.denominator;
    }
    
    //set Numerator
    public void setNumerator(int x){
        this.numerator = x;
    }
    
    //set Denominator
    public void setDenominator(int x){
        this.denominator = x;
    }
    
}//end of Fraction Class


