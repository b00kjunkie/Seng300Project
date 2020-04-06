package iteration_3;

/**
 * The DoctorUnavailabilityView.java class provides a frame to display the availability associated with the doctors in
 * the system. Nurses and patients are redirected to this frame when they select the View Availability button from
 * their respective dash board classes.
 *  
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-16
 * Updated:		2020-03-28
 */

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DoctorUnavailabilityView extends JPanel {

	private static final long serialVersionUID = 12L; // serial ID for java object saving

	/**
	 * Creates a window which allows patients and nurses to view the availabilities associated with doctors
	 * 
	 * @param frame    of type JFrame representing the program window
	 * @param id       of type String representing the id number of the user that opened the window
	 * @param usertype of type String representing either a patient or nurse
	 * @throws Exception
	 */
	protected DoctorUnavailabilityView(final JFrame frame, final String id, final String usertype) throws Exception {

		// set window properties
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		final Calendar calendar = new Calendar(); // create instance of Calendar class

		// header for the window
		JLabel lbl_availability_header = new JLabel("Availabililty Calendar");
		lbl_availability_header.setForeground(new Color(0, 102, 204));
		lbl_availability_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_availability_header.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_availability_header.setBounds(148, 46, 274, 36);
		add(lbl_availability_header);

		// Alberta health services logo
		JLabel lblAHSImg = new JLabel("");
		lblAHSImg.setIcon(new ImageIcon(DoctorUnavailabilityView.class.getResource("/iteration_3/ahs.png")));
		lblAHSImg.setBounds(443, 11, 188, 98);
		add(lblAHSImg);

		// add calendar header to show month and year
		JLabel cal_header = calendar.initCalendarHeader();
		add(cal_header);

		// buttons for every day of the month
		ArrayList<JButton> calendar_buttons = calendar.initCalendarButtons();
		for (int i = 0; i < calendar_buttons.size(); i++) {
			add(calendar_buttons.get(i));
		}

		// Date header to be displayed at the top of the unavailability portion of the window (lower right hand side)
		JLabel lbl_day_selected_header = new JLabel(
				calendar.get_year() + "-" + calendar.get_month() + "-" + calendar.get_day()); // get default header
		lbl_day_selected_header.setBackground(new Color(0, 102, 204));
		lbl_day_selected_header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_day_selected_header.setForeground(Color.WHITE);
		lbl_day_selected_header.setFont(new Font("Cambria Math", Font.BOLD, 14));
		lbl_day_selected_header.setBounds(709, 183, 145, 28);
		add(lbl_day_selected_header);

		// Scroll pane to dynamically display all times unavailable for the selected date
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(654, 294, 274, 166);
		add(scrollPane);

		// Text area to show booked off times, is inserted into the scroll pane
		final JTextArea unavail_textArea = new JTextArea();
		scrollPane.setViewportView(unavail_textArea);
		unavail_textArea.setEditable(false); // disable ability to change reserved times using text entry
		unavail_textArea.setCaretPosition(0); // set the default scroll pane position to be at the top

		// label for department dropdown list
		JLabel lbl_depart_comboBox = new JLabel("Select Department");
		lbl_depart_comboBox.setForeground(new Color(0, 102, 204));
		lbl_depart_comboBox.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_depart_comboBox.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_depart_comboBox.setBounds(715, 31, 139, 20);
		add(lbl_depart_comboBox);

		// dropdown list to select department
		JComboBox<String> comboBox_depart = new JComboBox<>();

		// add items to the department dropdown list
		comboBox_depart.addItem("");
		comboBox_depart.addItem("Emergency ");
		comboBox_depart.addItem("Cardiology");
		comboBox_depart.addItem("ICU       ");
		comboBox_depart.addItem("Neurology ");
		comboBox_depart.setBounds(654, 62, 274, 20);
		add(comboBox_depart);

		// label for doctor dropdown list
		JLabel lbl_doc_comboBox = new JLabel("Select Doctor");
		lbl_doc_comboBox.setForeground(new Color(0, 102, 204));
		lbl_doc_comboBox.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_doc_comboBox.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		lbl_doc_comboBox.setBounds(715, 99, 139, 20);
		add(lbl_doc_comboBox);

		// dropdown list to select department
		final JComboBox<String> comboBox_doc = new JComboBox<>();
		comboBox_doc.addItem("");
		comboBox_doc.setBounds(654, 130, 274, 20);
		add(comboBox_doc);

		// listener for department dropdown list
		comboBox_depart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				String depart = (String) cb.getSelectedItem();

				comboBox_doc.removeAllItems();
				comboBox_doc.addItem("");
				try {
					DoctorDB doctorDB = new DoctorDB();
					doctorDB = doctorDB.loadDoctorDB(); // load database from file

					CustomArray docs_in_depart = doctorDB.findDoctorsInDepartment(depart);
					for (int i = 0; i < docs_in_depart.size(); i++) {
						comboBox_doc.addItem(docs_in_depart.get(i).getCustomElement()[3]);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		// listener for doctor dropbox list
		comboBox_doc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				String name = (String) cb.getSelectedItem();

				if (name != null) {

					try {
						DoctorDB doctorDB = new DoctorDB();
						doctorDB = doctorDB.loadDoctorDB(); // load database from file

						if (name != "") {
							String id_no = doctorDB.matchNameToID(name);
							DoctorUnavailability.setUnavailabilityTextField(unavail_textArea, id_no, calendar);
						}

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		// add event listeners to buttons for every day of the month
		calendar.setupDateButtons(calendar_buttons, lbl_day_selected_header, unavail_textArea, "0", calendar,
				comboBox_depart, comboBox_doc, "Unavailability");

		// configure the start day of the month numbering and day of week
		calendar.configureCalendarForMonth(calendar_buttons);

		// Create and add navigabation buttons for the calendar
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
		lbl_avail_header.setBounds(715, 222, 139, 28);
		add(lbl_avail_header);

		// Unavailability start time column header
		JLabel lbl_time_start_column = new JLabel("Start Time");
		lbl_time_start_column.setForeground(new Color(0, 102, 255));
		lbl_time_start_column.setFont(new Font("Cambria Math", Font.BOLD, 14));
		lbl_time_start_column.setBounds(681, 269, 83, 14);
		add(lbl_time_start_column);

		// Unavailability end time column header
		JLabel lbl_time_start_column_1 = new JLabel("End Time");
		lbl_time_start_column_1.setForeground(new Color(0, 102, 204));
		lbl_time_start_column_1.setFont(new Font("Cambria Math", Font.BOLD, 14));
		lbl_time_start_column_1.setBounds(816, 269, 83, 14);
		add(lbl_time_start_column_1);

		// Add button and event listener to allow user to return to the dash board window
		final JButton btn_return = new JButton("Back");
		btn_return.setForeground(new Color(0, 102, 204));
		btn_return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (usertype.equalsIgnoreCase("nurse")) {
					try {
						NurseDashboard login = new NurseDashboard(frame, id);
						frame.setContentPane(login);
						frame.revalidate();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						PatientDashboard login = new PatientDashboard(frame, id);
						frame.setContentPane(login);
						frame.revalidate();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btn_return.setBounds(814, 528, 160, 23);
		add(btn_return);

	} // end constructor

} // end class DoctorUnavailabilityView
