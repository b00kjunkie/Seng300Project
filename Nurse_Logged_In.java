package iteration_2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.LayoutStyle.ComponentPlacement;

public class Nurse_Logged_In extends JPanel {

	/**
	 * Create the panel.
	 */
	public Nurse_Logged_In(final JFrame frame, final Nurse_Auth auth) {
		
		JButton btnSettings = new JButton("Settings ");
		btnSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Nurse_Settings panel = new Nurse_Settings(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Nurse_Login panel = new Nurse_Login(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(175)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogOut)
						.addComponent(btnSettings))
					.addContainerGap(186, Short.MAX_VALUE))
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
