package iteration_3;

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

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class DoctorDashboard extends JPanel {

	private static final long serialVersionUID = 10L; // serial ID for java object saving

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public DoctorDashboard(final JFrame frame, final String doctorID) throws Exception {

		// set window properties
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);

		DoctorDB doctorDB = new DoctorDB();
		doctorDB = doctorDB.loadDoctorDB(); // load saved database file

		String[] doctorRecord = doctorDB.getDoctorRecord(doctorID); // pull doctor record from database

		// assign the elements of doctor record to meaningful variable names
		String id = doctorRecord[0];
		String username = doctorRecord[1];
		String name = doctorRecord[3];
		String gender = doctorRecord[4];
		String department = doctorRecord[5];

		// header for window
		JLabel lbl_doctor_header = new JLabel("Doctor Dashboard");
		lbl_doctor_header.setForeground(new Color(0, 102, 204));
		lbl_doctor_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_doctor_header.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_doctor_header.setBounds(372, 69, 220, 35);
		add(lbl_doctor_header);

		// personal information section header
		JLabel lbl_info = new JLabel("Personal Info");
		lbl_info.setForeground(new Color(0, 102, 204));
		lbl_info.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_info.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lbl_info.setBounds(123, 141, 140, 16);
		add(lbl_info);

		// doctor id label
		JLabel lbl_id = new JLabel("ID:");
		lbl_id.setForeground(new Color(0, 102, 204));
		lbl_id.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_id.setBounds(191, 190, 69, 16);
		add(lbl_id);

		// doctor id value
		JLabel lbl_id_val = new JLabel(id);
		lbl_id_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_id_val.setBounds(323, 190, 130, 16);
		add(lbl_id_val);

		// doctor username label
		JLabel lbl_username = new JLabel("Username:");
		lbl_username.setForeground(new Color(0, 102, 204));
		lbl_username.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_username.setBounds(191, 225, 90, 16);
		add(lbl_username);

		// doctor username value
		JLabel lbl_username_val = new JLabel(username);
		lbl_username_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_username_val.setBounds(323, 225, 130, 16);
		add(lbl_username_val);

		// doctor name label
		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setForeground(new Color(0, 102, 204));
		lbl_name.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_name.setBounds(191, 267, 69, 16);
		add(lbl_name);

		// doctor name value
		JLabel lbl_name_val = new JLabel(name);
		lbl_name_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_name_val.setBounds(323, 267, 130, 16);
		add(lbl_name_val);

		// doctor gender label
		JLabel lbl_gender = new JLabel("Gender:");
		lbl_gender.setForeground(new Color(0, 102, 204));
		lbl_gender.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_gender.setBounds(191, 310, 69, 16);
		add(lbl_gender);

		// doctor gender value
		JLabel lbl_gender_val = new JLabel(gender);
		lbl_gender_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_gender_val.setBounds(323, 310, 130, 16);
		add(lbl_gender_val);

		// doctor department label
		JLabel lbl_department = new JLabel("Department:");
		lbl_department.setForeground(new Color(0, 102, 204));
		lbl_department.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_department.setBounds(191, 360, 90, 16);
		add(lbl_department);

		// doctor department value
		JLabel lbl_department_val = new JLabel(department);
		lbl_department_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_department_val.setBounds(323, 360, 130, 16);
		add(lbl_department_val);

		// settings button allows user to opend a window which displays options to edit personal information
		JButton btn_settings = new JButton("Settings");
		btn_settings.setForeground(new Color(0, 102, 204));
		btn_settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					frame.setContentPane(new DoctorSettings(frame, doctorID));
					frame.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_settings.setBounds(135, 462, 89, 23);
		add(btn_settings);

		// button allows the user to open a window that is used to edit/view appointment requests
		JButton btn_request_appoint = new JButton("Appointment Requests");
		btn_request_appoint.setForeground(new Color(0, 102, 204));
		btn_request_appoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					frame.setContentPane(new RequestAppointment(frame, doctorID, "Doctor"));
					frame.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_request_appoint.setBounds(392, 462, 180, 23);
		add(btn_request_appoint);

		// button allows the user to open a window that is used to edit/view availability
		JButton btn_edit_avail = new JButton("Edit Availability");
		btn_edit_avail.setForeground(new Color(0, 102, 204));
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
		btn_edit_avail.setBounds(598, 462, 136, 23);
		add(btn_edit_avail);

		// button allows user to exit the program
		JButton btn_logout = new JButton("Logout");
		btn_logout.setForeground(new Color(0, 102, 204));
		btn_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);

			}
		});
		btn_logout.setBounds(855, 528, 119, 23);
		add(btn_logout);

		// button allows the user to open a window which is used to display scheduling information
		JButton btn_schedule = new JButton("Schedule");
		btn_schedule.setForeground(new Color(0, 102, 204));
		btn_schedule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					frame.setContentPane(new AppointmentCalendar(frame, doctorID, "Doctor"));
					frame.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_schedule.setBounds(262, 462, 89, 23);
		add(btn_schedule);
		
		JLabel lblAHSImg = new JLabel("");
		lblAHSImg.setIcon(new ImageIcon(DoctorDashboard.class.getResource("/iteration_3/ahs.png")));
		lblAHSImg.setBounds(889, 34, 190, 97);
		add(lblAHSImg);

	} // end DoctorDashboard constructor

} // end class DoctorDashboard
