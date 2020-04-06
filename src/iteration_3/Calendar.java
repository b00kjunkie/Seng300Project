package iteration_3;

/**
 * Calendar.java class represents a calendar which can be used in the PatientDashboard.java, NurseDashboard.java, and
 * DoctorDashboard.java classes. The calendar defaults to the current month, and navigation buttons allows the user
 * to change the month and the year.
 * 
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-27
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Calendar {

	private int year; // the primitive int value for the year
	private int month; // the month-of-year, from 1 to 12
	private int day; // the numbered day of month
	private String date_string; // header string shows " <month> / <date> "

	private final int Y_POSITION_1 = 120; // 32
	private final int Y_POSITION_2 = Y_POSITION_1 + 48; // 80
	private final int Y_POSITION_3 = Y_POSITION_1 + 99; // 131

	JLabel lbl_month_cal_head; // Header label for calendar to display month and year selection

	/**
	 * Constructor determines the current date and assigns corresponding values to the year and month instance
	 * variables. Header label for calendar is set to the current month.
	 */
	protected Calendar() {

		LocalDate currentDate = LocalDate.now(); // current date
		this.month = currentDate.getMonthValue();
		this.year = currentDate.getYear();
		this.day = currentDate.getDayOfMonth();
		this.date_string = Integer.toString(this.month) + " / " + Integer.toString(this.year);

	} // end constructor

	/**
	 * Getter for year instance variable
	 * 
	 * @return
	 */
	protected int get_year() {
		return this.year;
	}

	/**
	 * Getter for month instance variable
	 * 
	 * @return
	 */
	protected int get_month() {
		return this.month;
	}

	/**
	 * Getter for day instance variable
	 * 
	 * @return
	 */
	protected int get_day() {
		return this.day;
	}

	/**
	 * Getter for the calendar header which displays "month / year"
	 * 
	 * @return
	 */
	protected JLabel getLbl_month_cal_head() {
		return lbl_month_cal_head;
	}

	/**
	 * Decreases the value of the year instance variable by one
	 */
	protected void decrementYear() {
		this.year -= 1;
	}

	/**
	 * Decreases the value of the month instance variable by one
	 */
	protected void decrementMonth() {
		this.month -= 1;
	}

	/**
	 * Increases the value of the year instance variable by one
	 */
	protected void incrementYear() {
		this.year += 1;
	}

	/**
	 * Increases the value of the month instance variable by one
	 */
	protected void incrementMonth() {
		this.month += 1;
	}

	/**
	 * Updates the header label, which shows the calendar month and year, to reflect state of instance variables
	 */
	protected void updateHeader() {
		this.date_string = Integer.toString(this.month) + " / " + Integer.toString(this.year);
		lbl_month_cal_head.setText(date_string);
	}

	/**
	 * Initializes the header label to display the caledar year and month
	 * 
	 * @return JLabel for calendar header
	 */
	protected JLabel initCalendarHeader() {

		// label with the header string
		this.lbl_month_cal_head = new JLabel(date_string);

		// formatting options for the header label
		lbl_month_cal_head.setBackground(new Color(0, 102, 204));
		lbl_month_cal_head.setForeground(Color.WHITE);
		lbl_month_cal_head.setOpaque(true);
		lbl_month_cal_head.setFont(new Font("Cambria Math", Font.BOLD, 14));
		lbl_month_cal_head.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_month_cal_head.setBounds(192, Y_POSITION_1, 168, 23);

		return lbl_month_cal_head;

	} // end initCalendarHeader()

	/**
	 * Creates 6 rows of 7 buttons which corresponds to the largest grid that would be needed for any calendar month.
	 * The buttons are assigned positions and added to an ArrayList which is returned by the method.
	 * 
	 * @return ArrayList of type JButton which contains all the buttons required to create a month calendar grid
	 */
	protected ArrayList<JButton> initCalendarButtons() {

		// Array to store a button for every day of the month
		ArrayList<JButton> calendar_btns = new ArrayList<JButton>();

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				int entry = (i * 7) + (j + 1); // determines the button number from ith row and jth column
				JButton new_btn = new JButton(Integer.toString(entry)); // adds a button for calendar day
				new_btn.setFont(new Font("Cambria Math", Font.BOLD, 14));
				new_btn.setForeground(new Color(0, 102, 204));
				new_btn.setBackground(Color.WHITE);
				int x = 37 + (j * 70); // horizontal position is calculated from button number
				int y = Y_POSITION_3 + (i * 50); // vertical position is calculated fro button number
				new_btn.setBounds(x, y, 60, 40); // set position and size of day button
				calendar_btns.add(new_btn); // add button to an array that is to be returned
			}
		}

		return calendar_btns;

	} // end initCalendarButtons()

	/**
	 * Method creates 4 buttons which can be used to increase (decrease) the calendar month (year). Buttons are add to
	 * an Arraylist which is returned by the method.
	 * 
	 * @return ArrayList of type JButton which contains all the buttons required to navigate the calendar
	 */
	protected ArrayList<JButton> initCalendarNavigation() {

		// Array to store the navigation buttons located at the top of the calendar
		ArrayList<JButton> navigation_buttons = new ArrayList<JButton>();

		JButton btn_year_prev = new JButton("<<"); // button to set calendar year to previous year
		btn_year_prev.setBounds(37, Y_POSITION_1, 50, 23); // set position and size of button
		navigation_buttons.add(btn_year_prev); // add button to return array

		JButton btn_month_prev = new JButton("<"); // button to set calendar month to previous month
		btn_month_prev.setBounds(110, Y_POSITION_1, 50, 23); // set position and size of button
		navigation_buttons.add(btn_month_prev); // add button to return array

		JButton btn_year_next = new JButton(">>"); // button to set calendar year to next year
		btn_year_next.setBounds(463, Y_POSITION_1, 50, 23); // set position and size of button
		navigation_buttons.add(btn_year_next); // add button to return array

		JButton btn_month_next = new JButton(">"); // button to set calendar month to next month
		btn_month_next.setBounds(390, Y_POSITION_1, 50, 23); // set position and size of button
		navigation_buttons.add(btn_month_next); // add button to return array

		return navigation_buttons;

	} // end initCalendarNavigation()

	/**
	 * Method creates a label for every day of the week (SUN-MON) and adds them to an ArrayList that is returned.
	 * 
	 * @return ArrayList of type JLabel which contains a label for every day of the week
	 */
	protected ArrayList<JLabel> initCalendarDayLabels() {

		// Text for the labels for the top of the calendar
		String[] day_labels = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		// Array to store each of the labels at the top of the calendar
		ArrayList<JLabel> calendar_day_lbls = new ArrayList<JLabel>();

		// for each day of the week: add the corresponding day name label
		for (int j = 0; j < 7; j++) {
			JLabel new_lbl = new JLabel(day_labels[j]); // label text is set to corresponding day of week name
			new_lbl.setFont(new Font("Cambria Math", Font.BOLD, 14));
			new_lbl.setForeground(Color.WHITE);
			new_lbl.setBackground(new Color(0, 102, 204));
			new_lbl.setOpaque(true); // allow for background color to show
			new_lbl.setHorizontalAlignment(SwingConstants.CENTER);
			int x = 37 + (j * 70); // horizontal position is calculated from label number
			int y = Y_POSITION_2; // // vertical position is calculated from label number
			new_lbl.setBounds(x, y, 60, 40); // set position and size of day label
			calendar_day_lbls.add(new_lbl); // add label to return array
		}

		return calendar_day_lbls;

	} // end initCalendarDayLabels

	/**
	 * Method calculates and returns the first day of the month corresponding to the month and year values of the
	 * instance variables. Method is used to determine which day buttons in the first row should not be visible, and
	 * where day button to begin numbering from 1.
	 * 
	 * @return int representing the first day of month (MON=1, TUE=2, ..., SUN=7)
	 */
	protected int calcFirstDayOfMonth() {

		LocalDate date = LocalDate.of(this.year, this.month, 1); // calculate first day of current year and month
		return date.getDayOfWeek().getValue(); // return integer value day of the week, for first day of the month

	} // end calcFirstDayOfMonth()

	/**
	 * Method calculates and returns the last day of the month corresponding to the month and year values of the
	 * instance variables. Method is used to determine which day buttons at the end of the month should not be visible.
	 * 
	 * @return int representing the last day of the month (MON=1, TUE=2, ..., SUN=7)
	 */
	protected int calcLastDayOfMonth() {

		// calculate the last day of the current year and month
		LocalDate lastDayofMonth = LocalDate.of(this.year, this.month, 1).with(TemporalAdjusters.lastDayOfMonth());
		return lastDayofMonth.getDayOfWeek().getValue(); // return integer day of the week, for last day of the month

	} // end calcLastDayOfMonth

	/**
	 * Method calculates the number of days in month corresponding to the month and year values of the instance
	 * variables.
	 * 
	 * @return
	 */
	protected int calcLengthOfMonth() {

		LocalDate date = LocalDate.of(this.year, this.month, 1); // date corresponding to instance variables
		return date.lengthOfMonth(); // returns number of days in the month

	} // end calcLengthOfMonth()

	/**
	 * Method determines which day buttons should be hidden, at the start and end of the month, for the month and year
	 * which correspond to the values of the instance variables. Since the calcFirstDayOfMonth() and
	 * calcLastDayOfMonth() methods return MON=1, TUE=2, ..., SUN=7, and the calendar starts with a Sunday, there is
	 * special treatment of the case where the month starts on a Sunday.
	 * 
	 * @param buttons of type ArrayList<JButton> corresponding to the day buttons of the calendar.
	 */
	public void configureCalendarForMonth(ArrayList<JButton> buttons) {

		int firstWeekDayOfMonth = this.calcFirstDayOfMonth(); // determine day of week for the first day of month
		int month_end_counter = 0; // counter used to determine when enough buttons have been added for length of month
		int day_counter = 1; // counter used to number that day buttons with that date of month

		switch (firstWeekDayOfMonth) { // switch case used for special treatment of month that starts on a Sunday
		case (7):
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 7; j++) {
					if (month_end_counter >= this.calcLengthOfMonth()) {
						buttons.get((i * 7) + (j)).setVisible(false);
					} else {
						buttons.get((i * 7) + (j)).setVisible(true);
					}
					month_end_counter++;
				}
			}
			for (int i = 0; i < buttons.size(); i++) {
				buttons.get(i).setText(Integer.toString(day_counter));
				day_counter++;
			}
			break;
		default:
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 7; j++) {
					if (month_end_counter - firstWeekDayOfMonth >= this.calcLengthOfMonth()) {
						buttons.get((i * 7) + (j)).setVisible(false);
					} else {
						buttons.get((i * 7) + (j)).setVisible(true);
					}
					month_end_counter++;
				}
			}
			for (int i = 0; i < firstWeekDayOfMonth; i++) {
				buttons.get(i).setVisible(false);
			}
			for (int i = firstWeekDayOfMonth; i < buttons.size(); i++) {
				buttons.get(i).setText(Integer.toString(day_counter));
				day_counter++;
			}
		} // end switch

	} // end configureCalendarForMonth()

	/**
	 * Method adds mouse click event listeners to every day button. Method can be used in two situations: to initialize
	 * a calendar that is used to view unavailability records or to initialize a calendar that is used to view scheduled
	 * appointments. The appropriate fields are set for both situations.
	 * 
	 * @param cal_buttons  of type ArrayList<Buttons> representing each day of the calendar
	 * @param selected_lbl of type JLabel representing the selected day
	 * @param text_area    of type JTextArea representing the text area that displays unavailability or scheduled
	 *                     appoints
	 * @param id           of type string representing the id number of the user who opened this window
	 * @param cal          of type Calendar representing the scheduling/unavailability calendar
	 * @param cb1          of type JComboBox<String> representing department dropdownlist (used in unavailability
	 *                     calendar only)
	 * @param cb2          of type JComboBox<String> representing doctor dropdownlist (used in unavailability calendar
	 *                     only)
	 * @param cal_type     of type string representing the use of the calendar (unavailability or scheduling calendar)
	 */
	protected void setupDateButtons(final ArrayList<JButton> cal_buttons, final JLabel selected_lbl,
			final JTextArea text_area, final String id, final Calendar cal, final JComboBox<String> cb1,
			final JComboBox<String> cb2, final String cal_type) {

		for (int i = 0; i < cal_buttons.size(); i++) {
			final int num = i;
			cal_buttons.get(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					day = Integer.parseInt(cal_buttons.get(num).getText());
					String str = year + "-" + month + "-" + cal_buttons.get(num).getText();
					selected_lbl.setText(str);

					if (cb1 != null && cb2 != null) {
						cb1.setSelectedIndex(0);
						cb2.setSelectedIndex(0);
					}

					try {
						if (cal_type.equalsIgnoreCase("Unavailability")) {
							// update content in text area to show availability for current date
							DoctorUnavailability.setUnavailabilityTextField(text_area, id, cal);
						} else {
							AppointmentCalendar.setUnavailabilityTextField(text_area, id, cal, cal_type);
						}

					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			});

		}

	} // end setupDateButtons()

	/**
	 * Method adds mouse click event listeners to the calendar navigation buttons which allow the user to change the
	 * month and/or year displayed by the calendar. Event listeners update the information displayed by the calendar to
	 * reflect the button clicked.
	 * 
	 * @param nav_buttons ArrayList of type JButton containing the 4 navigation buttons
	 * @param cal_buttons ArrayList of type JButton containing the day buttons of the calendar
	 */
	protected void setupNavigationButtons(ArrayList<JButton> nav_buttons, final ArrayList<JButton> cal_buttons) {

		nav_buttons.get(0).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				decrementYear();
				updateHeader();
				configureCalendarForMonth(cal_buttons);
			}
		});

		nav_buttons.get(1).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (month > 1) {
					decrementMonth();
					updateHeader();
					configureCalendarForMonth(cal_buttons);
				}
			}
		});

		nav_buttons.get(2).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				incrementYear();
				updateHeader();
				configureCalendarForMonth(cal_buttons);
			}
		});

		nav_buttons.get(3).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (month < 12) {
					incrementMonth();
					updateHeader();
					configureCalendarForMonth(cal_buttons);
				}
			}
		});

	} // end setupNavigationButtons()

} // end Calendar class