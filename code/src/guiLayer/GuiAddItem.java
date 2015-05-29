package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
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
import java.awt.Color;

public class GuiAddItem extends JDialog {

	private JPanel contentPane;
	private JTextField textField_barcode;
	private JTextField textField_name;
	private JTextField textField_price;
	private JTextField textField_stock;
	private JTextField textField_type;
	private JTextField textField_category;
	private static GuiAddItem instance= null;

	/**
	 * Launch the application.
	 */
	/**
	@author frunziss
	*/

	/**
	 * Create the frame.
	 */
	public static GuiAddItem getInstance()
	{
		if(instance == null) {
	         instance = new GuiAddItem();
	      }
	      return instance;
	}
	public GuiAddItem() {
		setModal(true);
		setTitle("Add Item");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(5, 7, 295, 231);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
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
		
		textField_barcode = new JTextField();
		textField_barcode.setBounds(115, 10, 150, 20);
		contentPane.add(textField_barcode);
		textField_barcode.setColumns(10);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(115, 36, 150, 20);
		contentPane.add(textField_name);
		
		textField_price = new JTextField();
		textField_price.setColumns(10);
		textField_price.setBounds(115, 60, 150, 20);
		contentPane.add(textField_price);
		
		textField_stock = new JTextField();
		textField_stock.setColumns(10);
		textField_stock.setBounds(115, 85, 150, 20);
		contentPane.add(textField_stock);
		
		textField_type = new JTextField();
		textField_type.setColumns(10);
		textField_type.setBounds(115, 110, 150, 20);
		contentPane.add(textField_type);
		
		textField_category = new JTextField();
		textField_category.setColumns(10);
		textField_category.setBounds(115, 135, 150, 20);
		contentPane.add(textField_category);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	Main.getFrames()[0].setEnabled(true);
				GuiAddItem.this.dispose();
				
			}
		});
		btnCancel.setBounds(176, 163, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(204, 204, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_barcode.getText().isEmpty()||textField_category.getText().isEmpty()||textField_name.getText().isEmpty()||textField_price.getText().isEmpty()||textField_stock.getText().isEmpty()||textField_type.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must complete all fields. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				
				} 
				else
				{
				String barcode = textField_barcode.getText();
				String category =  textField_category.getText();
				String name = textField_name.getText();
				Double price = Double.parseDouble(textField_price.getText());
				int stock = Integer.parseInt(textField_stock.getText());
				String type = textField_type.getText();
				
				}
			}
		});
		btnAdd.setBounds(86, 163, 89, 23);
		contentPane.add(btnAdd);
	}

}
