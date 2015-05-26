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

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;
import java.awt.Color;

public class ViewSale extends JDialog {

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
	public ViewSale() {
		setModal(true);
		setTitle("View Sale");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 611, 354);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSaleNr = new JLabel("Sale Nr:");
		lblSaleNr.setBounds(10, 11, 122, 14);
		lblSaleNr.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblSaleNr);
		
		JLabel lblSalenr = new JLabel("saleNr");
		lblSalenr.setBounds(214, 13, 136, 14);
		contentPane.add(lblSalenr);
		
		JLabel lblCustomerName = new JLabel("Customer name:");
		lblCustomerName.setBounds(10, 36, 122, 14);
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblCustomerName);
		
		JLabel lblCustomername = new JLabel("customerName");
		lblCustomername.setBounds(214, 38, 83, 14);
		contentPane.add(lblCustomername);
		
		JButton btnView = new JButton("View Customer");
		btnView.setBackground(new Color(204, 204, 255));
		btnView.setBounds(230, 291, 122, 23);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCustomer vc = new ViewCustomer();
				vc.setVisible(true);
				
			}
		});
		contentPane.add(btnView);
		
		JLabel lblEmployeeName = new JLabel("Employee name:");
		lblEmployeeName.setBounds(10, 61, 122, 14);
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblEmployeeName);
		
		JLabel lblEmployeename = new JLabel("employeeName");
		lblEmployeename.setBounds(214, 63, 83, 14);
		contentPane.add(lblEmployeename);
		
		JButton btnViewEmployee = new JButton("View Employee");
		btnViewEmployee.setBackground(new Color(204, 204, 255));
		btnViewEmployee.setBounds(352, 291, 122, 23);
		contentPane.add(btnViewEmployee);
		
		JLabel lblTotalPrice = new JLabel("Total price:");
		lblTotalPrice.setBounds(10, 136, 122, 14);
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblTotalPrice);
		
		JLabel lblTotalprice = new JLabel("totalPrice");
		lblTotalprice.setBounds(214, 136, 83, 14);
		contentPane.add(lblTotalprice);
		
		List list = new List();
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(367, 10, 228, 215);
		contentPane.add(list);
		
		JButton btnViewProduct = new JButton("View Product");
		btnViewProduct.setBounds(367, 225, 228, 23);
		btnViewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				*/
				JOptionPane.showMessageDialog(new JFrame(), "Name: "+"name\nQuantitiy: "+"quantity\nPrice of selling: price", "Show",
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		contentPane.add(btnViewProduct);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.setBounds(473, 291, 122, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	Main.getFrames()[0].setEnabled(true);
				ViewSale.this.dispose();
			}
		});
		contentPane.add(btnCancel);
		
		JLabel lblDiscount = new JLabel("Discount:");
		lblDiscount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDiscount.setBounds(10, 111, 122, 14);
		contentPane.add(lblDiscount);
		
		JLabel lblDiscount_1 = new JLabel("discount");
		lblDiscount_1.setBounds(214, 111, 83, 14);
		contentPane.add(lblDiscount_1);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(10, 86, 122, 14);
		contentPane.add(lblDate);
		
		JLabel lblDate_1 = new JLabel("date");
		lblDate_1.setBounds(214, 88, 83, 14);
		contentPane.add(lblDate_1);
		
		JLabel lblDatePacked = new JLabel("Date packed:");
		lblDatePacked.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatePacked.setBounds(10, 161, 122, 14);
		contentPane.add(lblDatePacked);
		
		JLabel lblDatePaid = new JLabel("Date paid:");
		lblDatePaid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatePaid.setBounds(10, 186, 122, 14);
		contentPane.add(lblDatePaid);
		
		JLabel lblDateSent = new JLabel("Date sent:");
		lblDateSent.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateSent.setBounds(10, 211, 122, 14);
		contentPane.add(lblDateSent);
		
		JLabel lblDatepacked = new JLabel("datePacked");
		lblDatepacked.setBounds(214, 163, 83, 14);
		contentPane.add(lblDatepacked);
		
		JLabel lblDatepaid = new JLabel("datePaid");
		lblDatepaid.setBounds(214, 188, 83, 14);
		contentPane.add(lblDatepaid);
		
		JLabel label = new JLabel("datePaid");
		label.setBounds(214, 211, 83, 14);
		contentPane.add(label);
	}
}
