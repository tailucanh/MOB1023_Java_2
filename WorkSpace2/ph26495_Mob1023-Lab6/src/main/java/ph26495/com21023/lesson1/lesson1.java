/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph26495.com21023.lesson1;

/**
 *
 * @author HL COMPUTER
 */
public class lesson1 {
    public static void main(String[] args) {
        MyThread thread1= new MyThread();
        MyThread thread2 = new MyThread();
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        
        
        thread1.start();
        
        
    }
}
