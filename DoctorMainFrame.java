package iteration2;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class DoctorMainFrame {

	private JFrame frame;
	private DoctorAuth auth = new DoctorAuth();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorMainFrame window = new DoctorMainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DoctorMainFrame() {
		initialize();
	}
	
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		DoctorLogin panel = new DoctorLogin(frame, auth);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.revalidate();
	}

}
