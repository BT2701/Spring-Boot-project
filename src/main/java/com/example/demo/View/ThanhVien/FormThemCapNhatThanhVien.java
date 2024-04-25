/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.example.demo.View.ThanhVien;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import com.example.demo.Controller.ThanhVienCTL;
import com.example.demo.Model.ThanhVienModel;
import com.example.demo.View.Styles.Styles;



/**
 *
 * @author phamv
 */
public class FormThemCapNhatThanhVien extends JDialog {
	private Color mainColor = Color.decode("#dff9fb");
	private Color tableColor= new java.awt.Color(126, 214, 223);
	Styles style = new Styles();
    ThanhVienCTL tvCtl = new ThanhVienCTL();
    ThanhVienModel oldThanhVien = null;
    private String[] nganhList = {"", "Giáo dục tiểu học", "Quản trị kinh doanh", "Quản lý giáo ", "Khoa học máy tính", "Khoa học dữ liệu", "Khoa học môi trường", "Khoa học xã hội"};
    private String[] khoaList = {"", "GDTH", "TLH", "QTKD", "CNTT", "VL", "MT", "XH"};

    String titleForm;
    String randomMaTv = "0";
    /**
     * Creates new form FormThemThanhVien
     */
    public FormThemCapNhatThanhVien(String titleForm) {
        this.titleForm = titleForm;
    	setSize(450, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		setTitle("Xử lý");
		setIconImage(new ImageIcon(getClass().getResource("/com/example/demo/View/images/material.png")).getImage());
//        super(parent, modal);
        initComponents();
        initMyComponents(titleForm);
        changeComponentForDiffForm(titleForm);
        content.setBackground(Color.white);
        header.setBackground(Color.white);
        setVisible(true);
       
    }

    public FormThemCapNhatThanhVien(String titleForm, int idOfoldThanhVien) {
//        this.oldThanhVien = tvCtl.getModel(idOfoldThanhVien);
        this.titleForm = titleForm;
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setTitle("Xử lý");
        setIconImage(new ImageIcon(getClass().getResource("/com/example/demo/View/images/material.png")).getImage());
        initComponents();
        initMyComponents(titleForm);
        changeComponentForDiffForm(titleForm);
        setVisible(true);
    }

    private void changeComponentForDiffForm(String titleForm){
        txtMaTV.setEditable(false);
        cbNienKhoa.setVisible(false);

        if(titleForm.equals("Thêm Thành Viên")) {
            setRandomMaTV();
        }
        if(titleForm.equals("Cập Nhật Thông Tin Thành Viên")) {
            txtMaTV.setText(Integer.toString(oldThanhVien.getMaTV()));

            txtSdt.setText(oldThanhVien.getSdt());
            txtHoTen.setText(oldThanhVien.getHoTen());
            cbKhoa.addItem(oldThanhVien.getKhoa());
            cbKhoa.setSelectedItem(oldThanhVien.getKhoa());
            cbNganh.addItem(oldThanhVien.getNganh());
            cbNganh.setSelectedItem(oldThanhVien.getNganh());
        }
        if(titleForm.equals("Xóa Nhiều Thành Viên")) {
            txtMaTV.setVisible(false);
            cbNienKhoa.setVisible(true);
            lbMaTV.setText("Khóa thứ");
        }
    }

    private void generateLast2DigitsOfYearFrom2010ToNow() {
        int startYear = 2010;
        int currentYear = LocalDate.now().getYear();

        ArrayList<String> lastTwoDigitsList = new ArrayList<String>();
        lastTwoDigitsList.add("");
        for (int year = startYear; year <= currentYear; year++) {
            String lastTwoDigits = String.valueOf(year).substring(2);
            lastTwoDigitsList.add(lastTwoDigits);
        }

        // Chuyển đổi danh sách thành mảng
        String[] lastTwoDigitsArray = lastTwoDigitsList.toArray(new String[0]);
        cbNienKhoa.setModel(new DefaultComboBoxModel<>(lastTwoDigitsArray));
    }

    private void setRandomMaTV() {
        // 2 số đầu tiên
        String soDau = "11";
        // 2 số tiếp theo là khóa

        // Lấy 2 số cuối cùng của năm
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String yearStr = String.valueOf(year);
        String khoaStr = yearStr.substring(2,4);

        // Lấy 6 số số cuối
//        ArrayList<ThanhVienModel> thanhVienModelList = tvCtl.getListForUpdateMethod();
//        ThanhVienModel lastThanhVienModel = thanhVienModelList.get(thanhVienModelList.size() - 1);
//        String soCuoi = String.valueOf(lastThanhVienModel.getMaTV()).substring(4, 10);
//        int soCuoiInt = (Integer.parseInt(soCuoi) + 1);

//        randomMaTv = soDau + khoaStr + soCuoiInt;
//        txtMaTV.setText(randomMaTv);
    }
    
    private void initMyComponents(String titleForm){
        title.setText(titleForm);
        title.setFont(sgUI15b);
        lbHoTen.setFont(sgUI13b); // NOI18N
        lbMaTV.setFont(sgUI13b); // NOI18N
        lbKhoa.setFont(sgUI13b); // NOI18N 
        lbNganh.setFont(sgUI13b); // NOI18N
        lbSdt.setFont(sgUI13b); // NOI18N
        lbThanhVien.setFont(sgUI13b); // NOI18N
        lbThanhVien.setVisible(false);
        txtSdt.setPreferredSize(new Dimension(200, 30));
        txtSdt.setFont(sgUI13p);
        txtSdt.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 3, 0, 3)));
        // txtSdt.setBorder(BorderFactory.createCompoundBorder(borderTxt, new
        // EmptyBorder(0, 3, 0, 3)));
       
        btnXacNhan.setFont(sgUI13b);
        btnXacNhan.setFocusPainted(false);
        btnXacNhan.setBorderPainted(false);
        btnXacNhan.setPreferredSize(new Dimension(100, 23));
        btnXacNhan.setBackground(Color.decode("#7ed6df"));

        // Xử lý sự kiện khi nhấn nút Xác Nhận
