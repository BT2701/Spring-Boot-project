package com.example.demo.View.ThanhVien;




import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import com.example.demo.Controller.ThanhVienCTL;
import com.example.demo.Controller.XuLyCTL;
import com.example.demo.Model.ThanhVienModel;
import com.example.demo.Model.XuLyModel;
import com.example.demo.View.Styles.Styles;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author phamv
 */
public class FormCanhBaoViPham extends javax.swing.JDialog {
	private Color mainColor = Color.decode("#dff9fb");
	private Color tableColor= new java.awt.Color(126, 214, 223);
	Styles style = new Styles();
    ThanhVienCTL tvCtl = new ThanhVienCTL();
    XuLyCTL xuLyCTL = new XuLyCTL();
    String[] viPhamList = {"Khóa thẻ 1 tháng", "Khóa thẻ 2 tháng", "Bồi thường mất tài sản", "Phạt tiền 10$", "Hủy thẻ"};
    /**
     * Creates new form FormCanhBaoViPham
     */
    public FormCanhBaoViPham() {
    	setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		setTitle("Cảnh báo");
		setIconImage(new ImageIcon(getClass().getResource("/com/example/demo/View/images/material.png")).getImage());
//        super(parent, modal);
        initComponents();
        initMyComponents();
        jpContent.setBackground(Color.white);
        jpHeader.setBackground(Color.white);
        setVisible(true);
    }

    
    private void initMyComponents(){
        jlTitle.setFont(sgUI15b); // NOI18N
        
        
        jlThanhVien.setFont(sgUI13b); // NOI18N
        
        jlViPham.setFont(sgUI13b); // NOI18N

        jlSoTien.setFont(sgUI13b);

        cbThanhVien.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbThanhVien.setBackground(Color.white);
        cbThanhVien.setFont(sgUI13b);
        cbThanhVien.setPreferredSize(new Dimension(100, 30));
        cbThanhVien.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        
        
        cbViPham.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbViPham.setBackground(Color.white);
        cbViPham.setFont(sgUI13b);
        cbViPham.setPreferredSize(new Dimension(100, 30));

        txtSoTien.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        txtSoTien.setBackground(Color.white);
        txtSoTien.setFont(sgUI13b);
        txtSoTien.setPreferredSize(new Dimension(100, 30));
        txtSoTien.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 3, 0, 3)));
        
        btnXacNhan.setFont(sgUI13b);
        btnXacNhan.setFocusPainted(false);
        btnXacNhan.setBorderPainted(false);
        btnXacNhan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnXacNhan.setPreferredSize(new java.awt.Dimension(100, 23));
        btnXacNhan.setBackground(Color.decode("#7ed6df"));
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String maTV = cbThanhVien.getSelectedItem().toString().split("-")[0];
                String viPham = cbViPham.getText();
                String soTien = txtSoTien.getText();

                if(soTien.isEmpty()) {
//                    ThanhVienModel thanhVienModel = tvCtl.getModel(Integer.parseInt(maTV));
//
//                    int xulyLength = xuLyCTL.getList().size();
//                    int id = xuLyCTL.getList().get(xulyLength - 1).getMaXL() + 1;
//                    XuLyModel xuLyModel = new XuLyModel(id, viPham, null, null, 0, thanhVienModel);
//                    xuLyCTL.addModel(xuLyModel);

                    JOptionPane.showMessageDialog(FormCanhBaoViPham.this,  " Đã thêm cảnh báo với thành viên có mã : " + maTV + " thành công !");
                    setVisible(false);
                    return;
                }
                if (!soTien.matches("\\d+")) {
                    JOptionPane.showMessageDialog(FormCanhBaoViPham.this,  " Tiền phải là số !");
                    return;
                }

