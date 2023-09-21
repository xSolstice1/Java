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
//default constructor
public class Baby {
    private String name;
    private int age;
    
    //constructor with 2 parameters
    public Baby(String name,int age){
        this.name = name;
        this.age = age;
    }
    
    //get name variable
    public String getName(){
        return this.name;
    }
    
    //get age variable
    public int getAge(){
        return this.age;
    }
    
    public void inputBaby(ArrayList baby){
        String choice = "Y";
        String name = "";
        int age = 0;
        Scanner input = new Scanner(System.in);
        while (choice.equalsIgnoreCase("Y")){
            System.out.println("Please enter name of baby: ");
            name = input.nextLine();
            System.out.println("Please enter age of baby: ");
            age = input.nextInt();
            input.nextLine();
            baby.add(new Baby(name,age));
            System.out.println("Do you want to add more babies? (Y/N): ");
            choice = input.nextLine();
        }
    }
    
    //set name variable, if name is blank or contains whitespace, set name to John
    public void setName(String name){
        if (name.equals("") == false && name.contains(" ") == false){
            this.name = name;
        }
        else{
            this.name = "John"; //default name if name contains whitespace or is blank
        }
    }
    
    //set age variable, if name is not in the range of 1 to 4, set age to 2
    public void setAge(int age){
        if (1 <= age && age <= 4){
            this.age = age;
        }
        else{
            this.age = 2; //default age if age is more than 4 or less than 1;
        }
    }
    
    //check if name and age of an object is same, return false if comparing same object
    public boolean equals(Baby obj){
        boolean equal;
        if (this.name.equalsIgnoreCase(obj.getName()) && this.age == obj.getAge()){
            equal = true;
        }
        else{
            equal = false;
        }
        if (obj == this){ //check if comparing same objects
            equal = false;
        }
        return equal;
    }
    
    //display obj name and age
    public String displayBaby(ArrayList baby){
        String msg = "";
        for (int i = 0; i< baby.size(); i++){
            Baby temp = (Baby) baby.get(i);
            msg += "Name: " + temp.getName() + " Age: " + temp.getAge() + "\n";
        }
        return msg;
    }
    
    public int menu(){
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("\n1. Calculate and display average age of baby");
        System.out.println("2. Remove a baby");
        System.out.println("3. Add more babies");
        System.out.println("4. Output details of babies");
        System.out.println("5. Sort and output babies to CSV file");
        System.out.println("6. Exit\n");
        choice = input.nextInt();
        return choice;
    }
    
    public void outputBaby(ArrayList baby){
        Baby temp;
        PrintWriter output = null;
        String data = "";
        for (int i=0; i<baby.size(); i++){
            for (int j=0; j<baby.size()-i-1; j++){ 
                Baby temp1 = (Baby) baby.get(j);
                Baby temp2 = (Baby) baby.get(j+1);
                if (temp1.getName().compareTo(temp2.getName()) > 0){
                    temp = temp1;
                    baby.set(j,temp2);
                    baby.set(j+1, temp);
                }                
            }
        }
        try{
            output = new PrintWriter(new File("sortedbabylist.csv"));
            data += "Name,Age\n"; //headers
            for (int i=0; i<baby.size(); i++){
                Baby current = (Baby) baby.get(i);
                data += current.getName() + ",";
                data += current.getAge() + "\n";
            }
            output.write(data);
            output.close();
            System.out.println("\nData successfully output to sortedbabylist.csv in your project directory!");
        }
        catch(FileNotFoundException e){
            System.out.println("Can't open file!");
        }
    }
    
    public void removeBaby(ArrayList baby){
        Scanner input = new Scanner(System.in);
        String delete = "";
        String choice = "";
        boolean found = false;
        System.out.println("Please enter the name of baby you want to delete: ");
        delete = input.nextLine();
        for (int i = 0; i<baby.size(); i++){
            Baby temp = (Baby) baby.get(i);
            if (temp.getName().equalsIgnoreCase(delete)){
                System.out.println("\nDo you want to delete this baby? (Y/N)");
                System.out.println("\nName: "+temp.getName()+"\nAge: "+temp.getAge());
                choice = input.nextLine();
                if (choice.equalsIgnoreCase("Y")){
                    baby.remove(i);
                    System.out.println("\nBaby successfully deleted!");
                    found = true;
                }
            }
        }
        if (found == false){
            System.out.println("Baby not found!");
        }
    }
    
    //calculate average age of all obj in the array and return as double
    public double getAverageAge(ArrayList baby){
        int total = 0;
        int count = 0;
        double average = 0;
        for (int i = 0; i < baby.size(); i++){
            Baby temp = (Baby) baby.get(i);
            total += temp.getAge();
            count += 1;
        }
        average = (double) total/count;
        return average;
    }
    
    
}