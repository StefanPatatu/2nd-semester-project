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

public class UpdateItem extends JDialog {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public UpdateItem() {
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Update Item");
		getContentPane().setLayout(null);
		this.setBounds(5, 7, 330, 202);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 304, 151);
	
		getContentPane().add(tabbedPane);
		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(20, 116, 50, 50);
		
		
		JPanel pricePanel = new JPanel();
		pricePanel.setBounds(116, 116, 50, 50);
		
		
		JPanel salePanel = new JPanel();
		salePanel.setBounds(20, 116, 50, 50);
		
		JPanel invoicePanel = new JPanel();
		invoicePanel.setBounds(20, 116, 50, 50);
		
		
		
		
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
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Main.getFrames()[0].setEnabled(true);
				UpdateItem.this.dispose();
			}
		});
		btnCancel.setBounds(200, 89, 89, 23);
		namePanel.add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the name of the item in order to be displayed. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}*/
			}
		});
		btnAdd.setBounds(109, 89, 89, 23);
		namePanel.add(btnAdd);
		tabbedPane.addTab("UpdatePrice", pricePanel);
		pricePanel.setLayout(null);
		
		JLabel lblCurrentPrice = new JLabel("Current price:");
		lblCurrentPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentPrice.setBounds(10, 11, 119, 14);
		pricePanel.add(lblCurrentPrice);
		
		JLabel lblNewPrice = new JLabel("New price:");
		lblNewPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewPrice.setBounds(10, 36, 103, 14);
		pricePanel.add(lblNewPrice);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setBounds(177, 13, 46, 14);
		pricePanel.add(lblPrice);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 35, 152, 20);
		pricePanel.add(textField_1);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*	if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the name of the item in order to be displayed. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}*/
			}
		});
		button.setBounds(109, 89, 89, 23);
		pricePanel.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	Main.getFrames()[0].setEnabled(true);
				UpdateItem.this.dispose();
			}
		});
		button_1.setBounds(200, 89, 89, 23);
		pricePanel.add(button_1);
		
		
	}
}
