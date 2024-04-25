/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.example.demo.View.ThietBi;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;


import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.Controller.ThietBiCTL;
import com.example.demo.Controller.ThongTinSdCTL;
import com.example.demo.Model.ThietBiModel;
import com.example.demo.Model.ThongTinSdModel;
import com.example.demo.View.Styles.Styles;

/**
 *
 * @author Admin
 */
public class DeviceView extends javax.swing.JPanel {

	private Color mainColor = Color.decode("#dff9fb");
	private Color tableColor= new java.awt.Color(126, 214, 223);
	Styles style = new Styles();
	// FORMAT
	private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
	private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
	private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
	private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
	private Font sgUI13I = new Font("Segoe UI", Font.ITALIC, 13);
	private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
	private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
	private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
	private Font fontTittle = new Font("Tahoma", Font.BOLD, 25);
	private Font fontSubTittle = new Font("Tahoma", Font.BOLD, 20);
	private Font fontTable = new Font("Segoe UI", Font.BOLD, 13);
	private DecimalFormat dcf = new DecimalFormat("###,###");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Color btnoldColor = new Color(52, 152, 219);
	private Color texfieldColor = new Color(45, 52, 54);
	private String colorTableCode = "#dee9fc";
	private Font buttonFont = new Font("Segoe UI", Font.BOLD, 15);
	MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
	LineBorder lineCB = new LineBorder(Color.white);
	MatteBorder matteBorderCBDark = new MatteBorder(2, 2, 2, 2, Color.decode("#919191"));
	MatteBorder borderTxt = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
	MatteBorder borderTxtDark = new MatteBorder(2, 2, 2, 2, Color.decode("#919191"));
	EmptyBorder emptyBorderTxt = new EmptyBorder(0, 7, 0, 7);
	EmptyBorder emptyBorderCB = new EmptyBorder(0, 7, 0, 0);

	ThietBiCTL thietBiCTL = new ThietBiCTL();
        ThongTinSdCTL thongTinSdCTL = new ThongTinSdCTL();

	String selectedOptionSearch = "All";

	public DeviceView() {
		initComponents();
		event();
	}

