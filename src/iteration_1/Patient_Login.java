package iteration_1;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class Patient_Login extends JPanel {
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private Patient_Auth auth;
	private JFrame frame;

	/**
	 * Create the panel.
	 */
	public Patient_Login(final JFrame frame,final Patient_Auth auth) {
		
		this.auth = auth;
		this.frame =frame;
		setLayout(new MigLayout("", "[89px][5px][][3px][9px][171px][31px][89px]", "[14px][20px][20px][22px][23px][23px]"));
		
		JLabel lblNewLabel = new JLabel("Welcome to Alberta hospital");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		add(lblNewLabel, "cell 5 0,grow");
		
		JLabel label = new JLabel("Username");
		add(label, "cell 0 1 4 1,alignx right,aligny top");
		
		JLabel label_1 = new JLabel("password");
		add(label_1, "cell 0 2,alignx right,aligny center");
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		add(txtUsername, "cell 5 1,alignx left,aligny top");
		
		txtPassword = new JPasswordField();
		add(txtPassword, "cell 5 2,growx,aligny top");
		
		final JTextArea txtrInvalid = new JTextArea();
		txtrInvalid.setBackground(Color.RED);
		txtrInvalid.setFont(new Font("Monospaced", Font.PLAIN, 10));
		txtrInvalid.setText("Invalid username or password");
		add(txtrInvalid, "cell 0 3 6 1,alignx center,growy");
		txtrInvalid.setVisible(false);
		
		JButton button_1 = new JButton("Login");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String username = txtUsername.getText();
				
				char[] password = txtPassword.getPassword();
				
				Patient_Account account = auth.login(username,password);
				
				if(account == null) {
					txtrInvalid.setVisible(true);
				}
				else {
					
					Patient_Internal intern = new Patient_Internal(account);
					frame.setContentPane(intern);
					frame.revalidate();
				}
			}
		});
		add(button_1, "cell 0 4,growx,aligny top");
		
		JButton btn_reset = new JButton("reset");
		btn_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		add(btn_reset, "cell 5 4,alignx center,aligny top");
		
		JButton button_3 = new JButton("Exit");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				
			}
		});
		add(button_3, "cell 7 4,growx,aligny top");
		
		JButton button = new JButton("Register");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			 Patient_Register register = new Patient_Register(frame,auth);
			 frame.setContentPane(register);
			 frame.revalidate();
				
			}
		});
		add(button, "cell 5 5,growx,aligny top");
		txtrInvalid.setVisible(false);
		
		
	
		
		
		
	}
}
