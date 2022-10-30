/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ph26495_mob1023_lab5;

import bai3.NhanVien;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author HL COMPUTER
 */
public class xFile {

    public static void writeObj(String path, Object object) {
        try {
           
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)); //ghi dữ liệu
            oos.writeObject(object);//Ghi đối tượng lên dữ liệu

            oos.flush();   //Đẩy dữ liệu vào luồng 
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object readObj(String path) {
         Object list=null;
        try {
             FileInputStream fis=new FileInputStream(path);//đọc dữ liệu từ file nhị phân
            ObjectInputStream ois=new ObjectInputStream(fis);
            list=ois.readObject();//đọc đối tượng
            ois.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
       return list;
    }
    

    
  
}
