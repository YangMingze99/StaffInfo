package com.artisan.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.artisan.dao.ClassDao;
import com.artisan.dao.StaffDao;
import com.artisan.model.Staff;
import com.artisan.model.StaffClass;
import com.artisan.util.StringUtil;

public class AddStaffFrm extends JInternalFrame {
	private JTextField staffNameTextField;
	private JPasswordField staffPasswordField;
	private JTextField staffAgeTextField;
	private ButtonGroup sexButtonGroup;
	private JRadioButton staffSexManRadioButton;
	private JRadioButton staffSexFemalRadioButton;
	private JComboBox staffClassComboBox;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStaffFrm frame = new AddStaffFrm();
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
	public AddStaffFrm() {
		setFrameIcon(new ImageIcon(AddStaffFrm.class.getResource("/images/test.png")));
		setClosable(true);                     /* ÄÚ²¿´°¿Ú¹Ø±ÕÞôÅ¦*/
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u804C\u5458\u4FE1\u606F");
		setBounds(100, 100, 510, 443);
		
		JLabel label = new JLabel("\u804C\u5458\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(AddStaffFrm.class.getResource("/images/\u5458\u5DE5\u5217\u8868.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		staffNameTextField = new JTextField();
		staffNameTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		staffNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6240\u5C5E\u90E8\u95E8\uFF1A");
		label_1.setIcon(new ImageIcon(AddStaffFrm.class.getResource("/images/\u90E8\u95E8\u63CF\u8FF0.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		staffClassComboBox = new JComboBox();
		staffClassComboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		label_2.setIcon(new ImageIcon(AddStaffFrm.class.getResource("/images/\u539F\u5BC6\u7801.png")));
		
		staffPasswordField = new JPasswordField();
		staffPasswordField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("\u804C\u5458\u6027\u522B\uFF1A");
		label_3.setIcon(new ImageIcon(AddStaffFrm.class.getResource("/images/\u6027\u522B.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		staffSexManRadioButton = new JRadioButton("\u7537");
		staffSexManRadioButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		staffSexFemalRadioButton = new JRadioButton("\u5973");
		staffSexFemalRadioButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("\u804C\u5458\u5E74\u9F84\uFF1A");
		label_4.setIcon(new ImageIcon(AddStaffFrm.class.getResource("/images/\u5E74\u9F84.png")));
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		staffAgeTextField = new JTextField();
		staffAgeTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		staffAgeTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E \u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				studentAddAct(ae);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddStaffFrm.class.getResource("/images/\u786E\u8BA4.png")));
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		JButton button = new JButton("\u91CD \u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		button.setIcon(new ImageIcon(AddStaffFrm.class.getResource("/images/\u91CD\u7F6E2.png")));
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(staffSexManRadioButton);
		sexButtonGroup.add(staffSexFemalRadioButton);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(staffNameTextField, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(91)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(staffPasswordField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addGap(7)
									.addComponent(staffClassComboBox, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addGap(6)
									.addComponent(staffSexManRadioButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(staffSexFemalRadioButton))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(label_4)
							.addGap(9)
							.addComponent(staffAgeTextField, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(124, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(105, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(73)
					.addComponent(button)
					.addGap(142))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addComponent(staffNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(label_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(staffClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(staffPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(label_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(staffSexManRadioButton)
								.addComponent(staffSexFemalRadioButton))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(label_4))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(staffAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addComponent(button)))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setStaffClassInfo();

	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		staffNameTextField.setText("");
		staffPasswordField.setText("");
		staffClassComboBox.setSelectedIndex(0);
		sexButtonGroup.clearSelection();
		staffSexManRadioButton.setSelected(true);
		staffAgeTextField.setText("");
	}

	protected void studentAddAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String sex = null;
		String staffName = staffNameTextField.getText().toString();
		String staffPassword = staffPasswordField.getText().toString();
		if(StringUtil.isEmpty(staffName)) {
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´Ö°Ô±ÐÕÃû!");
			return;
		}
		if(StringUtil.isEmpty(staffPassword)) {
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´Ö°Ô±ÃÜÂë!");
			return;
		}
		StaffClass sc = (StaffClass)staffClassComboBox.getSelectedItem();
		if(staffSexManRadioButton.isSelected()) {
			sex = staffSexManRadioButton.getText();
		}
		else {
			sex = staffSexFemalRadioButton.getText();
		}
		
	//	 staffSexManRadioButton.isSelected() ?  : staffSexFemalRadioButton.isSelected() ? 
/*		String age1 = staffAgeTextField.getText().toString();         //×Ö·û´®×ª»»ÕûÐÍ
		int age = Integer.parseInt(age1);						      //×Ö·û´®×ª»»ÕûÐÍ     2019.9.17 10:31*/
		String age = staffAgeTextField.getText().toString();
		Staff staff = new Staff();
		staff.setName(staffName);
		staff.setSex(sex);
		staff.setAge(age);
		staff.setClassId(sc.getId());
		staff.setPassword(staffPassword);
		StaffDao staffDao = new StaffDao();
		if(staffDao.addStaff(staff)){
			JOptionPane.showMessageDialog(this, "Ìí¼Ó³É¹¦!");
		}else{
			JOptionPane.showMessageDialog(this, "Ìí¼ÓÊ§°Ü!");
		}
		resetValue(ae);
	}
	
	private void setStaffClassInfo(){
		ClassDao classDao = new ClassDao();
		List<StaffClass> classList = classDao.getClassList(new StaffClass());
		for (StaffClass sc : classList) {
			staffClassComboBox.addItem(sc);
		}
		classDao.closeDao();
	}
	
}
