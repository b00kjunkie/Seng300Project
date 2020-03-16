package iteration2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class DoctorLoggedIn extends JPanel {

	public DoctorLoggedIn(final JFrame frame, final DoctorAuth auth) {
		setBackground(Color.GRAY);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DoctorSetting panel = new DoctorSetting(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DoctorLogin panel = new DoctorLogin(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(188)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLogOut, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
						.addComponent(btnSettings, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(187))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(169, Short.MAX_VALUE)
					.addComponent(btnSettings)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogOut)
					.addGap(79))
		);
		setLayout(groupLayout);

	}
}