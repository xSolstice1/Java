/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

/**
 *
 * @author jinweiang
 * please enable assertion if not already done so
 */

public class registerClassAssertion {
    
    public static void main(String[] args) throws Exception{
        TutorialSpaceAssertion obj = new TutorialSpaceAssertion(1);
        //testNotActivated(obj); //to test for not activated assertion
        //testEmpty(obj); //to test for slots empty assertion
        testActivated(obj); //to test for already activated assertion
    }
    
    public static void testActivated(TutorialSpaceAssertion obj){
        obj.activate();
        obj.activate(); //exception class already activated should be thrown
    }
    
    public static void testEmpty(TutorialSpaceAssertion obj){
        obj.activate();
        obj.reserveSlot();
        obj.reserveSlot(); //exception no slots remaining should be thrown
    }
    
    public static void testNotActivated(TutorialSpaceAssertion obj){
        obj.reserveSlot(); //exception class not activated should be thrown
    }
}
