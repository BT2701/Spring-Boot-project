package com.example.demo.View.Login;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.example.demo.Controller.ThanhVienCTL;
import com.example.demo.View.HomePage.HomePage;

public class LoginView extends javax.swing.JDialog {

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
    MatteBorder borderTxt = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    private LineBorder lineCB = new LineBorder(Color.white);
    private JCheckBox showPasswordCheckbox;

    public LoginView() {
        setSize(850, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setTitle("Đăng nhập");
//		setIconImage(new ImageIcon(getClass().getResource("/com/example/demo/View/images/material.png")).getImage());
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();

        jLabel3 = new javax.swing.JLabel();
        btnLogin = new JButton("Login");

        // Tạo panel cha để chứa jPanel13 và jPanel14
        JPanel parentPanel = new JPanel(new GridLayout(1, 2)); // Sử dụng GridLayout để chia đều không gian cho hai panel

        setBackground(Color.decode("#7ed6df"));
        setLayout(new BorderLayout());

        jPanel3.setBackground(Color.decode("#7ed6df"));
        jPanel3.setPreferredSize(new Dimension(200, 100));
        jPanel3.setLayout(new GridBagLayout());

        JLabel companyNameLabel = new JLabel("COMPANY NAME");
        companyNameLabel.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 30));
        companyNameLabel.setForeground(Color.WHITE);
        companyNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets((int) (jPanel3.getPreferredSize().getHeight() * 0.3), 0, 0, 0);
        jPanel3.add(companyNameLabel, gbc);

        parentPanel.add(jPanel3); // Thêm jPanel3 vào panel cha

        jPanel4.setLayout(new BoxLayout(jPanel4, BoxLayout.Y_AXIS));
        jPanel4.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel4.add(Box.createVerticalStrut(50)); // Khoảng cách dọc

        jLabel1.setFont(new Font("Arial", Font.BOLD, 36));
        jLabel1.setForeground(Color.decode("#7ed6df"));
        jLabel1.setText("LOGIN");
        jLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        jLabel1.setName("loginLabel");
        jPanel4.add(jLabel1);
        jPanel4.add(Box.createVerticalStrut(10)); // Khoảng cách dọc

        jLabel5.setFont(new Font("Arial", Font.ITALIC, 15));
        jLabel5.setForeground(Color.decode("#7ed6df"));
        jLabel5.setText("Hello, Welcome to the system");
        jLabel5.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel4.add(jLabel5);
        jPanel4.add(Box.createVerticalStrut(20));

        jLabel2.setFont(new Font("Arial", Font.PLAIN, 15));
        jLabel2.setText("USERNAME/EMAIL");
        jLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        jLabel2.setName("usernameLabel");
        jPanel4.add(jLabel2);
        jPanel4.add(Box.createVerticalStrut(5));
        jPanel4.add(Box.createVerticalStrut(5)); // Khoảng cách dọc

        txtUserName.setMaximumSize(new Dimension(300, 30));
        txtUserName.setFont(sgUI13b);
        txtUserName.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtUserName.setForeground(Color.black);

        jPanel4.add(txtUserName);
        jPanel4.add(Box.createVerticalStrut(10));

        jLabel3.setFont(new Font("Arial", Font.PLAIN, 15));
        jLabel3.setText("PASSWORD");
        jLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        jLabel3.setName("passwordLabel");
        jPanel4.add(jLabel3);
        jPanel4.add(Box.createVerticalStrut(5));
        jPanel4.add(Box.createVerticalStrut(5)); // Khoảng cách dọc

        txtPassword.setMaximumSize(new Dimension(300, 30));
        txtPassword.setName("txtPassword");
        txtPassword.setFont(sgUI13b);
        txtPassword.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtPassword.setForeground(Color.black);
        jPanel4.add(txtPassword);

        //khi an enter o username//pass thi goi toi login
        txtPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        txtUserName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        // Tạo JCheckBox để ẩn/hiện mật khẩu
        showPasswordCheckbox = new JCheckBox("Show password");
        showPasswordCheckbox.setFont(new Font("Arial", Font.PLAIN, 10));
        showPasswordCheckbox.setAlignmentX(Component.LEFT_ALIGNMENT);
        showPasswordCheckbox.setCursor(new Cursor(Cursor.HAND_CURSOR));

        showPasswordCheckbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckbox.isSelected()) {
                    txtPassword.setEchoChar((char) 0); // Hiện mật khẩu
                } else {
                    txtPassword.setEchoChar('\u2022'); // Ẩn mật khẩu
                }
            }
        });

        jPanel4.add(showPasswordCheckbox);

        jPanel4.add(Box.createVerticalStrut(20));

        btnLogin.setText("LOGIN"); // Đặt văn bản cho nút JButton là "Login"
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        btnLogin.setFocusPainted(false);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.setMaximumSize(new Dimension(300, 30));
        btnLogin.setName("btnLogin");

        btnLogin.setFont(sgUI13b);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setBackground(Color.decode("#7ed6df"));

        jPanel4.add(btnLogin);

        // Tạo panel114 và thiết lập BorderLayout cho nó
        JPanel panel114 = new JPanel(new BorderLayout());

        // Thêm panel14 vào phần trung tâm của panel114
        panel114.add(jPanel4, BorderLayout.CENTER);

        // Thêm panel114 vào parentPanel
        parentPanel.add(panel114);

        add(parentPanel, BorderLayout.CENTER); // Thêm panel cha vào BorderLayout.CENTER của panel login11

        // Thiết lập xử lý sự kiện cho nút Login
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    private void login() {
        String username = txtUserName.getText().trim();
        String password = new String(txtPassword.getPassword());

        Integer user;
//        ThanhVienCTL ctl = new ThanhVienCTL();
//
//        user = ctl.login(username, password);
//        if (user != null) {
//            JOptionPane.showMessageDialog(LoginView.this, "Đăng nhập thành công!"+user);
//            dispose();
//            new HomePage(ctl.getModel(user).getHoTen());
//        } else {
//            JOptionPane.showMessageDialog(LoginView.this, "Đăng nhập thất bại! Vui lòng kiểm tra lại thông tin đăng nhập.", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
//        }
    }

    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JPasswordField txtPassword;

}
