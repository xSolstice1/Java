import java.util.Arrays;
import java.util.Scanner;

 //TwoDps.java
//Displays running total of numbers in lines of standard
//input correct to two decimal places.
//Uses an out of range number(<-100 or >100) to quit.
        
public class Variable{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        boolean flag=true;
        String vowelsList = "";
        String occurA;
        String occurE;
        String occurI;
        String occurO;
        String occurU;
        String[] vowelsArr = null;
        String vowels="";
        String countA;
        String countE;
        String countI;
        String countO;
        String countU;
        
        System.out.println("Enter a string to a maximum length of 30. Enter Q to quit.");
        
        while(flag){
            System.out.println("Enter your string:");
            
            String userString = input.nextLine(); //reads user next line
            String lowerCase = userString.toLowerCase(); //lowercase
            
            if ("q".equals(lowerCase)){
                flag=false;
            }
            else{
                if (lowerCase.length() > 30){
                    System.out.println("The string is too long. Please enter again.");
                }
                else{
                    for(int i=0; i<lowerCase.length(); i++){
                        if(lowerCase.charAt(i) == 'a' || lowerCase.charAt(i) == 'e' ||
                           lowerCase.charAt(i) == 'i' || lowerCase.charAt(i) == 'o' ||
                           lowerCase.charAt(i) == 'u') {
                           vowels+=lowerCase.charAt(i);
                        }
                    }
                            vowelsArr = vowels.split(""); //store vowels in array
            vowelsList = printVowels(vowelsArr, vowelsList); //add vowels to vowelsList string
            System.out.println("The output of the array is \n"+vowelsList+"\n"+Arrays.toString(vowelsArr)); //prints vowels + array
            countA = countChar(vowelsArr, "a");
            countE = countChar(vowelsArr,"e");
            countI = countChar(vowelsArr,"i");
            countO = countChar(vowelsArr,"o");
            countU = countChar(vowelsArr,"u");
            occurA = searchArr(vowelsArr,"a");
            occurE = searchArr(vowelsArr,"e");
            occurI = searchArr(vowelsArr,"i");
            occurO = searchArr(vowelsArr,"o");
            occurU = searchArr(vowelsArr,"u");
            System.out.println("The count are as follow:\na" + countA + "\ne" + countE + "\ni" + countI
            + "\no" + countO + "\nu" + countU);
            System.out.println("The index of the second array where each vowel first appeared:\na" + occurA + "\ne" + occurE + "\ni" + occurI
            + "\no" + occurO + "\nu" + occurU);
            vowels = ""; //clears vowel list
            vowelsList = "";
                }

                
            
            } //end of else
        }//end of while
        System.out.println("You quit.");
    }//end of main   
    public static String printVowels(String[] arr, String vowels){
        for(int i=0; i<arr.length; i++){ //loop through arr
            vowels += arr[i]; //add vowels to string
        }
        return vowels;
    }
    public static String countChar(String[] arr, String x){
        int count=0;
        String finalnum;
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals(x)){ 
                count++; //if vowel in current index matches, add 1 to count
            }
        }
        finalnum = " = "+String.valueOf(count); //assign count of vowel as string
        return finalnum;
    }
    public static String searchArr(String[] arr, String x){
        String occur;
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals(x)){
                occur = " = "+String.valueOf(i);
                return occur; //return index in string
            }
        }
        occur = " not in input";
        return occur; //return not in input if vowel not in input
    }

    }

        
    
//end of class 
    
