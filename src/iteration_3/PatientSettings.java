package iteration_3;

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
import java.awt.Color;
import javax.swing.ImageIcon;

public class PatientSettings extends JPanel {

	private static final long serialVersionUID = 15L; // serial ID for java object saving
	private JTextField txt_name_val; // patient name
	private JTextField txt_dob_val; // patient date of birth

	// variables which are used to update/edit the patient record data fields
	private String new_gender; // default to Female
	private String new_heart_disease; // patient heart disease flag
	private String new_diabetes; // patient diabetes flag
	private String new_anxiety; // patient anxiety flag

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public PatientSettings(final JFrame frame, final String patientID) throws Exception {

		// set window properties
		setBackground(Color.LIGHT_GRAY);
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

		// window header
		JLabel lb_settings_header = new JLabel("Personal Information");
		lb_settings_header.setForeground(new Color(0, 102, 204));
		lb_settings_header.setHorizontalAlignment(SwingConstants.CENTER);
		lb_settings_header.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lb_settings_header.setBounds(261, 83, 353, 29);
		add(lb_settings_header);

		// patient name label
		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setForeground(new Color(0, 102, 204));
		lbl_name.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_name.setBounds(161, 158, 94, 22);
		add(lbl_name);

		// patient name value
		txt_name_val = new JTextField(name);
		txt_name_val.setBounds(396, 161, 131, 20);
		add(txt_name_val);
		txt_name_val.setColumns(10);

		// patient gender label
		JLabel lbl_gender = new JLabel("Gender:");
		lbl_gender.setForeground(new Color(0, 102, 204));
		lbl_gender.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_gender.setBounds(161, 208, 94, 22);
		add(lbl_gender);

		// button used to indicate if the patient gender is male
		final JRadioButton rdbtn_male = new JRadioButton("M");
		rdbtn_male.setForeground(new Color(0, 102, 204));
		rdbtn_male.setBackground(Color.LIGHT_GRAY);
		rdbtn_male.setFont(new Font("Cambria Math", Font.PLAIN, 16));
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
		rdbtn_male.setBounds(396, 207, 39, 23);
		add(rdbtn_male);

		// button used to indicate if the patient gender is female
		final JRadioButton rdbtn_female = new JRadioButton("F");
		rdbtn_female.setForeground(Color.RED);
		rdbtn_female.setBackground(Color.LIGHT_GRAY);
		rdbtn_female.setFont(new Font("Cambria Math", Font.PLAIN, 16));
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
		rdbtn_female.setBounds(437, 207, 39, 23);
		add(rdbtn_female);

		// patient date of birth label
		JLabel lbl_dob = new JLabel("Date of Birth:");
		lbl_dob.setForeground(new Color(0, 102, 204));
		lbl_dob.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_dob.setBounds(161, 261, 144, 22);
		add(lbl_dob);

		// patient date of birth value
		txt_dob_val = new JTextField(dob);
		txt_dob_val.setBounds(396, 264, 131, 20);
		add(txt_dob_val);
		txt_dob_val.setColumns(10);

		// label used to indicate the date of birth form
		JLabel lbl_dob_format = new JLabel("dd/mm/yy");
		lbl_dob_format.setForeground(Color.RED);
		lbl_dob_format.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_dob_format.setBounds(560, 265, 94, 17);
		add(lbl_dob_format);

		// patient health pre-conditions label
		JLabel lbl_preconditions = new JLabel("Pre-conditions:");
		lbl_preconditions.setForeground(new Color(0, 102, 204));
		lbl_preconditions.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_preconditions.setBounds(161, 317, 170, 20);
		add(lbl_preconditions);

		// box used to indicate if the patient has heart disease
		final JCheckBox chckbx_heart_disease = new JCheckBox("Heart Disease");
		chckbx_heart_disease.setForeground(new Color(0, 102, 204));
		chckbx_heart_disease.setBackground(Color.LIGHT_GRAY);
		chckbx_heart_disease.setFont(new Font("Cambria Math", Font.PLAIN, 16));
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
		chckbx_heart_disease.setBounds(396, 317, 144, 23);
		add(chckbx_heart_disease);

		// box used to indicate if the patient has diabetes
		final JCheckBox chckbx_diabetes = new JCheckBox("Diabetes");
		chckbx_diabetes.setForeground(new Color(0, 102, 204));
		chckbx_diabetes.setBackground(Color.LIGHT_GRAY);
		chckbx_diabetes.setFont(new Font("Cambria Math", Font.PLAIN, 16));
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
		chckbx_diabetes.setBounds(396, 343, 97, 23);
		add(chckbx_diabetes);

		// box used to indicate if the patient has anxiety
		final JCheckBox chckbx_anxiety = new JCheckBox("Anxiety");
		chckbx_anxiety.setForeground(new Color(0, 102, 204));
		chckbx_anxiety.setBackground(Color.LIGHT_GRAY);
		chckbx_anxiety.setFont(new Font("Cambria Math", Font.PLAIN, 16));
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
		chckbx_anxiety.setBounds(396, 369, 97, 23);
		add(chckbx_anxiety);

		// buttons allows the patient to save changes made to information and return to the dashboard
		JButton btn_save = new JButton("Save & Return");
		btn_save.setForeground(new Color(51, 102, 204));
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PatientDB patientDB = new PatientDB();
					patientDB = patientDB.loadPatientDB();

					// update patient record in the patient database
					for (int i = 0; i < patientDB.size(); i++) {
						if (patientDB.get(i).getCustomElement()[0].equalsIgnoreCase(patientID)) {
							patientDB.get(i).getCustomElement()[3] = txt_name_val.getText(); // name
							patientDB.get(i).getCustomElement()[4] = new_gender; // M or F
							patientDB.get(i).getCustomElement()[5] = txt_dob_val.getText(); // DOB
							patientDB.get(i).getCustomElement()[6] = new_heart_disease; // Y or N
							patientDB.get(i).getCustomElement()[7] = new_diabetes; // Y or N
							patientDB.get(i).getCustomElement()[8] = new_anxiety; // Y or N
						}
					}

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

		btn_save.setBounds(405, 479, 131, 23);
		add(btn_save);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PatientSettings.class.getResource("/iteration_3/ahs.png")));
		lblNewLabel.setBounds(26, 29, 179, 71);
		add(lblNewLabel);

	} // end constructor

} // end class PatientSettings
