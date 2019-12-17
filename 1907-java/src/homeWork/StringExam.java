package homeWork;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.TextField;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StringExam extends JFrame {

	private JPanel contentPane;
	private TextArea textArea;
	private JLabel lblNewLabel;
	private JTextField jumin;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField textField;
	private ScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StringExam frame = new StringExam();
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
	public StringExam() {
		setTitle("\uBB38\uC790\uC5F4 Exam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTextArea());
		contentPane.add(getLblNewLabel());
		contentPane.add(getJumin());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getTextField());
		contentPane.add(getScrollPane());
	}
	private TextArea getTextArea() {
		if (textArea == null) {
			textArea = new TextArea();
			textArea.setBounds(10, 94, 440, 170);
		}
		return textArea;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
			lblNewLabel.setBounds(10, 40, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getJumin() {
		if (jumin == null) {
			jumin = new JTextField();
			jumin.setText("891215-1234565");
			jumin.setBounds(65, 37, 116, 21);
			jumin.setColumns(10);
		}
		return jumin;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uD655\uC778");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = "";
					String j = jumin.getText();
					char c = j.charAt(7);
					str += "문자열의 길이 : " + j.length();
					str += "\n생년 : " + j.substring(0,2);
					str += "\n생월 : " + j.substring(2,4);
					str += "\n생일 : " + j.substring(4,6);
					
					str += "\n성별 : " + ((c%2==0)? "여자" : "남자");
					str += "\n---------------------------------\n";					
					textArea.append(str);
					
				}
			});
			btnNewButton.setBounds(193, 36, 71, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("New button");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_1.setBounds(130, 65, 71, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("New button");
			btnNewButton_2.setBounds(213, 65, 66, 23);
		}
		return btnNewButton_2;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(12, 65, 106, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private ScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new ScrollPane();
			scrollPane.setBounds(10, 94, 271, 170);
		}
		return scrollPane;
	}
}
