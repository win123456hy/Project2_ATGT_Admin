/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.dao.LawDAO;
import com.dao.getCategoryfromCateName;
import com.dao.getListLaw;
import com.model.Categorys;
import com.model.Law;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyLuat extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyLuat
     */
    private DefaultTableModel model;
    private DefaultComboBoxModel comboBoxModel;
    private JComboBox comboBox = new JComboBox();
    private ArrayList<Law> arrayListlay = new ArrayList<Law>();
    private ArrayList<Categorys> listcate = new ArrayList<>();
    private JTextField txtLawtitle = new JTextField();
    private JTextField txtlawdetail = new JTextField();

    public QuanLyLuat() {
        initComponents();

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel jPaneltop = new JPanel(new GridLayout(2, 1));
        JLabel lbtitlepage = new JLabel("Quản lý Luật");
        lbtitlepage.setFont(new Font("hihi", Font.BOLD, 24));
        jPaneltop.add(lbtitlepage);
        JPanel jsearch = new JPanel(new GridLayout(1, 2));
        jsearch.add(txtSearch);
        jsearch.add(buttonsearch);

        jPaneltop.add(jsearch);

        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(jPaneltop, constraints);
        model = new DefaultTableModel();
        model.addColumn("LawID");
        model.addColumn("LawTitle");
        model.addColumn("LawDetail");
        model.addColumn("LawTimeRelease");
        model.addColumn("Category");
        jTable1.setModel(model);

        constraints.gridx = 0;
        constraints.gridy = 1;
        jpaneltable.setPreferredSize(new Dimension(1300, 300));
        this.add(jpaneltable, constraints);

        JPanel jPanelshowdetailrow = new JPanel();

//        jPanelshowdetailrow.add(jScrollPane2);
//        jPanelshowdetailrow.add(jScrollPane3);
        jtexdetail.setEditable(false);
        jtextitle.setEditable(false);
        jPanelshowdetailrow.add(jScrollPane2);
        jPanelshowdetailrow.add(jScrollPane3);
        jPanelshowdetailrow.setLayout(new BoxLayout(jPanelshowdetailrow, BoxLayout.X_AXIS));
        constraints.gridx = 0;
        constraints.gridy = 2;

        this.add(jPanelshowdetailrow, constraints);

        JPanel jpallinput = new JPanel(new GridLayout(1, 4));

        JPanel jpCombo = new JPanel(new GridLayout(1, 2));

        getCategoryfromCateName categoryForLawsMN = new getCategoryfromCateName();
        JLabel lbCombo = new JLabel("Category:");
        jpCombo.add(lbCombo);
        comboBoxModel = new DefaultComboBoxModel();
        listcate.add(categoryForLawsMN.getCategoryName(3));
        listcate.add(categoryForLawsMN.getCategoryName(4));
        listcate.add(categoryForLawsMN.getCategoryName(5));

        comboBoxModel.addElement(categoryForLawsMN.getCategoryName(3).toString());
        comboBoxModel.addElement(categoryForLawsMN.getCategoryName(4).toString());
        comboBoxModel.addElement(categoryForLawsMN.getCategoryName(5).toString());
        jComboBox1.setModel(comboBoxModel);
        jComboBox1.setSelectedIndex(1);

        jpCombo.add(jComboBox1);
        jpCombo.setVisible(true);

        JPanel jplawtitle = new JPanel(new GridLayout(1, 2));
        JLabel lbLawtitle = new JLabel("Law Title:");
        jplawtitle.add(lbLawtitle);
        txtLawtitle.setPreferredSize(new Dimension(150, 35));
        jplawtitle.add(txtLawtitle);
        jplawtitle.setVisible(true);

        JPanel jplawdetail = new JPanel(new GridLayout(1, 2));
        JLabel lblawdetail = new JLabel("Law Detail:");
        jplawdetail.add(lblawdetail);
        txtlawdetail.setPreferredSize(new Dimension(150, 35));
        jplawdetail.add(txtlawdetail);
        jplawdetail.setVisible(true);

        JPanel jpLawDes = new JPanel(new GridLayout(1, 2));
        JLabel lbLawDes = new JLabel("Law Time Release:");
        jpLawDes.add(lbLawDes);

//        JTextField txtLawDes = new JTextField();
        jpLawDes.add(jDateChooser1);
        jpLawDes.setVisible(true);

        jpallinput.add(jpCombo);
        jpallinput.add(jplawtitle);
        jpallinput.add(jplawdetail);
        jpallinput.add(jpLawDes);
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

    }

    public void showtable() {
        model.setNumRows(0);
        for (int i = 0; i < arrayListlay.size(); i++) {

            getCategoryfromCateName categoryForLawsMN = new getCategoryfromCateName();

            model.addRow(new Object[]{arrayListlay.get(i).getLawID(), arrayListlay.get(i).getLawTitle(), arrayListlay.get(i).getLawDetail(), arrayListlay.get(i).getLawTimeRelease(), categoryForLawsMN.getCategoryName(arrayListlay.get(i).getCategoryID().getCategoryID()).getCategoryName()});
        }
    }

    public void showtabletimkiem() {
        model.setNumRows(0);
        for (int i = 0; i < arrayListlay.size(); i++) {

            model.addRow(new Object[]{arrayListlay.get(i).getLawID(), arrayListlay.get(i).getLawTitle(), arrayListlay.get(i).getLawDetail(), arrayListlay.get(i).getLawTimeRelease(), arrayListlay.get(i).getCategoryID().getCategoryID()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jpaneltable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtextitle = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtexdetail = new javax.swing.JTextArea();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        buttonThem = new javax.swing.JButton();
        buttonSua = new javax.swing.JButton();
        buttonXoa = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        buttonsearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtextitle.setColumns(60);
        jtextitle.setLineWrap(true);
        jtextitle.setRows(5);
        jScrollPane2.setViewportView(jtextitle);

        jtexdetail.setColumns(60);
        jtexdetail.setLineWrap(true);
        jtexdetail.setRows(5);
        jScrollPane3.setViewportView(jtexdetail);

        buttonThem.setText("Add");
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

        buttonsearch.setText("Search");
        buttonsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonsearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1449, 1449, 1449))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(174, 174, 174)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(305, 305, 305)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addComponent(buttonsearch)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpaneltable, 1320, 1320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(buttonThem)
                        .addGap(39, 39, 39)
                        .addComponent(buttonSua)
                        .addGap(46, 46, 46)
                        .addComponent(buttonXoa)
                        .addGap(38, 38, 38)
                        .addComponent(buttonBack)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonsearch))
                .addGap(56, 56, 56)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jpaneltable, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        String catename = jComboBox1.getSelectedItem().toString();
        for (int i = 0; i < listcate.size(); i++) {
            if (listcate.get(i).getCategoryName().equals(catename)) {
                getListLaw listLaw = new getListLaw();
                arrayListlay = listLaw.getLLaw(listcate.get(i).getCategoryID());
                showtable();
            }

        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        String title = jTable1.getValueAt(index, 1).toString();
        String detail = jTable1.getValueAt(index, 2).toString();

        jtextitle.setText(title);
        jtexdetail.setText(detail);
    }//GEN-LAST:event_jTable1MouseClicked

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        HomeAdmin le = new HomeAdmin();
        le.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThemActionPerformed
        String title = txtLawtitle.getText();
        String detail = txtlawdetail.getText();
        Date timerelease = jDateChooser1.getDate();
        boolean check = false;
        if (detail.isEmpty() || title.isEmpty() || timerelease == null) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Không được để rỗng", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            check = true;
        }
        String catenam = jComboBox1.getSelectedItem().toString();
        int cateid = 0;
        for (int i = 0; i < listcate.size(); i++) {
            if (listcate.get(i).getCategoryName().equals(catenam)) {
                cateid = listcate.get(i).getCategoryID();
                break;
            }
        }

        if (check == true) {
            LawDAO lawDAO = new LawDAO();
            lawDAO.addlaw(title, detail, timerelease, cateid);

            String catename = jComboBox1.getSelectedItem().toString();
            for (int i = 0; i < listcate.size(); i++) {
                if (listcate.get(i).getCategoryName().equals(catename)) {
                    getListLaw listLaw = new getListLaw();
                    arrayListlay = listLaw.getLLaw(listcate.get(i).getCategoryID());
                    showtable();
                }

            }
        }
    }//GEN-LAST:event_buttonThemActionPerformed

    private void buttonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXoaActionPerformed
        int index = jTable1.getSelectedRow();
        if (index > 0) {
            int idlaw = (int) jTable1.getValueAt(index, 0);
            int confirm = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn xoá không?", "Confrim", JOptionPane.YES_NO_CANCEL_OPTION);
            if (confirm == 0) {
                LawDAO lawDAO = new LawDAO();
                lawDAO.deletelaw(idlaw);

                String catename = jComboBox1.getSelectedItem().toString();
                for (int i = 0; i < listcate.size(); i++) {
                    if (listcate.get(i).getCategoryName().equals(catename)) {
                        getListLaw listLaw = new getListLaw();
                        arrayListlay = listLaw.getLLaw(listcate.get(i).getCategoryID());
                        showtable();
                    }

                }
                JOptionPane.showMessageDialog(rootPane, "Xoá thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);

            } else {
                jTable1.setRowSelectionInterval(0, 0);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn hàng nào!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonXoaActionPerformed

    private void buttonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSuaActionPerformed
        int index = jTable1.getSelectedRow();
        if (index > 0) {
            int idlaw = (int) jTable1.getValueAt(index, 0);
            String title = txtLawtitle.getText();
            String detail = txtlawdetail.getText();
            Date timerelease = jDateChooser1.getDate();

            String catenam = jComboBox1.getSelectedItem().toString();
            int cateid = 0;
            for (int i = 0; i < listcate.size(); i++) {
                if (listcate.get(i).getCategoryName().equals(catenam)) {
                    cateid = listcate.get(i).getCategoryID();
                    break;
                }
            }
            boolean check = false;
            if (detail.isEmpty() || title.isEmpty() || timerelease == null) {
                check = false;
                JOptionPane.showMessageDialog(rootPane, "Không được để rỗng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                check = true;
            }

            if (check == true) {
                LawDAO lawDAO = new LawDAO();
                lawDAO.updatelaw(idlaw, title, detail, timerelease, cateid);

                String catename = jComboBox1.getSelectedItem().toString();
                for (int i = 0; i < listcate.size(); i++) {
                    if (listcate.get(i).getCategoryName().equals(catename)) {
                        getListLaw listLaw = new getListLaw();
                        arrayListlay = listLaw.getLLaw(listcate.get(i).getCategoryID());
                        showtable();
                    }

                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn hàng nào!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonSuaActionPerformed

    private void buttonsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonsearchMouseClicked
        String key = txtSearch.getText();
//        if(key==null){
//        txtSearch.requestFocusInWindow();
//        }
        LawDAO lawDAO = new LawDAO();
        arrayListlay = lawDAO.timkiem(key);
        showtabletimkiem();
    }//GEN-LAST:event_buttonsearchMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyLuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyLuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyLuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyLuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyLuat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonSua;
    private javax.swing.JButton buttonThem;
    private javax.swing.JButton buttonXoa;
    private javax.swing.JButton buttonsearch;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpaneltable;
    private javax.swing.JTextArea jtexdetail;
    private javax.swing.JTextArea jtextitle;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
