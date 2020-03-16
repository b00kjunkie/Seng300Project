package iteration2;

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
import java.awt.Color;

public class DoctorSetting extends JPanel {

	public DoctorSetting(final JFrame frame, final DoctorAuth auth) {
		setBackground(Color.GRAY);
		
		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DoctorChangePassword panel = new DoctorChangePassword(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnUpdateInformation = new JButton("Customize Profile");
		btnUpdateInformation.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DoctorInfo panel = new DoctorInfo(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DoctorLoggedIn panel = new DoctorLoggedIn(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(116, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblSettings)
							.addGap(179))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnUpdateInformation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
							.addGap(110))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnBack)
							.addGap(196))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(lblSettings)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(30)
					.addComponent(btnUpdateInformation)
					.addGap(35)
					.addComponent(btnBack)
					.addGap(83))
		);
		setLayout(groupLayout);

	}
}