	public void event() {
		loadDataTable();

		// set sự kiện tìm kiếm có sự thay đổi trong text field tim kiem
		jtfTimKiem.getDocument().addDocumentListener(documentListenerSearch);
                
                jTableThietBi.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                         if(e.getClickCount() == 2 && jTableThietBi.getSelectedRow() != -1) {
                            int id = (int) jTableThietBi.getValueAt(jTableThietBi.getSelectedRow(), 0);
                            String ten = (String) jTableThietBi.getValueAt(jTableThietBi.getSelectedRow(), 1);
                            String moTa = (String) jTableThietBi.getValueAt(jTableThietBi.getSelectedRow(), 2);
                            
//                            ThietBiModel thietBiModel = thietBiCTL.getModel(id);
                            
//                            Collection<ThongTinSdModel> collection = thietBiModel.getListInfomation();

//                            if(!collection.isEmpty()){
//                                for(ThongTinSdModel thongTinSdModel: collection) {
//                                    if(thongTinSdModel.getTgMuon() != null && thongTinSdModel.getTgTra() == null) {
//                                        String tenThanhVien = thongTinSdModel.getThanhVien().getHoTen();
//                                        jlbDalTTCTTinhTrang.setText("Đang được mượn bởi " + tenThanhVien);
//                                        break;
//                                    } else jlbDalTTCTTinhTrang.setText("Thiết bị đang rảnh");  
//                                }
//                            } else jlbDalTTCTTinhTrang.setText("Thiết bị rảnh");

                            jlbDalTTCTId.setText(id + "");
                            jlbDalTTCTTen.setText(ten);
                            jlbDalTTCTMoTa.setText(moTa);
                            
                            jDialogThongTinChiTiet.setLocationRelativeTo(null);
                            jDialogThongTinChiTiet.setVisible(true);
                         }
                    }
                });

	}

	DocumentListener documentListenerSearch = new DocumentListener() {
		@Override
		public void insertUpdate(DocumentEvent e) {
			performSearch();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			performSearch();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
		}
	};

	DocumentListener documentListenerId = new DocumentListener() {
		@Override
		public void insertUpdate(DocumentEvent e) {
//			getNewestId();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
//			getNewestId();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
		}
	};

	public void loadDataTable() {
		DefaultTableModel model = (DefaultTableModel) jTableThietBi.getModel();
		model.setRowCount(0); // Xóa dữ liệu hiện tại của bảng

		model.setColumnIdentifiers(new Object[] { "ID", "Tên thiết bị", "Mô tả thiết bị" });

//		for (ThietBiModel thietBiModel : thietBiCTL.getList()) {
//			model.addRow(new Object[] { thietBiModel.getMaTB(), thietBiModel.getTenTB(), thietBiModel.getMoTaTB() });
//		}

		TableCellRenderer renderer = new CustomTableRender();

		for (int i = 0; i < jTableThietBi.getColumnCount(); i++) {
			jTableThietBi.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
	}

	public void performSearch() {

		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(jTableThietBi.getModel());
		jTableThietBi.setRowSorter(rowSorter);

		String text = jtfTimKiem.getText();

		List<RowFilter<Object, Object>> filters = new ArrayList<>();

		if (text.trim().length() > 0) {
			switch (selectedOptionSearch) {
				case "All":
					filters.add(RowFilter.regexFilter("(?i)" + text));
					break;
				case "ID":
					filters.add(RowFilter.regexFilter("(?i)" + text, 0));
					break;
				case "Tên thiết bị":
					filters.add(RowFilter.regexFilter("(?i)" + text, 1));
					break;
				case "Mô tả thiết bị":
					filters.add(RowFilter.regexFilter("(?i)" + text, 2));
					break;
			}
		}

		RowFilter<Object, Object> combinedFilter = RowFilter.andFilter(filters);
		rowSorter.setRowFilter(combinedFilter);
	}

//	public void getNewestId() {
//		String text = jtfDalTXSTen.getText();
//		String[] words = text.split("\\s+");
//
//		ArrayList<ThietBiModel> list = new ArrayList<>();
//
//		int id = 0;
//
//		switch (words[0]) {
//			case "Micro": {
//				list = thietBiCTL.getListById("1");
//				if (list.isEmpty())
//					id = 100001;
//
//			}
//				break;
//			case "Máy": {
//				if (words.length >= 2) {
//					if ("chiếu".equals(words[1])) {
//						list = thietBiCTL.getListById("2");
//						if (list.isEmpty())
//							id = 200001;
//
//					} else if ("ảnh".equals(words[1])) {
//						list = thietBiCTL.getListById("3");
//						if (list.isEmpty())
//							id = 300001;
//
//					}
//				}
//
//			}
//				break;
//			case "Cassette": {
//				list = thietBiCTL.getListById("4");
//				if (list.isEmpty())
//					id = 400001;
//
//			}
//				break;
//			case "Tivi": {
//				list = thietBiCTL.getListById("5");
//				if (list.isEmpty())
//					id = 500001;
//
//			}
//				break;
//			case "Quạt": {
//				if (words.length >= 2) {
//					if ("đứng".equals(words[1])) {
//						list = thietBiCTL.getListById("6");
//						if (list.isEmpty())
//							id = 600001;
//					}
//				}
//			}
//				break;
//			default:
//				list = null;
//				break;
//		}
//
//		if (list != null) {
//			if (id == 0) {
//				if (!list.isEmpty()) {
//					int len = list.size();
//					id = list.get(len - 1).getMaTB() + 1;
//					jtfDalTXSID.setText(id + "");
//				} else
//					jtfDalTXSID.setText("");
//			} else
//				jtfDalTXSID.setText(id + "");
//
//		} else
//			jtfDalTXSID.setText("");
//
//	}

	public void refresh() {
		jtfTimKiem.setText("");
		jcbTimKiem.setSelectedItem("All");
		jTableThietBi.clearSelection();

		loadDataTable();
	}

	public void resetDialogTXS() {
		jtfDalTXSID.setText("");
		jtfDalTXSTen.setText("");
		jtfDalTXSMoTa.setText("");
        }

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jDialogThemXoaSua = new javax.swing.JDialog();
        jpnDalTXSHeader = new javax.swing.JPanel();
        jlbDalTXSHeader = new javax.swing.JLabel();
        jpnDalTXSContent = new javax.swing.JPanel();
        jlbDalTXSID = new javax.swing.JLabel();
        jlbDalTXSTen = new javax.swing.JLabel();
        jtfDalTXSTen = new javax.swing.JTextField();
        jlbDalTXSMoTa = new javax.swing.JLabel();
        jtfDalTXSMoTa = new javax.swing.JTextField();
        jpnDalTXSID = new javax.swing.JPanel();
        jtfDalTXSID = new javax.swing.JTextField();
        jcbDalTXSLoaiId = new javax.swing.JComboBox<>();
        jpnDalTXSFooter = new javax.swing.JPanel();
        btnXacNhan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jDialogThongTinChiTiet = new javax.swing.JDialog();
        jpnDialogHeader1 = new javax.swing.JPanel();
        jlbDialogHeader1 = new javax.swing.JLabel();
        jpnDialogContent1 = new javax.swing.JPanel();
        jlbDialogID1 = new javax.swing.JLabel();
        jlbDialogTen1 = new javax.swing.JLabel();
        jlbDialogMoTa1 = new javax.swing.JLabel();
        jlbDalTTCTId = new javax.swing.JLabel();
        jlbDalTTCTTen = new javax.swing.JLabel();
        jlbDalTTCTMoTa = new javax.swing.JLabel();
        jlbDialogTinhTrang = new javax.swing.JLabel();
        jlbDalTTCTTinhTrang = new javax.swing.JLabel();
        jpnDialogFooter1 = new javax.swing.JPanel();
        btnThoat = new javax.swing.JButton();
        jpnHeader = new javax.swing.JPanel();
        jlbHeader = new javax.swing.JLabel();
        jpnTopContent = new javax.swing.JPanel();
        jlbTimKiem = new javax.swing.JLabel();
        jtfTimKiem = new javax.swing.JTextField();
        jcbTimKiem = new javax.swing.JComboBox<>();
        jpnContent = new javax.swing.JPanel();
        jScrollTable = new javax.swing.JScrollPane();
        jTableThietBi = new javax.swing.JTable();
        jpnFooter = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXoaNhieu = new javax.swing.JButton();
        btnNhapExcel = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        jDialogThemXoaSua.setMinimumSize(new java.awt.Dimension(500, 300));
        jDialogThemXoaSua.setModal(true);
        jDialogThemXoaSua.getContentPane().setLayout(new javax.swing.BoxLayout(jDialogThemXoaSua.getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jpnDalTXSHeader.setBackground(mainColor);
        jpnDalTXSHeader.setLayout(new java.awt.BorderLayout());

        jlbDalTXSHeader.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jlbDalTXSHeader.setText("Thông tin thiết bị");
        jlbDalTXSHeader.setPreferredSize(new java.awt.Dimension(500, 50));
        jlbDalTXSHeader.setHorizontalAlignment(JLabel.CENTER);
        jpnDalTXSHeader.add(jlbDalTXSHeader, java.awt.BorderLayout.CENTER);

        jDialogThemXoaSua.getContentPane().add(jpnDalTXSHeader);

        jpnDalTXSContent.setBackground(new java.awt.Color(255, 255, 255));
        jpnDalTXSContent.setPreferredSize(new java.awt.Dimension(500, 200));
        java.awt.GridBagLayout jPanel3Layout = new java.awt.GridBagLayout();
        jPanel3Layout.columnWidths = new int[] {0, 30, 0};
        jPanel3Layout.rowHeights = new int[] {0, 5, 0, 5, 0};
        jpnDalTXSContent.setLayout(jPanel3Layout);

        jlbDalTXSID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbDalTXSID.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpnDalTXSContent.add(jlbDalTXSID, gridBagConstraints);

        jlbDalTXSTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbDalTXSTen.setText("Tên thiết bị");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpnDalTXSContent.add(jlbDalTXSTen, gridBagConstraints);

        jtfDalTXSTen.setPreferredSize(new java.awt.Dimension(200, 30));
        jtfDalTXSTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDalTXSTenActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jpnDalTXSContent.add(jtfDalTXSTen, gridBagConstraints);

        jlbDalTXSMoTa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbDalTXSMoTa.setText("Mô tả thiết bị");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpnDalTXSContent.add(jlbDalTXSMoTa, gridBagConstraints);

        jtfDalTXSMoTa.setPreferredSize(new java.awt.Dimension(200, 30));
        jtfDalTXSMoTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDalTXSMoTaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        jpnDalTXSContent.add(jtfDalTXSMoTa, gridBagConstraints);

        jpnDalTXSID.setBackground(new java.awt.Color(255, 255, 255));

        jtfDalTXSID.setEnabled(false);
        jtfDalTXSID.setPreferredSize(new java.awt.Dimension(200, 30));
        jtfDalTXSID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDalTXSIDActionPerformed(evt);
            }
        });
        jpnDalTXSID.add(jtfDalTXSID);

        jcbDalTXSLoaiId.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jcbDalTXSLoaiId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Micro", "2 - Máy chiếu", "3 - Máy ảnh", "4 - Cassette", "5 - Tivi", "6 - Quạt đứng" }));
        jcbDalTXSLoaiId.setPreferredSize(new java.awt.Dimension(200, 30));
        jcbDalTXSLoaiId.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jcbDalTXSLoaiId.setBackground(Color.WHITE);
        jcbDalTXSLoaiId.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        jcbDalTXSLoaiId.setBackground(Color.white);
        //jcbDialogLoaiId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jcbDalTXSLoaiId.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(new LineBorder(Color.white));
                return basicComboPopup;
            }
        });
        jpnDalTXSID.add(jcbDalTXSLoaiId);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jpnDalTXSContent.add(jpnDalTXSID, gridBagConstraints);

        jDialogThemXoaSua.getContentPane().add(jpnDalTXSContent);

        jpnDalTXSFooter.setBackground(new java.awt.Color(255, 255, 255));
        jpnDalTXSFooter.setPreferredSize(new java.awt.Dimension(500, 60));

        btnXacNhan.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/xacnhan_icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.setFont(buttonFont);
        btnXacNhan.setBackground(tableColor);
        btnXacNhan.setBorder(new EmptyBorder(8, 12, 8, 12));
        btnXacNhan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnXacNhanActionPerformed(evt);
            }
        });
        jpnDalTXSFooter.add(btnXacNhan);

        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/demo/View/images/cancel button.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.setFont(buttonFont);
        btnHuy.setBackground(tableColor);
        btnHuy.setBorder(new EmptyBorder(8, 12, 8, 12));
        btnHuy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jpnDalTXSFooter.add(btnHuy);

        jDialogThemXoaSua.getContentPane().add(jpnDalTXSFooter);

        jDialogThongTinChiTiet.setMinimumSize(new java.awt.Dimension(500, 300));
        jDialogThongTinChiTiet.setModal(true);
        jDialogThongTinChiTiet.getContentPane().setLayout(new javax.swing.BoxLayout(jDialogThongTinChiTiet.getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jpnDialogHeader1.setBackground(mainColor);
        jpnDialogHeader1.setLayout(new java.awt.BorderLayout());

        jlbDialogHeader1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jlbDialogHeader1.setText("Thông tin chi tiết thiết bị");
        jlbDialogHeader1.setPreferredSize(new java.awt.Dimension(500, 50));
        jlbDialogHeader1.setHorizontalAlignment(JLabel.CENTER);
        jpnDialogHeader1.add(jlbDialogHeader1, java.awt.BorderLayout.CENTER);

        jDialogThongTinChiTiet.getContentPane().add(jpnDialogHeader1);

        jpnDialogContent1.setBackground(new java.awt.Color(255, 255, 255));
        jpnDialogContent1.setPreferredSize(new java.awt.Dimension(500, 200));
        java.awt.GridBagLayout jpnDialogContent1Layout = new java.awt.GridBagLayout();
        jpnDialogContent1Layout.columnWidths = new int[] {0, 30, 0};
        jpnDialogContent1Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        jpnDialogContent1.setLayout(jpnDialogContent1Layout);

        jlbDialogID1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbDialogID1.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpnDialogContent1.add(jlbDialogID1, gridBagConstraints);

        jlbDialogTen1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbDialogTen1.setText("Tên thiết bị");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpnDialogContent1.add(jlbDialogTen1, gridBagConstraints);

        jlbDialogMoTa1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbDialogMoTa1.setText("Mô tả thiết bị");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpnDialogContent1.add(jlbDialogMoTa1, gridBagConstraints);

        jlbDalTTCTId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpnDialogContent1.add(jlbDalTTCTId, gridBagConstraints);

        jlbDalTTCTTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpnDialogContent1.add(jlbDalTTCTTen, gridBagConstraints);

        jlbDalTTCTMoTa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpnDialogContent1.add(jlbDalTTCTMoTa, gridBagConstraints);

        jlbDialogTinhTrang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbDialogTinhTrang.setText("Tình trạng thiết bị");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jpnDialogContent1.add(jlbDialogTinhTrang, gridBagConstraints);

        jlbDalTTCTTinhTrang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpnDialogContent1.add(jlbDalTTCTTinhTrang, gridBagConstraints);

        jDialogThongTinChiTiet.getContentPane().add(jpnDialogContent1);

        jpnDialogFooter1.setBackground(new java.awt.Color(255, 255, 255));
        jpnDialogFooter1.setPreferredSize(new java.awt.Dimension(500, 60));

        btnThoat.setText("Thoát");
        btnThoat.setFont(buttonFont);
        btnThoat.setBackground(tableColor);
        btnThoat.setBorder(new EmptyBorder(8, 12, 8, 12));
        btnThoat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jpnDialogFooter1.add(btnThoat);

        jDialogThongTinChiTiet.getContentPane().add(jpnDialogFooter1);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jpnHeader.setBackground(mainColor);
        jpnHeader.setPreferredSize(new java.awt.Dimension(993, 50));
        jpnHeader.setLayout(new java.awt.BorderLayout());

        jlbHeader.setBackground(new java.awt.Color(153, 204, 255));
        jlbHeader.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jlbHeader.setText("Quản lý thiết bị");
        jlbHeader.setToolTipText("");
        jlbHeader.setPreferredSize(new java.awt.Dimension(37, 30));
        jlbHeader.setHorizontalAlignment(JLabel.CENTER);
        jpnHeader.add(jlbHeader, java.awt.BorderLayout.CENTER);

        add(jpnHeader);

        jpnTopContent.setBackground(new java.awt.Color(255, 255, 255));
        jpnTopContent.setPreferredSize(new java.awt.Dimension(993, 60));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15);
        flowLayout1.setAlignOnBaseline(true);
        jpnTopContent.setLayout(flowLayout1);

        jlbTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTimKiem.setText("Tìm kiếm");
        jpnTopContent.add(jlbTimKiem);

        jtfTimKiem.setPreferredSize(new java.awt.Dimension(200, 30));
        jtfTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTimKiemActionPerformed(evt);
            }
        });
        jpnTopContent.add(jtfTimKiem);

        jcbTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jcbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "ID", "Tên thiết bị", "Mô tả thiết bị" }));
        jcbTimKiem.setPreferredSize(new java.awt.Dimension(200, 30));
        jcbTimKiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jcbTimKiem.setBackground(Color.WHITE);
        jcbTimKiem.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        jcbTimKiem.setBackground(Color.white);
        //jcbTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jcbTimKiem.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(new LineBorder(Color.white));
                return basicComboPopup;
            }
        });
        jcbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTimKiemActionPerformed(evt);
            }
        });
        jpnTopContent.add(jcbTimKiem);

        add(jpnTopContent);

        jpnContent.setBackground(new java.awt.Color(255, 255, 255));
        jpnContent.setPreferredSize(new java.awt.Dimension(993, 600));
        jpnContent.setLayout(new java.awt.BorderLayout());

        jTableThietBi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTableThietBi.setShowGrid(false);
        jTableThietBi.setDefaultEditor(Object.class, null);

        jTableThietBi.setBackground(Color.WHITE);
        jTableThietBi.setBorder(null);
        jTableThietBi.setRowHeight(35);
        jTableThietBi.setFont(new Font("Segoe UI", Font.BOLD, 13)); // Thiết lập font cho các dòng trong bảng
        jTableThietBi.setShowGrid(false);
        jTableThietBi.setRowHeight(35);

        jTableThietBi.getTableHeader().setPreferredSize(new Dimension(1, 30));
        jTableThietBi.getTableHeader().setFont(fontTable);
        Font headerFont = new Font("Segoe UI", Font.BOLD, 15);
        jTableThietBi.getTableHeader().setFont(headerFont);
        jTableThietBi.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableThietBi.getTableHeader().setBackground(tableColor);

        //jTableThietBi.getColumnModel().getColumn(0).setPreferredWidth(50);
        jScrollTable.setViewportView(jTableThietBi);

        jScrollTable.getViewport().setBackground(Color.WHITE);

        jpnContent.add(jScrollTable, java.awt.BorderLayout.CENTER);

        add(jpnContent);

        jpnFooter.setBackground(new java.awt.Color(255, 255, 255));
        jpnFooter.setPreferredSize(new java.awt.Dimension(993, 60));
        jpnFooter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 15));

        btnThem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/add_icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnThem.setText("Thêm");
        btnThem.setFont(buttonFont);
        btnThem.setBackground(tableColor);
        btnThem.setBorder(new EmptyBorder(8, 12, 8, 12));
        btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jpnFooter.add(btnThem);

        btnSua.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/edit_icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnSua.setText("Sửa");
        btnSua.setFont(buttonFont);
        btnSua.setBackground(tableColor);
        btnSua.setBorder(new EmptyBorder(8, 12, 8, 12));
        btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jpnFooter.add(btnSua);

        btnXoa.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/delete_icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnXoa.setText("Xóa");
        btnXoa.setFont(buttonFont);
        btnXoa.setBackground(tableColor);
        btnXoa.setBorder(new EmptyBorder(8, 12, 8, 12));
        btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jpnFooter.add(btnXoa);

        btnXoaNhieu.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/delete_icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnXoaNhieu.setText("Xóa nhiều");
        btnXoaNhieu.setFont(buttonFont);
        btnXoaNhieu.setBackground(tableColor);
        btnXoaNhieu.setBorder(new EmptyBorder(8, 12, 8, 12));
        btnXoaNhieu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnXoaNhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNhieuActionPerformed(evt);
            }
        });
        jpnFooter.add(btnXoaNhieu);

        btnNhapExcel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/importExcel_icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnNhapExcel.setText("Nhập file Excel");
        btnNhapExcel.setFont(buttonFont);
        btnNhapExcel.setBackground(tableColor);
        btnNhapExcel.setBorder(new EmptyBorder(8, 12, 8, 12));
        btnNhapExcel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNhapExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapExcelActionPerformed(evt);
            }
        });
        jpnFooter.add(btnNhapExcel);

        btnRefresh.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/refresh_icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        btnRefresh.setText("Refresh");
        btnRefresh.setFont(buttonFont);
        btnRefresh.setBackground(tableColor);
        btnRefresh.setBorder(new EmptyBorder(8, 12, 8, 12));
        btnRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jpnFooter.add(btnRefresh);

        add(jpnFooter);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        jDialogThongTinChiTiet.setVisible(false);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void jtfDalTXSMoTaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDalTXSMoTaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDalTXSMoTaActionPerformed
    
    private void jtfDalTXSIDActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }
    
    private void jtfDalTXSTenActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
            // TODO add your handling code here:
            resetDialogTXS();

            jtfDalTXSTen.getDocument().addDocumentListener(documentListenerId);

            jtfDalTXSID.setVisible(true);
            jcbDalTXSLoaiId.setVisible(false);

            jlbDalTXSID.setText("ID");
            btnXacNhan.setText("Xác nhận");

            jDialogThemXoaSua.setLocationRelativeTo(null);
            jDialogThemXoaSua.setVisible(true);
    }// GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaActionPerformed
            // TODO add your handling code here:
            if (jTableThietBi.getSelectedRow() != -1) {
                    int option = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không?", "Xác nhận xóa",
                                    JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                            int id = (int) jTableThietBi.getValueAt(jTableThietBi.getSelectedRow(), 0);

//                            JOptionPane.showMessageDialog(this, thietBiCTL.deleteModel(id), "Thông báo",
//                                            JOptionPane.INFORMATION_MESSAGE);
                            loadDataTable();
                    }
            } else
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn thiết bị bạn cần xóa", "Thông báo",
                                    JOptionPane.INFORMATION_MESSAGE);
    }// GEN-LAST:event_btnXoaActionPerformed

    private void btnNhapExcelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNhapExcelActionPerformed
            // TODO add your handling code here:
            JFileChooser fileChooser = new JFileChooser();

            // Chỉ cho phép người dùng chọn file có đuôi là .xlsx
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xlsx");
            fileChooser.setFileFilter(filter);

            // Hiển thị hộp thoại chọn file
            int result = fileChooser.showOpenDialog(null);

            // Kiểm tra xem người dùng đã chọn file hay chưa
            if (result == JFileChooser.APPROVE_OPTION) {
                    // Lấy địa chỉ file đã chọn
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();

                    try {
                            FileInputStream file = new FileInputStream(filePath);

                            XSSFWorkbook workbook = new XSSFWorkbook(file);
                            XSSFSheet sheet = workbook.getSheetAt(0);

                            Iterator<Row> rowIterator = sheet.iterator();
                            rowIterator.next(); // Skip header row

                            DataFormatter dataFormatter = new DataFormatter();

                            ArrayList<ThietBiModel> list = new ArrayList<>();

                            while (rowIterator.hasNext()) {
                                    Row row = rowIterator.next();
                                    Cell cell1 = row.getCell(0);
                                    Cell cell2 = row.getCell(1);
                                    Cell cell3 = row.getCell(2);

                                    String value1 = dataFormatter.formatCellValue(cell1);
                                    String value2 = dataFormatter.formatCellValue(cell2);
                                    String value3 = dataFormatter.formatCellValue(cell3);

                                    int id = Integer.parseInt(value1);

                                    ThietBiModel thietBiModel = new ThietBiModel(id, value2, value3);

                                    list.add(thietBiModel);
                            }

//                            JOptionPane.showMessageDialog(this, thietBiCTL.addListModel(list), "Thông báo",
//                                            JOptionPane.INFORMATION_MESSAGE);

                            workbook.close();
                            file.close();
                            loadDataTable();
                    } catch (IOException | NumberFormatException e) {
                    }
            }
    }// GEN-LAST:event_btnNhapExcelActionPerformed

    private void btnXoaNhieuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaNhieuActionPerformed
            // TODO add your handling code here:
            resetDialogTXS();

            jtfDalTXSTen.getDocument().removeDocumentListener(documentListenerId);

            jtfDalTXSID.setVisible(false);
            jcbDalTXSLoaiId.setVisible(true);

            btnXacNhan.setText("Xóa");
            jlbDalTXSID.setText("Loại thiết bị");

            jDialogThemXoaSua.setLocationRelativeTo(null);
            jDialogThemXoaSua.setVisible(true);

    }// GEN-LAST:event_btnXoaNhieuActionPerformed

    private void jtfDialogTenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtfDialogTenActionPerformed
            // TODO add your handling code here:
    }// GEN-LAST:event_jtfDialogTenActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHuyActionPerformed
            // TODO add your handling code here:
            jDialogThemXoaSua.setVisible(false);
    }// GEN-LAST:event_btnHuyActionPerformed

    private void jtfDialogIDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtfDialogIDActionPerformed
            // TODO add your handling code here:
    }// GEN-LAST:event_jtfDialogIDActionPerformed

