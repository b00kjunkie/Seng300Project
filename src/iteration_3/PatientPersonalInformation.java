package iteration_3;

/**
 * The PatientPersonalInformation.java class represents the frame displayed when patients are registering for the
 * system. Patients are redirected here from the PatientRegister class in order to provide more details in the
 * registration process.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-03
 */

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PatientPersonalInformation extends JPanel {

	private static final long serialVersionUID = 5L; // serial ID for java object saving
	private JTextField txtNameField; // patient name
	private JTextField textFieldDOB; // patient date of birth
	private String gender; // patient gender
	private String heartdisease = "N"; // patient heart disease flag
	private String diabetes = "N"; // patient diabetes flag
	private String anxiety = "N"; // patient anxiety flag

	/**
	 * Create the panel.
	 */
	public PatientPersonalInformation(final JFrame frame, final String[] userParams) {

		// set window properties
		setBackground(Color.GRAY);
		setLayout(null);

		// personal information section header
		JLabel lbl_personal_info_header = new JLabel("Personal Information");
		lbl_personal_info_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_personal_info_header.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_personal_info_header.setBounds(294, 75, 275, 23);
		add(lbl_personal_info_header);

		// patient name label
		JLabel lblPatientName = new JLabel("Name:");
		lblPatientName.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lblPatientName.setBounds(153, 146, 126, 23);
		add(lblPatientName);

		// text field used to enter patient name
		txtNameField = new JTextField();
		txtNameField.setBounds(382, 149, 103, 20);
		add(txtNameField);
		txtNameField.setColumns(10);

		// patient gender label
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lblGender.setBounds(153, 197, 168, 20);
		add(lblGender);

		// button used to indicate if the patient gender is male
		JRadioButton rdbtnNewRadioButton = new JRadioButton("M");
		rdbtnNewRadioButton.setBackground(Color.GRAY);
		rdbtnNewRadioButton.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(382, 194, 57, 23);
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gender = "Male";
			}
		});
		add(rdbtnNewRadioButton);

		// button used to indicate if the patient gender is female
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("F");
		rdbtnNewRadioButton_1.setBackground(Color.GRAY);
		rdbtnNewRadioButton_1.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(444, 194, 155, 23);
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gender = "Female";
			}
		});
		add(rdbtnNewRadioButton_1);

		// patient date of birth label
		JLabel lblNewLabel = new JLabel("Date of birth:");
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lblNewLabel.setBounds(153, 257, 168, 19);
		add(lblNewLabel);

		// text field used to enter patient date of birth
		textFieldDOB = new JTextField();
		textFieldDOB.setBounds(382, 256, 103, 20);
		add(textFieldDOB);
		textFieldDOB.setColumns(10);

		// label used to indicate the form of the date of birth
		JLabel lblAgeFormat = new JLabel("dd/mm/yyyy");
		lblAgeFormat.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lblAgeFormat.setBounds(534, 257, 138, 20);
		add(lblAgeFormat);

		// patients health pre-conditions label
		JLabel lblNewLabel_1 = new JLabel("Pre-conditions :");
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lblNewLabel_1.setBounds(153, 306, 168, 20);
		add(lblNewLabel_1);

		// box used to indicate if the patient has heart disease
		JCheckBox chckbxNewCheckBox = new JCheckBox("Heart Disease");
		chckbxNewCheckBox.setBackground(Color.GRAY);
		chckbxNewCheckBox.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(382, 334, 138, 23);
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				heartdisease = "Y";
			}
		});
		add(chckbxNewCheckBox);

		// box used to indicate if the patient has diabetes
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Diabetes");
		chckbxNewCheckBox_1.setBackground(Color.GRAY);
		chckbxNewCheckBox_1.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		chckbxNewCheckBox_1.setBounds(382, 362, 138, 23);
		chckbxNewCheckBox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				diabetes = "Y";
			}
		});
		add(chckbxNewCheckBox_1);

		// box used to indicate if the patient has anxiety
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Anxiety");
		chckbxNewCheckBox_2.setBackground(Color.GRAY);
		chckbxNewCheckBox_2.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		chckbxNewCheckBox_2.setBounds(382, 390, 138, 23);
		chckbxNewCheckBox_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				anxiety = "Y";
			}
		});
		add(chckbxNewCheckBox_2);

		// button used to cancel the registration process and return to the login screen
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(885, 528, 89, 23);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				PatientLogin new_login = new PatientLogin(frame);
				frame.setContentPane(new_login);
				frame.revalidate();

			}
		});

		// button used to submit patient registration information
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setBounds(382, 467, 103, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					// Extract data from the GUI fields and assign as new patient parameters:
					PatientDB patientDB = new PatientDB();
					patientDB = patientDB.loadPatientDB();
					String p1 = Integer.toString(patientDB.size() + 1); // newly created ID
					String p2 = userParams[0]; // username
					String p3 = userParams[1]; // password
					String p4 = txtNameField.getText(); // name
					String p5 = gender; // M or F
					String p6 = textFieldDOB.getText(); // DOB
					String p7 = heartdisease; // Y or N
					String p8 = diabetes; // Y or N
					String p9 = anxiety; // Y or N

					// add new patient record to the patient database
					patientDB.add(new String[] { p1, p2, p3, p4, p5, p6, p7, p8, p9 });
					// save the database to file
					patientDB.savePatientDB();

					// open patient login frame
					PatientLogin login = new PatientLogin(frame);
					frame.setContentPane(login);
					frame.revalidate();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnNewButton);
		add(btnNewButton_1);

	} // end PatientPersonalInformation constructor

} // end class PatientPersonalInformation
