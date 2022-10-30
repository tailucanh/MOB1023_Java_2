/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.test15_06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HL COMPUTER
 */
public class QlHB extends javax.swing.JFrame {

    ArrayList<HocSinh> listHs = new ArrayList<>();
    int index;

    public QlHB() {
        initComponents();
        listHs.add(new HocSinh("Le van a", 36, "Chính quy"));
        listHs.add(new HocSinh("Le van b", 26, "Liên thông"));
        listHs.add(new HocSinh("Le van a", 52, "Chính quy"));
        findToTable();
        showData(index);
    }

    public void insert() {
        try {
            if (txtName.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Hãy nhập tên!");
            } else if (txtPoint.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Hãy nhập điểm!");
            } else if (Double.parseDouble(txtPoint.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Hãy nhập lớn hơn 0!");
            } else if (!rdoChinhQuy.isSelected() && !rdoLienThong.isSelected()) {
                JOptionPane.showMessageDialog(this, "Hãy chọn hệ học!");
            } else {
                HocSinh hs = new HocSinh();
                hs.setName(txtName.getText().toString());
                hs.setPoint(Double.parseDouble(txtPoint.getText()));
                hs.setHeHoc(rdoChinhQuy.isSelected() ? rdoChinhQuy.getText() : rdoLienThong.getText());

                listHs.add(hs);
                findToTable();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hãy nhập điểm là số !");
        }
    }

    public void findToTable() {
        DefaultTableModel model = (DefaultTableModel) lblHocSinh.getModel();
        model.setRowCount(0);
        for (HocSinh hs : listHs) {
            Object[] obj = new Object[]{
                hs.getName(), hs.getPoint(), hs.getHeHoc(), hs.xepLoai(hs.getPoint())
            };
            model.addRow(obj);
        }
    }

    public void showData(int index) {
        txtName.setText((String) lblHocSinh.getValueAt(index, 0));
        txtPoint.setText(lblHocSinh.getValueAt(index, 1) + "");
        if (lblHocSinh.getValueAt(index, 2).equals(rdoChinhQuy.getText())) {
            rdoChinhQuy.setSelected(true);
            rdoLienThong.setSelected(false);
        } else {
            rdoChinhQuy.setSelected(false);
            rdoLienThong.setSelected(true);
        }
    }

    public void delete() {
        index = lblHocSinh.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy đối tượng để xóa !");
        } else {
            listHs.remove(index);
            reset();
            findToTable();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        }

    }

    public void update(int index) {
        index = lblHocSinh.getSelectedRow();
        if (index >= 0) {
            HocSinh hs = listHs.get(index);
            hs.setName(txtName.getText().toString());
            hs.setPoint(Double.parseDouble(txtPoint.getText()));
            hs.setHeHoc(rdoChinhQuy.isSelected() ? "Chính quy" : "Liên thông");
            findToTable();
            JOptionPane.showMessageDialog(this, "Update thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Update không thành công!");
        }
    }

    public void reset() {
        txtName.setText("");
        txtPoint.setText("");
        rdoChinhQuy.setSelected(false);
        rdoLienThong.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPoint = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        rdoLienThong = new javax.swing.JRadioButton();
        rdoChinhQuy = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblHocSinh = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnWrite = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Quản lí xét học bạ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 260, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setText("Hệ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel3.setText("Họ và tên");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel4.setText("Điểm");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));
        getContentPane().add(txtPoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 220, 30));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 220, 30));

        buttonGroup1.add(rdoLienThong);
        rdoLienThong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoLienThong.setText("Liên thông");
        rdoLienThong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoLienThongActionPerformed(evt);
            }
        });
        getContentPane().add(rdoLienThong, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        buttonGroup1.add(rdoChinhQuy);
        rdoChinhQuy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoChinhQuy.setText("Chính quy");
        rdoChinhQuy.setBorderPainted(true);
        getContentPane().add(rdoChinhQuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        lblHocSinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ và tên", "Điểm", "Hệ", "Xếp loại"
            }
        ));
        lblHocSinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHocSinhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lblHocSinh);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 560, 200));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 80, 30));

        btnOpen.setText("Đọc");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });
        getContentPane().add(btnOpen, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 80, 30));

        btnWrite.setText("Ghi");
        btnWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWriteActionPerformed(evt);
            }
        });
        getContentPane().add(btnWrite, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 80, 30));

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 80, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoLienThongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoLienThongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoLienThongActionPerformed

    private void lblHocSinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHocSinhMouseClicked
        index = lblHocSinh.getSelectedRow();
        showData(index);
    }//GEN-LAST:event_lblHocSinhMouseClicked

    private void btnWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWriteActionPerformed
        insert();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("thithu.txt"));
            oos.writeObject(listHs);
            oos.flush();
            oos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(QlHB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QlHB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnWriteActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update(index);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("thithu.txt"));
            listHs = (ArrayList<HocSinh>) ois.readObject();
            findToTable();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(QlHB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QlHB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QlHB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnOpenActionPerformed

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
            java.util.logging.Logger.getLogger(QlHB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QlHB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QlHB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QlHB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QlHB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnWrite;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable lblHocSinh;
    private javax.swing.JRadioButton rdoChinhQuy;
    private javax.swing.JRadioButton rdoLienThong;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPoint;
    // End of variables declaration//GEN-END:variables
}