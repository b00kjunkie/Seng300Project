package iteration_1;

import javax.swing.JPanel;
import javax.swing.*;  

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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class Patient_Register extends JPanel {
	
	private Patient_Auth auth;
	private JTextField txtNewUser;
	private JTextField txtNewPwd;
	private JTextField txtConfirmedPwd;
	private JFrame frame;

	


	/**
	 * Create the panel.
	 */
	public Patient_Register(final JFrame frame,final Patient_Auth auth) {
		
		
		this.auth = auth;
		
		this.frame = frame;
		
		setBackground(Color.WHITE);
	    		GridBagLayout gridBagLayout = new GridBagLayout();
	    		gridBagLayout.columnWidths = new int[]{103, 86, 96, 143, 0};
	    		gridBagLayout.rowHeights = new int[]{20, 22, 28, 32, 9, 14, 32, 23, 0};
	    		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    		setLayout(gridBagLayout);
	    		
	    		JLabel lblNewUsername = new JLabel("New Username");
	    		GridBagConstraints gbc_lblNewUsername = new GridBagConstraints();
	    		gbc_lblNewUsername.insets = new Insets(0, 0, 5, 5);
	    		gbc_lblNewUsername.gridx = 0;
	    		gbc_lblNewUsername.gridy = 1;
	    		add(lblNewUsername, gbc_lblNewUsername);
	    		
	    		txtNewUser = new JTextField();
	    		GridBagConstraints gbc_txtNewUser = new GridBagConstraints();
	    		gbc_txtNewUser.anchor = GridBagConstraints.NORTH;
	    		gbc_txtNewUser.fill = GridBagConstraints.HORIZONTAL;
	    		gbc_txtNewUser.insets = new Insets(0, 0, 5, 5);
	    		gbc_txtNewUser.gridx = 1;
	    		gbc_txtNewUser.gridy = 1;
	    		add(txtNewUser, gbc_txtNewUser);
	    		txtNewUser.setColumns(10);
	    		
	    		final JLabel lblNewPassword = new JLabel("New Password ");
	    		GridBagConstraints gbc_lblNewPassword = new GridBagConstraints();
	    		gbc_lblNewPassword.insets = new Insets(0, 0, 5, 5);
	    		gbc_lblNewPassword.gridx = 0;
	    		gbc_lblNewPassword.gridy = 2;
	    		add(lblNewPassword, gbc_lblNewPassword);
	    		
	    		txtNewPwd = new JTextField();
	    		GridBagConstraints gbc_txtNewPwd = new GridBagConstraints();
	    		gbc_txtNewPwd.anchor = GridBagConstraints.SOUTH;
	    		gbc_txtNewPwd.fill = GridBagConstraints.HORIZONTAL;
	    		gbc_txtNewPwd.insets = new Insets(0, 0, 5, 5);
	    		gbc_txtNewPwd.gridx = 1;
	    		gbc_txtNewPwd.gridy = 2;
	    		add(txtNewPwd, gbc_txtNewPwd);
	    		txtNewPwd.setColumns(10);
	    		
	    		final JLabel lblNewPasswordConfirm = new JLabel("Confirm Password");
	    		GridBagConstraints gbc_lblNewPasswordConfirm = new GridBagConstraints();
	    		gbc_lblNewPasswordConfirm.anchor = GridBagConstraints.EAST;
	    		gbc_lblNewPasswordConfirm.insets = new Insets(0, 0, 5, 5);
	    		gbc_lblNewPasswordConfirm.gridx = 0;
	    		gbc_lblNewPasswordConfirm.gridy = 3;
	    		add(lblNewPasswordConfirm, gbc_lblNewPasswordConfirm);
	    		
	    		txtConfirmedPwd = new JTextField();
	    		GridBagConstraints gbc_txtConfirmedPwd = new GridBagConstraints();
	    		gbc_txtConfirmedPwd.anchor = GridBagConstraints.SOUTH;
	    		gbc_txtConfirmedPwd.fill = GridBagConstraints.HORIZONTAL;
	    		gbc_txtConfirmedPwd.insets = new Insets(0, 0, 5, 5);
	    		gbc_txtConfirmedPwd.gridx = 1;
	    		gbc_txtConfirmedPwd.gridy = 3;
	    		add(txtConfirmedPwd, gbc_txtConfirmedPwd);
	    		txtConfirmedPwd.setColumns(10);
	    		
	    		JSeparator separator = new JSeparator();
	    		GridBagConstraints gbc_separator = new GridBagConstraints();
	    		gbc_separator.fill = GridBagConstraints.BOTH;
	    		gbc_separator.insets = new Insets(0, 0, 5, 0);
	    		gbc_separator.gridwidth = 4;
	    		gbc_separator.gridx = 0;
	    		gbc_separator.gridy = 4;
	    		add(separator, gbc_separator);
	    		
	    		final JLabel lblPersonInfomation = new JLabel("default");
	    		lblPersonInfomation.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    		GridBagConstraints gbc_lblPersonInfomation = new GridBagConstraints();
	    		gbc_lblPersonInfomation.fill = GridBagConstraints.VERTICAL;
	    		gbc_lblPersonInfomation.insets = new Insets(0, 0, 5, 0);
	    		gbc_lblPersonInfomation.gridwidth = 4;
	    		gbc_lblPersonInfomation.gridx = 0;
	    		gbc_lblPersonInfomation.gridy = 5;
	    		add(lblPersonInfomation, gbc_lblPersonInfomation);
	    		
	    		JButton btnBack = new JButton("Back");
	    		btnBack.addMouseListener(new MouseAdapter() {
	    			@Override
	    			public void mouseClicked(MouseEvent e) {
	    				
	    				Patient_Login login = new Patient_Login(frame,auth);
	    				frame.setContentPane(login);
	    				frame.revalidate();
	    			}
	    		});
	    		
	    		JButton btnContinue = new JButton("Continue");
	    		
	    				btnContinue.addMouseListener(new MouseAdapter() {
	    					@Override
	    					public void mouseClicked(MouseEvent e) {
	    						
	    						String password_first = txtNewPwd.getText();
	    						String password_confirm = txtConfirmedPwd.getText();
	    						String user_name = txtNewUser.getText();
	    						
	    						if(password_first == null || password_confirm == null || user_name == null) {
	    							
	    							lblPersonInfomation.setText("Username or password is empty!");
	    							
	    							
	    						}
	    						
	    						
	    						else if(!password_first.contentEquals(password_confirm)) {
	    							
	    							lblPersonInfomation.setText("Confirmed password is not the same!");
	    							
	    						}
	    						
	    						else if (!auth.checkUsername(user_name)) {
	    							
	    							lblPersonInfomation.setText("username format is invalid!");}
	    						
	    						else if(!auth.checkPassword(password_first.toCharArray())) {
	    							
	    							lblPersonInfomation.setText("userpassword format is invalid!");}
	    						
	    						else {
	    							
	    							
	    							lblPersonInfomation.setText("Please continue provide personal detail infomation");
	    							Patient_Personal_Information personalInfo = new Patient_Personal_Information(frame,auth,user_name,password_first);
	    							frame.setContentPane(personalInfo);
	    							frame.revalidate();
	    							
	    						}
	    						
	    						
	    					}
	    				});
	    				GridBagConstraints gbc_btnContinue = new GridBagConstraints();
	    				gbc_btnContinue.anchor = GridBagConstraints.NORTH;
	    				gbc_btnContinue.insets = new Insets(0, 0, 0, 5);
	    				gbc_btnContinue.gridx = 0;
	    				gbc_btnContinue.gridy = 7;
	    				add(btnContinue, gbc_btnContinue);
	    		GridBagConstraints gbc_btnBack = new GridBagConstraints();
	    		gbc_btnBack.anchor = GridBagConstraints.NORTHWEST;
	    		gbc_btnBack.gridx = 3;
	    		gbc_btnBack.gridy = 7;
	    		add(btnBack, gbc_btnBack);
		
		
	
		
	}
}
