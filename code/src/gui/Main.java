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
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
				vi.setVisible(true);
				}
			}
		});
		btnViewInformation.setBounds(179, 266, 124, 23);
		itemPanel.add(btnViewInformation);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddItem addItem = new AddItem();
				addItem.setVisible(true);
			}
		});
		btnAdd.setBounds(90, 266, 89, 23);
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
				us.setVisible(true);
				}
				
				
				
			}
		});
		btnUpdateStock.setBounds(302, 266, 115, 23);
		itemPanel.add(btnUpdateStock);
		
		JButton btnModify_1 = new JButton("Modify");
		btnModify_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				UpdateItem ui=new UpdateItem();
				ui.setVisible(true);
			}
		});
		btnModify_1.setBounds(417, 266, 89, 23);
		itemPanel.add(btnModify_1);
		tabbedPane.addTab("Customer", customerPanel);
		customerPanel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(90, 12, 327, 20);
		customerPanel.add(textField_1);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the name of the customer in order to be displayed. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
			}
		});
		button.setBounds(417, 11, 89, 23);
		customerPanel.add(button);
		
		List list_1 = new List();
		list_1.setBounds(90, 38, 416, 222);
		customerPanel.add(list_1);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomer ad = new AddCustomer();
				ad.setVisible(true);
			}
		});
		btnAdd_1.setBounds(90, 266, 124, 23);
		customerPanel.add(btnAdd_1);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateCustomer uc = new UpdateCustomer();
				uc.setVisible(true);
			}
		});
		btnModify.setBounds(350, 266, 156, 23);
		customerPanel.add(btnModify);
		
		JButton btnViewInformation_1 = new JButton("View Information");
		btnViewInformation_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No customer were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
				else
				{
				ViewCustomer vc = new ViewCustomer();
				vc.setVisible(true);
				}
			}
		});
		btnViewInformation_1.setBounds(215, 266, 134, 23);
		customerPanel.add(btnViewInformation_1);
		tabbedPane.addTab("Sale", salePanel);
		salePanel.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(90, 12, 327, 20);
		salePanel.add(textField_3);
		
		JButton button_5 = new JButton("Search");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the name of the customer in order to be displayed. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
			}
		});
		button_5.setBounds(417, 11, 89, 23);
		salePanel.add(button_5);
		
		List list_3 = new List();
		list_3.setBounds(90, 38, 416, 222);
		salePanel.add(list_3);
		
		JButton button_6 = new JButton("Add");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sale s = new Sale();
				s.setVisible(true);
			}
		});
		button_6.setBounds(90, 266, 124, 23);
		salePanel.add(button_6);
		
		JButton button_7 = new JButton("View Information");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} */
				ViewSale vs = new ViewSale();
				vs.setVisible(true);
				
			}
		});
		button_7.setBounds(215, 266, 134, 23);
		salePanel.add(button_7);
		
		JButton button_8 = new JButton("Modify");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
			}
		});
		button_8.setBounds(350, 266, 156, 23);
		salePanel.add(button_8);
		tabbedPane.addTab("Invoice", invoicePanel);
		invoicePanel.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(90, 12, 327, 20);
		invoicePanel.add(textField_2);
		
		JButton button_1 = new JButton("Search");
		button_1.setBounds(417, 11, 89, 23);
		invoicePanel.add(button_1);
		
		List list_2 = new List();
		list_2.setBounds(90, 38, 416, 222);
		invoicePanel.add(list_2);
		
		JButton button_2 = new JButton("Add");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sale s = new Sale();
				s.setVisible(true);
			}
		});
		button_2.setBounds(90, 266, 124, 23);
		invoicePanel.add(button_2);
		
		JButton button_3 = new JButton("View Information");
		button_3.setBounds(215, 266, 134, 23);
		invoicePanel.add(button_3);
		
		JButton button_4 = new JButton("Modify");
		button_4.setBounds(350, 266, 156, 23);
		invoicePanel.add(button_4);
		
	}
}
