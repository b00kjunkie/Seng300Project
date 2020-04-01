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
import javax.swing.ImageIcon;

public class PatientPersonalInformation extends JPanel {

	private static final long serialVersionUID = 5L; // serial ID for java object saving
	private JTextField txtNameField; // patient name
	private JTextField txtDOB; // patient date of birth
	private String gender; // patient gender
	private String heartdisease = "N"; // patient heart disease flag
	private String diabetes = "N"; // patient diabetes flag
	private String anxiety = "N"; // patient anxiety flag

	/**
	 * Create the panel.
	 */
	public PatientPersonalInformation(final JFrame frame, final String[] userParams) {

		// set window properties
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		// personal information section header
		JLabel lbl_personal_info_header = new JLabel("Personal Information");
		lbl_personal_info_header.setForeground(new Color(0, 102, 204));
		lbl_personal_info_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_personal_info_header.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_personal_info_header.setBounds(294, 75, 275, 23);
		add(lbl_personal_info_header);

		// patient name label
		JLabel lblPatientName = new JLabel("Name:");
		lblPatientName.setForeground(new Color(0, 102, 204));
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
		lblGender.setForeground(new Color(0, 102, 204));
		lblGender.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lblGender.setBounds(153, 197, 168, 20);
		add(lblGender);

		// button used to indicate if the patient gender is male
		JRadioButton rdbtnMale = new JRadioButton("M");
		rdbtnMale.setForeground(Color.RED);
		rdbtnMale.setBackground(Color.LIGHT_GRAY);
		rdbtnMale.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		rdbtnMale.setBounds(382, 194, 57, 23);
		rdbtnMale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gender = "Male";
			}
		});
		add(rdbtnMale);

		// button used to indicate if the patient gender is female
		JRadioButton rdbtnFemale = new JRadioButton("F");
		rdbtnFemale.setForeground(new Color(0, 102, 204));
		rdbtnFemale.setBackground(Color.LIGHT_GRAY);
		rdbtnFemale.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		rdbtnFemale.setBounds(444, 194, 63, 23);
		rdbtnFemale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gender = "Female";
			}
		});
		add(rdbtnFemale);

		// patient date of birth label
		JLabel lblDOB = new JLabel("Date of birth:");
		lblDOB.setForeground(new Color(0, 102, 204));
		lblDOB.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lblDOB.setBounds(153, 257, 168, 19);
		add(lblDOB);

		// text field used to enter patient date of birth
		txtDOB = new JTextField();
		txtDOB.setBounds(382, 256, 103, 20);
		add(txtDOB);
		txtDOB.setColumns(10);

		// label used to indicate the form of the date of birth
		JLabel lblAgeFormat = new JLabel("dd/mm/yyyy");
		lblAgeFormat.setForeground(Color.RED);
		lblAgeFormat.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lblAgeFormat.setBounds(534, 257, 138, 20);
		add(lblAgeFormat);

		// patients health pre-conditions label
		JLabel lblPreCondition = new JLabel("Pre-conditions :");
		lblPreCondition.setForeground(new Color(0, 102, 204));
		lblPreCondition.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lblPreCondition.setBounds(153, 306, 168, 20);
		add(lblPreCondition);

		// box used to indicate if the patient has heart disease
		JCheckBox chckbxHeartDisease = new JCheckBox("Heart Disease");
		chckbxHeartDisease.setForeground(new Color(0, 102, 204));
		chckbxHeartDisease.setBackground(Color.LIGHT_GRAY);
		chckbxHeartDisease.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		chckbxHeartDisease.setBounds(382, 334, 138, 23);
		chckbxHeartDisease.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//flag yes for heart disease
				heartdisease = "Y";
			}
		});
		add(chckbxHeartDisease);

		// box used to indicate if the patient has diabetes
		JCheckBox chckbxDiabetes = new JCheckBox("Diabetes");
		chckbxDiabetes.setForeground(new Color(0, 102, 204));
		chckbxDiabetes.setBackground(Color.LIGHT_GRAY);
		chckbxDiabetes.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		chckbxDiabetes.setBounds(382, 362, 138, 23);
		chckbxDiabetes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//flag yes for diabetes
				diabetes = "Y";
			}
		});
		add(chckbxDiabetes);

		// box used to indicate if the patient has anxiety
		JCheckBox chckbxAnxiety = new JCheckBox("Anxiety");
		chckbxAnxiety.setForeground(new Color(0, 102, 204));
		chckbxAnxiety.setBackground(Color.LIGHT_GRAY);
		chckbxAnxiety.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		chckbxAnxiety.setBounds(382, 390, 138, 23);
		chckbxAnxiety.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//flag yes to anxiety
				anxiety = "Y";
			}
		});
		add(chckbxAnxiety);

		// button used to cancel the registration process and return to the login screen
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(885, 528, 89, 23);
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				// if cancel is clicked no data will be saved and new login panel will be launched. 
				PatientLogin new_login = new PatientLogin(frame);
				frame.setContentPane(new_login);
				frame.revalidate();

			}
		});

		// button used to submit patient registration information
		JButton btnDone = new JButton("Done");
		btnDone.setForeground(new Color(0, 102, 204));
		btnDone.setBounds(382, 467, 103, 23);
		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					// Extract data from the GUI fields and assign as new patient parameters:
					PatientDB patientDB = new PatientDB();
					patientDB = patientDB.loadPatientDB();
					String patientId = Integer.toString(patientDB.size() + 1); // newly created ID
					String username = userParams[0]; // username
					String password = userParams[1]; // password
					String pname = txtNameField.getText(); // name
					String pgender = gender; // M or F
					String pdob = txtDOB.getText(); // DOB
					String heartdisease_y = heartdisease; // Y or N
					String diabetes_y = diabetes; // Y or N
					String anxiety_y = anxiety; // Y or N

					// add new patient record to the patient database
					patientDB.add(new String[] { patientId, username, password, pname,pgender, pdob, heartdisease_y, diabetes_y, anxiety_y });
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
		add(btnDone);
		add(btnCancel);
		
		JLabel lblAHSimg = new JLabel("");
		lblAHSimg.setIcon(new ImageIcon(PatientPersonalInformation.class.getResource("/iteration_3/ahs.png")));
		lblAHSimg.setBounds(56, 528, 217, 73);
		add(lblAHSimg);

	} // end PatientPersonalInformation constructor
} // end class PatientPersonalInformation
