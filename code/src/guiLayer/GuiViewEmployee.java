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

import controlLayer.CtrEmployee;
import modelLayer.Customer;
import modelLayer.Employee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GuiViewEmployee extends JDialog {
	/**
	@author frunziss
	*/
	private JPanel contentPane;
	private static GuiViewEmployee instance=null;
	private static CtrEmployee ce = new CtrEmployee();
	private static GuiMain gm=GuiMain.getInstance();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public static GuiViewEmployee getInstance()
	{
		if(instance == null) {
	         instance = new GuiViewEmployee();
	      }
	      return instance;
	}
	public GuiViewEmployee() {
		
		 Employee employee=null;
			try {
				for(Employee curr:ce.getAllEmployees())
				{
					if(curr.getName().equals(gm.list_employees.getSelectedItem()))
					{
						employee=ce.findEmployeeById_employee(curr.getId_employee());
					}
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(new JFrame(), "Can't get all customers. ", "Error", JOptionPane.ERROR_MESSAGE);
			}
		
		setModal(true);
		setTitle("View Employee");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(5, 7, 295, 198);
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
		
		JLabel lblPrice = new JLabel("Street:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice.setBounds(10, 61, 108, 14);
		contentPane.add(lblPrice);
		
		JLabel lblStock = new JLabel("Ph. Nr:");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStock.setBounds(10, 86, 108, 14);
		contentPane.add(lblStock);
		
		JLabel lblType = new JLabel("Email:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblType.setBounds(10, 111, 108, 14);
		contentPane.add(lblType);
		
		JButton btnCancel = new JButton("Ok");
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	//			Main.getFrames()[0].setEnabled(true);
				GuiViewEmployee.this.dispose();
				
			}
		});
		btnCancel.setBounds(95, 136, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblBarcode_1 = new JLabel(employee.getName());
		lblBarcode_1.setBounds(95, 13, 140, 14);
		contentPane.add(lblBarcode_1);
		
		JLabel lblName_1 = new JLabel(employee.getAddress().getCountry());
		lblName_1.setBounds(95, 38, 140, 14);
		contentPane.add(lblName_1);
		
		JLabel lblPrice_1 = new JLabel(employee.getStreet());
		lblPrice_1.setBounds(93, 63, 140, 14);
		contentPane.add(lblPrice_1);
		
		JLabel lblStock_1 = new JLabel(employee.getPhoneNr());
		lblStock_1.setBounds(93, 86, 140, 14);
		contentPane.add(lblStock_1);
		
		JLabel lblType_1 = new JLabel(employee.getEmail());
		lblType_1.setBounds(93, 113, 140, 14);
		contentPane.add(lblType_1);
	}

}
