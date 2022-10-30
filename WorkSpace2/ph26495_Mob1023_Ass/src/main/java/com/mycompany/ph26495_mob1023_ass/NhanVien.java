/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ph26495_mob1023_ass;

import java.io.Serializable;

/**
 *
 * @author HL COMPUTER
 */
public class NhanVien implements  Serializable{
    private String id;
    private String fullName;
    private int age;
    private String email;
    private double  salary;

    public NhanVien() {
    }

    public NhanVien(String id, String fullName, int age, String email, double salary) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.salary = salary;
    }

    
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
    
    
    
}
