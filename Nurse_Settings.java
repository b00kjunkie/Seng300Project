package iteration_2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Nurse_Settings extends JPanel {

	/**
	 * Create the panel.
	 */
	public Nurse_Settings(final JFrame frame, final Nurse_Auth auth) {
		
		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Nurse_Change_Password panel = new Nurse_Change_Password(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JButton btnUpdateInformation = new JButton("Update Information");
		btnUpdateInformation.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Nurse_Information panel = new Nurse_Information(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Nurse_Logged_In panel = new Nurse_Logged_In(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(167)
							.addComponent(lblSettings))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(158)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnUpdateInformation)
								.addComponent(btnNewButton))))
					.addContainerGap(165, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(361, Short.MAX_VALUE)
					.addComponent(btnBack))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSettings)
					.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUpdateInformation)
					.addGap(23)
					.addComponent(btnBack))
		);
		setLayout(groupLayout);

	}
}
