/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ph26495_ktlab6;

import java.io.Serializable;

/**
 *
 * @author HL COMPUTER
 */
public class CanBo implements Serializable{
    
    private String id;
    private  String name;
    private double salary;
    private  String phong;

    public CanBo() {
    }

    public CanBo(String id, String name, double salary, String phong) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.phong = phong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    
    
}
