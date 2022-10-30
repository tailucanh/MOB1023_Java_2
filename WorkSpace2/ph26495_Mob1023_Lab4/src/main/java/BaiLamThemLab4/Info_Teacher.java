/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiLamThemLab4;

/**
 *
 * @author HL COMPUTER
 */
public class Info_Teacher {
    
    private String id;
    private String name;
    private String faculity;

    public Info_Teacher() {
        
    }

    public Info_Teacher(String id, String name, String faculity) {
        this.id = id;
        this.name = name;
        this.faculity = faculity;
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

    public String getFaculity() {
        return faculity;
    }

    public void setFaculity(String faculity) {
        this.faculity = faculity;
    }
    

}
