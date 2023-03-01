/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

/**
 *
 * @author jinweiang
 */
public class Fraction {
    private int numerator;
    private int denominator;
    
    //output as simplified fraction
    public void getFraction(){
        simplify();
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
    
    //add fractions
    public Fraction add(Fraction f){
        if(f.denominator == this.getDenominator()){ //if denominator is same, add numerators
            f.numerator = f.numerator + this.getNumerator();
        }
        else{ //cross multiply if denominator not same
            f.numerator = (this.getNumerator()*f.denominator) + (f.numerator*this.getDenominator());
            f.denominator = f.denominator * this.getDenominator();
        }
        return f; //return object f
    }
    
    private void simplify(){
        int gcd = this.gcd(this.numerator,this.denominator);
        this.numerator = this.numerator/gcd;
        this.denominator = this.denominator/gcd;
    } 
    
    private int gcd(int num, int den){
        int temp;
        while (num != 0 && den != 0){
            temp = den;
            den = num % den;
            num = temp;
        }
        return num + den;
    }
    
    
}//end of Fraction Class


