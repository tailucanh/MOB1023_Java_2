/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph26495.com21023.lesson1;

/**
 *
 * @author HL COMPUTER
 */
public class MyThread extends Thread{
    
    @Override
    public void run(){
        for (int i = 0 ; i <= 10; i++){
            System.out.println(i);
            try {
                    Thread.sleep(500);
                } catch (Exception e) {
                        e.printStackTrace();
                    break;
                }
        }
    }
    
    
}
