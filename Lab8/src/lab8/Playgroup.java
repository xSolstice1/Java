/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8;

/**
 *
 * @author jinweiang
 */
public class Playgroup extends Baby{
    public Playgroup(String name, int age){
        super(name, age);
    }
        
    public boolean equals(Playgroup obj){
        boolean equal;
        if (this.getName().equalsIgnoreCase(obj.getName()) && this.getAge() == obj.getAge()){
            equal = true;
        }
        else{
            equal = false;
        }
        return equal;
    }
    
    public String BabySound(){
        return "Baby Sound is Happy";
    }
        
    }
