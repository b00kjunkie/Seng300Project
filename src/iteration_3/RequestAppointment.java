package iteration_3;

/**
 * The RequestAppointment.java class provides a frame for either the patient or the doctor to request appointment.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-29
 */

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;

public class RequestAppointment extends JPanel {

	private static final long serialVersionUID = 3L; // serial ID for java object saving
	private String depart = "";
	private String user = "";
	private String date;
	private String start;
	private String end;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public RequestAppointment(final JFrame frame, final String id, final String user_type) throws Exception {

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		// Request Appointment Window Header
		JLabel lblNewLabel = new JLabel("Request Appointment");
		lblNewLabel.setForeground(new Color(0, 102, 204));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lblNewLabel.setBounds(358, 37, 257, 29);
		add(lblNewLabel);

		// scroll pane to dynamically display all the requested appointments
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(494, 180, 449, 206);
		add(scrollPane);

		// text area to display all the requested appointments
		final JTextArea textArea_requested_appoints = new JTextArea();
		scrollPane.setViewportView(textArea_requested_appoints);
		updateRequestTextArea(textArea_requested_appoints, id, user_type); // initialize requested appnts text area

		// updateRequestTextArea(textArea_requested_appoints, id)

		// label for department dropdown list
		JLabel lbl_department = new JLabel("Department");
		lbl_department.setForeground(new Color(0, 102, 204));
		lbl_department.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_department.setBounds(27, 102, 158, 23);
		add(lbl_department);

		// label for the user dropdown list
		JLabel lbl_user = new JLabel();
		lbl_user.setForeground(new Color(0, 102, 204));
		lbl_user.setText("Patient");
		lbl_user.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_user.setBounds(27, 172, 158, 23);
		add(lbl_user);

		setUserLabel(user_type, lbl_user);

		// dropdown list to select the department
		final JComboBox<String> comboBox_depart = new JComboBox<>();
		comboBox_depart.setForeground(new Color(0, 102, 204));
		comboBox_depart.setBackground(Color.WHITE);
		comboBox_depart.setOpaque(true);
		comboBox_depart.setBounds(195, 102, 216, 20);

		// add items to the department dropdown list
		comboBox_depart.addItem("");
		comboBox_depart.addItem("Emergency ");
		comboBox_depart.addItem("Cardiology");
		comboBox_depart.addItem("ICU       ");
		comboBox_depart.addItem("Neurology ");
		add(comboBox_depart);

		// dropdown list to select the users displayed
		final JComboBox<String> comboBox_user = new JComboBox<>();
		comboBox_user.setBackground(Color.WHITE);
		comboBox_user.setOpaque(true);
		comboBox_user.setBounds(195, 172, 216, 20);
		add(comboBox_user);

		// listener for department dropdown list
		comboBox_depart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				depart = (String) cb.getSelectedItem();

				comboBox_depart.setBackground(Color.WHITE);
				comboBox_user.setBackground(Color.WHITE);
				comboBox_user.removeAllItems();
				comboBox_user.addItem("");
				try {
					if (user_type.equalsIgnoreCase("Patient")) {
						DoctorDB doctorDB = new DoctorDB();
						doctorDB = doctorDB.loadDoctorDB(); // load database from file

						CustomArray docs_in_depart = doctorDB.findDoctorsInDepartment(depart);
						for (int i = 0; i < docs_in_depart.size(); i++) {
							comboBox_user.addItem(docs_in_depart.get(i).getCustomElement()[3]);
						}
					} else {
						PatientDB patientDB = new PatientDB();
						patientDB = patientDB.loadPatientDB(); // load patient database
						for (int i = 0; i < patientDB.size(); i++) {
							comboBox_user.addItem(patientDB.get(i).getCustomElement()[3]);
						}
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		// listener for user dropdown list
		comboBox_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				user = (String) cb.getSelectedItem();

			}
		});

