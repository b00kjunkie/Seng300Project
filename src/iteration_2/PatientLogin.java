package iteration_2;

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
import net.miginfocom.swing.MigLayout;

public class PatientLogin extends JPanel {

	private static final long serialVersionUID = 4L; // serial ID for java object saving
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Create the panel.
	 */
	public PatientLogin(final JFrame frame) {

		setLayout(new MigLayout("", "[89px][5px][][3px][9px][171px][31px][89px]",
				"[14px][20px][20px][22px][23px][23px]"));

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
		add(button_1, "cell 0 4,growx,aligny top");
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
				PatientRegister register = new PatientRegister(frame);
				frame.setContentPane(register);
				frame.revalidate();
			}
		});
		add(button, "cell 5 5,growx,aligny top");
		txtrInvalid.setVisible(false);
	}

} // end class PatientLogin
