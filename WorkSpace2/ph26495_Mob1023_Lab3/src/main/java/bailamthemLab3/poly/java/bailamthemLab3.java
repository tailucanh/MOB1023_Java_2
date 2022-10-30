/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bailamthemLab3.poly.java;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HL COMPUTER
 */
public class bailamthemLab3 extends javax.swing.JFrame {

    List<NhanVien> listNv = new ArrayList<>();

    public void insert() {
        if (txtID.getText().equals("") && txtName.getText().equals("") &&  txtLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập mã cán bộ  ! \n Nhập tên ! \n Nhập lương", "Thông báo", JOptionPane.WARNING_MESSAGE);
            
            return;
        }
        if (txtID.getText().equals("") && txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập mã cán bộ  ! \n Nhập tên ! ", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtID.getText().equals("") && txtLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập mã cán bộ  ! \n Nhập lương ! ", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtName.getText().equals("") && txtLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập tên ! \n Nhập lương ! ", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập mã cán bộ  !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập tên  !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (new String(txtLuong.getText()).equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập lương !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (Double.parseDouble(txtLuong.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Hãy nhập lương là số lớn hơn 0 !", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hãy nhập lương là số  !", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

        NhanVien nv = new NhanVien();
        nv.setMaCb(txtID.getText());
        nv.setHoTen(txtName.getText());
        nv.setLuong(Double.parseDouble(txtLuong.getText()));
        nv.setChucVu((String) cboChucVu.getSelectedItem());
        txtThue.setText(String.valueOf(nv.thue()));
        int choice = (JOptionPane.showConfirmDialog(this, "Thêm thông tin nhân viên?", "Confirm", JOptionPane.YES_NO_OPTION));
        if (choice == JOptionPane.YES_OPTION) {
            listNv.add(nv);
            findTable();
            JOptionPane.showMessageDialog(this, "Đã thêm nhân viên!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            return;
        }

    }

    public void findTable() {
        DefaultTableModel model = (DefaultTableModel) tblDsCanBo.getModel();
        model.setRowCount(0);
        for (NhanVien nv : listNv) {
            Object[] row = new Object[]{
                nv.getMaCb(), nv.getHoTen(), nv.getLuong(), nv.getChucVu(), nv.thue()
            };
            model.addRow(row);
        }
    }

    public void showData() {
        int index = tblDsCanBo.getSelectedRow();
        txtID.setText((String) tblDsCanBo.getValueAt(index, 0));
        txtName.setText((String) tblDsCanBo.getValueAt(index, 1));
        txtLuong.setText(tblDsCanBo.getValueAt(index, 2) + "");
        cboChucVu.setSelectedItem(tblDsCanBo.getValueAt(index, 3));
        txtThue.setText(tblDsCanBo.getValueAt(index, 4) + "");

    }

    public void delete() {
        int index = tblDsCanBo.getSelectedRow();
        int choice = (JOptionPane.showConfirmDialog(this, "Xóa thông tin người dùng?", "Confirm", JOptionPane.YES_NO_OPTION));
        if (choice == JOptionPane.YES_OPTION) {
            listNv.remove(index);
            findTable();
            JOptionPane.showMessageDialog(this, "Đã xóa người dùng trong list!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            return;
        }
    }

    public void refresh() {
        txtID.setText("");
        txtName.setText("");
        txtLuong.setText("");
        txtThue.setText("");
    }

    /**
     * Creates new form bailamthemLab3
     */
    public bailamthemLab3() {
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

        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        txtThue = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboChucVu = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDsCanBo = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Colonna MT", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 204));
        jLabel9.setText(".");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 20, 20));

        jLabel11.setFont(new java.awt.Font("Colonna MT", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 204));
        jLabel11.setText(",");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 30, 20));

