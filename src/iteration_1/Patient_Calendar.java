package iteration_1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class Patient_Calendar extends JPanel {

	private static final long serialVersionUID = 3L; // serial ID for java object saving

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public Patient_Calendar(final JFrame frame, String patientID) throws Exception {

		setLayout(null);

		PatientDB patientDB = new PatientDB();
		patientDB = patientDB.loadPatientDB(); // load saved database file

		String[] patientRecord = patientDB.getPatientRecord(patientID); // pull patient record from database

		// assign the elements of patient record to meaningful variable names
		String id = patientRecord[0];
		String username = patientRecord[1];
		String name = patientRecord[3];
		String gender = patientRecord[4];
		String dob = patientRecord[5];
		String heartdisease = patientRecord[6];
		String diabetes = patientRecord[7];
		String anxiety = patientRecord[8];

		JLabel lblHeader = new JLabel("Patient DashBoard");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHeader.setBounds(153, 11, 158, 43);
		add(lblHeader);

		// 8 labels to indicate what values are stored in the patient database (password is omitted)
		JLabel lbl_ID = new JLabel("ID");
		lbl_ID.setBounds(102, 75, 79, 14);
		add(lbl_ID);

		JLabel lbl_username = new JLabel("Username");
		lbl_username.setBounds(102, 98, 79, 14);
		add(lbl_username);

		JLabel lbl_name = new JLabel("Name");
		lbl_name.setBounds(102, 124, 79, 14);
		add(lbl_name);

		JLabel lbl_gender = new JLabel("Gender");
		lbl_gender.setBounds(102, 148, 79, 14);
		add(lbl_gender);

		JLabel lbl_dob = new JLabel("DOB");
		lbl_dob.setBounds(102, 173, 73, 14);
		add(lbl_dob);

		JLabel lbl_heart = new JLabel("Heart Disease");
		lbl_heart.setBounds(102, 198, 79, 14);
		add(lbl_heart);

		JLabel lbl_diabetes = new JLabel("Diabetes");
		lbl_diabetes.setBounds(102, 223, 79, 14);
		add(lbl_diabetes);

		JLabel lbl_anxiety = new JLabel("Anxiety");
		lbl_anxiety.setBounds(102, 248, 73, 14);
		add(lbl_anxiety);

		// 8 values corresponding to the datafields that have been stored in the patient database record
		JLabel lbl_ID_val = new JLabel(id);
		lbl_ID_val.setBounds(247, 75, 79, 14);
		add(lbl_ID_val);

		JLabel lbl_username_val = new JLabel(username);
		lbl_username_val.setBounds(247, 98, 79, 14);
		add(lbl_username_val);

		JLabel lbl_name_val = new JLabel(name);
		lbl_name_val.setBounds(247, 124, 79, 14);
		add(lbl_name_val);

		JLabel lbl_gender_val = new JLabel(gender);
		lbl_gender_val.setBounds(247, 148, 79, 14);
		add(lbl_gender_val);

		JLabel lbl_dob_val = new JLabel(dob);
		lbl_dob_val.setBounds(247, 173, 73, 14);
		add(lbl_dob_val);

		JLabel lbl_heart_val = new JLabel(heartdisease);
		lbl_heart_val.setBounds(247, 198, 79, 14);
		add(lbl_heart_val);

		JLabel lbl_diabetes_val = new JLabel(diabetes);
		lbl_diabetes_val.setBounds(247, 223, 79, 14);
		add(lbl_diabetes_val);

		JLabel lbl_anxiety_val = new JLabel(anxiety);
		lbl_anxiety_val.setBounds(247, 248, 73, 14);
		add(lbl_anxiety_val);

	} // end Patient_Calendar constructor

} // end class Patient_Calendar
