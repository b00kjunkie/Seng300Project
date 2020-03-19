package iteration_2;

/**
 * The DoctorUnavailabilityView.java class provides a frame to display the availability associated with the doctors in
 * the system. Nurses and patients are redirected to this frame when they select the View Availability button from
 * their respective dash board classes.
 *  
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-16
 */

import java.awt.Font;

/**
 * The DoctorAvailabilityView.java class provides a frame to display the availability associated with a doctor. 
 * Nurses and patients are redirected to this frame from their respective dash board classes. Currently, this class
 * is coded quite poorly. In future iterations, the listing length should be dynamic.
 *  
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-16
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorUnavailabilityView extends JPanel {

	private static final long serialVersionUID = 15L; // serial ID for java object saving

	// labels are initially empty so we have used "_" so that we can see them in the design tab
	JLabel lbl_doc1_date1 = new JLabel("_");
	JLabel lbl_doc1_time1 = new JLabel("_");
	JLabel lbl_doc1_date2 = new JLabel("_");
	JLabel lbl_doc1_time2 = new JLabel("_");
	JLabel lbl_doc1_date3 = new JLabel("_");
	JLabel lbl_doc1_time3 = new JLabel("_");
	JLabel lbl_doc1_date4 = new JLabel("_");
	JLabel lbl_doc1_time4 = new JLabel("_");
	JLabel lbl_doc1_date5 = new JLabel("_");
	JLabel lbl_doc1_time5 = new JLabel("_");

	JLabel lbl_doc2_date1 = new JLabel("_");
	JLabel lbl_doc2_time1 = new JLabel("_");
	JLabel lbl_doc2_date2 = new JLabel("_");
	JLabel lbl_doc2_time2 = new JLabel("_");
	JLabel lbl_doc2_date3 = new JLabel("_");
	JLabel lbl_doc2_time3 = new JLabel("_");
	JLabel lbl_doc2_date4 = new JLabel("_");
	JLabel lbl_doc2_time4 = new JLabel("_");
	JLabel lbl_doc2_date5 = new JLabel("_");
	JLabel lbl_doc2_time5 = new JLabel("_");

	JLabel lbl_doc1 = new JLabel("_");
	JLabel lbl_doc2 = new JLabel("_");
	private final JLabel lblNewLabel = new JLabel("Doctor Unavailabilities");
	private final JButton btn_return = new JButton("Return to Dashboard");

	public DoctorUnavailabilityView(final JFrame frame, final String id, final String usertype) throws Exception {

		setLayout(null);

		refresh();

		lbl_doc1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_doc1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_doc1.setBounds(26, 66, 130, 14);
		add(lbl_doc1);

		lbl_doc1_date1.setBounds(10, 91, 69, 14);
		add(lbl_doc1_date1);

		lbl_doc1_time1.setBounds(111, 91, 69, 14);
		add(lbl_doc1_time1);

		lbl_doc1_date2.setBounds(10, 116, 69, 14);
		add(lbl_doc1_date2);

		lbl_doc1_time2.setBounds(111, 116, 69, 14);
		add(lbl_doc1_time2);

		lbl_doc1_date3.setBounds(10, 141, 69, 14);
		add(lbl_doc1_date3);

		lbl_doc1_time3.setBounds(111, 141, 69, 14);
		add(lbl_doc1_time3);

		lbl_doc1_date4.setBounds(10, 166, 69, 14);
		add(lbl_doc1_date4);

		lbl_doc1_time4.setBounds(111, 166, 69, 14);
		add(lbl_doc1_time4);

		lbl_doc1_date5.setBounds(10, 191, 69, 14);
		add(lbl_doc1_date5);

		lbl_doc1_time5.setBounds(111, 191, 69, 14);
		add(lbl_doc1_time5);

		lbl_doc2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_doc2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_doc2.setBounds(267, 66, 130, 14);
		add(lbl_doc2);

		lbl_doc2_date1.setBounds(257, 91, 69, 14);
		add(lbl_doc2_date1);

		lbl_doc2_time1.setBounds(358, 91, 69, 14);
		add(lbl_doc2_time1);

		lbl_doc2_date2.setBounds(257, 116, 69, 14);
		add(lbl_doc2_date2);

		lbl_doc2_time2.setBounds(358, 116, 69, 14);
		add(lbl_doc2_time2);

		lbl_doc2_date3.setBounds(257, 141, 69, 14);
		add(lbl_doc2_date3);

		lbl_doc2_time3.setBounds(358, 141, 69, 14);
		add(lbl_doc2_time3);

		lbl_doc2_date4.setBounds(257, 166, 69, 14);
		add(lbl_doc2_date4);

		lbl_doc2_time4.setBounds(358, 166, 69, 14);
		add(lbl_doc2_time4);

		lbl_doc2_date5.setBounds(257, 191, 69, 14);
		add(lbl_doc2_date5);

		lbl_doc2_time5.setBounds(358, 191, 69, 14);
		add(lbl_doc2_time5);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(111, 11, 209, 22);

		add(lblNewLabel);
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
		btn_return.setBounds(132, 246, 162, 23);

		add(btn_return);

	} // end constructor

	/**
	 * Method updates the availability date and time fields to display stored values for the current doctors in the
	 * system (two as a test case). Data fields are set to non-visible if record does not contain them.
	 * @param doctorID
	 * @throws Exception
	 */
	private void refresh() throws Exception {

		DoctorUnavailabilityDB doctorUnavailabilityDB = new DoctorUnavailabilityDB();
		doctorUnavailabilityDB = doctorUnavailabilityDB.loadDoctorUnavailabilityDB(); // load saved database file

		// pull the availability records for the 2 doctors (currently implemented in a static fashion)
		CustomArray doctor_avail1 = doctorUnavailabilityDB.search(Integer.toString(1), 0); // doc with id = 1
		CustomArray doctor_avail2 = doctorUnavailabilityDB.search(Integer.toString(2), 0); // doc with id = 2

		DoctorDB doctorDB = new DoctorDB();
		doctorDB = doctorDB.loadDoctorDB(); // load saved database file

		String doc1Name = doctorDB.getDoctorRecord("1")[3];
		String doc2Name = doctorDB.getDoctorRecord("2")[3];
		lbl_doc1.setText("Doctor: " + doc1Name);
		lbl_doc2.setText("Doctor: " + doc2Name);

		int case_num1 = doctor_avail1.size();
		int case_num2 = doctor_avail2.size();

		// 5 cases correspond to currently maximum of 5 days of allowed for doctor availability
		switch (case_num1) {

		case 0:
			lbl_doc1_date1.setVisible(false);
			lbl_doc1_time1.setVisible(false);
			lbl_doc1_date2.setVisible(false);
			lbl_doc1_time2.setVisible(false);
			lbl_doc1_date3.setVisible(false);
			lbl_doc1_time3.setVisible(false);
			lbl_doc1_date4.setVisible(false);
			lbl_doc1_time4.setVisible(false);
			lbl_doc1_date5.setVisible(false);
			lbl_doc1_time5.setVisible(false);
			break;
		case 1:
			lbl_doc1_date1.setVisible(true);
			lbl_doc1_date1.setText(doctor_avail1.get(0).getCustomElement()[1]);
			lbl_doc1_time1.setVisible(true);
			lbl_doc1_time1.setText(doctor_avail1.get(0).getCustomElement()[2]);
			lbl_doc1_date2.setVisible(false);
			lbl_doc1_time2.setVisible(false);
			lbl_doc1_date3.setVisible(false);
			lbl_doc1_time3.setVisible(false);
			lbl_doc1_date4.setVisible(false);
			lbl_doc1_time4.setVisible(false);
			lbl_doc1_date5.setVisible(false);
			lbl_doc1_time5.setVisible(false);
			break;
		case 2:
			lbl_doc1_date1.setVisible(true);
			lbl_doc1_date1.setText(doctor_avail1.get(0).getCustomElement()[1]);
			lbl_doc1_time1.setVisible(true);
			lbl_doc1_time1.setText(doctor_avail1.get(0).getCustomElement()[2]);
			lbl_doc1_date2.setVisible(true);
			lbl_doc1_date2.setText(doctor_avail1.get(1).getCustomElement()[1]);
			lbl_doc1_time2.setVisible(true);
			lbl_doc1_time2.setText(doctor_avail1.get(1).getCustomElement()[2]);
			lbl_doc1_date3.setVisible(false);
			lbl_doc1_time3.setVisible(false);
			lbl_doc1_date4.setVisible(false);
			lbl_doc1_time4.setVisible(false);
			lbl_doc1_date5.setVisible(false);
			lbl_doc1_time5.setVisible(false);
			break;
		case 3:
			lbl_doc1_date1.setVisible(true);
			lbl_doc1_date1.setText(doctor_avail1.get(0).getCustomElement()[1]);
			lbl_doc1_time1.setVisible(true);
			lbl_doc1_time1.setText(doctor_avail1.get(0).getCustomElement()[2]);
			lbl_doc1_date2.setVisible(true);
			lbl_doc1_date2.setText(doctor_avail1.get(1).getCustomElement()[1]);
			lbl_doc1_time2.setVisible(true);
			lbl_doc1_time2.setText(doctor_avail1.get(1).getCustomElement()[2]);
			lbl_doc1_date3.setVisible(true);
			lbl_doc1_date3.setText(doctor_avail1.get(2).getCustomElement()[1]);
			lbl_doc1_time3.setVisible(true);
			lbl_doc1_time3.setText(doctor_avail1.get(2).getCustomElement()[2]);
			lbl_doc1_date4.setVisible(false);
			lbl_doc1_time4.setVisible(false);
			lbl_doc1_date5.setVisible(false);
			lbl_doc1_time5.setVisible(false);
			break;
		case 4:
			lbl_doc1_date1.setVisible(true);
			lbl_doc1_date1.setText(doctor_avail1.get(0).getCustomElement()[1]);
			lbl_doc1_time1.setVisible(true);
			lbl_doc1_time1.setText(doctor_avail1.get(0).getCustomElement()[2]);
			lbl_doc1_date2.setVisible(true);
			lbl_doc1_date2.setText(doctor_avail1.get(1).getCustomElement()[1]);
			lbl_doc1_time2.setVisible(true);
			lbl_doc1_time2.setText(doctor_avail1.get(1).getCustomElement()[2]);
			lbl_doc1_date3.setVisible(true);
			lbl_doc1_date3.setText(doctor_avail1.get(2).getCustomElement()[1]);
			lbl_doc1_time3.setVisible(true);
			lbl_doc1_time3.setText(doctor_avail1.get(2).getCustomElement()[2]);
			lbl_doc1_date4.setVisible(true);
			lbl_doc1_date4.setText(doctor_avail1.get(3).getCustomElement()[1]);
			lbl_doc1_time4.setVisible(true);
			lbl_doc1_time4.setText(doctor_avail1.get(3).getCustomElement()[2]);
			lbl_doc1_date5.setVisible(false);
			lbl_doc1_time5.setVisible(false);
			break;
		case 5:
			lbl_doc1_date1.setVisible(true);
			lbl_doc1_date1.setText(doctor_avail1.get(0).getCustomElement()[1]);
			lbl_doc1_time1.setVisible(true);
			lbl_doc1_time1.setText(doctor_avail1.get(0).getCustomElement()[2]);
			lbl_doc1_date2.setVisible(true);
			lbl_doc1_date2.setText(doctor_avail1.get(1).getCustomElement()[1]);
			lbl_doc1_time2.setVisible(true);
			lbl_doc1_time2.setText(doctor_avail1.get(1).getCustomElement()[2]);
			lbl_doc1_date3.setVisible(true);
			lbl_doc1_date3.setText(doctor_avail1.get(2).getCustomElement()[1]);
			lbl_doc1_time3.setVisible(true);
			lbl_doc1_time3.setText(doctor_avail1.get(2).getCustomElement()[2]);
			lbl_doc1_date4.setVisible(true);
			lbl_doc1_date4.setText(doctor_avail1.get(3).getCustomElement()[1]);
			lbl_doc1_time4.setVisible(true);
			lbl_doc1_time4.setText(doctor_avail1.get(3).getCustomElement()[2]);
			lbl_doc1_date5.setVisible(true);
			lbl_doc1_date5.setText(doctor_avail1.get(4).getCustomElement()[1]);
			lbl_doc1_time5.setVisible(true);
			lbl_doc1_time5.setText(doctor_avail1.get(4).getCustomElement()[2]);
			break;

		} // end switch

		switch (case_num2) {

		case 0:
			lbl_doc2_date1.setVisible(false);
			lbl_doc2_time1.setVisible(false);
			lbl_doc2_date2.setVisible(false);
			lbl_doc2_time2.setVisible(false);
			lbl_doc2_date3.setVisible(false);
			lbl_doc2_time3.setVisible(false);
			lbl_doc2_date4.setVisible(false);
			lbl_doc2_time4.setVisible(false);
			lbl_doc2_date5.setVisible(false);
			lbl_doc2_time5.setVisible(false);
			break;
		case 1:
			lbl_doc2_date1.setVisible(true);
			lbl_doc2_date1.setText(doctor_avail2.get(0).getCustomElement()[1]);
			lbl_doc2_time1.setVisible(true);
			lbl_doc2_time1.setText(doctor_avail2.get(0).getCustomElement()[2]);
			lbl_doc2_date2.setVisible(false);
			lbl_doc2_time2.setVisible(false);
			lbl_doc2_date3.setVisible(false);
			lbl_doc2_time3.setVisible(false);
			lbl_doc2_date4.setVisible(false);
			lbl_doc2_time4.setVisible(false);
			lbl_doc2_date5.setVisible(false);
			lbl_doc2_time5.setVisible(false);
			break;
		case 2:
			lbl_doc2_date1.setVisible(true);
			lbl_doc2_date1.setText(doctor_avail2.get(0).getCustomElement()[1]);
			lbl_doc2_time1.setVisible(true);
			lbl_doc2_time1.setText(doctor_avail2.get(0).getCustomElement()[2]);
			lbl_doc2_date2.setVisible(true);
			lbl_doc2_date2.setText(doctor_avail2.get(1).getCustomElement()[1]);
			lbl_doc2_time2.setVisible(true);
			lbl_doc2_time2.setText(doctor_avail2.get(1).getCustomElement()[2]);
			lbl_doc2_date3.setVisible(false);
			lbl_doc2_time3.setVisible(false);
			lbl_doc2_date4.setVisible(false);
			lbl_doc2_time4.setVisible(false);
			lbl_doc2_date5.setVisible(false);
			lbl_doc2_time5.setVisible(false);
			break;
		case 3:
			lbl_doc2_date1.setVisible(true);
			lbl_doc2_date1.setText(doctor_avail2.get(0).getCustomElement()[1]);
			lbl_doc2_time1.setVisible(true);
			lbl_doc2_time1.setText(doctor_avail2.get(0).getCustomElement()[2]);
			lbl_doc2_date2.setVisible(true);
			lbl_doc2_date2.setText(doctor_avail2.get(1).getCustomElement()[1]);
			lbl_doc2_time2.setVisible(true);
			lbl_doc2_time2.setText(doctor_avail2.get(1).getCustomElement()[2]);
			lbl_doc2_date3.setVisible(true);
			lbl_doc2_date3.setText(doctor_avail2.get(2).getCustomElement()[1]);
			lbl_doc2_time3.setVisible(true);
			lbl_doc2_time3.setText(doctor_avail2.get(2).getCustomElement()[2]);
			lbl_doc2_date4.setVisible(false);
			lbl_doc2_time4.setVisible(false);
			lbl_doc2_date5.setVisible(false);
			lbl_doc2_time5.setVisible(false);
			break;
		case 4:
			lbl_doc2_date1.setVisible(true);
			lbl_doc2_date1.setText(doctor_avail2.get(0).getCustomElement()[1]);
			lbl_doc2_time1.setVisible(true);
			lbl_doc2_time1.setText(doctor_avail2.get(0).getCustomElement()[2]);
			lbl_doc2_date2.setVisible(true);
			lbl_doc2_date2.setText(doctor_avail2.get(1).getCustomElement()[1]);
			lbl_doc2_time2.setVisible(true);
			lbl_doc2_time2.setText(doctor_avail2.get(1).getCustomElement()[2]);
			lbl_doc2_date3.setVisible(true);
			lbl_doc2_date3.setText(doctor_avail2.get(2).getCustomElement()[1]);
			lbl_doc2_time3.setVisible(true);
			lbl_doc2_time3.setText(doctor_avail2.get(2).getCustomElement()[2]);
			lbl_doc2_date4.setVisible(true);
			lbl_doc2_date4.setText(doctor_avail2.get(3).getCustomElement()[1]);
			lbl_doc2_time4.setVisible(true);
			lbl_doc2_time4.setText(doctor_avail2.get(3).getCustomElement()[2]);
			lbl_doc2_date5.setVisible(false);
			lbl_doc2_time5.setVisible(false);
			break;
		case 5:
			lbl_doc2_date1.setVisible(true);
			lbl_doc2_date1.setText(doctor_avail2.get(0).getCustomElement()[1]);
			lbl_doc2_time1.setVisible(true);
			lbl_doc2_time1.setText(doctor_avail2.get(0).getCustomElement()[2]);
			lbl_doc2_date2.setVisible(true);
			lbl_doc2_date2.setText(doctor_avail2.get(1).getCustomElement()[1]);
			lbl_doc2_time2.setVisible(true);
			lbl_doc2_time2.setText(doctor_avail2.get(1).getCustomElement()[2]);
			lbl_doc2_date3.setVisible(true);
			lbl_doc2_date3.setText(doctor_avail2.get(2).getCustomElement()[1]);
			lbl_doc2_time3.setVisible(true);
			lbl_doc2_time3.setText(doctor_avail2.get(2).getCustomElement()[2]);
			lbl_doc2_date4.setVisible(true);
			lbl_doc2_date4.setText(doctor_avail2.get(3).getCustomElement()[1]);
			lbl_doc2_time4.setVisible(true);
			lbl_doc2_time4.setText(doctor_avail2.get(3).getCustomElement()[2]);
			lbl_doc2_date5.setVisible(true);
			lbl_doc2_date5.setText(doctor_avail2.get(4).getCustomElement()[1]);
			lbl_doc2_time5.setVisible(true);
			lbl_doc2_time5.setText(doctor_avail2.get(4).getCustomElement()[2]);
			break;

		} // end switch

	} // end refresh()

} // end class DoctorUnavailabilityView
