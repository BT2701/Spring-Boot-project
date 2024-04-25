package com.example.demo.View.ThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.demo.Controller.ThongKeCTL;
import com.example.demo.View.Styles.Styles;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;



public class StatisticView extends JPanel {
	static ThongKeCTL thongKeCTL= new ThongKeCTL();
	
//	container
	private JPanel pnTop,pnTopTittle,pnTopTittleMain, pnTopTittleHiden,pnTopContent,pnCenter, pnCenterTittle, pnCenterContent, pnCenterContentSelection, pnCenterContentSelectionSpinner, pnCenterContentItems, pnItemMember, pnItemDevice, pnItemCurrent, pnItemDone, pnItemUnDone, pnItemFee,pnCbb, pnItemViolation;
//	components
	private JButton btnCountMember, btnCountDevice, btnCountDeviceCurrent, btnHandle;
	private JLabel lbTittleTop, lbTittleBot, lbHiden, lbSelectionDate, lbTxtMember, lbTxtDevice, lbTxtCurrent, lbTxtDone, lbTxtUnDone, lbTxtFee,lbTxtViolation,lbMember, lbDevice, lbCurrent, lbDone, lbUnDone, lbFee,lbViolation;
	private JComboBox<String> cbbSelection;
	private JDateChooser dcsDate, dcsDate1;
	private SpinnerDateModel dateModel, dateModel1;

//	styles
	private Styles style = new Styles();

//	icon
	final ImageIcon member = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/btnmember.png"))
			.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH));
	final ImageIcon device = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/btndevice.png"))
			.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH));
	final ImageIcon current = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/btncurrent.png"))
			.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH));
	final ImageIcon handle = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/btnhandle.png"))
			.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH));

	final ImageIcon member1 = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/btnmemberhover.png"))
			.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH));
	final ImageIcon device1 = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/btndevicehover.png"))
			.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH));
	final ImageIcon current1 = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/btncurrenthover.png"))
			.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH));
	final ImageIcon handle1 = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/btnhandlehover.png"))
			.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH));

	public StatisticView() {
		initComponents();
		styles();
		events();
	}

	private void initComponents() {
//		dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
		dcsDate = new JDateChooser();
		Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1);
        Date date = calendar.getTime();
		dcsDate.setDate(date);
		dcsDate.setDateFormatString("dd/MM/yyyy");
		dcsDate.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
		dcsDate.getCalendarButton().setBackground(Color.decode("#EEEEEE"));
		dcsDate.getCalendarButton().setFocusPainted(false);
		dcsDate.setFont(style.getSgUI13b());
		dcsDate.setPreferredSize(new Dimension(120,30));
        JTextFieldDateEditor editorNgaySinhFrom = (JTextFieldDateEditor) dcsDate.getDateEditor();
        editorNgaySinhFrom.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 3, 0, 3)));
        editorNgaySinhFrom.setBackground(Color.decode("#FFFFFF"));

