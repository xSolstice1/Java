/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

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
    public String displayBaby(Baby[] arr){
        String msg = "";
        for (int i = 0; i< arr.length; i++){
            msg += "Name: " + arr[i].getName() + " Age: " + arr[i].getAge() + "\n";
        }
        return msg;
    }
    
    //calculate average age of all obj in the array and return as double
    public double getAverageAge(Baby[] arr){
        int total = 0;
        int count = 0;
        double average = 0;
        for (int i = 0; i < arr.length; i++){
            total += arr[i].getAge();
            count += 1;
        }
        average = (double) total/count;
        return average;
    }
    
    
}
