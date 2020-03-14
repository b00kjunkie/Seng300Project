/**
 * * Group 12
 * Credits to https://github.com/colinauyeung for most of the code
 */

package iteration_2;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Nurse_Main {

	private JFrame frame;
	private Nurse_Auth auth = new Nurse_Auth();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nurse_Main window = new Nurse_Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Nurse_Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		Nurse_Login panel = new Nurse_Login(frame, auth);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.revalidate();
	}

}
