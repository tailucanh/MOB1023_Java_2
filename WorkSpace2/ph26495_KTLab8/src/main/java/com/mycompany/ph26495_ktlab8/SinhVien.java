/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ph26495_ktlab8;

import java.io.Serializable;

/**
 *
 * @author HL COMPUTER
 */
public class SinhVien  implements  Serializable{
    private String name;
    private double  salary;
    private String khoa;

    public SinhVien() {
    }

    public SinhVien(String name, double salary, String khoa) {
        this.name = name;
        this.salary = salary;
        this.khoa = khoa;
    }
    
    public String xepLoai(double  salary){
        String xl = null;
        if(salary > 0 && salary < 8000000){
            xl = "Thấp";
        }else if(salary >= 8000000 && salary < 15000000){
              xl = "Trung bình";
        }else if(salary >= 15000000){
            xl = "Cao";
        }
        
        
        return  xl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
    
    
    
    
    
}