//		dateModel1 = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        dcsDate1 = new JDateChooser();
		dcsDate1.setDate(new Date());
		dcsDate1.setDateFormatString("dd/MM/yyyy");
		dcsDate1.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
		dcsDate1.getCalendarButton().setBackground(Color.decode("#EEEEEE"));
		dcsDate1.getCalendarButton().setFocusPainted(false);
		dcsDate1.setFont(style.getSgUI13b());
		dcsDate1.setPreferredSize(new Dimension(120,30));
        JTextFieldDateEditor editorNgaySinhFrom1 = (JTextFieldDateEditor) dcsDate1.getDateEditor();
        editorNgaySinhFrom1.setBorder(BorderFactory.createCompoundBorder(style.getBorderTxt(), new EmptyBorder(0, 3, 0, 3)));
        editorNgaySinhFrom1.setBackground(Color.decode("#FFFFFF"));


		btnCountMember = new JButton("");
		btnCountMember.setIcon(member1);
		btnCountMember.setFocusPainted(false);
		btnCountMember.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnCountMember.setFont(style.getSgUI15b());
		btnCountMember.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hover(btnCountMember, member, member1);
		pressed(btnCountMember);

		btnCountDeviceCurrent = new JButton("");
		btnCountDeviceCurrent.setIcon(current1);
		btnCountDeviceCurrent.setFocusPainted(false);
		btnCountDeviceCurrent.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnCountDeviceCurrent.setFont(style.getSgUI15b());
		btnCountDeviceCurrent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hover(btnCountDeviceCurrent, current, current1);
		pressed(btnCountDeviceCurrent);

		btnCountDevice = new JButton("");
		btnCountDevice.setIcon(device1);
		btnCountDevice.setFocusPainted(false);
		btnCountDevice.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnCountDevice.setFont(style.getSgUI15b());
		btnCountDevice.setBackground(Color.red);
		btnCountDevice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hover(btnCountDevice, device, device1);
		pressed(btnCountDevice);

		btnHandle = new JButton("");
		btnHandle.setIcon(handle1);
		btnHandle.setFocusPainted(false);
		btnHandle.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnHandle.setFont(style.getSgUI15b());
		btnHandle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hover(btnHandle, handle, handle1);
		pressed(btnHandle);
		
		
		lbCurrent= new JLabel();
		
		
		lbDevice= new JLabel();
		
		lbDone= new JLabel();
		
		lbFee= new JLabel();
		
		lbHiden= new JLabel("Bấm vào 4 nút bên dưới để xem biểu đồ.");
		
		lbMember= new JLabel();
		
		lbSelectionDate= new JLabel("Đến ngày");
		
		lbTittleBot= new JLabel("Thống kê tổng Quan");
		
		lbTittleTop= new JLabel("Biểu đồ thống kê");
		
		lbTxtCurrent= new JLabel("Thiết bị đang được mượn: ");
		
		lbTxtDevice= new JLabel("Thiết bị đã được mượn: ");
		
		lbViolation=new JLabel();
		
		lbTxtViolation=new JLabel("Vi phạm: ");
		
		lbTxtDone= new JLabel("Đã xử lý: ");
		
		lbTxtFee= new JLabel("Tiền bồi thường: ");
		
		lbTxtMember= new JLabel("Lượt vào khu học tập: ");
		
		lbTxtUnDone= new JLabel("Đang xử lý: ");
		
		
		lbUnDone= new JLabel();
		
		cbbSelection= new JComboBox<String>();

		
		rendererData();
//		tittle hiden
		pnTopTittleHiden= new JPanel();
		pnTopTittleHiden.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		pnTopTittleHiden.add(lbHiden);
		
//		tittle main
		pnTopTittleMain= new JPanel();
		pnTopTittleMain.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		pnTopTittleMain.add(lbTittleTop);
		
//		top tittle
		pnTopTittle= new JPanel();
		pnTopTittle.setLayout(new BorderLayout());
		pnTopTittle.add(pnTopTittleMain, BorderLayout.CENTER);
		pnTopTittle.add(pnTopTittleHiden, BorderLayout.SOUTH);
		
//		topcontent
		pnTopContent=new JPanel();
		pnTopContent.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
		pnTopContent.setBackground(Color.white);
		pnTopContent.add(btnCountMember);
		pnTopContent.add(btnCountDevice);
		pnTopContent.add(btnCountDeviceCurrent);
		pnTopContent.add(btnHandle);
//		top panel
		pnTop= new JPanel();
		pnTop.setLayout(new BorderLayout());
		pnTop.add(pnTopTittle,BorderLayout.NORTH);
		pnTop.add(pnTopContent,BorderLayout.CENTER);
		
//		cbb panle
		pnCbb = new JPanel();
		pnCbb.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnCbb.add(cbbSelection);
		
//		spinner
		pnCenterContentSelectionSpinner= new JPanel();
		pnCenterContentSelectionSpinner.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnCenterContentSelectionSpinner.add(dcsDate);
		pnCenterContentSelectionSpinner.add(lbSelectionDate);
		pnCenterContentSelectionSpinner.add(dcsDate1);
		pnCenterContentSelectionSpinner.setVisible(false);
		
//		center selection
		pnCenterContentSelection= new JPanel();
		pnCenterContentSelection.setLayout(new BorderLayout());
		pnCenterContentSelection.add(pnCbb, BorderLayout.NORTH);
		pnCenterContentSelection.add(pnCenterContentSelectionSpinner, BorderLayout.CENTER);
		
//		member
		pnItemMember= new JPanel();
		pnItemMember.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		pnItemMember.add(lbTxtMember);
		pnItemMember.add(lbMember);
		
//		Device
		pnItemDevice= new JPanel();
		pnItemDevice.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		pnItemDevice.add(lbTxtDevice);
		pnItemDevice.add(lbDevice);
		
//		Current
		pnItemCurrent= new JPanel();
		pnItemCurrent.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		pnItemCurrent.add(lbTxtCurrent);
		pnItemCurrent.add(lbCurrent);
		
//		violation
		pnItemViolation=new JPanel();
		pnItemViolation.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		pnItemViolation.add(lbTxtViolation);
		pnItemViolation.add(lbViolation);
		
