package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Font;

import javax.swing.JList;

import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JCheckBox;

import controlLayer.CtrCustomer;
import controlLayer.CtrItem;
import controlLayer.CtrSale;
import controlLayer.CtrSaleLine;
import modelLayer.Customer;
import modelLayer.Item;
import modelLayer.SaleLine;

import java.awt.Scrollbar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.sql.Timestamp;
import java.util.ArrayList;
/**
@author frunziss
*/
public class GuiSale extends JDialog {

	private JPanel contentPane;
	private JTextField searchField;
	private static GuiSale instance=null;
	private GuiMain gm = new GuiMain();
	private CtrItem ci = new CtrItem();
	private static ArrayList<GuiItemWrapperGood<Item>> giw = new ArrayList<>();
	private List itemList = new List();
	public ArrayList<SaleLine> saleLines = new ArrayList<>();
	public Item item;
	private CtrSale cs = new CtrSale();
	private JTextField textField_nr;
	private Customer customer;
	public TextField quantityField;
	private double price=0;
	private JLabel lblPrice;
	private List saleList_1;
	private JCheckBox chckbxPaid;
	private String quantity = quantityField.getText();
	private String selectedItem=itemList.getSelectedItem();
	private String selectedCustomer;
	
	
	
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public static GuiSale getInstance()
	{
		if(instance == null) {
	         instance = new GuiSale();
	      }
	      return instance;
	}
	public void updatePrice()
	{ price=price+Integer.parseInt(quantityField.getText())*item.getPrice();
	  lblPrice.setText(Double.toString(price));	
	}
	public GuiSale() {
		GuiMain.getInstance().list_customers.getSelectedItem();
		CtrCustomer cc = new CtrCustomer();
		try {
			for(Customer curr:cc.getAllCustomers())
			{
				if(curr.getName().equals(curr.getName()))
					customer=curr;
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		this.setModal(true);
		setResizable(false);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent k) {
				
			}
		});
		setTitle("GuiSale");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 405);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 300, 344);
		contentPane.add(panel);
		panel.setLayout(null);
		
		searchField = new JTextField();
		searchField.addKeyListener(new KeyAdapter() {
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
		searchField.setBounds(10, 39, 193, 23);
		panel.add(searchField);
		searchField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(204, 204, 255));
		btnSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent k) {
				
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Item> result = new ArrayList<>();
				try {
					 result = ci.searchItemByName(searchField.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				giw= new ArrayList<>();
				itemList.removeAll();
				for(Item curr:result)
				{
					giw.add(new GuiItemWrapperGood<Item>(curr, curr::getName));
				}
				for(GuiItemWrapperGood<Item>curr:giw)
				{
					itemList.add(curr.toString());
				}
			}
		});
		btnSearch.setBounds(206, 38, 84, 24);
		panel.add(btnSearch);
		
		JLabel lblSearchProduct = new JLabel("Search product");
		lblSearchProduct.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSearchProduct.setBounds(10, 11, 156, 23);
		panel.add(lblSearchProduct);
		
		
		itemList.setBackground(Color.LIGHT_GRAY);
		itemList.setBounds(10, 68, 280, 196);
		for(String curr:gm.getInstance().list_items.getItems())
		{
			itemList.add(curr);
		}
		panel.add(itemList);
		
		
		
		quantityField = new TextField();
		quantityField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent k) {
				if (k.getKeyCode()==KeyEvent.VK_ENTER){
					//IMPORTANT 
				
		        }
			}
		});
		quantityField.setBounds(82, 271, 105, 22);
		panel.add(quantityField);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantity.setBounds(10, 271, 71, 22);
		panel.add(lblQuantity);
		
		JButton btnAdd = new JButton("Add to sale");
		btnAdd.setBackground(new Color(204, 204, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*	if(itemList.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				else
				/*if(quantityField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the quantity of the selected item before adding it to the sale. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}*/
				
				CtrSale cs = new CtrSale();
				CtrSaleLine csl = new CtrSaleLine();
				selectedCustomer=GuiMain.getInstance().list_customers.getSelectedItem();
				try {
					for(Item curr:ci.getAllItems())
					{
						if(curr.getName().equals(selectedCustomer))
						{
							 item = curr;
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				csl.createSaleLine(Integer.parseInt(quantity),item.getBarcode());
				
				
				saleList_1.add(item.getName()+" "+"Quantity: "+quantity+" "+"Price/Unit: "+item.getPrice());
				updatePrice();
				
				
			}
		});
		btnAdd.setBounds(185, 270, 105, 23);
		panel.add(btnAdd);
		
		
		JLabel lblStock_1 = new JLabel(itemList.getSelectedItem());
		
		lblStock_1.setBounds(97, 272, 46, 14);
		panel.add(lblStock_1);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(316, 11, 300, 344);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblGuiSale = new JLabel("New sale");
		lblGuiSale.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGuiSale.setBounds(10, 11, 108, 23);
		panel_1.add(lblGuiSale);
	//	List saleList = new List();
		saleList_1 = new List();
		saleList_1.setBackground(Color.LIGHT_GRAY);
		saleList_1.setBounds(10, 40, 280, 220);
		panel_1.add(saleList_1);
		
		JButton btnDelete = new JButton("Remove from sale");
		btnDelete.setBackground(new Color(204, 204, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(saleList.getSelectedItems().length==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "No item were selected. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}*/
				
				
			}
		});
		btnDelete.setBounds(171, 265, 119, 23);
		panel_1.add(btnDelete);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				java.util.Date date= new java.util.Date();
				Timestamp dateCreated = new Timestamp(date.getTime());
			//cs.insertSale(textField_nr.getText(), false, null, false, null, false, null, 1, 1, saleLines, -1);
			try {
				cs.addSaleLineToSale(Integer.parseInt(quantity), item.getBarcode(), saleLines);
				cs.insertSale(textField_nr.getText(), chckbxPaid.isSelected(), dateCreated, false, dateCreated, false, dateCreated, 1, customer.getId_customer(), saleLines, -1);
				saleLines.add(new SaleLine(Integer.parseInt(quantity), item.getPrice(), item));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GuiSale.this.dispose();
			}
		
		});
		btnFinish.setBackground(new Color(204, 204, 255));
		btnFinish.setBounds(123, 321, 89, 23);
		panel_1.add(btnFinish);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GuiSale.this.dispose();
				
			
			}
		});
		btnCancel.setBounds(211, 321, 89, 23);
		panel_1.add(btnCancel);
		
		JLabel lblTotalPrice = new JLabel("Total price:");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalPrice.setBounds(10, 266, 89, 22);
		panel_1.add(lblTotalPrice);
		
		lblPrice = new JLabel("");
		lblPrice.setBounds(91, 272, 46, 14);
		panel_1.add(lblPrice);
		
		
		chckbxPaid = new JCheckBox("Paid");
		chckbxPaid.setBackground(Color.GRAY);
		chckbxPaid.setBounds(226, 295, 64, 23);
		panel_1.add(chckbxPaid);
		
		textField_nr = new JTextField();
		textField_nr.setBounds(204, 14, 86, 20);
		panel_1.add(textField_nr);
		textField_nr.setColumns(10);
		
		JLabel lblNr = new JLabel("Nr:");
		lblNr.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNr.setBounds(160, 11, 34, 23);
		panel_1.add(lblNr);
		}
	}

