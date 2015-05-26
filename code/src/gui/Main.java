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
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Color;
/**
@author frunziss
*/
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
	private JTextField textField_5;
	private JTextField textField_6;

	private static void checkIfRunning() {
	  try {
	    //Bind to localhost adapter with a zero connection queue 
	    socket = new ServerSocket(PORT,0,InetAddress.getByAddress(new byte[] {127,0,0,1}));
	  }
	  catch (BindException e) {
	    JOptionPane.showMessageDialog(null,  "Already running");
	    
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
		setResizable(false);
		getContentPane().setBackground(Color.DARK_GRAY);
		setBackground(new Color(204, 204, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Adrian Frunza\\Desktop\\Entafarma.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Main");
		getContentPane().setLayout(null);
		this.setBounds(5, 7, 650, 400);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(10, 11, 606, 344);
	
		getContentPane().add(tabbedPane);
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBackground(Color.GRAY);
		itemPanel.setBounds(20, 116, 147, 239);
		
		
		JPanel customerPanel = new JPanel();
		customerPanel.setBackground(Color.GRAY);
		customerPanel.setBounds(116, 116, 147, 239);
		
		JPanel purchasePanel = new JPanel();
		purchasePanel.setBackground(Color.GRAY);
		purchasePanel.setBounds(20,116,147,239);
		
		JPanel supplierPanel = new JPanel();
		supplierPanel.setBackground(Color.GRAY);
		supplierPanel.setBounds(20,116,147,239);
		
		
		JPanel salePanel = new JPanel();
		salePanel.setBackground(Color.GRAY);
		salePanel.setBounds(20, 116, 147, 239);
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
		button_5.setForeground(new Color(0, 0, 0));
		button_5.setBackground(new Color(204, 204, 255));
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
		list_3.setForeground(Color.BLACK);
		list_3.setBackground(Color.LIGHT_GRAY);
		list_3.setBounds(10, 38, 360, 222);
		salePanel.add(list_3);
		
		JButton button_6 = new JButton("Add");
		button_6.setBackground(new Color(204, 204, 255));
		button_6.setForeground(new Color(0, 0, 0));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sale s = new Sale();
				s.setVisible(true);
				
				
			}
		});
		button_6.setBounds(10, 266, 81, 23);
		salePanel.add(button_6);
		
		JButton button_7 = new JButton("View Information");
		button_7.setForeground(new Color(0, 0, 0));
		button_7.setBackground(new Color(204, 204, 255));
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
		btnRegisterPaymeny.setForeground(new Color(0, 0, 0));
		btnRegisterPaymeny.setBackground(new Color(204, 204, 255));
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
		btnMarkAsPacked.setForeground(new Color(0, 0, 0));
		btnMarkAsPacked.setBackground(new Color(204, 204, 255));
		btnMarkAsPacked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} */
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
		btnItem.setBackground(new Color(204, 204, 255));
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
		list.setForeground(Color.BLACK);
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(90, 38, 416, 222);
		itemPanel.add(list);
		
		JButton btnViewInformation = new JButton("View");
		btnViewInformation.setBackground(new Color(204, 204, 255));
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
		btnAdd.setBackground(new Color(204, 204, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddItem addItem = new AddItem();
				addItem.setVisible(true);
				
			}
		});
		btnAdd.setBounds(90, 266, 89, 23);
		itemPanel.add(btnAdd);
		
		JButton btnUpdateStock = new JButton("Update stock");
		btnUpdateStock.setBackground(new Color(204, 204, 255));
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
		btnModify_1.setBackground(new Color(204, 204, 255));
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
		button.setBackground(new Color(204, 204, 255));
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
		list_1.setForeground(Color.BLACK);
		list_1.setBackground(Color.LIGHT_GRAY);
		list_1.setBounds(90, 37, 416, 222);
		customerPanel.add(list_1);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.setBackground(new Color(204, 204, 255));
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomer ad = new AddCustomer();
				ad.setVisible(true);
				
			}
		});
		btnAdd_1.setBounds(90, 266, 124, 23);
		customerPanel.add(btnAdd_1);
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBackground(new Color(204, 204, 255));
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
		btnViewInformation_1.setBackground(new Color(204, 204, 255));
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
		
		tabbedPane.addTab("Purchase", purchasePanel);
		purchasePanel.setLayout(null);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(90, 12, 266, 20);
		purchasePanel.add(textField_5);
		
		JButton button_8 = new JButton("Search");
		button_8.setBackground(new Color(204, 204, 255));
		button_8.addActionListener(new ActionListener() {
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
		button_8.setBounds(361, 11, 90, 23);
		purchasePanel.add(button_8);
		
		List list_4 = new List();
		list_4.setForeground(Color.BLACK);
		list_4.setBackground(Color.LIGHT_GRAY);
		list_4.setBounds(90, 38, 360, 222);
		purchasePanel.add(list_4);
		
		JButton btnAdd_2 = new JButton("Add");
		btnAdd_2.setBackground(new Color(204, 204, 255));
		btnAdd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Purchase p = new Purchase();
				p.setVisible(true);
			}
		});
		btnAdd_2.setBounds(90, 266, 89, 23);
		purchasePanel.add(btnAdd_2);
		
		JButton btnViewpurchase = new JButton("View");
		btnViewpurchase.setBackground(new Color(204, 204, 255));
		btnViewpurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*	if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
				else
				{*/
				ViewPurchase vs = new ViewPurchase();
				vs.setVisible(true);
				//*/
			}
		});
		btnViewpurchase.setBounds(179, 266, 99, 23);
		purchasePanel.add(btnViewpurchase);
		
		JButton btnMarkedAsReceived = new JButton("Mark as received");
		btnMarkedAsReceived.setBackground(new Color(204, 204, 255));
		btnMarkedAsReceived.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} */
				int response=JOptionPane.showConfirmDialog(null, "Are you sure you want to mark the selected purchase as received?", "Receive",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.NO_OPTION) {
				      System.out.println("No button clicked");
				    } else if (response == JOptionPane.YES_OPTION) {
				      JOptionPane.showMessageDialog(null, "The selected purchase was marked as received.");
				    } else if (response == JOptionPane.CLOSED_OPTION) {
				      System.out.println("JOptionPane closed");
				    }
				
			}
		});
		btnMarkedAsReceived.setBounds(278, 266, 173, 23);
		purchasePanel.add(btnMarkedAsReceived);
		JButton btnMarkAsPaid = new JButton("Mark as paid");
		btnMarkAsPaid.setBackground(new Color(204, 204, 255));
		btnMarkAsPaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} */
				int response=JOptionPane.showConfirmDialog(null, "Are you sure you want to mark the selected purchase as paid?", "Payment",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.NO_OPTION) {
				      System.out.println("No button clicked");
				    } else if (response == JOptionPane.YES_OPTION) {
				      JOptionPane.showMessageDialog(null, "The selected purchase was marked as paid");
				    } else if (response == JOptionPane.CLOSED_OPTION) {
				      System.out.println("JOptionPane closed");
				    }
			}
		});
		btnMarkAsPaid.setBounds(477, 99, 114, 65);
		purchasePanel.add(btnMarkAsPaid);
		tabbedPane.addTab("Supplier", supplierPanel);
		supplierPanel.setLayout(null);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(90, 11, 327, 20);
		supplierPanel.add(textField_6);
		
		JButton button_9 = new JButton("Search");
		button_9.setBackground(new Color(204, 204, 255));
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		button_9.setBounds(417, 11, 89, 23);
		supplierPanel.add(button_9);
		
		List list_5 = new List();
		list_5.setForeground(Color.BLACK);
		list_5.setBackground(Color.LIGHT_GRAY);
		list_5.setBounds(90, 37, 416, 222);
		supplierPanel.add(list_5);
		
		JButton button_10 = new JButton("Add");
		button_10.setBackground(new Color(204, 204, 255));
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddSupplier ad = new AddSupplier();
				ad.setVisible(true);
			}
		});
		button_10.setBounds(90, 266, 124, 23);
		supplierPanel.add(button_10);
		
		JButton button_11 = new JButton("View Information");
		button_11.setBackground(new Color(204, 204, 255));
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*	if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
				else
				{*/
				ViewSupplier vs = new ViewSupplier();
				vs.setVisible(true);
				//*/
			}
		});
		button_11.setBounds(215, 266, 134, 23);
		supplierPanel.add(button_11);
		
		JButton button_12 = new JButton("Modify");
		button_12.setBackground(new Color(204, 204, 255));
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*	if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
				else
				{*/
					UpdateSupplier us = new UpdateSupplier();
					us.setVisible(true);
				//*/
			}
		});
		button_12.setBounds(350, 266, 156, 23);
		supplierPanel.add(button_12);
		
		JPanel employeePanel = new JPanel();
		employeePanel.setBackground(Color.GRAY);
		employeePanel.setBounds(20, 116, 147, 239);
		tabbedPane.addTab("Employee", employeePanel);
		
		tabbedPane.setEnabledAt(5, false);
		employeePanel.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(90, 12, 327, 20);
		employeePanel.add(textField_4);
		
		JButton button_1 = new JButton("Search");
		button_1.setBackground(new Color(204, 204, 255));
		button_1.setBounds(417, 11, 89, 23);
		employeePanel.add(button_1);
		
		List list_2 = new List();
		list_2.setForeground(Color.BLACK);
		list_2.setBackground(Color.LIGHT_GRAY);
		list_2.setBounds(90, 37, 416, 222);
		employeePanel.add(list_2);
		
		JButton button_2 = new JButton("Add");
		button_2.setBackground(new Color(204, 204, 255));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setBounds(90, 266, 124, 23);
		employeePanel.add(button_2);
		
		JButton button_3 = new JButton("View Information");
		button_3.setBackground(new Color(204, 204, 255));
		button_3.setBounds(215, 266, 134, 23);
		employeePanel.add(button_3);
		
		JButton button_4 = new JButton("Modify");
		button_4.setBackground(new Color(204, 204, 255));
		button_4.setBounds(350, 266, 156, 23);
		employeePanel.add(button_4);
		
		JLabel lblNotWorkingYet = new JLabel("Not working yet");
		lblNotWorkingYet.setBounds(215, 141, 46, 14);
		employeePanel.add(lblNotWorkingYet);
	}
}
