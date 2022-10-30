/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ph26495.java.lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HL COMPUTER
 */
public class lesson3 extends javax.swing.JFrame {

    List<sinhVien> listSv = new ArrayList<sinhVien>();

    //Hàm thêm dữ liệu 
    public void add() {
        if (txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập tên !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (new String(txtPoint.getText()).equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập điểm !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (Double.parseDouble(txtPoint.getText()) < 0 || Double.parseDouble(txtPoint.getText()) > 10) {
                JOptionPane.showMessageDialog(this, "Hãy nhập điểm trong khoảng [1,10] !", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hãy nhập điểm là số  !", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

        sinhVien sv = new sinhVien();
        sv.setTen(txtName.getText());
        sv.setDiem(Double.parseDouble(txtPoint.getText()));
        sv.setNganh((String) cboNganh.getSelectedItem());
        txtHocLuc.setText(sv.hocLuc());
        chkCheck.setSelected(sv.phanThuong());

        listSv.add(sv);

    }

    //Hàm đổ dữ liệu vào bảng 
    public void findTable() {
        DefaultTableModel model = (DefaultTableModel) tblList.getModel();
        model.setRowCount(0);
        for (sinhVien sv : listSv) {
            Object[] row = new Object[]{
                sv.getTen(), sv.getDiem(), sv.getNganh(), sv.hocLuc(), sv.phanThuong()
            };
            model.addRow(row);  //Đổ dữ liệu theo dòng

        }
    }

    //Hàm hiện dữ liệu từ bảng vào form
    public void showDeltal() {
        int index = tblList.getSelectedRow();
        txtName.setText((String) tblList.getValueAt(index, 0));          //Cột 1
        txtPoint.setText(tblList.getValueAt(index, 1) + "");           //Cột 2
        cboNganh.setSelectedItem(tblList.getValueAt(index, 2));
        txtHocLuc.setText((String) tblList.getValueAt(index, 3));
        chkCheck.setSelected((boolean) tblList.getValueAt(index, 4));

    }

    //Hàm xóa 
    public void reset() {
        txtName.setText("");
        txtPoint.setText("");
        txtHocLuc.setText("");
        txtHocLuc.setText("");
        chkCheck.setSelected(false);
    }

    //hàm xóa bảng
    public void delete() {
        int index = tblList.getSelectedRow();
        int choice = (JOptionPane.showConfirmDialog(this, "Xóa thông tin người dùng?", "Confirm", JOptionPane.YES_NO_OPTION));
        if (choice == JOptionPane.YES_OPTION) {
            listSv.remove(index);
            findTable();
            JOptionPane.showMessageDialog(this, "Đã xóa người dùng trong list!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            return;
        }

    }
    //Hàm xếp theo tên và điểm

    public void xapXepTen() {
        Comparator<sinhVien> comp = new Comparator<sinhVien>() {
            @Override
            public int compare(sinhVien o1, sinhVien o2) {
                return o1.getTen().compareTo(o2.getTen());
            }
        };
        Collections.sort(listSv, comp);

    }

    public void xapXepDiem() {
        Comparator<sinhVien> comp = new Comparator<sinhVien>() {
            @Override
            public int compare(sinhVien o1, sinhVien o2) {
                return Double.compare(o1.getDiem(), o2.getDiem());
            }
        };
        Collections.sort(listSv, comp);
        Collections.reverse(listSv);

    }
    //Hàm update 

    public void update() {

        if (txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập tên name !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (new String(txtPoint.getText()).equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập điểm !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (Double.parseDouble(txtPoint.getText()) < 0 || Double.parseDouble(txtPoint.getText()) > 10) {
            JOptionPane.showMessageDialog(this, "Hãy nhập điểm trong khoảng [1,10] !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String checkPoint = "\\d{1,2}.\\d{1,5}";
        if (!new String(txtPoint.getText()).matches(checkPoint)) {
            JOptionPane.showMessageDialog(this, "Hãy nhập điểm là số !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int index = tblList.getSelectedRow();
        sinhVien sv = listSv.get(index);
        sv.setTen(txtName.getText());
        sv.setDiem(Double.parseDouble(txtPoint.getText()));
        sv.setNganh((String) cboNganh.getSelectedItem());
        txtHocLuc.setText(sv.hocLuc());
        chkCheck.setSelected(sv.phanThuong());

        int choice = (JOptionPane.showConfirmDialog(this, "Cập nhật thông tin người dùng này?", "Confirm", JOptionPane.YES_NO_OPTION));
        if (choice == JOptionPane.YES_OPTION) {
            findTable();
            JOptionPane.showMessageDialog(this, "Đã cập nhật người dùng trong list!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            return;
        }

    }

    /**
     * Creates new form lesson3
     */
    public lesson3() {
        this.listSv = new ArrayList<>();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPoint = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboNganh = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        chkCheck = new javax.swing.JCheckBox();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnXapXepDiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        BtnAdd = new javax.swing.JButton();
        btnXapXepTen = new javax.swing.JButton();
        txtHocLuc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Colonna MT", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 204));
        jLabel8.setText("Quan lí sinh vien");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 340, 60));

        jLabel1.setFont(new java.awt.Font("Consolas", 2, 18)); // NOI18N
        jLabel1.setText("Họ và tên");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 40));

        txtName.setBackground(new java.awt.Color(231, 231, 235));
        txtName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtName.setToolTipText("");
        txtName.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(231, 231, 235), new java.awt.Color(231, 231, 235)));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 400, 30));

        txtPoint.setBackground(new java.awt.Color(231, 231, 235));
        txtPoint.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPoint.setToolTipText("");
        txtPoint.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(231, 231, 235), new java.awt.Color(231, 231, 235)));
        txtPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPointActionPerformed(evt);
            }
        });
        getContentPane().add(txtPoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 400, 30));

        jLabel4.setFont(new java.awt.Font("Consolas", 2, 18)); // NOI18N
        jLabel4.setText("Điểm");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 40));

        cboNganh.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        cboNganh.setForeground(new java.awt.Color(51, 51, 51));
        cboNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lập trình mobile", "Ứng dụng phần mềm", "Thiết kế đồ họa", "Thương mại điện tử" }));
        cboNganh.setToolTipText("");
        cboNganh.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                cboNganhComponentHidden(evt);
            }
        });
        cboNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNganhActionPerformed(evt);
            }
        });
        getContentPane().add(cboNganh, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 210, 30));

        jLabel5.setFont(new java.awt.Font("Consolas", 2, 18)); // NOI18N
        jLabel5.setText("Ngành");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 40));

        chkCheck.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        chkCheck.setText("Có phần thưởng ?");
        chkCheck.setAutoscrolls(true);
        chkCheck.setMaximumSize(new java.awt.Dimension(100, 100));
        chkCheck.setMinimumSize(new java.awt.Dimension(90, 23));
        getContentPane().add(chkCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, 30));

        btnDelete.setBackground(new java.awt.Color(160, 229, 227));
        btnDelete.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setToolTipText("");
        btnDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227)));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 90, 30));

        btnUpdate.setBackground(new java.awt.Color(160, 229, 227));
        btnUpdate.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        btnUpdate.setText("Cập nhật");
        btnUpdate.setToolTipText("");
        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227)));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 90, 30));

        btnReset.setBackground(new java.awt.Color(160, 229, 227));
        btnReset.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setToolTipText("");
        btnReset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227)));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 90, 30));

        btnXapXepDiem.setBackground(new java.awt.Color(160, 229, 227));
        btnXapXepDiem.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        btnXapXepDiem.setText("Xắp xếp theo điểm");
        btnXapXepDiem.setToolTipText("");
        btnXapXepDiem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227)));
        btnXapXepDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXapXepDiemActionPerformed(evt);
            }
        });
        getContentPane().add(btnXapXepDiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 640, 160, 40));

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Họ tên", "Điểm", "Ngành", "Học lực", "Phần thưởng"
            }
        ));
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 630, 220));

        BtnAdd.setBackground(new java.awt.Color(160, 229, 227));
        BtnAdd.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        BtnAdd.setText("Thêm");
        BtnAdd.setToolTipText("");
        BtnAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227)));
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 90, 30));

        btnXapXepTen.setBackground(new java.awt.Color(160, 229, 227));
        btnXapXepTen.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        btnXapXepTen.setText("Xắp xếp theo tên");
        btnXapXepTen.setToolTipText("");
        btnXapXepTen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227)));
        btnXapXepTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXapXepTenActionPerformed(evt);
            }
        });
        getContentPane().add(btnXapXepTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 160, 40));

        txtHocLuc.setBackground(new java.awt.Color(231, 231, 235));
        txtHocLuc.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtHocLuc.setToolTipText("");
        txtHocLuc.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(231, 231, 235), new java.awt.Color(231, 231, 235)));
        txtHocLuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHocLucActionPerformed(evt);
            }
        });
        getContentPane().add(txtHocLuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 400, 30));

        jLabel6.setFont(new java.awt.Font("Consolas", 2, 18)); // NOI18N
        jLabel6.setText("Học lực");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, 40));

        jLabel11.setFont(new java.awt.Font("Colonna MT", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 204));
        jLabel11.setText(",");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 30, 20));

        jLabel12.setFont(new java.awt.Font("Colonna MT", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 204));
        jLabel12.setText("^");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 30, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed

    }//GEN-LAST:event_txtNameActionPerformed

    private void txtPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPointActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPointActionPerformed

    private void cboNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNganhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNganhActionPerformed

    private void cboNganhComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cboNganhComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNganhComponentHidden

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnXapXepDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXapXepDiemActionPerformed
        xapXepDiem();
        findTable();
    }//GEN-LAST:event_btnXapXepDiemActionPerformed

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        add();
        findTable();
    }//GEN-LAST:event_BtnAddActionPerformed

    private void btnXapXepTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXapXepTenActionPerformed
        xapXepTen();
        findTable();
    }//GEN-LAST:event_btnXapXepTenActionPerformed

    private void txtHocLucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHocLucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHocLucActionPerformed

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        showDeltal();
    }//GEN-LAST:event_tblListMouseClicked

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
            java.util.logging.Logger.getLogger(lesson3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lesson3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lesson3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lesson3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lesson3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnXapXepDiem;
    private javax.swing.JButton btnXapXepTen;
    private javax.swing.JComboBox<String> cboNganh;
    private javax.swing.JCheckBox chkCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblList;
    private javax.swing.JTextField txtHocLuc;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPoint;
    // End of variables declaration//GEN-END:variables
}
