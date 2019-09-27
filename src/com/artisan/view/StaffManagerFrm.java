package com.artisan.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.artisan.dao.ClassDao;
import com.artisan.dao.StaffDao;
import com.artisan.model.Staff;
import com.artisan.model.StaffClass;
import com.artisan.util.StringUtil;

import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StaffManagerFrm extends JInternalFrame {
	private JTable staffListTable;
	private JTextField searchStaffNameTextField;
	private JTextField editStaffNameTextField;
	private JTextField editStaffAgeTextField;
	private JTextField editStaffPasswordTextField;
	private JComboBox searchStaffComboBox;
	private List<StaffClass> staffClassList;
	private JComboBox editStaffClassComboBox;
	private ButtonGroup editSexButtonGroup;
	private JRadioButton editStaffSexManRadioButton;
	private JRadioButton editStaffSexWomanRadioButton;
	private JButton deleteStaffButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffManagerFrm frame = new StaffManagerFrm();
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
	public StaffManagerFrm() {
		setFrameIcon(new ImageIcon(StaffManagerFrm.class.getResource("/images/\u5458\u5DE5\u7BA1\u7406.png")));
		setClosable(true);                     /* 内部窗口关闭摁纽*/
		setIconifiable(true);
		setTitle("\u5458\u5DE5\u4FE1\u606F\u7BA1\u7406\u754C\u9762");
		setBounds(100, 100, 857, 626);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label.setIcon(new ImageIcon(StaffManagerFrm.class.getResource("/images/test.png")));
		
		searchStaffNameTextField = new JTextField();
		searchStaffNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u786E\u5B9A");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchStaff(ae);
			}
		});
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		searchButton.setIcon(new ImageIcon(StaffManagerFrm.class.getResource("/images/\u786E\u8BA4.png")));
		
		searchStaffComboBox = new JComboBox();
		searchStaffComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		editStaffNameTextField = new JTextField();
		editStaffNameTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		editStaffNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		JLabel label_3 = new JLabel("\u5E74\u9F84\uFF1A");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		editStaffAgeTextField = new JTextField();
		editStaffAgeTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		editStaffAgeTextField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u6240\u5C5E\u90E8\u95E8\uFF1A");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		JLabel label_5 = new JLabel("\u5BC6\u7801\uFF1A");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		editStaffPasswordTextField = new JTextField();
		editStaffPasswordTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		editStaffPasswordTextField.setColumns(10);
		
		JLabel label_6 = new JLabel("\u6240\u5C5E\u90E8\u95E8\uFF1A");
		label_6.setIcon(new ImageIcon(StaffManagerFrm.class.getResource("/images/\u90E8\u95E8.png")));
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		editSexButtonGroup = new ButtonGroup();
		editStaffSexManRadioButton = new JRadioButton("\u7537");
		editStaffSexManRadioButton.setSelected(true);
		editStaffSexManRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editStaffSexWomanRadioButton = new JRadioButton("\u5973");
		editStaffSexWomanRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editSexButtonGroup.add(editStaffSexManRadioButton);
		editSexButtonGroup.add(editStaffSexWomanRadioButton);
			
		editStaffClassComboBox = new JComboBox();
		editStaffClassComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEditAct(ae);
			}
		});
		submitEditButton.setIcon(new ImageIcon(StaffManagerFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		deleteStaffButton = new JButton("\u786E\u8BA4\u5220\u9664");
		deleteStaffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteStaff(ae);
			}
		});
		deleteStaffButton.setIcon(new ImageIcon(StaffManagerFrm.class.getResource("/images/\u5220\u9664.png")));
		deleteStaffButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchStaffNameTextField, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(label_6)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchStaffComboBox, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(searchButton))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 791, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(34)
									.addComponent(label_1)
									.addGap(1)
									.addComponent(editStaffNameTextField, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editStaffClassComboBox, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
									.addGap(78))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(33)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_2)
											.addGap(1)
											.addComponent(editStaffSexManRadioButton)
											.addGap(6)
											.addComponent(editStaffSexWomanRadioButton)
											.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
											.addComponent(label_5)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(editStaffPasswordTextField, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_3)
											.addGap(2)
											.addComponent(editStaffAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(70)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(submitEditButton)
								.addComponent(deleteStaffButton))
							.addGap(272)))
					.addGap(24))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(searchStaffNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(searchStaffComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_6)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(searchButton)))
					.addGap(47)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(label_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(editStaffNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(label_4)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(21)
											.addComponent(label_2))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											.addComponent(editStaffSexManRadioButton)))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(editStaffSexWomanRadioButton)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(20)
									.addComponent(label_3))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(15)
									.addComponent(editStaffAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(60))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(label_5)))
					.addGap(2))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(464)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(editStaffClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitEditButton))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(editStaffPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteStaffButton))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		
		staffListTable = new JTable();
		staffListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedTableRow(e);
			}
		});
		staffListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5458\u5DE5\u5DE5\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u6240\u5C5E\u90E8\u95E8", "\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(staffListTable);
		getContentPane().setLayout(groupLayout);
		setStaffClassInfo();
		setTable(new Staff());
		setAuthority();
	}
	
	protected void submitEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String staffName = editStaffNameTextField.getText().toString();
		String staffPassword = editStaffPasswordTextField.getText().toString();
		String staffAge= editStaffAgeTextField.getText().toString();
		int row = staffListTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选中要更新的员工信息");
			return;
		}
		if(StringUtil.isEmpty(staffName)) {
			JOptionPane.showMessageDialog(this, "姓名不可以为空");	
			return;
		}
		if(StringUtil.isEmpty(staffPassword)) {
			JOptionPane.showMessageDialog(this, "密码不可以为空");	
			return;
		}
		if(StringUtil.isEmpty(staffAge)) {
			JOptionPane.showMessageDialog(this, "年龄不可以为空");	
			return;
		}
		
		Staff staff = new Staff();
		staff.setId(Integer.parseInt(staffListTable.getValueAt(row, 0).toString()));
		staff.setName(staffName);
		staff.setAge(staffAge);
		staff.setPassword(staffPassword);
		StaffClass sc = (StaffClass)editStaffClassComboBox.getSelectedItem();
		staff.setClassId(sc.getId());
		if(editStaffSexManRadioButton.isSelected()) staff.setSex(editStaffSexManRadioButton.getText().toString());
		if(editStaffSexWomanRadioButton.isSelected()) staff.setSex(editStaffSexWomanRadioButton.getText().toString());
		StaffDao staffDao = new StaffDao();
		if(staffDao.update(staff)) {
			JOptionPane.showMessageDialog(this, "更新数据成功！");
		}else {
			JOptionPane.showMessageDialog(this, "更新数据失败！");
		}
		setTable(new Staff());                                                          //成功失败都必须刷新
		staffDao.closeDao();
	}

	protected void selectedTableRow(MouseEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) staffListTable.getModel();
		editStaffNameTextField.setText(dft.getValueAt(staffListTable.getSelectedRow(), 1).toString());
		String sex = dft.getValueAt(staffListTable.getSelectedRow(), 2).toString();
		editStaffAgeTextField.setText(dft.getValueAt(staffListTable.getSelectedRow(), 3).toString());
		String className = dft.getValueAt(staffListTable.getSelectedRow(), 4).toString();
		editStaffPasswordTextField.setText(dft.getValueAt(staffListTable.getSelectedRow(), 5).toString());
		for(int i=0;i<editStaffClassComboBox.getItemCount();i++) {
			StaffClass sc = (StaffClass)editStaffClassComboBox.getItemAt(i);
			if(className.equals(sc.getName())) {
				editStaffClassComboBox.setSelectedIndex(i);
			}
		}
		editSexButtonGroup.clearSelection();
		if(sex.equals(editStaffSexManRadioButton.getText()))
			editStaffSexManRadioButton.setSelected(true);
		if(sex.equals(editStaffSexWomanRadioButton.getText()))
			editStaffSexWomanRadioButton.setSelected(true);
	}
	
	protected void deleteStaff(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = staffListTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选中要删除的员工信息");
			return;
		}
		StaffDao staffDao = new StaffDao();
		if(staffDao.delete(Integer.parseInt(staffListTable.getValueAt(row, 0).toString()))) {
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		setTable(new Staff());                                                          //成功失败都必须刷新
		staffDao.closeDao();
	}

	protected void searchStaff(ActionEvent ae) {
		// TODO Auto-generated method stub
		Staff staff = new Staff();
		staff.setName(searchStaffNameTextField.getText().toString());
		StaffClass sc = (StaffClass)searchStaffComboBox.getSelectedItem();
		staff.setClassId(sc.getId());
		setTable(staff);
	}

	private void setTable(Staff staff) {
		if("员工".equals(MainFrm.userType.getName())) {
			Staff s = (Staff)MainFrm.userObject;
			staff.setName(s.getName());
		}
		DefaultTableModel dft = (DefaultTableModel) staffListTable.getModel();  //default模型
		dft.setRowCount(0);             										//清空列表
		StaffDao staffDao = new StaffDao();
		List<Staff> staffList = staffDao.getStaffList(staff);
		for (Staff s : staffList) {
			Vector v = new Vector();                                //Vector可实现自动增长的对象数组
			v.add(s.getId());
			v.add(s.getName());
			v.add(s.getSex());
			v.add(s.getAge());
			v.add(getClassNameById(s.getClassId()));
			v.add(s.getPassword());
			dft.addRow(v);                                          //v给模型 按顺序添加列
		}
		staffDao.closeDao();
	}
	
	private void setStaffClassInfo(){
		ClassDao classDao = new ClassDao();
		staffClassList = classDao.getClassList(new StaffClass());
		for (StaffClass sc : staffClassList) {
			searchStaffComboBox.addItem(sc);
			editStaffClassComboBox.addItem(sc);
		}
		classDao.closeDao();
	}
	
	private String getClassNameById (int id) {
		for (StaffClass sc : staffClassList) {
			if(sc.getId() == id)
				return sc.getName();
		}
		return "";
	}
	
	private void setAuthority() {
		if("员工".equals(MainFrm.userType.getName())) {
			Staff s = (Staff)MainFrm.userObject;
			searchStaffNameTextField.setText(s.getName());
			searchStaffNameTextField.setEnabled(false);
			deleteStaffButton.setEnabled(false);
			for(int i=0;i<searchStaffComboBox.getItemCount();i++)
			{
				StaffClass sc = (StaffClass) searchStaffComboBox.getItemAt(i);
				if(sc.getId() == s.getClassId()) {
					searchStaffComboBox.setSelectedIndex(i);
					break;
				}
			}
			searchStaffComboBox.setEnabled(false);
			
			for(int i=0;i<editStaffClassComboBox.getItemCount();i++)
			{
				StaffClass sc = (StaffClass) editStaffClassComboBox.getItemAt(i);
				if(sc.getId() == s.getClassId()) {
					editStaffClassComboBox.setSelectedIndex(i);
					break;
				}
			}
			editStaffClassComboBox.setEnabled(false);
		}
	}
}
