package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UpdateStock extends JDialog {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public UpdateStock() {
		setModal(true);
		setTitle("Update Stock");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 389, 189);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(100, 11, 227, 14);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("Current stock:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(22, 45, 192, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCurrstock = new JLabel("currStock");
		lblCurrstock.setBounds(152, 47, 144, 14);
		contentPane.add(lblCurrstock);
		
		JLabel lblInmputTheAmount = new JLabel("Input the amount to be added to the current stock:");
		lblInmputTheAmount.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInmputTheAmount.setBounds(29, 85, 372, 14);
		contentPane.add(lblInmputTheAmount);
		
		textField = new JTextField();
		textField.setBounds(39, 110, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Update");
		btnSubmit.setBackground(new Color(204, 204, 255));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input a positive value. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}*/
			}
		});
		btnSubmit.setBounds(135, 110, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	Main.getFrames()[0].setEnabled(true);
				UpdateStock.this.dispose();
			}
		});
		btnCancel.setBounds(234, 109, 89, 23);
		contentPane.add(btnCancel);
	}

}
