package iteration_3;

/**
 * The DoctorSettings.java class provides a frame for the doctor to edit their personal information. Doctors are 
 * redirected to this frame after they select the "settings" button in their dash board.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-29
 */

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class DoctorSettings extends JPanel {

	private static final long serialVersionUID = 16L; // serial ID for java object saving
	private JTextField text_name_field;

	private String name_val;
	private String gender_val;
	private String department_val;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public DoctorSettings(final JFrame frame, final String id) throws Exception {

		setBackground(Color.GRAY);
		setLayout(null);

		DoctorDB doctorDB = new DoctorDB();
		doctorDB = doctorDB.loadDoctorDB(); // load database from file

		String[] doctorRecord = doctorDB.getDoctorRecord(id);
		this.name_val = doctorRecord[3];
		this.gender_val = doctorRecord[4];
		this.department_val = doctorRecord[5];
		System.out.println(this.name_val + " " + this.gender_val + " " + this.department_val);

		// Window header
		JLabel lblNewLabel = new JLabel("Doctor Personal Information");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lblNewLabel.setBounds(333, 71, 332, 29);
		add(lblNewLabel);

		// label for name text field
		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_name.setBounds(204, 183, 143, 29);
		add(lbl_name);

		// label for male/female gender buttons
		JLabel lbl_gender = new JLabel("Gender:");
		lbl_gender.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_gender.setBounds(204, 257, 143, 29);
		add(lbl_gender);

		// label for department dropdown list
		JLabel lbl_department = new JLabel("Department:");
		lbl_department.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_department.setBounds(204, 337, 143, 29);
		add(lbl_department);

		// name text field
		text_name_field = new JTextField();
		text_name_field.setBounds(404, 189, 214, 20);
		add(text_name_field);
		text_name_field.setText(doctorRecord[3]);
		text_name_field.setColumns(10);

		// button to select for male gender
		final JRadioButton rdbtn_male = new JRadioButton("Male");
		rdbtn_male.setBackground(Color.GRAY);
		rdbtn_male.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		rdbtn_male.setBounds(404, 262, 64, 23);
		add(rdbtn_male);

		// button to select for female gender
		final JRadioButton rdbtn_female = new JRadioButton("Female");
		rdbtn_female.setBackground(Color.GRAY);
		rdbtn_female.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		rdbtn_female.setBounds(481, 262, 85, 23);
		add(rdbtn_female);

		// set the gender according to which button is pressed
		if (doctorRecord[4].equalsIgnoreCase("M")) {
			rdbtn_male.setSelected(true);
			rdbtn_female.setSelected(false);
		} else {
			rdbtn_male.setSelected(false);
			rdbtn_female.setSelected(true);
		}

		// listener for Male button
		rdbtn_male.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtn_male.isSelected()) {
					gender_val = "M";
					rdbtn_male.setSelected(true);
					rdbtn_female.setSelected(false);
				} else {
					rdbtn_male.setSelected(false);
					rdbtn_female.setSelected(true);
					gender_val = "F";
				}
				System.out.println(gender_val);
			}
		});

		// listener for Female button
		rdbtn_female.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtn_female.isSelected()) {
					gender_val = "F";
					rdbtn_male.setSelected(false);
					rdbtn_female.setSelected(true);
				} else {
					gender_val = "M";
					rdbtn_male.setSelected(true);
					rdbtn_female.setSelected(false);
				}
				System.out.println(gender_val);
			}
		});

		// dropdown list to show all departments
		JComboBox<String> comboBox_depart = new JComboBox<>();

		// add items to the department dropdown list
		comboBox_depart.addItem("");
		comboBox_depart.addItem("Emergency ");
		comboBox_depart.addItem("Cardiology");
		comboBox_depart.addItem("ICU       ");
		comboBox_depart.addItem("Neurology ");
		comboBox_depart.setBounds(404, 343, 214, 20);
		add(comboBox_depart);

		// listener for department dropdown list
		comboBox_depart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				department_val = (String) cb.getSelectedItem();
			}
		});

		comboBox_depart.setSelectedItem(doctorRecord[5]); // initialize dropdown list to current doctor department

		// button that allows the user to save changes and return to dashboard
		JButton btn_save_return = new JButton("Save and Return");
		btn_save_return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					DoctorDB doctorDB = new DoctorDB();
					doctorDB = doctorDB.loadDoctorDB(); // load database from file

					name_val = text_name_field.getText();

					// delete old record from the doctor database
					for (int i = 0; i < doctorDB.size(); i++) {
						if (doctorDB.get(i).getCustomElement()[0].equalsIgnoreCase(id)) {
							doctorDB.get(i).getCustomElement()[3] = name_val;
							doctorDB.get(i).getCustomElement()[4] = gender_val;
							doctorDB.get(i).getCustomElement()[5] = department_val;
						}
					}

					doctorDB.saveDoctorDB();

					// redirect to patient dash board
					frame.setContentPane(new DoctorDashboard(frame, id));
					frame.revalidate();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_save_return.setBounds(843, 528, 131, 23);
		add(btn_save_return);

	} // end DoctorSettings constructor

} // end class DoctorSettings
