/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bailamthemLab3.poly.java;

/**
 *
 * @author HL COMPUTER
 */
public class NhanVien {
        private String maCb;
        private String hoTen;
        private double  luong;
        private String chucVu;

        public double  thue(){
            double thueThuNhap = 0;
            if(this.luong < 9000000 && this.luong > 0){
                thueThuNhap = this.luong*0.1;
            }else if(this.luong >= 9000000 && this.luong < 20000000){
                  thueThuNhap = this.luong*0.15;
            }else if(this.luong >= 20000000){
                thueThuNhap = this.luong*0.2;
            }else{
                thueThuNhap = 0;
            }
            return  thueThuNhap;
        }
        
    public String getMaCb() {
        return maCb;
    }

    public void setMaCb(String maCb) {
        this.maCb = maCb;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
        
        
       
        
}
