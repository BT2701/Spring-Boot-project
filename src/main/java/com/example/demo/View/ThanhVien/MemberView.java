package com.example.demo.View.ThanhVien;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.example.demo.Controller.ThanhVienCTL;
import com.example.demo.Controller.ThongTinSdCTL;
import com.example.demo.Controller.XuLyCTL;
import com.example.demo.Model.ThanhVienModel;
import com.example.demo.Model.ThongTinSdModel;
import com.example.demo.Model.XuLyModel;
import com.example.demo.View.Styles.Styles;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author phamv
 */
public class MemberView extends javax.swing.JPanel {

	private Color mainColor = Color.decode("#dff9fb");
	private Color tableColor= new java.awt.Color(126, 214, 223);
	Styles style = new Styles();
    ThanhVienCTL tvCtl = new ThanhVienCTL();
    DefaultTableModel model;
    /**
     * Creates new form MemberView
     */
    public MemberView() {
    	this.setLayout(new BorderLayout());
        initComponents();
        initMyComponents();
    }
    
    
    //VÌ DÙNG TOOL ĐỂ TẠO GIAO DIỆN NÊN CÓ VÀI CHỖ CẦN PHẢI CUSTOM LẠI, 
    //ĐÓ LÀ LÍ DO CÓ FUNCTION NÀY
    private void initMyComponents(){
        JLHeader.setFont(fontTittle); 
        
        txtTimKiem.setFont(sgUI13p);
        txtTimKiem.setForeground(texfieldColor);
        txtTimKiem.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        
        
        btnTimKiem.setFont(sgUI13b); // NOI18N
        btnTimKiem.setForeground(Color.black);
        btnTimKiem.setFocusPainted(false);
        btnTimKiem.setBorderPainted(false);
        btnTimKiem.setBackground(Color.decode("#7ed6df"));

        btnXemChiTiet.setFont(sgUI13b); // NOI18N
        btnXemChiTiet.setForeground(Color.black);
        btnXemChiTiet.setFocusPainted(false);
        btnXemChiTiet.setBorderPainted(false);
        btnXemChiTiet.setBackground(Color.decode("#7ed6df"));
        
        JTableHeader header = jTable2.getTableHeader();
        header.setPreferredSize(new java.awt.Dimension(header.getWidth(), 30)); // Customize the header height here
        header.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 13)); // Customize the font here
        header.setBackground(tableColor);
    
        
        btnThem.setFont(sgUI13b);
        btnThem.setFocusPainted(false);
        btnThem.setBorderPainted(false);
        btnThem.setBackground(Color.decode("#7ed6df"));
        
        
        btnKhuVucHocTap.setFont(sgUI13b);
        btnKhuVucHocTap.setFocusPainted(false);
        btnKhuVucHocTap.setBorderPainted(false); 
        btnKhuVucHocTap.setBackground(Color.decode("#7ed6df"));
        
        
        btnCanhBaoViPham.setFont(sgUI13b);
        btnCanhBaoViPham.setFocusPainted(false);
        btnCanhBaoViPham.setBorderPainted(false);
        btnCanhBaoViPham.setBackground(Color.decode("#7ed6df"));
        
        btnXoa.setFont(sgUI13b);
        btnXoa.setFocusPainted(false);
        btnXoa.setBorderPainted(false); 
        btnXoa.setBackground(Color.decode("#7ed6df"));
        
        
        btnCapNhat.setFont(sgUI13b);
        btnCapNhat.setFocusPainted(false);
        btnCapNhat.setBorderPainted(false);
        btnCapNhat.setBackground(Color.decode("#7ed6df"));
       
        
        btnMuonTraThietBi.setFont(sgUI13b);
        btnMuonTraThietBi.setFocusPainted(false);
        btnMuonTraThietBi.setBorderPainted(false);
        btnMuonTraThietBi.setBackground(Color.decode("#7ed6df"));

        loadData(null);
    }

    // Hàm để nạp dữ liệu từ ArrayList<ThanhVienModel> vào jTable2
    private void loadData(ArrayList<ThanhVienModel> tvLstAfterUpdated) {
//         Lấy danh sách thành viên từ ThanhVienController
//        ArrayList<ThanhVienModel> tvLst = tvCtl.getList();
//        if(tvLstAfterUpdated != null) {
//            tvLst = tvLstAfterUpdated;
//        }
        // Lấy DefaultTableModel từ jTable2
        model = (DefaultTableModel) jTable2.getModel();

        // Xóa tất cả các dòng hiện tại trong jTable2
        model.setRowCount(0);

        // Duyệt qua từng thành viên và thêm vào jTable2
//        for (ThanhVienModel tv : tvLst) {
//            Object[] row = {tv.getMaTV(), tv.getHoTen(), tv.getKhoa(), tv.getNganh(), tv.getSdt()};
//            model.addRow(row);
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPHeader = new javax.swing.JPanel();
        JLHeader = new javax.swing.JLabel();
        JPMainContent = new javax.swing.JPanel();
        JPContainSearchOperation = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnXemChiTiet = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        JPContainOperation = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnKhuVucHocTap = new javax.swing.JButton();
        btnCanhBaoViPham = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnMuonTraThietBi = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(225, 500));
        setName("JFQLTV"); // NOI18N

        JPHeader.setBackground(mainColor);
        JPHeader.setPreferredSize(new java.awt.Dimension(300, 80));
        JPHeader.setLayout(new java.awt.BorderLayout());

        JLHeader.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        
        JLHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLHeader.setText("Quản Lý Thành Viên");
        JLHeader.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JLHeader.setPreferredSize(new java.awt.Dimension(341, 50));
        JPHeader.add(JLHeader, java.awt.BorderLayout.CENTER);

        add(JPHeader, java.awt.BorderLayout.NORTH);

        JPMainContent.setLayout(new java.awt.BorderLayout());

        JPContainSearchOperation.setBackground(new java.awt.Color(255, 255, 255));
        JPContainSearchOperation.setAutoscrolls(true);
        JPContainSearchOperation.setPreferredSize(new java.awt.Dimension(752, 100));

        txtTimKiem.setText("Tìm kiếm theo họ tên...");
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });

        btnTimKiem.setBackground(mainColor);
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/demo/View/images/search_icon.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = txtTimKiem.getText().toLowerCase().trim();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                jTable2.setRowSorter(sorter);
                if (searchText.isEmpty() || searchText.equals("Tìm kiếm theo họ tên...".toLowerCase())) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, 1)); // Tìm kiếm theo cột "Họ và Tên"
                }
            }
        });

        btnXemChiTiet.setBackground(mainColor);
        btnXemChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnXemChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        btnXemChiTiet.setText("Xem chi tiết");
        btnXemChiTiet.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnXemChiTiet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//        btnXemChiTiet.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int selectedRow = jTable2.getSelectedRow();
