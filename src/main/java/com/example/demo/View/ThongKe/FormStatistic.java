package com.example.demo.View.ThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;

import com.example.demo.View.Styles.Styles;



public class FormStatistic extends JDialog {
//	styles
	Styles style = new Styles();

//	MEMBER
	private JPanel pnTop, pnBot, pnTopContent, pnTopCBB, pnBotContent, pnBotCBB, pnBotDepartment, pnBotBranch;
	private ChartPanel pnChartTime, pnChartDepartment, pnChartBranch;
	private JFreeChart chartTime, chartDepartment, chartBranch;
	private JComboBox<String> cbbTop;

//	DEVICE
	private JPanel pnDeviceContent, pnDeviceCbb;
	private JComboBox<String> cbbYear, cbbMonth;
	private JFreeChart chartDevice;
	private ChartPanel pnChartDevice;

//	HANDLE
	private JPanel pnHandleTop, pnHandleBot, pnHandleBotNorth;
	private JFreeChart chartHandle;
	private ChartPanel pnChartHandle;
	
//	base chart title
	private final String titleTimeChart="Lượng sinh viên vào khu học liệu";
	private final String titleDepartmentChart="Lượng sinh viên thuộc các khoa";
	private final String titleBranchChart="Lượng sinh viên thuộc các ngành";
	private final String titleDeviceChart="Lượng đã được mượn";
	private final String titleTimeCurrentChart="Lượng đang được mượn";
	private final String titleHandleChart="Thống kê vi phạm";
	

	public FormStatistic(int option) {
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		setTitle("Biểu đồ thống kê");
		setIconImage(new ImageIcon(getClass().getResource("/com/example/demo/View/images/material.png")).getImage());
		switch (option) {
			case 1:
				initComponentsMember();
				break;
			case 2:
				initComponentsDevice();
				break;
			case 3:
				initComponentsCurrent();
				break;
			case 4:
				initComponentsHandle();
				break;
		}

		setVisible(true);
	}

	public void initComponentsMember() {
//		subcomponent

		cbbTop = new JComboBox<String>();
		cbbTop.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
		cbbTop.setBackground(Color.white);
		cbbTop.setFont(style.getSgUI13b());
		cbbTop.setPreferredSize(new Dimension(100, 30));
		cbbTop.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
				basicComboPopup.setBorder(style.getLineCB());
				return basicComboPopup;
			}
		});
		cbbTop.setBorder(style.getMatteBorderCB());
		rendererCbb(cbbTop,1);
		cbbTop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int year= Integer.parseInt(cbbTop.getSelectedItem().toString().split(" ")[1]);
				chartTime=createLineChart(titleTimeChart, "Month", "value", createDatasetTime(year));
				setColorChart(chartTime);
				pnChartTime.setChart(chartTime);
			}
		});

		
		cbbMonth = new JComboBox<String>();
		cbbMonth.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
		cbbMonth.setBackground(Color.white);
		cbbMonth.setFont(style.getSgUI13b());
		cbbMonth.setPreferredSize(new Dimension(100, 30));
		cbbMonth.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
				basicComboPopup.setBorder(style.getLineCB());
				return basicComboPopup;
			}
		});
		cbbMonth.setBorder(style.getMatteBorderCB());
		rendererCbb(cbbMonth, 2);

//		chart
		int year= Integer.parseInt(cbbTop.getSelectedItem().toString().split(" ")[1]);
		chartTime = ChartFactory.createLineChart(titleTimeChart, "Month", "value",
				createDatasetTime(year));
		setColorChart(chartTime);
		
		chartBranch = ChartFactory.createBarChart(titleBranchChart, "Branch", "value", createDatasetBranch());
		setColorChart(chartBranch);
		
		chartDepartment = ChartFactory.createBarChart(titleDepartmentChart, "Department", "value",
				createDatasetDepartment());
		setColorChart(chartDepartment);
		