//        btnXacNhan.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Trích xuất dữ liệu từ các trường và combobox
//                String hoTen = txtHoTen.getText();
//                String sdt = txtSdt.getText();
//                String khoa = (String) cbKhoa.getSelectedItem();
//                String nganh = (String) cbNganh.getSelectedItem();
//                String maTVStr = txtMaTV.getText();
//
//                if(!titleForm.equals("Xóa Nhiều Thành Viên")) {
//                    if((khoa == null || khoa.isEmpty()) || (nganh == null || nganh.isEmpty()) || hoTen.isEmpty() || sdt.isEmpty()) {
//                        JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Vui lòng nhập đầy đủ các trường!");
//                        return;
//                    }
//                }

//                if (titleForm.equals("Thêm Thành Viên")) {
//                    // Thêm dữ liệu vào cơ sở dữ liệu
//                    tvCtl.addModel(new ThanhVienModel(Integer.parseInt(randomMaTv), hoTen, khoa, nganh, sdt, "", ""));
//
//                    // Xóa dữ liệu sau khi thêm thành công
//                    txtMaTV.setText("");
//                    txtHoTen.setText("");
//                    txtSdt.setText("");
//                    cbKhoa.setSelectedIndex(0);
//                    cbNganh.setSelectedIndex(0);
//
//                    // Hiển thị thông báo thành công (có thể thêm)
//                    JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Thêm thành viên thành công!");
//                    setVisible(false);
//                } else if (titleForm.equals("Cập Nhật Thông Tin Thành Viên")) {
//                    oldThanhVien = tvCtl.getModel(Integer.parseInt(maTVStr));
//                    ThanhVienModel thanhvien = tvCtl.getModel(Integer.parseInt(maTVStr));
//                    if (thanhvien == null) {
//                        JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Thành viên chưa tồn tại!");
//                        return;
//                    }
//
//                    ThanhVienModel updatedThanhvien = new ThanhVienModel(Integer.parseInt(maTVStr), hoTen, khoa, nganh, sdt, "", "");
//                    tvCtl.updateModel(updatedThanhvien);
//
//                    txtMaTV.setText("");
//                    txtHoTen.setText("");
//                    txtSdt.setText("");
//                    cbKhoa.setSelectedIndex(0);
//                    cbNganh.setSelectedIndex(0);
//
//                    JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Cập Nhật thành viên thành công!");
//                    setVisible(false);
//                } else if (titleForm.equals("Xóa Nhiều Thành Viên")) {
//                    String nienKhoa = (String) cbNienKhoa.getSelectedItem();
//                    if((nienKhoa !=null && nienKhoa.isEmpty()) && hoTen.isEmpty() && (khoa != null && khoa.isEmpty()) && (nganh != null && nganh.isEmpty()) && sdt.isEmpty()) {
//                        JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Nhập 1 trong những điều kiện để xóa !");
//                        return;
//                    }
//
//                    String queryToDelete = "";
//                    if(!nienKhoa.isEmpty()) {
//                        String query = "substring(cast(MaTV as string), 3, 2) = '" + nienKhoa + "'";
//                        queryToDelete += !queryToDelete.isEmpty() ? " and " + query : query;
//                    }
//                    if(!hoTen.isEmpty()) {
//                        String query = "HoTen = '" + hoTen + "'";
//                        queryToDelete += !queryToDelete.isEmpty() ? " and " + query : query;
//                    }
//                    if (khoa != null && !khoa.isEmpty()) {
//                        String query = "Khoa = '" + khoa + "'";
//                        queryToDelete += !queryToDelete.isEmpty() ? " and " + query : query;
//                    }
//                    if(nganh != null && !nganh.isEmpty()) {
//                        String query = "Nganh = '" + nganh + "'";
//                        queryToDelete += !queryToDelete.isEmpty() ? " and " + query : query;
//                    }
//                    if(!sdt.isEmpty()) {
//                        String query = "Sdt = '" + sdt + "'";
//                        queryToDelete += !queryToDelete.isEmpty() ? " and " + query : query;
//                    }
//
//                    tvCtl.deleteMultipleModelByCondition(queryToDelete);
//
//                    txtMaTV.setText("");
//                    txtHoTen.setText("");
//                    txtSdt.setText("");
//                    cbKhoa.setSelectedIndex(0);
//                    cbNganh.setSelectedIndex(0);
//
//                    JOptionPane.showMessageDialog(FormThemCapNhatThanhVien.this, "Xóa nhiều thành viên thành công!");
//                    setVisible(false);
//                }
//            }
//        });
        
        btnHuy.setFont(sgUI13b);
        btnHuy.setFocusPainted(false);
        btnHuy.setBorderPainted(false);
        btnHuy.setPreferredSize(new Dimension(150, 23));
        btnHuy.setBackground(Color.decode("#7ed6df"));
        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        
        btnLamMoi.setFont(sgUI13b);
        btnLamMoi.setFocusPainted(false);
        btnLamMoi.setBorderPainted(false);
        btnLamMoi.setPreferredSize(new Dimension(100, 23));
        btnLamMoi.setBackground(Color.decode("#7ed6df"));
        
        txtHoTen.setPreferredSize(new Dimension(200, 30));
        txtHoTen.setFont(sgUI13p);
        txtHoTen.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtHoTen.setForeground(Color.black);
        txtHoTen.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 3, 0, 3)));

        txtMaTV.setPreferredSize(new Dimension(200, 30));
        txtMaTV.setFont(sgUI13p);
        txtMaTV.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtMaTV.setForeground(Color.black);
        txtMaTV.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 3, 0, 3)));
        
        txtSdt.setPreferredSize(new Dimension(200, 30));
        txtSdt.setFont(sgUI13p);
        txtSdt.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtSdt.setForeground(Color.black);
        txtSdt.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 3, 0, 3)));
        
        txtThanhVien.setPreferredSize(new Dimension(200, 30));
        txtThanhVien.setFont(sgUI13p);
        txtThanhVien.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtThanhVien.setForeground(Color.black);
        txtThanhVien.setVisible(false);

        cbNienKhoa.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbNienKhoa.setBackground(Color.white);
        cbNienKhoa.setFont(sgUI13b);
        cbNienKhoa.setPreferredSize(new Dimension(100, 30));
        cbNienKhoa.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });

        cbKhoa.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbKhoa.setBackground(Color.white);
        cbKhoa.setFont(sgUI13b);
        cbKhoa.setPreferredSize(new Dimension(100, 30));
        cbKhoa.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });

        cbNganh.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbNganh.setBackground(Color.white);
        cbNganh.setFont(sgUI13b);
        cbNganh.setPreferredSize(new Dimension(100, 30));
        cbNganh.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });

        cbKhoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(titleForm.equals("Thêm Thành Viên")) {
                    setRandomMaTV();
                }
            }
        });
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
        lbKhoa = new JLabel();
        lbNganh = new JLabel();
        lbSdt = new JLabel();
        btnXacNhan = new JButton();
        btnLamMoi = new JButton();
        txtHoTen = new JTextField();
        txtMaTV = new JTextField();
        txtSdt = new JTextField();
        cbKhoa = new JComboBox<>();
        cbNienKhoa = new JComboBox<>();
        cbNganh = new JComboBox<>();
        btnHuy = new JButton();
        lbThanhVien = new JLabel();
        txtThanhVien = new JTextField();

        

        header.setBackground(mainColor);
        header.setPreferredSize(new Dimension(400, 50));
        header.setLayout(new BorderLayout());

        title.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("title");
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        header.add(title, BorderLayout.CENTER);

        getContentPane().add(header, BorderLayout.PAGE_START);

        lbMaTV.setText("Mã thành viên");

        lbHoTen.setText("Họ và Tên");

        lbKhoa.setText("Khoa");

        lbNganh.setText("Ngành");

        lbSdt.setText("Số điện thoại");

        btnXacNhan.setIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/xacnhan_icon.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnLamMoi.setIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/Refresh_icon.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));

        cbKhoa.setModel(new DefaultComboBoxModel<>(khoaList));

        cbNganh.setModel(new DefaultComboBoxModel<>(nganhList));

        generateLast2DigitsOfYearFrom2010ToNow();

