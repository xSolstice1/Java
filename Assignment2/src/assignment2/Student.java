package assignment2;
import java.util.*;
import java.io.*;

/**
 *
 * @author Ang Jin wei
 * @date 16 Mar 2023
 * @file Student.java
 * @description Student Class
 */

public class Student {
    private String firstname;
    private String lastname;
    private long studentid;
    
    //default constructor
    public Student(){
        this.firstname = "NA";
        this.lastname = "NA";
        this.studentid = 0;
    }
    
    //parametized constructor
    public Student(String first, String last, long id){
        this.firstname = first;
        this.lastname = last;
        this.studentid = id;
    }
    
    //start of accessor methods
    public String getFirst(){
        return this.firstname;
    }
    
    public String getLast(){
        return this.lastname;
    }
    
    public long getID(){
        return this.studentid;
    }
    
    public String getEnrolmentType(){
        return "NA";
    }
    //end of accessor methods
    
    public String reportGrade(ArrayList Units){
        return "There is no grade here.";
    }
    
    public boolean equals(Student obj){
        boolean equal;
        if (this.studentid == obj.getID()){
            equal = true;
        }
        else{
            equal = false;
        }
        if (obj == this){
            equal = false;
        }
        return equal;
    }
    
}