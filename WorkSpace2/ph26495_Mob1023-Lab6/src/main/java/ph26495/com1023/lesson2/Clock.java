/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ph26495.com1023.lesson2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HL COMPUTER
 */
public class Clock extends javax.swing.JFrame {

    /**
     * Creates new form Clock
     */
    public Clock() {
        initComponents();
        clockTime();
    }

    public void clockTime() {
//       Lớp nặc danh hoặc   
//  Thread r1 = new Thread(){
//            
//        };   t1.start();
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        SimpleDateFormat spDateFormat = new SimpleDateFormat();
                        spDateFormat.applyPattern("hh:mm:ss aa");  //đưa ra chuỗi định dạng
                        Date dateNow = new Date();  //lấy ngày h hiện tại
                        String time = spDateFormat.format(dateNow);
                        lblClock.setText(time);
                        
                        Thread.sleep(1000);
                        
                                            
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblClock = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblClock.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblClock.setText("jLabel1");
        getContentPane().add(lblClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 230, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Clock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblClock;
    // End of variables declaration//GEN-END:variables
}