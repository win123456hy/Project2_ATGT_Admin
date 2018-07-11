/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.dao.LawDAO;
import com.dao.UserDAO;
import com.dao.getCategoryfromCateName;
import com.dao.getListLaw;
import com.dao.getListUser;
import com.model.Categorys;
import com.model.Law;
import com.model.Users;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyUser extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyLuat
     */
    private DefaultTableModel model;
    private ArrayList<Users> arrayListUser = new ArrayList<Users>();
    private JTextField txtusername = new JTextField();
    private JTextField txtpassword = new JTextField();
    private JTextField txtemail = new JTextField();

    public QuanLyUser() {
        initComponents();

        this.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        JLabel lbtitlepage = new JLabel("Quản lý User");
        lbtitlepage.setFont(new Font("hihi", Font.BOLD, 24));
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(lbtitlepage, constraints);
        model = new DefaultTableModel();
        model.addColumn("UserID");
        model.addColumn("UserName");
        model.addColumn("Password");
        model.addColumn("Gender");
        model.addColumn("Email");
        model.addColumn("CreateTime");
        jTable1.setModel(model);

        constraints.gridx = 0;
        constraints.gridy = 1;

        this.add(jpaneltable, constraints);

        JPanel jPanelshowdetailrow = new JPanel();

//        jPanelshowdetailrow.add(jScrollPane2);
//        jPanelshowdetailrow.add(jScrollPane3);
        jtexUsername.setEditable(false);
        jtexgender.setEditable(false);
        jtexpassword.setEditable(false);
        jtextemail.setEditable(false);
        jtexcreatetime.setEditable(false);
        jPanelshowdetailrow.add(jScrollPane2);
        jPanelshowdetailrow.add(jScrollPane3);
        jPanelshowdetailrow.add(jScrollPane4);
        jPanelshowdetailrow.add(jScrollPane5);
        jPanelshowdetailrow.add(jScrollPane6);
        jPanelshowdetailrow.setLayout(new BoxLayout(jPanelshowdetailrow, BoxLayout.X_AXIS));
        constraints.gridx = 0;
        constraints.gridy = 2;

        this.add(jPanelshowdetailrow, constraints);

        JPanel jpallinput = new JPanel(new GridLayout(1, 4));

        JPanel jpusername = new JPanel(new GridLayout(1, 2));
        JLabel lbusername = new JLabel("Username:");
        jpusername.add(lbusername);
        txtusername.setPreferredSize(new Dimension(150, 35));
        jpusername.add(txtusername);
        jpusername.setVisible(true);

        JPanel jppassword = new JPanel(new GridLayout(1, 2));
        JLabel lbpassword = new JLabel("Password:");
        jppassword.add(lbpassword);
         txtpassword.setPreferredSize(new Dimension(150, 35));
        jppassword.add(txtpassword);
        jppassword.setVisible(true);

        JPanel jpgender = new JPanel(new GridLayout(1, 2));
        JLabel lbgender = new JLabel("Gender:");
        JPanel jpnamenu = new JPanel(new GridLayout(2, 1));
        jpnamenu.add(jRadioButton1);
        jpnamenu.add(jRadioButton2);

        jpgender.add(lbgender);
        jpgender.add(jpnamenu);

        JPanel jpemail = new JPanel(new GridLayout(1, 2));
        JLabel lbemail = new JLabel("Email:");
        jpemail.add(lbemail);
         txtemail.setPreferredSize(new Dimension(150, 35));
        jpemail.add(txtemail);
//        JTextField txtLawDes = new JTextField();

        jpemail.setVisible(true);

        jpallinput.add(jpusername);
        jpallinput.add(jppassword);
        jpallinput.add(jpgender);
        jpallinput.add(jpemail);
        jpallinput.setVisible(true);

        constraints.gridx = 0;
        constraints.gridy = 3;
        this.add(jpallinput, constraints);

        JPanel jPanelcontroll = new JPanel(new GridBagLayout());
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        bagConstraints.insets = new Insets(0, 0, 0, 100);
        jPanelcontroll.add(buttonThem, bagConstraints);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        jPanelcontroll.add(buttonSua, bagConstraints);
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 0;
        jPanelcontroll.add(buttonXoa, bagConstraints);
        bagConstraints.gridx = 3;
        bagConstraints.gridy = 0;
        jPanelcontroll.add(buttonBack, bagConstraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        this.add(jPanelcontroll, constraints);
        loaddata();
        showtable();
    }

    public void loaddata() {
        getListUser listUser = new getListUser();
        arrayListUser = listUser.getUsers();
    }

    public void showtable() {
        model.setNumRows(0);
        for (int i = 0; i < arrayListUser.size(); i++) {

            if (arrayListUser.get(i).getGender() == 1) {
                model.addRow(new Object[]{arrayListUser.get(i).getUserID(), arrayListUser.get(i).getUsername(), arrayListUser.get(i).getPassword(), "Nam", arrayListUser.get(i).getEmail(), arrayListUser.get(i).getCreatedTime()});
            } else {
                model.addRow(new Object[]{arrayListUser.get(i).getUserID(), arrayListUser.get(i).getUsername(), arrayListUser.get(i).getPassword(), "Nữ", arrayListUser.get(i).getEmail(), arrayListUser.get(i).getCreatedTime()});
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpaneltable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtexUsername = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtexpassword = new javax.swing.JTextArea();
        buttonThem = new javax.swing.JButton();
        buttonSua = new javax.swing.JButton();
        buttonXoa = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtexgender = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtextemail = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtexcreatetime = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpaneltable.setPreferredSize(new java.awt.Dimension(1300, 449));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1300, 402));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jpaneltableLayout = new javax.swing.GroupLayout(jpaneltable);
        jpaneltable.setLayout(jpaneltableLayout);
        jpaneltableLayout.setHorizontalGroup(
            jpaneltableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneltableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpaneltableLayout.setVerticalGroup(
            jpaneltableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneltableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jtexUsername.setColumns(20);
        jtexUsername.setLineWrap(true);
        jtexUsername.setRows(5);
        jScrollPane2.setViewportView(jtexUsername);

        jtexpassword.setColumns(20);
        jtexpassword.setLineWrap(true);
        jtexpassword.setRows(5);
        jScrollPane3.setViewportView(jtexpassword);

        buttonThem.setText("Add");
        buttonThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonThemMouseClicked(evt);
            }
        });
        buttonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThemActionPerformed(evt);
            }
        });

        buttonSua.setText("Update");
        buttonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSuaActionPerformed(evt);
            }
        });

        buttonXoa.setText("Delete");
        buttonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXoaActionPerformed(evt);
            }
        });

        buttonBack.setText("Back");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Nam");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Nữ");

        jtexgender.setColumns(20);
        jtexgender.setLineWrap(true);
        jtexgender.setRows(5);
        jScrollPane4.setViewportView(jtexgender);

        jtextemail.setColumns(20);
        jtextemail.setLineWrap(true);
        jtextemail.setRows(5);
        jScrollPane5.setViewportView(jtextemail);

        jtexcreatetime.setColumns(20);
        jtexcreatetime.setLineWrap(true);
        jtexcreatetime.setRows(5);
        jScrollPane6.setViewportView(jtexcreatetime);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpaneltable, 1320, 1320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(buttonThem)
                        .addGap(39, 39, 39)
                        .addComponent(buttonSua)
                        .addGap(46, 46, 46)
                        .addComponent(buttonXoa)
                        .addGap(38, 38, 38)
                        .addComponent(buttonBack)))
                .addContainerGap(492, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jpaneltable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(456, 456, 456))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(141, 141, 141)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonThem)
                    .addComponent(buttonSua)
                    .addComponent(buttonXoa)
                    .addComponent(buttonBack))
                .addGap(300, 300, 300))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        String username = jTable1.getValueAt(index, 1).toString();
        String pass = jTable1.getValueAt(index, 2).toString();
        String gender = jTable1.getValueAt(index, 3).toString();
        String email = jTable1.getValueAt(index, 4).toString();
        String createtime = jTable1.getValueAt(index, 5).toString();

        jtexUsername.setText(username);
        jtexpassword.setText(pass);
        jtexgender.setText(gender);
        jtextemail.setText(email);
        jtexcreatetime.setText(createtime);

    }//GEN-LAST:event_jTable1MouseClicked

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
                        HomeAdmin le = new HomeAdmin();
                            le.setVisible(true);
                            this.dispose();
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThemActionPerformed
        String username = txtusername.getText();
        String password = txtpassword.getText();
        int gender = 0;
        if (jRadioButton1.isSelected()) {
            gender = 1;
        } else if (jRadioButton2.isSelected()) {
            gender = 0;
        }

        String emaill = txtemail.getText();

        UserDAO dAO = new UserDAO();
        if (dAO.regis(username, password, gender, emaill) == true) {
            loaddata();
            showtable();
        }
    }//GEN-LAST:event_buttonThemActionPerformed

    private void buttonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXoaActionPerformed
        int index = jTable1.getSelectedRow();
        int iduser = (int) jTable1.getValueAt(index, 0);
        UserDAO dAO = new UserDAO();
        dAO.deleteusers(iduser);

        loaddata();
        showtable();
    }//GEN-LAST:event_buttonXoaActionPerformed

    private void buttonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSuaActionPerformed
        int index = jTable1.getSelectedRow();
        int idusers = (int) jTable1.getValueAt(index, 0);

        String username = txtusername.getText();
        String password = txtpassword.getText();
        int gender = 0;
        if (jRadioButton1.isSelected()) {
            gender = 1;
        } else if (jRadioButton2.isSelected()) {
            gender = 0;
        }

        String emaill = txtemail.getText();

        UserDAO dAO = new UserDAO();
        
        dAO.updatetraffic(username, password, gender, emaill, idusers);
            loaddata();
            showtable();
    }//GEN-LAST:event_buttonSuaActionPerformed

    private void buttonThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonThemMouseClicked
        String username = txtusername.getText();
        String password = txtpassword.getText();
        int gender = 0;
        if (jRadioButton1.isSelected()) {
            gender = 1;
        } else if (jRadioButton2.isSelected()) {
            gender = 0;
        }

        String emaill = txtemail.getText();

        UserDAO dAO = new UserDAO();
        if (dAO.regis(username, password, gender, emaill) == true) {
            loaddata();
            showtable();
        }
    }//GEN-LAST:event_buttonThemMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBack;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonSua;
    private javax.swing.JButton buttonThem;
    private javax.swing.JButton buttonXoa;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpaneltable;
    private javax.swing.JTextArea jtexUsername;
    private javax.swing.JTextArea jtexcreatetime;
    private javax.swing.JTextArea jtexgender;
    private javax.swing.JTextArea jtexpassword;
    private javax.swing.JTextArea jtextemail;
    // End of variables declaration//GEN-END:variables
}
