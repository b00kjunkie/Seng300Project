package iteration_1;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Patient_Calendar extends JPanel {
	
	
	
	Patient_Account current_patient;
	JFrame frame;

	/**
	 * Create the panel.
	 */
	public Patient_Calendar(Patient_Account patient,JFrame frame) {
		
		this.current_patient = patient;
		this.frame = frame;
		setLayout(null);
		
		JLabel lblWelcomePatient = new JLabel("Welcome " + this.current_patient.getPatientName());
		lblWelcomePatient.setBounds(48, 11, 49, 14);
		add(lblWelcomePatient);
		
		
		

	}

}
