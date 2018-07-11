/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.dao.LawDAO;
import com.dao.TrafficDAO;
import com.dao.getCategoryfromCateName;
import com.dao.getListBienBao;
import com.dao.getListLaw;
import com.model.Categorys;
import com.model.Law;
import com.model.Trafficsigns;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyBienBao extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyLuat
     */
    private DefaultTableModel model;
    private DefaultComboBoxModel comboBoxModel;
    private JComboBox comboBox = new JComboBox();
    private ArrayList<Trafficsigns> arraytraffic = new ArrayList<Trafficsigns>();
    private ArrayList<Categorys> listcate = new ArrayList<>();
    private JTextField txttraffictitle = new JTextField();
    private JTextField txttrafficdetail = new JTextField();
    private JFileChooser fileChooser;
    private File file = null;

    public QuanLyBienBao() {
        initComponents();

        this.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        JPanel jPaneltop = new JPanel(new GridLayout(2, 1));
        JLabel lbtitlepage = new JLabel("Quản lý Biển Báo");
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
        model.addColumn("Traffic SignID");
        model.addColumn("Traffic Link");
        model.addColumn("Traffic Title");
        model.addColumn("Traffic Detail");
        model.addColumn("Category");
        jTable1.setModel(model);

        constraints.gridx = 0;
        constraints.gridy = 1;

        this.add(jpaneltable, constraints);

        JPanel jPanelshowdetailrow = new JPanel();

//        jPanelshowdetailrow.add(jScrollPane2);
//        jPanelshowdetailrow.add(jScrollPane3);
        jPanelshowdetailrow.add(lbhinhanh);
        jPanelshowdetailrow.add(jSeparator1);
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
        listcate.add(categoryForLawsMN.getCategoryName(6));
        listcate.add(categoryForLawsMN.getCategoryName(7));
        listcate.add(categoryForLawsMN.getCategoryName(8));
        listcate.add(categoryForLawsMN.getCategoryName(9));
        comboBoxModel.addElement(categoryForLawsMN.getCategoryName(6));
        comboBoxModel.addElement(categoryForLawsMN.getCategoryName(7));
        comboBoxModel.addElement(categoryForLawsMN.getCategoryName(8));
        comboBoxModel.addElement(categoryForLawsMN.getCategoryName(9));

        jComboBox1.setModel(comboBoxModel);
        jComboBox1.setSelectedIndex(1);

        jpCombo.add(jComboBox1);
        jpCombo.setVisible(true);

        JPanel jptraffictitle = new JPanel(new GridLayout(1, 2));
        JLabel lbLawtitle = new JLabel("Traffic Title:");
        jptraffictitle.add(lbLawtitle);
        txttraffictitle.setPreferredSize(new Dimension(150, 35));
        jptraffictitle.add(txttraffictitle);
        jptraffictitle.setVisible(true);

        JPanel jptrafficdetail = new JPanel(new GridLayout(1, 2));
        JLabel lblawdetail = new JLabel("Traffic Detail:");
        jptrafficdetail.add(lblawdetail);
        txttrafficdetail.setPreferredSize(new Dimension(150, 35));
        jptrafficdetail.add(txttrafficdetail);
        jptrafficdetail.setVisible(true);

        jpallinput.add(jpCombo);
        jpallinput.add(buttonchooseimage);
        //jpallinput.add(fileChooser);
        jpallinput.add(jptraffictitle);
        jpallinput.add(jptrafficdetail);
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
        for (int i = 0; i < arraytraffic.size(); i++) {

            getCategoryfromCateName categoryForLawsMN = new getCategoryfromCateName();

            model.addRow(new Object[]{arraytraffic.get(i).getTrafficsignsID(), arraytraffic.get(i).getTrafficLink(), arraytraffic.get(i).getTrafficTitle(), arraytraffic.get(i).getTrafficDetails(), categoryForLawsMN.getCategoryName(arraytraffic.get(i).getCategoryID().getCategoryID()).getCategoryName()});
        }
    }

    public void showtabletimkiem() {
        model.setNumRows(0);
        for (int i = 0; i < arraytraffic.size(); i++) {

            model.addRow(new Object[]{arraytraffic.get(i).getTrafficsignsID(), arraytraffic.get(i).getTrafficLink(), arraytraffic.get(i).getTrafficTitle(), arraytraffic.get(i).getTrafficDetails(), arraytraffic.get(i).getCategoryID().getCategoryID()});
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
        buttonThem = new javax.swing.JButton();
        buttonSua = new javax.swing.JButton();
        buttonXoa = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();
        lbhinhanh = new javax.swing.JLabel();
        buttonchooseimage = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtSearch = new javax.swing.JTextField();
        buttonsearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jpaneltable.setPreferredSize(new java.awt.Dimension(1300, 402));

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtextitle.setColumns(40);
        jtextitle.setLineWrap(true);
        jtextitle.setRows(5);
        jScrollPane2.setViewportView(jtextitle);

        jtexdetail.setColumns(40);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(buttonchooseimage)
                                .addGap(395, 395, 395))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbhinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(buttonsearch)))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(buttonchooseimage)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonsearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbhinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(537, 537, 537))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jpaneltable, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        String catename = jComboBox1.getSelectedItem().toString();
        for (int i = 0; i < listcate.size(); i++) {
            if (listcate.get(i).getCategoryName().equals(catename)) {
                getListBienBao libb = new getListBienBao();
                arraytraffic = libb.getltraffic(listcate.get(i).getCategoryID());
                showtable();
            }

        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged
    ImageIcon imageIcon;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        String link = jTable1.getValueAt(index, 1).toString();
        String title = jTable1.getValueAt(index, 2).toString();
        String detail = jTable1.getValueAt(index, 3).toString();
//        String catenam = jComboBox1.getSelectedItem().toString();
//        String link = null;
//        switch (catenam) {
//            case "Biển Báo Cấm":
//                link = "Images/Bien_Bao_Cam/" + nampick;
//                break;
//            case "Biển Báo Chỉ Dẫn":
//                link = "Images/Bien_Bao_Chi_Dan/" + nampick;
//                break;
//            case "Biển Báo Hiệu Lệnh":
//                link = "Images/Bien_Bao_Hieu_Lenh/" + nampick;
//                break;
//            case "Biển Báo Nguy Hiểm":
//                link = "Images/Bien_Bao_Nguy_Hiem/" + nampick;
//                break;
//            default:
//                link = null;
//                break;
//        }

        imageIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lbhinhanh.setIcon(imageIcon);
        lbhinhanh.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                 imageIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
//                lbhinhanh.setIcon(imageIcon);
            }

            @Override
            public void mousePressed(MouseEvent e) {

                imageIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
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
                imageIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
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
        jtextitle.setText(title);
        jtexdetail.setText(detail);
    }//GEN-LAST:event_jTable1MouseClicked

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        HomeAdmin le = new HomeAdmin();
        le.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThemActionPerformed
        String title = txttraffictitle.getText();
        String detail = txttrafficdetail.getText();
        boolean check = true;
        if (title.isEmpty() || detail.isEmpty() || file == null) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Không đươc để rỗng", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

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
            switch (catenam) {
                case "Biển Báo Cấm":
                    link = "Images/Bien_Bao_Cam/" + Paths.get(file.getName());
                    break;
                case "Biển Báo Chỉ Dẫn":
                    link = "Images/Bien_Bao_Chi_Dan/" + Paths.get(file.getName());
                    break;
                case "Biển Báo Hiệu Lệnh":
                    link = "Images/Bien_Bao_Hieu_Lenh/" + Paths.get(file.getName());
                    break;
                case "Biển Báo Nguy Hiểm":
                    link = "Images/Bien_Bao_Nguy_Hiem/" + Paths.get(file.getName());
                    break;
                default:
                    link = null;
                    break;
            }
        }
        if (check == true) {
            TrafficDAO trafficDAO = new TrafficDAO();
            trafficDAO.addtraffic(link, title, detail, cateid);

            String catename = jComboBox1.getSelectedItem().toString();
            for (int i = 0; i < listcate.size(); i++) {
                if (listcate.get(i).getCategoryName().equals(catename)) {
                    getListBienBao libb = new getListBienBao();
                    arraytraffic = libb.getltraffic(listcate.get(i).getCategoryID());
                    showtable();
                }

            }
        }
        buttonchooseimage.setText("Chọn ảnh");
        txttrafficdetail.requestFocusInWindow();
    }//GEN-LAST:event_buttonThemActionPerformed

    private void buttonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXoaActionPerformed

        int index = jTable1.getSelectedRow();
        if (index > 0) {
            int idtraff = (int) jTable1.getValueAt(index, 0);

            int confirm = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn xoá không?", "Confrim", JOptionPane.YES_NO_CANCEL_OPTION);

            if (confirm == 0) {
                TrafficDAO trafficDAO = new TrafficDAO();
                trafficDAO.deletetraffic(idtraff);

                String catename = jComboBox1.getSelectedItem().toString();
                for (int i = 0; i < listcate.size(); i++) {
                    if (listcate.get(i).getCategoryName().equals(catename)) {
                        getListBienBao libb = new getListBienBao();
                        arraytraffic = libb.getltraffic(listcate.get(i).getCategoryID());
                        showtable();
                    }

                }
                JOptionPane.showMessageDialog(rootPane, "Xoá thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);

            } else {
                jTable1.setRowSelectionInterval(0, 0);
            }
        } else 
             JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn hàng nào!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_buttonXoaActionPerformed

    private void buttonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSuaActionPerformed
        int index = jTable1.getSelectedRow();
        if (index > 0) {
            int idtraffic = (int) jTable1.getValueAt(index, 0);
            String title = txttraffictitle.getText();
            String detail = txttrafficdetail.getText();

            boolean check = true;
            if (title == null || detail == null || file == null) {
                check = false;
                JOptionPane.showMessageDialog(rootPane, "Không đươc để rỗng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

            String catenam = jComboBox1.getSelectedItem().toString();
            int cateid = 0;
            for (int i = 0; i < listcate.size(); i++) {
                if (listcate.get(i).getCategoryName().equals(catenam)) {
                    cateid = listcate.get(i).getCategoryID();
                    break;
                }
            }

            String link = null;
            switch (catenam) {
                case "Biển Báo Cấm":
                    link = "Images/Bien_Bao_Cam/" + Paths.get(file.getName());
                    break;
                case "Biển Báo Chỉ Dẫn":
                    link = "Images/Bien_Bao_Chi_Dan/" + Paths.get(file.getName());
                    break;
                case "Biển Báo Hiệu Lệnh":
                    link = "Images/Bien_Bao_Hieu_Lenh/" + Paths.get(file.getName());
                    break;
                case "Biển Báo Nguy Hiểm":
                    link = "Images/Bien_Bao_Nguy_Hiem/" + Paths.get(file.getName());
                    break;
                default:
                    link = null;
                    break;
            }

            if (check == true) {
                TrafficDAO traffic = new TrafficDAO();
                traffic.updatetraffic(idtraffic, link, title, detail, cateid);

                String catename = jComboBox1.getSelectedItem().toString();
                for (int i = 0; i < listcate.size(); i++) {
                    if (listcate.get(i).getCategoryName().equals(catename)) {
                        getListBienBao libb = new getListBienBao();
                        arraytraffic = libb.getltraffic(listcate.get(i).getCategoryID());
                        showtable();
                    }

                }
            } else {
            }
            buttonchooseimage.setText("Chọn ảnh");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn hàng nào!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonSuaActionPerformed

    private void buttonchooseimageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonchooseimageMouseClicked
        // TODO add your handling code here:
        String catenam = jComboBox1.getSelectedItem().toString();
        String link = null;
        switch (catenam) {
            case "Biển Báo Cấm":
                link = "D:\\Github\\Project2_ATGT_Admin\\Project2_Admin\\JavaApplication2\\Images\\Bien_Bao_Cam";
                break;
            case "Biển Báo Chỉ Dẫn":
                link = "D:\\Github\\Project2_ATGT_Admin\\Project2_Admin\\JavaApplication2\\Images\\Bien_Bao_Chi_Dan";
                break;
            case "Biển Báo Hiệu Lệnh":
                link = "D:\\Github\\Project2_ATGT_Admin\\Project2_Admin\\JavaApplication2\\Images\\Bien_Bao_Hieu_Lenh";
                break;
            case "Biển Báo Nguy Hiểm":
                link = "D:\\Github\\Project2_ATGT_Admin\\Project2_Admin\\JavaApplication2\\Images\\Bien_Bao_Nguy_Hiem";
                break;
            default:
                link = null;
                break;
        }

        fileChooser = new JFileChooser(new File(link));
        fileChooser.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }

                return f.getName().endsWith(".jpg");
            }

            @Override
            public String getDescription() {
                return "Chi duoc la jpg file!";
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
        // TODO add your handling code here:
        String key = txtSearch.getText();
//        if(key==null){
//        txtSearch.requestFocusInWindow();
//        }
        TrafficDAO trafficDAO = new TrafficDAO();
        arraytraffic = trafficDAO.timkiem(key);
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
            java.util.logging.Logger.getLogger(QuanLyBienBao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyBienBao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyBienBao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyBienBao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyBienBao().setVisible(true);
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
    private javax.swing.JPanel jpaneltable;
    private javax.swing.JTextArea jtexdetail;
    private javax.swing.JTextArea jtextitle;
    private javax.swing.JLabel lbhinhanh;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
