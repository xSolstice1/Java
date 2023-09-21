package assignment2;

/**
 *
 * @author Ang Jin wei
 * @date 16 Mar 2023
 * @file Unit_Course.java
 * @description Unit_Course, sub-class of Unit class
 */

public class Unit_Course extends Unit{
    private int assignment1;
    private int assignment2;
    private int finalexam;
    private double overall;
    private String finalGrade;
    
    public Unit_Course(long studentid, String unitid, int level, String enrolmenttype, int first, int second, int last){
        super(studentid, unitid, level, "C");
        this.assignment1 = first;
        this.assignment2 = second;
        this.finalexam = last;
        this.overall = 0;
        this.finalGrade = "";
    }
    
    //start of accessor methods
    public int getAssignment1(){
        return this.assignment1;
    }
    
    public int getAssignment2(){
        return this.assignment2;
    }
    
    public int getFinal(){
        return this.finalexam;
    }
    
    public double getOverall(){
        return this.overall;
    }
    
    public String finalreport(){
        return this.finalGrade;
    }
    //end of accessor methods
    
    public void calculateOverall(){
        double assignment;
        double result;
        assignment = (this.assignment1*0.3)+(this.assignment2*0.3); //calculate assignment mark 30% each of overall
        result = assignment + (this.finalexam*0.4); //calculate final exam mark 40% of overall
        result = Math.round(result*100.0)/100.0; //round up to nearest decimal
        this.overall = result;
    }
    
    //calculate final grade
    // HD = 80 or above
    // D = 70 or above and below 80
    // C = 60 or above and below 70
    // P = 50 or above and below 60
    // N = below 50
    public void calculateFinalGrade(){
        if (this.getOverall() >= 80){
            this.finalGrade = "HD";
        }
        if (this.getOverall() >= 70 && this.getOverall() < 80){
            this.finalGrade = "D";
        }
        if (this.getOverall() >= 60 && this.getOverall() < 70){
            this.finalGrade = "C";
        }
        if (this.getOverall() >= 50 && this.getOverall() < 60){
            this.finalGrade = "P";
        }
        if (this.getOverall() < 50){
            this.finalGrade = "N";
        }
    }
}