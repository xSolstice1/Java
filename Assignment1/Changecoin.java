package assignment1;
import java.util.Scanner;

/**
 *
 * @author Ang Jin Wei
 * @date 8 Feb 2023
 * @filename Changecoin.java
 * @
 */


public class Changecoin {
    private String name;
    private int coin;
    private int twoDollars;
    private int oneDollar;
    private int fiftyCents;
    private int twentyCents;
    private int tenCents;
    private int fiveCents;
    
    //default constructor
    public Changecoin(){
        this.name = "empty";
        this.coin = 0;
    }
    
    //constructor with two parameters
    public Changecoin(String name, int value){
        this.name = name;
        this.coin = value;
    }
    
    public void StudentInfo(){
        String msg = "";
        
        msg += "Name: Ang Jin Wei";
        msg += "\nStudent Number: 34792195";
        msg += "\nMode of Enrolment: Part-Time";
        msg += "\nTutor Name: Steven Loke";
        msg += "\nClass: ICT284 B";
        System.out.println(msg+"\n");
    }
    
    //start of accessor methods
    //precondition: call method on changecoin object
    //postcondition: return "name" variable of the object
    public String getName(){
        return this.name;
    }
    
    //precondition: call method on changecoin object
    //postcondition: return "name" variable of the object
    public int getCoin(){
        return this.coin;
    }
    //end of accessor methods
    
    //calculate amount of coins for each denominator
    //precondition: call method on changecoin object
    //postcondition: calculate the amount of coins for each denominator on the object
    public void calculateChange(){
        int temp = 0;
        while (this.coin >= 200){
            this.coin -= 200;
            temp += 200;
            this.twoDollars += 1;
        }
        while (this.coin >= 100){
            this.coin -= 100;
            temp += 100;
            this.oneDollar += 1;
        }
        while (this.coin >= 50){
            this.coin -= 50;
            temp += 50;
            this.fiftyCents += 1;
        }
        while (this.coin >= 20){
            this.coin -= 20;
            temp += 20;
            this.twentyCents += 1;
        }
        while (this.coin >= 10){
            this.coin -= 10;
            temp += 10;
            this.tenCents += 1;
        }
        while (this.coin >= 5){
            this.coin -= 5;
            temp += 5;
            this.fiveCents += 1;
        }
        this.coin = temp; //revert coin amount to original after calculation
    }
    
    //reset denominations count to 0
    //precondition: call method on a changecoin object
    //postcondition: mutate the values of the denominations in the object to 0
    public void resetChange(){
        this.twoDollars = 0;
        this.oneDollar = 0;
        this.fiftyCents = 0;
        this.twentyCents = 0;
        this.tenCents = 0;
        this.fiveCents = 0;
    }
    
    //check divisible by 5, if not round off to nearest multiple of 5
    //precondition: call method on a changecoin object
    //postcondition: mutate the coin amount to nearest multiple of 5
    public void checkDivisible(){
        int temp = this.coin % 10; //find last digit of number
        if (temp > 0 && temp < 3){
            this.coin -= temp;
        }
        if (temp > 2 && temp < 5 ){
            this.coin += (5-temp);
        }
        if (temp > 5 && temp < 8){
            this.coin -= (temp-5);
        }
        if (temp > 7 && temp < 10){
            this.coin += (10-temp);
        }
        
    }
    
    //method to allow user to input names and value of coins
    //precondition: specify arr under the method parameter
    //postcondition: should loop till user enters N and add changecoin objects into array to a maximum of 10
    public Changecoin[] userInput(Changecoin[] arr){
        Scanner input = new Scanner(System.in);
        String userchoice = "Y";
        String username;
        int amount;
        
        for (int x = 0; x<arr.length ; x++){
            arr[x] = new Changecoin(); //fill array with "empty" objects
        }
        for (int i = 0; i<arr.length; i++){
            System.out.println("Please enter the name of the person:");
            username = input.nextLine();
            if (isExisting(arr,username) == true){
                System.out.println("The name already exist, please try again.");
                i -= 1;
            }
            if (isExisting(arr, username) == false){
                System.out.println("Please enter the coin value for the person:");
                amount = input.nextInt();
                arr[i] = new Changecoin(username,amount);
                arr[i].checkDivisible();
                if(i < 9){ //check if max array size reached
                    System.out.println("Do you have more person to enter (Y/N):");
                    input.nextLine();
                    userchoice = input.nextLine();
                }
                else{
                    System.out.println("\nYou have reached the maximum number of records.\n");
                }
            }
            if (userchoice.equalsIgnoreCase("N")){
                break;
            }
        }
        return arr;
    }   
    
    //menu returning choice of user
    //precondition: should be called from changecoin class
    //postcondition: choice should be returned as integer
    public int menu(){
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("\n1. Enter a name and display change to be given for each denomination");
        System.out.println("2. Find the name with the largest amount and display change to be given for each denomination");
        System.out.println("3. Find the name with the smallest amount and display change to be given for each denomination");
        System.out.println("4. Calculate and display the total number of coins for each denomination");
        System.out.println("5. Calculate and display the total amount (i.e. NOT the total number of coins) for the sum of all denominations");
        System.out.println("6. Exit\n");
        choice = input.nextInt();
        return choice;
    }
    
