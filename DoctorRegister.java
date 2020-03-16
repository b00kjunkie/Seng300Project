package iteration2;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class DoctorRegister extends JPanel {
	
	private JTextField username;
	private JTextField password;
	private JTextField comfirmpass;

	public DoctorRegister(final JFrame frame, final DoctorAuth auth) {
		setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(1, 0, 112, 30);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(113, 0, 112, 30);
		add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(225, 0, 112, 30);
		add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(337, 0, 112, 30);
		add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(1, 30, 112, 30);
		add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(113, 30, 112, 30);
		add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(225, 30, 112, 30);
		add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(337, 30, 112, 30);
		add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(1, 90, 112, 30);
		add(label_8);
		
		JLabel lblRegisterForAccount = new JLabel("Register for an Account");
		lblRegisterForAccount.setBounds(91, 41, 257, 30);
		lblRegisterForAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterForAccount.setFont(new Font("Dialog", Font.BOLD, 20));
		add(lblRegisterForAccount);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(337, 60, 112, 30);
		add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(1, 90, 112, 30);
		add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(113, 90, 112, 30);
		add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(225, 90, 112, 30);
		add(label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.setBounds(317, 90, 112, 30);
		add(label_14);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(38, 90, 75, 30);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblUsername);
		
		username = new JTextField();
		username.setBounds(139, 90, 179, 30);
		add(username);
		username.setColumns(10);
		
		final JLabel lblInvalidUsername = new JLabel("Invalid Username");
		lblInvalidUsername.setBounds(328, 82, 112, 30);
		lblInvalidUsername.setVisible(false);
		add(lblInvalidUsername);
		
		JLabel label_17 = new JLabel("");
		label_17.setBounds(38, 120, 112, 30);
		add(label_17);
		
		JLabel passwordlbl = new JLabel("Password:");
		passwordlbl.setBounds(48, 120, 112, 30);
		add(passwordlbl);
		
		password = new JTextField();
		password.setBounds(139, 120, 179, 30);
		add(password);
		password.setColumns(10);
		
		final JLabel lblInvalidPassword = new JLabel("Invalid Password");
		lblInvalidPassword.setBounds(316, 120, 101, 30);
		lblInvalidPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvalidPassword.setVisible(false);
		add(lblInvalidPassword);
		
		JLabel label_19 = new JLabel("");
		label_19.setBounds(1, 180, 112, 30);
		add(label_19);
		
		JLabel comfrimpasslbl = new JLabel("Confirm Password:");
		comfrimpasslbl.setBounds(38, 150, 112, 30);
		add(comfrimpasslbl);
		
		comfirmpass = new JTextField();
		comfirmpass.setBounds(139, 150, 179, 30);
		add(comfirmpass);
		comfirmpass.setColumns(10);
		
		final JLabel lblPasswordsDontMatch = new JLabel("Doesn't match");
		lblPasswordsDontMatch.setBounds(328, 150, 112, 30);
		lblPasswordsDontMatch.setVisible(false);
		add(lblPasswordsDontMatch);
		
		JLabel label_21 = new JLabel("");
		label_21.setBounds(1, 210, 112, 30);
		add(label_21);
		
		JLabel label_22 = new JLabel("");
		label_22.setBounds(113, 210, 112, 30);
		add(label_22);
		
		JButton buttonregister = new JButton("Register");
		buttonregister.setBounds(179, 191, 112, 30);
		buttonregister.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("null")
			@Override
			public void mousePressed(MouseEvent e) {
				String user = username.getText();
				String pass = password.getText();
				String confirm = comfirmpass.getText();
				if(!pass.equals(confirm)) {
					lblPasswordsDontMatch.setVisible(true);
					return;
				}
				String mess = auth.register(user, pass);
				if(mess == "Invalid username" || mess == "Username taken") {
					lblInvalidUsername.setVisible(true);
					return;
				}
				if(mess == "Invalid password") {
					lblInvalidPassword.setVisible(true);
					return;
				}
				DoctorLogin panel = new DoctorLogin(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		add(buttonregister);
		
		JLabel label_23 = new JLabel("");
		label_23.setBounds(337, 210, 112, 30);
		add(label_23);
		
		JLabel label_24 = new JLabel("");
		label_24.setBounds(1, 240, 112, 30);
		add(label_24);
		
		JLabel label_25 = new JLabel("");
		label_25.setBounds(113, 240, 112, 30);
		add(label_25);
		
		JLabel label_26 = new JLabel("");
		label_26.setBounds(337, 240, 112, 30);
		add(label_26);
		
		JLabel label_27 = new JLabel("");
		label_27.setBounds(1, 270, 112, 30);
		add(label_27);
		
		JLabel label_28 = new JLabel("");
		label_28.setBounds(113, 270, 112, 30);
		add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.setBounds(337, 270, 112, 30);
		add(label_29);

	}

}