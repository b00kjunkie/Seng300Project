package iteration_2;

/**
 * The NurseDashboard.java class provides a frame for the nurse dash board. Nurses are redirected to this frame
 * after they have successfully logged in through the Staff_Login class.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-16
 */

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class NurseDashboard extends JPanel {

	private static final long serialVersionUID = 14L; // serial ID for java object saving

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public NurseDashboard(final JFrame frame, final String nurseID) throws Exception {

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

		JLabel lbl_nurse_header = new JLabel("Nurse Dashboard");
		lbl_nurse_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nurse_header.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_nurse_header.setBounds(152, 11, 162, 22);
		add(lbl_nurse_header);

		JLabel lbl_id = new JLabel("ID:");
		lbl_id.setBounds(20, 89, 80, 14);
		add(lbl_id);

		JLabel lbl_id_val = new JLabel(id);
		lbl_id_val.setBounds(110, 89, 75, 14);
		add(lbl_id_val);

		JLabel lbl_username = new JLabel("Username:");
		lbl_username.setBounds(20, 114, 80, 14);
		add(lbl_username);

		JLabel lbl_username_val = new JLabel(username);
		lbl_username_val.setBounds(110, 114, 75, 14);
		add(lbl_username_val);

		JLabel lbl_name = new JLabel("Name:");
		lbl_name.setBounds(20, 139, 80, 14);
		add(lbl_name);

		JLabel lbl_name_val = new JLabel(name);
		lbl_name_val.setBounds(110, 139, 100, 14);
		add(lbl_name_val);

		JLabel lbl_gender = new JLabel("Gender:");
		lbl_gender.setBounds(20, 164, 80, 14);
		add(lbl_gender);

		JLabel lbl_id_val_1_1_1 = new JLabel(gender);
		lbl_id_val_1_1_1.setBounds(110, 164, 75, 14);
		add(lbl_id_val_1_1_1);

		JLabel lbl_department = new JLabel("Department:");
		lbl_department.setBounds(20, 189, 80, 14);
		add(lbl_department);

		JLabel lbl_department_val = new JLabel(department);
		lbl_department_val.setBounds(110, 189, 75, 14);
		add(lbl_department_val);

		JButton btn_change_password = new JButton("Change Password");
		btn_change_password.setBounds(152, 228, 139, 23);
		add(btn_change_password);

		JButton btn_logout = new JButton("Logout");
		btn_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btn_logout.setBounds(179, 266, 89, 23);
		add(btn_logout);

		JButton btn_settings = new JButton("Settings");
		btn_settings.setBounds(10, 228, 89, 23);
		add(btn_settings);

		JLabel lblNewLabel = new JLabel("Personal Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(43, 56, 100, 22);
		add(lblNewLabel);

		JButton btnNewButton = new JButton("Check Availability");
		btnNewButton.addMouseListener(new MouseAdapter() {
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
		btnNewButton.setBounds(325, 228, 140, 23);
		add(btnNewButton);

	} // end NurseDashboard constructor

} // end class NurseDashboard
