/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8;

/**
 *
 * @author jinweiang
 */
public class Patient extends Baby{
    private int idnum;
        
    public Patient(String name, int age, int id) {
        super(name, age);
        idnum = id;
    }
        
    public int getID(){
        return this.idnum;
    }
        
    public void setID(int num){
        this.idnum = num;
    }
        
    public boolean equals(Patient obj){
        boolean equal;
        if (this.getID() == obj.getID()){
            equal = true;
        }
        else{
            equal = false;
        }
        return equal;
        } 
    public String BabySound(){
        return "Baby Sound is Sick";
    }
    
    }
