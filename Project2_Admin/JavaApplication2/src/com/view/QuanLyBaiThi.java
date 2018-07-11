/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.dao.getExamDetail;
import com.dao.getListAnswer;
import com.dao.getListExam;
import com.dao.getListQues;
import com.dao.getListUser;
import com.model.Answers;
import com.model.ExamDetails;
import com.model.Exams;
import com.model.Question;
import com.model.Users;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyBaiThi extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyLuat
     */
    private DefaultTableModel model;
    private DefaultTableModel model1;
    private ArrayList<Exams> arrayExams = new ArrayList<Exams>();
    private ArrayList<ExamDetails> arrayExamDetails = new ArrayList<ExamDetails>();
    private JTextField key = new JTextField();

    public QuanLyBaiThi() {
        initComponents();

        this.setLayout(new GridLayout(5, 1));
        JPanel jpaneltop = new JPanel(new GridLayout(2, 1));
        JLabel lbtitlepage = new JLabel("Quản lý Bài Thi");
        lbtitlepage.setFont(new Font("hihi", Font.BOLD, 24));
        JPanel title = new JPanel(new FlowLayout());
        title.add(lbtitlepage);
        JPanel timkiem = new JPanel(new GridLayout(1, 3));

        JLabel jLabelSearch = new JLabel("Tìm kiếm theo Username:");
        JPanel keyjLabelSearch = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        keyjLabelSearch.add(jLabelSearch);
        timkiem.add(keyjLabelSearch);
        JPanel keypanel = new JPanel();
        key.setPreferredSize(new Dimension(350, 30));
        keypanel.add(key);
        timkiem.add(keypanel);
        JPanel searchpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchpanel.add(buttonSearch);
        timkiem.add(searchpanel);

        jpaneltop.add(title);
        jpaneltop.add(timkiem);
        this.add(jpaneltop);
        model = new DefaultTableModel();
        model.addColumn("Exam ID");
        model.addColumn("Create Time");
        model.addColumn("User ID");
        model.addColumn("Username");
        model.addColumn("Score");
        jTable1.setModel(model);

        this.add(jpaneltable);

        model1 = new DefaultTableModel();
        model1.addColumn("STT");
        model1.addColumn("Question");
        model1.addColumn("Answer of User");
        model1.addColumn("Is Correct");
        jTable2.setModel(model1);

        this.add(jpaneltable1);

        JPanel jpanelshowdetail = new JPanel();
        // jpanelshowdetail.set
        jTextArea1.setEditable(false);
        jTextArea2.setEditable(false);
        jpanelshowdetail.add(jScrollPane1);
        jpanelshowdetail.add(jScrollPane2);
        jpanelshowdetail.setLayout(new BoxLayout(jpanelshowdetail, BoxLayout.X_AXIS));

        this.add(jpanelshowdetail);
        JPanel jPanelbutton = new JPanel(new FlowLayout());
        jPanelbutton.add(buttonBack);
        this.add(jPanelbutton);
        getListExam exam = new getListExam();
        arrayExams = exam.getExam();

        showtable();

    }

    public void showtable() {
        model.setNumRows(0);
        for (int i = 0; i < arrayExams.size(); i++) {
            getListUser listUser = new getListUser();
            Users u = listUser.get1Users(arrayExams.get(i).getUsersID().getUserID());
            model.addRow(new Object[]{arrayExams.get(i).getExamID(), arrayExams.get(i).getCreatedTime(), arrayExams.get(i).getUsersID().getUserID(), u.getUsername(), arrayExams.get(i).getScore()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpaneltable = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonBack = new javax.swing.JButton();
        jpaneltable1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        buttonSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpaneltable.setPreferredSize(new java.awt.Dimension(1300, 449));
        jpaneltable.setLayout(new java.awt.GridLayout());

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
        jScrollPane3.setViewportView(jTable1);

        jpaneltable.add(jScrollPane3);

        buttonBack.setText("Back");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        jpaneltable1.setLayout(new java.awt.GridLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setRequestFocusEnabled(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jpaneltable1.add(jScrollPane4);

        jTextArea1.setColumns(30);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(30);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        buttonSearch.setText("Search");
        buttonSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 1469, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1268, 1268, 1268))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jpaneltable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198)
                        .addComponent(buttonSearch))
                    .addComponent(jpaneltable, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpaneltable, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jpaneltable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(buttonSearch)))
                .addGap(617, 617, 617)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(buttonBack)
                        .addGap(300, 300, 300))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jpaneltable.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
      HomeAdmin le = new HomeAdmin();
         le.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_buttonBackActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        int idexam = (int) jTable1.getValueAt(index, 0);
        
        getExamDetail examDetail = new getExamDetail();
        arrayExamDetails = examDetail.getExamDetail(idexam);

        model1.setNumRows(0);

        for (int i = 0; i < arrayExamDetails.size(); i++) {
            getListQues listQues = new getListQues();
            Question quesofuser = listQues.get1ques(arrayExamDetails.get(i).getQuestionID().getQuestionID());
            getListAnswer listAnswer = new getListAnswer();
            Answers answerofuser = listAnswer.getAnswer(arrayExamDetails.get(i).getAnswerID().getAnswerID());
            if (answerofuser.getIsCorrect() == 1) {
                model1.addRow(new Object[]{i + 1, quesofuser.getQuestionDetail(), answerofuser.getAnswerDetail(), "Đúng"});
            } else {
                model1.addRow(new Object[]{i + 1, quesofuser.getQuestionDetail(), answerofuser.getAnswerDetail(), "Sai"});
            }

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int index = jTable2.getSelectedRow();
        String quesd = jTable2.getValueAt(index, 1).toString();
        String answerd = jTable2.getValueAt(index, 2).toString();

        jTextArea1.setText(quesd);
        jTextArea2.setText(answerd);

    }//GEN-LAST:event_jTable2MouseClicked

    private void buttonSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSearchMouseClicked
        String keys = key.getText();
        getListExam listExam = new getListExam();
        arrayExams = listExam.timkiem(keys);
        showtable();
    }//GEN-LAST:event_buttonSearchMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyBaiThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyBaiThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyBaiThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyBaiThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyBaiThi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JPanel jpaneltable;
    private javax.swing.JPanel jpaneltable1;
    // End of variables declaration//GEN-END:variables
}
