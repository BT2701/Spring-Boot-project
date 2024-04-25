/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.example.demo.View.ThanhVien;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import com.example.demo.Controller.ThanhVienCTL;
import com.example.demo.Controller.ThietBiCTL;
import com.example.demo.Controller.ThongTinSdCTL;
import com.example.demo.Model.ThanhVienModel;
import com.example.demo.Model.ThongTinSdModel;
import com.example.demo.View.Styles.Styles;

/**
 *
 * @author phamv
 */
public class FormKhuVucHocTap extends javax.swing.JDialog {
	private Color mainColor = Color.decode("#dff9fb");
	private Color tableColor= new java.awt.Color(126, 214, 223);
	Styles style = new Styles();
    ThanhVienCTL tvCtl = new ThanhVienCTL();
    ThietBiCTL tbCtl = new ThietBiCTL();
    ThongTinSdCTL sdCtl = new ThongTinSdCTL();
    /**
     * Creates new form FormKhuVucHocTap
     */
    public FormKhuVucHocTap() {
    	setSize(400, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		setTitle("Vào khu học tập");
		setIconImage(new ImageIcon(getClass().getResource("/com/example/demo/View/images/material.png")).getImage());
//        super(parent, modal);
        initComponents();
        intiMyComponents();
        changeValueOfTextfileWhenMaTVChange("");
        jpContent.setBackground(Color.white);
        jpHeader.setBackground(Color.white);
        setVisible(true);
    }
    
    public void changeValueOfTextfileWhenMaTVChange(String fill) {
    	if(fill.equals("")) {
    		txtHoTen.setText("");
            txtHoTen.setEditable(false);

            txtSdt.setText("");
            txtSdt.setEditable(false);

            cbKhoa.setText("");
            cbKhoa.setEditable(false);

            cbNganh.setText("");
            cbNganh.setEditable(false);
    	}
    	else {
    		int id = Integer.parseInt((String) cbThanhVien.getText());
//            ThanhVienModel thanhVienModel = tvCtl.getModel(id);
//            cbThanhVien.setSelectedItem(thanhVienModel.getMaTV());

//            txtHoTen.setText(thanhVienModel.getHoTen());
//            txtHoTen.setEditable(false);
//
//            txtSdt.setText(thanhVienModel.getSdt());
//            txtSdt.setEditable(false);
//
//            cbKhoa.setText(thanhVienModel.getKhoa());
//            cbKhoa.setEditable(false);
//
//            cbNganh.setText(thanhVienModel.getNganh());
//            cbNganh.setEditable(false);
    	}
    }

    private void intiMyComponents(){
        jlTitle.setFont(sgUI15b); // NOI18N
        jlThanhVien.setFont(sgUI13b); // NOI18N
        jlHoTen.setFont(sgUI13b); // NOI18N
        jlKhoa.setFont(sgUI13b); // NOI18N
        jlNganh.setFont(sgUI13b); // NOI18N
        jlSdt.setFont(sgUI13b); // NOI18N
        
        txtHoTen.setPreferredSize(new Dimension(200, 30));
        txtHoTen.setFont(sgUI13p);
        txtHoTen.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtHoTen.setForeground(Color.black);

        txtSdt.setPreferredSize(new Dimension(200, 30));
        txtSdt.setFont(sgUI13p);
        txtSdt.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtSdt.setForeground(Color.black);

        
        btnXacNhan.setFont(sgUI13b);
        btnXacNhan.setFocusPainted(false);
        btnXacNhan.setBorderPainted(false);
        btnXacNhan.setPreferredSize(new java.awt.Dimension(100, 23));
        btnXacNhan.setBackground(Color.decode("#7ed6df"));

        btnLamMoi.setFont(sgUI13b);
        btnLamMoi.setFocusPainted(false);
        btnLamMoi.setBorderPainted(false);
        btnLamMoi.setPreferredSize(new java.awt.Dimension(100, 23));
        btnLamMoi.setBackground(Color.decode("#7ed6df"));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbThanhVien.setText("");
                txtHoTen.setText("");
                cbKhoa.setText("");
                cbNganh.setText("");
                txtSdt.setText("");
            }
        });
        
        cbThanhVien.setBorder(new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF")));
        cbThanhVien.setBackground(Color.white);
        cbThanhVien.setFont(sgUI13b);
        cbThanhVien.setPreferredSize(new Dimension(100, 30));
//        cbThanhVien.setUI(new BasicComboBoxUI() {
//            @Override
//            protected ComboPopup createPopup() {
//                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
//                basicComboPopup.setBorder(lineCB);
//                return basicComboPopup;
//            }
//        });
//        cbThanhVien.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            	int id= Integer.parseInt(cbThanhVien.getText());
//            	if(tvCtl.getModel(id)==null) {
//            		cbThanhVien.setText("");
//            		changeValueOfTextfileWhenMaTVChange("");
//            		return;
//            	}
//                changeValueOfTextfileWhenMaTVChange("1");
//            }
//        });

        cbKhoa.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbKhoa.setFont(sgUI13b);
//        cbNganh.setBackground(null);
        cbKhoa.setPreferredSize(new Dimension(100, 30));

        cbNganh.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbNganh.setFont(sgUI13b);
//        cbNganh.setBackground(null);
        cbNganh.setPreferredSize(new Dimension(100, 30));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpHeader = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
        jpContent = new javax.swing.JPanel();
        jlThanhVien = new javax.swing.JLabel();
        jlHoTen = new javax.swing.JLabel();
        jlKhoa = new javax.swing.JLabel();
        jlNganh = new javax.swing.JLabel();
        jlSdt = new javax.swing.JLabel();
        btnXacNhan = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        txtHoTen = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        cbThanhVien = new javax.swing.JTextField();
        cbKhoa = new javax.swing.JTextField();
        cbNganh = new javax.swing.JTextField();


        jpHeader.setBackground(mainColor);
        jpHeader.setMinimumSize(new java.awt.Dimension(100, 50));
        jpHeader.setPreferredSize(new java.awt.Dimension(400, 50));
        jpHeader.setLayout(new java.awt.BorderLayout());

        jlTitle.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        
        jlTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitle.setText("Khu Vực Học Tập");
        jlTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jpHeader.add(jlTitle, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpHeader, java.awt.BorderLayout.PAGE_START);

        jlThanhVien.setText("Mã thành viên");

        jlHoTen.setText("Họ và Tên");

        jlKhoa.setText("Khoa");

        jlNganh.setText("Ngành");

        jlSdt.setText("Sđt");

        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/demo/View/images/xacnhan_icon.png"))); // NOI18N
        btnXacNhan.setText("Xác Nhận");
        btnXacNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnXacNhanActionPerformed(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/demo/View/images/Refresh_icon.png"))); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

//        String[] maTVArr = tvCtl.getList().stream()
//                .map(tv -> Integer.toString(tv.getMaTV()))
//                .toArray(String[]::new);
//        cbThanhVien.setModel(new javax.swing.DefaultComboBoxModel<>(maTVArr));

        javax.swing.GroupLayout jpContentLayout = new javax.swing.GroupLayout(jpContent);
        jpContent.setLayout(jpContentLayout);
        jpContentLayout.setHorizontalGroup(
            jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContentLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpContentLayout.createSequentialGroup()
                        .addComponent(jlThanhVien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(cbThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpContentLayout.createSequentialGroup()
                        .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlHoTen)
                            .addComponent(jlKhoa)
                            .addComponent(jlNganh)
                            .addComponent(jlSdt))
                        .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpContentLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpContentLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHoTen)
                                    .addComponent(cbKhoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbNganh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(59, 59, 59))
            .addGroup(jpContentLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpContentLayout.setVerticalGroup(
            jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContentLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlThanhVien)
                    .addComponent(cbThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlHoTen)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlKhoa)
                    .addComponent(cbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNganh)
                    .addComponent(cbNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSdt)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        getContentPane().add(jpContent, java.awt.BorderLayout.CENTER);


    }// </editor-fold>//GEN-END:initComponents

//    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
//        int maTV = Integer.parseInt(cbThanhVien.getText().toString().split("-")[0]);
//
//        ThanhVienModel thanhVienModel = tvCtl.getModel(maTV);
//        ThongTinSdModel thongTinSdModel = sdCtl.getModelByMaTVAndMaTB(maTV, -1);
//        if(thongTinSdModel != null && thongTinSdModel.getTgVao() != null) {
//            JOptionPane.showMessageDialog(FormKhuVucHocTap.this,  "Thành viên có mã : " + maTV + " đã vào khu vực này! Vui lòng kiểm tra lại !");
//        } else if(thongTinSdModel != null && thongTinSdModel.getTgVao() == null) {
//            thongTinSdModel.setTgVao(new Date());
//            sdCtl.updateModel(thongTinSdModel);
//            JOptionPane.showMessageDialog(FormKhuVucHocTap.this,  "Đã thêm thành viên có mã : " + maTV + " vào khu vực học  thành công !");
//            setVisible(false);
//        } else if(thongTinSdModel == null) {
//            thongTinSdModel = new ThongTinSdModel(maTV, new Date(), null, null, null, thanhVienModel, null);
//            sdCtl.addModel(thongTinSdModel);
//            JOptionPane.showMessageDialog(FormKhuVucHocTap.this,  "Đã thêm thành viên có mã : " + maTV + " vào khu vực học  thành công !");
//            setVisible(false);
//        }
//    }//GEN-LAST:event_btnXacNhanActionPerformed

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
            java.util.logging.Logger.getLogger(FormKhuVucHocTap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKhuVucHocTap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKhuVucHocTap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKhuVucHocTap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JTextField cbKhoa;
    private javax.swing.JTextField cbNganh;
    private javax.swing.JTextField cbThanhVien;
    private javax.swing.JLabel jlHoTen;
    private javax.swing.JLabel jlKhoa;
    private javax.swing.JLabel jlNganh;
    private javax.swing.JLabel jlSdt;
    private javax.swing.JLabel jlThanhVien;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JPanel jpContent;
    private javax.swing.JPanel jpHeader;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtSdt;
    // End of variables declaration//GEN-END:variables

  // Custom font and color -start
    private Font sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13p = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    private Font tNR13i = new Font("Times New Roman", Font.ITALIC, 13);
    private Font fontTittle = new Font("Tahoma", Font.BOLD, 25);
    private Font fontSubTittle = new Font("Tahoma", Font.BOLD, 20);
    private Font fontTable = new Font("Segoe UI", Font.BOLD, 13);
    private DecimalFormat dcf = new DecimalFormat("###,###");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Color btnoldColor = new Color(52, 152, 219);
    private Color texfieldColor = new Color(45, 52, 54);
    private MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    private LineBorder lineCB = new LineBorder(Color.white);
    private MatteBorder borderTxt = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    // Custom font adn color - end
}
