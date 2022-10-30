/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test15_06;

import java.io.Serializable;

/**
 *
 * @author HL COMPUTER
 */
public class HocSinh implements Serializable{
    
    private String name;
    private double  point;
    private String heHoc;

    public HocSinh() {
    }

    public HocSinh(String name, double point, String heHoc) {
        this.name = name;
        this.point = point;
        this.heHoc = heHoc;
    }
    
    public String xepLoai(double  point){
        String kq = null;
        if(point < 30){
            kq = " Rớt";
        }else {
                   kq = " Đỗ";
        }
        
        
        return kq;
        
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

    public String getHeHoc() {
        return heHoc;
    }

    public void setHeHoc(String heHoc) {
        this.heHoc = heHoc;
    }
    
    
    
}
