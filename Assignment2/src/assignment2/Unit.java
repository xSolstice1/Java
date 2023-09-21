package assignment2;

/**
 *
 * @author Ang Jin wei
 * @date 16 Mar 2023
 * @file Unit.java
 * @description Unit Class
 */

public class Unit {
    private String unitid;
    private long studentid;
    private int level;
    private String enrolmenttype;
    
    //default constructor
    public Unit(){
        this.unitid = "NA";
        this.studentid = 0;
        this.level = 0;
        this.enrolmenttype = "NA";
    }
    
    //parametized constructor
    public Unit(long studentid, String unitid, int level, String enrolmenttype){
        this.studentid = studentid;
        this.unitid = unitid;
        this.level = level;
        this.enrolmenttype = enrolmenttype;
    }
    
    //start of accessor methods
    public String getUnit(){
        return this.unitid;
    }
    
    public long getID(){
        return this.studentid;
    }
    
    public int getLevel(){
        return this.level;
    }
    
    public int getAssignment1(){
        return 0;
    }
    
    public int getAssignment2(){
        return 0;
    }
    
    public int getFinal(){
        return 0;
    }
    
    public int getDissertation(){
        return 0;
    }
    
    public int getProposal(){
        return 0;
    }
    
    public String getEnrolmentType(){
        return this.enrolmenttype;
    }
    
    public double getOverall(){
        return 0;
    }
    
    public String finalreport(){
        return "NA";
    }
    //end of accessor methods
    
    public void calculateOverall(){
    }
    
    public void calculateFinalGrade(){
    }
}