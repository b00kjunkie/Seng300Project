package iteration2;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
public class DoctorLogin extends JPanel {
	
	private JTextField textUser;
	private JTextField testPass;

	public DoctorLogin(final JFrame frame, final DoctorAuth auth) {
		setBackground(Color.GRAY);

		JLabel lblWelcomeToOpen = new JLabel("Welcome");
		lblWelcomeToOpen.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JLabel lblUsername = new JLabel("Username:");
		
		JLabel lblPassword = new JLabel("Password:");
		
		textUser = new JTextField();
		textUser.setColumns(10);
		
		testPass = new JTextField();
		testPass.setColumns(10);
		
		final JLabel lblInvalidLogin = new JLabel("Invalid Login");
		lblInvalidLogin.setVisible(false);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.setBackground(Color.WHITE);
		loginbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String user = textUser.getText();
				String pass = testPass.getText();
				DoctorAccount acc = auth.login(user, pass);
				if(acc == null) {
					lblInvalidLogin.setVisible(true);
				}
				else {
					DoctorLoggedIn panel = new DoctorLoggedIn(frame, auth);
					frame.setContentPane(panel);
					frame.revalidate();
				}
			}
		});
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DoctorRegister panel = new DoctorRegister(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUsername)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textUser, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
								.addComponent(testPass, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
							.addGap(40)
							.addComponent(lblInvalidLogin)
							.addGap(19))))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(189, Short.MAX_VALUE)
					.addComponent(lblWelcomeToOpen)
					.addGap(179))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(193, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(loginbtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRegister, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(184))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addComponent(lblWelcomeToOpen)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInvalidLogin))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(testPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(loginbtn)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRegister)
					.addGap(27))
		);
		setLayout(groupLayout);

	}
}

