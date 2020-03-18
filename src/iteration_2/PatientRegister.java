package iteration_2;

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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PatientRegister extends JPanel {

	private static final long serialVersionUID = 6L; // serial ID for java object saving
	private JTextField txtNewUser;
	private JTextField txtNewPwd;
	private JTextField txtConfirmedPwd;

	/**
	 * Create the panel.
	 */
	public PatientRegister(final JFrame frame) {

		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 128, 61, 249, 0 };
		gridBagLayout.rowHeights = new int[] { 14, 2, 19, 14, 23, 14, 20, 14, 14, 23, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		final JLabel lblInvalidUsername = new JLabel("Sorry, this username is not valid");
		lblInvalidUsername.setBackground(Color.CYAN);
		lblInvalidUsername.setVisible(false);

		final JLabel lblGoodUser = new JLabel("Username is availiable");
		lblGoodUser.setVisible(false);

		JLabel lblNewUsername = new JLabel("New Username");

		GridBagConstraints gbc_lblNewUsername = new GridBagConstraints();
		gbc_lblNewUsername.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewUsername.gridx = 0;
		gbc_lblNewUsername.gridy = 0;
		add(lblNewUsername, gbc_lblNewUsername);

		GridBagConstraints gbc_lblGoodUser = new GridBagConstraints();
		gbc_lblGoodUser.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblGoodUser.insets = new Insets(0, 0, 5, 0);
		gbc_lblGoodUser.gridheight = 2;
		gbc_lblGoodUser.gridx = 2;
		gbc_lblGoodUser.gridy = 0;
		add(lblGoodUser, gbc_lblGoodUser);

		GridBagConstraints gbc_lblInvalidUsername = new GridBagConstraints();
		gbc_lblInvalidUsername.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblInvalidUsername.insets = new Insets(0, 0, 5, 0);
		gbc_lblInvalidUsername.gridx = 2;
		gbc_lblInvalidUsername.gridy = 0;
		add(lblInvalidUsername, gbc_lblInvalidUsername);

		final JLabel lblValidpassword = new JLabel("Password is valid");
		lblValidpassword.setVisible(false);

		final JLabel lblInvalidPassword = new JLabel("Sorry, this password is not valid");
		lblInvalidPassword.setVisible(false);

		txtNewUser = new JTextField();
		GridBagConstraints gbc_txtNewUser = new GridBagConstraints();
		gbc_txtNewUser.anchor = GridBagConstraints.EAST;
		gbc_txtNewUser.insets = new Insets(0, 0, 5, 5);
		gbc_txtNewUser.gridheight = 2;
		gbc_txtNewUser.gridx = 0;
		gbc_txtNewUser.gridy = 1;
		add(txtNewUser, gbc_txtNewUser);
		txtNewUser.setColumns(10);

		final JLabel lblUserTaken = new JLabel("Username is taken");
		lblUserTaken.setVisible(false);

		JButton btnCheckUser = new JButton("Check");

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

		GridBagConstraints gbc_btnCheckUser = new GridBagConstraints();
		gbc_btnCheckUser.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCheckUser.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheckUser.gridheight = 2;
		gbc_btnCheckUser.gridx = 1;
		gbc_btnCheckUser.gridy = 1;
		add(btnCheckUser, gbc_btnCheckUser);

		GridBagConstraints gbc_lblUserTaken = new GridBagConstraints();
		gbc_lblUserTaken.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUserTaken.insets = new Insets(0, 0, 5, 0);
		gbc_lblUserTaken.gridx = 2;
		gbc_lblUserTaken.gridy = 2;
		add(lblUserTaken, gbc_lblUserTaken);

		final JLabel lblNewPassword = new JLabel("New Password ");
		GridBagConstraints gbc_lblNewPassword = new GridBagConstraints();
		gbc_lblNewPassword.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewPassword.gridx = 0;
		gbc_lblNewPassword.gridy = 3;
		add(lblNewPassword, gbc_lblNewPassword);

		GridBagConstraints gbc_lblInvalidPassword = new GridBagConstraints();
		gbc_lblInvalidPassword.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblInvalidPassword.insets = new Insets(0, 0, 5, 0);
		gbc_lblInvalidPassword.gridx = 2;
		gbc_lblInvalidPassword.gridy = 3;
		add(lblInvalidPassword, gbc_lblInvalidPassword);

		txtNewPwd = new JTextField();
		GridBagConstraints gbc_txtNewPwd = new GridBagConstraints();
		gbc_txtNewPwd.anchor = GridBagConstraints.EAST;
		gbc_txtNewPwd.insets = new Insets(0, 0, 5, 5);
		gbc_txtNewPwd.gridx = 0;
		gbc_txtNewPwd.gridy = 4;
		add(txtNewPwd, gbc_txtNewPwd);
		txtNewPwd.setColumns(10);

		JButton btnCheckPwd = new JButton("Check");
		btnCheckPwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String pwd = txtNewPwd.getText();

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

		GridBagConstraints gbc_btnCheckPwd = new GridBagConstraints();
		gbc_btnCheckPwd.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCheckPwd.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheckPwd.gridx = 1;
		gbc_btnCheckPwd.gridy = 4;
		add(btnCheckPwd, gbc_btnCheckPwd);

		GridBagConstraints gbc_lblValidpassword = new GridBagConstraints();
		gbc_lblValidpassword.anchor = GridBagConstraints.WEST;
		gbc_lblValidpassword.insets = new Insets(0, 0, 5, 0);
		gbc_lblValidpassword.gridx = 2;
		gbc_lblValidpassword.gridy = 4;
		add(lblValidpassword, gbc_lblValidpassword);

		final JLabel lblNewPasswordConfirm = new JLabel("Confirm Password");
		GridBagConstraints gbc_lblNewPasswordConfirm = new GridBagConstraints();
		gbc_lblNewPasswordConfirm.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewPasswordConfirm.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewPasswordConfirm.gridx = 0;
		gbc_lblNewPasswordConfirm.gridy = 5;
		add(lblNewPasswordConfirm, gbc_lblNewPasswordConfirm);

		final JLabel lblNotMatch = new JLabel("Confirmed password not match");
		lblNotMatch.setVisible(false);

		txtConfirmedPwd = new JTextField();
		GridBagConstraints gbc_txtConfirmedPwd = new GridBagConstraints();
		gbc_txtConfirmedPwd.anchor = GridBagConstraints.NORTHEAST;
		gbc_txtConfirmedPwd.insets = new Insets(0, 0, 5, 5);
		gbc_txtConfirmedPwd.gridx = 0;
		gbc_txtConfirmedPwd.gridy = 6;
		add(txtConfirmedPwd, gbc_txtConfirmedPwd);
		txtConfirmedPwd.setColumns(10);

		GridBagConstraints gbc_lblNotMatch = new GridBagConstraints();
		gbc_lblNotMatch.anchor = GridBagConstraints.WEST;
		gbc_lblNotMatch.insets = new Insets(0, 0, 5, 0);
		gbc_lblNotMatch.gridx = 2;
		gbc_lblNotMatch.gridy = 6;
		add(lblNotMatch, gbc_lblNotMatch);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridwidth = 3;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 7;
		add(separator, gbc_separator);

		JLabel lblPersonInfomation = new JLabel("Please continue provide personal detail infomation");
		GridBagConstraints gbc_lblPersonInfomation = new GridBagConstraints();
		gbc_lblPersonInfomation.anchor = GridBagConstraints.NORTH;
		gbc_lblPersonInfomation.insets = new Insets(0, 0, 5, 0);
		gbc_lblPersonInfomation.gridwidth = 3;
		gbc_lblPersonInfomation.gridx = 0;
		gbc_lblPersonInfomation.gridy = 8;
		add(lblPersonInfomation, gbc_lblPersonInfomation);

		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				PatientLogin login = new PatientLogin(frame);
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

				if (password_first == null || password_confirm == null || user_name == null) {
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

		GridBagConstraints gbc_btnContinue = new GridBagConstraints();
		gbc_btnContinue.anchor = GridBagConstraints.NORTH;
		gbc_btnContinue.insets = new Insets(0, 0, 0, 5);
		gbc_btnContinue.gridx = 0;
		gbc_btnContinue.gridy = 9;
		add(btnContinue, gbc_btnContinue);

		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.NORTH;
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 9;
		add(btnBack, gbc_btnBack);

	} // end PatientRegister constructor

} // end class PatientRegister
