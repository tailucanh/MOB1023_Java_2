/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lesson4;

import javax.swing.JOptionPane;

/**
 *
 * @author HL COMPUTER
 */
public class Xpoly {

    public static boolean isCardNumber(String number) {
        int n = Integer.parseInt(number);
        double sum = 0;
        while (n > 0) {
            int a = n % 10;
            n = n / 10;
            sum += a;
        }

        if (sum % 2 == 0) {
            return true;
        } else {
            return false;
        }

    }

}
