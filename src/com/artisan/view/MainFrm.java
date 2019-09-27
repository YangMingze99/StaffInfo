package com.artisan.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.artisan.model.UserType;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static UserType userType;
	public static Object userObject;
	private JMenuItem menuItem_2;
	private JMenu menu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				
//				try {
//					MainFrm frame = new MainFrm(null,null);
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainFrm(UserType userType,Object userObject) {
		this.userType = userType;
		this.userObject = userObject;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/images/logo-github.png")));
		setTitle("\u5458\u5DE5\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1148, 830);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u8BBE\u7F6E.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5207\u6362\u7528\u6237");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MainFrm.this, "确定更换新用户嘛？") == JOptionPane.OK_OPTION) {
					LoginFrm lf = new LoginFrm();
					lf.setVisible(true);
					lf.setSize(675,430);  
					lf.setLocationRelativeTo(null);
					dispose();
				}
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/change.png")));
		menu.add(menuItem_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5173\u95ED\u7CFB\u7EDF");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(JOptionPane.showConfirmDialog(MainFrm.this, "确定退出系统嘛？") == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9000\u51FA.png")));
		menu.add(mntmNewMenuItem_1);
		
		JMenu menu_1 = new JMenu("\u5458\u5DE5\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5458\u5DE5\u7BA1\u7406.png")));
		menuBar.add(menu_1);
		
		menuItem_2 = new JMenuItem("\u5458\u5DE5\u6DFB\u52A0");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				AddStaffFrm addStudentFrm = new AddStaffFrm();
				addStudentFrm.setVisible(true);
				desktopPane.add(addStudentFrm);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0\u5458\u5DE5.png")));
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5458\u5DE5\u5217\u8868");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffManagerFrm staffManagerFrm = new StaffManagerFrm();
				staffManagerFrm.setVisible(true);
				desktopPane.add(staffManagerFrm);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5458\u5DE5\u5217\u8868.png")));
		menu_1.add(menuItem_3);
		
		menu_2 = new JMenu("\u90E8\u95E8\u4FE1\u606F");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u90E8\u95E8.png")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_4 = new JMenuItem("\u6DFB\u52A0\u90E8\u95E8");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				StaffClassAddFrm staffClassAddFrm = new StaffClassAddFrm();
				staffClassAddFrm.setVisible(true);
				desktopPane.add(staffClassAddFrm);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u90E8\u95E8\u6DFB\u52A0.png")));
		menu_2.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u90E8\u95E8\u7BA1\u7406");
		menuItem_5.addActionListener(new ActionListener() {                                 //部门信息管理监听+方法   懒
			public void actionPerformed(ActionEvent e) {
				SClassManagerFrm sClassManagerFrm = new SClassManagerFrm();
				sClassManagerFrm.setVisible(true);
				desktopPane.add(sClassManagerFrm);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u90E8\u95E8\u5217\u8868.png")));
		menu_2.add(menuItem_5);
		
		JMenu mnNewMenu = new JMenu("\u8003\u52E4\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/signup.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("\u5458\u5DE5\u8003\u52E4");
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5458\u5DE5\u8003\u52E4.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				SigninFrm sf = new SigninFrm();
				sf.setVisible(true);
				desktopPane.add(sf);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_2 = new JMenuItem("\u8003\u52E4\u7BA1\u7406");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				SigninManagerFrm smf = new SigninManagerFrm();
				smf.setVisible(true);
				desktopPane.add(smf);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		mntmNewMenuItem_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu menu_3 = new JMenu("\u5E2E\u52A9");
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5E2E\u52A9.png")));
		menuBar.add(menu_3);
		
		JMenuItem menuItem_6 = new JMenuItem("\u5173\u4E8E\u4F5C\u8005");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutMe(ae);
			}
		});
		menuItem_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5173\u4E8E.png")));
		menu_3.add(menuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setForeground(Color.WHITE);
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
//		int width = 1120,height = 747;
//		ImageIcon image = new ImageIcon("/images/1.png");
		lblNewLabel.setIcon(new ImageIcon(MainFrm.class.getResource("/images/1.png")));
//		image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));
//		lblNewLabel.setIcon(image); 
//		lblNewLabel.setSize(width, height); 
		
		lblNewLabel.setBounds(147, 0, 1120, 747);
		desktopPane.add(lblNewLabel);
		setLocationRelativeTo(null);
		setAuthority();
		
	}
	

	protected void addStaffClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		StaffClassAddFrm sca = new StaffClassAddFrm();
		sca.setVisible(true);
		desktopPane.add(sca);
	}

	protected void editPassword(ActionEvent ae) { 
		// TODO Auto-generated method stub
		EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
		editPasswordFrm.setVisible(true);
		desktopPane.add(editPasswordFrm);
	}

	protected void aboutMe(ActionEvent ae) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, "学号:2017742036"+"\n"+"姓名:杨明泽"+"\n"+"项目文件已上传GitHub"+"\n"+"url:  https://github.com/YangMingze99");
	}
	
	private void setAuthority()                                         //权限分配
	{
		if("员工".equals(userType.getName())) {
			menuItem_2.setEnabled(false);
			menu_2.setEnabled(false);
			mntmNewMenuItem_2.setEnabled(false);
			
		}
		if("系统管理员".equals(MainFrm.userType.getName())) {
			mntmNewMenuItem.setEnabled(false);
		}
	}
}
