package assignment2;
import java.util.*;
import java.io.*;

/**
 *
 * @author Ang Jin wei
 * @date 16 Mar 2023
 * @file Student_Course.java
 * @description Student_Course, sub-class of Student Class
 */

public class Student_Course extends Student{
    private String enrolmenttype;
    
    public Student_Course(String first, String last, long id){
        super(first, last, id);
        this.enrolmenttype = "C";
    }
    
    //start of accessor methods
    public String getEnrolmentType(){
        return this.enrolmenttype;
    }
    //end of accessor methods
    
    //display information and grade of student
    public String reportGrade(ArrayList Units){
        String msg = "";
        msg += "Enrolment Type: " + this.getEnrolmentType() + "\n";
        msg += "First Name: " + this.getFirst() + "\n";
        msg += "Last Name: " + this.getLast() + "\n";
        msg += "Student ID: " + this.getID() + "\n";
        
        for (int i=0; i<Units.size(); i++){
            Unit temp = (Unit) Units.get(i); //cast temp as Unit type object
            if (this.getID() == temp.getID()){
                msg += "\nUnit ID: " + temp.getUnit() + "\n";
                msg += "Assignment 1 Mark: " + temp.getAssignment1() + "\n";
                msg += "Assignment 2 Mark: " + temp.getAssignment2() + "\n";
                msg += "Final Exam Mark: " + temp.getFinal() + "\n";
                msg += "Overall Mark: " + temp.getOverall() + "\n";
                msg += "Final Grade: " + temp.finalreport() + "\n";
            }
        }
        return msg;
    }
    
}