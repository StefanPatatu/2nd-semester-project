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

import java.awt.List;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import modelLayer.Customer;
import modelLayer.Item;
import controlLayer.CtrCustomer;
import controlLayer.CtrItem;

import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
/**
@author frunziss
*/
public class GuiUpdateItem extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private GuiMain gm = GuiMain.getInstance();
	
	private CtrItem ci = new CtrItem();
	private Item item = null;
	private ArrayList<Item> items=null;
	private ArrayList<GuiItemWrapperGood<Item>> giw=new ArrayList<>();


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	public GuiUpdateItem() {
		
		 try {
				for(Item curr:ci.getAllItems())
				 {
					 if(curr.getName().equals(GuiMain.getInstance().list_items.getSelectedItem()))
					 {
						 item=ci.findItemById_item(curr.getId_item());
						 				 }
				 }
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(new JFrame(), "Can't get all items. ", "Error", JOptionPane.ERROR_MESSAGE);
			}
		
		getContentPane().setBackground(Color.DARK_GRAY);
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Update Item");
		getContentPane().setLayout(null);
		this.setBounds(5, 7, 330, 202);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.DARK_GRAY);
		tabbedPane.setBounds(10, 11, 304, 151);
	
		getContentPane().add(tabbedPane);
		
		JPanel namePanel = new JPanel();
		namePanel.setBackground(Color.GRAY);
		namePanel.setBounds(20, 116, 50, 50);
		
		
		JPanel pricePanel = new JPanel();
		pricePanel.setBackground(Color.GRAY);
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
		
		JLabel lblName = new JLabel(item.getName());
		lblName.setBounds(177, 13, 112, 14);
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
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Main.getFrames()[0].setEnabled(true);
				GuiUpdateItem.this.dispose();
			}
		});
		btnCancel.setBounds(200, 89, 89, 23);
		namePanel.add(btnCancel);
		
		JButton btnAdd = new JButton("Update");
		btnAdd.setBackground(new Color(204, 204, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the new name. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				else
				{
				
				try {
					GuiUpdateItem.this.dispose();
					ci.updateItem(item.getId_item(), item.getBarcode(), textField.getText(), item.getPrice(), item.getStock(), item.getItemType(), item.getCategory());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					items=ci.getAllItems();
					giw= new ArrayList<GuiItemWrapperGood<Item>>();
					GuiMain.getInstance().list_items.removeAll();
					
					
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
					GuiMain.getInstance().list_items.add(curr.getObject().getName());
				}
				}
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
		
		JLabel lblPrice = new JLabel(Double.toString(item.getPrice()));
		lblPrice.setBounds(177, 13, 46, 14);
		pricePanel.add(lblPrice);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 35, 152, 20);
		pricePanel.add(textField_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(204, 204, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_1.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input the new price. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				}
				else
				{
				
				try {
					GuiUpdateItem.this.dispose();
					ci.updateItem(item.getId_item(), item.getBarcode(), item.getName(), Double.parseDouble(textField_1.getText()), item.getStock(), item.getItemType(), item.getCategory());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		btnUpdate.setBounds(109, 89, 89, 23);
		pricePanel.add(btnUpdate);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setBackground(new Color(204, 204, 255));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	Main.getFrames()[0].setEnabled(true);
				GuiUpdateItem.this.dispose();
			}
		});
		button_1.setBounds(200, 89, 89, 23);
		pricePanel.add(button_1);
		
		
	}
}
