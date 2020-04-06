package iteration_3;

/**
 * The StaffLogin.java class provides a frame for Staff login. Both doctors and nurses are redirected to this frame
 * from the MainFrame class when attempting to login.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-16
 */

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class StaffLogin extends JPanel {

	private static final long serialVersionUID = 23L; // serial ID for java object saving
	private JTextField txt_username_doc;
	private JTextField txt_password_doc;
	private JTextField txt_password_nurse;
	private JTextField txt_username_nurse;

	/**
	 * Creates a window which allows either doctors or nurses to login to the system
	 * 
	 * @param frame of type JFrame representing the program window
	 */
	protected StaffLogin(final JFrame frame) {
		setForeground(new Color(0, 0, 0));

		// set window properties
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		// header for the window
		JLabel lbl_Staff_login_screen = new JLabel("Staff Login Screen");
		lbl_Staff_login_screen.setBackground(Color.LIGHT_GRAY);
		lbl_Staff_login_screen.setForeground(new Color(0, 102, 204));
		lbl_Staff_login_screen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Staff_login_screen.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_Staff_login_screen.setBounds(354, 77, 219, 36);
		add(lbl_Staff_login_screen);

		// Alberta health services logo
		JLabel lblAHSimg = new JLabel("");
		lblAHSimg.setIcon(new ImageIcon(StaffLogin.class.getResource("/iteration_3/ahs.png")));
		lblAHSimg.setBounds(41, 11, 190, 97);
		add(lblAHSimg);

		// doctor login header
		JLabel lbl_doctors_login_here = new JLabel("Doctor Login");
		lbl_doctors_login_here.setForeground(new Color(0, 102, 204));
		lbl_doctors_login_here.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lbl_doctors_login_here.setBounds(125, 139, 182, 23);
		add(lbl_doctors_login_here);

		// doctor username label
		JLabel lbl_username_doc = new JLabel("Username");
		lbl_username_doc.setForeground(new Color(0, 102, 204));
		lbl_username_doc.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_username_doc.setBounds(258, 192, 70, 23);
		add(lbl_username_doc);

		// doctor password label
		JLabel lbl_password_doc = new JLabel("Password");
		lbl_password_doc.setForeground(new Color(0, 102, 204));
		lbl_password_doc.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_password_doc.setBounds(458, 192, 70, 23);
		add(lbl_password_doc);

		// text field to enter to doctor username
		txt_username_doc = new JTextField();
		txt_username_doc.setBounds(258, 226, 115, 20);
		add(txt_username_doc);
		txt_username_doc.setColumns(10);

		// text field to enter the doctor password
		txt_password_doc = new JPasswordField();
		txt_password_doc.setColumns(10);
		txt_password_doc.setBounds(458, 226, 115, 20);
		add(txt_password_doc);

		// nurse login header
		JLabel lbl_nurses_login_here = new JLabel("Nurse Login");
		lbl_nurses_login_here.setForeground(new Color(0, 102, 204));
		lbl_nurses_login_here.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lbl_nurses_login_here.setBounds(125, 311, 167, 23);
		add(lbl_nurses_login_here);

		// nurse username label
		JLabel lbl_username_nurse = new JLabel("Username");
		lbl_username_nurse.setForeground(new Color(0, 102, 204));
		lbl_username_nurse.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_username_nurse.setBounds(258, 366, 70, 23);
		add(lbl_username_nurse);

		// nurse password label
		JLabel lbl_password_nurse = new JLabel("Password");
		lbl_password_nurse.setForeground(new Color(0, 102, 204));
		lbl_password_nurse.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_password_nurse.setBounds(458, 366, 70, 23);
		add(lbl_password_nurse);

		// text field to input nurse username
		txt_username_nurse = new JTextField();
		txt_username_nurse.setColumns(10);
		txt_username_nurse.setBounds(258, 400, 115, 20);
		add(txt_username_nurse);

		// text field to input nurse password
		txt_password_nurse = new JPasswordField();
		txt_password_nurse.setColumns(10);
		txt_password_nurse.setBounds(458, 400, 115, 20);
		add(txt_password_nurse);

		// button allows the user to return to main screen
		JButton btn_exit = new JButton("Back");
		btn_exit.setForeground(new Color(0, 102, 204));
		btn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame.main(new String[] {}); // restart the program by calling main method and passing empty array
				frame.dispose(); // close current screen
			}
		});
		btn_exit.setBounds(814, 528, 160, 23);
		add(btn_exit);

		// label used to indicate if the login information is incorrect
		final JLabel lbl_invalid_password = new JLabel("Invalid Information");
		lbl_invalid_password.setBackground(Color.LIGHT_GRAY);
		lbl_invalid_password.setOpaque(true);
		lbl_invalid_password.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lbl_invalid_password.setVisible(false);
		lbl_invalid_password.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_invalid_password.setForeground(Color.RED);
		lbl_invalid_password.setBounds(364, 495, 182, 23);
		add(lbl_invalid_password);

		// button allows doctor to login to the system
		JButton btn_login_doc = new JButton("Login");
		btn_login_doc.setForeground(new Color(0, 102, 204));
		btn_login_doc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String username = txt_username_doc.getText();
				String password = txt_password_doc.getText();

				try {
					DoctorDB doctorDB = new DoctorDB();
					doctorDB = doctorDB.loadDoctorDB(); // load database from file

					// if username and password don't match in the doctor database, then display error
					// else, create DoctorDashboards frame and pass parameter String array containing username+pass
					if (!doctorDB.checkForMatch(username, password)) {
						lbl_invalid_password.setVisible(true);
					} else {
						String doctorID = doctorDB.getID(username, password);
						DoctorDashboard login = new DoctorDashboard(frame, doctorID);
						frame.setContentPane(login);
						frame.revalidate();
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		}); // end MouseListener for btn_login_doc "Login"
		btn_login_doc.setBounds(661, 225, 89, 23);
		add(btn_login_doc);

		// button allows nurse to login to the system
		JButton btn_login_nurse = new JButton("Login");
		btn_login_nurse.setForeground(new Color(0, 102, 204));
		btn_login_nurse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String username = txt_username_nurse.getText();
				String password = txt_password_nurse.getText();

				try {
					NurseDB nurseDB = new NurseDB();
					nurseDB = nurseDB.loadNurseDB(); // load database from file

					// if username and password don't match in the doctor database, then display error
					// else, create NurseDashboard frame and pass parameter String array containing username+pass
					if (!nurseDB.checkForMatch(username, password)) {
						lbl_invalid_password.setVisible(true);

					} else {
						String nurseID = nurseDB.getID(username, password);
						NurseDashboard login = new NurseDashboard(frame, nurseID);
						frame.setContentPane(login);
						frame.revalidate();
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		}); // end MouseListener for btn_login_nurse "Login"
		btn_login_nurse.setBounds(661, 399, 89, 23);
		add(btn_login_nurse);

	}

} // end class StaffLogin
