/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.dao.QuesDAO;
import com.dao.getCategoryfromCateName;
import com.dao.getListQues;
import com.model.Categorys;
import com.model.Images;
import com.model.Question;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyCauHoi extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyLuat
     */
    private DefaultTableModel model;
    private DefaultComboBoxModel comboBoxModel;
    private JComboBox comboBox = new JComboBox();
    private ArrayList<Question> arrayques = new ArrayList<Question>();
    private ArrayList<Categorys> listcate = new ArrayList<>();
    private JTextField txtquesdetail = new JTextField();
    private JFileChooser fileChooser;
    private File file = null;

    public QuanLyCauHoi() {
        initComponents();

        this.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        JPanel toppanel = new JPanel(new GridLayout(2, 1));
        JPanel searchPanel = new JPanel(new GridLayout(1, 2));
        searchPanel.add(txtsearch);
        searchPanel.add(buttonsearch);

        JLabel lbtitlepage = new JLabel("Quản lý Câu Hỏi");
        lbtitlepage.setFont(new Font("hihi", Font.BOLD, 24));
        constraints.gridx = 0;
        constraints.gridy = 0;
        toppanel.add(lbtitlepage);
        toppanel.add(searchPanel);
        this.add(toppanel, constraints);
        model = new DefaultTableModel();
        model.addColumn("Question ID");
        model.addColumn("Question Detail");
        model.addColumn("Category ID");
        model.addColumn("Image ID");
        model.addColumn("Image Link");
        jTable1.setModel(model);

        constraints.gridx = 0;
        constraints.gridy = 1;

        this.add(jpaneltable, constraints);

        JPanel jPanelshowdetailrow = new JPanel();

//        jPanelshowdetailrow.add(jScrollPane2);
//        jPanelshowdetailrow.add(jScrollPane3);
        jPanelshowdetailrow.add(lbhinhanh);
        jPanelshowdetailrow.add(jSeparator1);
        jteximagelink.setEditable(false);
        jTexdetail.setEditable(false);
        jPanelshowdetailrow.add(jScrollPane2);
        jPanelshowdetailrow.add(jScrollPane3);
        jPanelshowdetailrow.setLayout(new BoxLayout(jPanelshowdetailrow, BoxLayout.X_AXIS));
        constraints.gridx = 0;
        constraints.gridy = 2;

        this.add(jPanelshowdetailrow, constraints);

        JPanel jpallinput = new JPanel(new GridLayout(1, 3));

        JPanel jpCombo = new JPanel(new GridLayout(1, 2));

        getCategoryfromCateName categoryForLawsMN = new getCategoryfromCateName();
        JLabel lbCombo = new JLabel("Category:");
        jpCombo.add(lbCombo);
        comboBoxModel = new DefaultComboBoxModel();
        listcate.add(categoryForLawsMN.getCategoryName(1));
        listcate.add(categoryForLawsMN.getCategoryName(2));
        listcate.add(categoryForLawsMN.getCategoryName(3));
        listcate.add(categoryForLawsMN.getCategoryName(4));
        listcate.add(categoryForLawsMN.getCategoryName(5));

        comboBoxModel.addElement(categoryForLawsMN.getCategoryName(1));
        comboBoxModel.addElement(categoryForLawsMN.getCategoryName(2));
        comboBoxModel.addElement(categoryForLawsMN.getCategoryName(3));
        comboBoxModel.addElement(categoryForLawsMN.getCategoryName(4));
        comboBoxModel.addElement(categoryForLawsMN.getCategoryName(5));
        jComboBox1.setModel(comboBoxModel);
        jComboBox1.setSelectedIndex(1);

        jpCombo.add(jComboBox1);
        jpCombo.setVisible(true);

        JPanel jpquesdetail = new JPanel(new GridLayout(1, 2));
        JLabel quesdetail = new JLabel("Question Detail:");
        jpquesdetail.add(quesdetail);
        txtquesdetail.setPreferredSize(new Dimension(200, 35));
        jpquesdetail.add(txtquesdetail);
        jpquesdetail.setVisible(true);

        jpallinput.add(jpCombo);
        jpallinput.add(jpquesdetail);
        jpallinput.add(buttonchooseimage);
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
        for (int i = 0; i < arrayques.size(); i++) {
            getCategoryfromCateName categoryForLawsMN = new getCategoryfromCateName();
            getListQues listQues = new getListQues();
            Images imagelinkofques = listQues.getImageforQues(arrayques.get(i).getQuestionID());
            if (imagelinkofques == null) {
                model.addRow(new Object[]{arrayques.get(i).getQuestionID(), arrayques.get(i).getQuestionDetail(), categoryForLawsMN.getCategoryName(arrayques.get(i).getCategoryID().getCategoryID()).getCategoryName(), "", ""});
            } else {
                model.addRow(new Object[]{arrayques.get(i).getQuestionID(), arrayques.get(i).getQuestionDetail(), categoryForLawsMN.getCategoryName(arrayques.get(i).getCategoryID().getCategoryID()).getCategoryName(), imagelinkofques.getImageID(), imagelinkofques.getImageLinks()});
            }
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
        jTexdetail = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jteximagelink = new javax.swing.JTextArea();
        buttonThem = new javax.swing.JButton();
        buttonSua = new javax.swing.JButton();
        buttonXoa = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();
        buttonchooseimage = new javax.swing.JButton();
        lbhinhanh = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonsearch = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jpaneltable.setPreferredSize(new java.awt.Dimension(1300, 410));

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
        jTable1.setPreferredSize(new java.awt.Dimension(1300, 400));
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTexdetail.setColumns(30);
        jTexdetail.setLineWrap(true);
        jTexdetail.setRows(5);
        jScrollPane2.setViewportView(jTexdetail);

        jteximagelink.setColumns(30);
        jteximagelink.setLineWrap(true);
        jteximagelink.setRows(5);
        jScrollPane3.setViewportView(jteximagelink);

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

        buttonchooseimage.setText("Chọn ảnh");
        buttonchooseimage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonchooseimageMouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 100, 100, 1));

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
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbhinhanh)
                                .addGap(2354, 2354, 2354))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(174, 174, 174)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(buttonchooseimage)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(234, 234, 234)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(312, 312, 312)
                                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonsearch)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpaneltable, 1320, 1320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonThem)
                        .addGap(39, 39, 39)
                        .addComponent(buttonSua)
                        .addGap(46, 46, 46)
                        .addComponent(buttonXoa)
                        .addGap(38, 38, 38)
                        .addComponent(buttonBack)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(buttonchooseimage)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpaneltable, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbhinhanh)
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        String catename = jComboBox1.getSelectedItem().toString();
        for (int i = 0; i < listcate.size(); i++) {
            if (listcate.get(i).getCategoryName().equals(catename)) {
                getListQues listQues = new getListQues();
                arrayques = listQues.getLques(listcate.get(i).getCategoryID());
                showtable();
                break;
            }

        }

    }//GEN-LAST:event_jComboBox1ItemStateChanged
    ImageIcon imageIcon;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        String detail = jTable1.getValueAt(index, 1).toString();
        String imagelink = jTable1.getValueAt(index, 4).toString();

        imageIcon = new ImageIcon(new ImageIcon(imagelink).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lbhinhanh.setIcon(imageIcon);
        lbhinhanh.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                 imageIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
//                lbhinhanh.setIcon(imageIcon);
            }

            @Override
            public void mousePressed(MouseEvent e) {

                imageIcon = new ImageIcon(new ImageIcon(imagelink).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
                lbhinhanh.setIcon(imageIcon);
                jScrollPane2.setVisible(false);
                jScrollPane3.setVisible(false);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                imageIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
//                lbhinhanh.setIcon(imageIcon);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                imageIcon = new ImageIcon(new ImageIcon(imagelink).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                lbhinhanh.setIcon(imageIcon);
                jScrollPane2.setVisible(true);
                jScrollPane3.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                imageIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
//                lbhinhanh.setIcon(imageIcon);
            }
        });

        jTexdetail.setText(detail);
        jteximagelink.setText(imagelink);
    }//GEN-LAST:event_jTable1MouseClicked

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        HomeAdmin le = new HomeAdmin();
        le.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThemActionPerformed
        String detail = txtquesdetail.getText();
        String catenam = jComboBox1.getSelectedItem().toString();
        int cateid = 0;
        for (int i = 0; i < listcate.size(); i++) {
            if (listcate.get(i).getCategoryName().equals(catenam)) {
                cateid = listcate.get(i).getCategoryID();
                break;
            }
        }
        String link = null;
        if (file == null) {
            link = null;
        } else {
            link = "Images/ImagesQuestion/" + Paths.get(file.getName());
        }

        boolean check = true;
        if (detail.isEmpty()) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Không đươc để rỗng", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        if (check == true) {
            QuesDAO quesDAO = new QuesDAO();
            quesDAO.addques(detail, cateid);
            int idlast = quesDAO.getquesidlastrow();
            if (link != null) {
                quesDAO.addimageforques(idlast, link);
            }
            for (int i = 0; i < listcate.size(); i++) {
                if (listcate.get(i).getCategoryName().equals(catenam)) {
                    getListQues listQues = new getListQues();
                    arrayques = listQues.getLques(listcate.get(i).getCategoryID());
                    showtable();
                    break;
                }

            }

        }
        buttonchooseimage.setText("Chọn ảnh");
    }//GEN-LAST:event_buttonThemActionPerformed

    private void buttonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXoaActionPerformed
        int index = jTable1.getSelectedRow();
     if(index>0){
        int idques = (int) jTable1.getValueAt(index, 0);
        int confirm = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn xoá không?", "Confrim", JOptionPane.YES_NO_CANCEL_OPTION);

        if (confirm == 0) {
            QuesDAO quesDAO = new QuesDAO();
            quesDAO.deleteques(idques);
            quesDAO.deleteimagesforques(idques);
            String catename = jComboBox1.getSelectedItem().toString();
            for (int i = 0; i < listcate.size(); i++) {
                if (listcate.get(i).getCategoryName().equals(catename)) {
                    getListQues listQues = new getListQues();
                    arrayques = listQues.getLques(listcate.get(i).getCategoryID());
                    showtable();
                }

            }
            JOptionPane.showMessageDialog(rootPane, "Xoá thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);

        } else {
            jTable1.setRowSelectionInterval(0, 0);
        }
     }else
          JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn hàng nào!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_buttonXoaActionPerformed

    private void buttonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSuaActionPerformed
        int index = jTable1.getSelectedRow();
        if(index>0){
        int idques = (int) jTable1.getValueAt(index, 0);
        String detail = txtquesdetail.getText();

        String catenam = jComboBox1.getSelectedItem().toString();
        int cateid = 0;
        for (int i = 0; i < listcate.size(); i++) {
            if (listcate.get(i).getCategoryName().equals(catenam)) {
                cateid = listcate.get(i).getCategoryID();
                break;
            }
        }

        String link = null;
        if (file == null) {
            link = null;
        } else {
            link = "Images/ImagesQuestion/" + Paths.get(file.getName());
        }

        boolean check = true;
        if (detail == null || link == null) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Không đươc để rỗng", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        if (check == true) {
            QuesDAO quesDAO = new QuesDAO();
            quesDAO.updateques(idques, detail, cateid);

            quesDAO.updateimageforques(idques, link);

            String catename = jComboBox1.getSelectedItem().toString();
            for (int i = 0; i < listcate.size(); i++) {
                if (listcate.get(i).getCategoryName().equals(catename)) {
                    getListQues listQues = new getListQues();
                    arrayques = listQues.getLques(listcate.get(i).getCategoryID());
                    showtable();
                }
            }
        }
        buttonchooseimage.setText("Chọn ảnh");
        }
        else
             JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn hàng nào!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_buttonSuaActionPerformed

    private void buttonchooseimageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonchooseimageMouseClicked
        fileChooser = new JFileChooser(new File("D:\\Github\\Project2_ATGT_Admin\\Project2_Admin\\JavaApplication2\\Images\\ImagesQuestion"));
        fileChooser.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }

                return f.getName().endsWith(".png");
            }

            @Override
            public String getDescription() {
                return "Chi duoc la png file!";
            }

        });

        if (fileChooser.showOpenDialog(this) == JFileChooser.OPEN_DIALOG) {
            try {
                file = fileChooser.getSelectedFile();
                buttonchooseimage.setText("Bạn đã chọn ảnh");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_buttonchooseimageMouseClicked

    private void buttonsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonsearchMouseClicked
         String key = txtsearch.getText();
        String catenam = jComboBox1.getSelectedItem().toString();
        int cateid = 0;
        for (int i = 0; i < listcate.size(); i++) {
            if (listcate.get(i).getCategoryName().equals(catenam)) {
                cateid = listcate.get(i).getCategoryID();
                break;
            }
        }
        QuesDAO quesDAO = new QuesDAO();
        arrayques = quesDAO.timkiem(key, cateid);
        showtable();
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
            java.util.logging.Logger.getLogger(QuanLyCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyCauHoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonSua;
    private javax.swing.JButton buttonThem;
    private javax.swing.JButton buttonXoa;
    private javax.swing.JButton buttonchooseimage;
    private javax.swing.JButton buttonsearch;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTexdetail;
    private javax.swing.JPanel jpaneltable;
    private javax.swing.JTextArea jteximagelink;
    private javax.swing.JLabel lbhinhanh;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
