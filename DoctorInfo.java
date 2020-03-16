package iteration2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class DoctorInfo extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public DoctorInfo(final JFrame frame, final DoctorAuth auth) {
		setBackground(Color.GRAY);
		
		JLabel lblFullName = new JLabel("Last Name:");
		
		JLabel lblGender = new JLabel("Gender:");
		
		JLabel lblDepartment = new JLabel("Department:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DoctorSetting panel = new DoctorSetting(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DoctorSetting panel = new DoctorSetting(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		
		JLabel lblNewLinabel = new JLabel("Information");
		lblNewLinabel.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("First Name:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(210)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnSave, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBack, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(70)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDepartment)
								.addComponent(lblFullName)
								.addComponent(lblNewLabel)
								.addComponent(lblGender))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_2)
								.addComponent(textField_1)
								.addComponent(textField_3)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(77, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(188, Short.MAX_VALUE)
					.addComponent(lblNewLinabel)
					.addGap(154))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(lblNewLinabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFullName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(btnSave)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBack))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblDepartment)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(42))
		);
		setLayout(groupLayout);

	}
}