package iteration_3;

/**
 * The NurseAppointment.java class provides a frame for nurses to view all requested appointments made by either
 * patients or doctors. Nurses can convert confirmed appointments into booked appointments, or deny appointments
 * that have been made by either doctors or patients.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-29
 */

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;

public class NurseAppointment extends JPanel {

	private static final long serialVersionUID = 16L; // serial ID for java object saving
	private String department;
	private String status = "";

	public NurseAppointment(final JFrame frame, final String nurseID) throws Exception {

		// set window properties
		setBackground(Color.GRAY);
		setLayout(null);

		// header for appointment scheduling window
		JLabel lbl_window_header = new JLabel("Appointment Booking System");
		lbl_window_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_window_header.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_window_header.setBounds(303, 36, 347, 44);
		add(lbl_window_header);

		// label for patient id column of appointment text area
		JLabel lbl_patient_id_column = new JLabel("Patient ID");
		lbl_patient_id_column.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_patient_id_column.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_patient_id_column.setBounds(169, 120, 79, 23);
		add(lbl_patient_id_column);

		// label for doctor id column of appointment text area
		JLabel lbl_doctor_id_column = new JLabel("Doctor ID");
		lbl_doctor_id_column.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_doctor_id_column.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_doctor_id_column.setBounds(253, 120, 79, 23);
		add(lbl_doctor_id_column);

		// label for department column of appointment text area
		JLabel lbl_department_column = new JLabel("Department");
		lbl_department_column.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_department_column.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_department_column.setBounds(344, 120, 99, 23);
		add(lbl_department_column);

		// label for date column of appointment text area
		JLabel lbl_date_column = new JLabel("Date");
		lbl_date_column.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_date_column.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_date_column.setBounds(447, 120, 47, 23);
		add(lbl_date_column);

		// label for start time column of appointment text area
		JLabel lbl_start_time_column = new JLabel("Start");
		lbl_start_time_column.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_start_time_column.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_start_time_column.setBounds(520, 120, 47, 23);
		add(lbl_start_time_column);

		// label for end time column of appointment text area
		JLabel lbl_end_time_column = new JLabel("End");
		lbl_end_time_column.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_end_time_column.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_end_time_column.setBounds(571, 120, 37, 23);
		add(lbl_end_time_column);

		// label for status column of appointment text area
		JLabel lbl_status_column = new JLabel("Status");
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

		setAppointmentTextArea(textArea_appointments);

		// label for selected patient id
		JLabel lbl_patient_id = new JLabel("Patient ID");
		lbl_patient_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_patient_id.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_patient_id.setBounds(63, 335, 111, 23);
		add(lbl_patient_id);

		// label for selected doctor id
		JLabel lbl_doctor_id = new JLabel("Doctor ID");
		lbl_doctor_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_doctor_id.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_doctor_id.setBounds(198, 335, 111, 23);
		add(lbl_doctor_id);

		// label for selected department
		JLabel lbl_department = new JLabel("Department");
		lbl_department.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_department.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_department.setBounds(342, 335, 168, 23);
		add(lbl_department);

		// label for selected date
		JLabel lbl_date = new JLabel("Date");
		lbl_date.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_date.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_date.setBounds(551, 335, 111, 23);
		add(lbl_date);

		// label for selected start time
		JLabel lbl_start_time = new JLabel("Start");
		lbl_start_time.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_start_time.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_start_time.setBounds(689, 335, 79, 23);
		add(lbl_start_time);

		// label for selected end time
		JLabel lbl_end_time = new JLabel("End");
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

		// label for status field
		JLabel lbl_status = new JLabel("Status");
		lbl_status.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_status.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_status.setBounds(140, 437, 111, 23);
		add(lbl_status);

		// button used to approve appointment request
		final JRadioButton rdbtn_booked = new JRadioButton("Schedule Appointment");
		rdbtn_booked.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		rdbtn_booked.setBackground(Color.GRAY);
		rdbtn_booked.setBounds(278, 439, 186, 21);
		add(rdbtn_booked);

		// button used to deny appointment request
		final JRadioButton rdbtn_denied = new JRadioButton("Deny Appointment");
		rdbtn_denied.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		rdbtn_denied.setBackground(Color.GRAY);
		rdbtn_denied.setBounds(278, 480, 186, 21);
		add(rdbtn_denied);

		// listener for button to schedule appointment
		rdbtn_booked.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtn_booked.isSelected()) {
					status = "Booked";
					rdbtn_booked.setSelected(true);
					rdbtn_denied.setSelected(false);
				} else {
					status = "Denied";
					rdbtn_booked.setSelected(false);
					rdbtn_denied.setSelected(true);
				}
			}
		});

		// listener for button to deny appointment
		rdbtn_denied.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtn_denied.isSelected()) {
					status = "Denied";
					rdbtn_booked.setSelected(false);
					rdbtn_denied.setSelected(true);
				} else {
					status = "Booked";
					rdbtn_booked.setSelected(true);
					rdbtn_denied.setSelected(false);
				}
			}
		});

		// button used to confirm that an appointment has either been scheduled or denied
		JButton btn_update_status = new JButton("Update Status");
		btn_update_status.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String patient_id = textField_patient_id.getText();
				String doctor_id = textField_doctor_id.getText();
				// got depart
				String date = textField_date.getText();
				String start = DoctorUnavailability.extractHourAndMinute(spinner_start_time);
				String end = DoctorUnavailability.extractHourAndMinute(spinner_end_time);
				// status

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
							if (appointmentDB.get(i).getCustomElement()[6].equalsIgnoreCase("Confirmed")) {
								appointmentDB.get(i).getCustomElement()[6] = status;
							}
						}
					}
					appointmentDB.saveAppointmentDB();

					setAppointmentTextArea(textArea_appointments);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_update_status.setBounds(538, 454, 139, 23);
		add(btn_update_status);

		// button that allows the nurse to return to the dashboard
		JButton btn_return = new JButton("Return");
		btn_return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					frame.setContentPane(new NurseDashboard(frame, nurseID));
					frame.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_return.setBounds(865, 528, 89, 23);
		add(btn_return);

	} // end NurseAppointment constructor

	/**
	 * Method sets the text area with all the appointments requested by both doctors and patients. Text area will show
	 * any appointments that have yet to be scheduled (booked)
	 * 
	 * @param textArea_appointments of type JTextArea representing the area where the appointment requests are shown
	 * @throws Exception
	 */
	protected static void setAppointmentTextArea(JTextArea textArea_appointments) throws Exception {

		AppointmentDB appointmentDB = new AppointmentDB();
		appointmentDB = appointmentDB.loadAppointmentDB(); // load saved database file

		String req_appointments = ""; // initialize string used to hold all requested appointments
		for (int i = 0; i < appointmentDB.size(); i++) {
			if (!appointmentDB.get(i).getCustomElement()[6].equalsIgnoreCase("Booked")) {
				// pull the details from the requested appointment
				String patient_id = appointmentDB.get(i).getCustomElement()[0];
				String doctor_id = appointmentDB.get(i).getCustomElement()[1];
				String department = appointmentDB.get(i).getCustomElement()[2];
				String date = appointmentDB.get(i).getCustomElement()[3];
				String start = appointmentDB.get(i).getCustomElement()[4];
				String end = appointmentDB.get(i).getCustomElement()[5];
				String status = appointmentDB.get(i).getCustomElement()[6];
				// add all the appointment details to the string that is shown in appointment text area
				req_appointments += patient_id + "\t" + doctor_id + "\t" + department + "\t    " + date + "\t" + start
						+ "     " + end + "       " + status + "\n";
			}
		}
		// set the text area with the complied string containing all requested appointments
		textArea_appointments.setText(req_appointments);

	}

} // end NurseAppointment class
