/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ph26495_ktlab5;

import java.io.Serializable;

/**
 *
 * @author HL COMPUTER
 */
public class SinhVien   implements  Serializable{
        private String id;
        private String hoTen;
        private double  diem;
        private String nganh;

    public SinhVien() {
    }

    public SinhVien(String id, String hoTen, double diem, String nganh) {
        this.id = id;
        this.hoTen = hoTen;
        this.diem = diem;
        this.nganh = nganh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }
        
        
        
        
    
}
