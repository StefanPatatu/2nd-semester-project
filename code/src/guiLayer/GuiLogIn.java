package guiLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import authLayer.DbConfig;
import controlLayer.CtrEmployee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiLogIn extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	public CtrEmployee ce = new CtrEmployee();
	private String username, password;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			DbConfig dbb = new DbConfig();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			GuiLogIn dialog = new GuiLogIn();
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("deprecation")
	public int checkEmployee()
	{ 
		username = textField.getText();
		 password = passwordField.getText();
		 
		 
		 
		 return ce.authenticateEmployee(username, password);
	}
	public GuiLogIn() {
	setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		
		setResizable(false);
		setTitle("Log In");
		setBounds(100, 100, 450, 223);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("Employee id:");
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeId.setBounds(44, 38, 104, 14);
		contentPanel.add(lblEmployeeId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(62, 82, 104, 14);
		contentPanel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(139, 37, 280, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 81, 280, 20);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(checkEmployee()>0)
						{
							GuiMain gm = GuiMain.getInstance();
							gm.setVisible(true);
							GuiLogIn.this.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(new JFrame(), "Can't log in. ", "Error", JOptionPane.ERROR_MESSAGE);
						}
						 
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
