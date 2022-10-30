/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ph26495_ktlab7;

import java.io.Serializable;

/**
 *
 * @author HL COMPUTER
 */
public class GiaoVien implements Serializable{
    private String ten;
    private double  diem;
    private String gioitinh;
   

    public GiaoVien() {
    }

    public GiaoVien(String ten, double diem, String gioitinh) {
        this.ten = ten;
        this.diem = diem;
        this.gioitinh = gioitinh;
 
    }
    
    
    
    
    public String xepLoai(double  diem){
        String xeploai = null;
        if(diem < 5 && diem > 0){
           xeploai = "Yếu";
        }else if(diem >= 5 && diem < 7){
            xeploai = "Khá";
        }else{
            xeploai = "Tốt";
        }
       
         return  xeploai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
    
    
}
