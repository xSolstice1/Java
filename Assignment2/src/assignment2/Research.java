package assignment2;

/**
 *
 * @author Ang Jin wei
 * @date 16 Mar 2023
 * @file Research.java
 * @description Research, sub-class of Unit Class
 */

public class Research extends Unit{
    private int proposal;
    private int dissertation;
    private double overall;
    private String finalGrade;
    
    public Research(long studentid, String unitid, int level, String enrolmenttype, int first, int second){
        super(studentid, unitid, level, "R");
        this.proposal = first;
        this.dissertation = second;
        this.overall = 0;
    }
    
    //start of accessor methods
    public int getProposal(){
        return this.proposal;
    }
    
    public int getDissertation(){
        return this.dissertation;
    }
    
    public double getOverall(){
        return this.overall;
    }
    
    public String finalreport(){
        return this.finalGrade;
    }
    //end of accessor methods
    
    public void calculateOverall(){
        double result;
        result = (this.proposal*0.4) + (this.dissertation*0.6); //calculate proposal mark 40% and disseration 60%
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