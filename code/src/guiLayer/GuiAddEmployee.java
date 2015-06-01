package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GuiAddEmployee extends JDialog {

	private JPanel contentPane;
	private JTextField textField_Id;
	private JTextField textField_name;
	private JTextField textField_address;
	private JTextField textField_street;
	private JTextField textField_number;
	private JTextField textField_email;
	private static GuiAddEmployee instance=null;

	/**
	 * Launch the application.
	 */
	/**
	@author frunziss
	*/

	/**
	 * Create the frame.
	 */
	public static GuiAddEmployee getInstance()
	{
		if(instance == null) {
	         instance = new GuiAddEmployee();
	      }
	      return instance;
	}
	public GuiAddEmployee() {
		setModal(true);
		setTitle("Add Employee");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(5, 7, 295, 307);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(10, 11, 108, 14);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(10, 36, 108, 14);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(10, 61, 108, 14);
		contentPane.add(lblAddress);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStreet.setBounds(10, 86, 108, 14);
		contentPane.add(lblStreet);
		
		JLabel lblType = new JLabel("Ph. Nr:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblType.setBounds(10, 111, 108, 14);
		contentPane.add(lblType);
		
		JLabel lblCategory = new JLabel("Email:");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCategory.setBounds(10, 136, 108, 14);
		contentPane.add(lblCategory);
		
		textField_Id = new JTextField();
		textField_Id.setBounds(115, 10, 150, 20);
		contentPane.add(textField_Id);
		textField_Id.setColumns(10);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(115, 36, 150, 20);
		contentPane.add(textField_name);
		
		textField_address = new JTextField();
		textField_address.setColumns(10);
		textField_address.setBounds(115, 60, 150, 20);
		contentPane.add(textField_address);
		
		textField_street = new JTextField();
		textField_street.setColumns(10);
		textField_street.setBounds(115, 85, 150, 20);
		contentPane.add(textField_street);
		
		textField_number = new JTextField();
		textField_number.setColumns(10);
		textField_number.setBounds(115, 110, 150, 20);
		contentPane.add(textField_number);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(115, 135, 150, 20);
		contentPane.add(textField_email);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Main.getFrames()[0].setEnabled(true);
				GuiAddEmployee.this.dispose();
			}
		});
		btnCancel.setBounds(177, 244, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(204, 204, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_Id.getText().isEmpty()||textField_name.getText().isEmpty()||textField_address.getText().isEmpty()||textField_street.getText().isEmpty()||textField_number.getText().isEmpty()||textField_email.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must complete all fields. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				else
				{
					//
				}
			}
		});
		btnAdd.setBounds(87, 244, 89, 23);
		contentPane.add(btnAdd);
	}

}
