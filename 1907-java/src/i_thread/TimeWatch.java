package i_thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TimeWatch extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel labelTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeWatch frame = new TimeWatch();
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
	
	
	public TimeWatch() {
		setBackground(SystemColor.info);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPanel());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getLabelTime());
		
		DateTimeThread dtt = new DateTimeThread(labelTime);
		dtt.setDaemon(true);
		dtt.start();
		
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC2DC\uACC4");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(255, 215, 0));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
			lblNewLabel.setBounds(166, 10, 85, 27);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC2A4\uD1B1\uC6CC\uCE58");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.setBackground(new Color(255, 215, 0));
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
			lblNewLabel_1.setBounds(154, 112, 108, 27);
		}
		return lblNewLabel_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new StopWatchThread();
			panel.setBackground(new Color(255, 235, 205));
			panel.setBounds(12, 145, 410, 62);
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("START");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			btnNewButton.setBackground(new Color(255, 215, 0));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StopWatchThread st = (StopWatchThread)panel;
					st.stop = false;
					Thread t = new Thread(st);
					t.setDaemon(true);
					t.start();
				}
			});
			btnNewButton.setBounds(94, 217, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("STOP");
			btnNewButton_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			btnNewButton_1.setBackground(new Color(255, 215, 0));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StopWatchThread st = (StopWatchThread)panel;
					st.stop = true;					
				}

			});
			btnNewButton_1.setBounds(235, 217, 97, 23);
		}
		return btnNewButton_1;
	}
	private JLabel getLabelTime() {
		if (labelTime == null) {
			labelTime = new JLabel("");
			labelTime.setBackground(new Color(255, 239, 213));
			labelTime.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
			labelTime.setOpaque(true);
			labelTime.setForeground(new Color(255, 215, 0));
			labelTime.setBounds(12, 43, 410, 59);
		}
		return labelTime;
	}
}
