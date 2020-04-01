package iteration_3;

/**
 * The NurseDashboard.java class provides a frame for the nurse dash board. Nurses are redirected to this frame
 * after they have successfully logged in through the Staff_Login class.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-16
 */

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class NurseDashboard extends JPanel {

	private static final long serialVersionUID = 14L; // serial ID for java object saving

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public NurseDashboard(final JFrame frame, final String nurseID) throws Exception {

		// set window properties
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		NurseDB nurseDB = new NurseDB();
		nurseDB = nurseDB.loadNurseDB(); // load saved database file

		String[] nurseRecord = nurseDB.getNurseRecord(nurseID); // pull nurse record from database

		// assign the elements of nurse record to meaningful variable names
		String id = nurseRecord[0];
		String username = nurseRecord[1];
		String name = nurseRecord[3];
		String gender = nurseRecord[4];
		String department = nurseRecord[5];

		// window header
		JLabel lbl_nurse_header = new JLabel("Nurse Dashboard");
		lbl_nurse_header.setForeground(new Color(0, 102, 204));
		lbl_nurse_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nurse_header.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_nurse_header.setBounds(355, 73, 219, 22);
		add(lbl_nurse_header);

		// nurse id label
		JLabel lbl_id = new JLabel("ID:");
		lbl_id.setForeground(new Color(0, 102, 204));
		lbl_id.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_id.setBounds(192, 201, 80, 14);
		add(lbl_id);

		// nurse id value
		JLabel lbl_id_val = new JLabel(id);
		lbl_id_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_id_val.setBounds(318, 201, 112, 14);
		add(lbl_id_val);

		// nurse username label
		JLabel lbl_username = new JLabel("Username:");
		lbl_username.setForeground(new Color(0, 102, 204));
		lbl_username.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_username.setBounds(192, 236, 80, 14);
		add(lbl_username);

		// nurse username value
		JLabel lbl_username_val = new JLabel(username);
		lbl_username_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_username_val.setBounds(318, 236, 112, 14);
		add(lbl_username_val);

		// nurse name label
		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setForeground(new Color(0, 102, 204));
		lbl_name.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_name.setBounds(192, 274, 80, 14);
		add(lbl_name);

		// nurse name value
		JLabel lbl_name_val = new JLabel(name);
		lbl_name_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_name_val.setBounds(318, 274, 112, 14);
		add(lbl_name_val);

		// nurse gender label
		JLabel lbl_gender = new JLabel("Gender:");
		lbl_gender.setForeground(new Color(0, 102, 204));
		lbl_gender.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_gender.setBounds(192, 311, 80, 14);
		add(lbl_gender);

		// nurse gender value
		JLabel lbl_id_val_1_1_1 = new JLabel(gender);
		lbl_id_val_1_1_1.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_id_val_1_1_1.setBounds(318, 311, 112, 14);
		add(lbl_id_val_1_1_1);

		// nurse department label
		JLabel lbl_department = new JLabel("Department:");
		lbl_department.setForeground(new Color(0, 102, 204));
		lbl_department.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_department.setBounds(192, 346, 104, 14);
		add(lbl_department);

		// nurse department value
		JLabel lbl_department_val = new JLabel(department);
		lbl_department_val.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_department_val.setBounds(318, 346, 112, 14);
		add(lbl_department_val);

		// button allows the nurse to exit the program
		JButton btn_logout = new JButton("Logout");
		btn_logout.setForeground(new Color(0, 102, 204));
		btn_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btn_logout.setBounds(885, 528, 89, 23);
		add(btn_logout);

		// personal information section header
		JLabel lblNewLabel = new JLabel("Personal Info");
		lblNewLabel.setForeground(new Color(0, 102, 204));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lblNewLabel.setBounds(69, 140, 142, 22);
		add(lblNewLabel);

		// button allows the nurse to check doctor availability
		JButton btn_availabililty = new JButton("Check Availability");
		btn_availabililty.setForeground(new Color(0, 102, 204));
		btn_availabililty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DoctorUnavailabilityView availView = new DoctorUnavailabilityView(frame, nurseID, "nurse");
					frame.setContentPane(availView);
					frame.revalidate();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_availabililty.setBounds(306, 441, 140, 23);
		add(btn_availabililty);

		// button allows the nurse to view all appointments requested by both doctors and patients
		JButton btn_appointments = new JButton("Appointments Requested");
		btn_appointments.setForeground(new Color(0, 102, 204));
		btn_appointments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					frame.setContentPane(new NurseAppointment(frame, nurseID));
					frame.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_appointments.setBounds(497, 441, 180, 23);
		add(btn_appointments);
		
		JLabel lblAHSimg = new JLabel("");
		lblAHSimg.setIcon(new ImageIcon(NurseDashboard.class.getResource("/iteration_3/ahs.png")));
		lblAHSimg.setBounds(10, 11, 208, 102);
		add(lblAHSimg);

	} // end NurseDashboard constructor

} // end class NurseDashboard
