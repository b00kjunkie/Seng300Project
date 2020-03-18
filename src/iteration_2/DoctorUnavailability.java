package iteration_2;

/**
 * The DoctorUnavailability.java class provides a frame to display and edit the availability associated with a doctor. 
 * Doctors are redirected to this frame from the DoctorDashboard class.
 *  
 * @author		SENG 300 Group 12 - Winter 2020
 * Date:		2020-03-16
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class DoctorUnavailability extends JPanel {

	private static final long serialVersionUID = 12L; // serial ID for java object saving
	private JTextField txt_add_date;
	private JTextField txt_add_time;

	// labels are initially empty so we have used "_" so that we can see them in the design tab
	JLabel lbl_date1_val = new JLabel("_");
	JLabel lbl_time1_val = new JLabel("_");
	JLabel lbl_time2_val = new JLabel("_");
	JLabel lbl_date2_val = new JLabel("_");
	JLabel lbl_time3_val = new JLabel("_");
	JLabel lbl_date3_val = new JLabel("_");
	JLabel lbl_time4_val = new JLabel("_");
	JLabel lbl_date4_val = new JLabel("_");
	JLabel lbl_time5_val = new JLabel("_");
	JLabel lbl_date5_val = new JLabel("_");

	JButton btn_remove1 = new JButton("Remove");
	JButton btn_remove2 = new JButton("Remove");
	JButton btn_remove3 = new JButton("Remove");
	JButton btn_remove4 = new JButton("Remove");
	JButton btn_remove5 = new JButton("Remove");

	JLabel lbl_cannot_add = new JLabel("Maximum 5 Entries. Did not add.");

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public DoctorUnavailability(final JFrame frame, final String doctorID) throws Exception {

		setLayout(null);

		refresh(doctorID);

		JLabel lbl_avail_header = new JLabel("Day & Time Unavailable");
		lbl_avail_header.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_avail_header.setBounds(119, 11, 221, 28);
		add(lbl_avail_header);

		JButton btn_back = new JButton("Back");
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

		btn_back.setBounds(351, 266, 89, 23);
		add(btn_back);

		lbl_date1_val.setBounds(33, 78, 75, 14);
		add(lbl_date1_val);

		lbl_time1_val.setBounds(132, 78, 62, 14);
		add(lbl_time1_val);

		lbl_time2_val.setBounds(132, 107, 62, 14);
		add(lbl_time2_val);

		lbl_date2_val.setBounds(33, 107, 75, 14);
		add(lbl_date2_val);

		lbl_time3_val.setBounds(132, 136, 62, 14);
		add(lbl_time3_val);

		lbl_date3_val.setBounds(33, 136, 75, 14);
		add(lbl_date3_val);

		lbl_time4_val.setBounds(132, 165, 62, 14);
		add(lbl_time4_val);

		lbl_date4_val.setBounds(33, 165, 75, 14);
		add(lbl_date4_val);

		lbl_time5_val.setBounds(132, 194, 62, 14);
		add(lbl_time5_val);

		lbl_date5_val.setBounds(33, 194, 75, 14);
		add(lbl_date5_val);

		lbl_cannot_add.setVisible(false);
		lbl_cannot_add.setForeground(Color.RED);
		lbl_cannot_add.setBounds(233, 44, 184, 14);
		add(lbl_cannot_add);

		JLabel lbl_date_column = new JLabel("Date");
		lbl_date_column.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_date_column.setBounds(34, 44, 44, 23);
		add(lbl_date_column);

		JLabel lbl_time_column = new JLabel("Time");
		lbl_time_column.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_time_column.setBounds(129, 48, 46, 14);
		add(lbl_time_column);

		btn_remove1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DoctorUnavailabilityDB doctUnavailDB = new DoctorUnavailabilityDB();
					doctUnavailDB = doctUnavailDB.loadDoctorUnavailabilityDB(); // load saved database file
					doctUnavailDB.remove(0);
					doctUnavailDB.saveDoctorUnavailabilityDB();
					lbl_cannot_add.setVisible(false);
					refresh(doctorID);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btn_remove1.setBounds(232, 74, 89, 23);
		add(btn_remove1);

		btn_remove2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DoctorUnavailabilityDB doctUnavailDB = new DoctorUnavailabilityDB();
					doctUnavailDB = doctUnavailDB.loadDoctorUnavailabilityDB(); // load saved database file
					doctUnavailDB.remove(1);
					doctUnavailDB.saveDoctorUnavailabilityDB();
					lbl_cannot_add.setVisible(false);
					refresh(doctorID);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_remove2.setBounds(232, 103, 89, 23);
		add(btn_remove2);

		btn_remove3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DoctorUnavailabilityDB doctUnavailDB = new DoctorUnavailabilityDB();
					doctUnavailDB = doctUnavailDB.loadDoctorUnavailabilityDB(); // load saved database file
					doctUnavailDB.remove(2);
					doctUnavailDB.saveDoctorUnavailabilityDB();
					lbl_cannot_add.setVisible(false);
					refresh(doctorID);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_remove3.setBounds(232, 132, 89, 23);
		add(btn_remove3);

		btn_remove4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DoctorUnavailabilityDB doctUnavailDB = new DoctorUnavailabilityDB();
					doctUnavailDB = doctUnavailDB.loadDoctorUnavailabilityDB(); // load saved database file
					doctUnavailDB.remove(3);
					doctUnavailDB.saveDoctorUnavailabilityDB();
					lbl_cannot_add.setVisible(false);
					refresh(doctorID);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_remove4.setBounds(232, 161, 89, 23);
		add(btn_remove4);

		btn_remove5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DoctorUnavailabilityDB doctUnavailDB = new DoctorUnavailabilityDB();
					doctUnavailDB = doctUnavailDB.loadDoctorUnavailabilityDB(); // load saved database file
					doctUnavailDB.remove(4);
					doctUnavailDB.saveDoctorUnavailabilityDB();
					lbl_cannot_add.setVisible(false);
					refresh(doctorID);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_remove5.setBounds(232, 190, 89, 23);
		add(btn_remove5);

		JLabel lbl_add_column = new JLabel("Add New");
		lbl_add_column.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_add_column.setBounds(33, 219, 75, 14);
		add(lbl_add_column);

		txt_add_date = new JTextField();
		txt_add_date.setBounds(33, 244, 75, 20);
		add(txt_add_date);
		txt_add_date.setColumns(10);

		txt_add_time = new JTextField();
		txt_add_time.setBounds(132, 244, 75, 20);
		add(txt_add_time);
		txt_add_time.setColumns(10);

		JButton btn_add = new JButton("Add");
		btn_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String new_date = txt_add_date.getText();
				String new_time = txt_add_time.getText();

				try {
					DoctorUnavailabilityDB doctUnavailDB = new DoctorUnavailabilityDB();
					doctUnavailDB = doctUnavailDB.loadDoctorUnavailabilityDB(); // load saved database file
					CustomArray docAvailList = doctUnavailDB.search(doctorID, 0);
					System.out.println("DocAvail " + docAvailList.size());
					if (docAvailList.size() < 5) {
						doctUnavailDB.add(new String[] { doctorID, new_date, new_time });
						doctUnavailDB.saveDoctorUnavailabilityDB();

						refresh(doctorID);
					} else {
						lbl_cannot_add.setVisible(true);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		btn_add.setBounds(232, 243, 89, 23);
		add(btn_add);

		JLabel lbl_new_date = new JLabel("Date");
		lbl_new_date.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_new_date.setBounds(33, 270, 75, 19);
		add(lbl_new_date);

		JLabel lbl_new_time = new JLabel("Time");
		lbl_new_time.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_new_time.setBounds(132, 270, 75, 19);
		add(lbl_new_time);

	} // end DoctorAvailability constructor

	/**
	 * Method updates the availability date and time fields to display stored values for the current doctor, identified
	 * by Jframe parameter doctor ID. Data fields are set to non-visible if record does not contain them.
	 * 
	 * @throws Exception
	 * 
	 */
	private void refresh(String doctorID) throws Exception {

		DoctorUnavailabilityDB doctorUnavailabilityDB = new DoctorUnavailabilityDB();
		doctorUnavailabilityDB = doctorUnavailabilityDB.loadDoctorUnavailabilityDB(); // load saved database file

		// pull the availability records that have the matching doctorID
		CustomArray doctor_avail = doctorUnavailabilityDB.search(doctorID, 0);

		int case_num = doctor_avail.size();

		// currently the system permits a max of 5 doctor requested days off, hence 5 case values
		switch (case_num) {

		case 0:
			lbl_date1_val.setVisible(false);
			lbl_time1_val.setVisible(false);
			lbl_time2_val.setVisible(false);
			lbl_date2_val.setVisible(false);
			lbl_time3_val.setVisible(false);
			lbl_date3_val.setVisible(false);
			lbl_time4_val.setVisible(false);
			lbl_date4_val.setVisible(false);
			lbl_time5_val.setVisible(false);
			lbl_date5_val.setVisible(false);
			btn_remove1.setVisible(false);
			btn_remove2.setVisible(false);
			btn_remove3.setVisible(false);
			btn_remove4.setVisible(false);
			btn_remove5.setVisible(false);
			break;
		case 1:
			lbl_date1_val.setText(doctor_avail.get(0).getCustomElement()[1]);
			lbl_date1_val.setVisible(true);
			lbl_time1_val.setText(doctor_avail.get(0).getCustomElement()[2]);
			lbl_time1_val.setVisible(true);
			btn_remove1.setVisible(true);
			lbl_time2_val.setVisible(false);
			lbl_date2_val.setVisible(false);
			lbl_time3_val.setVisible(false);
			lbl_date3_val.setVisible(false);
			lbl_time4_val.setVisible(false);
			lbl_date4_val.setVisible(false);
			lbl_time5_val.setVisible(false);
			lbl_date5_val.setVisible(false);
			btn_remove2.setVisible(false);
			btn_remove3.setVisible(false);
			btn_remove4.setVisible(false);
			btn_remove5.setVisible(false);
			break;
		case 2:
			lbl_date1_val.setText(doctor_avail.get(0).getCustomElement()[1]);
			lbl_date1_val.setVisible(true);
			lbl_time1_val.setText(doctor_avail.get(0).getCustomElement()[2]);
			lbl_time1_val.setVisible(true);
			lbl_date2_val.setText(doctor_avail.get(1).getCustomElement()[1]);
			lbl_date2_val.setVisible(true);
			lbl_time2_val.setText(doctor_avail.get(1).getCustomElement()[2]);
			lbl_time2_val.setVisible(true);
			btn_remove1.setVisible(true);
			btn_remove2.setVisible(true);
			lbl_time3_val.setVisible(false);
			lbl_date3_val.setVisible(false);
			lbl_time4_val.setVisible(false);
			lbl_date4_val.setVisible(false);
			lbl_time5_val.setVisible(false);
			lbl_date5_val.setVisible(false);
			btn_remove3.setVisible(false);
			btn_remove4.setVisible(false);
			btn_remove5.setVisible(false);
			break;
		case 3:
			lbl_date1_val.setText(doctor_avail.get(0).getCustomElement()[1]);
			lbl_date1_val.setVisible(true);
			lbl_time1_val.setText(doctor_avail.get(0).getCustomElement()[2]);
			lbl_time1_val.setVisible(true);
			lbl_date2_val.setText(doctor_avail.get(1).getCustomElement()[1]);
			lbl_date2_val.setVisible(true);
			lbl_time2_val.setText(doctor_avail.get(1).getCustomElement()[2]);
			lbl_time2_val.setVisible(true);
			lbl_date3_val.setText(doctor_avail.get(2).getCustomElement()[1]);
			lbl_date3_val.setVisible(true);
			lbl_time3_val.setText(doctor_avail.get(2).getCustomElement()[2]);
			lbl_time3_val.setVisible(true);
			btn_remove1.setVisible(true);
			btn_remove2.setVisible(true);
			btn_remove3.setVisible(true);
			lbl_time4_val.setVisible(false);
			lbl_date4_val.setVisible(false);
			lbl_time5_val.setVisible(false);
			lbl_date5_val.setVisible(false);
			btn_remove4.setVisible(false);
			btn_remove5.setVisible(false);
			break;
		case 4:
			lbl_date1_val.setText(doctor_avail.get(0).getCustomElement()[1]);
			lbl_date1_val.setVisible(true);
			lbl_time1_val.setText(doctor_avail.get(0).getCustomElement()[2]);
			lbl_time1_val.setVisible(true);
			lbl_date2_val.setText(doctor_avail.get(1).getCustomElement()[1]);
			lbl_date2_val.setVisible(true);
			lbl_time2_val.setText(doctor_avail.get(1).getCustomElement()[2]);
			lbl_time2_val.setVisible(true);
			lbl_date3_val.setText(doctor_avail.get(2).getCustomElement()[1]);
			lbl_date3_val.setVisible(true);
			lbl_time3_val.setText(doctor_avail.get(2).getCustomElement()[2]);
			lbl_time3_val.setVisible(true);
			lbl_date4_val.setText(doctor_avail.get(3).getCustomElement()[1]);
			lbl_date4_val.setVisible(true);
			lbl_time4_val.setText(doctor_avail.get(3).getCustomElement()[2]);
			lbl_time4_val.setVisible(true);
			btn_remove1.setVisible(true);
			btn_remove2.setVisible(true);
			btn_remove3.setVisible(true);
			btn_remove4.setVisible(true);
			lbl_time5_val.setVisible(false);
			lbl_date5_val.setVisible(false);
			btn_remove5.setVisible(false);
			break;
		case 5:
			lbl_date1_val.setText(doctor_avail.get(0).getCustomElement()[1]);
			lbl_date1_val.setVisible(true);
			lbl_time1_val.setText(doctor_avail.get(0).getCustomElement()[2]);
			lbl_time1_val.setVisible(true);
			lbl_date2_val.setText(doctor_avail.get(1).getCustomElement()[1]);
			lbl_date2_val.setVisible(true);
			lbl_time2_val.setText(doctor_avail.get(1).getCustomElement()[2]);
			lbl_time2_val.setVisible(true);
			lbl_date3_val.setText(doctor_avail.get(2).getCustomElement()[1]);
			lbl_date3_val.setVisible(true);
			lbl_time3_val.setText(doctor_avail.get(2).getCustomElement()[2]);
			lbl_time3_val.setVisible(true);
			lbl_date4_val.setText(doctor_avail.get(3).getCustomElement()[1]);
			lbl_date4_val.setVisible(true);
			lbl_time4_val.setText(doctor_avail.get(3).getCustomElement()[2]);
			lbl_time4_val.setVisible(true);
			lbl_date5_val.setText(doctor_avail.get(4).getCustomElement()[1]);
			lbl_date5_val.setVisible(true);
			lbl_time5_val.setText(doctor_avail.get(4).getCustomElement()[2]);
			lbl_time5_val.setVisible(true);
			btn_remove1.setVisible(true);
			btn_remove2.setVisible(true);
			btn_remove3.setVisible(true);
			btn_remove4.setVisible(true);
			btn_remove5.setVisible(true);
			break;

		} // end switch

	} // end refresh

} // end class DoctorUavailability
