import java.util.Scanner;

 //TwoDps.java
//Displays running total of numbers in lines of standard
//input correct to two decimal places.
//Uses an out of range number(<-100 or >100) to quit.
        
public class Trunc{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double total=0;
        boolean flag=true;
        
        System.out.println("Use an out of range entry <-100 or >100 to quit.");
        
        while(flag){
            System.out.println("Enter a number on a line:");
            
            double d = input.nextDouble();
            
            if (outOfRange(d)){
                flag=false;
            }
            else{
                dispTwoDPs("The number value is: ",d);
                //round up based on positive or negative double
                boolean neg = (d<0); // check if double is negative
                int round = (int) (d+0.5); // casting to int after adding 0.5
                if(neg) round = (int) (d-0.5); // casting to int after subtracting 0.5
                total += round; // adding rounded number to total
                
                dispTwoDPs("The total is: ",total);
                
                System.out.println();
                System.out.println("Next.");
                
            
            } //end of else
        }//end of while
        System.out.println("You quit.");
    }//end of main

    static boolean outOfRange(double d) {
        if(d<-100) return true;
        if(d>100) return true;
        return false;
        
    }

    static void dispTwoDPs(String msg, double num) {
       //display on screen the message msg
        //followed by num correct to two decima places
        //with both decimal values showing even if they are zero
        
        //record whetherthe number is negative
       boolean neg =(num < 0);
        //positive double
        int wholeNum = (int) (num+0.5); // cast to int after adding 0.5
        //negative double
        if(neg) wholeNum = (int) (num-0.5); // cast to int after subtracting 0.5
        
        System.out.println(msg +"" +wholeNum); //print out msg + rounded whole number
        
    }

    
        
    }
        
    
//end of class 
    
