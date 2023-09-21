package assignment2;
import java.util.*;
import java.io.*;

/**
 * @author Ang Jin wei
 * @date 16 Mar 2023
 * @file Client.java
 * @description Allow entry of data for several students into ArrayList and perform analysis and queries.
 */

public class Client {
    private static ArrayList<Student> Students = new ArrayList<>();
    private static ArrayList<Unit> Units = new ArrayList<>();
    private static int count;
    private static int unitcount;
    
    public static void main(String[] args) {
        int choice = 0;
        boolean sorted = false;
        String csvfile;
        Scanner input = new Scanner(System.in);
        
        StudentInfo(); //print student info
        System.out.println("Please enter the name of the student csv file: ");
        csvfile = input.nextLine();
        
        importData(csvfile); //import data from csvfile
        //display menu and loop till user chooses 1
        while (choice != 1){
          choice = menu();
          if (choice == 2){
              optionTwo();
          }
          if (choice == 3){
              optionThree();
          }
          if (choice == 4){
              optionFour();
          }
          if (choice == 5){
              optionFive();
          }
          if (choice == 6){
              optionSix();
          }
          if (choice == 7){
              optionSeven();
              sorted = true;
          }
          if (choice == 8){
              optionEight(sorted);
          }
          if (choice == 1){
              System.out.println("Thanks for using, goodbye!");
              System.exit(0); //terminate program
          }
        }
    }
    
    //menu method, print out menu and return choice of user's input
    private static int menu(){
        int choice;
        Scanner input = new Scanner(System.in); //define scanner
        System.out.println("\n1. Quit (Exit the Program)");
        System.out.println("2. Add all the marks information about a course work student or a research student by reading it from another CSV file. ");
        System.out.println("3. Remove specific student and relevant information from the ArrayList.");
        System.out.println("4. Output all details currently held in array list.");
        System.out.println("5. Determine and display how many course work students obtained an overall mark equal to or above the average overall and how many obtained an overall mark below the average overall mark.");
        System.out.println("6. Report grade of a student.");
        System.out.println("7. Sort ArrayList in ascending order based on student ID.");
        System.out.println("8. Output sorted ArrayList to a CSV file. (Must sort ArrayList first)\n");
        choice = input.nextInt();
        input.nextLine();
        return choice; //return user choice
    }
    
    //import data from csv file
    //precondition: filename must be defined
    //postcondition: method will run through csv file and add data to arraylist
    private static void importData(String filename){
        try{
            Scanner readFile = new Scanner(new File(filename));
            while(readFile.hasNextLine()){ //check if file has next line
                String[] line = readFile.nextLine().split(",");
                if (line[0].equalsIgnoreCase("C")){
                    Students.add(new Student_Course(line[1],line[2],Long.parseLong(line[3])));
                }
                if (line[0].equalsIgnoreCase("R")){
                    Students.add(new Student_Research(line[1],line[2],Long.parseLong(line[3]))); //add student object to arraylist
                }
                count+=1; //add 1 to count
            }
            System.out.println("Data successfully imported!");
        }
        catch(FileNotFoundException e){ //catch filenotfound exception
            System.out.println("Can't open file "+filename+", please try again, the program will exit now.");
            System.exit(0);
        }
    }
    
    //optionTwo method: add data to arraylist from csv file specified by user
    //precondition: there must be an existing csv file and filename should be defined
    //postcondition: method will run through csv file and add data to the arraylist
    private static void optionTwo(){
        String filename;
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease enter the name of the marks csv file: "); //ask user for csv filename
        filename = input.nextLine();
        try{
            Scanner readFile = new Scanner(new File(filename));
            while(readFile.hasNextLine()){
               String[] line = readFile.nextLine().split(","); //split csv into array
                if (line[0].equalsIgnoreCase("C")){ //check if student is coursework
                    //add details to arraylist
                    Units.add(new Unit_Course(Long.parseLong(line[1]),line[2],Integer.parseInt(line[3]),line[0],Integer.parseInt(line[4]),Integer.parseInt(line[5]),Integer.parseInt(line[6])));
                    Units.get(unitcount).calculateOverall();;
                    Units.get(unitcount).calculateFinalGrade();
                    
                }
                if (line[0].equalsIgnoreCase("R")){ //check if student is research
                    //add details to arraylist
                    Units.add(new Research(Long.parseLong(line[1]),line[2],Integer.parseInt(line[3]),line[0],Integer.parseInt(line[4]),Integer.parseInt(line[5])));
                    Units.get(unitcount).calculateOverall();;
                    Units.get(unitcount).calculateFinalGrade();
                }
                unitcount += 1; //add 1 to count
            }
            System.out.println("\nData successfully added to the ArrayList.");
        }
        catch(FileNotFoundException e){
            System.out.println("\nCan't open file "+filename);
        }
    }
    
