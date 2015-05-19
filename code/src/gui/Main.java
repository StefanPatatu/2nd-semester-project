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
import javax.swing.SwingUtilities;

import java.awt.List;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Main extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	private static final int PORT = 9999;
	private static ServerSocket socket;    

	private static void checkIfRunning() {
	  try {
	    //Bind to localhost adapter with a zero connection queue 
	    socket = new ServerSocket(PORT,0,InetAddress.getByAddress(new byte[] {127,0,0,1}));
	  }
	  catch (BindException e) {
	    System.err.println("Already running.");
	    System.exit(1);
	  }
	  catch (IOException e) {
	    System.err.println("Unexpected error.");
	    e.printStackTrace();
	    System.exit(2);
	  }
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkIfRunning();
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
		//setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JPanel employeePanel = new JPanel();
		employeePanel.setBounds(20, 116, 147, 239);
		
		
		
		
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
			/*	if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the name of the item in order to be displayed. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				else
				{
					
				}*/
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
			/*	if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
				else
				{*/
				ViewItem vi = new ViewItem();
				vi.setVisible(true);
				
				//}
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
				 /*if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				
				else{*/
				UpdateStock us = new UpdateStock();
				us.setVisible(true);
			
				//}
				
				
				
			}
		});
		btnUpdateStock.setBounds(302, 266, 115, 23);
		itemPanel.add(btnUpdateStock);
		
		JButton btnModify_1 = new JButton("Modify");
		btnModify_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				else
				{*/
				UpdateItem ui=new UpdateItem();
				ui.setVisible(true);
				
				//}
			}
		});
		btnModify_1.setBounds(417, 266, 89, 23);
		itemPanel.add(btnModify_1);
		tabbedPane.addTab("Customer", customerPanel);
		customerPanel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode()==KeyEvent.VK_ENTER){
					//IMPORTANT 
				
		        }
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(90, 11, 327, 20);
		customerPanel.add(textField_1);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the name of the customer in order to be displayed. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				else
				{
					
				}*/
			}
		});
		button.setBounds(417, 11, 89, 23);
		customerPanel.add(button);
		
		List list_1 = new List();
		list_1.setBounds(90, 37, 416, 222);
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
			/*	if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No customer were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
				else
				{*/
				UpdateCustomer uc = new UpdateCustomer();
				uc.setVisible(true);
				
			//	}
			}
		});
		btnModify.setBounds(350, 266, 156, 23);
		customerPanel.add(btnModify);
		
		JButton btnViewInformation_1 = new JButton("View Information");
		btnViewInformation_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*	if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No customer were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
				else
				{*/
				ViewCustomer vc = new ViewCustomer();
				vc.setVisible(true);
				
				//}
			}
		});
		btnViewInformation_1.setBounds(215, 266, 134, 23);
		customerPanel.add(btnViewInformation_1);
		tabbedPane.addTab("Sale", salePanel);
		salePanel.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					//IMPORTANT 
				
		        }
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(10, 12, 266, 20);
		salePanel.add(textField_3);
		
		JButton button_5 = new JButton("Search");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the name of the customer in order to be displayed. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}*/
			}
		});
		button_5.setBounds(281, 11, 90, 23);
		salePanel.add(button_5);
		
		List list_3 = new List();
		list_3.setBounds(10, 38, 360, 222);
		salePanel.add(list_3);
		
		JButton button_6 = new JButton("Add");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sale s = new Sale();
				s.setVisible(true);
				
				
			}
		});
		button_6.setBounds(10, 266, 81, 23);
		salePanel.add(button_6);
		
		JButton button_7 = new JButton("View Information");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
				else
				{
				*/
				
				ViewSale vs = new ViewSale();
				vs.setVisible(true);
				
				//}
				
			}
		});
		button_7.setBounds(94, 266, 113, 23);
		salePanel.add(button_7);
		
		JButton btnRegisterPaymeny = new JButton("Register payment for invoice");
		btnRegisterPaymeny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
				else
				{
				
				}*/
			}
		});
		btnRegisterPaymeny.setBounds(382, 53, 209, 58);
		salePanel.add(btnRegisterPaymeny);
		
		JButton btnMarkAsPacked = new JButton("Mark as packed");
		btnMarkAsPacked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response=JOptionPane.showConfirmDialog(null, "Are you sure you want to mark the selected sale as packed?", "Pack",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.NO_OPTION) {
				      System.out.println("No button clicked");
				    } else if (response == JOptionPane.YES_OPTION) {
				      JOptionPane.showMessageDialog(null, "The selected item was marked as packed");
				    } else if (response == JOptionPane.CLOSED_OPTION) {
				      System.out.println("JOptionPane closed");
				    }
				  
		
			}
		});
		btnMarkAsPacked.setBounds(209, 266, 162, 23);
		salePanel.add(btnMarkAsPacked);
		tabbedPane.addTab("Employee", employeePanel);
		employeePanel.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(90, 12, 327, 20);
		employeePanel.add(textField_4);
		
		JButton button_1 = new JButton("Search");
		button_1.setBounds(417, 11, 89, 23);
		employeePanel.add(button_1);
		
		List list_2 = new List();
		list_2.setBounds(90, 37, 416, 222);
		employeePanel.add(list_2);
		
		JButton button_2 = new JButton("Add");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setBounds(90, 266, 124, 23);
		employeePanel.add(button_2);
		
		JButton button_3 = new JButton("View Information");
		button_3.setBounds(215, 266, 134, 23);
		employeePanel.add(button_3);
		
		JButton button_4 = new JButton("Modify");
		button_4.setBounds(350, 266, 156, 23);
		employeePanel.add(button_4);
		
		
		
		
	}
}
