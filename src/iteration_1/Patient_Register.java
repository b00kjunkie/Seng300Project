package iteration_1;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Patient_Register extends JPanel {
	
	private Patient_Auth auth;
	private JTextField txtNewUser;
	private JTextField txtNewPwd;
	private JTextField txtConfirmedPwd;

	/**
	 * Create the panel.
	 */
	public Patient_Register(final JFrame frame, final Patient_Auth auth) {
		setBackground(Color.WHITE);
		
		this.auth=auth;
		
		
		setLayout(null);
		
		JLabel lblNewUsername = new JLabel("New Username");
		lblNewUsername.setBounds(29, 24, 99, 14);
		add(lblNewUsername);
		
		txtNewUser = new JTextField();
		txtNewUser.setBounds(29, 49, 96, 20);
		add(txtNewUser);
		txtNewUser.setColumns(10);
		
		final JLabel lblNewPassword = new JLabel("New Password ");
		lblNewPassword.setBounds(29, 80, 99, 14);
		add(lblNewPassword);
		
		txtNewPwd = new JTextField();
		txtNewPwd.setBounds(29, 105, 96, 20);
		add(txtNewPwd);
		txtNewPwd.setColumns(10);
		
		final JLabel lblNewPasswordConfirm = new JLabel("Confirm Password");
		lblNewPasswordConfirm.setBounds(29, 136, 99, 14);
		add(lblNewPasswordConfirm);
		
		txtConfirmedPwd = new JTextField();
		txtConfirmedPwd.setBounds(32, 161, 96, 20);
		add(txtConfirmedPwd);
		txtConfirmedPwd.setColumns(10);
		
	    final JLabel lblInvalidUsername = new JLabel("Sorry, this username is not valid");
	    lblInvalidUsername.setBackground(Color.CYAN);
		lblInvalidUsername.setVisible(false);
		lblInvalidUsername.setBounds(271, 52, 169, 14);
		add(lblInvalidUsername);
		
		final JLabel lblInvalidPassword = new JLabel("Sorry, this password is not valid");
		lblInvalidPassword.setVisible(false);
		lblInvalidPassword.setBounds(271, 108, 169, 14);
		add(lblInvalidPassword);
		
		final JLabel lblNotMatch = new JLabel("Confirmed password not match");
		lblNotMatch.setVisible(false);
		lblNotMatch.setBounds(271, 164, 169, 14);
		add(lblNotMatch);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 204, 450, 14);
		add(separator);
		
		JLabel lblPersonInfomation = new JLabel("Please continue provide personal detail infomation");
		lblPersonInfomation.setBounds(100, 224, 248, 14);
		add(lblPersonInfomation);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String password_first = txtNewPwd.getText();
				String password_confirm = txtConfirmedPwd.getText();
				
				
				if(!password_first.equalsIgnoreCase(password_confirm)) {
					
					lblNotMatch.setVisible(true);
					
				}
				
				else {
					
					Patient_Personal_Information personalInfo = new Patient_Personal_Information(frame);
					frame.setContentPane(personalInfo);
					frame.revalidate();
					
				}
				
				
			}
		});
		btnContinue.setBounds(177, 249, 89, 23);
		add(btnContinue);
		
		JButton btnCheckUser = new JButton("Check");
		
		final JLabel lblUserTaken = new JLabel("Username is taken");
		lblUserTaken.setVisible(false);
		lblUserTaken.setBounds(299, 52, 112, 14);
		add(lblUserTaken);

		final JLabel lblGoodUser = new JLabel("Username is availiable");
		lblGoodUser.setVisible(false);
		lblGoodUser.setBounds(270, 52, 141, 14);
		add(lblGoodUser);
		
		btnCheckUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 
				String username = txtNewUser.getText();
				
				if (!auth.checkUsername(username)) {
					
					lblInvalidUsername.setVisible(true);
				}
				
				else if(auth.checkSameUser(username)) {
					
					lblUserTaken.setVisible(true);
					
				}
				
				else {
					
					lblGoodUser.setVisible(true);
					
				}				
				
			}
		});
		btnCheckUser.setBounds(135, 48, 61, 23);
		add(btnCheckUser);
		
		final JLabel lblValidpassword = new JLabel("Password is valid");
		lblValidpassword.setVisible(false);
		lblValidpassword.setBounds(270, 108, 141, 14);
		add(lblValidpassword);
		
		JButton btnCheckPwd = new JButton("Check");
		btnCheckPwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String pwd = lblNewPassword.getText();
				
				if(!auth.checkPassword(pwd)) {
					
					lblInvalidPassword.setVisible(true);
				}
				
				else {
					
					lblValidpassword.setVisible(true);
				}
			
			}
		});
		btnCheckPwd.setBounds(135, 104, 61, 23);
		add(btnCheckPwd);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(398, 249, 89, 23);
		add(btnBack);
		
		
	
		
	}

}