    //optionThree method: get user input for student ID and delete the object with the specific student ID
    //precondition: studentid should exist in the arraylist
    //postcondition: run through arraylist to see if student id exist, if so ask user for confirmation and delete the object
    private static void optionThree(){
        boolean found = false;
        long delete;
        String choice = "";
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease enter the Student ID of the student you want to delete: "); //ask user for student id
        delete = input.nextLong();
        input.nextLine();
        for (int i=0; i<Students.size(); i++){
            if (Students.get(i).getID() == delete){ //check if student id equals to user specified id
                found = true;
                System.out.println("Are you sure you want to delete this user? (Y/N)\n"); //ask user for confirmation
                System.out.println("Name: " + Students.get(i).getFirst() + " " + Students.get(i).getLast());
                System.out.println("Student ID: " + Students.get(i).getID()+"\n");
                choice = input.nextLine();
                if (choice.equalsIgnoreCase("Y")){ //check if user entered Y
                    Students.remove(i); //remove student
                    count -= 1;
                    for (int j=0; j<Units.size(); j++){
                        if (Units.get(j).getID() == delete){ //check if unit belongs to particular student
                            Units.remove(j); //remove unit
                            unitcount -= 1;
                            j-=1;
                        }
                    }
                }
            }
        }
        if (found == false){
            System.out.println("Student ID not found!");
        }
    }
    
    //optionFour method: display details held in array list
    //precondition: arraylist should be defined
    //postcondition: run through arraylist and display details in arraylist
    private static void optionFour(){
        String msg = "";
        for (int i=0; i<Students.size(); i++){ //loop through arraylist
            msg += "\n\nName: " + Students.get(i).getFirst() + " " + Students.get(i).getLast();
            msg += " Student ID: " + Students.get(i).getID();
            msg += " Enrolment Type: " + Students.get(i).getEnrolmentType();
            if (Students.get(i).getEnrolmentType().equalsIgnoreCase("C")){ //check if student is coursework
                for (int j=0; j<Units.size(); j++){
                    if (Units.get(j).getID() == Students.get(i).getID()){ //check if student id equal
                        //add details to msg
                        msg += "\nUnit ID: " + Units.get(j).getUnit();
                        msg += " Assignment 1: " + Units.get(j).getAssignment1();
                        msg += " Assignment 2: " + Units.get(j).getAssignment2();
                        msg += " Final Exam: " + Units.get(j).getFinal();
                        msg += " Overall Mark: " + Units.get(j).getOverall();
                        msg += " Final Grade: " + Units.get(j).finalreport();
                    }
                }
            }
            if (Students.get(i).getEnrolmentType().equalsIgnoreCase("R")){ //check if student is research
                for (int j=0; j<Units.size(); j++){
                    if (Units.get(j).getID() == Students.get(i).getID()){ //check if student id equal
                        //add details to msg
                        msg += "\nUnit ID: " + Units.get(j).getUnit();
                        msg += " Proposal: " + Units.get(j).getProposal();
                        msg += " Dissertation: " + Units.get(j).getDissertation();
                        msg += " Overall Mark: " + Units.get(j).getOverall();
                        msg += " Final Grade: " + Units.get(j).finalreport();
                    }
                }
            }
            
        }
        System.out.println(msg);
    }
    
    //optionFive method: run through arraylist and determine amount of student with higher or lower average mark for coursework students
    //precondition: arraylist must be defined, student must be coursework student
    //postcondition: display number of students with overall mark lower and above the average overall mark
    private static void optionFive(){
        int total = 0;
        int count = 0;
        double average = 0;
        int above = 0;
        int below = 0;
        String abovestudent = "";
        String belowstudent = "";
        
        for (int i=0; i<Units.size(); i++){
            if (Units.get(i).getEnrolmentType().equalsIgnoreCase("C")){ //check if unit is coursework unit
                total += Units.get(i).getOverall(); //add overall score to total score
                count += 1; //add 1 to count
            }
        }
        average = total/count; //calculate average totaloverallscore divided by number of coursework students
        for (int i=0; i<Units.size(); i++){
            if (Units.get(i).getOverall() > average && Units.get(i).getEnrolmentType().equalsIgnoreCase("C")){ //check if overall score higher than average
                above += 1; //add 1 to above average
                for (int j=0; j<Students.size(); j++){
                    if (Units.get(i).getID() == Students.get(j).getID()){
                        //add particular student details
                        abovestudent += "Name: " + Students.get(j).getFirst() + " " + Students.get(j).getLast() + "\n";
                        abovestudent += "Student ID: " + Students.get(j).getID() + "\n";
                        abovestudent += "Unit ID: " + Units.get(i).getUnit() + "\n";
                        abovestudent += "Overall Mark: " + Units.get(i).getOverall() + "\n\n";
                    }
                }
            }
            if (Units.get(i).getOverall() < average && Units.get(i).getEnrolmentType().equalsIgnoreCase("C")){ //check if overall score below than average
                below += 1; //add 1 to below average
                for (int j=0; j<Students.size(); j++){
                    if (Units.get(i).getID() == Students.get(j).getID()){
                        //add particular student details
                        belowstudent += "Name: " + Students.get(j).getFirst() + " " + Students.get(j).getLast() + "\n";
                        belowstudent += "Student ID: " + Students.get(j).getID() + "\n";
                        belowstudent += "Unit ID: " + Units.get(i).getUnit() + "\n";
                        belowstudent += "Overall Mark: " + Units.get(i).getOverall() + "\n\n";
                    }
                }
            }
        }
        System.out.println("\nThe average score is " + average);
        System.out.println("There are " + above + " students that got above the average score.");
        System.out.println("There are " + below + " students taht got below the average score.\n");
        System.out.println("The students who got above the average score are: \n" + abovestudent);
        System.out.println("The students who got below the average score are: \n" + belowstudent);
    }
    
