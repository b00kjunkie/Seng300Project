package iteration_2;

/**
 * The PatientDashboard.java class provides a frame for the patient dash board. Patients are redirected to this frame
 * after they have successfully logged in through the Patient_Login class.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-10
 * Updated:		2020-03-17
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PatientDashboard extends JPanel {

	private static final long serialVersionUID = 3L; // serial ID for java object saving

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public PatientDashboard(final JFrame frame, final String patientID) throws Exception {

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
		JLabel lbl_ID = new JLabel("ID:");
		lbl_ID.setBounds(27, 65, 79, 14);
		add(lbl_ID);

		JLabel lbl_username = new JLabel("Username:");
		lbl_username.setBounds(27, 88, 79, 14);
		add(lbl_username);

		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setBounds(27, 114, 79, 14);
		add(lbl_name);

		JLabel lbl_gender = new JLabel("Gender:");
		lbl_gender.setBounds(27, 138, 79, 14);
		add(lbl_gender);

		JLabel lbl_dob = new JLabel("DOB:");
		lbl_dob.setBounds(27, 163, 73, 14);
		add(lbl_dob);

		JLabel lbl_heart = new JLabel("Heart Disease:");
		lbl_heart.setBounds(27, 188, 100, 14);
		add(lbl_heart);

		JLabel lbl_diabetes = new JLabel("Diabetes:");
		lbl_diabetes.setBounds(27, 213, 79, 14);
		add(lbl_diabetes);

		JLabel lbl_anxiety = new JLabel("Anxiety:");
		lbl_anxiety.setBounds(27, 238, 73, 14);
		add(lbl_anxiety);

		// 8 values corresponding to the datafields that have been stored in the patient database record
		JLabel lbl_ID_val = new JLabel(id);
		lbl_ID_val.setBounds(172, 65, 79, 14);
		add(lbl_ID_val);

		JLabel lbl_username_val = new JLabel(username);
		lbl_username_val.setBounds(172, 88, 79, 14);
		add(lbl_username_val);

		JLabel lbl_name_val = new JLabel(name);
		lbl_name_val.setBounds(172, 114, 79, 14);
		add(lbl_name_val);

		JLabel lbl_gender_val = new JLabel(gender);
		lbl_gender_val.setBounds(172, 138, 79, 14);
		add(lbl_gender_val);

		JLabel lbl_dob_val = new JLabel(dob);
		lbl_dob_val.setBounds(172, 163, 73, 14);
		add(lbl_dob_val);

		JLabel lbl_heart_val = new JLabel(heartdisease);
		lbl_heart_val.setBounds(172, 188, 79, 14);
		add(lbl_heart_val);

		JLabel lbl_diabetes_val = new JLabel(diabetes);
		lbl_diabetes_val.setBounds(172, 213, 79, 14);
		add(lbl_diabetes_val);

		JLabel lbl_anxiety_val = new JLabel(anxiety);
		lbl_anxiety_val.setBounds(172, 238, 73, 14);
		add(lbl_anxiety_val);
		
		JButton btnNewButton = new JButton("Doctor Availability");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DoctorUnavailabilityView availView = new DoctorUnavailabilityView(frame, patientID, "patient");
					frame.setContentPane(availView);
					frame.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(291, 154, 160, 23);
		add(btnNewButton);
		
		JButton btn_logout = new JButton("Logout");
		btn_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btn_logout.setBounds(291, 245, 160, 23);
		add(btn_logout);
		
		JButton btn_settings = new JButton("Settings");
		btn_settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PatientSettings login = new PatientSettings(frame, patientID);
					frame.setContentPane(login);
					frame.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_settings.setBounds(291, 61, 160, 23);
		add(btn_settings);
		
		JButton btn_appointments = new JButton("Appointment List");
		btn_appointments.setBounds(291, 110, 160, 23);
		add(btn_appointments);
		
		JButton btn_request_appoint = new JButton("Request Appointment");
		btn_request_appoint.setBounds(291, 198, 160, 23);
		add(btn_request_appoint);

	} // end PatientDashboard constructor

} // end class PatientDashboard
