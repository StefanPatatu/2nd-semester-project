package guiLayer;

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

import modelLayer.Item;
import controlLayer.CtrItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**
@author frunziss
*/
public class GuiUpdateStock extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private static GuiUpdateStock instance=null;
	private GuiMain gm=GuiMain.getInstance();
	private CtrItem ci = new CtrItem();
	private Item item = null;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
/*	public static GuiUpdateStock getInstance()
	{
		if(instance == null) {
	         instance = new GuiUpdateStock();
	      }
	      return instance;
	}
	*/
	public GuiUpdateStock() {
		try {
			for(Item curr:ci.getAllItems())
			{
				if(curr.getName().equals(gm.list_items.getSelectedItem()))
				{
					item=ci.findItemByBarcode(curr.getBarcode());
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "Can't get all customers. ", "Error", JOptionPane.ERROR_MESSAGE);
		}
		setModal(true);
		setTitle("Update Stock");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 389, 189);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel(item.getName());
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(100, 11, 227, 14);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("Current stock:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(22, 45, 192, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCurrstock = new JLabel(String.valueOf(item.getStock()));
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
				if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "You must input a positive value. ", "Error",
					        JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				
				try {
					ci.updateItem(item.getId_item(), item.getBarcode(), item.getName(), item.getPrice(), Integer.parseInt(textField.getText())+item.getStock(), item.getItemType(), item.getCategory());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				GuiUpdateStock.this.dispose();
			}}
		});
		btnSubmit.setBounds(135, 110, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	Main.getFrames()[0].setEnabled(true);
				GuiUpdateStock.this.dispose();
			}
		});
		btnCancel.setBounds(234, 109, 89, 23);
		contentPane.add(btnCancel);
	}

}
