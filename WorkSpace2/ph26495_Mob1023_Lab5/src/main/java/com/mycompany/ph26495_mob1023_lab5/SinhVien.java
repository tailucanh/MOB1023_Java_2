/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ph26495_mob1023_lab5;

import java.io.Serializable;

/**
 *
 * @author HL COMPUTER
 */
public class SinhVien implements  Serializable{

    private String name;
    private double point;
    private String marjor;

    public SinhVien() {
    }

    public SinhVien(String name, double point, String marjor) {
        this.name = name;
        this.point = point;
        this.marjor = marjor;
    }



    public String HocLuc() {
        String kq = "";
        if (this.point < 5 && this.point > 0) {
            kq = "Yếu";
        } else if (this.point < 7) {
            kq = "Tb";
        } else if (this.point < 8) {
            kq = "Khá";
        } else if(this.point <= 10){
            kq = "Giỏi";
        }else {
            kq = "Null";
        }
        return kq;
    }
    
    public boolean  phanThuong(){
        return  this.point > 8;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getMarjor() {
        return marjor;
    }

    public void setMarjor(String marjor) {
        this.marjor = marjor;
    }


}