//		chart pn
		pnChartBranch = new ChartPanel(chartBranch);
		pnChartBranch.setPreferredSize(new Dimension(450, 200));
		pnChartBranch.setBackground(Color.white);

		pnChartDepartment = new ChartPanel(chartDepartment);
		pnChartDepartment.setPreferredSize(new Dimension(450, 200));
		pnChartDepartment.setBackground(Color.white);

		pnChartTime = new ChartPanel(chartTime);
		pnChartTime.setPreferredSize(new Dimension(900, 350));
		pnChartTime.setBackground(Color.white);

//		topcontent
		pnTopContent = new JPanel();
		pnTopContent.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnTopContent.add(pnChartTime);
		pnTopContent.setBackground(Color.white);

//		topcbb
		pnTopCBB = new JPanel();
		pnTopCBB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnTopCBB.add(cbbTop);
		pnTopCBB.setBackground(Color.white);

//		top
		pnTop = new JPanel();
		pnTop.setLayout(new BorderLayout());
		pnTop.add(pnTopContent, BorderLayout.CENTER);
		pnTop.add(pnTopCBB, BorderLayout.SOUTH);
		pnTop.setBackground(Color.white);

//		botdepartment
		pnBotDepartment = new JPanel();
		pnBotDepartment.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		pnBotDepartment.add(pnChartDepartment);
		pnBotDepartment.setBackground(Color.white);

//		botbranch
		pnBotBranch = new JPanel();
		pnBotBranch.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		pnBotBranch.add(pnChartBranch);
		pnBotBranch.setBackground(Color.white);

//		botcontent
		pnBotContent = new JPanel();
		pnBotContent.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
		pnBotContent.add(pnBotDepartment);
		pnBotContent.add(pnBotBranch);
		pnBotContent.setBackground(Color.white);

//		botcbb
		pnBotCBB = new JPanel();
		pnBotCBB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
//		pnBotCBB.add(cbbMonth);
		pnBotCBB.setBackground(Color.white);

//		bot
		pnBot = new JPanel();
		pnBot.setLayout(new BorderLayout());
		pnBot.add(pnBotContent, BorderLayout.CENTER);
		pnBot.add(pnBotCBB, BorderLayout.SOUTH);
		pnBot.setBackground(Color.white);

//		container
		this.setLayout(new BorderLayout());
		this.add(pnTop, BorderLayout.CENTER);
		this.add(pnBot, BorderLayout.SOUTH);
	}

	public void initComponentsDevice() {
//		subcomponent
		
		cbbYear = new JComboBox<String>();
		cbbYear.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
		cbbYear.setBackground(Color.white);
		cbbYear.setFont(style.getSgUI13b());
		cbbYear.setPreferredSize(new Dimension(100, 30));
		cbbYear.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
				basicComboPopup.setBorder(style.getLineCB());
				return basicComboPopup;
			}
		});
		cbbYear.setBorder(style.getMatteBorderCB());
		rendererCbb(cbbYear, 3);
		cbbYear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int year1= Integer.parseInt(cbbYear.getSelectedItem().toString().split(" ")[1]);
				int month1= Integer.parseInt(cbbMonth.getSelectedItem().toString().split(" ")[1]);
				chartDevice=createBarChart(titleDeviceChart, "Thiết bị", "Số lượng", createDatasetDevice(year1 ,month1));
				setColorChart(chartDevice);
				pnChartDevice.setChart(chartDevice);
			}
		});
		
		cbbMonth = new JComboBox<String>();
		cbbMonth.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
		cbbMonth.setBackground(Color.white);
		cbbMonth.setFont(style.getSgUI13b());
		cbbMonth.setPreferredSize(new Dimension(100, 30));
		cbbMonth.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
				basicComboPopup.setBorder(style.getLineCB());
				return basicComboPopup;
			}
		});
		cbbMonth.setBorder(style.getMatteBorderCB());
		rendererCbb(cbbMonth, 2);
		cbbMonth.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int year1= Integer.parseInt(cbbYear.getSelectedItem().toString().split(" ")[1]);
				int month1= Integer.parseInt(cbbMonth.getSelectedItem().toString().split(" ")[1]);
				chartDevice=createBarChart(titleDeviceChart, "Thiết bị", "Số lượng", createDatasetDevice(year1 ,month1));
				setColorChart(chartDevice);
				pnChartDevice.setChart(chartDevice);
			}
		});
		int year= Integer.parseInt(cbbYear.getSelectedItem().toString().split(" ")[1]);
		int month= Integer.parseInt(cbbMonth.getSelectedItem().toString().split(" ")[1]);
		chartDevice = ChartFactory.createBarChart(titleDeviceChart, "Thiết bị", "Số lượng",
				createDatasetDevice(year, month));
		setColorChart(chartDevice);

		pnChartDevice = new ChartPanel(chartDevice);
		pnChartDevice.setBackground(Color.white);

