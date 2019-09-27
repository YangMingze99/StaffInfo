package com.artisan.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;


import com.artisan.dao.ClassDao;
import com.artisan.dao.SigninDao;

import com.artisan.model.Signin;
import com.artisan.model.Staff;
import com.artisan.model.StaffClass;
import com.artisan.util.Chooser;
import com.artisan.util.DateFormatUtil;

public class SigninFrm extends JInternalFrame {
	private JTextField signinDateTextField;
	private JTable signinTable;
	private JComboBox signinSelectClassComboBox;
	private JComboBox searchSelectClassComboBox;
	private List<StaffClass> staffClassList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SigninFrm frame = new SigninFrm();
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
	public SigninFrm() {
		setClosable(true);                     /* 内部窗口关闭摁纽*/
		setIconifiable(true);
		setFrameIcon(new ImageIcon(SigninFrm.class.getResource("/images/signup.png")));
		setTitle("\u7B7E\u5230");
		setBounds(100, 100, 850, 583);
		
		JLabel label = new JLabel("\u90E8\u95E8\uFF1A");
		label.setIcon(new ImageIcon(SigninFrm.class.getResource("/images/\u90E8\u95E8.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		signinSelectClassComboBox = new JComboBox();
		signinSelectClassComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton signinButton = new JButton("\u7B7E\u5230");
		signinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addSigninAct(ae);
			}
		});
		signinButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		signinButton.setIcon(new ImageIcon(SigninFrm.class.getResource("/images/signup.png")));
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(174)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(signinSelectClassComboBox, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addGap(99)
							.addComponent(signinButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 748, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(signinSelectClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addComponent(signinButton)))
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u90E8\u95E8\uFF1A");
		label_1.setIcon(new ImageIcon(SigninFrm.class.getResource("/images/\u90E8\u95E8.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		searchSelectClassComboBox = new JComboBox();
		searchSelectClassComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u65E5\u671F\uFF1A");
		label_2.setIcon(new ImageIcon(SigninFrm.class.getResource("/images/\u65E5\u5386.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		signinDateTextField = new JTextField();
		signinDateTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		signinDateTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchAct(ae);
			}
		});
		searchButton.setIcon(new ImageIcon(SigninFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchSelectClassComboBox, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addGap(71)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(signinDateTextField, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(searchButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(57)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(28)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addComponent(searchSelectClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(28)
							.addComponent(label_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(26)
							.addComponent(signinDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(26)
							.addComponent(searchButton)))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		
		signinTable = new JTable();
		signinTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7B7E\u5230ID", "\u5458\u5DE5\u59D3\u540D", "\u90E8\u95E8\u540D\u79F0", "\u7B7E\u5230\u65E5\u671F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(signinTable);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		setStaffClassInfo();
		setAuthority();
		initTable();
		Chooser.getInstance().register(signinDateTextField);
	}

	protected void searchAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		Staff staff = (Staff)MainFrm.userObject;
		StaffClass sc = (StaffClass)signinSelectClassComboBox.getSelectedItem();
		String dateString = signinDateTextField.getText().toString();
		Signin signin = new Signin();
		signin.setStaff_id(staff.getId());
		signin.setClass_id(sc.getId());
		signin.setSignin_date(dateString);
		getSigninedList(signin);
	}

	protected void addSigninAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		Staff staff = (Staff)MainFrm.userObject;
		StaffClass sc = (StaffClass)signinSelectClassComboBox.getSelectedItem();
		String dateString = DateFormatUtil.getDateString(new Date(System.currentTimeMillis()), "yyyy-MM-dd");
		Signin signin = new Signin();
		SigninDao signinDao = new SigninDao();
		signin.setStaff_id(staff.getId());
		signin.setClass_id(sc.getId());
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
		signinDao.closeDao();
		initTable();
	}
	
	private void setStaffClassInfo(){   
		ClassDao classDao = new ClassDao();
		if("员工".equals(MainFrm.userType.getName())) {
		staffClassList = classDao.getClassList(new StaffClass());
//		Staff staff = (Staff)MainFrm.userObject;		
		for (StaffClass sc : staffClassList) { //把部门信息都放到下拉列表去！
			signinSelectClassComboBox.addItem(sc);
			searchSelectClassComboBox.addItem(sc);
			}
		}
	}
	
	private String getClassNameById (int id) {
		for (StaffClass sc : staffClassList) {
			if(sc.getId() == id)
				return sc.getName();
		}
		return "";
	}
	private void getSigninedList(Signin signin){
		Staff staff = (Staff)MainFrm.userObject;
		SigninDao signinDao = new SigninDao();
		List<Signin> getSigninList = signinDao.getSigninList(signin);
		DefaultTableModel dft = (DefaultTableModel) signinTable.getModel();
		dft.setRowCount(0);
		for (Signin s : getSigninList) {
			Vector v = new Vector();
			v.add(s.getId());
			v.add(staff.getName());
			v.add(getClassNameById(s.getClass_id()));
			v.add(s.getSignin_date());
			dft.addRow(v);
		}
		signinDao.closeDao();
	}
	
	private void setAuthority() {
		if("员工".equals(MainFrm.userType.getName())) {
			Staff s = (Staff)MainFrm.userObject;
			for(int i=0;i<signinSelectClassComboBox.getItemCount();i++)
			{
				StaffClass sc = (StaffClass) signinSelectClassComboBox.getItemAt(i);
				if(sc.getId() == s.getClassId()) {
					signinSelectClassComboBox.setSelectedIndex(i);
					break;
				}
			}
			signinSelectClassComboBox.setEnabled(false);
			
			for(int i=0;i<searchSelectClassComboBox.getItemCount();i++)
			{
				StaffClass sc = (StaffClass) searchSelectClassComboBox.getItemAt(i);
				if(sc.getId() == s.getClassId()) {
					searchSelectClassComboBox.setSelectedIndex(i);
					break;
				}
			}
			searchSelectClassComboBox.setEnabled(false);			
		}
	}
	
	
	private void initTable(){
		Staff staff = (Staff)MainFrm.userObject;
		Signin signin = new Signin();
		signin.setStaff_id(staff.getId());
		getSigninedList(signin);
	}
}