		// spinner which allows the user to set the date
		final JSpinner spinner_date = new JSpinner(new SpinnerDateModel());
		spinner_date.setForeground(new Color(0, 102, 204));
		JSpinner.DateEditor dateEditor1 = new JSpinner.DateEditor(spinner_date, "yyyy.MM.dd");
		spinner_date.setEditor(dateEditor1);
		spinner_date.setBounds(195, 242, 89, 23);
		add(spinner_date);

		// label for date spinner
		JLabel lbl_date = new JLabel("Date");
		lbl_date.setForeground(new Color(0, 102, 204));
		lbl_date.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_date.setBounds(27, 245, 158, 23);
		add(lbl_date);

		// label for the start time spinner
		JLabel lbl_start_time = new JLabel("Start Time");
		lbl_start_time.setForeground(new Color(0, 102, 204));
		lbl_start_time.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_start_time.setBounds(27, 314, 158, 23);
		add(lbl_start_time);

		// label for the end time spinner
		JLabel lbl_end_time = new JLabel("End Time");
		lbl_end_time.setForeground(new Color(0, 102, 204));
		lbl_end_time.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_end_time.setBounds(27, 379, 158, 23);
		add(lbl_end_time);

		// spinner which allows the user to set the start time
		final JSpinner spinner_start_time = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor dateEditor2 = new JSpinner.DateEditor(spinner_start_time, "HH:mm");
		spinner_start_time.setEditor(dateEditor2);
		spinner_start_time.setBounds(195, 311, 89, 23);
		add(spinner_start_time);

		// spinner which allows the user to set the end time
		final JSpinner spinner_end_time = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor dateEditor3 = new JSpinner.DateEditor(spinner_end_time, "HH:mm");
		spinner_end_time.setEditor(dateEditor3);
		spinner_end_time.setBounds(195, 376, 89, 23);
		add(spinner_end_time);

		setDateStartEnd(spinner_date, spinner_start_time, spinner_end_time); // initialize instance variables

		// request appointment button
		JButton btn_request = new JButton("Request Appointment");
		btn_request.setForeground(new Color(0, 102, 204));
		btn_request.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				setDateStartEnd(spinner_date, spinner_start_time, spinner_end_time); // set instance variables

