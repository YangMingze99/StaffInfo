package com.artisan.view;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.artisan.dao.AdminDao;
import com.artisan.dao.StaffDao;
import com.artisan.model.Admin;
import com.artisan.model.Staff;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditPasswordFrm extends JInternalFrame {

	private JPanel contentPane;
	private JTextField oldPasswordTextField;
	private JTextField newPasswordTextField;
	private JTextField confirmPasswordTextField;
	private JLabel currentUserLabel;


	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPassword frame = new EditPassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public EditPasswordFrm() {
		setFrameIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		setTitle("\u4FEE\u6539\u5BC6\u7801");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		setIconifiable(true);
		
		JLabel label = new JLabel("\u539F \u5BC6 \u7801\uFF1A");
		label.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u539F\u5BC6\u7801.png")));
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
		
		oldPasswordTextField = new JTextField();
		oldPasswordTextField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		oldPasswordTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u65B0 \u5BC6 \u7801\uFF1A");
		label_1.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u65B0\u5BC6\u7801.png")));
		label_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
		
		newPasswordTextField = new JTextField();
		newPasswordTextField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		newPasswordTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u65B0\u5BC6\u7801.png")));
		label_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
		
		confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		confirmPasswordTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitEdit(e);
			}
		});
		submitButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		JButton testButton = new JButton("\u91CD\u8F93");
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				restValue(ae);
			}
		});
		testButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u91CD\u7F6E1.png")));
		testButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		label_3.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u5F53\u524D\u7528\u6237.png")));
		label_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		
		currentUserLabel = new JLabel("");
		currentUserLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(96)
							.addComponent(submitButton)
							.addGap(46)
							.addComponent(testButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(19, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(label_2)
								.addComponent(label)
								.addComponent(label_3))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(currentUserLabel))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(confirmPasswordTextField, 222, 222, 222)
										.addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(111)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(submitButton, Alignment.TRAILING)
						.addComponent(testButton, Alignment.TRAILING))
					.addGap(32))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(currentUserLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(143, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		if("œµÕ≥π‹¿Ì‘±".equals(MainFrm.userType.getName())) {
			Admin admin = (Admin)MainFrm.userObject;
			currentUserLabel.setText("œµÕ≥π‹¿Ì‘±   "+admin.getName());
		}
		if("‘±π§".equals(MainFrm.userType.getName())) {
			Staff staff = (Staff)MainFrm.userObject;
			currentUserLabel.setText("‘±π§   "+staff.getName());
		}
	}


	protected void submitEdit(ActionEvent e) {
		// TODO Auto-generated method stub
		String oldPassword = oldPasswordTextField.getText().toString();
		String newPassword = newPasswordTextField.getText().toString();
		String conformPassword = confirmPasswordTextField.getText().toString();
		if(StringUtil.isEmpty(oldPassword)) {
			JOptionPane.showMessageDialog(this, "«ÎÃÓ–¥‘≠√‹¬Î£°");
			return;
		}
		if(StringUtil.isEmpty(newPassword)) {
			JOptionPane.showMessageDialog(this, "«ÎÃÓ–¥–¬√‹¬Î£°");
			return;
		}
		if(StringUtil.isEmpty(conformPassword)) {
			JOptionPane.showMessageDialog(this, "«Î÷ÿ–¬ÃÓ–¥–¬√‹¬Î£°");
			return;
		}
		if(!newPassword.equals(conformPassword)) {
			JOptionPane.showMessageDialog(this, "¡Ω¥Œ–¬√‹¬ÎÃÓ–¥≤ª“ª÷¬");
			return;
		}
		if("œµÕ≥π‹¿Ì‘±".equals(MainFrm.userType.getName())) {
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			Admin admin = (Admin)MainFrm.userObject;
			adminTmp.setId(admin.getId());
			adminTmp.setName(admin.getName());
			adminTmp.setPassword(oldPassword);
			JOptionPane.showMessageDialog(this,adminDao.editPassword(adminTmp, newPassword));
			adminDao.closeDao();
		}
		if("‘±π§".equals(MainFrm.userType.getName())) {
			StaffDao staffDao = new StaffDao();
			Staff staffTmp = new Staff();
			Staff staff = (Staff)MainFrm.userObject;
			staffTmp.setName(staff.getName());
			staffTmp.setPassword(oldPassword);
			staffTmp.setId(staff.getId());
			JOptionPane.showMessageDialog(this,staffDao.editPassword(staffTmp, newPassword));
			staffDao.closeDao();
		}
		
	}


	protected void restValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		confirmPasswordTextField.setText("");
	}
}
