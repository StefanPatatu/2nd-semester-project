package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;

public class ViewSale extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ViewSale() {
		setTitle("View Sale");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 397, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSaleNr = new JLabel("Sale Nr:");
		lblSaleNr.setBounds(68, 11, 122, 14);
		lblSaleNr.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblSaleNr);
		
		JLabel lblSalenr = new JLabel("saleNr");
		lblSalenr.setBounds(188, 13, 136, 14);
		contentPane.add(lblSalenr);
		
		JLabel lblCustomerName = new JLabel("Customer name:");
		lblCustomerName.setBounds(68, 36, 122, 14);
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblCustomerName);
		
		JLabel lblCustomername = new JLabel("customerName");
		lblCustomername.setBounds(188, 38, 83, 14);
		contentPane.add(lblCustomername);
		
		JButton btnView = new JButton("View Customer");
		btnView.setBounds(0, 342, 122, 23);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCustomer vc = new ViewCustomer();
				vc.setVisible(true);
			}
		});
		contentPane.add(btnView);
		
		JLabel lblEmployeeName = new JLabel("Employee name:");
		lblEmployeeName.setBounds(68, 61, 122, 14);
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblEmployeeName);
		
		JLabel lblEmployeename = new JLabel("employeeName");
		lblEmployeename.setBounds(188, 63, 83, 14);
		contentPane.add(lblEmployeename);
		
		JButton btnViewEmployee = new JButton("View Employee");
		btnViewEmployee.setBounds(130, 342, 122, 23);
		contentPane.add(btnViewEmployee);
		
		JLabel lblTotalPrice = new JLabel("Total price:");
		lblTotalPrice.setBounds(68, 86, 122, 14);
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblTotalPrice);
		
		JLabel lblTotalprice = new JLabel("totalPrice");
		lblTotalprice.setBounds(188, 86, 83, 14);
		contentPane.add(lblTotalprice);
		
		List list = new List();
		list.setBounds(68, 106, 228, 196);
		contentPane.add(list);
		
		JButton btnViewProduct = new JButton("View Product");
		btnViewProduct.setBounds(68, 303, 228, 23);
		btnViewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				JOptionPane.showMessageDialog(new JFrame(), "Name: "+"name\nQuantitiy: "+"quantity\nPrice of selling: price", "Show",
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		contentPane.add(btnViewProduct);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(262, 342, 122, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSale.this.dispose();
			}
		});
		contentPane.add(btnCancel);
	}
}
