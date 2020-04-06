package iteration_3;

/**
 * The PatientLogin.java class represents the login screen for patients. Patients are redirected to this frame from the
 * MainFrame class when they select the Patient button.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-03
 */

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PatientLogin extends JPanel {

	private static final long serialVersionUID = 18L; // serial ID for java object saving
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Creates a window which allows patients to enter their login information to access the system
	 * 
	 * @param frame of type JFrame representing the program window
	 */
	protected PatientLogin(final JFrame frame) {

		// set window properties
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		// header for the window
		JLabel lblWelcome = new JLabel("Welcome to the Alberta Hospital Scheduling System");
		lblWelcome.setForeground(new Color(0, 102, 204));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(173, 99, 600, 34);
		lblWelcome.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 24));
		add(lblWelcome);

		// Alberta health services logo
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PatientLogin.class.getResource("/iteration_3/ahs.png")));
		lblNewLabel.setBounds(41, 11, 190, 97);
		add(lblNewLabel);

		// patient picture
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(
				new ImageIcon(PatientLogin.class.getResource("/iteration_3/icons8-patient-oxygen-mask-48.png")));
		lblNewLabel_1.setBounds(146, 182, 55, 65);
		add(lblNewLabel_1);

		// patient username label
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(0, 102, 204));
		lblUsername.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		lblUsername.setBounds(240, 182, 109, 20);
		add(lblUsername);

		// patient password label
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 102, 204));
		lblPassword.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		lblPassword.setBounds(240, 242, 109, 20);
		add(lblPassword);

		// text field allows patient to enter username
		txtUsername = new JTextField();
		txtUsername.setBounds(387, 182, 171, 20);
		txtUsername.setColumns(10);
		add(txtUsername);

		// text field allows patient to enter password
		txtPassword = new JPasswordField();
		txtPassword.setBounds(387, 242, 171, 20);
		add(txtPassword);

		// text indicates if invalid login information was entered
		final JTextArea txtrInvalid = new JTextArea();
		txtrInvalid.setForeground(Color.RED);
		txtrInvalid.setBounds(358, 362, 250, 22);
		txtrInvalid.setBackground(Color.LIGHT_GRAY);
		txtrInvalid.setFont(new Font("Cambria Math", Font.BOLD, 16));
		txtrInvalid.setText("Invalid username or password");
		add(txtrInvalid);
		txtrInvalid.setVisible(false);

		// button allows the patient to login
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 102, 204));
		btnLogin.setBounds(509, 302, 86, 23);
		add(btnLogin);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String username = txtUsername.getText();
				@SuppressWarnings("deprecation")
				String password = txtPassword.getText();

				try {
					// reinitialize database to remove all patients registered during SE testing period
					// this needs to be commented-out to not overwrite newly registered patients
					// PatientDB.reinitDB();

					PatientDB patientDB = new PatientDB();
					patientDB = patientDB.loadPatientDB(); // load database from file

					// For debugging or general interest, can print patient database to console:
					// patientDB.printArray();

					// if username and password don't match in the patient database, then display error
					// else, create PatientDashboard frame and pass parameter String array containing username+pass
					if (!patientDB.checkForMatch(username, password)) {
						txtrInvalid.setVisible(true);
					} else {
						String patientID = patientDB.getID(username, password);
						PatientDashboard login = new PatientDashboard(frame, patientID);
						frame.setContentPane(login);
						frame.revalidate();
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		}); // end MouseListener for button_1 "Login"

		// button resets the login informaton to null
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(0, 102, 204));
		btnReset.setBounds(358, 302, 86, 23);
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		add(btnReset);

		// button allows the patient to return to the initial screen
		JButton btnExit = new JButton("Back");
		btnExit.setForeground(new Color(0, 102, 204));
		btnExit.setBounds(814, 530, 160, 23);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame.main(new String[] {}); // restart the program by calling main method and passing empty array
				frame.dispose(); // close current screen
			}
		});
		add(btnExit);

		// button allows the user to access a patient registration window
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(new Color(0, 102, 204));
		btnRegister.setBounds(387, 436, 171, 23);
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientRegister register = new PatientRegister(frame);
				frame.setContentPane(register);
				frame.revalidate();
			}
		});
		add(btnRegister);

	} // end patient login constructor

} // end class PatientLogin
