/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab9;

/**
 *
 * @author jinweiang
 */
public class TutorialSpaceAssertion {
    private int slots;
    private boolean activated = false;
    
    public TutorialSpaceAssertion(int n){
        this.slots = n;
    }
    
    public void activate(){
        assert (this.activated != true): "Exception: Class is already activated";
        this.activated = true;
    }
    
    public void reserveSlot(){
        assert (this.activated == true): "Exception: Class is not activated!";
        assert (this.slots > 0): "Exception: No slots remaining in the class!";
        this.slots -= 1;
    }
    
    public int slotsRemaining(){
        return this.slots;
    }
}
    

