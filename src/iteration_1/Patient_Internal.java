package iteration_1;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class Patient_Internal extends JPanel {
	
	Patient_Account account;

	/**
	 * Create the panel.
	 */
	public Patient_Internal(Patient_Account account) {
		
		this.account = account;
		
		JLabel lblGreet = new JLabel("Welcome ! " + account.getPatientName());
		add(lblGreet);
		
		
		
		
		

	}

}
