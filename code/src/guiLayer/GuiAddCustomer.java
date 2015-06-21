package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import modelLayer.*;
import controlLayer.*;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;

public class GuiAddCustomer extends JDialog {

	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_country;
	private JTextField textField_city;
	private JTextField textField_street;
	private JTextField textField_number;
	private JTextField textField_email;
	private static GuiAddCustomer instance=null;
	private CtrAddress ca =  new CtrAddress();
	private CtrCustomer cc= new CtrCustomer();
	private ArrayList<GuiCustomerWrapper<Customer>> gcw = new ArrayList<>();
	private ArrayList<Customer> customers = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	/**
	@author frunziss
	*/

	/**
	 * Create the frame.
	 */
	public static GuiAddCustomer getInstance()
	{
		if(instance == null) {
	         instance = new GuiAddCustomer();
	      }
	      return instance;
	}
	public GuiAddCustomer() {
		/*
		try {
			customers=cc.getAllCustomers();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "Can't get all customers. ", "Error", JOptionPane.ERROR_MESSAGE);
		}
		try {
			customers=cc.getAllCustomers();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "Can't get all customers. ", "Error", JOptionPane.ERROR_MESSAGE);
		}
		for(Customer curr:customers)
		{
			gcw.add(new GuiCustomerWrapper<Customer>(curr, curr::getName));
			
			
		}
		
		for(GuiCustomerWrapper<Customer>curr:gcw)
		{
			GuiMain.getInstance().list_customers.add(curr.getObject().getName());
		}
		*/
		setModal(true);
		setTitle("Add Customer");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(5, 7, 295, 231);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBarcode = new JLabel("Name:");
		lblBarcode.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBarcode.setBounds(10, 11, 108, 14);
		contentPane.add(lblBarcode);
		
		JLabel lblName = new JLabel("Country:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(10, 36, 108, 14);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("City:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice.setBounds(10, 61, 108, 14);
		contentPane.add(lblPrice);
		
		JLabel lblStock = new JLabel("Street:");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStock.setBounds(10, 86, 108, 14);
		contentPane.add(lblStock);
		
		JLabel lblType = new JLabel("Ph. Nr:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblType.setBounds(10, 111, 108, 14);
		contentPane.add(lblType);
		
		JLabel lblCategory = new JLabel("Email:");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCategory.setBounds(10, 136, 108, 14);
		contentPane.add(lblCategory);
		
		textField_name = new JTextField();
		textField_name.setBounds(115, 10, 150, 20);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		textField_country = new JTextField();
		textField_country.setColumns(10);
		textField_country.setBounds(115, 36, 150, 20);
		contentPane.add(textField_country);
		
		textField_city = new JTextField();
		textField_city.setColumns(10);
		textField_city.setBounds(115, 60, 150, 20);
		contentPane.add(textField_city);
		
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
			//	Main.getFrames()[0].setEnabled(true);
				GuiAddCustomer.this.dispose();
				
			}
		});
		btnCancel.setBounds(176, 163, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(204, 204, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_name.getText().isEmpty()||textField_country.getText().isEmpty()||textField_city.getText().isEmpty()||textField_street.getText().isEmpty()||textField_number.getText().isEmpty()||textField_email.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must complete all fields. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				else
				{
					String city = textField_city.getText();
					String country = textField_country.getText();
					String street = textField_street.getText();
					String name = textField_name.getText();
					String number = textField_number.getText();
					String email = textField_email.getText();

					try {
						cc.insertCustomer(name, country, city, street, number, email);
						customers = cc.getAllCustomers();
						gcw= new ArrayList<>();
						GuiMain.getInstance().list_customers.removeAll();
						try {
							customers=cc.getAllCustomers();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(new JFrame(), "Can't get all customers. ", "Error", JOptionPane.ERROR_MESSAGE);
						}
						try {
							customers=cc.getAllCustomers();
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(new JFrame(), "Can't get all customers. ", "Error", JOptionPane.ERROR_MESSAGE);
						}
						for(Customer curr:customers)
						{
							gcw.add(new GuiCustomerWrapper<Customer>(curr, curr::getName));
							
							
						}
						
						for(GuiCustomerWrapper<Customer>curr:gcw)
						{
							GuiMain.getInstance().list_customers.add(curr.getObject().getName());
						}
						GuiAddCustomer.this.dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(new JFrame(), "Can't insert customer. ", "Error",
						        JOptionPane.ERROR_MESSAGE);
					}
							
				}
					GuiAddCustomer.this.dispose();
			}
		});
		btnAdd.setBounds(86, 163, 89, 23);
		contentPane.add(btnAdd);
	}

}
