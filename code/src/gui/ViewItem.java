package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class ViewItem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ViewItem() {
		setTitle("View Item");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(5, 7, 295, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBarcode = new JLabel("Barcode:");
		lblBarcode.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBarcode.setBounds(10, 11, 108, 14);
		contentPane.add(lblBarcode);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(10, 36, 108, 14);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice.setBounds(10, 61, 108, 14);
		contentPane.add(lblPrice);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStock.setBounds(10, 86, 108, 14);
		contentPane.add(lblStock);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblType.setBounds(10, 111, 108, 14);
		contentPane.add(lblType);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCategory.setBounds(10, 136, 108, 14);
		contentPane.add(lblCategory);
		
		JButton btnCancel = new JButton("Ok");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewItem.this.dispose();
			}
		});
		btnCancel.setBounds(93, 161, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblBarcode_1 = new JLabel("barcode");
		lblBarcode_1.setBounds(95, 13, 140, 14);
		contentPane.add(lblBarcode_1);
		
		JLabel lblName_1 = new JLabel("name");
		lblName_1.setBounds(95, 38, 140, 14);
		contentPane.add(lblName_1);
		
		JLabel lblPrice_1 = new JLabel("price");
		lblPrice_1.setBounds(93, 63, 140, 14);
		contentPane.add(lblPrice_1);
		
		JLabel lblStock_1 = new JLabel("stock");
		lblStock_1.setBounds(93, 86, 140, 14);
		contentPane.add(lblStock_1);
		
		JLabel lblType_1 = new JLabel("type");
		lblType_1.setBounds(93, 113, 140, 14);
		contentPane.add(lblType_1);
		
		JLabel lblCategory_1 = new JLabel("category");
		lblCategory_1.setBounds(93, 138, 140, 14);
		contentPane.add(lblCategory_1);
	}

}