        jLabel10.setFont(new java.awt.Font("Colonna MT", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 204));
        jLabel10.setText("Quan lí cán bô");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 340, 60));

        jLabel1.setFont(new java.awt.Font("Consolas", 2, 18)); // NOI18N
        jLabel1.setText("Mã cán bộ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 100, 40));

        txtID.setBackground(new java.awt.Color(231, 231, 235));
        txtID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtID.setToolTipText("");
        txtID.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(231, 231, 235), new java.awt.Color(231, 231, 235)));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 360, 30));

        txtName.setBackground(new java.awt.Color(231, 231, 235));
        txtName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtName.setToolTipText("");
        txtName.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(231, 231, 235), new java.awt.Color(231, 231, 235)));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 360, 30));

        jLabel4.setFont(new java.awt.Font("Consolas", 2, 18)); // NOI18N
        jLabel4.setText("Họ tên");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, 40));

        jLabel2.setFont(new java.awt.Font("Consolas", 2, 18)); // NOI18N
        jLabel2.setText("Lương");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 100, 40));

        txtLuong.setBackground(new java.awt.Color(231, 231, 235));
        txtLuong.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtLuong.setToolTipText("");
        txtLuong.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(231, 231, 235), new java.awt.Color(231, 231, 235)));
        txtLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuongActionPerformed(evt);
            }
        });
        getContentPane().add(txtLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 360, 30));

        txtThue.setBackground(new java.awt.Color(231, 231, 235));
        txtThue.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtThue.setToolTipText("");
        txtThue.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(231, 231, 235), new java.awt.Color(231, 231, 235)));
        txtThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThueActionPerformed(evt);
            }
        });
        getContentPane().add(txtThue, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 360, 30));

        jLabel5.setFont(new java.awt.Font("Consolas", 2, 18)); // NOI18N
        jLabel5.setText("Thuế");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, 40));

        cboChucVu.setFont(new java.awt.Font("Consolas", 3, 19)); // NOI18N
        cboChucVu.setForeground(new java.awt.Color(51, 51, 51));
        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Tổ trưởng", "Kế toán", "Quản Lý", "Trưởng Phòng", "Giám đốc" }));
        cboChucVu.setToolTipText("");
        cboChucVu.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                cboChucVuComponentHidden(evt);
            }
        });
        cboChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChucVuActionPerformed(evt);
            }
        });
        getContentPane().add(cboChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 170, 40));

        jLabel6.setFont(new java.awt.Font("Consolas", 2, 18)); // NOI18N
        jLabel6.setText("Chức vụ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, 40));

        tblDsCanBo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã cán bộ", "Họ tên", "Lương", "Chức vụ", "Thuế"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDsCanBo.setToolTipText("");
        tblDsCanBo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblDsCanBo.setDoubleBuffered(true);
        tblDsCanBo.setFillsViewportHeight(true);
        tblDsCanBo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDsCanBoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDsCanBo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 660, 220));

        btnRefresh.setBackground(new java.awt.Color(255, 204, 204));
        btnRefresh.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setToolTipText("");
        btnRefresh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204)));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 120, 30));

        btnInsert.setBackground(new java.awt.Color(255, 204, 204));
        btnInsert.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.setToolTipText("");
        btnInsert.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204)));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 120, 30));

        btnUpdate.setBackground(new java.awt.Color(255, 204, 204));
        btnUpdate.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setToolTipText("");
        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204)));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 120, 30));

        btnDelete.setBackground(new java.awt.Color(255, 204, 204));
        btnDelete.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setToolTipText("");
        btnDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204)));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 120, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed

    }//GEN-LAST:event_txtIDActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongActionPerformed

    private void txtThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThueActionPerformed

    private void cboChucVuComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cboChucVuComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_cboChucVuComponentHidden

    private void cboChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboChucVuActionPerformed

    private void tblDsCanBoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDsCanBoMouseClicked
        showData();
    }//GEN-LAST:event_tblDsCanBoMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        insert();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(bailamthemLab3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bailamthemLab3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bailamthemLab3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bailamthemLab3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bailamthemLab3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDsCanBo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtThue;
    // End of variables declaration//GEN-END:variables

    private boolean String(boolean matches) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
