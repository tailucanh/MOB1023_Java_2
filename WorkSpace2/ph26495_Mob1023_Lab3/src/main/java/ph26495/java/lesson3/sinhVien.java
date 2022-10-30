/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph26495.java.lesson3;

/**
 *
 * @author HL COMPUTER
 */
public class sinhVien {
    private String ten;
    private double  diem;
    private String nganh;
    //Lớp học lực
    public String hocLuc(){
        String kq = null;
        if(this.diem < 5){
            kq = "Yếu";
        }else if(this.diem < 7){
            kq = "Trung bình";
        }
        else if(this.diem < 8){
            kq = "Khá";
        }
        else if(this.diem < 9){
            kq = "Giỏi";
        }else {
            kq = "Xuất sắc";
        }
        
        return kq;
    }
    //Lớp phần thưởng
    public boolean  phanThuong(){
        return this.diem > 8;
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

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }
    
    
    
    
}
