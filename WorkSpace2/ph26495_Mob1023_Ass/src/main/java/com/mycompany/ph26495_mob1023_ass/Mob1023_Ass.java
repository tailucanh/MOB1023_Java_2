/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ph26495_mob1023_ass;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HL COMPUTER
 */
public class Mob1023_Ass extends javax.swing.JFrame {

    List<NhanVien> listNv = new ArrayList<>();
    int index;
    
    public Mob1023_Ass() {
        initComponents();
        clockTime();
        textAuto();
    }

    //Kiểm tra mảng trùng lặp
    public boolean checkList(String id) {
        if (index == -1) {
            for (NhanVien nv : listNv) {
                if (nv.getId().equalsIgnoreCase(id)) {
                    return false;
                }
            }
        } else {
            for (NhanVien nv : listNv) {
                if (!(listNv.get(index).getId().equalsIgnoreCase(nv.getId()))) {   //Phủ định giá trị chọn
                    if (nv.getId().equalsIgnoreCase(id)) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    //Nút save 
    public void save() {
        try {
            //Kiểm tra id
            try {
                if (txtID.getText().equals("")) {
                    txtID.setBackground(Color.red);
                    JOptionPane.showMessageDialog(this, "Please enter id!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    txtID.requestFocus();
                    return;
                } else if (!(checkList(txtID.getText()))) { //Kiểm tra trùng lặp
                    JOptionPane.showMessageDialog(this, "Please enter id unduplicated!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    txtID.requestFocus();
                    return;
                } else {
                    txtID.setBackground(Color.white);
                }
            } catch (Exception e) {
                txtID.setBackground(Color.red);
                JOptionPane.showMessageDialog(this, "Please enter id!");
                txtID.requestFocus();
                return;
            }
            
            //Kiểm tra tên
            try {
                if (txtName.getText().equals("")) {
                    txtName.setBackground(Color.red);
                    JOptionPane.showMessageDialog(this, "Please enter name!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    txtName.requestFocus();
                    return;
                } else {
                    txtName.setBackground(Color.white);
                }

            } catch (Exception e) {
                txtName.setBackground(Color.red);
                JOptionPane.showMessageDialog(this, "Please enter name!");
                txtName.requestFocus();
                return;
            }
            //Kiểm tra tuổi
            try {

                if (Integer.parseInt(txtAge.getText()) < 16 || Integer.parseInt(txtAge.getText()) > 55) {
                    txtAge.setBackground(Color.red);
                    JOptionPane.showMessageDialog(this, "Please enter age between 16 and 55!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    txtAge.requestFocus();
                    return;
                } else {
                    txtAge.setBackground(Color.white);

                }
            } catch (Exception e) {
                txtAge.setBackground(Color.red);
                JOptionPane.showMessageDialog(this, "Please enter age in digits !", "Thông báo", JOptionPane.WARNING_MESSAGE);
                txtAge.requestFocus();
                return;
            }
            //Kiểm tra email
            if (txtEmail.getText().equals("")) {
                txtEmail.setBackground(Color.red);
                JOptionPane.showMessageDialog(this, "Please enter email !", "Thông báo", JOptionPane.WARNING_MESSAGE);
                txtEmail.requestFocus();
                return;
            } else if (!txtEmail.getText().matches("\\w+@\\w+(\\.\\w+){1,2}")) {
                txtEmail.setBackground(Color.red);
                JOptionPane.showMessageDialog(this, "Please enter your email in the correct format (levana@gmail.com) !", "Thông báo", JOptionPane.WARNING_MESSAGE);
                txtEmail.requestFocus();
                return;
            } else {
                txtEmail.setBackground(Color.white);
            }
            //Kiểm tra lương
            try {
                if (Double.parseDouble(txtSalary.getText()) < 5000000) {
                    txtSalary.setBackground(Color.red);
                    JOptionPane.showMessageDialog(this, "Please enter salary greater than 5000000!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    txtSalary.requestFocus();
                    return;
                } else {
                    txtSalary.setBackground(Color.white);
                }
            } catch (Exception e) {
                txtSalary.setBackground(Color.red);
                JOptionPane.showMessageDialog(this, "Please enter salary in digits !", "Thông báo", JOptionPane.WARNING_MESSAGE);
                txtSalary.requestFocus();
                return;
            }
            //Hai chức năng của nút save
            if (index == -1) {
                insert();
            } else {
                update(index);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Hàm thêm 
    public void insert() {
        index = tbl_List.getSelectedRow();
        NhanVien nv = new NhanVien();
        nv.setId(txtID.getText());
        nv.setFullName(txtName.getText());
        nv.setAge(Integer.parseInt(txtAge.getText()));
        nv.setEmail(txtEmail.getText());
        nv.setSalary(Double.parseDouble(txtSalary.getText()));

        int choice = (JOptionPane.showConfirmDialog(this, "More employee information?", "Confirm", JOptionPane.YES_NO_OPTION));
        if (choice == JOptionPane.YES_OPTION) {
            listNv.add(nv);
            findToTable();
            lblRecord.setText("Record:  " + (index + 1) + "/" + listNv.size());
            JOptionPane.showMessageDialog(this, "Staff added !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, " Cancelled!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

    }

    //Hàm find vào bảng
    public void findToTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_List.getModel();
        model.setRowCount(0);
        for (NhanVien nv : listNv) {
            Object[] obj = new Object[]{
                nv.getId(), nv.getFullName(), nv.getAge(), nv.getEmail(), nv.getSalary()
            };
            model.addRow(obj);
        }
    }

    //Hàm làm mới
    public void refresh() {
        index = -1;
        txtID.setText("");
        txtEmail.setText("");
        txtAge.setText("");
        txtName.setText("");
        txtSalary.setText("");
        txtAge.setBackground(Color.white);
        txtID.setBackground(Color.white);
        txtEmail.setBackground(Color.white);
        txtName.setBackground(Color.white);
        txtSalary.setBackground(Color.white);

    }

    //hàm show
    public void showData(int index) {
        txtID.setText((String) tbl_List.getValueAt(index, 0));
        txtName.setText((String) tbl_List.getValueAt(index, 1));
        txtAge.setText(tbl_List.getValueAt(index, 2) + "");
        txtEmail.setText((String) tbl_List.getValueAt(index, 3));
        txtSalary.setText(tbl_List.getValueAt(index, 4) + "");

        lblRecord.setText("Record:  " + (index + 1) + "/" + listNv.size());

        tbl_List.setRowSelectionInterval(index, index); //Xét dòng con trỏ trong bảng 

    }

    //Hàm xóa 
    public void delete() {
        index = tbl_List.getSelectedRow();

        int choice = (JOptionPane.showConfirmDialog(this, "Delete user information?", "Confirm", JOptionPane.YES_NO_OPTION));
        if (choice == JOptionPane.YES_OPTION) {
            if (index < 0) {
                JOptionPane.showMessageDialog(this, "Couldn't find employee information to delete!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                listNv.remove(index);
                findToTable();
                refresh();
                JOptionPane.showMessageDialog(this, "Removed user from the list!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, " Cancelled !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    //Hàm tìm kiếm mảng 
    public int findID(String idNv) {
        int x = -1;
        for (NhanVien nv : listNv) {
            if (nv.getId().equalsIgnoreCase(idNv)) {
                x = listNv.indexOf(nv);
            }
        }

        return x;
    }

    //Hàm update
    public void update(int index) {
        index = tbl_List.getSelectedRow();
        if (index >= 0) {
            NhanVien nv = listNv.get(index);
            nv.setId(txtID.getText());
            nv.setFullName(txtName.getText());
            nv.setAge(Integer.parseInt(txtAge.getText()));
            nv.setEmail(txtEmail.getText());
            nv.setSalary(Double.parseDouble(txtSalary.getText()));

            int choice = (JOptionPane.showConfirmDialog(this, "Update this user information?", "Confirm", JOptionPane.YES_NO_OPTION));
            if (choice == JOptionPane.YES_OPTION) {
                if (index < 0) {
                    JOptionPane.showMessageDialog(this, "Couldn't find employee information to update!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    findToTable();
                    JOptionPane.showMessageDialog(this, "Updated users in the list!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, " Cancelled !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

    }

    //Nút về đầu 
    public void Top() {
        index = 0;
        showData(index);
    }

    //Nút về cuối 
    public void Last() {
        index = listNv.size() - 1;
        showData(index);
    }

    //Nút lùi xuống
    public void Back() {
        if (index > 0) {
            index--;
            showData(index);
        }
    }

    //Nút tiến lên
    public void Up() {
        if (index < listNv.size() - 1) {
            index++;
            showData(index);
        }
    }

    //Đồng hồ thời  gian
    public void clockTime() {
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
                        simpleDateFormat.applyPattern("hh:mm:ss aa");
                        Date date = new Date();
                        String time = simpleDateFormat.format(date);
                        lblClock.setText(time);
                        Thread.sleep(1000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
    public void textAuto() {
        new Thread() {
            public void run() {
                String title = lblTitle.getText() + "    ";
                while (true) {
                    try {
                        title = title.substring(1,title.length()) +title.charAt(0);
                  
                        Thread.sleep(1000);
                        lblTitle.setText(title);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        lblTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btn_New = new javax.swing.JButton();
        btn_Save = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        btn_Find = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btn_Exit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblRecord = new javax.swing.JLabel();
        btn_Last = new javax.swing.JButton();
        btn_Top = new javax.swing.JButton();
        btn_Back = new javax.swing.JButton();
        btn_Up = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_List = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        lblClock = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Colonna MT", 3, 46)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(84, 178, 224));
        lblTitle.setText("Employees Manager");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 440, 50));

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 610, -1));

        jPanel1.setBackground(new java.awt.Color(212, 240, 247));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Viner Hand ITC", 3, 24), new java.awt.Color(255, 102, 102))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jLabel2.setText("Salary");

        jLabel3.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jLabel3.setText("FullName");

        jLabel4.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jLabel4.setText("Age");
        jLabel4.setMinimumSize(new java.awt.Dimension(33, 22));

        jLabel5.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jLabel5.setText("Email");

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtID.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221)));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221)));

        txtAge.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAge.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221)));
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221)));

        txtSalary.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSalary.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221), new java.awt.Color(240, 221, 221)));
        txtSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalary, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 600, 300));

        jPanel2.setBackground(new java.awt.Color(231, 226, 226));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_New.setBackground(new java.awt.Color(255, 177, 177));
        btn_New.setFont(new java.awt.Font("Sitka Banner", 3, 18)); // NOI18N
        btn_New.setText("New");
        btn_New.setBorder(null);
        btn_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NewActionPerformed(evt);
            }
        });
        jPanel2.add(btn_New, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 30));

        btn_Save.setBackground(new java.awt.Color(255, 177, 177));
        btn_Save.setFont(new java.awt.Font("Sitka Banner", 3, 18)); // NOI18N
        btn_Save.setText("Save");
        btn_Save.setBorder(null);
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, 30));

        btn_Delete.setBackground(new java.awt.Color(255, 177, 177));
        btn_Delete.setFont(new java.awt.Font("Sitka Banner", 3, 18)); // NOI18N
        btn_Delete.setText("Delete");
        btn_Delete.setBorder(null);
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 90, 30));

        btn_Find.setBackground(new java.awt.Color(255, 177, 177));
        btn_Find.setFont(new java.awt.Font("Sitka Banner", 3, 18)); // NOI18N
        btn_Find.setText("Find");
        btn_Find.setBorder(null);
        btn_Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FindActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Find, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, 30));

        btnOpen.setBackground(new java.awt.Color(255, 177, 177));
        btnOpen.setFont(new java.awt.Font("Sitka Banner", 3, 18)); // NOI18N
        btnOpen.setText("Open");
        btnOpen.setBorder(null);
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });
        jPanel2.add(btnOpen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 90, 30));

        btn_Exit.setBackground(new java.awt.Color(255, 177, 177));
        btn_Exit.setFont(new java.awt.Font("Sitka Banner", 3, 18)); // NOI18N
        btn_Exit.setText("Exit");
        btn_Exit.setBorder(null);
        btn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExitActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 130, 320));

        jPanel4.setBackground(new java.awt.Color(250, 224, 224));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRecord.setFont(new java.awt.Font("Harlow Solid Italic", 2, 22)); // NOI18N
        lblRecord.setForeground(new java.awt.Color(255, 51, 51));
        jPanel4.add(lblRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 180, 50));

        btn_Last.setBackground(new java.awt.Color(246, 245, 116));
        btn_Last.setFont(new java.awt.Font("Footlight MT Light", 1, 15)); // NOI18N
        btn_Last.setText(">|");
        btn_Last.setBorder(null);
        btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LastActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Last, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 50, 30));

        btn_Top.setBackground(new java.awt.Color(246, 245, 116));
        btn_Top.setFont(new java.awt.Font("Footlight MT Light", 1, 15)); // NOI18N
        btn_Top.setText("|<");
        btn_Top.setBorder(null);
        btn_Top.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TopActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Top, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 50, 30));

        btn_Back.setBackground(new java.awt.Color(246, 245, 116));
        btn_Back.setFont(new java.awt.Font("Footlight MT Light", 1, 15)); // NOI18N
        btn_Back.setText("<<");
        btn_Back.setBorder(null);
        btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 50, 30));

        btn_Up.setBackground(new java.awt.Color(246, 245, 116));
        btn_Up.setFont(new java.awt.Font("Footlight MT Light", 1, 15)); // NOI18N
        btn_Up.setText(">>");
        btn_Up.setBorder(null);
        btn_Up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Up, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 50, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 600, 50));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Employee information board", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Script", 3, 20), new java.awt.Color(191, 136, 54))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_List.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FullName", "Age", "Email", "Salary"
            }
        ));
        tbl_List.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_List);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 730, 140));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 10));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 770, 200));
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, -30, -1, -1));

        lblClock.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        lblClock.setForeground(new java.awt.Color(252, 48, 48));
        lblClock.setText("Time");
        getContentPane().add(lblClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        int choice = (JOptionPane.showConfirmDialog(this, "Do you want to open the file ?", "Confirm", JOptionPane.YES_NO_OPTION));
        if (choice == JOptionPane.YES_OPTION) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ass.txt"));
                listNv = (List<NhanVien>) ois.readObject();
                findToTable();
  
                ois.close();

            } catch (IOException ex) {
                Logger.getLogger(Mob1023_Ass.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Mob1023_Ass.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, " Cancelled!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btn_FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FindActionPerformed
        try {
            String idNv = JOptionPane.showInputDialog(this, "Please enter the employee code you are looking for ");
            if (findID(idNv) == -1) {
                JOptionPane.showMessageDialog(this, "The employee with the code could not be found");
            } else {
                index = findID(idNv);  //Trả về vị trí tìm thấy
                showData(index);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_FindActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed

        delete();
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        save();

    }//GEN-LAST:event_btn_SaveActionPerformed

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed
        int choice = (JOptionPane.showConfirmDialog(this, "Do you want to save the file and exit?", "Confirm", JOptionPane.YES_NO_OPTION));
        if (choice == JOptionPane.YES_OPTION) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ass.txt"));
                oos.writeObject(listNv);
                oos.flush();
                oos.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Mob1023_Ass.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Mob1023_Ass.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);

            JOptionPane.showMessageDialog(this, "File saved successfully !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, " Cancelled!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }


    }//GEN-LAST:event_btn_ExitActionPerformed

    private void txtSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaryActionPerformed

    private void btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LastActionPerformed
        Last();
    }//GEN-LAST:event_btn_LastActionPerformed

    private void btn_TopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TopActionPerformed
        Top();
    }//GEN-LAST:event_btn_TopActionPerformed

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        Back();
    }//GEN-LAST:event_btn_BackActionPerformed

    private void btn_UpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpActionPerformed
        Up();
    }//GEN-LAST:event_btn_UpActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed

    }//GEN-LAST:event_txtAgeActionPerformed

    private void btn_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NewActionPerformed
        refresh();

    }//GEN-LAST:event_btn_NewActionPerformed

    private void tbl_ListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ListMouseClicked
        index = tbl_List.getSelectedRow();
        showData(index);
    }//GEN-LAST:event_tbl_ListMouseClicked

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
            java.util.logging.Logger.getLogger(Mob1023_Ass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mob1023_Ass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mob1023_Ass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mob1023_Ass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mob1023_Ass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Exit;
    private javax.swing.JButton btn_Find;
    private javax.swing.JButton btn_Last;
    private javax.swing.JButton btn_New;
    private javax.swing.JButton btn_Save;
    private javax.swing.JButton btn_Top;
    private javax.swing.JButton btn_Up;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblRecord;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tbl_List;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSalary;
    // End of variables declaration//GEN-END:variables
}
