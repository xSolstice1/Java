package assignment2;
import java.util.*;
import java.io.*;

/**
 *
 * @author Ang Jin wei
 * @date 16 Mar 2023
 * @file Student_Research.java
 * @description Student_Research, sub-class of Student Class
 */

public class Student_Research extends Student{
    private String enrolmenttype;
    
    public Student_Research(String first, String last, long id){
        super(first, last, id);
        this.enrolmenttype = "R";
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
                msg += "Proposal: " + temp.getProposal() + "\n";
                msg += "Dissertation: " + temp.getDissertation() + "\n";
                msg += "Overall Mark: " + temp.getOverall() + "\n";
                msg += "Final Grade: " + temp.finalreport() + "\n";
            }
        }
        return msg;
    }
    
}