//        btnHuy.setIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/comeback_icon.png"))); // NOI18N
        btnHuy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnHuy.setLabel("Hủy");

        lbThanhVien.setText("Thành Viên");

        GroupLayout contentLayout = new GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbKhoa)
                    .addComponent(lbNganh)
                    .addComponent(btnXacNhan)
                    .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbMaTV, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbHoTen, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbSdt, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbThanhVien))
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSdt, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(cbNganh, 0, 189, Short.MAX_VALUE)
                            .addComponent(cbKhoa, 0, 189, Short.MAX_VALUE)
                            .addComponent(cbNienKhoa, 0, 189, Short.MAX_VALUE)
                            .addComponent(txtMaTV, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txtHoTen, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txtThanhVien)))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnLamMoi)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtThanhVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbThanhVien))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                     .addComponent(cbNienKhoa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                     .addComponent(txtMaTV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                     .addComponent(lbMaTV))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHoTen))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKhoa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbKhoa))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNganh)
                    .addComponent(cbNganh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSdt)
                    .addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan)
                    .addComponent(btnHuy)
                    .addComponent(btnLamMoi))
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
            Logger.getLogger(FormThemCapNhatThanhVien.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FormThemCapNhatThanhVien.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FormThemCapNhatThanhVien.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FormThemCapNhatThanhVien.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnHuy;
    private JButton btnLamMoi;
    private JButton btnXacNhan;
    private JComboBox<String> cbKhoa;
    private JComboBox<String> cbNganh;
    private JComboBox<String> cbNienKhoa;
    private JPanel content;
    private JPanel header;
    private JLabel lbMaTV;
    private JLabel lbHoTen;
    private JLabel lbKhoa;
    private JLabel lbNganh;
    private JLabel lbSdt;
    private JLabel lbThanhVien;
    private JLabel title;
    private JTextField txtMaTV;
    private JTextField txtHoTen;
    private JTextField txtSdt;
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
