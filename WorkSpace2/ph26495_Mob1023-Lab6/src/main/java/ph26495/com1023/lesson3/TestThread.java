/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph26495.com1023.lesson3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HL COMPUTER
 */
public class TestThread {
    public static void main(String[] args) {
          OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();
     
        try {
            oddThread.start();
            oddThread.join();
            evenThread.start();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestThread.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
 
    
    
}
