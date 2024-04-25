package com.example.demo.View.HomePage;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import com.example.demo.View.ThanhVien.MemberView;
import com.example.demo.View.ThietBi.DeviceView;
import com.example.demo.View.ThongKe.StatisticView;
import com.example.demo.View.ViPham.HandleView;


@Component
public class HomePage extends JFrame {
//	components
	private JPanel pnNorth, pnCenter, pnSouth, pnWest, pnEast; // container
	private JPanel pnNorthContent, pnNorthProcess, pnNorthContentTittle, pnNorthContentUser; // North
	private JPanel pnWestContent, pnWesthandle; // west
	private JPanel pnCenterContent; // center

	private JLabel lbTittle, lbUserName, lbProcessHome, lbProcessFunc, lbProcessHandle; // north
	private ArrayList<JPanel> listPanel; // west
	private JButton btnHomePage, btnMember, btnDevice, btnHandle, btnStatistic; // west
	private ArrayList<JButton> listbtn;
	private JButton btnLogin;

//	styles 
	private String btnHover= "#95afc0";
	private String btnExit= "#dff9fb";
	private Font sgUI15 = new Font("Segoe UI", Font.PLAIN, 15);
	private Font sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
	private Font sgUI16b = new Font("Segoe UI", Font.BOLD, 16);
	private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
	private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 18);
	private Font tNR18b = new Font("Times New Roman", Font.BOLD, 18);
	private Color mainColor = Color.decode("#dff9fb");

//	Content
	private JPanel pnMember = new MemberView();
	private JPanel pnDevice = new DeviceView();
	private JPanel pnHandle = new HandleView();
	private JPanel pnStatistic = new StatisticView();

	ArrayList<Boolean> mouseClicked;

	public HomePage(String user) {
		setSize(1400, 800);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Phần mềm quản lý học liệu");
		setIconImage(new ImageIcon(getClass().getResource("/com/example/demo/View/images/material.png")).getImage());
		initComponent(user);
		styles();
		events();
		setVisible(true);
	}

	public void initComponent(String user) {
//		sub components

		lbProcessFunc = new JLabel();

		lbProcessHandle = new JLabel("/");

		lbProcessHome = new JLabel("Home");

		lbTittle = new JLabel("Learning Materials Management");
		ImageIcon iconLogo = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/material.png")).getImage()
				.getScaledInstance(80, 50, Image.SCALE_SMOOTH));
		lbTittle.setIcon(iconLogo);

		ImageIcon usericon = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/user.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		lbUserName = new JLabel(user);
		lbUserName.setIcon(usericon);

		ImageIcon deviceicon = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/device.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnDevice = new JButton("Quản lý thiết bị");
		btnDevice.setIcon(deviceicon);

		ImageIcon handleicon = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/handle.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnHandle = new JButton("Quản lý vi phạm");
		btnHandle.setIcon(handleicon);

		ImageIcon homeicon = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/home1.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnHomePage = new JButton("Trang chủ");
		btnHomePage.setIcon(homeicon);

		ImageIcon loginicon = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/logout.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnLogin = new JButton("Đăng xuất");
		btnLogin.setIcon(loginicon);

		ImageIcon membericon = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/member.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnMember = new JButton("Quản lý thành viên");
		btnMember.setIcon(membericon);

		ImageIcon statisticicon = new ImageIcon(new ImageIcon(getClass().getResource("/com/example/demo/View/images/statistic1.png"))
				.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		btnStatistic = new JButton("Thống kê");
		btnStatistic.setIcon(statisticicon);

		listbtn = new ArrayList<>();
		listbtn.add(btnHomePage);
		listbtn.add(btnMember);
		listbtn.add(btnDevice);
		listbtn.add(btnHandle);
		listbtn.add(btnStatistic);

//		of north content

		pnNorthContentTittle = new JPanel();
		pnNorthContentTittle.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		pnNorthContentTittle.add(lbTittle);

		pnNorthContentUser = new JPanel();
		pnNorthContentUser.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
		pnNorthContentUser.add(lbUserName);

//		content of north panel
		pnNorthContent = new JPanel();
		pnNorthContent.setLayout(new BorderLayout());
		pnNorthContent.add(pnNorthContentTittle, BorderLayout.CENTER);
		pnNorthContent.add(pnNorthContentUser, BorderLayout.EAST);

//		process of north panel
		pnNorthProcess = new JPanel();
		pnNorthProcess.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		pnNorthProcess.add(lbProcessHome);
		pnNorthProcess.add(lbProcessHandle);
		pnNorthProcess.add(lbProcessFunc);
		

//		content of west panel
		pnWestContent = new JPanel();
		pnWestContent.setLayout(new BoxLayout(pnWestContent, BoxLayout.Y_AXIS));
		listPanel = new ArrayList<>();
		mouseClicked = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			pnWestContent.add(listbtn.get(i));
			mouseClicked.add(false);
		}
