/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ph26495.poly.lesson4;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HL COMPUTER
 */
public class lab2_lesson4 extends javax.swing.JFrame {

    ArrayList<User> list = new ArrayList<User>();

    public lab2_lesson4() {
        initComponents();
    }

    //Phương thức xóa
    public void reset() {
        txtUsername.setText("");
        txtPass.setText("");
        rdoAmin.setSelected(false);
        rdoUser.setSelected(false);
        btnGroup.clearSelection();
    }

    //Phương thức thêm
    public void add() {

        if (txtUsername.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập user name !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (new String(txtPass.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập pass !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        User user = new User();
        user.setName(txtUsername.getText());
        user.setPass(new String(txtPass.getPassword()));
        user.setRole(rdoUser.isSelected() ? "User" : "Admin");
        if(  !rdoAmin.isSelected() && !rdoUser.isSelected()){
              JOptionPane.showMessageDialog(this, "Hãy chọn thể loại !", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }else{
                 list.add(user);
                fillToTable();
                JOptionPane.showMessageDialog(this, "Đã thêm người dùng vào list!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                reset();
         }
        
    }

    //đổ dữ liệu vào bảng
    public void fillToTable() {
        DefaultTableModel tableModel = (DefaultTableModel) tableList.getModel();  //Lấy mô hình dữ liệu của bản
        tableModel.setRowCount(0);
        for (User us : list) {
            Object[] row = new Object[]{
                us.getName(), us.getPass(), us.getRole()
            };
            tableModel.addRow(row); //Đổ dữ liệu theo từng hàng

        }
    }

    // Hiển thị dữ liệu lên các text
    public void showDetail() {
        int index = tableList.getSelectedRow();
        txtUsername.setText((String) tableList.getValueAt(index, 0));
        txtPass.setText((String) tableList.getValueAt(index, 1));
        if (tableList.getValueAt(index, 2).equals("Admin")) {
            rdoAmin.setSelected(true);
            rdoUser.setSelected(false);
        } else {
            rdoAmin.setSelected(false);
            rdoUser.setSelected(true);
        }

    }

    // xóa trong bảng
    public void delete() {
         int index = tableList.getSelectedRow();
           int choice = (JOptionPane.showConfirmDialog(this, "Xóa  người dùng này?", "Confirm", JOptionPane.YES_NO_OPTION));
                if (choice == JOptionPane.YES_OPTION) {
                           list.remove(index);
                            fillToTable();
                          JOptionPane.showMessageDialog(this, "Đã xóa người dùng khỏi list!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                      
          
                }else {
                    return;
                }
  
         
    }

    //chỉnh sửa : update
    public void update() {
        if (txtUsername.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập user name !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (new String(txtPass.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập pass !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
         int index = tableList.getSelectedRow();
        User user = list.get(index);
        user.setName(txtUsername.getText());
        user.setPass(new String(txtPass.getPassword()));
        user.setRole(rdoUser.isSelected() ? "User" : "Admin");
        if(  !rdoAmin.isSelected() && !rdoUser.isSelected()){
              JOptionPane.showMessageDialog(this, "Hãy chọn thể loại !", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }else{
                 int choice = (JOptionPane.showConfirmDialog(this, "Thay đổi thông tin người dùng?", "Confirm", JOptionPane.YES_NO_OPTION));
                if (choice == JOptionPane.YES_OPTION) {
                      JOptionPane.showMessageDialog(this, "Đã thay đổi người dùng trong list!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        fillToTable();
          
                }else {
                    return;
                }
       
         }
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        rdoAmin = new javax.swing.JRadioButton();
        rdoUser = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        setMinimumSize(new java.awt.Dimension(850, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Colonna MT", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 204));
        jLabel8.setText("User Mangagement");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 340, 60));

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGroup.add(rdoAmin);
        rdoAmin.setFont(new java.awt.Font("Georgia", 3, 16)); // NOI18N
        rdoAmin.setText(" Admin");
        rdoAmin.setToolTipText("");
        rdoAmin.setAlignmentY(0.0F);
        rdoAmin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        rdoAmin.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rdoAmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAminActionPerformed(evt);
            }
        });
        jPanel1.add(rdoAmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 100, 40));

        btnGroup.add(rdoUser);
        rdoUser.setFont(new java.awt.Font("Georgia", 3, 16)); // NOI18N
        rdoUser.setText(" User");
        rdoUser.setToolTipText("");
        rdoUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        rdoUser.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rdoUser.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        rdoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoUserActionPerformed(evt);
            }
        });
        jPanel1.add(rdoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 80, 40));

        jLabel1.setFont(new java.awt.Font("Consolas", 2, 20)); // NOI18N
        jLabel1.setText("Role");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 40));

        jLabel2.setFont(new java.awt.Font("Consolas", 2, 20)); // NOI18N
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, 40));

        txtUsername.setBackground(new java.awt.Color(231, 231, 235));
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUsername.setToolTipText("");
        txtUsername.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(231, 231, 235), new java.awt.Color(231, 231, 235)));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 390, 30));

        btnAdd.setBackground(new java.awt.Color(160, 229, 227));
        btnAdd.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setToolTipText("");
        btnAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227)));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 90, 30));

        jLabel3.setFont(new java.awt.Font("Consolas", 2, 20)); // NOI18N
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 40));

        btnRemove.setBackground(new java.awt.Color(160, 229, 227));
        btnRemove.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227)));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 90, 30));

        btnUpdate.setBackground(new java.awt.Color(160, 229, 227));
        btnUpdate.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227)));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 90, 30));

        btnReset.setBackground(new java.awt.Color(160, 229, 227));
        btnReset.setFont(new java.awt.Font("Calibri Light", 3, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227), new java.awt.Color(160, 229, 227)));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 90, 30));

        txtPass.setBackground(new java.awt.Color(231, 231, 235));
        txtPass.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(231, 231, 235), new java.awt.Color(231, 231, 235)));
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 122, 390, 30));

        jTabbedPane1.addTab("EDITION", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "USER NAME", "PASSWORD", "ROLE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableList);
        if (tableList.getColumnModel().getColumnCount() > 0) {
            tableList.getColumnModel().getColumn(0).setHeaderValue("USER NAME");
            tableList.getColumnModel().getColumn(1).setHeaderValue("PASSWORD");
            tableList.getColumnModel().getColumn(2).setHeaderValue("ROLE");
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 340));

        jTabbedPane1.addTab("LIST", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 640, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        delete();

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        add();

    }//GEN-LAST:event_btnAddActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void rdoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoUserActionPerformed

    }//GEN-LAST:event_rdoUserActionPerformed

    private void rdoAminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAminActionPerformed

    }//GEN-LAST:event_rdoAminActionPerformed

    private void tableListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListMouseClicked
        showDetail();
    }//GEN-LAST:event_tableListMouseClicked

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

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
            java.util.logging.Logger.getLogger(lab2_lesson4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lab2_lesson4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lab2_lesson4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lab2_lesson4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lab2_lesson4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoAmin;
    private javax.swing.JRadioButton rdoUser;
    private javax.swing.JTable tableList;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
