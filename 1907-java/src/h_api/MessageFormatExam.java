package h_api;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MessageFormatExam extends JFrame {

	private JDesktopPane contentPane; // Jpanel¿ª JDesktopPane¿∏∑Œ πŸ≤ﬁ
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageFormatExam frame = new MessageFormatExam();
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
	public MessageFormatExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 472);
		setJMenuBar(getMenuBar_1());
		contentPane = new JDesktopPane(); // ¿ßø° ∞¥√º∏¶ Panel¿ª DesktopPane∑Œ πŸ≤ﬁ
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Format");
			mnNewMenu.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem_2());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Decimal");
			mntmNewMenuItem.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DecimalFormatExam exam = new DecimalFormatExam();
					contentPane.add(exam);
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("Simple Date");
			mntmNewMenuItem_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SimpleDateExam exam = new SimpleDateExam();
					contentPane.add(exam);
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("Message");
			mntmNewMenuItem_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MessageExam exam = new MessageExam();
					contentPane.add(exam);
				}
			});
		}
		return mntmNewMenuItem_2;
	}
}