//		Done
		pnItemDone= new JPanel();
		pnItemDone.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		pnItemDone.add(lbTxtDone);
		pnItemDone.add(lbDone);
		
//		UnDone
		pnItemUnDone= new JPanel();
		pnItemUnDone.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		pnItemUnDone.add(lbTxtUnDone);
		pnItemUnDone.add(lbUnDone);
		
//		Fee
		pnItemFee= new JPanel();
		pnItemFee.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		pnItemFee.add(lbTxtFee);
		pnItemFee.add(lbFee);
		
//		center items
		pnCenterContentItems= new JPanel();
		pnCenterContentItems.setLayout(new BoxLayout(pnCenterContentItems, BoxLayout.Y_AXIS));
		pnCenterContentItems.add(pnItemMember);
		pnCenterContentItems.add(pnItemDevice);
		pnCenterContentItems.add(pnItemCurrent);
		pnCenterContentItems.add(pnItemViolation);
		pnCenterContentItems.add(pnItemDone);
		pnCenterContentItems.add(pnItemUnDone);
		pnCenterContentItems.add(pnItemFee);
		
//		center tittle
		pnCenterTittle= new JPanel();
		pnCenterTittle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		pnCenterTittle.add(lbTittleBot);
		
//		center content
		pnCenterContent=new JPanel();
		pnCenterContent.setLayout(new BorderLayout());
		pnCenterContent.add(pnCenterContentSelection,BorderLayout.NORTH);
		pnCenterContent.add(pnCenterContentItems, BorderLayout.CENTER);
		
//		center panel
		pnCenter=new JPanel();
		pnCenter.setLayout(new BorderLayout());
		pnCenter.add(pnCenterTittle,BorderLayout.NORTH);
		pnCenter.add(pnCenterContent,BorderLayout.CENTER);
		
//		container
		this.setLayout(new BorderLayout());
		this.add(pnTop,BorderLayout.NORTH);
		this.add(pnCenter,BorderLayout.CENTER);
	}

	public void hover(final JButton btn, final ImageIcon hover, final ImageIcon exit) {

		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btn.setIcon(hover);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				btn.setIcon(exit);

			}
		});

	}

	public void pressed(final JButton btn) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == btnCountMember) {
					new FormStatistic(1);
				} else if (e.getSource() == btnCountDevice) {
					new FormStatistic(2);
				} else if (e.getSource() == btnCountDeviceCurrent) {
					new FormStatistic(3);
				} else if (e.getSource() == btnHandle) {
					new FormStatistic(4);
				}
			}
		});
	}

	public void styles() {
//		panel
		pnCbb.setBackground(Color.white);
		pnCenter.setBackground(Color.white);
		pnCenterContent.setBackground(Color.white);
		pnCenterContentItems.setBackground(Color.white);
		pnCenterContentSelection.setBackground(Color.white);
		pnCenterContentSelectionSpinner.setBackground(Color.white);
		pnCenterTittle.setBackground(Color.white);
		pnItemCurrent.setBackground(Color.white);
		pnItemDevice.setBackground(Color.white);
		pnItemDone.setBackground(Color.white);
		pnItemFee.setBackground(Color.white);
		pnItemMember.setBackground(Color.white);
		pnItemUnDone.setBackground(Color.white);
		pnTop.setBackground(Color.white);
		pnTopContent.setBackground(Color.white);
		pnTopTittle.setBackground(Color.white);
		pnTopTittleHiden.setBackground(Color.white);
		pnTopTittleMain.setBackground(Color.white);
		pnItemViolation.setBackground(Color.white);
		
		pnTopContent.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.decode("#7ed6df")));
		
		pnItemCurrent.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.decode("#c7ecee")));
		
		pnItemDevice.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.decode("#c7ecee")));
		
		pnItemDone.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.decode("#c7ecee")));
		
		pnItemFee.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.decode("#c7ecee")));
		
		pnItemUnDone.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.decode("#c7ecee")));
		
		pnItemViolation.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.decode("#c7ecee")));
