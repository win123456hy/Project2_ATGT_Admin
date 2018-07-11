/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.dao.AnswerDAO;
import com.dao.LawDAO;
import com.dao.getCategoryfromCateName;
import com.dao.getListAnswer;
import com.dao.getListLaw;
import com.dao.getListQues;
import com.model.Answers;
import com.model.Categorys;
import com.model.Law;
import com.model.Question;
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
public class QuanLyDapAn extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyLuat
     */
    private DefaultTableModel model;
    private DefaultComboBoxModel comboBoxModel;
    private JComboBox comboBox = new JComboBox();
    private ArrayList<Answers> arraylistAnswer = new ArrayList<Answers>();
    private ArrayList<Question> listques = new ArrayList<>();
    private JTextField txtanswerdetail = new JTextField();
    private int quesidisselected = 0;
    
    public QuanLyDapAn() {
        initComponents();
        
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel lbtitlepage = new JLabel("Quản lý Đáp Án");
        lbtitlepage.setFont(new Font("hihi", Font.BOLD, 24));
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(lbtitlepage, constraints);
        model = new DefaultTableModel();
        model.addColumn("Answer ID");
        model.addColumn("Answer Detail");
        model.addColumn("Question");
        model.addColumn("Is Correct");
        jTable1.setModel(model);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        
        this.add(jpaneltable, constraints);
        
        JPanel jPanelshowdetailrow = new JPanel();

//        jPanelshowdetailrow.add(jScrollPane2);
//        jPanelshowdetailrow.add(jScrollPane3);
        jtextdetail.setEditable(false);
        jtexiscorrect.setEditable(false);
        jPanelshowdetailrow.add(jScrollPane2);
        jPanelshowdetailrow.add(jScrollPane3);
        jPanelshowdetailrow.setLayout(new BoxLayout(jPanelshowdetailrow, BoxLayout.X_AXIS));
        constraints.gridx = 0;
        constraints.gridy = 2;
        
        this.add(jPanelshowdetailrow, constraints);
        
        JPanel jpallinput = new JPanel(new GridLayout(1, 4));
        
        JPanel jpCombo = new JPanel(new GridLayout(1, 2));
        
        getListQues lq = new getListQues();
        JLabel lbCombo = new JLabel("Question ID:");
        jpCombo.add(lbCombo);
        comboBoxModel = new DefaultComboBoxModel();
        listques = lq.getAllques();
        for (int i = 0; i < listques.size(); i++) {
            comboBoxModel.addElement(listques.get(i).getQuestionID());
        }
        
        jComboBox1.setModel(comboBoxModel);
        jComboBox1.setSelectedIndex(1);
        
        jpCombo.add(jComboBox1);
        jpCombo.setVisible(true);
        
        JPanel jpanswerdetail = new JPanel(new GridLayout(1, 2));
        JLabel lbanswerdetail = new JLabel("Answer Detail:");
        jpanswerdetail.add(lbanswerdetail);
        txtanswerdetail.setPreferredSize(new Dimension(200, 35));
        jpanswerdetail.add(txtanswerdetail);
        jpanswerdetail.setVisible(true);
        
        JPanel jpiscorrect = new JPanel(new GridLayout(1, 2));
        JLabel lbiscorrect = new JLabel("Is Correct:");
        jpiscorrect.add(lbiscorrect);
        JPanel jpdungsai = new JPanel(new GridLayout(2, 1));
        jpdungsai.add(radiodung);
        jpdungsai.add(radiosai);
        
        jpiscorrect.add(jpdungsai);
        jpiscorrect.setVisible(true);

//        JTextField txtLawDes = new JTextField();
        jpallinput.add(jpCombo);
        jpallinput.add(jpanswerdetail);
        jpallinput.add(jpiscorrect);
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
        for (int i = 0; i < arraylistAnswer.size(); i++) {
            if (arraylistAnswer.get(i).getIsCorrect() == 1) {
                model.addRow(new Object[]{arraylistAnswer.get(i).getAnswerID(), arraylistAnswer.get(i).getAnswerDetail(), quesidisselected, "Đúng"});
            } else {
                model.addRow(new Object[]{arraylistAnswer.get(i).getAnswerID(), arraylistAnswer.get(i).getAnswerDetail(), quesidisselected, "Sai"});
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox<>();
        jpaneltable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtextdetail = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtexiscorrect = new javax.swing.JTextArea();
        buttonThem = new javax.swing.JButton();
        buttonSua = new javax.swing.JButton();
        buttonXoa = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();
        radiodung = new javax.swing.JRadioButton();
        radiosai = new javax.swing.JRadioButton();

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(285, Short.MAX_VALUE))
        );

        jtextdetail.setColumns(60);
        jtextdetail.setLineWrap(true);
        jtextdetail.setRows(5);
        jScrollPane2.setViewportView(jtextdetail);

        jtexiscorrect.setColumns(60);
        jtexiscorrect.setLineWrap(true);
        jtexiscorrect.setRows(5);
        jScrollPane3.setViewportView(jtexiscorrect);

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

        buttonGroup1.add(radiodung);
        radiodung.setText("Đúng");

        buttonGroup1.add(radiosai);
        radiosai.setText("Sai");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(281, 281, 281)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radiodung)
                                    .addComponent(radiosai))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpaneltable, 1320, 1320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jpaneltable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(456, 456, 456))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radiodung)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radiosai)
                .addGap(125, 125, 125)
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

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        int quesid = (int) jComboBox1.getSelectedItem();
        quesidisselected = quesid;
        for (int i = 0; i < listques.size(); i++) {
            if (listques.get(i).getQuestionID() == quesid) {
                getListAnswer listAnswer = new getListAnswer();
                arraylistAnswer = listAnswer.getListAnswer(quesid);
                showtable();
            }
            
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        String title = jTable1.getValueAt(index, 1).toString();
        String iscorrect = jTable1.getValueAt(index, 3).toString();
        
        jtextdetail.setText(title);
        jtexiscorrect.setText(iscorrect);
    }//GEN-LAST:event_jTable1MouseClicked

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
                        HomeAdmin le = new HomeAdmin();
                            le.setVisible(true);
                            this.dispose();
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThemActionPerformed
        
        String detail = txtanswerdetail.getText();
        int iscorrect = 0;
        if (radiodung.isSelected()) {
            iscorrect = 1;
        } else if (radiosai.isSelected()) {
            iscorrect = 0;
        }
        int quesid = (int) jComboBox1.getSelectedItem();
        
        getListAnswer listAnswer = new getListAnswer();
        if (listAnswer.getListAnswer(quesid).size() > 3) {
            JOptionPane.showMessageDialog(rootPane, "Đáp án không được vượt quá 4!!");
            arraylistAnswer = listAnswer.getListAnswer(quesid);
            showtable();
            txtanswerdetail.requestFocusInWindow();
        } else {
            AnswerDAO answerDAO = new AnswerDAO();
            answerDAO.addanswer(detail, iscorrect, quesid);
            arraylistAnswer = listAnswer.getListAnswer(quesid);
            
            showtable();
        }
    }//GEN-LAST:event_buttonThemActionPerformed

    private void buttonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXoaActionPerformed
        int index = jTable1.getSelectedRow();
        int idanwer = (int) jTable1.getValueAt(index, 0);
        int quesid = (int) jTable1.getValueAt(index, 2);
        AnswerDAO answerDAO = new AnswerDAO();
        answerDAO.deleteAnswers(idanwer);
        getListAnswer listAnswer = new getListAnswer();
        arraylistAnswer = listAnswer.getListAnswer(quesid);
        showtable();
    }//GEN-LAST:event_buttonXoaActionPerformed

    private void buttonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSuaActionPerformed
        int index = jTable1.getSelectedRow();
        int idanwer = (int) jTable1.getValueAt(index, 0);
        int quesid = (int) jComboBox1.getSelectedItem();
        int iscorrect = 0;
        if (radiodung.isSelected()) {
            iscorrect = 1;
        } else if (radiosai.isSelected()) {
            iscorrect = 0;
        }
        String detail = txtanswerdetail.getText();
        AnswerDAO answerDAO = new AnswerDAO();
        answerDAO.updateanswer(idanwer, detail, iscorrect, quesid);
        
        getListAnswer listAnswer = new getListAnswer();
        arraylistAnswer = listAnswer.getListAnswer(quesid);
        showtable();
    }//GEN-LAST:event_buttonSuaActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyDapAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyDapAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyDapAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyDapAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyDapAn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBack;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonSua;
    private javax.swing.JButton buttonThem;
    private javax.swing.JButton buttonXoa;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpaneltable;
    private javax.swing.JTextArea jtexiscorrect;
    private javax.swing.JTextArea jtextdetail;
    private javax.swing.JRadioButton radiodung;
    private javax.swing.JRadioButton radiosai;
    // End of variables declaration//GEN-END:variables
}
