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

public class PatientLogin extends JPanel {

	private static final long serialVersionUID = 4L; // serial ID for java object saving
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Create the panel.
	 */
	public PatientLogin(final JFrame frame) {

		// set window properties
		setBackground(Color.GRAY);
		setLayout(null);

		// header for the window
		JLabel lblNewLabel = new JLabel("Welcome to the Alberta Hospital Scheduling System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(173, 75, 600, 34);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 24));
		add(lblNewLabel);

		// patient username label
		JLabel label = new JLabel("Username");
		label.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		label.setBounds(240, 158, 109, 20);
		add(label);

		// patient password label
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		lblPassword.setBounds(240, 218, 109, 20);
		add(lblPassword);

		// text field allows patient to enter username
		txtUsername = new JTextField();
		txtUsername.setBounds(387, 158, 171, 20);
		txtUsername.setColumns(10);
		add(txtUsername);

		// text field allows patient to enter password
		txtPassword = new JPasswordField();
		txtPassword.setBounds(387, 218, 171, 20);
		add(txtPassword);

		// text indicates if invalid login information was entered
		final JTextArea txtrInvalid = new JTextArea();
		txtrInvalid.setForeground(Color.WHITE);
		txtrInvalid.setBounds(358, 362, 250, 22);
		txtrInvalid.setBackground(Color.RED);
		txtrInvalid.setFont(new Font("Cambria Math", Font.BOLD, 16));
		txtrInvalid.setText("Invalid username or password");
		add(txtrInvalid);
		txtrInvalid.setVisible(false);

		// button allows the patient to login
		JButton button_1 = new JButton("Login");
		button_1.setBounds(509, 278, 86, 23);
		add(button_1);
		button_1.addMouseListener(new MouseAdapter() {
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
		JButton btn_reset = new JButton("Reset");
		btn_reset.setBounds(358, 278, 86, 23);
		btn_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		add(btn_reset);

		// button allows the patient to exit the program
		JButton button_3 = new JButton("Exit");
		button_3.setBounds(885, 530, 89, 23);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);

			}
		});
		add(button_3);

		// button allows the user to access a patient registration window
		JButton button = new JButton("Register");
		button.setBounds(387, 436, 171, 23);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientRegister register = new PatientRegister(frame);
				frame.setContentPane(register);
				frame.revalidate();
			}
		});
		add(button);
		txtrInvalid.setVisible(false);
	}

} // end class PatientLogin
