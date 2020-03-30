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

public class MainFrame {

	private JFrame frame;

	/**
	 * Main method launches the SENG300 system.
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

	public JFrame getFrame() {

		return this.frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// initialize the window frame
		frame = new JFrame("Alberta Hospital Scheduling System");
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(200, 200, 1000, 600);
		frame.setResizable(false); // remove ability to resize the window
		frame.getContentPane().setLayout(null);

		// header for the window
		JLabel lblNewLabel = new JLabel("Welcome to Alberta Hospital System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lblNewLabel.setBounds(274, 134, 419, 42);
		frame.getContentPane().add(lblNewLabel);

		// label indicating user action to be performed
		JLabel lblNewLabel_1 = new JLabel("Please Select Below");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblNewLabel_1.setBounds(389, 237, 183, 23);
		frame.getContentPane().add(lblNewLabel_1);

		// button allows the user to log on as a staff member
		JButton btnNewButton = new JButton("Staff");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StaffLogin login = new StaffLogin(frame);
				frame.setContentPane(login);
				frame.revalidate();
			}
		});
		btnNewButton.setBounds(399, 293, 162, 23);
		frame.getContentPane().add(btnNewButton);

		// button allows the user to log on or register as a patient
		JButton btnNewButton_1 = new JButton("Patient");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientLogin login = new PatientLogin(frame);
				frame.setContentPane(login);
				frame.revalidate();
			}
		});

		btnNewButton_1.setBounds(399, 327, 162, 23);
		frame.getContentPane().add(btnNewButton_1);

	} // end initialize()

} // end class Patient_Main_Login