    //display change based on amount of each denominator, not displaying if amount equals 0
    //precondition: should be called from the changecoin object you want to run the method on
    //postcondition: message with customer name and their change should be output
    public void displayChange(){
        String msg = "\nCustomer: \n" + this.name + " " + this.coin + " cents\n\nChange:";
        if (this.twoDollars != 0){
            msg += "\n2 dollars: " + this.twoDollars;
        }
        if (this.oneDollar != 0){
            msg += "\n1 dollar: " + this.oneDollar;
        }
        if (this.fiftyCents != 0){
            msg += "\n50 cents: " + this.fiftyCents;
        }
        if (this.twentyCents != 0){
            msg += "\n20 cents: " + this.twentyCents;
        }
        if (this.tenCents != 0){
            msg += "\n10 cents: " + this.tenCents;
        }
        if (this.fiveCents != 0){
            msg += "\n5 cents: " + this.fiveCents;
        }
        System.out.println(msg);
    }
    
    //method to check if name exists
    //precondition: arr and a name should be specified in the parameter
    //postcondition: return true if name exists, false if name doesn't exist
    public boolean isExisting(Changecoin[] arr, String name){
        boolean result = false;
        for (int i = 0; i< arr.length; i++){
            if (arr[i].name.equalsIgnoreCase(name)){
                result = true;
            }
        }
        return result;
    }
    
    //enter a name and display change to be given for each denomination
    //precondition: arr must be specified in parameter
    //postcondition: change of the specified person should be output
    public void optionOne(Changecoin[] arr){
        Scanner input = new Scanner(System.in);
        boolean exist = true;
        System.out.println("\nPlease enter a name:");
        String userinput = input.nextLine();
        for (int i = 0; i<arr.length; i++){
            if (arr[i].name.equalsIgnoreCase(userinput)){
                arr[i].calculateChange();
                arr[i].displayChange();
                arr[i].resetChange();
                exist = true;
                break;
            }
            else{
                exist = false;
            }
        }
        if (exist == false){
            System.out.println("\nName: " + userinput + "\nNot found\n");
        }
    }
    
    //display change of the person with largest amount of coins
    //precondition: arr must be specified in parameter
    //postcondition: change of the person with largest amount of coins should be output
    public void optionTwo(Changecoin[] arr){
        int largestIndex=0;
        int largestNum=arr[0].coin;
        for (int i = 0; i < arr.length; i++){
            if (arr[i].coin > largestNum){
                largestNum = arr[i].coin;
                largestIndex = i;
            }
        }
        arr[largestIndex].calculateChange();
        arr[largestIndex].displayChange();
        arr[largestIndex].resetChange();
    }
    
    //display change of the person with smallest amount of coins
    //precondition: arr must be specified in parameter
    //postcondition: change of the person with smallest amount of coins should be output
    public void optionThree(Changecoin[] arr){
        int smallestIndex=0;
        int smallestNum=arr[0].coin;
        for (int i = 0; i < arr.length; i++){
            if (arr[i].coin < smallestNum && arr[i].name.equals("empty") == false){ //ignore default entry
                smallestNum = arr[i].coin;
                smallestIndex = i;
            }
        }
        arr[smallestIndex].calculateChange();
        arr[smallestIndex].displayChange();
        arr[smallestIndex].resetChange();
    }
    
    //calculate and display total number of coins for each denomination
    //precondition: arr must be specified in parameter
    //postcondition: total number of coins for each denomination should be output
    public void optionFour(Changecoin[] arr){
        String msg =  "\nTotal number of coins for each denomination:";
        int two = 0;
        int one = 0;
        int fifty = 0;
        int twenty = 0;
        int ten = 0;
        int five = 0;
        
        for (int i = 0; i < arr.length; i++){
            arr[i].calculateChange();
            two += arr[i].twoDollars;
            one += arr[i].oneDollar;
            fifty += arr[i].fiftyCents;
            twenty += arr[i].twentyCents;
            ten += arr[i].tenCents;
            five += arr[i].fiveCents;
            arr[i].resetChange();
        }
        
        if (two != 0){
            msg += "\n2 dollars: " + two;
        }
        if (one != 0){
            msg += "\n1 dollar: " + one;
        }
        if (fifty != 0){
            msg += "\n50 cents: " + fifty;
        }
        if (twenty!= 0){
            msg += "\n20 cents: " + twenty;
        }
        if (ten != 0){
            msg += "\n10 cents: " + ten;
        }
        if (five != 0){
            msg += "\n5 cents: " + five;
        }
        System.out.println(msg);      
    }
    
    //calculate and display total amount for each denomination
    //precondition: arr must be specified in parameter
    //postcondition: total amount for each denomination should be output
    public void optionFive(Changecoin[] arr){
        String msg =  "\nTotal amount for each denomination:";
        int two = 0;
        int one = 0;
        int fifty = 0;
        int twenty = 0;
        int ten = 0;
        int five = 0;
        
        for (int i = 0; i < arr.length; i++){
            arr[i].calculateChange();
            two += arr[i].twoDollars;
            one += arr[i].oneDollar;
            fifty += arr[i].fiftyCents;
            twenty += arr[i].twentyCents;
            ten += arr[i].tenCents;
            five += arr[i].fiveCents;
            arr[i].resetChange();
        }
        two *= 200;
        one *= 100;
        fifty *= 50;
        twenty *= 20;
        ten *= 10;
        five *= 5;
        if (two != 0){
            msg += "\n2 dollars: " + two + " cents";
        }
        if (one != 0){
            msg += "\n1 dollar: " + one + " cents";
        }
        if (fifty != 0){
            msg += "\n50 cents: " + fifty + " cents";
        }
        if (twenty!= 0){
            msg += "\n20 cents: " + twenty + " cents";
        }
        if (ten != 0){
            msg += "\n10 cents: " + ten + " cents";
        }
        if (five != 0){
            msg += "\n5 cents: " + five + " cents";
        }
        System.out.println(msg);      
    }
    
} //end of Changecoin class
