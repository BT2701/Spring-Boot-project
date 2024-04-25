/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.example.demo.View.ThanhVien;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import com.example.demo.View.Styles.Styles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phamv
 */
public class FormXemChiTiet extends JDialog {
	private Color mainColor = Color.decode("#dff9fb");
	private Color tableColor= new Color(126, 214, 223);
	Styles style = new Styles();
    String randomMaTv = "0";
    /**
     * Creates new form FormThemThanhVien
     */
    public FormXemChiTiet(String titleForm) {
    	setSize(500, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		setTitle("Xử lý");
		setIconImage(new ImageIcon(getClass().getResource("/com/example/demo/View/images/material.png")).getImage());
        initComponents();
        initMyComponents(titleForm);
//        changeComponentForDiffForm(titleForm);
        content.setBackground(Color.white);
        header.setBackground(Color.white);
        setVisible(true);

    }

    public FormXemChiTiet(String titleForm, String maTV, String hoTen, String sdt, String khoa, String nganh, String email, String password, String thietBiDaMuon, String xuLyDaCo) {
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setTitle("Xử lý");
        setIconImage(new ImageIcon(getClass().getResource("/com/example/demo/View/images/material.png")).getImage());
        initComponents();
        initMyComponents(titleForm);
        changeComponentForDiffForm(titleForm, maTV, hoTen, sdt, khoa, nganh, email, password, thietBiDaMuon, xuLyDaCo);
        setVisible(true);
    }

    private void changeComponentForDiffForm(String titleForm, String maTV, String hoTen, String sdt, String khoa, String nganh, String email, String password, String thietBiDaMuon, String xuLyDaCo){
        txtMaTV.setEditable(false);
        txtMaTV.setText(maTV);

        txtSdt.setEditable(false);
        txtSdt.setText(sdt);

        txtHoTen.setEditable(false);
        txtHoTen.setText(hoTen);

        txtKhoa.setEditable(false);
        txtKhoa.setText(khoa);

        txtNganh.setEditable(false);
        txtNganh.setText(nganh);

        txtEmail.setEditable(false);
        txtEmail.setText(email);

        txtPassword.setEditable(false);
        txtPassword.setText(password);

        viPhamValue.setText(xuLyDaCo);
        thietBiDaMuonValue.setText(thietBiDaMuon);
    }

    private void initMyComponents(String titleForm){
        title.setText(titleForm);
        title.setFont(sgUI15b);
        lbHoTen.setFont(sgUI13b); // NOI18N
        lbMaTV.setFont(sgUI13b); // NOI18N
        lbSdt.setFont(sgUI13b); // NOI18N
        lbEmail.setFont(sgUI13b);
        lbNganh.setFont(sgUI13b);
        lbViPham.setFont(sgUI13b);
        lbThietBiDaMuon.setFont(sgUI13b);
        lbPassword.setFont(sgUI13b);
        lbKhoa.setFont(sgUI13b);


        txtSdt.setPreferredSize(new Dimension(200, 30));
        txtSdt.setFont(sgUI13b);
        txtSdt.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 0, 0, 0)));

        txtEmail.setPreferredSize(new Dimension(200, 30));
        txtEmail.setFont(sgUI13b);
        txtEmail.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 0, 0, 0)));

        txtPassword.setPreferredSize(new Dimension(200, 30));
        txtPassword.setFont(sgUI13b);
        txtPassword.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 0, 0, 0)));

        txtKhoa.setPreferredSize(new Dimension(200, 30));
        txtKhoa.setFont(sgUI13b);
        txtKhoa.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 0, 0, 0)));

        txtNganh.setPreferredSize(new Dimension(200, 30));
        txtNganh.setFont(sgUI13b);
        txtNganh.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 0, 0, 0)));

        btnDong.setFont(sgUI13b);
        btnDong.setFocusPainted(false);
        btnDong.setBorderPainted(false);
        btnDong.setPreferredSize(new Dimension(200, 25));
        btnDong.setBackground(Color.decode("#7ed6df"));
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        txtHoTen.setPreferredSize(new Dimension(200, 30));
        txtHoTen.setFont(sgUI13p);
        txtHoTen.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 0, 0, 0)));
        txtHoTen.setForeground(Color.black);
        txtHoTen.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 0, 0, 0)));
        txtHoTen.setBackground(Color.white);

        txtMaTV.setPreferredSize(new Dimension(200, 30));
        txtMaTV.setFont(sgUI13p);
        txtMaTV.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 0, 0, 0)));
        txtMaTV.setForeground(Color.black);
        txtMaTV.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 0, 0, 0)));
        txtMaTV.setBackground(Color.white);

        txtSdt.setPreferredSize(new Dimension(200, 30));
        txtSdt.setFont(sgUI13p);
        txtSdt.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 0, 0, 0)));
        txtSdt.setForeground(Color.black);
        txtSdt.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 0, 0, 0)));
        txtSdt.setBackground(Color.white);

        txtEmail.setPreferredSize(new Dimension(200, 30));
        txtEmail.setFont(sgUI13p);
        txtEmail.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 0, 0, 0)));
        txtEmail.setForeground(Color.black);
        txtEmail.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 0, 0, 0)));
        txtEmail.setBackground(Color.white);

        txtPassword.setPreferredSize(new Dimension(200, 30));
        txtPassword.setFont(sgUI13p);
        txtPassword.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 0, 0, 0)));
        txtPassword.setForeground(Color.black);
        txtPassword.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 0, 0, 0)));
        txtPassword.setBackground(Color.white);

        txtKhoa.setPreferredSize(new Dimension(200, 30));
        txtKhoa.setFont(sgUI13p);
        txtKhoa.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 0, 0, 0)));
        txtKhoa.setForeground(Color.black);
        txtKhoa.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 0, 0, 0)));
        txtKhoa.setBackground(Color.white);

        txtNganh.setPreferredSize(new Dimension(200, 30));
        txtNganh.setFont(sgUI13p);
        txtNganh.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 0, 0, 0)));
        txtNganh.setForeground(Color.black);
        txtNganh.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 0, 0, 0)));
        txtNganh.setBackground(Color.white);

        txtThanhVien.setPreferredSize(new Dimension(200, 30));
        txtThanhVien.setFont(sgUI13p);
        txtThanhVien.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 0, 0, 0)));
        txtThanhVien.setForeground(Color.black);
        txtThanhVien.setVisible(false);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new JPanel();
        header.setBackground(Color.white);
        title = new JLabel();
        content = new JPanel();
        content.setBackground(Color.white);
        lbHoTen = new JLabel();
        lbMaTV = new JLabel();
        lbSdt = new JLabel();
        lbPassword = new JLabel();
        lbKhoa = new JLabel();
        lbNganh = new JLabel();
        lbThietBiDaMuon = new JLabel();
        lbEmail = new JLabel();
        lbViPham = new JLabel();
        viPhamValue = new JLabel();
        thietBiDaMuonValue = new JLabel();
        txtHoTen = new JTextField();
        txtMaTV = new JTextField();
        txtSdt = new JTextField();
        txtEmail = new JTextField();
        txtPassword = new JTextField();
        txtKhoa = new JTextField();
        txtNganh = new JTextField();
        btnDong = new JButton();
        txtThanhVien = new JTextField();

        viPhamValue.setForeground(Color.RED);

        header.setBackground(mainColor);
        header.setPreferredSize(new Dimension(400, 50));
        header.setLayout(new BorderLayout());

        title.setFont(new Font("Segoe UI", 1, 13)); // NOI18N

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("title");
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        header.add(title, BorderLayout.CENTER);

        getContentPane().add(header, BorderLayout.PAGE_START);

        lbMaTV.setText("Mã thành viên: ");

        lbHoTen.setText("Họ và Tên: ");

        lbSdt.setText("Số điện thoại: ");
        lbEmail.setText("Email: ");
        lbPassword.setText("Password: ");
        lbViPham.setText("Vi phạm: ");
        lbThietBiDaMuon.setText("Thiết bị đã mượn: ");
        lbNganh.setText("Khoa: ");
        lbKhoa.setText("Ngành: ");

        btnDong.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDong.setLabel("Đóng");

        GroupLayout contentLayout = new GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbMaTV, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbHoTen, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbSdt, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbKhoa, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNganh, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbThietBiDaMuon, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbViPham, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbEmail, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbPassword, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    ))
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSdt, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txtMaTV, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txtHoTen, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                .addComponent(txtKhoa, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                .addComponent(txtNganh, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                .addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                .addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                .addComponent(thietBiDaMuonValue, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                .addComponent(viPhamValue, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        ))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnDong, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                     .addComponent(txtMaTV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                     .addComponent(lbMaTV))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHoTen))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSdt)
                    .addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                    .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lbKhoa)
                            .addComponent(txtKhoa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNganh)
                            .addComponent(txtNganh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEmail)
                            .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPassword)
                            .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lbThietBiDaMuon)
                            .addComponent(thietBiDaMuonValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lbViPham)
                            .addComponent(viPhamValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDong))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        getContentPane().add(content, BorderLayout.CENTER);


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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormXemChiTiet.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FormXemChiTiet.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FormXemChiTiet.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FormXemChiTiet.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnDong;
    private JPanel content;
    private JPanel header;
    private JLabel lbMaTV;
    private JLabel lbHoTen;
    private JLabel lbSdt;
    private JLabel lbKhoa;
    private JLabel lbNganh;
    private JLabel lbThietBiDaMuon;
    private JLabel thietBiDaMuonValue;
    private JLabel lbViPham;
    private JLabel viPhamValue;
    private JLabel lbEmail;
    private JLabel lbPassword;
    private JLabel title;
    private JTextField txtMaTV;
    private JTextField txtHoTen;
    private JTextField txtSdt;
    private JTextField txtKhoa;
    private JTextField txtNganh;
    private JTextField txtEmail;
    private JTextField txtPassword;
    private JTextField txtThanhVien;
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
