package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;

import java.awt.List;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
/**
@author frunziss
*/
public class GuiUpdateCustomer extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private static GuiUpdateCustomer instance= null;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public static GuiUpdateCustomer getInstance()
	{
		if(instance == null) {
	         instance = new GuiUpdateCustomer();
	      }
	      return instance;
	}
	public GuiUpdateCustomer() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Update Customer");
		getContentPane().setLayout(null);
		this.setBounds(5, 7, 608, 210);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 582, 151);
	
		getContentPane().add(tabbedPane);
		
		JPanel namePanel = new JPanel();
		namePanel.setBackground(Color.GRAY);
		namePanel.setBounds(20, 116, 50, 50);
		
		
		JPanel countryPanel = new JPanel();
		countryPanel.setBackground(Color.GRAY);
		countryPanel.setBounds(116, 116, 50, 50);
		
		
		JPanel cityPanel = new JPanel();
		cityPanel.setBackground(Color.GRAY);
		cityPanel.setBounds(20, 116, 50, 50);
		
		JPanel streetPanel = new JPanel();
		streetPanel.setBackground(Color.GRAY);
		streetPanel.setBounds(20, 116, 50, 50);
		
		JPanel phonePanel = new JPanel();
		phonePanel.setBackground(Color.GRAY);
		phonePanel.setBounds(20, 116, 50, 50);
		
		JPanel emailPanel = new JPanel();
		emailPanel.setBackground(Color.GRAY);
		emailPanel.setBounds(20, 116, 50, 50);
		
		
		
		
		tabbedPane.addTab("UpdateName", namePanel);
		namePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Current name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 119, 14);
		namePanel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(177, 13, 46, 14);
		namePanel.add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("New name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 36, 103, 14);
		namePanel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(137, 35, 152, 20);
		namePanel.add(textField);
		textField.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Main.getFrames()[0].setEnabled(true);
				GuiUpdateCustomer.this.dispose();
			}
		});
		btnCancel.setBounds(200, 89, 89, 23);
		namePanel.add(btnCancel);
		
		JButton btnAdd = new JButton("Update");
		btnAdd.setBackground(new Color(204, 204, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the name of the item in order to be displayed. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				*/
			}
		});
		btnAdd.setBounds(109, 89, 89, 23);
		namePanel.add(btnAdd);
		tabbedPane.addTab("UpdateCountry", countryPanel);
		countryPanel.setLayout(null);
		
		JLabel lblCurrentPrice = new JLabel("Current country:");
		lblCurrentPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentPrice.setBounds(10, 11, 119, 14);
		countryPanel.add(lblCurrentPrice);
		
		JLabel lblNewPrice = new JLabel("New country:");
		lblNewPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewPrice.setBounds(10, 36, 103, 14);
		countryPanel.add(lblNewPrice);
		
		JLabel lblPrice = new JLabel("country");
		lblPrice.setBounds(177, 13, 46, 14);
		countryPanel.add(lblPrice);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 35, 152, 20);
		countryPanel.add(textField_1);
		
		JButton btnModify = new JButton("Update");
		btnModify.setBackground(new Color(204, 204, 255));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the name of the item in order to be displayed. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}*/
			}
		});
		btnModify.setBounds(109, 89, 89, 23);
		countryPanel.add(btnModify);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setBackground(new Color(204, 204, 255));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	Main.getFrames()[0].setEnabled(true);
				GuiUpdateCustomer.this.dispose();
			}
		});
		button_1.setBounds(200, 89, 89, 23);
		countryPanel.add(button_1);
		//
		tabbedPane.addTab("UpdateCity", cityPanel);
		cityPanel.setLayout(null);
		
		JLabel lblUpdateName = new JLabel("Current city:");
		lblUpdateName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUpdateName.setBounds(10, 11, 119, 14);
		cityPanel.add(lblUpdateName);
		
		JLabel lblCity = new JLabel("city");
		lblCity.setBounds(177, 13, 46, 14);
		cityPanel.add(lblCity);
		
		JLabel lblNewCity = new JLabel("New city:");
		lblNewCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewCity.setBounds(10, 36, 103, 14);
		cityPanel.add(lblNewCity);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(137, 35, 152, 20);
		cityPanel.add(textField_2);
		
		JButton btnModify_1 = new JButton("Update");
		btnModify_1.setBackground(new Color(204, 204, 255));
		btnModify_1.setBounds(109, 89, 89, 23);
		cityPanel.add(btnModify_1);
		
		JButton button_3 = new JButton("Cancel");
		button_3.setBackground(new Color(204, 204, 255));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	Main.getFrames()[0].setEnabled(true);
				GuiUpdateCustomer.this.dispose();
			}
		});
		button_3.setBounds(200, 89, 89, 23);
		cityPanel.add(button_3);
		namePanel.setLayout(null);
		
		tabbedPane.addTab("UpdateStreet", streetPanel);
		streetPanel.setLayout(null);
		
		JLabel lblCurrentStreet = new JLabel("Current street:");
		lblCurrentStreet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentStreet.setBounds(10, 11, 119, 14);
		streetPanel.add(lblCurrentStreet);
		
		JLabel lblStreet = new JLabel("street");
		lblStreet.setBounds(177, 13, 46, 14);
		streetPanel.add(lblStreet);
		
		JLabel lblNewStreet = new JLabel("New street:");
		lblNewStreet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewStreet.setBounds(10, 36, 103, 14);
		streetPanel.add(lblNewStreet);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(137, 35, 152, 20);
		streetPanel.add(textField_3);
		
		JButton btnModify_2 = new JButton("Update");
		btnModify_2.setBackground(new Color(204, 204, 255));
		btnModify_2.setBounds(109, 89, 89, 23);
		streetPanel.add(btnModify_2);
		
		JButton button_5 = new JButton("Cancel");
		button_5.setBackground(new Color(204, 204, 255));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//		Main.getFrames()[0].setEnabled(true);
				GuiUpdateCustomer.this.dispose();
			}
		});
		button_5.setBounds(200, 89, 89, 23);
		streetPanel.add(button_5);
		
		tabbedPane.addTab("UpdatePhone", phonePanel);
		phonePanel.setLayout(null);
		
		JLabel lblCurrentPhone = new JLabel("Current phone:");
		lblCurrentPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentPhone.setBounds(10, 11, 119, 14);
		phonePanel.add(lblCurrentPhone);
		
		JLabel lblPhon = new JLabel("phon");
		lblPhon.setBounds(177, 13, 46, 14);
		phonePanel.add(lblPhon);
		
		JLabel lblNewPhone = new JLabel("New phone:");
		lblNewPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewPhone.setBounds(10, 36, 103, 14);
		phonePanel.add(lblNewPhone);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(137, 35, 152, 20);
		phonePanel.add(textField_4);
		
		JButton btnModify_3 = new JButton("Update");
		btnModify_3.setBackground(new Color(204, 204, 255));
		btnModify_3.setBounds(109, 89, 89, 23);
		phonePanel.add(btnModify_3);
		
		JButton button_7 = new JButton("Cancel");
		button_7.setBackground(new Color(204, 204, 255));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//		Main.getFrames()[0].setEnabled(true);
				GuiUpdateCustomer.this.dispose();
			}
		});
		button_7.setBounds(200, 89, 89, 23);
		phonePanel.add(button_7);
		
		tabbedPane.addTab("UpdateEmail", emailPanel);
		emailPanel.setLayout(null);
		
		JLabel lblCurrentEmail = new JLabel("Current email:");
		lblCurrentEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentEmail.setBounds(10, 11, 119, 14);
		emailPanel.add(lblCurrentEmail);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(177, 13, 46, 14);
		emailPanel.add(lblEmail);
		
		JLabel lblNewEmail = new JLabel("New email:");
		lblNewEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewEmail.setBounds(10, 36, 103, 14);
		emailPanel.add(lblNewEmail);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(137, 35, 152, 20);
		emailPanel.add(textField_5);
		
		JButton btnModify_4 = new JButton("Update");
		btnModify_4.setBackground(new Color(204, 204, 255));
		btnModify_4.setBounds(109, 89, 89, 23);
		emailPanel.add(btnModify_4);
		
		JButton button_9 = new JButton("Cancel");
		button_9.setBackground(new Color(204, 204, 255));
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Main.getFrames()[0].setEnabled(true);
				GuiUpdateCustomer.this.dispose();
			}
		});
		button_9.setBounds(200, 89, 89, 23);
		emailPanel.add(button_9);
	}
	
	
}
