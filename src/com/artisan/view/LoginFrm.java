package com.artisan.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.artisan.dao.AdminDao;
import com.artisan.dao.StaffDao;
import com.artisan.model.Admin;
import com.artisan.model.Staff;
import com.artisan.model.UserType;
import com.artisan.util.StringUtil;

import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LoginFrm extends JFrame {
	private JTextField userNameTextField;
	private JPasswordField userPasswordTextField;
	private JComboBox userTypeComboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
					frame.setVisible(true);      
				    frame.setSize(675,430);  
				    frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrm() {
		//getContentPane().setBackground(Color.ORANGE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrm.class.getResource("/images/logo-github.png")));
		setTitle("\u767B\u9646");
		
		JLabel lblNewLabel = new JLabel("  \u5458\u5DE5\u7BA1\u7406\u7CFB\u7EDF\u767B\u9646\u754C\u9762");
		lblNewLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/logo-github.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D \uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 19));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6    \u7801 \uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 19));
		
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		userNameTextField.setColumns(10);
		
		JButton resetButton = new JButton("\u91CD  \u8F93");
		resetButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				restValue(ae);
			}
		});
		
		userPasswordTextField = new JPasswordField();
		userPasswordTextField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JLabel label = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		label.setFont(new Font("微软雅黑", Font.BOLD, 19));
		
		userTypeComboBox = new JComboBox();
		//UserType.java toString
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.OrdinaryUser}));
		userTypeComboBox.setFont(new Font("微软雅黑", Font.BOLD, 18));
		
		JButton loginButton = new JButton("\u767B  \u9646");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
			}
		});
		loginButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(93)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_2)
									.addComponent(lblNewLabel_1)))
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(loginButton)
									.addGap(119)
									.addComponent(resetButton))
								.addComponent(userPasswordTextField)
								.addComponent(userTypeComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(userNameTextField)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addComponent(lblNewLabel)))
					.addContainerGap(221, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(userPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(resetButton))
					.addGap(49))
		);
		getContentPane().setLayout(groupLayout);
		setBak();
	}

	protected void loginAct(ActionEvent ae) {           			      //登录摁扭
		// TODO Auto-generated method stub
		String userName = userNameTextField.getText().toString();
		String password = userPasswordTextField.getText().toString();
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		
		//用户名 密码空值禁止登录   调用封装
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "用户名不可为空呦！");  	 //友情提示弹窗
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "不打密码让我猜吗？");  	 //友情提示弹窗
			return;
		}
		
		Admin admin = null;
		if("系统管理员".equals(selectedItem.getName())) {
			//尊贵的管理员登陆
			AdminDao adminDao = new AdminDao();
			Admin adminTemp = new Admin();
			adminTemp.setName(userName);
			adminTemp.setPassword(password);
			admin = adminDao.login(adminTemp);
			adminDao.closeDao();
			if(admin == null) {
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");  	 //友情提示弹窗
				return;
			}
			
			JOptionPane.showMessageDialog(this, "欢迎"+selectedItem.getName()+"：  "+admin.getName()+"登录~~~");
			this.dispose();
			MainFrm mainFrm = new MainFrm(selectedItem,admin);
			mainFrm.setVisible(true);
			mainFrm.setLocationRelativeTo(null);                                        //屏幕居中
		}
		if("员工".equals(selectedItem.getName())){
		//普通员工登陆
			Staff staff = null;
			StaffDao staffDao = new StaffDao();
			Staff staffTemp = new Staff();
			staffTemp.setName(userName);
			staffTemp.setPassword(password);
			staff = staffDao.login(staffTemp);
			staffDao.closeDao();
			if(staff == null) {
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");  	 //友情提示弹窗
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎"+selectedItem.getName()+"：  "+staff.getName()+"登录~~~");
			this.dispose();
			MainFrm mainFrm = new MainFrm(selectedItem,staff);
			mainFrm.setVisible(true);
			mainFrm.setLocationRelativeTo(null);                                        //屏幕居中
		}
	}
	

	protected void restValue(ActionEvent ae) {         				     //重置摁扭
		// TODO Auto-generated method stub
		userNameTextField.setText("");
		userPasswordTextField.setText("");
		userTypeComboBox.setSelectedIndex(0);
	}
	
	public void setBak(){
	    ((JPanel)this.getContentPane()).setOpaque(false);
	    ImageIcon img = new ImageIcon("E:\\eclipse\\StaffInfo\\src\\images\\1.png"); 
	    JLabel background = new JLabel(img); 
	    this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	    background.setBounds(0, -50, 820, 450);     //左右     上下    
	}
}
