package iteration_3;

/**
 * The AppointmentCalendar.java class provides a frame for doctors and patients to view their schedules.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-29
 */

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class AppointmentCalendar extends JPanel {

	private static final long serialVersionUID = 2L; // serial ID for java object saving

	/**
	 * Creates the appointment calendar view window which can be accessed by either patients or doctors.
	 * 
	 * @param frame     of type JFrame represents the program window
	 * @param id        of type String represents the id number of the user who opened the window
	 * @param user_type of type String represents either a doctor or patients, who opened the window
	 * @throws Exception
	 */
	protected AppointmentCalendar(final JFrame frame, final String id, final String user_type) throws Exception {

		// set window properties
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		final Calendar calendar = new Calendar(); // create instance of Calendar class

		// window title
		JLabel lbl_calendar_header = new JLabel("Schedule Calendar");
		lbl_calendar_header.setForeground(new Color(0, 102, 204));
		lbl_calendar_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_calendar_header.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_calendar_header.setBounds(120, 42, 316, 38);
		add(lbl_calendar_header);

		// add calendar header to show month and year
		JLabel cal_header = calendar.initCalendarHeader();
		add(cal_header);

		// buttons for every day of the month
		ArrayList<JButton> calendar_buttons = calendar.initCalendarButtons();
		for (int i = 0; i < calendar_buttons.size(); i++) {
			add(calendar_buttons.get(i));
		}

		// configure the start day of the month numbering and day of week
		calendar.configureCalendarForMonth(calendar_buttons);

		// Create and add navigation buttons for the calendar
		ArrayList<JButton> navigation_buttons = calendar.initCalendarNavigation();
		for (int i = 0; i < navigation_buttons.size(); i++) {
			add(navigation_buttons.get(i));

		}

		// add event listeners to calendar navigation buttons
		calendar.setupNavigationButtons(navigation_buttons, calendar_buttons);

		// Create and add calendar day labels
		ArrayList<JLabel> day_labels = calendar.initCalendarDayLabels();
		for (int i = 0; i < day_labels.size(); i++) {
			add(day_labels.get(i));
		}

		// Date header to be displayed at the top of the unavailability portion of the window (lower right hand side)
		JLabel lbl_day_selected_header = new JLabel(
				calendar.get_year() + "-" + calendar.get_month() + "-" + calendar.get_day()); // get default header
		lbl_day_selected_header.setBackground(new Color(0, 102, 204));
		lbl_day_selected_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_day_selected_header.setForeground(Color.WHITE);
		lbl_day_selected_header.setFont(new Font("Cambria Math", Font.BOLD, 14));
		lbl_day_selected_header.setBounds(680, 113, 145, 28);
		add(lbl_day_selected_header);

		// add scroll pane to dynamically display appointments
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(613, 178, 301, 237);
		add(scrollPane);

		// add text area to display appointments
		JTextArea schedule_textArea = new JTextArea();
		scrollPane.setViewportView(schedule_textArea);

		// initialize the text area with the appointments for the current day
		setUnavailabilityTextField(schedule_textArea, id, calendar, user_type);

		// add event listeners to buttons for every day of the month
		calendar.setupDateButtons(calendar_buttons, lbl_day_selected_header, schedule_textArea, id, calendar, null,
				null, user_type);

		// add header for appointment display
		JLabel lbl_appoint_header = new JLabel("Booked Appointments");
		lbl_appoint_header.setForeground(new Color(0, 102, 204));
		lbl_appoint_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_appoint_header.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_appoint_header.setBounds(642, 77, 222, 25);
		add(lbl_appoint_header);

		// add date column header
		JLabel lbl_date_column = new JLabel("Date");
		lbl_date_column.setForeground(new Color(0, 102, 204));
		lbl_date_column.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lbl_date_column.setBounds(613, 152, 46, 14);
		add(lbl_date_column);

		// addd start time column header
		JLabel lbl_start_column = new JLabel("Start");
		lbl_start_column.setForeground(new Color(0, 102, 204));
		lbl_start_column.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lbl_start_column.setBounds(685, 153, 46, 14);
		add(lbl_start_column);

		// add end time column header
		JLabel lbl_end_column = new JLabel("End");
		lbl_end_column.setForeground(new Color(0, 102, 204));
		lbl_end_column.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lbl_end_column.setBounds(725, 152, 46, 14);
		add(lbl_end_column);

		// add either docotor or patient column header, depending on who opened the window
		JLabel lbl_user_column = new JLabel("User");
		lbl_user_column.setForeground(new Color(0, 102, 204));
		lbl_user_column.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lbl_user_column.setBounds(781, 152, 46, 14);
		add(lbl_user_column);
		if (user_type.equalsIgnoreCase("Patient")) {
			lbl_user_column.setText("Doctor");
		} else {
			lbl_user_column.setText("Patient");
		}

		// addd button to allow user to return to dashboard
		JButton btn_return = new JButton("Back");
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
		btn_return.setBounds(814, 528, 160, 23);
		add(btn_return);

		JLabel lblAHSImg = new JLabel("");
		lblAHSImg.setIcon(new ImageIcon(AppointmentCalendar.class.getResource("/iteration_3/ahs.png")));
		lblAHSImg.setBounds(413, 11, 216, 71);
		add(lblAHSImg);

	} // end AppointmentCalendar constructor

	/**
	 * Method sets the appointment text area with the appointments for the doctor or the patient, depending on who
	 * opened the winodw
	 * 
	 * @param textArea of type JTextArea used to show sheduled appointments
	 * @param id       of type string representing the user id who opened the window
	 * @param cal      of type Calendar representing the scheduling calendar
	 * @param cal_user of type string, either "Patient" or "Doctor", depending on who opened the window
	 * @throws Exception
	 */
	protected static void setUnavailabilityTextField(JTextArea textArea, String id, Calendar cal, String cal_user)
			throws Exception {

		String text_for_textArea = ""; // start with blank text, used to create a single string showing all appointments

		AppointmentDB appointmentDB = new AppointmentDB();
		appointmentDB = appointmentDB.loadAppointmentDB(); // load saved database file

		String date; // string will be set to current day. For months < 10 (Oct) a '0' is added in front of month
		// to match the date entry in the appointment database
		if (cal.get_month() < 10) {
			date = String.valueOf(cal.get_year()) + "-0" + String.valueOf(cal.get_month());
		} else {
			date = String.valueOf(cal.get_year()) + "-" + String.valueOf(cal.get_month());
		}
		// for days < 10 a '0' is added in front of the month to match the date entry in the appointment database
		if (cal.get_day() < 10) {
			date += "-0" + String.valueOf(cal.get_day());
		} else {
			date += "-" + String.valueOf(cal.get_day());
		}

		// set the text area appropriately, depending on which type of user opened the window
		if (cal_user.equalsIgnoreCase("Patient")) {
			CustomArray search_res = appointmentDB.search(id, 0).search(date, 3).search("Booked", 6);

			for (int i = 0; i < search_res.size(); i++) {
				String date_val = search_res.get(i).getCustomElement()[3];
				String start_val = search_res.get(i).getCustomElement()[4];
				String end_val = search_res.get(i).getCustomElement()[5];

				DoctorDB doctorDB = new DoctorDB();
				doctorDB = doctorDB.loadDoctorDB(); // load saved database file
				String doc_id = search_res.get(i).getCustomElement()[1];
				String doc_name = doctorDB.search(doc_id, 0).get(0).getCustomElement()[3];

				text_for_textArea += date_val + "   " + start_val + "   " + end_val + "       " + doc_name + "\n";
			}
		} else {
			CustomArray search_res = appointmentDB.search(id, 1).search(date, 3).search("Booked", 6);
			for (int i = 0; i < search_res.size(); i++) {
				String date_val = search_res.get(i).getCustomElement()[3];
				String start_val = search_res.get(i).getCustomElement()[4];
				String end_val = search_res.get(i).getCustomElement()[5];

				PatientDB patientDB = new PatientDB();
				patientDB = patientDB.loadPatientDB(); // load saved database file
				String patient_id = search_res.get(i).getCustomElement()[0];
				String patient_name = patientDB.search(patient_id, 0).get(0).getCustomElement()[3];

				text_for_textArea += date_val + "   " + start_val + "   " + end_val + "       " + patient_name + "\n";
			}
		}

		textArea.setText(text_for_textArea);
		textArea.setCaretPosition(0); // set the default scroll pane position to be at the top

	} // end setUnavailabilityTextField()

} // end AppointmentCalendar class
