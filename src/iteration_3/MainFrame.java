package iteration_3;

/**
 * Hospital management system for the Alberta government. The MainFrame.java class contains the main method for this 
 * SENG300Project. The class represents the initial screen that users will see when accessing the system. The user will 
 * choose to proceed as either Staff (doctors and nurses) or as a patient.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-03
 */

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MainFrame extends JPanel {

	private static final long serialVersionUID = 1L; // serial ID for java object saving

	private JFrame frame;

	/**
	 * Main method launches the new Alberta hospital system.
	 * 
	 * @param args of type String[] are not required/used.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					MainFrame window = new MainFrame();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	} // end main method

	/**
	 * Create the application.
	 * 
	 * @throws Exception
	 */
	protected MainFrame() throws Exception {
		initializeDB();
		initializeWindow();
	}

	/**
	 * Method ensures that each of the database relations; PatientDB, DoctorDB, NurseDB, AppointmentDB,
	 * DoctorUnavailabilityDB, have corresponding text files initialized for storing/retrieving data. If the
	 * corresponding text file is not initialized, the load functions will create the missing file.
	 * 
	 * @throws Exception
	 */
	private static void initializeDB() throws Exception {

		// verify that that patient database file is properly initialized
		PatientDB patDB = new PatientDB();
		patDB.loadPatientDB();

		// verify that that doctor database file is properly initialized
		DoctorDB.initDoctorDB();
		DoctorDB docDB = new DoctorDB();
		docDB.loadDoctorDB();

		// verify that that nurse database file is properly initialized
		NurseDB.initNurseDB(); // initialize the nurse database file
		NurseDB nurseDB = new NurseDB();
		nurseDB = nurseDB.loadNurseDB(); // load database from file

		// verify the appointment database file is properly initialized
		AppointmentDB appointDB = new AppointmentDB();
		appointDB.loadAppointmentDB();

		// verify the doctor unavailability database file is properly initialized
		DoctorUnavailabilityDB docUnavailDB = new DoctorUnavailabilityDB();
		docUnavailDB.loadDoctorUnavailabilityDB();

	}

	/**
	 * Initialize the contents of the welcome screen window.
	 */
	private void initializeWindow() {
		// initialize the window frame
		frame = new JFrame("Alberta Hospital Scheduling System");
		frame.getContentPane();

		frame.setBounds(200, 100, 1000, 600);
		frame.setResizable(false); // remove ability to resize the window
		frame.getContentPane().setLayout(null);

		// header for the window
		JLabel lblWelcome = new JLabel("Welcome to Alberta Hospital System");
		lblWelcome.setBackground(Color.WHITE);
		lblWelcome.setForeground(new Color(0, 102, 204));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lblWelcome.setBounds(274, 134, 419, 42);
		frame.getContentPane().add(lblWelcome);

		// Alberta health services logo
		JLabel lblAHSimg = new JLabel("");
		lblAHSimg.setIcon(new ImageIcon(MainFrame.class.getResource("/iteration_3/ahs.png")));
		lblAHSimg.setBounds(41, 11, 190, 97);
		frame.getContentPane().add(lblAHSimg);

		// picture of a few patients
		JLabel lblPatient = new JLabel("");
		lblPatient.setIcon(new ImageIcon(MainFrame.class.getResource("/iteration_3/patient.png")));
		lblPatient.setBounds(274, 327, 64, 64);
		frame.getContentPane().add(lblPatient);

		// picture of two doctors
		JLabel lblDocNur = new JLabel("");
		lblDocNur.setIcon(new ImageIcon(MainFrame.class.getResource("/iteration_3/doctor.png")));
		lblDocNur.setBounds(615, 274, 49, 42);
		frame.getContentPane().add(lblDocNur);

		// label indicating user action to be performed
		JLabel lblSelect = new JLabel("Please Select Below");
		lblSelect.setForeground(new Color(0, 102, 204));
		lblSelect.setBackground(new Color(0, 102, 204));
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblSelect.setBounds(389, 237, 183, 23);
		frame.getContentPane().add(lblSelect);

		// button allows the user to log on as a staff member
		JButton btnStaff = new JButton("Staff");
		btnStaff.setForeground(new Color(0, 102, 204));
		btnStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// initial staff login interface channel
				StaffLogin login = new StaffLogin(frame);
				frame.setContentPane(login);
				frame.revalidate();
			}
		});
		btnStaff.setBounds(399, 293, 162, 23);
		frame.getContentPane().add(btnStaff);

		// button allows the user to log on or register as a patient
		JButton btnPatient = new JButton("Patient");
		btnPatient.setForeground(new Color(0, 102, 204));
		btnPatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// patient login interface
				PatientLogin login = new PatientLogin(frame);
				frame.setContentPane(login);
				frame.revalidate();
			}
		});

		btnPatient.setBounds(399, 327, 162, 23);
		frame.getContentPane().add(btnPatient);

	} // end initialize()

} // end class Patient_Main_Login
