package i_thread;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.Date;
import java.awt.Color;

public class StopWatchThread extends JPanel implements Runnable{
	boolean stop = false;
	private JLabel timeLabel;

	/**
	 * Create the panel.
	 */
	public StopWatchThread() {
		setLayout(new BorderLayout(0, 0));
		add(getLblNewLabel(), BorderLayout.CENTER);
		
	}

	@Override
	public void run() {
		DecimalFormat df = new DecimalFormat("###,###.000");
		long begin = new Date().getTime();
		while(!stop) {
			long end = new Date().getTime()-begin;
			try {
				Thread.sleep(1);
			}catch(Exception ex) {}
			timeLabel.setText(df.format(end/1000.0));
		}
		
	}
	private JLabel getLblNewLabel() {
		if (timeLabel == null) {
			timeLabel = new JLabel("stop watch");
			timeLabel.setForeground(new Color(255, 215, 0));
			timeLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		}
		
		return timeLabel;
	}
}
