/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab9;

/**
 *
 * @author jinweiang
 */
public class TutorialSpace {
    private int slots;
    private boolean activated = false;
    
    public TutorialSpace(int n){
        this.slots = n;
    }
    
    public void activate(){
        try{
            if (this.activated == true){
                throw new ActivatedException();
            }
            else{
                this.activated = true;
            }
        }
        catch(ActivatedException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void reserveSlot(){
        try{
            if (this.activated == false){
                throw new NotActivatedException();
            }
            if (this.slots < 1){
                throw new EmptyException();
            }
            else{
                this.slots -= 1;
            }
        }
        catch(NotActivatedException e){
            System.out.println(e.getMessage());
        }
        catch(EmptyException e){
            System.out.println(e.getMessage());
        }
    }
    
    public int slotsRemaining(){
        return this.slots;
    }
}
    

