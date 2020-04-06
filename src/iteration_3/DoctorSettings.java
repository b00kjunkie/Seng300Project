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
import javax.swing.ImageIcon;

public class DoctorSettings extends JPanel {

	private static final long serialVersionUID = 9L; // serial ID for java object saving
	private JTextField text_name_field;

	private String name_val;
	private String gender_val;
	private String department_val;

	/**
	 * Creates a window which allows doctors to view and edit their personal information
	 * 
	 * @param frame of type JFrame representing the program window
	 * @param id    of type String representing the id number of the doctor who opened the window
	 * @throws Exception
	 */
	protected DoctorSettings(final JFrame frame, final String id) throws Exception {

		// set window properties
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		DoctorDB doctorDB = new DoctorDB();
		doctorDB = doctorDB.loadDoctorDB(); // load database from file

		// initialize instance variables with doctor info
		String[] doctorRecord = doctorDB.getDoctorRecord(id);
		this.name_val = doctorRecord[3];
		this.gender_val = doctorRecord[4];
		this.department_val = doctorRecord[5];

		// Window header
		JLabel lblNewLabel = new JLabel("Doctor Personal Information");
		lblNewLabel.setForeground(new Color(0, 102, 204));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lblNewLabel.setBounds(333, 71, 332, 29);
		add(lblNewLabel);

		// Alberta health services logo
		JLabel lblAHSImg = new JLabel("");
		lblAHSImg.setIcon(new ImageIcon(DoctorSettings.class.getResource("/iteration_3/ahs.png")));
		lblAHSImg.setBounds(41, 11, 190, 97);
		add(lblAHSImg);

		// label for name text field
		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setForeground(new Color(0, 102, 204));
		lbl_name.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_name.setBounds(204, 183, 143, 29);
		add(lbl_name);

		// label for male/female gender buttons
		JLabel lbl_gender = new JLabel("Gender:");
		lbl_gender.setForeground(new Color(0, 102, 204));
		lbl_gender.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_gender.setBounds(204, 257, 143, 29);
		add(lbl_gender);

		// label for department dropdown list
		JLabel lbl_department = new JLabel("Department:");
		lbl_department.setForeground(new Color(0, 102, 204));
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
		rdbtn_male.setForeground(new Color(0, 102, 204));
		rdbtn_male.setBackground(Color.LIGHT_GRAY);
		rdbtn_male.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		rdbtn_male.setBounds(404, 262, 64, 23);
		add(rdbtn_male);

		// button to select for female gender
		final JRadioButton rdbtn_female = new JRadioButton("Female");
		rdbtn_female.setForeground(Color.RED);
		rdbtn_female.setBackground(Color.LIGHT_GRAY);
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
		btn_save_return.setForeground(new Color(0, 102, 204));
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
		btn_save_return.setBounds(435, 436, 131, 23);
		add(btn_save_return);

		// allow user to return to the dash board without saving changes
		JButton btn_return = new JButton("Back");
		btn_return.setForeground(new Color(0, 102, 204));
		btn_return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					frame.setContentPane(new DoctorDashboard(frame, id));
					frame.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_return.setBounds(814, 528, 160, 23);
		add(btn_return);

	} // end DoctorSettings constructor

} // end class DoctorSettings