    //optionSix method: ask user for input on student ID and report grade of the particular student
    //precondition: arraylist must be defined and student ID must exist in arraylist
    //postcondition: grades of the particular student will be displayed
    private static void optionSix(){
        long id;
        boolean found = false;
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease enter student ID of the student: "); //ask user for student ID
        id = input.nextLong();
        for (int i=0; i<Students.size(); i++){
            if (Students.get(i).getID() == id){ //loop through arraylist and check if student id is found
                System.out.println("\n"+Students.get(i).reportGrade(Units)); //report grade of the particular student
                found = true;
            }
        }
        if (found == false){
            System.out.println("\nStudent ID not found."); //if student id isn't found, display not found message
        }
    }
    
    //optionSeven method: use bubble sort to sort students in arraylist in ascending order based on student ID
    //precondition: arraylist must be defined
    //postcondition: arraylist will be sorted in ascending order
    private static void optionSeven(){
        Student temp;
        for (int i=0; i<Students.size(); i++){
            for (int j=0; j<Students.size()-i-1; j++){
                if (Students.get(j).getID() > Students.get(j+1).getID()){
                    temp = Students.get(j);
                    Students.set(j,Students.get(j+1));
                    Students.set(j+1, temp);
                    
                }
            }
        }
        System.out.println("\nArrayList successfully sorted!");
    }
    
    //optionEight method: output arraylist to csv file defined by user
    //precondition: arraylist must be defined, arraylist must be sorted
    //postcondition: output the arraylist to csv file
    private static void optionEight(boolean sorted){
        String outputfile = "";
        PrintWriter output = null; //define null printwriter
        String data = "";
        Scanner input = new Scanner(System.in); //define scanner
        if (sorted == true){
            System.out.println("\nPlease enter the name of the output csv file: "); //ask user for output file name
            outputfile = input.nextLine();
            //start of try-block
            try{
                output = new PrintWriter(new File(outputfile));
                for (int i=0; i < Students.size(); i++){
                    if (Students.get(i).getEnrolmentType().equalsIgnoreCase("C")){ //check if student is coursework student
                        //add data from arraylist to data variable
                        data += Students.get(i).getEnrolmentType() + ",";
                        data += Students.get(i).getFirst() + ",";
                        data += Students.get(i).getLast() + ",";
                        data += Students.get(i).getID() + "\n";
                        for (int j=0; j < Units.size(); j++){
                            if (Units.get(j).getID() == Students.get(i).getID()){
                                data += Units.get(j).getUnit() + ",";
                                data += Units.get(j).getLevel() + ",";
                                data += Units.get(j).getAssignment1() + ",";
                                data += Units.get(j).getAssignment2() + ",";
                                data += Units.get(j).getFinal() + ",";
                                data += Units.get(j).getOverall() + ",";
                                data += Units.get(j).finalreport() + "\n\n";
                            }
                        }
                    }
                    if (Students.get(i).getEnrolmentType().equalsIgnoreCase("R")){ //check if student is research student
                        //add data from arraylist to datavariable
                        data += Students.get(i).getEnrolmentType() + ",";
                        data += Students.get(i).getFirst() + ",";
                        data += Students.get(i).getLast() + ",";
                        data += Students.get(i).getID() + "\n";
                        for (int j=0; j < Units.size(); j++){
                            if (Units.get(j).getID() == Students.get(i).getID()){
                                data += Units.get(j).getUnit() + ",";
                                data += Units.get(j).getLevel() + ",";
                                data += Units.get(j).getProposal() + ",";
                                data += Units.get(j).getDissertation() + ",";
                                data += Units.get(j).getOverall() + ",";
                                data += Units.get(j).finalreport() + "\n\n";
                            }
                        }
                    }
                }
                output.write(data); //write data to csv file
                System.out.println("Data successfully output to "+outputfile+" in your project directory.");
                output.close();
            }
            //end of try-block
            catch(FileNotFoundException e){
                System.out.println("Can't open file "+outputfile);
            }
        }
        else{
            System.out.println("Please sort the ArrayList first!");
        }
    }
    
    //StudentInfo method: Print out student's information
    public static void StudentInfo(){
        String msg = "";
        
        msg += "Name: Ang Jin Wei";
        msg += "\nStudent Number: 34792195";
        msg += "\nMode of Enrolment: Part-Time";
        msg += "\nTutor Name: Steven Loke";
        msg += "\nClass: ICT284 B";
        System.out.println(msg+"\n");
    }

}