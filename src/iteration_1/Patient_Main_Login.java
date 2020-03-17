package iteration_1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Patient_Main_Login {

	private JFrame frame;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Patient_Main_Login window = new Patient_Main_Login();
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
	public Patient_Main_Login() {

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

		JButton btnNewButton = new JButton("Doctor/Nurse");
		btnNewButton.setBounds(136, 148, 162, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Patients");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Patient_Login login = new Patient_Login(frame);
				frame.setContentPane(login);
				frame.revalidate();
			}
		});
		
		btnNewButton_1.setBounds(136, 182, 162, 23);
		frame.getContentPane().add(btnNewButton_1);

	} // end initialize()

} // end class Patient_Main_Login
