package guiLayer;

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
import java.util.ArrayList;

import javax.swing.JLabel;

import controlLayer.CtrCheckConnection;
import controlLayer.CtrCustomer;
import controlLayer.CtrEmployee;
import controlLayer.CtrItem;
import modelLayer.Customer;
import modelLayer.Employee;
import modelLayer.Item;
import authLayer.DbConfig;

import java.awt.Toolkit;
import java.awt.Color;
/**
@author frunziss
*/
public class GuiMain extends JFrame {
	public CtrCheckConnection ccc = new CtrCheckConnection();
	private static ArrayList<GuiCustomerWrapper<Customer>> gcw = new ArrayList<>();
	private static ArrayList<Customer> customers = new ArrayList<>();
	private static ArrayList<GuiEmployeeWrapper<Employee>> gew = new ArrayList<>();
	private static ArrayList<Employee> employees = new ArrayList<>();
	private static ArrayList<GuiItemWrapperGood<Item>> giw = new ArrayList<>();
	private static ArrayList<Item> items = new ArrayList<>();
//	private static List list_customers;
	private static CtrCustomer cc=new CtrCustomer();
	private static CtrEmployee ce=new CtrEmployee();
	private static CtrItem ci=new CtrItem();
	
	private static GuiMain instance=null;
	private JTextField textField_items;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_employees;
	public List list_customers=new List();
	public List list_employees=new List();
	public List list_items=new List();
	

	/**
	 * Launch the application.
	 */
	private static final int PORT = 9999;
	private static ServerSocket socket;    
	private JTextField textField_5;
	private JTextField textField_6;
	
	
	
	
	public static GuiMain getInstance() {
		
		
	      if(instance == null) {
	         instance = new GuiMain();
	      }
	      return instance;
	   }
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
					DbConfig dbb = new DbConfig();
					GuiLogIn gli = new GuiLogIn();
					gli.setVisible(true);
					GuiCheckThread cgt=new GuiCheckThread();
					cgt.start();
				/*if(gli.checkEmployee()>0)
					{
						GuiMain frame = GuiMain.getInstance();
						
						frame.setVisible(true);
						cgt.start();
						
					
					} 
				else*/
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private GuiMain() {
		//-----------------------------------------------------------------------------------------
		try {
			customers=cc.getAllCustomers();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "Can't get all customers. ", "Error", JOptionPane.ERROR_MESSAGE);
		}
		for(Customer curr:customers)
		{
			gcw.add(new GuiCustomerWrapper<Customer>(curr, curr::getName));
			
			
		}
		
