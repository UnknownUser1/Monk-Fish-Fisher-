package ikovfisherancooker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Gui() {
		initComponents();
	}

	private void button_runActionPerformed(ActionEvent e) {
		setVisible(false);
	}

	private void initComponents() {
		label1 = new JLabel();
		checkBox_cookFish = new JCheckBox();
		checkBox_login = new JCheckBox();
		button_run = new JButton();
		label2 = new JLabel();
		label3 = new JLabel();

		// ======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// ---- label1 ----
		label1.setText("Monk Fisher && Cooker");
		label1.setFont(new Font("Tekton Pro", Font.BOLD, 15));
		contentPane.add(label1);
		label1.setBounds(5, 5, 155, label1.getPreferredSize().height);

		// ---- checkBox_cookFish ----
		checkBox_cookFish.setText("Cook Fish");
		checkBox_cookFish.setEnabled(false);
		contentPane.add(checkBox_cookFish);
		checkBox_cookFish.setBounds(10, 40, 120,
				checkBox_cookFish.getPreferredSize().height);

		// ---- checkBox_login ----
		checkBox_login.setText("Relogin");
		contentPane.add(checkBox_login);
		checkBox_login.setBounds(10, 75, 80,
				checkBox_login.getPreferredSize().height);

		// ---- button_run ----
		button_run.setText("Run");
		button_run.addActionListener(e -> button_runActionPerformed(e));
		contentPane.add(button_run);
		button_run.setBounds(0, 115, 145, 30);

		// ---- label2 ----
		label2.setText("Made By");
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(10, 160), label2
				.getPreferredSize()));

		// ---- label3 ----
		label3.setText("Unknownuser");
		contentPane.add(label3);
		label3.setBounds(new Rectangle(new Point(15, 180), label3
				.getPreferredSize()));

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for (int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width,
						preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height,
						preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());
	}

	private JLabel label1;
	public static JCheckBox checkBox_cookFish;
	public static JCheckBox checkBox_login;
	private JButton button_run;
	private JLabel label2;
	private JLabel label3;

}
