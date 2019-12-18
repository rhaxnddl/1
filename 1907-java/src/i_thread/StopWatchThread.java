package i_thread;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class StopWatchThread extends JPanel implements Runnable{
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public StopWatchThread() {
		setLayout(new BorderLayout(0, 0));
		add(getLblNewLabel(), BorderLayout.CENTER);
		
	}

	@Override
	public void run() {
		
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("stop watch");
		}
		
		return lblNewLabel;
	}
}
