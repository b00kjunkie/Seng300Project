package iteration_2;

/**
 * Hospital management system for the Alberta government. The MainFrame.java class contains the main method for this 
 * SENG300Project. The class represents the initial screen that users will see when accessing the system. The user will 
 * choose to proceed as either Staff (doctors and nurses) or as a patient.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-03
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		frame = new JFrame();
		frame.setBounds(200, 200, 572, 340);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome to Alberta Hospital System");
		lblNewLabel.setFont(new Font("Broadway", Font.ITALIC, 12));
		lblNewLabel.setBounds(75, 27, 266, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Please select below :");
		lblNewLabel_1.setBounds(163, 99, 123, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Staff");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StaffLogin login = new StaffLogin(frame);
				frame.setContentPane(login);
				frame.revalidate();
			}
		});

		btnNewButton.setBounds(136, 148, 162, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Patient");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientLogin login = new PatientLogin(frame);
				frame.setContentPane(login);
				frame.revalidate();
			}
		});

		btnNewButton_1.setBounds(136, 182, 162, 23);
		frame.getContentPane().add(btnNewButton_1);

	} // end initialize()

} // end class Patient_Main_Login
