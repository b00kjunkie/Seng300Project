package iteration_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Patient_Main_Login {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private final Action action = new SwingAction();
	
	private Patient_Auth auth = new Patient_Auth();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Patient_Main_Login window = new Patient_Main_Login();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Patient_Main_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 572, 340);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Alberta Hospital System");
		lblNewLabel.setFont(new Font("Broadway", Font.ITALIC, 12));
		lblNewLabel.setBounds(75, 27, 266, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUser = new JLabel("Username");
		lblUser.setBounds(75, 79, 61, 14);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPwd = new JLabel("password");
		lblPwd.setBounds(75, 116, 49, 14);
		frame.getContentPane().add(lblPwd);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(168, 76, 96, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(170, 113, 94, 20);
		frame.getContentPane().add(txtPassword);
		
		JButton btnReset = new JButton("reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				txtUsername.setText(null);
				txtPassword.setText(null);
				
			}
		});
		
		btnReset.setBounds(175, 192, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				
			}
			
		});
		
		btnExit.setBounds(312, 192, 89, 23);
		frame.getContentPane().add(btnExit);
		
		final JLabel lblInvalidMsg = new JLabel("invalid account information!");
		lblInvalidMsg.setVisible(false);
		
		lblInvalidMsg.setBounds(145, 155, 164, 14);
		frame.getContentPane().add(lblInvalidMsg);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				
				CustomElement account = auth.login(username,password);
				
				if(account == null) {
					lblInvalidMsg.setVisible(true);
				}
			}
		});
		
		btnLogin.setBounds(23, 192, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Patient_Register register = new Patient_Register(frame,auth);
				frame.setContentPane(register);
				frame.revalidate();
			}
		});
		btnRegister.setBounds(105, 226, 215, 23);
		frame.getContentPane().add(btnRegister);
		
		
	
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