		for(GuiCustomerWrapper<Customer>curr:gcw)
		{
			list_customers.add(curr.getObject().getName());
		}
		//-----------------------------------------------------------
		//-----------------------------------------------------------------------------------------
		try {
			employees=ce.getAllEmployees();
			
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "Can't get all customers. ", "Error", JOptionPane.ERROR_MESSAGE);
		}
		for(Employee curr:employees)
		{
			gew.add(new GuiEmployeeWrapper<Employee>(curr, curr::getName));
			
			
		}
		
		
		for(GuiEmployeeWrapper<Employee>curr:gew)
		{if(!curr.getObject().getName().equals("God"))
			list_employees.add(curr.getObject().getName());
		}
		//-----------------------------------------------------------
		//-----------------------------------------------------------------------------------------
				try {
					items=ci.getAllItems();
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(new JFrame(), "Can't get all customers. ", "Error", JOptionPane.ERROR_MESSAGE);
				}
				for(Item curr:items)
				{
					giw.add(new GuiItemWrapperGood<Item>(curr, curr::getName));
					
					
				}
				
				
				for(GuiItemWrapperGood<Item>curr:giw)
				{
					list_items.add(curr.getObject().getName());
				}
				//-----------------------------------------------------------
		setResizable(false);
		getContentPane().setBackground(Color.DARK_GRAY);
		setBackground(new Color(204, 204, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Adrian Frunza\\Desktop\\Entafarma.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GuiMain");
		this.setBounds(5, 7, 650, 400);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 606, 344);
		tabbedPane.setBackground(Color.WHITE);
		
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
		button_5.setBounds(280, 11, 90, 23);
		salePanel.add(button_5);
		
		List list_3 = new List();
		list_3.setForeground(Color.BLACK);
		list_3.setBackground(Color.LIGHT_GRAY);
		list_3.setBounds(10, 38, 360, 222);
		salePanel.add(list_3);
		
		JButton button_6 = new JButton("Add");
		button_6.setEnabled(false);
		button_6.setBackground(new Color(204, 204, 255));
		button_6.setForeground(new Color(0, 0, 0));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiSale s = GuiSale.getInstance();
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
				
				GuiViewSale vs = GuiViewSale.getInstance();
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
		btnRegisterPaymeny.setBounds(376, 175, 209, 64);
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
		btnMarkAsPacked.setBounds(376, 38, 209, 58);
		salePanel.add(btnMarkAsPacked);
		
		JButton btnMarkAsSent = new JButton("Mark as sent");
		btnMarkAsSent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*if(list.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} */
				int response=JOptionPane.showConfirmDialog(null, "Are you sure you want to mark the selected sale as sent?", "sent",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.NO_OPTION) {
				      System.out.println("No button clicked");
				    } else if (response == JOptionPane.YES_OPTION) {
				      JOptionPane.showMessageDialog(null, "The selected item was marked as packed");
				    } else if (response == JOptionPane.CLOSED_OPTION) {
				      System.out.println("JOptionPane closed");
				    }
			}});
		
		btnMarkAsSent.setForeground(Color.BLACK);
		btnMarkAsSent.setBackground(new Color(204, 204, 255));
		btnMarkAsSent.setBounds(376, 107, 209, 59);
		salePanel.add(btnMarkAsSent);
		
		
		
		;
		tabbedPane.addTab("Item", itemPanel);
		itemPanel.setLayout(null);
		
		textField_items = new JTextField();
		textField_items.addKeyListener(new KeyAdapter() {
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
		textField_items.setBounds(90, 12, 327, 20);
		itemPanel.add(textField_items);
		textField_items.setColumns(10);
		
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
				ArrayList<Item> result = new ArrayList<>();
				try {
					 result = ci.searchItemByName(textField_items.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				giw= new ArrayList<>();
				GuiMain.getInstance().list_items.removeAll();
				for(Item curr:result)
				{
					giw.add(new GuiItemWrapperGood<Item>(curr, curr::getName));
				}
				for(GuiItemWrapperGood<Item>curr:giw)
				{
					GuiMain.getInstance().list_items.add(curr.toString());
				}
			}
		});
		btnItem.setBounds(417, 11, 89, 23);
		itemPanel.add(btnItem);
		
		//List list_items = new List();
		list_items.setForeground(Color.BLACK);
		list_items.setBackground(Color.LIGHT_GRAY);
		list_items.setBounds(90, 38, 416, 222);
		itemPanel.add(list_items);
		
		JButton btnViewInformation = new JButton("View");
		btnViewInformation.setBackground(new Color(204, 204, 255));
		btnViewInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_items.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
				else
				{
				GuiViewItem vi = new GuiViewItem();
				vi.setVisible(true);
				
				}
			}
		});
		btnViewInformation.setBounds(179, 266, 124, 23);
		itemPanel.add(btnViewInformation);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(204, 204, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiAddItem addItem = GuiAddItem.getInstance();
				addItem.setVisible(true);
				
			}
		});
		btnAdd.setBounds(90, 266, 89, 23);
		itemPanel.add(btnAdd);
		
		JButton btnUpdateStock = new JButton("Add To stock");
		btnUpdateStock.setBackground(new Color(204, 204, 255));
		btnUpdateStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(list_items.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				
				else{
				GuiUpdateStock us =  new GuiUpdateStock();
				us.setVisible(true);
			
				}
				
				
				
			}
		});
		btnUpdateStock.setBounds(302, 266, 115, 23);
		itemPanel.add(btnUpdateStock);
		
		JButton btnModify_1 = new JButton("Modify");
		
		btnModify_1.setBackground(new Color(204, 204, 255));
		btnModify_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_items.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				else
				{
				GuiUpdateItem ui=new GuiUpdateItem();
				ui.setVisible(true);
				
				}
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
				ArrayList<Customer> result = new ArrayList<>();
			try {
				 result = cc.searchCustomerByName(textField_1.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			gcw= new ArrayList<>();
			GuiMain.getInstance().list_customers.removeAll();
			for(Customer curr:result)
			{
				gcw.add(new GuiCustomerWrapper<Customer>(curr, curr::getName));
			}
			for(GuiCustomerWrapper<Customer>curr:gcw)
			{
				GuiMain.getInstance().list_customers.add(curr.toString());
			}
			
			}
		});
		button.setBounds(417, 11, 89, 23);
		customerPanel.add(button);
		
		 
		list_customers.setForeground(Color.BLACK);
		list_customers.setBackground(Color.LIGHT_GRAY);
		list_customers.setBounds(90, 37, 416, 222);
		customerPanel.add(list_customers);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.setBackground(new Color(204, 204, 255));
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiAddCustomer ad = GuiAddCustomer.getInstance();
				ad.setVisible(true);
				
			}
		});
		btnAdd_1.setBounds(90, 266, 124, 23);
		customerPanel.add(btnAdd_1);
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBackground(new Color(204, 204, 255));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list_customers.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No customer were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
				else
				{
				GuiUpdateCustomer uc = new GuiUpdateCustomer();
				uc.setVisible(true);
				
				}
			}
		});
		btnModify.setBounds(350, 266, 156, 23);
		customerPanel.add(btnModify);
		
		JButton btnViewInformation_1 = new JButton("View Information");
		btnViewInformation_1.setBackground(new Color(204, 204, 255));
		btnViewInformation_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list_customers.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No customer were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
				else
				{
				GuiViewCustomer vc =new GuiViewCustomer();
				vc.setVisible(true);
				
				}
			}
		});
		btnViewInformation_1.setBounds(215, 266, 134, 23);
		customerPanel.add(btnViewInformation_1);
		
		JButton btnNewButton = new JButton("Create sale ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiSale gs = new GuiSale();
				gs.setVisible(true);
			}
		});
		btnNewButton.setBounds(90, 289, 416, 29);
		customerPanel.add(btnNewButton);
		
		
		
	
		
		
		
		
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
				GuiPurchase p = GuiPurchase.getInstance();
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
				GuiViewPurchase vs = GuiViewPurchase.getInstance();
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
				GuiAddSupplier ad = GuiAddSupplier.getInstance();
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
				GuiViewSupplier vs = GuiViewSupplier.getInstance();
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
					GuiUpdateSupplier us =GuiUpdateSupplier.getInstance();
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
		
		//tabbedPane.setEnabledAt(5, false);
		employeePanel.setLayout(null);
		
		textField_employees = new JTextField();
		textField_employees.setColumns(10);
		textField_employees.setBounds(90, 12, 327, 20);
		employeePanel.add(textField_employees);
		
		JButton button_1 = new JButton("Search");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*	if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the name of the customer in order to be displayed. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				else
				{
					
				}*/
				ArrayList<Employee> result = new ArrayList<>();
			try {
				 result = ce.searchEmployeeByName(textField_employees.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			gew= new ArrayList<>();
			GuiMain.getInstance().list_employees.removeAll();
			for(Employee curr:result)
			{
				gew.add(new GuiEmployeeWrapper<Employee>(curr, curr::getName));
			}
			for(GuiEmployeeWrapper<Employee>curr:gew)
			{	if(!curr.toString().equalsIgnoreCase("God"))
				GuiMain.getInstance().list_employees.add(curr.toString());
			}
			}
		});
		button_1.setBackground(new Color(204, 204, 255));
		button_1.setBounds(417, 11, 89, 23);
		employeePanel.add(button_1);
		
		//List list_employees = new List();
		list_employees.setForeground(Color.BLACK);
		list_employees.setBackground(Color.LIGHT_GRAY);
		list_employees.setBounds(90, 37, 416, 222);
		employeePanel.add(list_employees);
		
		JButton button_2 = new JButton("Add");
		button_2.setBackground(new Color(204, 204, 255));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiAddEmployee ae=new GuiAddEmployee();
				ae.getInstance();
				ae.setVisible(true);
			}
		});
		button_2.setBounds(90, 266, 124, 23);
		employeePanel.add(button_2);
		
		JButton button_3 = new JButton("View Information");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiViewEmployee ve = new GuiViewEmployee();
				ve.setVisible(true);
			}
		});
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
