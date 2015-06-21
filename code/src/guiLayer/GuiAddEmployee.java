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

import modelLayer.Customer;
import modelLayer.Employee;
import controlLayer.CtrCustomer;
import controlLayer.CtrEmployee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;

public class GuiAddEmployee extends JDialog {

	private JPanel contentPane;
	private JTextField textField_Id;
	private JTextField textField_name;
	private JTextField textField_country;
	private JTextField textField_street;
	private JTextField textField_number;
	private JTextField textField_email;
	private static GuiAddEmployee instance=null;
	private JTextField textField_city;
	private CtrEmployee ce= new CtrEmployee();
	private JTextField textField_pass;
	private JTextField textField_rights;
	
	private ArrayList<GuiEmployeeWrapper<Employee>> gew = new ArrayList<>();
	private ArrayList<Employee> employees = new ArrayList<>();

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
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCountry.setBounds(10, 61, 108, 14);
		contentPane.add(lblCountry);
		
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
		
		textField_country = new JTextField();
		textField_country.setColumns(10);
		textField_country.setBounds(115, 60, 150, 20);
		contentPane.add(textField_country);
		
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
				if(textField_Id.getText().isEmpty()||textField_name.getText().isEmpty()||textField_country.getText().isEmpty()||textField_street.getText().isEmpty()||textField_number.getText().isEmpty()||textField_email.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must complete all fields. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				else
				{	String id=textField_Id.getText();
					String city = textField_city.getText();
					String country = textField_country.getText();
					String street = textField_street.getText();
					String name = textField_name.getText();
					String number = textField_number.getText();
					String email = textField_email.getText();
					String pass =textField_pass.getText();
					int rights =Integer.parseInt(textField_rights.getText());

					try {
			ce.insertEmployee(id, name, number, email, pass, rights, country, city, street);
					//	GuiMain.getInstance().refreshList();
						employees=new ArrayList<>();
						
			
			gew= new ArrayList<>();
			GuiMain.getInstance().list_employees.removeAll();
			try {
				employees=ce.getAllEmployees();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(new JFrame(), "Can't get all customers. ", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			for(Employee curr:employees)
			{
				gew.add(new GuiEmployeeWrapper<Employee>(curr, curr::getName));
				
				
			}
			
			for(GuiEmployeeWrapper<Employee>curr:gew)
			{if(!curr.getObject().getName().equals("God"))
				GuiMain.getInstance().list_employees.add(curr.getObject().getName());
			}
//					GuiAddCustomer.this.dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(new JFrame(), "Can't insert employee. ", "Error",
						        JOptionPane.ERROR_MESSAGE);
					}
					
				}
				GuiAddEmployee.this.dispose();
			}
		});
		btnAdd.setBounds(87, 244, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCity.setBounds(10, 162, 108, 14);
		contentPane.add(lblCity);
		
		textField_city = new JTextField();
		textField_city.setColumns(10);
		textField_city.setBounds(115, 161, 150, 20);
		contentPane.add(textField_city);
		
		JLabel lblPass = new JLabel("Pass:");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPass.setBounds(10, 187, 108, 14);
		contentPane.add(lblPass);
		
		textField_pass = new JTextField();
		textField_pass.setColumns(10);
		textField_pass.setBounds(115, 186, 150, 20);
		contentPane.add(textField_pass);
		
		JLabel lblRights = new JLabel("Rights:");
		lblRights.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRights.setBounds(10, 213, 108, 14);
		contentPane.add(lblRights);
		
		textField_rights = new JTextField();
		textField_rights.setColumns(10);
		textField_rights.setBounds(115, 212, 150, 20);
		contentPane.add(textField_rights);
	}
}
