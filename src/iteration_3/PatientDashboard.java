package iteration_3;

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
import javax.swing.SwingConstants;
import java.awt.Color;

public class PatientDashboard extends JPanel {

	private static final long serialVersionUID = 3L; // serial ID for java object saving

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public PatientDashboard(final JFrame frame, final String patientID) throws Exception {

		setBackground(Color.GRAY);
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

		// header for the window
		JLabel lblHeader = new JLabel("Patient DashBoard");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lblHeader.setBounds(385, 48, 227, 43);
		add(lblHeader);

		// 8 labels to indicate what values are stored in the patient database (password is omitted)
		JLabel lbl_ID = new JLabel("ID:");
		lbl_ID.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_ID.setBounds(168, 115, 79, 14);
		add(lbl_ID);

		// patient username label
		JLabel lbl_username = new JLabel("Username:");
		lbl_username.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_username.setBounds(168, 148, 79, 14);
		add(lbl_username);

		// patient name label
		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_name.setBounds(168, 184, 79, 14);
		add(lbl_name);

		// patient gender label
		JLabel lbl_gender = new JLabel("Gender:");
		lbl_gender.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_gender.setBounds(168, 220, 79, 14);
		add(lbl_gender);

		// patient date of birth label
		JLabel lbl_dob = new JLabel("DOB:");
		lbl_dob.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_dob.setBounds(168, 256, 73, 14);
		add(lbl_dob);

		// patient heart disease label
		JLabel lbl_heart = new JLabel("Heart Disease:");
		lbl_heart.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_heart.setBounds(168, 292, 100, 14);
		add(lbl_heart);

		// patient diabetes label
		JLabel lbl_diabetes = new JLabel("Diabetes:");
		lbl_diabetes.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_diabetes.setBounds(168, 325, 79, 14);
		add(lbl_diabetes);

		// patient anxiety label
		JLabel lbl_anxiety = new JLabel("Anxiety:");
		lbl_anxiety.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_anxiety.setBounds(168, 358, 73, 14);
		add(lbl_anxiety);

		// patient id value
		JLabel lbl_ID_val = new JLabel(id);
		lbl_ID_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_ID_val.setBounds(313, 115, 91, 14);
		add(lbl_ID_val);

		// patient username value
		JLabel lbl_username_val = new JLabel(username);
		lbl_username_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_username_val.setBounds(313, 148, 91, 14);
		add(lbl_username_val);

		// patient name value
		JLabel lbl_name_val = new JLabel(name);
		lbl_name_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_name_val.setBounds(313, 184, 91, 14);
		add(lbl_name_val);

		// patient gender value
		JLabel lbl_gender_val = new JLabel(gender);
		lbl_gender_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_gender_val.setBounds(313, 220, 91, 14);
		add(lbl_gender_val);

		// patient date of birth value
		JLabel lbl_dob_val = new JLabel(dob);
		lbl_dob_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_dob_val.setBounds(313, 256, 91, 14);
		add(lbl_dob_val);

		/// patient heart disease value
		JLabel lbl_heart_val = new JLabel(heartdisease);
		lbl_heart_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_heart_val.setBounds(313, 292, 91, 14);
		add(lbl_heart_val);

		// patient diabetes value
		JLabel lbl_diabetes_val = new JLabel(diabetes);
		lbl_diabetes_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_diabetes_val.setBounds(313, 325, 91, 14);
		add(lbl_diabetes_val);

		// patient anxiety value
		JLabel lbl_anxiety_val = new JLabel(anxiety);
		lbl_anxiety_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_anxiety_val.setBounds(313, 358, 91, 14);
		add(lbl_anxiety_val);

		// button allows the patient to check doctor availability
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
		btnNewButton.setBounds(518, 437, 160, 23);
		add(btnNewButton);

		// button allows the patient to exit the program
		JButton btn_logout = new JButton("Logout");
		btn_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btn_logout.setBounds(814, 528, 160, 23);
		add(btn_logout);

		// button allows the patient to view a window where they can edit their personal information
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
		btn_settings.setBounds(118, 437, 160, 23);
		add(btn_settings);

		// button allows patient to view doctor availability
		JButton btn_appointments = new JButton("Appointment List");
		btn_appointments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					frame.setContentPane(new AppointmentCalendar(frame, patientID, "Patient"));
					frame.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_appointments.setBounds(324, 437, 160, 23);
		add(btn_appointments);

		// button allows patient to view all requested appointments associated with their account
		JButton btn_request_appoint = new JButton("Appointment Requests");
		btn_request_appoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					frame.setContentPane(new RequestAppointment(frame, patientID, "Patient"));
					frame.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_request_appoint.setBounds(713, 437, 180, 23);
		add(btn_request_appoint);

	} // end PatientDashboard constructor

} // end class PatientDashboard