//		

//		south of west panel
		pnWesthandle = new JPanel();
		pnWesthandle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		pnWesthandle.add(btnLogin);

//		content of center panel
		pnCenterContent = new JPanel();
		setDisplayContent(1);

//		north panel
		pnNorth = new JPanel();
		pnNorth.setLayout(new BorderLayout());
		pnNorth.add(pnNorthContent, BorderLayout.CENTER);
		pnNorth.add(pnNorthProcess, BorderLayout.SOUTH);

//		west panel
		pnWest = new JPanel();
		pnWest.setLayout(new BorderLayout());
		pnWest.add(pnWestContent, BorderLayout.CENTER);
		pnWest.add(pnWesthandle, BorderLayout.SOUTH);

//		center panel
		pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout(5, 5));
		pnCenter.add(pnCenterContent, BorderLayout.CENTER);

//		frame
		this.setLayout(new BorderLayout());
		this.add(pnNorth, BorderLayout.NORTH);
		this.add(pnWest, BorderLayout.WEST);
		this.add(pnCenter, BorderLayout.CENTER);
	}

	public void events() {

	}

	public void styles() {
		for (int i = 0; i < listbtn.size(); i++) {
			listbtn.get(i).setFocusPainted(false);
			listbtn.get(i).setBorder(new EmptyBorder(10, 10, 10, 10));
			listbtn.get(i).setPreferredSize(new Dimension(200, 45));
			listbtn.get(i).setMaximumSize(new Dimension(200, 45));
			listbtn.get(i).setFont(sgUI15b);
			listbtn.get(i).setHorizontalAlignment(SwingConstants.LEFT);
			listbtn.get(i).setBackground(mainColor);
			listbtn.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			pressedBtn();
//			if (mouseClicked.get(i) == false) {
//				hoverBtn(listbtn.get(i), 0);
//			}

		}

		btnLogin.setBackground(Color.decode("#7ed6df"));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnLogin.setFont(sgUI15b);
		btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hoverBtn(btnLogin, 1);

		lbTittle.setFont(tNR18b);
		lbProcessFunc.setFont(sgUI15);
		lbProcessFunc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbProcessHandle.setFont(sgUI15b);
		lbProcessHandle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbProcessHome.setFont(sgUI15b);
		lbProcessHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbUserName.setFont(sgUI16b);
		lbUserName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hoverLb(lbUserName);
		hoverLb(lbProcessFunc);
		hoverLb(lbProcessHandle);
		hoverLb(lbProcessHome);

		pnCenter.setBackground(Color.white);
		pnCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnNorth.setBackground(mainColor);
		pnNorthContent.setBackground(mainColor);
		pnNorthContentTittle.setBackground(mainColor);
		pnNorthContentUser.setBackground(mainColor);
		pnNorthProcess.setBackground(Color.decode("#c7ecee"));
		pnWest.setBackground(mainColor);
		pnWestContent.setBackground(mainColor);
		pnWesthandle.setBackground(mainColor);
	}

	public void hoverBtn(final JButton btn, int option) {
		if (option == 1) {
			btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {

					btn.setBackground(Color.decode("#95afc0"));

				}

				@Override
				public void mouseExited(MouseEvent e) {

					btn.setBackground(Color.decode("#7ed6df"));

				}
			});
		} else {
			btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {

					btn.setBackground(Color.decode("#95afc0"));

				}

				@Override
				public void mouseExited(MouseEvent e) {

					btn.setBackground(mainColor);

				}
			});
		}

	}

	public void hoverLb(final JLabel lb) {
		lb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lb.setForeground(Color.decode("#95afc0"));

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lb.setForeground(Color.black);

			}
		});
	}

	public void setDisplayContent(int option) {
		pnCenterContent.removeAll();
		pnCenterContent.revalidate();
		pnCenterContent.repaint();
		pnCenterContent.setLayout(new BorderLayout());
		switch (option) {
			case 1:
				JPanel a = new PanelHome(getWidth(), getHeight());
				pnCenterContent.setLayout(new BorderLayout());
				pnCenterContent.add(a, BorderLayout.CENTER);
				lbProcessFunc.setText("Trang chủ");
				break;
			case 2:
				pnCenterContent.add(pnMember, BorderLayout.CENTER);
				lbProcessFunc.setText("Quản lý thành viên");
				break;
			case 5:
				pnCenterContent.add(pnStatistic, BorderLayout.CENTER);
				lbProcessFunc.setText("Thống kê");
				break;
			case 4:
				pnCenterContent.add(pnHandle, BorderLayout.CENTER);
				lbProcessFunc.setText("Xử lý vi phạm");
				break;
			case 3:
				pnCenterContent.add(pnDevice, BorderLayout.CENTER);
				lbProcessFunc.setText("Quản lý thiết bị");
				break;
		}
	}