//		pn device
		pnDeviceContent = new JPanel();
		pnDeviceContent.setLayout(new BorderLayout());
		pnDeviceContent.add(pnChartDevice, BorderLayout.CENTER);
		pnDeviceContent.setBackground(Color.white);

//		pn cbb
		pnDeviceCbb = new JPanel();
		pnDeviceCbb.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		pnDeviceCbb.add(cbbYear);
		pnDeviceCbb.add(cbbMonth);
		pnDeviceCbb.setBackground(Color.white);

		this.setLayout(new BorderLayout());
		this.add(pnDeviceContent, BorderLayout.CENTER);
		this.add(pnDeviceCbb, BorderLayout.SOUTH);

	}

	public void initComponentsCurrent() {
//		subcomponent
		
		cbbYear = new JComboBox<String>();
		cbbYear.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
		cbbYear.setBackground(Color.white);
		cbbYear.setFont(style.getSgUI13b());
		cbbYear.setPreferredSize(new Dimension(100, 30));
		cbbYear.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
				basicComboPopup.setBorder(style.getLineCB());
				return basicComboPopup;
			}
		});
		cbbYear.setBorder(style.getMatteBorderCB());
		rendererCbb(cbbYear, 3);
		cbbYear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int year1= Integer.parseInt(cbbYear.getSelectedItem().toString().split(" ")[1]);
				int month1= Integer.parseInt(cbbMonth.getSelectedItem().toString().split(" ")[1]);
				chartDevice=createBarChart(titleTimeCurrentChart, "Thiết bị", "Số lượng", createDatasetCurrent(year1 ,month1));
				setColorChart(chartDevice);
				pnChartDevice.setChart(chartDevice);
			}
		});
		
		cbbMonth = new JComboBox<String>();
		cbbMonth.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
		cbbMonth.setBackground(Color.white);
		cbbMonth.setFont(style.getSgUI13b());
		cbbMonth.setPreferredSize(new Dimension(100, 30));
		cbbMonth.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
				basicComboPopup.setBorder(style.getLineCB());
				return basicComboPopup;
			}
		});
		cbbMonth.setBorder(style.getMatteBorderCB());
		rendererCbb(cbbMonth, 2);
		cbbMonth.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int year1= Integer.parseInt(cbbYear.getSelectedItem().toString().split(" ")[1]);
				int month1= Integer.parseInt(cbbMonth.getSelectedItem().toString().split(" ")[1]);
				chartDevice=createBarChart(titleTimeCurrentChart, "Thiết bị", "Số lượng", createDatasetCurrent(year1 ,month1));
				setColorChart(chartDevice);
				pnChartDevice.setChart(chartDevice);
			}
		});
		int year= Integer.parseInt(cbbYear.getSelectedItem().toString().split(" ")[1]);
		int month= Integer.parseInt(cbbMonth.getSelectedItem().toString().split(" ")[1]);
		chartDevice = ChartFactory.createBarChart(titleTimeCurrentChart, "Thiết bị", "Số lượng",
				createDatasetCurrent(year, month));
		setColorChart(chartDevice);
		pnChartDevice = new ChartPanel(chartDevice);
		pnChartDevice.setBackground(Color.white);

