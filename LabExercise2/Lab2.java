import java.util.Scanner;
        
public class Lab2{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        boolean flag=true;

        while(flag){
            System.out.println("Select an option a,b,c,d,e,f,g,q:");
            char userChoice = input.nextLine().trim().toLowerCase().charAt(0);
            switch(userChoice){
                case 'q':
                    flag=false;
                    break;
                case 'a':
                    System.out.println(optionA());
                    break;
                case 'b':
                    System.out.println(optionB());
                    break;
                case 'c':
                    System.out.println(optionC());
                    break;
                case 'd':
                    System.out.println(optionD());
                    break;
                case 'e':
                    System.out.println(optionE());
                    break;
                case 'f':
                    System.out.println(optionF());
                    break;
                case 'g':
                    System.out.println(optionG());
                    break;
            } //end of switch
        }//end of while
        System.out.println("You quit.");
    }//end of main

    public static String optionA() {
       return "My name: Ang Jin Wei \nTutor name: Lu Qi Fa";  
    }

    public static String optionB() {
        double[] doubleArr = new double[3];
        Scanner d = new Scanner(System.in);
        System.out.println("Enter three doubles:");
        for(int i=0; i<doubleArr.length; i++){
            doubleArr[i] = d.nextDouble();
        }
        double largestNum = doubleArr[0];
        double smallestNum = doubleArr[0];
        for(int i=0; i<doubleArr.length; i++){
            if(doubleArr[i] > largestNum){
                largestNum = doubleArr[i];
            }
            else if (doubleArr[i] < smallestNum){
                smallestNum = doubleArr[i];
            }
    }
        return "The largest number is: "+largestNum+"\nThe smallest number is: "+smallestNum;
    }
    public static String optionC() {
        Scanner intInput = new Scanner(System.in);
        String msg = "";
        int num1, num2;
        int sum = 0;
        int numL = 0;
        System.out.println("Enter two integers:");
        num1 = intInput.nextInt();
        num2 = intInput.nextInt();
        int minNum = Math.min(num1, num2);
        int maxNum = Math.max(num1, num2);
        for(int i = minNum;i<maxNum+1; i++){
            if(numL < 5){
                msg += i + " ";
                numL+=1;
            }
            else{
                msg += "\n" + i + " ";
                numL = 1;
            }
        }
        for(int i = minNum;i<maxNum+1; i++){
            if(i%2 != 0){
                sum += i;
            }
        }
        msg += "\nThe sum of the odd numbers are: "+sum;
        return msg;
    }
    public static String optionD(){
        Scanner triInput = new Scanner(System.in);
        int a,b,c;
        System.out.println("Enter three integers: ");
        a = triInput.nextInt();
        b = triInput.nextInt();
        c = triInput.nextInt();
        String msg = "The numbers selected are: "+a+" "+b+" "+c;
        if (a+b>c && b+c>a && a+c>b){
            msg += "\nThe numbers selected forms a triangle.";
        }
        else{
            msg += "\nThe numbers selected will not form a triangle.";
        }
        return msg;
    }
    public static String optionE(){
        Scanner x = new Scanner(System.in);
        int a;
        String msg = "The number is not a prime number.";
        boolean flag = true;
        System.out.println("Enter one integer: ");
        a = x.nextInt();
        if(a>1){
            for(int i=2; i<a; i++){
                if(a%i == 0){
                    flag = false;
                }
            }
        }
        else{
            flag = false;
        }
        if(flag==true){
            msg = "The number is a prime number.";
        }
        return msg;
    }
    public static String optionF(){
        Scanner x = new Scanner(System.in);
        System.out.println("Enter 10 integers: ");
        int[] arr = new int[10];
        double sum = 0;
        for(int i=0; i<arr.length; i++){
            arr[i] = x.nextInt();
            sum += arr[i];
        }
        int smallestNum = arr[0];
        int largestNum = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>largestNum){
                largestNum = arr[i];
            }
            else if(arr[i]<smallestNum){
                smallestNum = arr[i];
            }
        }
        double average = sum/arr.length;
        return "The average of the 10 numbers is: "+average+"\nThe largest number is: "+largestNum
                +"\nThe smallest number is: "+smallestNum;
    }
    public static String optionG(){
        boolean loop = true;
        String msg = "The result is: ";
        Scanner x = new Scanner(System.in);
        System.out.println("Please enter an input not longer than 50 characters: ");
        String input = x.nextLine();
        while (loop){
            if(input.length()>50){
                System.out.println("Input is too long, please try again: ");
                input = x.nextLine();
            }
            else{
                char[] arr = input.toCharArray();
                char first = arr[0];
                arr[0] = arr[arr.length-1];
                arr[arr.length-1] = first;
                msg += String.valueOf(arr);
                loop = false;
            }
        }
        return msg;
    }
    }
        
    
//end of class 
    