//	public void pressedBtn() {
//		for (int i = 0; i < listbtn.size(); i++) {
//			final int index = i;
//			listbtn.get(index).addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//
//					listbtn.get(index).setBackground(Color.decode("#95afc0"));
//					mouseClicked.set(index, true);
//					setDisplayContent(index + 1);
//					for (int j = 0; j < listbtn.size(); j++) {
//						if (j != index) {
//							listbtn.get(index).setBackground(mainColor);
//						}
//					}
//
//				}
//			});
//		}
//
//	}

	public void settingColor(JButton x, String colorLight, String colorDark, String colorPos) {
		setBackground();

		run(x, Color.decode(colorLight));
		x.setBackground(Color.decode(colorPos));
		revalidate();
		repaint();
	}

	public synchronized void run(JButton btn, Color color) {
		new Thread(() -> {
			btn.setLayout(null);
			JPanel pn = new JPanel();
			pn.setBackground(color);
			JPanel pn1 = new JPanel();
			pn1.setBackground(color);
			btn.add(pn);
			btn.add(pn1);
			for (int i = 0; i <= btn.getWidth() / 2; i++) {
				pn.setBounds(0, 0, btn.getWidth() / 2 - i, btn.getHeight());
				pn1.setBounds(btn.getWidth() / 2 + i, 0, btn.getWidth() / 2, btn.getHeight());
				repaint();
				try {

					Thread.sleep(1);
				} catch (InterruptedException e) {
				}
			}
			btn.remove(pn);
			btn.remove(pn1);
		}).start();
	}

	public void setBackground() {
		for (JButton x : listbtn) {

			x.setBackground(Color.decode(btnExit));

		}
	}

	public void pressedBtn() {
		for (JButton x : listbtn) {
			x.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == listbtn.get(0)) {
						settingColor(x, btnExit, "#FFFFFF", btnHover);
						setDisplayContent(1);
					} else if (e.getSource() == listbtn.get(1)) {
						settingColor(x, btnExit, "#FFFFFF", btnHover);
						setDisplayContent(2);
					} else if (e.getSource() == listbtn.get(2)) {
						setDisplayContent(3);
						settingColor(x, btnExit, "#FFFFFF", btnHover);
					} else if (e.getSource() == listbtn.get(3)) {
						setDisplayContent(4);
						settingColor(x, btnExit, "#FFFFFF", btnHover);
					} else if (e.getSource() == listbtn.get(4)) {
						setDisplayContent(5);
						settingColor(x, btnExit, "#FFFFFF", btnHover);
					} 
				}
			});
		}
	}

}