//		pn device
		pnDeviceContent = new JPanel();
		pnDeviceContent.setLayout(new BorderLayout());
		pnDeviceContent.add(pnChartDevice, BorderLayout.CENTER);
		pnDeviceContent.setBackground(Color.white);
		
//		pn cbb
		pnDeviceCbb = new JPanel();
		pnDeviceCbb.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		pnDeviceCbb.add(cbbYear);
		pnDeviceCbb.add(cbbMonth);
		pnDeviceCbb.setBackground(Color.white);

		this.setLayout(new BorderLayout());
		this.add(pnDeviceContent, BorderLayout.CENTER);
		this.add(pnDeviceCbb, BorderLayout.SOUTH);

	}

	public void initComponentsHandle() {
		
		cbbYear = new JComboBox<String>();
		cbbYear.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
		cbbYear.setBackground(Color.white);
		cbbYear.setFont(style.getSgUI13b());
		cbbYear.setPreferredSize(new Dimension(100, 30));
		cbbYear.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
				basicComboPopup.setBorder(style.getLineCB());
				return basicComboPopup;
			}
		});
		cbbYear.setBorder(style.getMatteBorderCB());
		rendererCbb(cbbYear, 3);
		cbbYear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int year1= Integer.parseInt(cbbYear.getSelectedItem().toString().split(" ")[1]);
				int month1= Integer.parseInt(cbbMonth.getSelectedItem().toString().split(" ")[1]);
				chartHandle=createBarChart(titleHandleChart, "Xử lý vi phạm", "Số lượng", createDatasetHandle(year1 ,month1));
				setColorChart(chartHandle);
				pnChartHandle.setChart(chartHandle);
			}
		});
		
		cbbMonth = new JComboBox<String>();
		cbbMonth.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
		cbbMonth.setBackground(Color.white);
		cbbMonth.setFont(style.getSgUI13b());
		cbbMonth.setPreferredSize(new Dimension(100, 30));
		cbbMonth.setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
				basicComboPopup.setBorder(style.getLineCB());
				return basicComboPopup;
			}
		});
		cbbMonth.setBorder(style.getMatteBorderCB());
		rendererCbb(cbbMonth, 2);
		cbbMonth.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int year1= Integer.parseInt(cbbYear.getSelectedItem().toString().split(" ")[1]);
				int month1= Integer.parseInt(cbbMonth.getSelectedItem().toString().split(" ")[1]);
				chartHandle=createBarChart(titleHandleChart, "Xử lý vi phạm", "Số lượng", createDatasetHandle(year1 ,month1));
				setColorChart(chartHandle);
				pnChartHandle.setChart(chartHandle);
			}
		});
		int year= Integer.parseInt(cbbYear.getSelectedItem().toString().split(" ")[1]);
		int month= Integer.parseInt(cbbMonth.getSelectedItem().toString().split(" ")[1]);
		chartHandle = ChartFactory.createBarChart(titleHandleChart, "Xử lý vi phạm", "Số lượng",
				createDatasetHandle(year, month));
		setColorChart(chartHandle);
		pnChartHandle = new ChartPanel(chartHandle);
		pnChartHandle.setBackground(Color.white);
//		top
		pnHandleTop = new JPanel();
		pnHandleTop.setLayout(new BorderLayout());
		pnHandleTop.add(pnChartHandle, BorderLayout.CENTER);
		pnHandleTop.setBackground(Color.white);

//		bot north
		pnHandleBotNorth = new JPanel();
		pnHandleBotNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		pnHandleBotNorth.add(cbbYear);
		pnHandleBotNorth.add(cbbMonth);
		pnHandleBotNorth.setBackground(Color.white);


//		bot
		pnHandleBot = new JPanel();
		pnHandleBot.setLayout(new BorderLayout());
		pnHandleBot.add(pnHandleBotNorth, BorderLayout.CENTER);
		pnHandleBot.setBackground(Color.white);

