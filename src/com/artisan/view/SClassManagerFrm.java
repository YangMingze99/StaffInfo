package com.artisan.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.artisan.dao.ClassDao;
import com.artisan.model.StaffClass;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SClassManagerFrm extends JInternalFrame {
	private JTextField searchClassNameTextField;
	private JTable classListTable;
	private JTextField editClassNameTextField;
	private JTextArea editClassInfoTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SClassManagerFrm frame = new SClassManagerFrm();
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
	public SClassManagerFrm() {
		JInternalFrame jf = new JInternalFrame();
		jf.toFront();
		setFrameIcon(new ImageIcon(SClassManagerFrm.class.getResource("/images/\u90E8\u95E8.png")));
		setClosable(true);                     /* 内部窗口关闭摁纽*/
		setIconifiable(true);
		
		setTitle("\u90E8\u95E8\u4FE1\u606F\u7BA1\u7406\u754C\u9762");
		setBounds(100, 100, 721, 498);
		
		JLabel lblNewLabel = new JLabel("\u90E8\u95E8\u540D\u79F0\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(SClassManagerFrm.class.getResource("/images/\u6DFB\u52A0\u540D\u79F0.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		searchClassNameTextField = new JTextField();
		searchClassNameTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		searchClassNameTextField.setColumns(10);
		
		
		JButton searchButton = new JButton("\u67E5  \u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StaffClass sc = new StaffClass();
				sc.setName(searchClassNameTextField.getText().toString());
				setTable(sc);
			}
		});
		searchButton.setIcon(new ImageIcon(SClassManagerFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u90E8\u95E8\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(SClassManagerFrm.class.getResource("/images/\u6DFB\u52A0\u540D\u79F0.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		JLabel label_1 = new JLabel("\u90E8\u95E8\u4FE1\u606F\uFF1A");
		label_1.setIcon(new ImageIcon(SClassManagerFrm.class.getResource("/images/\u90E8\u95E8\u63CF\u8FF0.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		editClassNameTextField = new JTextField();
		editClassNameTextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		editClassNameTextField.setColumns(10);
		
		editClassInfoTextArea = new JTextArea();
		editClassInfoTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEditAct(ae);
				
			}
		});
		submitEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitEditButton.setIcon(new ImageIcon(SClassManagerFrm.class.getResource("/images/\u786E\u8BA4.png")));
		
		JButton submitDeleteButton = new JButton("\u4FE1\u606F\u5220\u9664");
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteClassAct(ae);
			}
		});
		submitDeleteButton.setIcon(new ImageIcon(SClassManagerFrm.class.getResource("/images/\u5220\u9664.png")));
		submitDeleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(131, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(3)
					.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(searchButton)
					.addGap(144))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(94)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(78, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addComponent(label_1)))
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(editClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addGap(78)
							.addComponent(submitDeleteButton)
							.addContainerGap(119, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
							.addComponent(submitEditButton)
							.addGap(119))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(34))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(31))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(searchButton)
									.addGap(29)))
							.addGap(223)
							.addComponent(label)
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(editClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(14)
									.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(22)
									.addComponent(submitEditButton)))
							.addGap(43)
							.addComponent(submitDeleteButton)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		
		classListTable = new JTable();
		classListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				//JOptionPane.showMessageDialog(null, "ok");
				selectedTableRow(me);
			}
		});
		classListTable.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		classListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u90E8\u95E8\u7F16\u53F7", "\u90E8\u95E8\u540D\u79F0", "\u90E8\u95E8\u4FE1\u606F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		classListTable.getColumnModel().getColumn(2).setPreferredWidth(388);
		scrollPane.setViewportView(classListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new StaffClass());
	}
	

	protected void deleteClassAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "确认删除？")!=JOptionPane.OK_OPTION) {
			return;
		}
		int index = classListTable.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(this, "请选中要删除的数据");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(),0).toString());
		ClassDao classDao = new ClassDao();
		if(classDao.delete(id)) {
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		classDao.closeDao();
		setTable(new StaffClass());								//是否成功都要刷新数据库
	}

	protected void submitEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		ClassDao classDao = new ClassDao();
		int index = classListTable.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(this, "请选中要修改的数据");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		String className = dft.getValueAt(classListTable.getSelectedRow(), 1).toString();
		String classInfo = dft.getValueAt(classListTable.getSelectedRow(), 2).toString(); 
		String editClassName = editClassNameTextField.getText().toString();
		String editClassInfo = editClassInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(editClassName)) {
			JOptionPane.showMessageDialog(this, "请填写要修改的名字");
			return;
		}
		if(className.equals(editClassName)&&classInfo.equals(editClassInfo)) {           //2019/9/16 0:50 
			JOptionPane.showMessageDialog(this, "没有提交修改的新信息");
			return;
		}
		
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(),0).toString());
		StaffClass sc = new StaffClass();
		sc.setId(id);
		sc.setName(editClassName);
		sc.setInfo(editClassInfo);
		if(classDao.update(sc)) {
			JOptionPane.showMessageDialog(this, "修改成功！");
		}else {
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		classDao.closeDao();
		setTable(new StaffClass());                                                     //刷新数据库
	}

	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		editClassNameTextField.setText(dft.getValueAt(classListTable.getSelectedRow(), 1).toString());
		editClassInfoTextArea.setText(dft.getValueAt(classListTable.getSelectedRow(), 2).toString());
	}

	private void setTable(StaffClass staffClass) {
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();  //default模型
		dft.setRowCount(0);             										//清空列表
		ClassDao classDao = new ClassDao();
		List<StaffClass> classList = classDao.getClassList(staffClass);
		for (StaffClass sc : classList) {
			Vector v = new Vector();                                //Vector可实现自动增长的对象数组
			v.add(sc.getId());
			v.add(sc.getName());
			v.add(sc.getInfo());
			dft.addRow(v);                                          //v给模型 按顺序添加列
		}
		classDao.closeDao();
	}
}
