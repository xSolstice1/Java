/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

/**
 *
 * @author jinweiang
 */
public class registerClass {
    
    public static void main(String[] args) {
        TutorialSpace obj = new TutorialSpace(1);
        testNotActivated(obj); //class hasn't been activated, should throw exception is not activated
        testActivated(obj); //tries to activate class twice, should throw exception class already activated
        testEmpty(obj); //tries to reserve slot twice, should throw exception after slot is empty
    }
    
    private static void testActivated(TutorialSpace obj){
        obj.activate(); //set activated = true
        obj.activate(); //should throw exception already activated
    }
    
    private static void testEmpty(TutorialSpace obj){
        obj.reserveSlot(); //slot minus 1
        obj.reserveSlot(); //should throw exception slot is empty
    }
    
    private static void testNotActivated(TutorialSpace obj){
        obj.reserveSlot(); //should throw exception class not activated
    }
    
}
