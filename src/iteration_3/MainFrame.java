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
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

/**
 * The main frame to initial the entire system. user will be give choices between staff and patient.
 * If user made mistake, he/she will have to exit and reopen the main login frame.
 * @author dongb
 *
 */
public class MainFrame {

	private JFrame frame;

	/**
	 * Main method launches the new alberta hospital system.
	 * 
	 * @param args
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
	 */
	public MainFrame() {

		initialize();
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// initialize the window frame
		frame = new JFrame("Alberta Hospital Scheduling System");
		frame.getContentPane();
		
		frame.setBounds(200, 200, 1000, 600);
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
		
		JLabel lblAHSimg = new JLabel("");
		lblAHSimg.setIcon(new ImageIcon("C:\\Users\\dongb\\Documents\\GitHub\\Seng300Project\\src\\iteration_3\\ahs.png"));
		lblAHSimg.setBounds(35, 36, 183, 65);
		frame.getContentPane().add(lblAHSimg);
		
		JLabel lblPatient = new JLabel("");
		lblPatient.setIcon(new ImageIcon("C:\\Users\\dongb\\Documents\\GitHub\\Seng300Project\\src\\iteration_3\\patient.png"));
		lblPatient.setBounds(274, 327, 64, 64);
		frame.getContentPane().add(lblPatient);
		
		JLabel lblDocNur = new JLabel("");
		lblDocNur.setIcon(new ImageIcon("C:\\Users\\dongb\\Documents\\GitHub\\Seng300Project\\src\\iteration_3\\doctor.png"));
		lblDocNur.setBounds(615, 274, 49, 42);
		frame.getContentPane().add(lblDocNur);

	} // end initialize()
} // end class Patient_Main_Login
