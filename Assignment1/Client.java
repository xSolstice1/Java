package assignment1;

/**
 *
 * @author Ang Jin Wei
 * @date 8 Feb 2023
 * @filename Client.java
 * @
 */

public class Client {
    public static void main(String[] args) {
        Changecoin personArr[] = new Changecoin[10]; //initialize array of size 10
        Changecoin coinobj = new Changecoin(); //create new Changecoin class object
        int choice = 0;
        
        //testing(personArr);
        coinobj.StudentInfo();
        System.out.println("Enter a maximum of 10 records.\n");
        coinobj.userInput(personArr);
        while (choice != 6){
            choice = coinobj.menu();
            switch(choice){
                case 1:
                    coinobj.optionOne(personArr);
                    break;
                case 2:
                    coinobj.optionTwo(personArr);
                    break;
                case 3:
                    coinobj.optionThree(personArr);
                    break;
                case 4:
                    coinobj.optionFour(personArr);
                    break;
                case 5:
                    coinobj.optionFive(personArr);
                    break;
            }
            if (choice < 1 || choice > 6){
                System.out.println("\nInvalid choice, please try again.\n");
            }
        }
        System.out.println("Thank you for using, good bye!");

    }
  
    //hardcoded method to store 10 Changecoin objects in the array
    public static void testing(Changecoin[] arr){
        arr[0] = new Changecoin("John",95);
        arr[1] = new Changecoin("Mary", 65);
        arr[2] = new Changecoin("Peter", 45);
        arr[3] = new Changecoin("Fred", 85);
        arr[4] = new Changecoin("Tom", 90);
        arr[5] = new Changecoin("Jane", 40);
        arr[6] = new Changecoin("May", 75);
        arr[7] = new Changecoin("Alfred", 30);
        arr[8] = new Changecoin("Carmen", 15);
        arr[9]= new Changecoin("Poka", 25);
        
     }
    
}