//                ThanhVienModel thanhVienModel = tvCtl.getModel(Integer.parseInt(maTV));
//
//                int xulyLength = xuLyCTL.getList().size();
//                int id = xuLyCTL.getList().get(xulyLength - 1).getMaXL() + 1;
//                XuLyModel xuLyModel = new XuLyModel(id, viPham, Integer.parseInt(soTien), null, 0, thanhVienModel);
//                xuLyCTL.addModel(xuLyModel);

                JOptionPane.showMessageDialog(FormCanhBaoViPham.this,  " Đã thêm cảnh báo với thành viên có mã : " + maTV + " thành công !");
                setVisible(false);
            }
        });
        
        btnLamMoi.setFont(sgUI13b);
        btnLamMoi.setFocusPainted(false);
        btnLamMoi.setBorderPainted(false);
        btnLamMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(100, 23));
        btnLamMoi.setBackground(Color.decode("#7ed6df"));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbThanhVien.setSelectedIndex(0);
                cbViPham.setText("");
                txtSoTien.setText("");
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpHeader = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
        jpContent = new javax.swing.JPanel();
        jlThanhVien = new javax.swing.JLabel();
        jlViPham = new javax.swing.JLabel();
        cbThanhVien = new javax.swing.JComboBox<>();
        cbViPham = new javax.swing.JTextField();
        jlSoTien = new javax.swing.JLabel();
        txtSoTien = new javax.swing.JTextField();
        btnXacNhan = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();

        jpHeader.setBackground(mainColor);
        jpHeader.setPreferredSize(new java.awt.Dimension(400, 50));
        jpHeader.setLayout(new java.awt.BorderLayout());

        jlTitle.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jlTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitle.setText("Cảnh Báo Vi Phạm");
        jlTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jpHeader.add(jlTitle, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpHeader, java.awt.BorderLayout.PAGE_START);

        jlThanhVien.setText("Thành viên ");
        jlViPham.setText("Vi phạm ");
        jlSoTien.setText("Số tiền ");

//        String[] tvArr = tvCtl.getList().stream()
//                .map(tv -> tv.getMaTV() + "-" + tv.getHoTen())
//                .toArray(String[]::new);
//        cbThanhVien.setModel(new javax.swing.DefaultComboBoxModel<>(tvArr));

        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/demo/View/images/xacnhan_icon.png"))); // NOI18N
        btnXacNhan.setText("Xác Nhận");

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/demo/View/images/Refresh_icon.png"))); // NOI18N
        btnLamMoi.setText("Làm Mới");

        javax.swing.GroupLayout jpContentLayout = new javax.swing.GroupLayout(jpContent);
        jpContent.setLayout(jpContentLayout);
        jpContentLayout.setHorizontalGroup(
            jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContentLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpContentLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnXacNhan)
                        .addGap(78, 78, 78)
                        .addComponent(btnLamMoi))
                    .addGroup(jpContentLayout.createSequentialGroup()
                        .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlThanhVien)
                            .addComponent(jlViPham)
                            .addComponent(jlSoTien))
                        .addGap(37, 37, 37)
                    .addGroup(jpContentLayout.createSequentialGroup()
                        .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbThanhVien, 0, 180, Short.MAX_VALUE)
                            .addComponent(cbViPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoTien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                ).addContainerGap(47, Short.MAX_VALUE))
        );
        jpContentLayout.setVerticalGroup(
            jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContentLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlThanhVien)
                    .addComponent(cbThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlViPham)
                    .addComponent(cbViPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSoTien)
                    .addComponent(txtSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jpContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan)
                    .addComponent(btnLamMoi))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        getContentPane().add(jpContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormCanhBaoViPham.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCanhBaoViPham.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCanhBaoViPham.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCanhBaoViPham.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the dialog */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JComboBox<String> cbThanhVien;
    private javax.swing.JTextField cbViPham;
    private javax.swing.JTextField txtSoTien;
    private javax.swing.JLabel jlThanhVien;
    private javax.swing.JLabel jlSoTien;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JLabel jlViPham;
    private javax.swing.JPanel jpContent;
    private javax.swing.JPanel jpHeader;
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

    // Custom font adn color - end
}
