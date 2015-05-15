package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class Main extends JFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setTitle("Main");
		getContentPane().setLayout(null);
		this.setBounds(5, 7, 650, 400);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 606, 344);
	
		getContentPane().add(tabbedPane);
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBounds(20, 116, 147, 239);
		
		
		JPanel customerPanel = new JPanel();
		customerPanel.setBounds(116, 116, 147, 239);
		
		
		JPanel salePanel = new JPanel();
		salePanel.setBounds(20, 116, 147, 239);
		
		JPanel invoicePanel = new JPanel();
		invoicePanel.setBounds(20, 116, 147, 239);
		
		
		
		
		tabbedPane.addTab("Item", itemPanel);
		itemPanel.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			@Override
			public void keyPressed(KeyEvent k) {
				if (k.getKeyCode()==KeyEvent.VK_ENTER){
					//IMPORTANT 
				
		        }
			}
		});
		textField.setBounds(90, 12, 327, 20);
		itemPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnItem = new JButton("Search");
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the name of the item in order to be displayed. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
			}
		});
		btnItem.setBounds(417, 11, 89, 23);
		itemPanel.add(btnItem);
		
		List list = new List();
		list.setBounds(90, 38, 416, 222);
		itemPanel.add(list);
		
		JButton btnViewInformation = new JButton("View information");
		btnViewInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
				else
				{
				ViewItem vi = new ViewItem();
				vi.main(null);
				}
			}
		});
		btnViewInformation.setBounds(215, 266, 140, 23);
		itemPanel.add(btnViewInformation);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddItem addItem = new AddItem();
				addItem.main(null);
			}
		});
		btnAdd.setBounds(90, 266, 123, 23);
		itemPanel.add(btnAdd);
		
		JButton btnUpdateStock = new JButton("Update stock");
		btnUpdateStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				
				else{
				UpdateStock us = new UpdateStock();
				us.main(null);
				}
				
				
				
			}
		});
		btnUpdateStock.setBounds(357, 266, 149, 23);
		itemPanel.add(btnUpdateStock);
		tabbedPane.addTab("Customer", customerPanel);
		tabbedPane.addTab("Sale", salePanel);
		salePanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Create Sale");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sale sale = new Sale();
				sale.main(null);
			}
		});
		btnNewButton.setBounds(10, 11, 581, 294);
		salePanel.add(btnNewButton);
		tabbedPane.addTab("Invoice", invoicePanel);
		
	}
}
