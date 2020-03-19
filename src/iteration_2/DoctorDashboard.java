package iteration_2;

/**
 * The DoctorDashboard.java class provides a frame for the doctor dash board. Doctors are redirected to this frame
 * after they have successfully logged in through the Staff_Login class.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-16
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class DoctorDashboard extends JPanel {

	private static final long serialVersionUID = 10L; // serial ID for java object saving

	JLabel lbl_date1_val = new JLabel("_");
	JLabel lbl_time1_val = new JLabel("_");
	JLabel lbl_date2_val = new JLabel("_");
	JLabel lbl_time2_val = new JLabel("_");
	JLabel lbl_date3_val = new JLabel("_");
	JLabel lbl_time3_val = new JLabel("_");
	JLabel lbl_date4_val = new JLabel("_");
	JLabel lbl_time4_val = new JLabel("_");
	JLabel lbl_date5_val = new JLabel("_");
	JLabel lbl_time5_val = new JLabel("_");

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public DoctorDashboard(final JFrame frame, final String doctorID) throws Exception {

		setLayout(null);

		refresh(doctorID);

		DoctorDB doctorDB = new DoctorDB();
		doctorDB = doctorDB.loadDoctorDB(); // load saved database file

		String[] doctorRecord = doctorDB.getDoctorRecord(doctorID); // pull doctor record from database

		// assign the elements of doctor record to meaningful variable names
		String id = doctorRecord[0];
		String username = doctorRecord[1];
		String name = doctorRecord[3];
		String gender = doctorRecord[4];
		String department = doctorRecord[5];

		JLabel lbl_doctor_header = new JLabel("Doctor Dashboard");
		lbl_doctor_header.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_doctor_header.setBounds(146, 11, 174, 35);
		add(lbl_doctor_header);

		JLabel lbl_id = new JLabel("ID:");
		lbl_id.setBounds(21, 84, 69, 14);
		add(lbl_id);

		JLabel lbl_id_val = new JLabel(id);
		lbl_id_val.setBounds(113, 84, 130, 14);
		add(lbl_id_val);

		JLabel lbl_username = new JLabel("Username:");
		lbl_username.setBounds(21, 109, 69, 14);
		add(lbl_username);

		JLabel lbl_username_val = new JLabel(username);
		lbl_username_val.setBounds(113, 109, 130, 14);
		add(lbl_username_val);

		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setBounds(21, 134, 69, 14);
		add(lbl_name);

		JLabel lbl_name_val = new JLabel(name);
		lbl_name_val.setBounds(113, 134, 130, 14);
		add(lbl_name_val);

		JLabel lbl_gender = new JLabel("Gender:");
		lbl_gender.setBounds(21, 159, 69, 14);
		add(lbl_gender);

		JLabel lbl_gender_val = new JLabel(gender);
		lbl_gender_val.setBounds(113, 159, 130, 14);
		add(lbl_gender_val);

		JLabel lbl_department = new JLabel("Department:");
		lbl_department.setBounds(21, 184, 90, 14);
		add(lbl_department);

		JLabel lbl_department_val = new JLabel(department);
		lbl_department_val.setBounds(113, 184, 130, 14);
		add(lbl_department_val);

		JButton btn_settings = new JButton("Settings");
		btn_settings.setBounds(10, 232, 89, 23);
		add(btn_settings);

		JButton btn_change_password = new JButton("Change Password");
		btn_change_password.setBounds(130, 232, 140, 23);
		add(btn_change_password);

		JButton btn_edit_avail = new JButton("Edit Availability");
		btn_edit_avail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DoctorUnavailability login = new DoctorUnavailability(frame, doctorID);
					frame.setContentPane(login);
					frame.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_edit_avail.setBounds(297, 232, 136, 23);
		add(btn_edit_avail);

		JButton btn_logout = new JButton("Logout");
		btn_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);

			}
		});
		btn_logout.setBounds(140, 266, 119, 23);
		add(btn_logout);

		JLabel lblNewLabel = new JLabel("Unavailability");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(303, 57, 97, 16);
		add(lblNewLabel);

		JLabel lbl_info = new JLabel("Personal Info");
		lbl_info.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_info.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_info.setBounds(39, 57, 97, 16);
		add(lbl_info);

		lbl_date1_val.setBounds(277, 84, 80, 14);
		add(lbl_date1_val);

		lbl_time1_val.setBounds(372, 84, 61, 14);
		add(lbl_time1_val);

		lbl_date2_val.setBounds(277, 109, 80, 14);
		add(lbl_date2_val);

		lbl_time2_val.setBounds(372, 109, 61, 14);
		add(lbl_time2_val);

		lbl_date3_val.setBounds(277, 134, 80, 14);
		add(lbl_date3_val);

		lbl_time3_val.setBounds(372, 134, 61, 14);
		add(lbl_time3_val);

		lbl_date4_val.setBounds(277, 159, 80, 14);
		add(lbl_date4_val);

		lbl_time4_val.setBounds(372, 159, 61, 14);
		add(lbl_time4_val);

		lbl_date5_val.setBounds(277, 184, 80, 14);
		add(lbl_date5_val);

		lbl_time5_val.setBounds(372, 184, 61, 14);
		add(lbl_time5_val);

	} // end DoctorDashboard constructor

	/**
	 * Method updates all of the text fields to appropriately display the information contained within the doctor record
	 * that corresponds to the doctorID in the DoctorDB.
	 * 
	 * @param doctorID of type String - used to identify the doctor record in the DoctorDB
	 * @throws Exception
	 */
	private void refresh(String doctorID) throws Exception {

		DoctorUnavailabilityDB doctorUnavailabilityDB = new DoctorUnavailabilityDB();
		doctorUnavailabilityDB = doctorUnavailabilityDB.loadDoctorUnavailabilityDB(); // load saved database file

		// pull the availability records that have the matching doctorID
		CustomArray doctor_avail = doctorUnavailabilityDB.search(doctorID, 0);

		int case_num = doctor_avail.size();

		// cases correspond to the number of requested date/times off. Currently the system permits a max of 5 days off.
		switch (case_num) {

		case 0:
			lbl_date1_val.setVisible(false);
			lbl_time1_val.setVisible(false);
			lbl_time2_val.setVisible(false);
			lbl_date2_val.setVisible(false);
			lbl_time3_val.setVisible(false);
			lbl_date3_val.setVisible(false);
			lbl_time4_val.setVisible(false);
			lbl_date4_val.setVisible(false);
			lbl_time5_val.setVisible(false);
			lbl_date5_val.setVisible(false);
			break;
		case 1:
			lbl_date1_val.setText(doctor_avail.get(0).getCustomElement()[1]);
			lbl_date1_val.setVisible(true);
			lbl_time1_val.setText(doctor_avail.get(0).getCustomElement()[2]);
			lbl_time1_val.setVisible(true);
			lbl_time2_val.setVisible(false);
			lbl_date2_val.setVisible(false);
			lbl_time3_val.setVisible(false);
			lbl_date3_val.setVisible(false);
			lbl_time4_val.setVisible(false);
			lbl_date4_val.setVisible(false);
			lbl_time5_val.setVisible(false);
			lbl_date5_val.setVisible(false);
			break;
		case 2:
			lbl_date1_val.setText(doctor_avail.get(0).getCustomElement()[1]);
			lbl_date1_val.setVisible(true);
			lbl_time1_val.setText(doctor_avail.get(0).getCustomElement()[2]);
			lbl_time1_val.setVisible(true);
			lbl_date2_val.setText(doctor_avail.get(1).getCustomElement()[1]);
			lbl_date2_val.setVisible(true);
			lbl_time2_val.setText(doctor_avail.get(1).getCustomElement()[2]);
			lbl_time2_val.setVisible(true);
			lbl_time3_val.setVisible(false);
			lbl_date3_val.setVisible(false);
			lbl_time4_val.setVisible(false);
			lbl_date4_val.setVisible(false);
			lbl_time5_val.setVisible(false);
			lbl_date5_val.setVisible(false);
			break;
		case 3:
			lbl_date1_val.setText(doctor_avail.get(0).getCustomElement()[1]);
			lbl_date1_val.setVisible(true);
			lbl_time1_val.setText(doctor_avail.get(0).getCustomElement()[2]);
			lbl_time1_val.setVisible(true);
			lbl_date2_val.setText(doctor_avail.get(1).getCustomElement()[1]);
			lbl_date2_val.setVisible(true);
			lbl_time2_val.setText(doctor_avail.get(1).getCustomElement()[2]);
			lbl_time2_val.setVisible(true);
			lbl_date3_val.setText(doctor_avail.get(2).getCustomElement()[1]);
			lbl_date3_val.setVisible(true);
			lbl_time3_val.setText(doctor_avail.get(2).getCustomElement()[2]);
			lbl_time3_val.setVisible(true);
			lbl_time4_val.setVisible(false);
			lbl_date4_val.setVisible(false);
			lbl_time5_val.setVisible(false);
			lbl_date5_val.setVisible(false);
			break;
		case 4:
			lbl_date1_val.setText(doctor_avail.get(0).getCustomElement()[1]);
			lbl_date1_val.setVisible(true);
			lbl_time1_val.setText(doctor_avail.get(0).getCustomElement()[2]);
			lbl_time1_val.setVisible(true);
			lbl_date2_val.setText(doctor_avail.get(1).getCustomElement()[1]);
			lbl_date2_val.setVisible(true);
			lbl_time2_val.setText(doctor_avail.get(1).getCustomElement()[2]);
			lbl_time2_val.setVisible(true);
			lbl_date3_val.setText(doctor_avail.get(2).getCustomElement()[1]);
			lbl_date3_val.setVisible(true);
			lbl_time3_val.setText(doctor_avail.get(2).getCustomElement()[2]);
			lbl_time3_val.setVisible(true);
			lbl_date4_val.setText(doctor_avail.get(3).getCustomElement()[1]);
			lbl_date4_val.setVisible(true);
			lbl_time4_val.setText(doctor_avail.get(3).getCustomElement()[2]);
			lbl_time4_val.setVisible(true);
			lbl_time5_val.setVisible(false);
			lbl_date5_val.setVisible(false);
			break;
		case 5:
			lbl_date1_val.setText(doctor_avail.get(0).getCustomElement()[1]);
			lbl_date1_val.setVisible(true);
			lbl_time1_val.setText(doctor_avail.get(0).getCustomElement()[2]);
			lbl_time1_val.setVisible(true);
			lbl_date2_val.setText(doctor_avail.get(1).getCustomElement()[1]);
			lbl_date2_val.setVisible(true);
			lbl_time2_val.setText(doctor_avail.get(1).getCustomElement()[2]);
			lbl_time2_val.setVisible(true);
			lbl_date3_val.setText(doctor_avail.get(2).getCustomElement()[1]);
			lbl_date3_val.setVisible(true);
			lbl_time3_val.setText(doctor_avail.get(2).getCustomElement()[2]);
			lbl_time3_val.setVisible(true);
			lbl_date4_val.setText(doctor_avail.get(3).getCustomElement()[1]);
			lbl_date4_val.setVisible(true);
			lbl_time4_val.setText(doctor_avail.get(3).getCustomElement()[2]);
			lbl_time4_val.setVisible(true);
			lbl_date5_val.setText(doctor_avail.get(4).getCustomElement()[1]);
			lbl_date5_val.setVisible(true);
			lbl_time5_val.setText(doctor_avail.get(4).getCustomElement()[2]);
			lbl_time5_val.setVisible(true);
			break;

		} // end switch

	} // end refresh()

} // end class DoctorDashboard
