package h_api;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class DecimalFormatExam extends JInternalFrame {
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DecimalFormatExam frame = new DecimalFormatExam();
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
	public DecimalFormatExam() {
		super("Decimal Format", false, true, true, true);
		
		setTitle("Decimal Format");
		setBounds(100, 100, 367, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getScrollPane());
		setVisible(true);

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC785\uAE08\uC561");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			lblNewLabel.setBounds(12, 10, 65, 21);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(81, 7, 256, 24);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCC9C \uB2E8\uC704");
			btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 천단위
					long v = Long.parseLong(textField.getText()); // parseLong을 사용해서 소숫점을 받지 못한다.
					DecimalFormat df = new DecimalFormat("00,000,000,000.00");
					String r = df.format(v);
					
					textArea.append(r + "\n");
					
				}
			});
			btnNewButton.setBounds(12, 38, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC18C\uC22B\uC810 \uD45C\uC2DC");
			btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 소숫점 표시
					double v = Double.parseDouble(textField.getText());
					DecimalFormat df = new DecimalFormat("#,###,###,###.#");
					
					textArea.append(df.format(v) + "\n");
				}
			});
			btnNewButton_1.setBounds(121, 38, 107, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC6D0\uD654 \uD45C\uC2DC");
			btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 원화 표시
					double v = Double.parseDouble(textField.getText());
					DecimalFormat df = new DecimalFormat("\u00a4 #,###.##");
					
					textArea.append(df.format(v) + "\n");
					
				}
			});
			btnNewButton_2.setBounds(240, 38, 97, 23);
		}
		return btnNewButton_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 71, 327, 190);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