				if (!depart.equalsIgnoreCase("") && !user.equalsIgnoreCase("")) {

					try {
						AppointmentDB appointmentDB = new AppointmentDB();
						appointmentDB = appointmentDB.loadAppointmentDB(); // load saved database file

						PatientDB patientDB = new PatientDB();
						patientDB = patientDB.loadPatientDB(); // load database from file

						DoctorDB doctorDB = new DoctorDB();
						doctorDB = doctorDB.loadDoctorDB(); // load database from file

						String patient_id;
						String doctor_id;
						String status;

						if (user_type.equalsIgnoreCase("Patient")) {
							patient_id = id;
							doctor_id = doctorDB.matchNameToID(user);
							status = "Patient Requested";
						} else {
							patient_id = patientDB.matchNameToID(user);
							doctor_id = id;
							status = "Doctor Requested";
						}

						// add new unavailability to the data base and save
						appointmentDB.add(new String[] { patient_id, doctor_id, depart, date, start, end, status });
						appointmentDB.saveAppointmentDB();
						// refresh requested appnts text area
						updateRequestTextArea(textArea_requested_appoints, id, user_type);

					} catch (Exception e1) {
						e1.printStackTrace();
					}

				} // end out if statement

			} // end mouseClicked handler

		}); // end listener
		btn_request.setBounds(90, 488, 158, 23);
		add(btn_request);

		// cancel request appointment button
		JButton btn_cancel_request = new JButton("Cancel Request");
		btn_cancel_request.setForeground(new Color(0, 102, 204));
		btn_cancel_request.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				setDateStartEnd(spinner_date, spinner_start_time, spinner_end_time); // set instance variables

				try {
					AppointmentDB appointmentDB = new AppointmentDB();
					appointmentDB = appointmentDB.loadAppointmentDB(); // load saved database file

					for (int i = 0; i < appointmentDB.size(); i++) {

						if (user_type.equalsIgnoreCase("Patient")) {

							DoctorDB doctorDB = new DoctorDB();
							doctorDB = doctorDB.loadDoctorDB(); // load database from file
							String user_id = doctorDB.matchNameToID(user);

							if (appointmentDB.get(i).getCustomElement()[0].equalsIgnoreCase(id)
									&& appointmentDB.get(i).getCustomElement()[1].equalsIgnoreCase(user_id)
									&& appointmentDB.get(i).getCustomElement()[2].equalsIgnoreCase(depart)
									&& appointmentDB.get(i).getCustomElement()[3].equalsIgnoreCase(date)
									&& appointmentDB.get(i).getCustomElement()[4].equalsIgnoreCase(start)
									&& appointmentDB.get(i).getCustomElement()[5].equalsIgnoreCase(end)) {

								if (appointmentDB.get(i).getCustomElement()[6].equalsIgnoreCase("Patient Requested")
										&& user_type.equalsIgnoreCase("Patient")) {
									appointmentDB.remove(i);
								} else if (appointmentDB.get(i).getCustomElement()[6]
										.equalsIgnoreCase("Doctor Requested") && user_type.equalsIgnoreCase("Doctor")) {
									appointmentDB.remove(i);
								} else if (appointmentDB.get(i).getCustomElement()[6].equalsIgnoreCase("Denied")) {
									appointmentDB.remove(i);
								}

							}
						} else {

							PatientDB patientDB = new PatientDB();
							patientDB = patientDB.loadPatientDB(); // load database from file
							String user_id = patientDB.matchNameToID(user);

							if (appointmentDB.get(i).getCustomElement()[0].equalsIgnoreCase(user_id)
									&& appointmentDB.get(i).getCustomElement()[1].equalsIgnoreCase(id)
									&& appointmentDB.get(i).getCustomElement()[2].equalsIgnoreCase(depart)
									&& appointmentDB.get(i).getCustomElement()[3].equalsIgnoreCase(date)
									&& appointmentDB.get(i).getCustomElement()[4].equalsIgnoreCase(start)
									&& appointmentDB.get(i).getCustomElement()[5].equalsIgnoreCase(end)) {

								if (appointmentDB.get(i).getCustomElement()[6].equalsIgnoreCase("Patient Requested")
										&& user_type.equalsIgnoreCase("Patient")) {
									appointmentDB.remove(i);
								} else if (appointmentDB.get(i).getCustomElement()[6]
										.equalsIgnoreCase("Doctor Requested") && user_type.equalsIgnoreCase("Doctor")) {
									appointmentDB.remove(i);
								} else if (appointmentDB.get(i).getCustomElement()[6].equalsIgnoreCase("Denied")) {
									appointmentDB.remove(i);
								}

							} // end out if statements
						}

					} // end for statement

					appointmentDB.saveAppointmentDB();
					updateRequestTextArea(textArea_requested_appoints, id, user_type);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			} // end mouseClicked handler

		}); // end listener
		btn_cancel_request.setBounds(283, 488, 158, 23);
		add(btn_cancel_request);

		// button used to deny a requested appointment
		JButton btn_deny_req = new JButton("Deny Request");
		btn_deny_req.setForeground(new Color(0, 102, 204));
		btn_deny_req.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				setDateStartEnd(spinner_date, spinner_start_time, spinner_end_time); // set instance variables

				try {
					AppointmentDB appointmentDB = new AppointmentDB();
					appointmentDB = appointmentDB.loadAppointmentDB(); // load saved database file

					for (int i = 0; i < appointmentDB.size(); i++) {

						if (user_type.equalsIgnoreCase("Patient")) {

							DoctorDB doctorDB = new DoctorDB();
							doctorDB = doctorDB.loadDoctorDB(); // load database from file
							String user_id = doctorDB.matchNameToID(user);

							if (appointmentDB.get(i).getCustomElement()[0].equalsIgnoreCase(id)
									&& appointmentDB.get(i).getCustomElement()[1].equalsIgnoreCase(user_id)
									&& appointmentDB.get(i).getCustomElement()[2].equalsIgnoreCase(depart)
									&& appointmentDB.get(i).getCustomElement()[3].equalsIgnoreCase(date)
									&& appointmentDB.get(i).getCustomElement()[4].equalsIgnoreCase(start)
									&& appointmentDB.get(i).getCustomElement()[5].equalsIgnoreCase(end)) {

								if (appointmentDB.get(i).getCustomElement()[6].equalsIgnoreCase("Doctor Requested")) {
									appointmentDB.get(i).getCustomElement()[6] = "Denied";
								}

							}
						} else {

							PatientDB patientDB = new PatientDB();
							patientDB = patientDB.loadPatientDB(); // load database from file
							String user_id = patientDB.matchNameToID(user);

							if (appointmentDB.get(i).getCustomElement()[0].equalsIgnoreCase(user_id)
									&& appointmentDB.get(i).getCustomElement()[1].equalsIgnoreCase(id)
									&& appointmentDB.get(i).getCustomElement()[2].equalsIgnoreCase(depart)
									&& appointmentDB.get(i).getCustomElement()[3].equalsIgnoreCase(date)
									&& appointmentDB.get(i).getCustomElement()[4].equalsIgnoreCase(start)
									&& appointmentDB.get(i).getCustomElement()[5].equalsIgnoreCase(end)) {

								if (appointmentDB.get(i).getCustomElement()[6].equalsIgnoreCase("Patient Requested")) {
									appointmentDB.get(i).getCustomElement()[6] = "Denied";
								}

							} // end out if statements
						}

					} // end for statement

					appointmentDB.saveAppointmentDB();
					updateRequestTextArea(textArea_requested_appoints, id, user_type);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			} // end mouseClicked handler

		}); // end listener
		btn_deny_req.setBounds(468, 488, 158, 23);
		add(btn_deny_req);

		// button used to confirm a requested appointment
		JButton btn_confirm_req = new JButton("Confirm Request");
		btn_confirm_req.setForeground(new Color(0, 102, 204));
		btn_confirm_req.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				setDateStartEnd(spinner_date, spinner_start_time, spinner_end_time); // set instance variables

				try {
					AppointmentDB appointmentDB = new AppointmentDB();
					appointmentDB = appointmentDB.loadAppointmentDB(); // load saved database file

					for (int i = 0; i < appointmentDB.size(); i++) {

						if (user_type.equalsIgnoreCase("Patient")) {

							DoctorDB doctorDB = new DoctorDB();
							doctorDB = doctorDB.loadDoctorDB(); // load database from file
							String user_id = doctorDB.matchNameToID(user);

							if (appointmentDB.get(i).getCustomElement()[0].equalsIgnoreCase(id)
									&& appointmentDB.get(i).getCustomElement()[1].equalsIgnoreCase(user_id)
									&& appointmentDB.get(i).getCustomElement()[2].equalsIgnoreCase(depart)
									&& appointmentDB.get(i).getCustomElement()[3].equalsIgnoreCase(date)
									&& appointmentDB.get(i).getCustomElement()[4].equalsIgnoreCase(start)
									&& appointmentDB.get(i).getCustomElement()[5].equalsIgnoreCase(end)) {

								if (appointmentDB.get(i).getCustomElement()[6].equalsIgnoreCase("Doctor Requested")) {
									appointmentDB.get(i).getCustomElement()[6] = "Confirmed";
								}

							}
						} else {

							PatientDB patientDB = new PatientDB();
							patientDB = patientDB.loadPatientDB(); // load database from file
							String user_id = patientDB.matchNameToID(user);

							if (appointmentDB.get(i).getCustomElement()[0].equalsIgnoreCase(user_id)
									&& appointmentDB.get(i).getCustomElement()[1].equalsIgnoreCase(id)
									&& appointmentDB.get(i).getCustomElement()[2].equalsIgnoreCase(depart)
									&& appointmentDB.get(i).getCustomElement()[3].equalsIgnoreCase(date)
									&& appointmentDB.get(i).getCustomElement()[4].equalsIgnoreCase(start)
									&& appointmentDB.get(i).getCustomElement()[5].equalsIgnoreCase(end)) {

								if (appointmentDB.get(i).getCustomElement()[6].equalsIgnoreCase("Patient Requested")) {
									appointmentDB.get(i).getCustomElement()[6] = "Confirmed";
								}

							} // end out if statements
						}

					} // end for statement

					appointmentDB.saveAppointmentDB();
					updateRequestTextArea(textArea_requested_appoints, id, user_type);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			} // end mouseClicked handler

		}); // end listener
		btn_confirm_req.setBounds(649, 488, 158, 23);
		add(btn_confirm_req);

		// text used to explain how the cancel/deny/confirm process works
		JTextArea txtr_instructions = new JTextArea();
		txtr_instructions.setForeground(Color.RED);
		txtr_instructions.setBackground(Color.LIGHT_GRAY);
		txtr_instructions.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		txtr_instructions.setEditable(false); // disable ability to change reserved times using text entry
		txtr_instructions.setLineWrap(true); // set the text wrap around
		txtr_instructions.setWrapStyleWord(true); // do not split words whe wrapping text
		txtr_instructions.setText(
				"To request an appointment, all the above fields must be filled-out. You can only cancel requests "
						+ "that you have made or that have been denied. You may only deny/confirm requests not made by you.");
		txtr_instructions.setBounds(90, 421, 717, 46);
		add(txtr_instructions);

		// header for the requested appointments display area
		JLabel lbl_requested_header = new JLabel("Requested Appointments");
		lbl_requested_header.setForeground(new Color(0, 102, 204));
		lbl_requested_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_requested_header.setFont(new Font("Cambria Math", Font.BOLD, 16));
		lbl_requested_header.setBounds(665, 121, 216, 23);
		add(lbl_requested_header);

		// date column header for the requested appointments display area
		JLabel lbl_date_column = new JLabel("Date");
		lbl_date_column.setForeground(new Color(0, 102, 204));
		lbl_date_column.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lbl_date_column.setBounds(494, 155, 35, 14);
		add(lbl_date_column);

		// start time column header for the requested appointments display area
		JLabel lbl_start_time_column = new JLabel("Start");
		lbl_start_time_column.setForeground(new Color(0, 102, 204));
		lbl_start_time_column.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lbl_start_time_column.setBounds(562, 155, 35, 14);
		add(lbl_start_time_column);

		// end time column header for the requested appointments display area
		JLabel lbl_end_time_column = new JLabel("End");
		lbl_end_time_column.setForeground(new Color(0, 102, 204));
		lbl_end_time_column.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lbl_end_time_column.setBounds(599, 155, 29, 14);
		add(lbl_end_time_column);

		// user who requested the appoinment
		JLabel lbl_user_column = new JLabel("User");
		lbl_user_column.setForeground(new Color(0, 102, 204));
		if (user_type.equalsIgnoreCase("Patient")) {
			lbl_user_column.setText("Doctor");
		} else {
			lbl_user_column.setText("Patient");
		}
		lbl_user_column.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lbl_user_column.setBounds(737, 155, 70, 14);
		add(lbl_user_column);

		// button allows the user to return to the dash board
		JButton btn_return = new JButton("Return");
		btn_return.setForeground(new Color(0, 102, 204));
		btn_return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (user_type.equalsIgnoreCase("Patient")) {
					try {
						frame.setContentPane(new PatientDashboard(frame, id));
						frame.revalidate();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						frame.setContentPane(new DoctorDashboard(frame, id));
						frame.revalidate();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btn_return.setBounds(885, 528, 89, 23);
		add(btn_return);

		JLabel lbl_depart_column = new JLabel("Department");
		lbl_depart_column.setForeground(new Color(0, 102, 204));
		lbl_depart_column.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lbl_depart_column.setBounds(639, 155, 88, 14);
		add(lbl_depart_column);
		
		JLabel lbl_AHSimg = new JLabel("");
		lbl_AHSimg.setIcon(new ImageIcon(RequestAppointment.class.getResource("/iteration_3/ahs.png")));
		lbl_AHSimg.setBounds(10, 3, 189, 88);
		add(lbl_AHSimg);
	} // end RequestAppointment constructor

	/**
	 * Method determines whether a doctor or a patient has accessed the request appointment screen and sets the user
	 * dropdown list appropriately.
	 * 
	 * @param user_type  of type String is either "Patient" or "Doctor"
	 * @param user_label of type JLabel representing the label for the user dropdown list
	 */
	protected static void setUserLabel(String user_type, JLabel user_label) {
		if (user_type.equalsIgnoreCase("Patient")) {
			user_label.setText("Doctor");
		} else {
			user_label.setText("Patient");
		}
	}

	/**
	 * Method extracts the current date from date spin, current start time from start time spinner, and current end time
	 * from end time spinner, and updates the instance variables accordingly.
	 * 
	 * @param spinner_date       of type JSpinner representing the requested appointment date
	 * @param spinner_start_time of type JSpinner representing the requested appointment start time
	 * @param spinner_end_time   of type JSpinner representing the requested appointment end time
	 */
	protected void setDateStartEnd(JSpinner spinner_date, JSpinner spinner_start_time, JSpinner spinner_end_time) {

		String date = spinner_date.getValue().toString(); // convert spinner to string
		String[] date_split1 = date.split(" "); // split time string by spaces

		String month;
		switch (date_split1[1]) {
		case ("Jan"):
			month = "01";
			break;
		case ("Feb"):
			month = "02";
			break;
		case ("Mar"):
			month = "03";
			break;
		case ("Apr"):
			month = "04";
			break;
		case ("May"):
			month = "05";
			break;
		case ("Jun"):
			month = "06";
			break;
		case ("Jul"):
			month = "07";
			break;
		case ("Aug"):
			month = "08";
			break;
		case ("Sep"):
			month = "09";
			break;
		case ("Oct"):
			month = "10";
			break;
		case ("Nov"):
			month = "11";
			break;
		default:
			month = "12";
			break;
		}

		// set date instance variable to current value of date spinner in form YYYY-MM-DD
		this.date = date_split1[5] + "-" + month + "-" + date_split1[2];

		// set start instance variable to current value of start time spinner in form HH:MM
		String start_time_date = spinner_start_time.getValue().toString(); // convert spinner to string
		String[] strt_split1 = start_time_date.split(" "); // split time string by spaces
		// time is in third position of spinner string. Split by ":" symbol
		String[] strt_split2 = strt_split1[3].split(":");
		// hour and minute are first and second elements of split string
		this.start = strt_split2[0] + ":" + strt_split2[1];

		// set end instance variable to current value of end time spinner in form HH:MM
		String end_time_date = spinner_end_time.getValue().toString(); // convert spinner to string
		String[] end_split1 = end_time_date.split(" "); // split time string by spaces
		// time is in third position of spinner string. Split by ":" symbol
		String[] end_split2 = end_split1[3].split(":");
		// hour and minute are first and second elements of split string
		this.end = end_split2[0] + ":" + end_split2[1];

	} // end setDateStartEnd()

	/**
	 * Method returns a string array containing elements which are appointment records that match their id number
	 * 
	 * @param id        of type string representing the id number of the user who opened the window
	 * @param user_type of type string indicating if the user is a patient or a doctor
	 * @return String[] containing all appointment records which match the id number
	 * @throws Exception
	 */
	protected String[] getRequestedAppointments(String id, String user_type) throws Exception {

		AppointmentDB appointmentDB = new AppointmentDB();
		appointmentDB = appointmentDB.loadAppointmentDB(); // load saved database file

		String[] request_strings; // initialize return array
		CustomArray requested_appointments; // initialize array to hold appointments which match the id number

		if (user_type.equalsIgnoreCase("Patient")) {
			requested_appointments = appointmentDB.search(id, 0);
			request_strings = new String[requested_appointments.size()];

			DoctorDB doctorDB = new DoctorDB();
			doctorDB = doctorDB.loadDoctorDB(); // load database from file

			for (int i = 0; i < request_strings.length; i++) {
				if (!requested_appointments.get(i).getCustomElement()[6].equalsIgnoreCase("Booked")) {
					String req_depart = requested_appointments.get(i).getCustomElement()[2];
					String req_date = requested_appointments.get(i).getCustomElement()[3];
					String req_start = requested_appointments.get(i).getCustomElement()[4];
					String req_end = requested_appointments.get(i).getCustomElement()[5];
					String req_user = "";
					for (int j = 0; j < doctorDB.size(); j++) {
						if (doctorDB.get(j).getCustomElement()[0]
								.equalsIgnoreCase(requested_appointments.get(i).getCustomElement()[1])) {
							req_user = doctorDB.get(j).getCustomElement()[3];
						}
					}
					String req_status = requested_appointments.get(i).getCustomElement()[6];
					request_strings[i] = req_date + " " + req_start + " " + req_end + "    " + req_depart
							+ "            " + req_user + "  (" + req_status + ")";
				}
			}

		} else {
			requested_appointments = appointmentDB.search(id, 1);
			request_strings = new String[requested_appointments.size()];

			PatientDB patientDB = new PatientDB();
			patientDB = patientDB.loadPatientDB(); // load database from file

			for (int i = 0; i < request_strings.length; i++) {
				if (!requested_appointments.get(i).getCustomElement()[6].equalsIgnoreCase("Booked")) {
					String req_depart = requested_appointments.get(i).getCustomElement()[2];
					String req_date = requested_appointments.get(i).getCustomElement()[3];
					String req_start = requested_appointments.get(i).getCustomElement()[4];
					String req_end = requested_appointments.get(i).getCustomElement()[5];
					String req_user = "";
					for (int j = 0; j < patientDB.size(); j++) {
						if (patientDB.get(j).getCustomElement()[0]
								.equalsIgnoreCase(requested_appointments.get(i).getCustomElement()[0])) {
							req_user = patientDB.get(j).getCustomElement()[3];
						}
					}
					String req_status = requested_appointments.get(i).getCustomElement()[6];
					request_strings[i] = req_date + " " + req_start + " " + req_end + "    " + req_depart
							+ "            " + req_user + "  (" + req_status + ")";
				}
			}
		}

		return request_strings;

	} // end getRequestedAppointments

	/**
	 * Method calls the getRequestedAppointment method and uses the returned string array, containing all the
	 * appointments which match the id number parameter, and sets the textArea parameter with the contents of the string
	 * array
	 * 
	 * @param textArea  of type JTextArea representing the appointment display
	 * @param id        of type String representing the id number of the user who opened the window
	 * @param user_type of type String representing the type of user who opened the window, "Patient" or "Doctor"
	 * @throws Exception
	 */
	protected void updateRequestTextArea(JTextArea textArea, String id, String user_type) throws Exception {

		String[] requests = getRequestedAppointments(id, user_type);

		String text_for_textArea = "";
		for (int i = 0; i < requests.length; i++) {
			if (requests[i] != null) {
				text_for_textArea += requests[i] + "\n";
			}
		}
		textArea.setText(text_for_textArea);
		textArea.setCaretPosition(0); // set the default scroll pane position to be at the top

	} // end updateRequestTextArea()

} // end class RequestAppointment
