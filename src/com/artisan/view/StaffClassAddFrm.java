package com.artisan.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.artisan.dao.ClassDao;
import com.artisan.model.StaffClass;
import com.artisan.util.StringUtil;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffClassAddFrm extends JInternalFrame {
	private JTextField classNameTextField;
	private JTextArea classInfoTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffClassAddFrm frame = new StaffClassAddFrm();
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
	public StaffClassAddFrm() {
		setFrameIcon(new ImageIcon(StaffClassAddFrm.class.getResource("/images/\u90E8\u95E8\u6DFB\u52A0.png")));
		setClosable(true);                     /* ÄÚ²¿´°¿Ú¹Ø±ÕÞôÅ¦*/
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u90E8\u95E8\u4FE1\u606F");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u90E8\u95E8\u540D\u79F0\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(StaffClassAddFrm.class.getResource("/images/\u6DFB\u52A0\u540D\u79F0.png")));
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("\u90E8\u95E8\u63CF\u8FF0\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(StaffClassAddFrm.class.getResource("/images/\u90E8\u95E8\u63CF\u8FF0.png")));
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		classNameTextField = new JTextField();
		classNameTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		classNameTextField.setColumns(10);
		
		classInfoTextArea = new JTextArea();
		classInfoTextArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		
		JButton submitButton = new JButton("\u63D0\u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitClass(ae);
			}
		});
		submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		submitButton.setIcon(new ImageIcon(StaffClassAddFrm.class.getResource("/images/\u786E\u8BA4.png")));
		
		JButton restButton = new JButton("\u91CD\u7F6E");
		restButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restValue(e);
			}
		});
		restButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		restButton.setIcon(new ImageIcon(StaffClassAddFrm.class.getResource("/images/\u91CD\u7F6E1.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(lblNewLabel_1)
							.addGap(5)
							.addComponent(classInfoTextArea, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(95, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(96, Short.MAX_VALUE)
					.addComponent(submitButton)
					.addGap(67)
					.addComponent(restButton)
					.addGap(105))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(lblNewLabel)
							.addGap(37)
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(classInfoTextArea, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(submitButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(restButton)))
					.addGap(30))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void submitClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		String className = classNameTextField.getText().toString();
		String classInfo = classInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(className))
		{
			JOptionPane.showMessageDialog(this, "²¿ÃÅÃû³Æ²»¿ÉÒÔÎª¿Õ!");
			return;
		}
		StaffClass sc1 = new StaffClass();
		sc1.setName(className);
		sc1.setInfo(classInfo);
		ClassDao classDao = new ClassDao();
		if(classDao.addClass(sc1)) {
			JOptionPane.showMessageDialog(this, "²¿ÃÅÌí¼Ó³É¹¦");
		} else {
			JOptionPane.showMessageDialog(this, "²¿ÃÅÌí¼ÓÊ§°Ü");
		}
		classDao.closeDao();
		restValue(ae);
	}

	protected void restValue(ActionEvent e) {
		// TODO Auto-generated method stub
		classNameTextField.setText(""); 
		classInfoTextArea.setText("");
	}
}
