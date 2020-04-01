package iteration_3;

/**
 * The DoctorUnavailability.java class provides a frame to display and edit the availability associated with a doctor. 
 * Doctors are redirected to this frame from the DoctorDashboard class.
 *  
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-16
 * Updated:		2020-03-28
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;

public class DoctorUnavailability extends JPanel {

	private static final long serialVersionUID = 12L; // serial ID for java object saving

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public DoctorUnavailability(final JFrame frame, final String doctorID) throws Exception {

		// set window properties
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		final Calendar calendar = new Calendar(); // create instance of Calendar class

		// add calendar header to show month and year
		JLabel cal_header = calendar.initCalendarHeader();
		add(cal_header);

		// add buttons for every day of the month
		ArrayList<JButton> calendar_buttons = calendar.initCalendarButtons();
		for (int i = 0; i < calendar_buttons.size(); i++) {
			add(calendar_buttons.get(i));
		}

		// Date header to be displayed at the top of the unavailability portion of the window (right hand side)
		JLabel lbl_day_selected_header = new JLabel(
				calendar.get_year() + "-" + calendar.get_month() + "-" + calendar.get_day()); // get current day header
		lbl_day_selected_header.setBackground(new Color(0, 102, 204));
		lbl_day_selected_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_day_selected_header.setForeground(Color.WHITE);
		lbl_day_selected_header.setFont(new Font("Cambria Math", Font.BOLD, 14));
		lbl_day_selected_header.setBounds(707, 30, 145, 28);
		add(lbl_day_selected_header);

		// Add scroll pane to dynamically display all times unavailable for the selected date
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(656, 141, 274, 166);
		add(scrollPane);

		// Text area to show booked off times, is inserted into the scroll pane
		final JTextArea unavail_textArea = new JTextArea();
		scrollPane.setViewportView(unavail_textArea); // add text area to scroll pane
		unavail_textArea.setEditable(false); // disable ability to change reserved times using text entry
		unavail_textArea.setCaretPosition(0); // set the default scroll pane position to be at the top

		// update content in text area to show availability for current date
		setUnavailabilityTextField(unavail_textArea, doctorID, calendar);

		// add event listeners to buttons for every day of the month
		calendar.setupDateButtons(calendar_buttons, lbl_day_selected_header, unavail_textArea, doctorID, calendar, null,
				null, "Unavailability");

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

		// Unavailability display header
		JLabel lbl_avail_header = new JLabel("Times Unavailable");
		lbl_avail_header.setForeground(new Color(0, 102, 204));
		lbl_avail_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_avail_header.setFont(new Font("Cambria Math", Font.BOLD, 14));
		lbl_avail_header.setBounds(713, 69, 139, 28);
		add(lbl_avail_header);

		// Unavailability start time column header
		JLabel lbl_time_start_column = new JLabel("Start Time");
		lbl_time_start_column.setForeground(new Color(0, 102, 204));
		lbl_time_start_column.setFont(new Font("Cambria Math", Font.BOLD, 14));
		lbl_time_start_column.setBounds(679, 116, 83, 14);
		add(lbl_time_start_column);

		// Unavailability end time column header
		JLabel lbl_time_start_column_1 = new JLabel("End Time");
		lbl_time_start_column_1.setForeground(new Color(0, 102, 204));
		lbl_time_start_column_1.setFont(new Font("Cambria Math", Font.BOLD, 14));
		lbl_time_start_column_1.setBounds(814, 116, 83, 14);
		add(lbl_time_start_column_1);

		// Unavailability modify section header
		JLabel lbl_modify = new JLabel("Modify Unavailability - 24 Clock");
		lbl_modify.setForeground(new Color(0, 102, 204));
		lbl_modify.setFont(new Font("Cambria Math", Font.BOLD, 14));
		lbl_modify.setBounds(676, 330, 237, 14);
		add(lbl_modify);

		// Add time spinner for start time entry
		final JSpinner start_time_spinner = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor dateEditor1 = new JSpinner.DateEditor(start_time_spinner, "HH:mm");
		start_time_spinner.setEditor(dateEditor1);
		start_time_spinner.setBounds(679, 367, 83, 20);
		add(start_time_spinner);

		// Add time spinner for end time entry
		final JSpinner end_time_spinner = new JSpinner(new SpinnerDateModel());
		end_time_spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				end_time_spinner.setValue(end_time_spinner.getValue());
			}
		});
		JSpinner.DateEditor dateEditor2 = new JSpinner.DateEditor(end_time_spinner, "HH:mm");
		end_time_spinner.setEditor(dateEditor2);
		end_time_spinner.setBounds(814, 367, 83, 20);
		add(end_time_spinner);

		// Unavailability modify start time label
		JLabel lbl_modify_start_time = new JLabel("Start Time");
		lbl_modify_start_time.setForeground(new Color(0, 102, 204));
		lbl_modify_start_time.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_modify_start_time.setBounds(687, 398, 75, 19);
		add(lbl_modify_start_time);

		// Unavailability modify end time label
		JLabel lbl_new_time = new JLabel("End Time");
		lbl_new_time.setForeground(new Color(0, 102, 204));
		lbl_new_time.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_new_time.setBounds(822, 398, 75, 19);
		add(lbl_new_time);

		// button to add a new unavailability entry. Start and end times are extracted from the spinners
		JButton btn_add = new JButton("Add");
		btn_add.setForeground(new Color(0, 102, 204));
		btn_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					DoctorUnavailabilityDB doctUnavailDB = new DoctorUnavailabilityDB();
					doctUnavailDB = doctUnavailDB.loadDoctorUnavailabilityDB(); // load saved database file
					CustomArray docAvailList = doctUnavailDB.search(doctorID, 1); // get doctor unavailability entries

					String entry_no = String.valueOf(docAvailList.size()); // assign of number to new entry
					String id = doctorID; // doctor id
					// get date from the Calendar instance variables and concatenate into a String of form YYYY-MM-DD
					String date = String.valueOf(calendar.get_year()) + "-" + String.valueOf(calendar.get_month()) + "-"
							+ String.valueOf(calendar.get_day()); // YYYY-MM-DD
					String start = extractHourAndMinute(start_time_spinner); // get start time of unavailability
					String end = extractHourAndMinute(end_time_spinner); // get end time of unavailability

					// add new unavailability to the data base and save
					doctUnavailDB.add(new String[] { entry_no, id, date, start, end });
					doctUnavailDB.saveDoctorUnavailabilityDB();

					// update the unavailability text box to show newly added entry
					setUnavailabilityTextField(unavail_textArea, doctorID, calendar);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btn_add.setBounds(746, 436, 89, 23);
		add(btn_add);

		// button to remove an unavailability entry. Start and end times are extracted from the spinners
		JButton btn_remove = new JButton("Remove");
		btn_remove.setForeground(new Color(0, 102, 204));
		btn_remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DoctorUnavailabilityDB doctUnavailDB = new DoctorUnavailabilityDB();
					doctUnavailDB = doctUnavailDB.loadDoctorUnavailabilityDB(); // load saved database file

					// get date from the Calendar instance variables and concatenate into a String of form YYYY-MM-DD
					String date = String.valueOf(calendar.get_year()) + "-" + String.valueOf(calendar.get_month()) + "-"
							+ String.valueOf(calendar.get_day()); // YYYY-MM-DD
					String start = extractHourAndMinute(start_time_spinner); // get start time of unavailability
					String end = extractHourAndMinute(end_time_spinner); // get end time of unavailability

					// remove matching unavailbility entry from the database and save
					doctUnavailDB.removeMatchStartEndID(doctorID, date, start, end);
					doctUnavailDB.saveDoctorUnavailabilityDB();

					// update the unavailability text box to show newly removed entry
					setUnavailabilityTextField(unavail_textArea, doctorID, calendar);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_remove.setBounds(746, 478, 89, 23);
		add(btn_remove);

		// Add button and event listener to allow user to return to the Doctor dash board window
		JButton btn_back = new JButton("Back");
		btn_back.setForeground(new Color(0, 102, 204));
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DoctorDashboard login = new DoctorDashboard(frame, doctorID);
					frame.setContentPane(login);
					frame.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_back.setBounds(885, 528, 89, 23);
		add(btn_back);

		JLabel lbl_availabililty_header = new JLabel("Availability Calendar");
		lbl_availabililty_header.setForeground(new Color(0, 102, 204));
		lbl_availabililty_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_availabililty_header.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_availabililty_header.setBounds(157, 47, 248, 39);
		add(lbl_availabililty_header);
		
		JLabel lblAHSimg = new JLabel("");
		lblAHSimg.setIcon(new ImageIcon(DoctorUnavailability.class.getResource("/iteration_3/ahs.png")));
		lblAHSimg.setBounds(484, 11, 190, 68);
		add(lblAHSimg);

	} // end DoctorAvailability constructor

	/**
	 * Method extracts the hour and minute from the time spinner. A string is generated in the form HH-MM and returned.
	 * 
	 * @param spinner JSpinner of the form "HH:mm"
	 * @return String of hour and minute extracted from the spinner of form HH-MM
	 */
	protected static String extractHourAndMinute(JSpinner spinner) {

		String date = spinner.getValue().toString(); // convert spinner to string
		String[] str_split1 = date.split(" "); // split time string by spaces
		// time is in third position of spinner string. Split by ":" symbol
		String[] str_split2 = str_split1[3].split(":");

		// hour and minute are first and second elements of split string
		return str_split2[0] + ":" + str_split2[1];

	}

	/**
	 * Method pulls the unavailability for the doctor with id equal to doctorID parameter, for the current date of the
	 * calendar. Each (if any) of the entries is added to a string array, to be returned by the method.
	 * 
	 * @param doctorID of type String representing the doctor ID
	 * @param cal      of type calendar representing the current state of the calendar
	 * @return String[] containing elements which correspond to unavailability entries for the doctor
	 * @throws Exception
	 */
	protected static String[] getDoctorUnavailability(String doctorID, Calendar cal) throws Exception {

		// get date from the Calendar instance variables and concatenate into a String of form YYYY-MM-DD
		String date = String.valueOf(cal.get_year()) + "-" + String.valueOf(cal.get_month()) + "-"
				+ String.valueOf(cal.get_day());

		DoctorUnavailabilityDB doctUnavailDB = new DoctorUnavailabilityDB();
		doctUnavailDB = doctUnavailDB.loadDoctorUnavailabilityDB(); // load saved database file
		// find all entries which match the doctor id and the current date that the calendar is set to
		CustomArray docAvailList = doctUnavailDB.search(doctorID, 1).search(date, 2);
		// make a return string array that is the same size as the number of unavailability entries found
		String[] doc_unavail_strings = new String[docAvailList.size()];

		// for each of the unavailability entries found, create a string that contains start and end times
		// add the newly created string to the return string array
		for (int i = 0; i < docAvailList.size(); i++) {
			String start = docAvailList.get(i).getCustomElement()[3];
			String end = docAvailList.get(i).getCustomElement()[4];
			doc_unavail_strings[i] = "               " + start + "\t\t" + end;
		}

		return doc_unavail_strings;

	}

	/**
	 * Method adds each (if any) of the unavailability entries, found by the getDoctorUnavailability() method, to a
	 * String, separated by line breaks, so that one entry appears per line. The string is set as text in the
	 * unavailability textArea.
	 * 
	 * @param textArea of type JTextArea representing the box where doctor unavailability is displayed
	 * @param doctorID of type String representing the doctor id
	 * @param cal      of type Calendar representing the current state of the calendar
	 * @throws Exception
	 */
	protected static void setUnavailabilityTextField(JTextArea textArea, String doctorID, Calendar cal)
			throws Exception {

		String[] times_unavail = getDoctorUnavailability(doctorID, cal);
		String text_for_textArea = "";
		for (int i = 0; i < times_unavail.length; i++) {
			text_for_textArea += times_unavail[i] + "\n";
		}
		textArea.setText(text_for_textArea);
		textArea.setCaretPosition(0); // set the default scroll pane position to be at the top

	}

} // end class DoctorUavailability
