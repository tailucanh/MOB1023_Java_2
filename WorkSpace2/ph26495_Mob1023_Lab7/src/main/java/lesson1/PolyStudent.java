/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lesson1;

/**
 *
 * @author HL COMPUTER
 */
enum listMajors {
    UDPM, LTMOBILE, TKWEB, TMDT;
}  //có thể khai báo ngoài hoặc trong class

public class PolyStudent {

    public String name;
    public listMajors majors;

    public void output() {
        System.out.println("Họ tên :" + name);
        switch (majors) {
            case UDPM:
                System.out.println("Ứng dụng phần mềm");
                break;

            case LTMOBILE:
                System.out.println("Lập trình mobile");
                break;

            case TKWEB:
                System.out.println("Thiết kế web");
                break;

            case TMDT:
                System.out.println("Thương mại điện tử");
                break;
        }
    }
    public static void main(String[] args) {
        PolyStudent sv = new PolyStudent();
        sv.name = "Lê văn A";
        sv.majors = listMajors.valueOf("LTMOBILE");
        sv.output();
    }

}