//    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXacNhanActionPerformed
//            // TODO add your handling code here:
//            String ten = jtfDalTXSTen.getText();
//            String moTa = jtfDalTXSMoTa.getText();
//
//            if ("Xác nhận".equals(btnXacNhan.getText())) {
//                    String id = jtfDalTXSID.getText();
//                    if (id.isEmpty()) {
//                            JOptionPane.showMessageDialog(this, "Bạn nhập sai định dạng tên thiết bị", "Thông báo",
//                                            JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                            int ID = Integer.parseInt(id);
//                            ThietBiModel thietBiModel = thietBiCTL.getModel(ID);
//
//                            if (thietBiModel != null) {
//                                    thietBiModel.setTenTB(ten);
//                                    thietBiModel.setMoTaTB(moTa);
//
//                                    JOptionPane.showMessageDialog(this, thietBiCTL.updateModel(thietBiModel), "Thông báo",
//                                                    JOptionPane.INFORMATION_MESSAGE);
//                            } else {
//                                    ThietBiModel thietBi = new ThietBiModel(ID, ten, moTa);
//                                    JOptionPane.showMessageDialog(this, thietBiCTL.addModel(thietBi), "Thông báo",
//                                                    JOptionPane.INFORMATION_MESSAGE);
//                            }
//
//                            jDialogThemXoaSua.setVisible(false);
//                    }
//            } else {
//                    ArrayList<ThietBiModel> list = new ArrayList<>();
//                    ArrayList<ThietBiModel> listDelete = new ArrayList<>();
//
//                    String selectedItem = (String) jcbDalTXSLoaiId.getSelectedItem();
//
//                    switch (selectedItem) {
//                            case "1 - Micro":
//                                    list = thietBiCTL.getListById("1");
//                                    break;
//                            case "2 - Máy chiếu":
//                                    list = thietBiCTL.getListById("2");
//                                    break;
//                            case "3 - Máy ảnh":
//                                    list = thietBiCTL.getListById("3");
//                                    break;
//                            case "4 - Cassette":
//                                    list = thietBiCTL.getListById("4");
//                                    break;
//                            case "5 - Tivi":
//                                    list = thietBiCTL.getListById("5");
//                                    break;
//                            case "6 - Quạt đứng":
//                                    list = thietBiCTL.getListById("6");
//                                    break;
//                    }
//
//                    for (ThietBiModel thietBiModel : list) {
//                            if (thietBiModel.getTenTB().contains(ten))
//                                    if (thietBiModel.getMoTaTB().contains(moTa))
//                                            listDelete.add(thietBiModel);
//                    }
//
//                    int option = JOptionPane.showConfirmDialog(this,
//                                    "Bạn chắc chắn muốn xóa " + listDelete.size() + " thiết bị không?", "Xác nhận xóa",
//                                    JOptionPane.YES_NO_OPTION);
//
//                    if (option == JOptionPane.YES_OPTION) {
//                            JOptionPane.showMessageDialog(this, thietBiCTL.deleteListModel(listDelete), "Thông báo",
//                                            JOptionPane.INFORMATION_MESSAGE);
//                            jDialogThemXoaSua.setVisible(false);
//                    }
//
//            }
//
//            loadDataTable();
//
//    }// GEN-LAST:event_btnXacNhanActionPerformed

    private void jtfTimKiemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtfTimKiemActionPerformed
            // TODO add your handling code here:
    }// GEN-LAST:event_jtfTimKiemActionPerformed

    private void jcbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jcbTimKiemActionPerformed
            // TODO add your handling code here:
            selectedOptionSearch = (String) jcbTimKiem.getSelectedItem();
            performSearch();
    }// GEN-LAST:event_jcbTimKiemActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRefreshActionPerformed
            // TODO add your handling code here:
            refresh();
    }// GEN-LAST:event_btnRefreshActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaActionPerformed
            // TODO add your handling code here:
            if (jTableThietBi.getSelectedRow() != -1) {
                    int id = (int) jTableThietBi.getValueAt(jTableThietBi.getSelectedRow(), 0);
                    String ten = (String) jTableThietBi.getValueAt(jTableThietBi.getSelectedRow(), 1);
                    String moTa = (String) jTableThietBi.getValueAt(jTableThietBi.getSelectedRow(), 2);

                    jtfDalTXSTen.getDocument().removeDocumentListener(documentListenerId);

                    jtfDalTXSID.setText(id + "");
                    jtfDalTXSTen.setText(ten);
                    jtfDalTXSMoTa.setText(moTa);

                    jtfDalTXSID.setVisible(true);
                    jcbDalTXSLoaiId.setVisible(false);

                    btnXacNhan.setText("Xác nhận");
                    jlbDalTXSID.setText("ID");

                    jDialogThemXoaSua.setLocationRelativeTo(null);
                    jDialogThemXoaSua.setVisible(true);

            } else
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn thiết bị bạn cần sửa", "Thông báo",
                                    JOptionPane.INFORMATION_MESSAGE);

    }// GEN-LAST:event_btnSuaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnNhapExcel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaNhieu;
    private javax.swing.JDialog jDialogThemXoaSua;
    private javax.swing.JDialog jDialogThongTinChiTiet;
    private javax.swing.JScrollPane jScrollTable;
    private javax.swing.JTable jTableThietBi;
    private javax.swing.JComboBox<String> jcbDalTXSLoaiId;
    private javax.swing.JComboBox<String> jcbTimKiem;
    private javax.swing.JLabel jlbDalTTCTId;
    private javax.swing.JLabel jlbDalTTCTMoTa;
    private javax.swing.JLabel jlbDalTTCTTen;
    private javax.swing.JLabel jlbDalTTCTTinhTrang;
    private javax.swing.JLabel jlbDalTXSHeader;
    private javax.swing.JLabel jlbDalTXSID;
    private javax.swing.JLabel jlbDalTXSMoTa;
    private javax.swing.JLabel jlbDalTXSTen;
    private javax.swing.JLabel jlbDialogHeader1;
    private javax.swing.JLabel jlbDialogID1;
    private javax.swing.JLabel jlbDialogMoTa1;
    private javax.swing.JLabel jlbDialogTen1;
    private javax.swing.JLabel jlbDialogTinhTrang;
    private javax.swing.JLabel jlbHeader;
    private javax.swing.JLabel jlbTimKiem;
    private javax.swing.JPanel jpnContent;
    private javax.swing.JPanel jpnDalTXSContent;
    private javax.swing.JPanel jpnDalTXSFooter;
    private javax.swing.JPanel jpnDalTXSHeader;
    private javax.swing.JPanel jpnDalTXSID;
    private javax.swing.JPanel jpnDialogContent1;
    private javax.swing.JPanel jpnDialogFooter1;
    private javax.swing.JPanel jpnDialogHeader1;
    private javax.swing.JPanel jpnFooter;
    private javax.swing.JPanel jpnHeader;
    private javax.swing.JPanel jpnTopContent;
    private javax.swing.JTextField jtfDalTXSID;
    private javax.swing.JTextField jtfDalTXSMoTa;
    private javax.swing.JTextField jtfDalTXSTen;
    private javax.swing.JTextField jtfTimKiem;
    // End of variables declaration//GEN-END:variables
}