//		label
		lbCurrent.setFont(style.getSgUI15p());
		lbUnDone.setFont(style.getSgUI15p());
		lbDevice.setFont(style.getSgUI15p());
		lbDone.setFont(style.getSgUI15p());
		lbFee.setFont(style.getSgUI15p());
		lbHiden.setFont(style.gettNR13i());
		lbMember.setFont(style.getSgUI15p());
		lbSelectionDate.setFont(style.getSgUI15p());
		lbTittleBot.setFont(style.getSgUI18b());
		lbTittleTop.setFont(style.getSgUI18b());
		lbTxtUnDone.setFont(style.getSgUI15p());
		lbTxtMember.setFont(style.getSgUI15b());
		lbTxtFee.setFont(style.getSgUI15b());
		lbTxtDone.setFont(style.getSgUI15p());
		lbTxtDevice.setFont(style.getSgUI15b());
		lbTxtCurrent.setFont(style.getSgUI15b());
		lbViolation.setFont(style.getSgUI15p());
		lbTxtViolation.setFont(style.getSgUI15b());
		lbFee.setForeground(Color.decode("#f0932b"));
		lbViolation.setForeground(Color.decode("#eb4d4b"));
		lbUnDone.setForeground(Color.decode("#ee5253"));
		lbDone.setForeground(Color.decode("#1dd1a1"));
		
		
//		button
		btnCountDevice.setBackground(Color.decode("#dff9fb"));
		btnCountDeviceCurrent.setBackground(Color.decode("#dff9fb"));
		btnCountMember.setBackground(Color.decode("#dff9fb"));
		btnHandle.setBackground(Color.decode("#dff9fb"));
		
//		combobox
		cbbSelection.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
		cbbSelection.setBackground(Color.white);
		cbbSelection.setFont(style.getSgUI13b());
		cbbSelection.setPreferredSize(new Dimension(200, 30));
		cbbSelection.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
				basicComboPopup.setBorder(style.getLineCB());
				return basicComboPopup;
			}
		});
		cbbSelection.setBorder(style.getMatteBorderCB());
		rendererCbb(cbbSelection);
	}
	public void rendererCbb(JComboBox<String> cbb) {
		DefaultComboBoxModel<String> model= new DefaultComboBoxModel<>();
		model.addElement("Tất cả thời gian");
		model.addElement("Theo khoảng thời gian");
		cbb.setModel(model);
	}
	
	public void events() {
		ComboboxEvent();
		ChooserEvents();
	}
	public void ComboboxEvent() {
		cbbSelection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cbbSelection.getSelectedIndex()==0) {
					pnCenterContentSelectionSpinner.setVisible(false);
					rendererData();
				}
				else if (cbbSelection.getSelectedIndex()==1) {
					pnCenterContentSelectionSpinner.setVisible(true);
				}
			}
		});
	}
	public void ChooserEvents() {
		dcsDate.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				Date from= dcsDate.getDate();
				if(from==null) {
					Calendar calendar = Calendar.getInstance();
			        calendar.set(2000, Calendar.JANUARY, 1);
			        from = calendar.getTime();
				}
				Date to= dcsDate1.getDate();
				if(to == null) {
					to = new Date();
				}
				if(from.after(to)) {
					return;
				}
				changeValueByDate(from, to);
			}
		});
		dcsDate1.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				Date from= dcsDate.getDate();
				if(from==null) {
					Calendar calendar = Calendar.getInstance();
			        calendar.set(2000, Calendar.JANUARY, 1);
			        from = calendar.getTime();
				}
				Date to= dcsDate1.getDate();
				if(to == null) {
					to = new Date();
				}
				if(from.after(to)) {
					return;
				}
				changeValueByDate(from, to);
			}
		});
	}
	public void rendererData() {
//		lbCurrent.setText(thongKeCTL.countBorrowingDevice()+"");
//		lbDevice.setText(thongKeCTL.countBorrowedDevice()+"");
//		lbDone.setText(thongKeCTL.countHandledViolation()+"");
//		lbFee.setText(thongKeCTL.countFee()+"đ");
//		lbMember.setText(thongKeCTL.countMemberIntoMaterial()+"");
//		lbUnDone.setText(thongKeCTL.countHandlingViolation()+"");
//		lbViolation.setText(thongKeCTL.countViolation()+"");
	}
	public void changeValueByDate(Date from, Date to) {
//		lbCurrent.setText(thongKeCTL.countBorrowingDeviceOverTime(from, to)+"");
//		lbDevice.setText(thongKeCTL.countBorrowedDeviceOverTime(from, to)+"");
//		lbDone.setText(thongKeCTL.countHandledViolationOverTime(from, to)+"");
//		lbFee.setText(thongKeCTL.countFeeOverTime(from, to)+"đ");
//		lbMember.setText(thongKeCTL.countIntoMaterialOverTime(from, to)+"");
//		lbUnDone.setText(thongKeCTL.countHandlingViolationOverTime(from, to)+"");
//		lbViolation.setText(thongKeCTL.countViolationOverTime(from, to)+"");
	}

}
