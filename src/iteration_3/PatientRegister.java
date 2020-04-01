package iteration_3;

/**
 * The PatientRegister.java class represents the first frame seen by patients when they attempt to complete the 
 * registration process for the system. They are asked to provide initial details, such as a username and a password.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-03
 */

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class PatientRegister extends JPanel {

	private static final long serialVersionUID = 6L; // serial ID for java object saving
	private JTextField txtNewUser; // patient username
	private JTextField pwdNewPwd; // patient password
	private JTextField pwdConfirmedPwd; // patient confirm password

	/**
	 * Create the panel.
	 */
	public PatientRegister(final JFrame frame) {

		// window properties
		setBackground(Color.LIGHT_GRAY);

		// header for window
		JLabel lbl_registration_header = new JLabel("New Patient Registration");
		lbl_registration_header.setForeground(new Color(0, 102, 204));
		lbl_registration_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_registration_header.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_registration_header.setBounds(330, 75, 305, 32);
		add(lbl_registration_header);

		// label that indicates that the username is not value
		final JLabel lblInvalidUsername = new JLabel("Sorry, this username is not valid");
		lblInvalidUsername.setForeground(new Color(204, 51, 51));
		lblInvalidUsername.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lblInvalidUsername.setBounds(610, 150, 242, 19);
		lblInvalidUsername.setBackground(Color.CYAN);
		lblInvalidUsername.setVisible(false);

		// label that indicates that the username is not available
		final JLabel lblGoodUser = new JLabel("Username is availiable");
		lblGoodUser.setForeground(new Color(204, 51, 102));
		lblGoodUser.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lblGoodUser.setBounds(610, 169, 242, 14);
		lblGoodUser.setVisible(false);
		setLayout(null);

		// patient username label
		JLabel lblNewUsername = new JLabel("New Username");
		lblNewUsername.setForeground(new Color(0, 102, 204));
		lblNewUsername.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lblNewUsername.setBounds(60, 163, 154, 20);
		add(lblNewUsername);
		add(lblGoodUser);
		add(lblInvalidUsername);

		// label indicates if the password is not valid
		final JLabel lblValidpassword = new JLabel("Password is valid");
		lblValidpassword.setForeground(new Color(204, 51, 102));
		lblValidpassword.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lblValidpassword.setBounds(610, 304, 216, 20);
		lblValidpassword.setVisible(false);

		// label that indicates if the password is not valid
		final JLabel lblInvalidPassword = new JLabel("Sorry, this password is not valid");
		lblInvalidPassword.setForeground(new Color(204, 51, 102));
		lblInvalidPassword.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lblInvalidPassword.setBounds(610, 235, 242, 23);
		lblInvalidPassword.setVisible(false);

		// text field to enter patient username
		txtNewUser = new JTextField();
		txtNewUser.setBounds(272, 162, 137, 20);
		add(txtNewUser);
		txtNewUser.setColumns(10);

		// label indicates that the entered username has already been taken
		final JLabel lblUserTaken = new JLabel("Username is taken");
		lblUserTaken.setForeground(new Color(204, 51, 102));
		lblUserTaken.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lblUserTaken.setBounds(610, 188, 227, 14);
		lblUserTaken.setVisible(false);

		// button allows patient to check if username is valid
		JButton btnCheckUser = new JButton("Check");
		btnCheckUser.setForeground(new Color(0, 102, 204));
		btnCheckUser.setBounds(477, 161, 80, 23);
		btnCheckUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String username = txtNewUser.getText();

				try {
					PatientDB patientDB = new PatientDB();
					patientDB = patientDB.loadPatientDB(); // load patient database

					// check to see if username is already in patient database. If it is, then display error. If it
					// is not, then display proceed.
					if (patientDB.usernameAvailable(username)) {
						lblUserTaken.setVisible(false);
						lblGoodUser.setVisible(true);
					} else {
						lblUserTaken.setVisible(true);
						lblGoodUser.setVisible(false);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		add(btnCheckUser);
		add(lblUserTaken);

		// label for patient password
		final JLabel lblNewPassword = new JLabel("New Password ");
		lblNewPassword.setForeground(new Color(0, 102, 204));
		lblNewPassword.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lblNewPassword.setBounds(60, 229, 154, 32);
		add(lblNewPassword);
		add(lblInvalidPassword);

		// text field allows patient to enter in a password
		pwdNewPwd = new JPasswordField();
		pwdNewPwd.setBounds(272, 237, 137, 20);
		add(pwdNewPwd);
		pwdNewPwd.setColumns(10);

		// buttons allows patient to check if entered password is valid
		JButton btnCheckPwd = new JButton("Check");
		btnCheckPwd.setForeground(new Color(0, 102, 204));
		btnCheckPwd.setBounds(477, 236, 80, 23);
		btnCheckPwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String pwd = pwdNewPwd.getText();

				// verify password length is at least 8 characters
				if (pwd.length() >= 8) {
					lblValidpassword.setVisible(true);
					lblInvalidPassword.setVisible(false);
				} else {
					lblValidpassword.setVisible(false);
					lblInvalidPassword.setVisible(true);
				}
			}

		});
		add(btnCheckPwd);
		add(lblValidpassword);

		// confirm password label
		final JLabel lblNewPasswordConfirm = new JLabel("Confirm Password");
		lblNewPasswordConfirm.setForeground(new Color(0, 102, 204));
		lblNewPasswordConfirm.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lblNewPasswordConfirm.setBounds(60, 317, 202, 25);
		add(lblNewPasswordConfirm);

		// label indicates that the two entered passwords do not match
		final JLabel lblNotMatch = new JLabel("Confirmed password not match");
		lblNotMatch.setForeground(new Color(204, 51, 102));
		lblNotMatch.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lblNotMatch.setBounds(610, 329, 242, 23);
		lblNotMatch.setVisible(false);

		// text field allows patient to re-enter password
		pwdConfirmedPwd = new JPasswordField();;
		pwdConfirmedPwd.setBounds(272, 321, 137, 20);
		add(pwdConfirmedPwd);
		pwdConfirmedPwd.setColumns(10);
		add(lblNotMatch);

		// separator used to visually separate fields
		JSeparator separator = new JSeparator();
		separator.setBounds(254, 386, 443, 9);
		add(separator);

		// label instructs patients to continue entering in their personal information
		JLabel lblPersonInfomation = new JLabel("Please continue provide personal detail infomation");
		lblPersonInfomation.setForeground(new Color(0, 102, 204));
		lblPersonInfomation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonInfomation.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lblPersonInfomation.setBounds(299, 406, 373, 20);
		add(lblPersonInfomation);

		// button allows the patient to return to the patient login screen
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(893, 528, 81, 23);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				PatientLogin login = new PatientLogin(frame);
				frame.setContentPane(login);
				frame.revalidate();
			}
		});

		// button allows for the patient to submit their registration information
		JButton btnContinue = new JButton("Continue");
		btnContinue.setForeground(new Color(0, 102, 255));
		btnContinue.setBounds(436, 452, 100, 23);
		btnContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String password_first = pwdNewPwd.getText();
				String password_confirm = pwdConfirmedPwd.getText();
				String user_name = txtNewUser.getText();

				if (password_first == null || password_confirm == null || user_name == null) {
					
					// we do nothing since it should be an unintended mistake.
				}

				else if (!password_first.contentEquals(password_confirm)) {
					lblNotMatch.setVisible(true);
				}

				else {
					try {
						// package username and password into an String array, to be passed as a parameter into a new
						// Patient_Personal_Information frame.
						String[] userParams = new String[] { user_name, password_first };
						PatientPersonalInformation personalInfo = new PatientPersonalInformation(frame, userParams);
						frame.setContentPane(personalInfo);
						frame.revalidate();
					} catch (Exception e1) {

						e1.printStackTrace();
					}
				} // end if - else if - else
			}
		});
		add(btnContinue);
		add(btnBack);
		
		JLabel lblAHSimg = new JLabel("");
		lblAHSimg.setIcon(new ImageIcon(PatientRegister.class.getResource("/iteration_3/ahs.png")));
		lblAHSimg.setBounds(38, 11, 194, 75);
		add(lblAHSimg);

	} // end PatientRegister constructor
} // end class PatientRegister