//		container
		this.setLayout(new BorderLayout());
		this.add(pnHandleTop, BorderLayout.CENTER);
		this.add(pnHandleBot, BorderLayout.SOUTH);

	}

//	Member
	private DefaultCategoryDataset createDatasetTime(int year) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < 12; i++) {
//			dataset.addValue(StatisticView.thongKeCTL.listCountTime(year).get(i), "Students", (i + 1)+"");
		}
		return dataset;
	}

	private DefaultCategoryDataset createDatasetBranch() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// Insert data for each department
//		for(int i =0;i<StatisticView.thongKeCTL.listBranch().size();i++) {
//			dataset.addValue(StatisticView.thongKeCTL.listCountBranch().get(i), StatisticView.thongKeCTL.listBranch().get(i), StatisticView.thongKeCTL.listBranch().get(i));
//		}

		return dataset;
	}

	private DefaultCategoryDataset createDatasetDepartment() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// Insert data for each department
//		for(int i =0;i<StatisticView.thongKeCTL.listDeparment().size();i++) {
//			dataset.addValue(StatisticView.thongKeCTL.listCountDeparment().get(i), StatisticView.thongKeCTL.listDeparment().get(i), StatisticView.thongKeCTL.listDeparment().get(i));
//		}
		return dataset;
	}

	public void rendererCbb(JComboBox<String> cbb, int option) {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		switch (option) {
			case 1: // cbb năm
				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				for (int i = year; i > year - 5; i--) {
					model.addElement("Năm " + i);
				}
				break;
			case 2:// cbb tháng
				for (int i = 1; i < 13; i++) {
					model.addElement("Tháng "+i);
				}
				break;
			case 3:// cbb đặc biệt
				Calendar calendar1 = Calendar.getInstance();
				int year1 = calendar1.get(Calendar.YEAR);
				for (int i = year1; i > year1 - 5; i--) {
					model.addElement("Năm " + i);
				}
				break;
		}

		cbb.setModel(model);
	}

//	DEVICE
	private DefaultCategoryDataset createDatasetDevice(int year, int month) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		for(int i =0;i<StatisticView.thongKeCTL.listDevice().size();i++) {
//			dataset.addValue(StatisticView.thongKeCTL.listCountDevice(year, month).get(i), StatisticView.thongKeCTL.listDevice().get(i), StatisticView.thongKeCTL.listDevice().get(i));
//		}
		return dataset;
	}

//	CURRENT
	private DefaultCategoryDataset createDatasetCurrent(int year, int month) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

//		for(int i =0;i<StatisticView.thongKeCTL.listDevice().size();i++) {
//			dataset.addValue(StatisticView.thongKeCTL.listCountCurrent(year, month).get(i), StatisticView.thongKeCTL.listDevice().get(i), StatisticView.thongKeCTL.listDevice().get(i));
//		}
		return dataset;
	}

//	HANDLE
	private DefaultCategoryDataset createDatasetHandle(int year, int month) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

//		for(int i =0;i<StatisticView.thongKeCTL.listHandle().size();i++) {
//			dataset.addValue(StatisticView.thongKeCTL.listCountHandle(year, month).get(i), StatisticView.thongKeCTL.listHandle().get(i), StatisticView.thongKeCTL.listHandle().get(i));
//		}
		return dataset;
	}
	
	public void setColorChart(JFreeChart chart) {
		CategoryPlot plot = chart.getCategoryPlot();

        // Thiết lập màu nền cho plot
        plot.setBackgroundPaint(Color.white);
	}
	
	public JFreeChart createLineChart(String title, String bot, String left, DefaultCategoryDataset dataset) {
		JFreeChart chart =ChartFactory.createLineChart(title, bot, left,
				dataset);
		return chart;
	}
	
	public JFreeChart createBarChart(String title, String bot, String left, DefaultCategoryDataset dataset) {
		JFreeChart chart=ChartFactory.createBarChart(title, bot, left,
				dataset);
		return chart;
	}
	
	
}
