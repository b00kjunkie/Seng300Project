package iteration_2;

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

public class Nurse_Login extends JPanel {
	private JTextField textUser;
	private JTextField testPass;

	/**
	 * Create the panel.
	 */
	public Nurse_Login(final JFrame frame, final Nurse_Auth auth) {
		
		JLabel lblWelcomeToOpen = new JLabel("Welcome to Alberta Hospital");
		lblWelcomeToOpen.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblUsername = new JLabel("Username:");
		
		JLabel lblPassword = new JLabel("Password:");
		
		textUser = new JTextField();
		textUser.setColumns(10);
		
		testPass = new JTextField();
		testPass.setColumns(10);
		
		final JLabel lblInvalidLogin = new JLabel("Invalid Login");
		lblInvalidLogin.setVisible(false);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String user = textUser.getText();
				String pass = testPass.getText();
				Nurse_Account acc = auth.login(user, pass);
				if(acc == null) {
					lblInvalidLogin.setVisible(true);
				}
				else {
					Nurse_Logged_In panel = new Nurse_Logged_In(frame, auth);
					frame.setContentPane(panel);
					frame.revalidate();
				}
			}
		});
		loginbtn.setHorizontalAlignment(SwingConstants.LEADING);
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblOrRegister = new JLabel("or Register");
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Nurse_Register panel = new Nurse_Register(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		btnRegister.setHorizontalAlignment(SwingConstants.LEADING);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(32, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblWelcomeToOpen)
							.addGap(28))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPassword)
								.addComponent(lblUsername))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(testPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnRegister, Alignment.LEADING))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblInvalidLogin))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(6)
											.addComponent(lblOrRegister))
										.addComponent(loginbtn))))
							.addGap(73))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addComponent(lblWelcomeToOpen)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsername)
								.addComponent(textUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(testPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword))
							.addGap(17)
							.addComponent(loginbtn)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblOrRegister)
							.addGap(12)
							.addComponent(btnRegister))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(lblInvalidLogin)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
