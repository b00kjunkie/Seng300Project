package iteration_3;

/**
 * The CancelAppointment.java class allows patients and doctors to cancel scheduled appointments. Doctors can cancel
 * appointments at any time. Patients can only cancel appointments which occur the next day or later.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-04-04
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

public class CancelAppointment extends JPanel {

	private static final long serialVersionUID = 4L; // serial ID for java object saving
	private String department; // variable to represent the deparment which is selected from a dropdown list

	/**
	 * Creates the window which allows patients and doctors to view all scheduled appointments, and cancel them
	 * 
	 * @param frame     of type JFrame representing the program window
	 * @param id        of type String representing the id number of the user who opened the window
	 * @param user_type of type String representing either a doctor or a patient who opened the window
	 * @throws Exception
	 */
	protected CancelAppointment(final JFrame frame, final String id, final String user_type) throws Exception {

		// set window properties
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		// header for appointment scheduling window
		JLabel lbl_window_header = new JLabel("Appointment Booking System");
		lbl_window_header.setForeground(new Color(0, 102, 204));
		lbl_window_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_window_header.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_window_header.setBounds(303, 36, 347, 44);
		add(lbl_window_header);

		// ALberta Health Services logo
		JLabel lblAHSimg = new JLabel("");
		lblAHSimg.setIcon(new ImageIcon(NurseAppointment.class.getResource("/iteration_3/ahs.png")));
		lblAHSimg.setBounds(41, 11, 190, 97);
		add(lblAHSimg);

		// label for patient id column of appointment text area
		JLabel lbl_patient_id_column = new JLabel("Patient ID");
		lbl_patient_id_column.setForeground(new Color(0, 102, 204));
		lbl_patient_id_column.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_patient_id_column.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_patient_id_column.setBounds(169, 120, 79, 23);
		add(lbl_patient_id_column);

		// label for doctor id column of appointment text area
		JLabel lbl_doctor_id_column = new JLabel("Doctor ID");
		lbl_doctor_id_column.setForeground(new Color(0, 102, 204));
		lbl_doctor_id_column.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_doctor_id_column.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_doctor_id_column.setBounds(253, 120, 79, 23);
		add(lbl_doctor_id_column);

		// label for department column of appointment text area
		JLabel lbl_department_column = new JLabel("Department");
		lbl_department_column.setForeground(new Color(0, 102, 204));
		lbl_department_column.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_department_column.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_department_column.setBounds(344, 120, 99, 23);
		add(lbl_department_column);

		// label for date column of appointment text area
		JLabel lbl_date_column = new JLabel("Date");
		lbl_date_column.setForeground(new Color(0, 102, 204));
		lbl_date_column.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_date_column.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_date_column.setBounds(447, 120, 47, 23);
		add(lbl_date_column);

		// label for start time column of appointment text area
		JLabel lbl_start_time_column = new JLabel("Start");
		lbl_start_time_column.setForeground(new Color(0, 102, 204));
		lbl_start_time_column.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_start_time_column.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_start_time_column.setBounds(520, 120, 47, 23);
		add(lbl_start_time_column);

		// label for end time column of appointment text area
		JLabel lbl_end_time_column = new JLabel("End");
		lbl_end_time_column.setForeground(new Color(0, 102, 204));
		lbl_end_time_column.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_end_time_column.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_end_time_column.setBounds(571, 120, 37, 23);
		add(lbl_end_time_column);

		// label for status column of appointment text area
		JLabel lbl_status_column = new JLabel("Status");
		lbl_status_column.setForeground(new Color(0, 102, 204));
		lbl_status_column.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_status_column.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_status_column.setBounds(618, 120, 68, 23);
		add(lbl_status_column);

		// scroll pane to dynamically display requested appointments
		JScrollPane scrollPane_appoints = new JScrollPane();
		scrollPane_appoints.setBounds(169, 154, 612, 134);
		add(scrollPane_appoints);

		// text area to display all requested appointments
		final JTextArea textArea_appointments = new JTextArea();
		scrollPane_appoints.setViewportView(textArea_appointments);

		setAppointmentTextArea(textArea_appointments, id, user_type); // initialize appointment text area

		// label for selected patient id
		JLabel lbl_patient_id = new JLabel("Patient ID");
		lbl_patient_id.setForeground(new Color(0, 102, 204));
		lbl_patient_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_patient_id.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_patient_id.setBounds(63, 335, 111, 23);
		add(lbl_patient_id);

		// label for selected doctor id
		JLabel lbl_doctor_id = new JLabel("Doctor ID");
		lbl_doctor_id.setForeground(new Color(0, 102, 204));
		lbl_doctor_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_doctor_id.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_doctor_id.setBounds(198, 335, 111, 23);
		add(lbl_doctor_id);

		// label for selected department
		JLabel lbl_department = new JLabel("Department");
		lbl_department.setForeground(new Color(0, 102, 204));
		lbl_department.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_department.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_department.setBounds(342, 335, 168, 23);
		add(lbl_department);

		// label for selected date
		JLabel lbl_date = new JLabel("Date");
		lbl_date.setForeground(new Color(0, 102, 204));
		lbl_date.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_date.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_date.setBounds(551, 335, 111, 23);
		add(lbl_date);

		// label for selected start time
		JLabel lbl_start_time = new JLabel("Start");
		lbl_start_time.setForeground(new Color(0, 102, 204));
		lbl_start_time.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_start_time.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_start_time.setBounds(689, 335, 79, 23);
		add(lbl_start_time);

		// label for selected end time
		JLabel lbl_end_time = new JLabel("End");
		lbl_end_time.setForeground(new Color(0, 102, 204));
		lbl_end_time.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_end_time.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_end_time.setBounds(797, 335, 79, 23);
		add(lbl_end_time);

		// text field to enter patient id
		final JTextField textField_patient_id = new JTextField();
		textField_patient_id.setBounds(63, 369, 111, 20);
		add(textField_patient_id);
		textField_patient_id.setColumns(10);

		// text field to enter doctor id
		final JTextField textField_doctor_id = new JTextField();
		textField_doctor_id.setColumns(10);
		textField_doctor_id.setBounds(198, 369, 111, 20);
		add(textField_doctor_id);

		// dropdown list to select department
		JComboBox<String> comboBox_depart = new JComboBox<>();
		comboBox_depart.setBounds(342, 369, 168, 20);
		add(comboBox_depart);

		// add items to the department dropdown list
		comboBox_depart.addItem("");
		comboBox_depart.addItem("Emergency ");
		comboBox_depart.addItem("Cardiology");
		comboBox_depart.addItem("ICU       ");
		comboBox_depart.addItem("Neurology ");
		add(comboBox_depart);

		// listener for department dropdown list
		comboBox_depart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				department = (String) cb.getSelectedItem();
			}
		});

		// text field to enter date
		final JTextField textField_date = new JTextField();
		textField_date.setColumns(10);
		textField_date.setBounds(551, 369, 111, 20);
		add(textField_date);

		// spinner to select start time
		final JSpinner spinner_start_time = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor dateEditor1 = new JSpinner.DateEditor(spinner_start_time, "HH:mm");
		spinner_start_time.setEditor(dateEditor1);
		spinner_start_time.setBounds(689, 369, 79, 20);
		add(spinner_start_time);

		// spinner to select end time
		final JSpinner spinner_end_time = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor dateEditor2 = new JSpinner.DateEditor(spinner_end_time, "HH:mm");
		spinner_end_time.setEditor(dateEditor2);
		spinner_end_time.setBounds(797, 369, 79, 20);
		add(spinner_end_time);

		// Message to indicate that patients cannot cancel the appointment on the day (or after) of the appointment
		final JLabel lbl_error = new JLabel("Appointments cannot be cancelled on the day of the appointment or later");
		lbl_error.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_error.setForeground(Color.RED);
		lbl_error.setFont(new Font("Cambria Math", Font.BOLD, 14));
		lbl_error.setVisible(false);
		lbl_error.setBounds(211, 487, 536, 23);
		add(lbl_error);

		// button allows user to cancel appointment with data fields equal to select feilds
		JButton btn_cancel_appoint = new JButton("Cancel Appointment");
		btn_cancel_appoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_error.setVisible(false);
				String patient_id = textField_patient_id.getText();
				String doctor_id = textField_doctor_id.getText();
				// depart
				String date = textField_date.getText();
				String start = DoctorUnavailability.extractHourAndMinute(spinner_start_time);
				String end = DoctorUnavailability.extractHourAndMinute(spinner_end_time);

				String[] year_month_date = date.split("-");

				if (year_month_date.length == 3) {

					Calendar cal = new Calendar();

					// is the user is a patient, then check to see if the appointment they have selected to cancel
					// is tomorrow or later. doctors can cancel any appointments, without restriction
					if ((user_type.equalsIgnoreCase("Patient") && Integer.parseInt(year_month_date[0]) >= cal.get_year()
							&& Integer.parseInt(year_month_date[1]) >= cal.get_month()
							&& Integer.parseInt(year_month_date[2]) > cal.get_day())
							|| user_type.equalsIgnoreCase("Doctor")) {

						try {
							AppointmentDB appointmentDB = new AppointmentDB();
							appointmentDB = appointmentDB.loadAppointmentDB(); // load saved database file

							for (int i = 0; i < appointmentDB.size(); i++) {

								if (appointmentDB.get(i).getCustomElement()[0].equalsIgnoreCase(patient_id)
										&& appointmentDB.get(i).getCustomElement()[1].equalsIgnoreCase(doctor_id)
										&& appointmentDB.get(i).getCustomElement()[2].equalsIgnoreCase(department)
										&& appointmentDB.get(i).getCustomElement()[3].equalsIgnoreCase(date)
										&& appointmentDB.get(i).getCustomElement()[4].equalsIgnoreCase(start)
										&& appointmentDB.get(i).getCustomElement()[5].equalsIgnoreCase(end)) {
									appointmentDB.get(i).getCustomElement()[6] = "Cancelled";
								}
							}
							appointmentDB.saveAppointmentDB();

							// // update appointment text area to reflect changes
							setAppointmentTextArea(textArea_appointments, id, user_type);

						} catch (Exception e1) {
							e1.printStackTrace();
						}

					} else {
						// display error message is the appointment requested to be cancelled is either today,
						// or already has occurred
						lbl_error.setVisible(true);
					}
				}
			}
		});
		btn_cancel_appoint.setBounds(389, 441, 180, 23);
		add(btn_cancel_appoint);

		// allow user to return to the dash board without saving changes
		JButton btn_return = new JButton("Back");
		btn_return.setForeground(new Color(0, 102, 204));
		btn_return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// return to patient or doctor dashboard, depending on the user type that open the window
				try {
					if (user_type.equalsIgnoreCase("Patient")) {
						frame.setContentPane(new PatientDashboard(frame, id));
					} else {
						frame.setContentPane(new DoctorDashboard(frame, id));
					}

					frame.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_return.setBounds(814, 528, 160, 23);
		add(btn_return);

	} // end CancelAppointment constructor

	/**
	 * Method sets the text area with all the appointments requested by both doctors and patients. Text area will show
	 * any appointments that have yet to be scheduled (booked)
	 * 
	 * @param textArea_appointments of type JTextArea representing the area where the appointment requests are shown
	 * @throws Exception
	 */
	protected static void setAppointmentTextArea(JTextArea textArea_appointments, String id_no, String userType)
			throws Exception {

		AppointmentDB appointmentDB = new AppointmentDB();
		appointmentDB = appointmentDB.loadAppointmentDB(); // load saved database file

		String req_appointments = ""; // initialize string used to hold all requested appointments

		if (userType.equalsIgnoreCase("Patient")) {
			for (int i = 0; i < appointmentDB.size(); i++) {
				if (appointmentDB.get(i).getCustomElement()[0].equalsIgnoreCase(id_no)
						&& (appointmentDB.get(i).getCustomElement()[6].equalsIgnoreCase("Booked")
								|| appointmentDB.get(i).getCustomElement()[6].equalsIgnoreCase("Cancelled"))) {
					// pull the details from the requested appointment
					String patient_id = appointmentDB.get(i).getCustomElement()[0];
					String doctor_id = appointmentDB.get(i).getCustomElement()[1];
					String department = appointmentDB.get(i).getCustomElement()[2];
					String date = appointmentDB.get(i).getCustomElement()[3];
					String start = appointmentDB.get(i).getCustomElement()[4];
					String end = appointmentDB.get(i).getCustomElement()[5];
					String status = appointmentDB.get(i).getCustomElement()[6];
					// add all the appointment details to the string that is shown in appointment text area
					req_appointments += patient_id + "\t" + doctor_id + "\t" + department + "\t    " + date + "\t"
							+ start + "     " + end + "       " + status + "\n";
				}
			}
		} else {
			for (int i = 0; i < appointmentDB.size(); i++) {
				if (appointmentDB.get(i).getCustomElement()[1].equalsIgnoreCase(id_no)
						&& (appointmentDB.get(i).getCustomElement()[6].equalsIgnoreCase("Booked")
								|| appointmentDB.get(i).getCustomElement()[6].equalsIgnoreCase("Cancelled"))) {
					// pull the details from the requested appointment
					String patient_id = appointmentDB.get(i).getCustomElement()[0];
					String doctor_id = appointmentDB.get(i).getCustomElement()[1];
					String department = appointmentDB.get(i).getCustomElement()[2];
					String date = appointmentDB.get(i).getCustomElement()[3];
					String start = appointmentDB.get(i).getCustomElement()[4];
					String end = appointmentDB.get(i).getCustomElement()[5];
					String status = appointmentDB.get(i).getCustomElement()[6];
					// add all the appointment details to the string that is shown in appointment text area
					req_appointments += patient_id + "\t" + doctor_id + "\t" + department + "\t    " + date + "\t"
							+ start + "     " + end + "       " + status + "\n";
				}
			}
		}

		// set the text area with the complied string containing all requested appointments
		textArea_appointments.setText(req_appointments);

	} // end setAppointmentTextArea()

} // end class CancelAppointment
