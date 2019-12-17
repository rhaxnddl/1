package h_api2;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Main extends JPanel {
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public Main() {
		setLayout(new BorderLayout(0, 0));
		add(getLblNewLabel(), BorderLayout.CENTER);

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\JHTA\\Desktop\\3.jpg"));
		}
		return lblNewLabel;
	}
}
