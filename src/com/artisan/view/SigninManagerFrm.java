package com.artisan.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.artisan.dao.ClassDao;

import com.artisan.dao.SigninDao;
import com.artisan.dao.StaffDao;
import com.artisan.model.Signin;
import com.artisan.model.Staff;
import com.artisan.model.StaffClass;
import com.artisan.util.DateFormatUtil;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SigninManagerFrm extends JInternalFrame {
	private JTable signinedListTable;
	private JComboBox staffClassSearchComboBox;
	private List<StaffClass> staffClassList;
	private JComboBox staffNameSearchComboBox;
	private List<Staff> getStaffList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SigninManagerFrm frame = new SigninManagerFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SigninManagerFrm() {
		setClosable(true);                     /* 内部窗口关闭摁纽*/
		setIconifiable(true);
		setFrameIcon(new ImageIcon(SigninManagerFrm.class.getResource("/images/signup.png")));
		setTitle("\u7B7E\u5230\u8003\u52E4\u7BA1\u7406");
		setBounds(100, 100, 900, 599);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label.setIcon(new ImageIcon(SigninManagerFrm.class.getResource("/images/\u5458\u5DE5\u5217\u8868.png")));
		
		JLabel label_1 = new JLabel("\u6240\u5C5E\u90E8\u95E8\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_1.setIcon(new ImageIcon(SigninManagerFrm.class.getResource("/images/\u90E8\u95E8.png")));
		
		staffClassSearchComboBox = new JComboBox();
		staffClassSearchComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				classChangeAct(ie);
			}
		});
		staffClassSearchComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton signinAddButton = new JButton("\u8003\u52E4\u7B7E\u5230");
		signinAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addSigninAct(ae);
			}
		});
		signinAddButton.setIcon(new ImageIcon(SigninManagerFrm.class.getResource("/images/\u786E\u8BA4.png")));
		signinAddButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		
		JButton signinDeleteButton = new JButton("\u6DFB\u52A0\u7F3A\u52E4");
		signinDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteSigninAct(ae);
			}
		});
		signinDeleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		signinDeleteButton.setIcon(new ImageIcon(SigninManagerFrm.class.getResource("/images/\u65F7\u5DE5.png")));
		
		staffNameSearchComboBox = new JComboBox();
		staffNameSearchComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				staffChangedAct(ie);
			}
		});
		staffNameSearchComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(47, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(97)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(staffNameSearchComboBox, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(staffClassSearchComboBox, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(signinDeleteButton)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(signinAddButton)
							.addGap(113))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(staffNameSearchComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(signinAddButton)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(label_1))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(signinDeleteButton))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(staffClassSearchComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(8)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		
		signinedListTable = new JTable();
		signinedListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7B7E\u5230ID", "\u5458\u5DE5\u59D3\u540D", "\u6240\u5C5E\u90E8\u95E8", "\u7B7E\u5230\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(signinedListTable);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		setClassCombox();
		setNameCombox();
		setTable();
	}



	protected void deleteSigninAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "确定删除签到信息么？") != JOptionPane.OK_OPTION)return;
		int row = signinedListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请先选择一行数据！");
			return;
		}
		int attendanceId = Integer.parseInt(signinedListTable.getValueAt(row, 0).toString());
		SigninDao attendanceDao = new SigninDao();
		if(attendanceDao.delete(attendanceId)){
			JOptionPane.showMessageDialog(this, "成功删除签到信息！");
		}else{
			JOptionPane.showMessageDialog(this, "操作失败！");
		}
		setTable();
	}

	protected void staffChangedAct(ItemEvent ie) {
		// TODO Auto-generated method stub
		if(ie.getStateChange() == ItemEvent.SELECTED){
			setTable();
		}
	}

	protected void addSigninAct(ActionEvent ae) {
			// TODO Auto-generated method stub
		  	Staff staff = new Staff();
		  	StaffClass staffClass =new StaffClass();
		  	staff.setName(staffNameSearchComboBox.getSelectedItem().toString());
		  	staffClass.setName(staffClassSearchComboBox.getSelectedItem().toString());
			String dateString = DateFormatUtil.getDateString(new Date(System.currentTimeMillis()), "yyyy-MM-dd");
			Signin signin = new Signin();
			SigninDao signinDao = new SigninDao();
			signin.setStaff_id(getStaffIdByName(staff.getName()));
			signin.setClass_id(getClassIdByClassName(staffClass.getName()));
			signin.setSignin_date(dateString);
			if(signinDao.isSignined(signin)) {
				JOptionPane.showMessageDialog(this, "请勿重复签到");
				return;
			}
			if(signinDao.addSignin(signin)) {
				JOptionPane.showMessageDialog(this,"签到成功");
			}else {
				JOptionPane.showMessageDialog(this,"签到失败");
			}
			setTable();
			signinDao.closeDao();
	}


	
	protected void classChangeAct(ItemEvent ie) {
		// TODO Auto-generated method stub
		if(ie.getStateChange() == ItemEvent.SELECTED){
			setNameCombox();
		}
	}

	
	private String getClassNameById (int id) {
		for (StaffClass sc : staffClassList) {
			if(sc.getId() == id)
				return sc.getName();
		}
		return "";
	}
	
	private String getStaffNameById (int id) {
		for (Staff s : getStaffList) {
			if(s.getId() == id)
				return s.getName();
		}
		return "";
	}
	private int getStaffIdByName (String staffname) {
		for (Staff s : getStaffList) {
			if(s.getName() .equals(staffname))
				return s.getId();
		}
		return -1;
	}
	
	private int getClassIdByClassName(String classname) {
		for (StaffClass sc : staffClassList) {
			if(sc.getName() .equals(classname))
				return sc.getId();
		}
		return -1;
	}
	private void setNameCombox(){                                       //部门对应员工
		staffNameSearchComboBox.removeAllItems();
		StaffDao staffDao = new StaffDao();
		getStaffList = staffDao.getStaffList(new Staff());
		StaffClass staffClass = new StaffClass();
		staffDao.closeDao();
		staffClass.setName(staffClassSearchComboBox.getSelectedItem().toString());
		staffClass.setId(getClassIdByClassName(staffClass.getName()));
		for (Staff staff : getStaffList) {
			if(staff.getClassId() == staffClass.getId())
				staffNameSearchComboBox.addItem(staff.getName());
		}
	}
	
	private List<StaffClass> selectedStaffClassList(StaffClass staffClass){
		ClassDao cd = new ClassDao();
		List<StaffClass> selectedCourseStudentList = cd.getClassList(staffClass);
		return selectedCourseStudentList;
	}

	private void setClassCombox(){                                      //部门combox
		SigninDao signinDao = new SigninDao();
		ClassDao classDao = new ClassDao();
		staffClassList = classDao.getClassList(new StaffClass());
		classDao.closeDao();
		for (StaffClass sc : staffClassList) 
			staffClassSearchComboBox.addItem(sc);
	}
		
	private void setTable() {
		//Staff staff = staffNameSearchComboBox.getSelectedItem();
		Staff staff = new Staff();
		staff.setName(staffNameSearchComboBox.getSelectedItem().toString());
		DefaultTableModel dft = (DefaultTableModel) signinedListTable.getModel();  //default模型
		dft.setRowCount(0);//清空列表
		Signin signin = new Signin();
		SigninDao sd = new SigninDao();
		signin.setStaff_id(staff.getId());
		List<Signin> getSigninList = sd.getSigninList(signin);
		for (Signin s : getSigninList) {
			Vector v = new Vector();                                //Vector可实现自动增长的对象数组
			v.add(s.getId());
			v.add(getStaffNameById(s.getStaff_id()));
			v.add(getClassNameById(s.getClass_id()));
			v.add(s.getSignin_date());
			dft.addRow(v);                                          //v给模型 按顺序添加列
		}
		sd.closeDao();
	}
	
	
	private void setAuthority() {
		
	}
}
