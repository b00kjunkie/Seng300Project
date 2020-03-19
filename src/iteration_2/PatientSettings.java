package iteration_2;

/**
 * The PatientSettings.java class provides a frame for the patient to edit their personal information. Patients are 
 * redirected to this frame after they select the "settings" button in their dash board.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-16
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PatientSettings extends JPanel {

	private static final long serialVersionUID = 15L; // serial ID for java object saving
	private JTextField txt_name_val;
	private JTextField txt_dob_val;

	// variables which are used to update/edit the patient record data fields
	private String new_gender; // default to Female
	private String new_heart_disease;
	private String new_diabetes;
	private String new_anxiety;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public PatientSettings(final JFrame frame, final String patientID) throws Exception {

		setLayout(null);

		PatientDB patientDB = new PatientDB();
		patientDB = patientDB.loadPatientDB(); // load saved database file

		String[] patientRecord = patientDB.getPatientRecord(patientID); // pull patient record from database

		// assign the elements of patient record to meaningful variable names
		String name = patientRecord[3];
		String gender = patientRecord[4];
		String dob = patientRecord[5];
		String heartdisease = patientRecord[6];
		String diabetes = patientRecord[7];
		String anxiety = patientRecord[8];

		JLabel lb_settings_header = new JLabel("Personal Information");
		lb_settings_header.setHorizontalAlignment(SwingConstants.CENTER);
		lb_settings_header.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_settings_header.setBounds(122, 11, 208, 22);
		add(lb_settings_header);

		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setBounds(95, 69, 94, 14);
		add(lbl_name);

		txt_name_val = new JTextField(name);
		txt_name_val.setBounds(244, 66, 107, 20);
		add(txt_name_val);
		txt_name_val.setColumns(10);

		JLabel lbl_gender = new JLabel("Gender:");
		lbl_gender.setBounds(95, 94, 94, 14);
		add(lbl_gender);

		final JRadioButton rdbtn_male = new JRadioButton("M");
		new_gender = gender;
		rdbtn_male.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtn_male.isSelected()) {
					new_gender = "M";
				} else {
					new_gender = "F";
				}
			}
		});
		rdbtn_male.setBounds(254, 93, 39, 23);
		add(rdbtn_male);

		final JRadioButton rdbtn_female = new JRadioButton("F");
		rdbtn_female.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtn_female.isSelected()) {
					new_gender = "F";
				} else {
					new_gender = "M";
				}
			}
		});
		if (gender.equalsIgnoreCase("M")) {
			rdbtn_male.setSelected(true);
		} else {
			rdbtn_female.setSelected(true);
		}
		rdbtn_female.setBounds(295, 93, 39, 23);
		add(rdbtn_female);

		JLabel lbl_dob = new JLabel("Date of Birth:");
		lbl_dob.setBounds(95, 119, 94, 14);
		add(lbl_dob);

		txt_dob_val = new JTextField(dob);
		txt_dob_val.setBounds(244, 116, 107, 20);
		add(txt_dob_val);
		txt_dob_val.setColumns(10);

		JLabel lbl_dob_format = new JLabel("dd/mm/yy");
		lbl_dob_format.setBounds(359, 119, 66, 14);
		add(lbl_dob_format);

		JLabel lbl_preconditions = new JLabel("Pre-conditions:");
		lbl_preconditions.setBounds(95, 144, 94, 14);
		add(lbl_preconditions);

		final JCheckBox chckbx_heart_disease = new JCheckBox("Heart Disease");
		new_heart_disease = heartdisease;
		chckbx_heart_disease.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chckbx_heart_disease.isSelected()) {
					new_heart_disease = "Y";
				} else {
					new_heart_disease = "N";
				}
			}
		});
		if (heartdisease.equalsIgnoreCase("Y")) {
			chckbx_heart_disease.setSelected(true);
		}
		chckbx_heart_disease.setBounds(244, 168, 120, 23);
		add(chckbx_heart_disease);

		final JCheckBox chckbx_diabetes = new JCheckBox("Diabetes");
		new_diabetes = diabetes;
		chckbx_diabetes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chckbx_diabetes.isSelected()) {
					new_diabetes = "Y";
				} else {
					new_diabetes = "N";
				}
			}
		});

		if (diabetes.equalsIgnoreCase("Y")) {
			chckbx_diabetes.setSelected(true);
		}
		chckbx_diabetes.setBounds(244, 194, 97, 23);
		add(chckbx_diabetes);

		final JCheckBox chckbx_anxiety = new JCheckBox("Anxiety");
		new_anxiety = anxiety;
		chckbx_anxiety.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chckbx_anxiety.isSelected()) {
					new_anxiety = "Y";
				} else {
					new_anxiety = "N";
				}
			}
		});

		if (anxiety.equalsIgnoreCase("Y")) {
			chckbx_anxiety.setSelected(true);
		}
		chckbx_anxiety.setBounds(244, 220, 97, 23);
		add(chckbx_anxiety);

		JButton btn_save = new JButton("Save & Return");
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PatientDB patientDB = new PatientDB();
					patientDB = patientDB.loadPatientDB();
					String[] oldRecord = patientDB.getPatientRecord(patientID); // pull patient record from database

					String p1 = oldRecord[0]; // same id as before
					String p2 = oldRecord[1]; // same username as before
					String p3 = oldRecord[2]; // same password as before
					String p4 = txt_name_val.getText(); // name

					String p5 = new_gender; // M or F
					String p6 = txt_dob_val.getText(); // DOB
					String p7 = new_heart_disease; // Y or N
					String p8 = new_diabetes; // Y or N
					String p9 = new_anxiety; // Y or N

					// delete old record from the patient database
					for (int i = 0; i < patientDB.size(); i++) {
						if (patientDB.get(i).getCustomElement()[0].equalsIgnoreCase(patientID)) {
							patientDB.remove(i);
						}
					}

					// add new patient record to the patient database
					patientDB.add(new String[] { p1, p2, p3, p4, p5, p6, p7, p8, p9 });
					// save the database to file
					patientDB.savePatientDB();

					// redirect to patient dash board

					PatientDashboard login = new PatientDashboard(frame, patientID);
					frame.setContentPane(login);
					frame.revalidate();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btn_save.setBounds(95, 254, 131, 23);
		add(btn_save);

	} // end constructor

} // end class PatientSettings
