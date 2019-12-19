package h_api;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class SimpleDateExam extends JInternalFrame {
	private JButton btnNewButton;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleDateExam frame = new SimpleDateExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleDateExam() {
		super("SimpleDateFormat", false, true, true,true);
		setVisible(true);
		setBounds(100, 100, 450, 174);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getStatus());

	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC624\uB298 \uB0A0\uC9DC");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Date now = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd (E)요일 hh:mm:ss");
				
					status.setText(sdf.format(now));
				}
			});
			btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			btnNewButton.setBounds(12, 10, 117, 23);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			status.setBounds(12, 43, 410, 78);
		}
		return status;
	}
}
