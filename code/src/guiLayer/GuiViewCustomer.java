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

import controlLayer.CtrCustomer;
import modelLayer.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**
@author frunziss
*/
public class GuiViewCustomer extends JDialog {

	private JPanel contentPane;
	private static GuiViewCustomer instance=null;
	private CtrCustomer cc= new CtrCustomer();
	private GuiMain gm = GuiMain.getInstance();
	
	private Customer customer=cc.searchCustomerByName(gm.list_1.getSelectedItem());
	
	
	
		JOptionPane.showMessageDialog(null, "Bullshit, stefan :)).", "Error", JOptionPane.ERROR_MESSAGE);
	
			
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public static GuiViewCustomer getInstance()
	{
		if(instance == null) {
	         instance = new GuiViewCustomer();
	      }
	      return instance;
	}
	public GuiViewCustomer() {
		setModal(true);
		setTitle("View Customer");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(5, 7, 295, 229);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNameUn = new JLabel("Name:");
		lblNameUn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNameUn.setBounds(10, 11, 108, 14);
		contentPane.add(lblNameUn);
		
		JLabel lblCountryUn = new JLabel("Country:");
		lblCountryUn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCountryUn.setBounds(10, 36, 108, 14);
		contentPane.add(lblCountryUn);
		
		JLabel lblStreetUn = new JLabel("Street:");
		lblStreetUn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStreetUn.setBounds(10, 61, 108, 14);
		contentPane.add(lblStreetUn);
		
		JLabel lblNumberUn = new JLabel("Ph. Nr:");
		lblNumberUn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumberUn.setBounds(10, 86, 108, 14);
		contentPane.add(lblNumberUn);
		
		JLabel lblEmailUn = new JLabel("Email:");
		lblEmailUn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmailUn.setBounds(10, 111, 108, 14);
		contentPane.add(lblEmailUn);
		
		JButton btnCancel = new JButton("Ok");
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GuiViewCustomer.this.dispose();
			}
		});
		btnCancel.setBounds(95, 166, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblBarcode_1 = new JLabel(customer.getName());
		lblBarcode_1.setBounds(95, 13, 140, 14);
		contentPane.add(lblBarcode_1);
		
		JLabel lblCountry = new JLabel(customer.getAddress().getCountry());
		lblCountry.setBounds(95, 38, 140, 14);
		contentPane.add(lblCountry);
		
		JLabel lblStreet = new JLabel(customer.getStreet());
		lblStreet.setBounds(93, 63, 140, 14);
		contentPane.add(lblStreet);
		
		JLabel lblNumber = new JLabel(customer.getPhoneNr());
		lblNumber.setBounds(93, 86, 140, 14);
		contentPane.add(lblNumber);
		
		JLabel lblEmail = new JLabel(customer.getEmail());
		lblEmail.setBounds(93, 113, 140, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCityUn = new JLabel("City:");
		lblCityUn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCityUn.setBounds(10, 136, 108, 14);
		contentPane.add(lblCityUn);
		
		JLabel lblCity = new JLabel(customer.getAddress().getCity());
		lblCity.setBounds(95, 136, 140, 14);
		contentPane.add(lblCity);
	}

}
