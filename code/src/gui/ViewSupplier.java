package gui;

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

public class ViewSupplier extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	@author frunziss
	*/

	/**
	 * Create the frame.
	 */
	public ViewSupplier() {
		setModal(true);
		setTitle("View Supplier");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(5, 7, 295, 325);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBarcode = new JLabel("Id:");
		lblBarcode.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBarcode.setBounds(10, 11, 108, 14);
		contentPane.add(lblBarcode);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(10, 36, 108, 14);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("Phone:");
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
				
				ViewSupplier.this.dispose();
			}
		});
		btnCancel.setBounds(95, 262, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblBarcode_1 = new JLabel("id");
		lblBarcode_1.setBounds(95, 13, 140, 14);
		contentPane.add(lblBarcode_1);
		
		JLabel lblName_1 = new JLabel("name");
		lblName_1.setBounds(95, 38, 140, 14);
		contentPane.add(lblName_1);
		
		JLabel lblPrice_1 = new JLabel("phone");
		lblPrice_1.setBounds(93, 63, 140, 14);
		contentPane.add(lblPrice_1);
		
		JLabel lblStock_1 = new JLabel("phoneNumber");
		lblStock_1.setBounds(93, 86, 140, 14);
		contentPane.add(lblStock_1);
		
		JLabel lblType_1 = new JLabel("email");
		lblType_1.setBounds(93, 113, 140, 14);
		contentPane.add(lblType_1);
		
		JLabel lblStreet_1 = new JLabel("street");
		lblStreet_1.setBounds(93, 139, 140, 14);
		contentPane.add(lblStreet_1);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStreet.setBounds(10, 137, 108, 14);
		contentPane.add(lblStreet);
		
		JLabel lblCountry_1 = new JLabel("city");
		lblCountry_1.setBounds(95, 166, 140, 14);
		contentPane.add(lblCountry_1);
		
		JLabel lblCountry = new JLabel("City:");
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCountry.setBounds(12, 164, 108, 14);
		contentPane.add(lblCountry);
		
		JLabel lblCountry_3 = new JLabel("country");
		lblCountry_3.setBounds(93, 193, 140, 14);
		contentPane.add(lblCountry_3);
		
		JLabel lblCountry_2 = new JLabel("Country:");
		lblCountry_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCountry_2.setBounds(10, 191, 108, 14);
		contentPane.add(lblCountry_2);
	}

}
