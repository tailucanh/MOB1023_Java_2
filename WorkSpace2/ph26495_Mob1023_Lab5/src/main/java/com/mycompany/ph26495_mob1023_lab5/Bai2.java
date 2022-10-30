/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ph26495_mob1023_lab5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HL COMPUTER
 */
public class Bai2 {

    public static void main(String[] args) {
        List<SinhVien> listSv = new ArrayList<SinhVien>();

        listSv.add(new SinhVien("Le van a", 7, "UDPM"));
        listSv.add(new SinhVien("Le van b", 9, "MKT"));
        listSv.add(new SinhVien("Le van c", 4, "TMDT"));
        
        //Ghi vào file
        xFile.writeObj("lesson2.txt", listSv);
        //Đọc
        listSv = (List<SinhVien>) xFile.readObj("lesson2.txt");
        
        for(SinhVien sv : listSv ){
            System.out.println("Name :"+ sv.getName());
        }
        
    }

}
