package guiLayer;

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

import modelLayer.Customer;
import controlLayer.CtrCustomer;

import java.awt.Font;
import java.awt.Color;
/**
@author frunziss
*/
public class GuiUpdateCustomer extends JDialog {
	private JTextField textField_name;
	private JTextField textField_country;
	private JTextField textField_city;
	private JTextField textField_street;
	private JTextField textField_phone;
	private JTextField textField_email;
	private static GuiUpdateCustomer instance= null;
	private CtrCustomer cc = new CtrCustomer();
	
	private Customer customer = cc.searchCustomerByName(GuiMain.getInstance().list_1.getSelectedItem());

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
		
		JLabel lblName = new JLabel(customer.getName());
		lblName.setBounds(177, 13, 46, 14);
		namePanel.add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("New name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 36, 103, 14);
		namePanel.add(lblNewLabel_1);
		
		textField_name = new JTextField();
		textField_name.setBounds(137, 35, 152, 20);
		namePanel.add(textField_name);
		textField_name.setColumns(10);
		
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
				else
				*/
			cc.updateCustomer(customer.getId_customer(), textField_name.getText(), customer.getAddress().getCountry(), customer.getAddress().getCity(), customer.getStreet(), customer.getPhoneNr(), customer.getEmail());
			
				
			
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
		
		JLabel lblCountry = new JLabel(customer.getAddress().getCountry());
		lblCountry.setBounds(177, 13, 46, 14);
		countryPanel.add(lblCountry);
		
		textField_country = new JTextField();
		textField_country.setColumns(10);
		textField_country.setBounds(137, 35, 152, 20);
		countryPanel.add(textField_country);
		
		JButton btnModify = new JButton("Update");
		btnModify.setBackground(new Color(204, 204, 255));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the name of the item in order to be displayed. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}*/
				cc.updateCustomer(customer.getId_customer(), customer.getName(), textField_country.getText(), customer.getAddress().getCity(), customer.getStreet(), customer.getPhoneNr(), customer.getEmail());
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
		
		textField_city = new JTextField();
		textField_city.setColumns(10);
		textField_city.setBounds(137, 35, 152, 20);
		cityPanel.add(textField_city);
		
		JButton btnModify_1 = new JButton("Update");
		btnModify_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cc.updateCustomer(customer.getId_customer(), customer.getName(), customer.getAddress().getCountry(), textField_city.getText(), customer.getStreet(), customer.getPhoneNr(), customer.getEmail());
			}
		});
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
		
		JLabel lblStreet = new JLabel(customer.getStreet());
		lblStreet.setBounds(177, 13, 46, 14);
		streetPanel.add(lblStreet);
		
		JLabel lblNewStreet = new JLabel("New street:");
		lblNewStreet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewStreet.setBounds(10, 36, 103, 14);
		streetPanel.add(lblNewStreet);
		
		textField_street = new JTextField();
		textField_street.setColumns(10);
		textField_street.setBounds(137, 35, 152, 20);
		streetPanel.add(textField_street);
		
		JButton btnModify_2 = new JButton("Update");
		btnModify_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cc.updateCustomer(customer.getId_customer(), customer.getName(), customer.getAddress().getCountry(), customer.getAddress().getCity(), textField_street.getText(), customer.getPhoneNr(), customer.getEmail());
			}
		});
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
		
		JLabel lblPhone = new JLabel(customer.getPhoneNr());
		lblPhone.setBounds(177, 13, 46, 14);
		phonePanel.add(lblPhone);
		
		JLabel lblNewPhone = new JLabel("New phone:");
		lblNewPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewPhone.setBounds(10, 36, 103, 14);
		phonePanel.add(lblNewPhone);
		
		textField_phone = new JTextField();
		textField_phone.setColumns(10);
		textField_phone.setBounds(137, 35, 152, 20);
		phonePanel.add(textField_phone);
		
		JButton btnModify_3 = new JButton("Update");
		btnModify_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cc.updateCustomer(customer.getId_customer(), customer.getName(), customer.getAddress().getCountry(), customer.getAddress().getCity(), customer.getStreet(), textField_phone.getText(), customer.getEmail());
			}
		});
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
		
		JLabel lblEmail = new JLabel(customer.getEmail());
		lblEmail.setBounds(177, 13, 46, 14);
		emailPanel.add(lblEmail);
		
		JLabel lblNewEmail = new JLabel("New email:");
		lblNewEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewEmail.setBounds(10, 36, 103, 14);
		emailPanel.add(lblNewEmail);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(137, 35, 152, 20);
		emailPanel.add(textField_email);
		
		JButton btnModify_4 = new JButton("Update");
		btnModify_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cc.updateCustomer(customer.getId_customer(), customer.getEmail(), customer.getAddress().getCountry(), customer.getAddress().getCity(), customer.getStreet(), customer.getPhoneNr(), textField_email.getText());
		}});
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
