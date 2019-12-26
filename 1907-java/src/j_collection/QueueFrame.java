package j_collection;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class QueueFrame extends JInternalFrame {	
	Queue<Message> queue = new LinkedList<Message>();
	// Queue는 인퍼페이스여서 new Queue로 받을 수 없어서 new LinkList<>();로 받아야 한다.
	
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueueFrame frame = new QueueFrame();
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
	public QueueFrame() {
		super("Queue", false, true, true, true);
		getContentPane().setBackground(new Color(250, 240, 230));
		setVisible(true);
		setBounds(100, 100, 382, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getScrollPane());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getComboBox());
		getContentPane().add(getLblNewLabel_1());
	}
	
	public void offer() {
		String command = (String)comboBox.getSelectedItem();
		String to = textField.getText();
		Message message = new Message(command, to);	
		
		queue.offer(message);		
	}
	
	public void poll() {
		textArea.setText("");
		while(!queue.isEmpty()) {
			Message message = queue.poll();
			
			switch(message.command) {
			case "Mail":
				textArea.append(message.to + "Mail을 발송합니다.");
				break;
			case "SMS":
				textArea.append(message.to + "SMS 문자를 보냅니다.");
				break;
			case "kakaotalk":
				textArea.append(message.to + "kakaotalk 메세지를 보냅니다.");
				break;
			}
			textArea.append("\n");
		}		
	}
	
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			textField.setBounds(122, 43, 102, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("OFFER");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(154, 205, 50));
			btnNewButton.setFont(new Font("타이포_스톰 B", Font.BOLD, 18));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				offer();
				}
			});
			btnNewButton.setBounds(247, 9, 105, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("POLL");
			btnNewButton_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1.setBackground(new Color(154, 205, 50));
			btnNewButton_1.setFont(new Font("타이포_스톰 B", Font.BOLD, 18));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					poll();
				}
			});
			btnNewButton_1.setBounds(245, 42, 107, 23);
		}
		return btnNewButton_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 75, 340, 186);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		}
		return textArea;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("command");
			lblNewLabel.setFont(new Font("타이포_스톰 B", Font.BOLD, 18));
			lblNewLabel.setBounds(12, 10, 102, 21);
		}
		return lblNewLabel;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(122, 12, 102, 21);
			
			comboBox.addItem("Mail");
			comboBox.addItem("SMS");
			comboBox.addItem("kakaotalk");
			comboBox.setSelectedIndex(0);
		}
		return comboBox;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("To");
			lblNewLabel_1.setFont(new Font("타이포_스톰 B", Font.BOLD, 18));
			lblNewLabel_1.setBounds(12, 47, 84, 17);
		}
		return lblNewLabel_1;
	}
}