//                if(selectedRow<0) {
//                	return;
//                }
//                int maTV = (int) jTable2.getValueAt(selectedRow, 0);
//                String hoTen = (String) jTable2.getValueAt(selectedRow, 1);
//                String khoa = (String) jTable2.getValueAt(selectedRow, 2);
//                String nganh = (String) jTable2.getValueAt(selectedRow, 3);
//                String sdt = (String) jTable2.getValueAt(selectedRow, 4);
//
//                ThongTinSdCTL thongTinSdCTL = new ThongTinSdCTL();
//                ArrayList<ThongTinSdModel> listTB = (ArrayList<ThongTinSdModel>) thongTinSdCTL.getList().stream()
//                        .filter(ttsd -> ttsd.getThanhVien().getMaTV() == maTV && ttsd.getTgMuon() != null && ttsd.getTgTra() == null)
//                        .collect(Collectors.toList());
//                String thietBiDaMuon = !listTB.isEmpty()
//                        ? listTB.stream().map(t -> t.getThietBi().getTenTB()).collect(Collectors.joining(", "))
//                        : "Không có";

                XuLyCTL xlCtl = new XuLyCTL();
//                ArrayList<XuLyModel> listXL = (ArrayList<XuLyModel>) xlCtl.getList().stream()
//                        .filter(xl -> xl.getThanhVien().getMaTV() == maTV && xl.getTrangThaiXL() == 1)
//                        .collect(Collectors.toList());
//                String xuLyDaCo = !listXL.isEmpty()
//                        ? listXL.stream().map(XuLyModel::getHinhThucXL).collect(Collectors.joining(", "))
//                        : "Không có";
//
//                ThanhVienCTL tvCtl = new ThanhVienCTL();
//                ThanhVienModel tv = tvCtl.getModel(maTV);
//                String email = !tv.getEmail().isEmpty() ? tv.getEmail() : "Chưa tạo";
//                String password = !tv.getPassword().isEmpty() ? tv.getPassword() : "Chưa tạo";
//
//                new FormXemChiTiet("Xem chi tiết thành viên", Integer.toString(maTV), hoTen, sdt, khoa, nganh, email, password, thietBiDaMuon, xuLyDaCo);
//            }
//        });

        javax.swing.GroupLayout JPContainSearchOperationLayout = new javax.swing.GroupLayout(JPContainSearchOperation);
        JPContainSearchOperation.setLayout(JPContainSearchOperationLayout);
        JPContainSearchOperationLayout.setHorizontalGroup(
            JPContainSearchOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPContainSearchOperationLayout.createSequentialGroup()
                .addContainerGap(416, Short.MAX_VALUE)
                .addComponent(btnXemChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        JPContainSearchOperationLayout.setVerticalGroup(
            JPContainSearchOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPContainSearchOperationLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(JPContainSearchOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXemChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        JPMainContent.add(JPContainSearchOperation, java.awt.BorderLayout.PAGE_START);

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Mã TV", "Họ và Tên", "Khoa", "Ngành", "Số điện thoại"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setRowHeight(30);
        jScrollPane2.setViewportView(jTable2);

        JPMainContent.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(JPMainContent, java.awt.BorderLayout.CENTER);

        JPContainOperation.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/demo/View/images/add_icon.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnKhuVucHocTap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/demo/View/images/khuvuchoctap_icon.png"))); // NOI18N
        btnKhuVucHocTap.setText("Khu Vực Học Tập");
        btnKhuVucHocTap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhuVucHocTap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuVucHocTapActionPerformed(evt);
            }
        });

        btnCanhBaoViPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/demo/View/images/canhbao_icon.jpg"))); // NOI18N
        btnCanhBaoViPham.setText("Cảnh Báo Vi Phạm");
        btnCanhBaoViPham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCanhBaoViPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanhBaoViPhamActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/demo/View/images/delete_icon.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/demo/View/images/edit_icon.png"))); // NOI18N
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnCapNhatActionPerformed(evt);
            }
        });

        btnMuonTraThietBi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/demo/View/images/borow_icon.png"))); // NOI18N
        btnMuonTraThietBi.setText("Mượn Trả Thiết Bị");
        btnMuonTraThietBi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMuonTraThietBi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuonTraThietBiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPContainOperationLayout = new javax.swing.GroupLayout(JPContainOperation);
        JPContainOperation.setLayout(JPContainOperationLayout);
        JPContainOperationLayout.setHorizontalGroup(
            JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPContainOperationLayout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addGroup(JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKhuVucHocTap, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCanhBaoViPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMuonTraThietBi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        JPContainOperationLayout.setVerticalGroup(
            JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPContainOperationLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMuonTraThietBi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPContainOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnKhuVucHocTap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCanhBaoViPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnThem.getAccessibleContext().setAccessibleName("btnThem");

        add(JPContainOperation, java.awt.BorderLayout.SOUTH);

    }// </editor-fold>//GEN-END:initComponents


    // MỞ JDIALOG THÊM THÀNH VIÊN KHI CLICK VÀO NÚT "Thêm"
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
        String[] options = { "Thông qua form nhập ", "Thông qua file excel" };
        int userChoice = JOptionPane.showOptionDialog(null,
                "Chọn cách thêm thành viên",
                "Select Option",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (userChoice == 0) {
            // user chọn thêm thông qua form
            new FormThemCapNhatThanhVien("Thêm Thành Viên");
            loadData(null);
        } else {
            // user chọn thêm thông qua
            // Tạo một hộp thoại chọn tệp
            JFileChooser fileChooser = new JFileChooser();

            // Thiết lập bộ lọc để chỉ chọn các tệp có phần mở rộng là .xlsx
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files", "xlsx");
            fileChooser.setFileFilter(filter);

            // Hiển thị hộp thoại chọn tệp
            int result = fileChooser.showOpenDialog(null);

            // Kiểm tra xem người dùng đã chọn tệp hay chưa
            if (result == JFileChooser.APPROVE_OPTION) {
                // Lấy đường dẫn tệp đã chọn
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();

                // Gọi phương thức để thêm thành viên từ tệp Excel = filePath
//                JOptionPane.showMessageDialog(MemberView.this, addThanhVienFromExcel(filePath));
            } else if (result == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(MemberView.this, "Bạn đã hủy bỏ việc chọn tệp.");
            }

            loadData(null);
        }
    }

//    private static String addThanhVienFromExcel(String filepath) {
//        ThanhVienCTL thanhVienController = new ThanhVienCTL();
//        return thanhVienController.addModelFromFileExcel(filepath);
//    }

    // MỞ JDIALOG CẬP NHẬT THÔNG TIN THÀNH VIÊN KHI CLICK VÀO NÚT "Cập Nhật"
//    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {
//        int selectedRow = jTable2.getSelectedRow();
//        if (selectedRow != -1) { // Kiểm tra xem có dòng nào được chọn hay không
//            // Xóa dòng được chọn khỏi JTable
//            Integer maTV = (Integer) jTable2.getValueAt(selectedRow, 0);
//            // chuyển thành viên đc chọn qua form
//            new FormThemCapNhatThanhVien("Cập Nhật Thông Tin Thành Viên", maTV);
//            ArrayList<ThanhVienModel> tvLstAfterUpdate = tvCtl.getListForUpdateMethod();
//            loadData(tvLstAfterUpdate);
//        } else {
//            JOptionPane.showMessageDialog(MemberView.this, "Chọn dòng cần sửa !");
//        }
//    }

    // MỞ JDIALOG KHU VỰC HỌC TẬP KHI CLICK VÀO NÚT "Khu Vực Học Tập"
    private void btnKhuVucHocTapActionPerformed(java.awt.event.ActionEvent evt) {
        new FormKhuVucHocTap();
    }

    // MỞ JDIALOG MƯỢN TRẢ THIẾT BỊ KHI CLICK VÀO NÚT "Mượn Trả Thiết Bị"
    private void btnMuonTraThietBiActionPerformed(java.awt.event.ActionEvent evt) {
        new FormMuonTraThietBi();
    }

    // MỞ JDIALOG CẢNH BẢO VI PHẠM KHI CLICK VÀO NÚT "Mượn Trả Thiết Bị"
    private void btnCanhBaoViPhamActionPerformed(java.awt.event.ActionEvent evt) {
        new FormCanhBaoViPham();
    }

    // XÓA PLACEHODER CỦA TEXTFIELD TÌM KIẾM
    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {
        if (txtTimKiem.getText().equals("Tìm kiếm theo họ tên...")) {
            txtTimKiem.setText("");
        }
    }
    
    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {
        if (txtTimKiem.getText().isEmpty()) {
            txtTimKiem.setText("Tìm kiếm theo họ tên...");
        }
    }

//    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
//        String[] options = { "Xóa nhiều thành viên", "Xóa một thành viên" };
//        int userChoice = JOptionPane.showOptionDialog(null,
//                "Chọn cách xóa thành viên",
//                "Select Option",
//                JOptionPane.DEFAULT_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null,
//                options,
//                options[0]);
//        if (userChoice == 0) {
//            // user chọn thêm thông qua form
//            new FormThemCapNhatThanhVien("Xóa Nhiều Thành Viên");
//            loadData(null);
//        } else {
//            // user chọn thêm thông qua
//            int selectedRow = jTable2.getSelectedRow();
//            if (selectedRow != -1) { // Kiểm tra xem có dòng nào được chọn hay không
//                // Xóa dòng được chọn khỏi JTable
//                Integer maTV = (Integer) jTable2.getValueAt(selectedRow, 0);
//                ThanhVienCTL ctl = new ThanhVienCTL();
//                XuLyCTL xuLyCTL = new XuLyCTL();
//                ThongTinSdCTL thongTinSdCTL = new ThongTinSdCTL();
//
//                boolean check = false;
//                for(XuLyModel xl : xuLyCTL.getList()) {
//                    if(xl.getThanhVien().getMaTV().equals(maTV)) {
//                        check = true;
//                    }
//                }
//                for(ThongTinSdModel ttsd : thongTinSdCTL.getList()) {
//                    if(ttsd.getThanhVien().getMaTV().equals(maTV)) {
//                        check = true;
//                    }
//                }
//
//                if(check) {
//                    JOptionPane.showMessageDialog(MemberView.this, "Sinh viên này đang thực hiện 1 hành động!");
//                    return;
//                }
//
//                ctl.deleteModel(maTV);
//                JOptionPane.showMessageDialog(MemberView.this, "Xóa 1 thành viên thành công!");
//                loadData(null);
//            } else {
//                JOptionPane.showMessageDialog(MemberView.this, "Chọn dòng cần xóa !");
//            }
//        }
//    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLHeader;
    private javax.swing.JPanel JPContainOperation;
    private javax.swing.JPanel JPContainSearchOperation;
    private javax.swing.JPanel JPHeader;
    private javax.swing.JPanel JPMainContent;
    private javax.swing.JButton btnCanhBaoViPham;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnKhuVucHocTap;
    private javax.swing.JButton btnMuonTraThietBi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    // Custom font and color - start
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    private Font sgUI13p = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
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
