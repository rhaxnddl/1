package j_collection;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.text.NavigationFilter;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.NavigableSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class TreeSetFrame extends JInternalFrame {
	private JTextField textField;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeSetFrame frame = new TreeSetFrame();
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
	public TreeSetFrame() {
		super("TreeSet", false, true, true, true);
		getContentPane().setBackground(new Color(250, 240, 230));
		setVisible(true);
		setBounds(100, 100, 383, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
	}
	
	public void process() {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		StringTokenizer tokens = new StringTokenizer(textField.getText(), ",");
		
		textArea.setText("");
		while(tokens.hasMoreTokens()) {
		// textArea.append(tokens.nextToken() + "\n");
			scores.add(Integer.parseInt(tokens.nextToken()));
		}
		textArea.append("\n최소값 : " + scores.first());
		textArea.append("\n최대값 : " + scores.last());
		textArea.append("\n60점 이하 : " + scores.lower(60));
		textArea.append("\n90점 이상 : " + scores.higher(90));
		
		textArea.append("\n60점 바로 밑 값 : " + scores.floor(60));
		textArea.append("\n90점 바로 위 값 : " + scores.ceiling(90));
		
		textArea.append("\n-----------------------------------");
		while(!scores.isEmpty()) {
			textArea.append("\n" + scores.pollFirst() + ":::" + scores.size());
		}
	}
	
	public void asc() { // 오름차순 정렬
		TreeSet<Integer> set = new TreeSet<Integer>();
		StringTokenizer tokens = new StringTokenizer(textField.getText(),",");
		
		textArea.setText("");
		while(tokens.hasMoreTokens()) {
			set.add(Integer.parseInt(tokens.nextToken()));
		}
		
		NavigableSet<Integer> descendingSet = set.descendingSet();
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();{
			textArea.setText("----- 오름차순 정렬결과 -----\n");
			for(Integer i : ascendingSet) {
				textArea.append(i+"\n");
			}
		}
	}
	
	public void desc() { // 내림차순 정렬
		TreeSet<Integer> set = new TreeSet<Integer>();
		StringTokenizer tokens = new StringTokenizer(textField.getText(),",");
		while(tokens.hasMoreTokens()) {
			set.add(Integer.parseInt(tokens.nextToken()));
		}
		NavigableSet<Integer> descendingSet = set.descendingSet();
		textArea.setText("----- 내림차순 정렬 결과 -----\n");
		for(Integer i : descendingSet) {
			textArea.append(i+"\n");
		}
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			textField.setText("66,488,3,59,878,56,21,,,345,,2,3,,31,484");
			textField.setBounds(12, 10, 257, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC2E4\uD589");
			btnNewButton.setBackground(new Color(154, 205, 50));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setFont(new Font("타이포_스톰 B", Font.BOLD, 20));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					process();
				}
			});
			btnNewButton.setBounds(280, 8, 75, 23);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 68, 343, 193);
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
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("ASC");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					asc();
				}
			});
			btnNewButton_1.setBackground(new Color(154, 205, 50));
			btnNewButton_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1.setFont(new Font("타이포_스톰 B", Font.PLAIN, 18));
			btnNewButton_1.setBounds(179, 41, 75, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("DESC");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					desc();
				}
			});
			btnNewButton_2.setForeground(new Color(255, 255, 255));
			btnNewButton_2.setBackground(new Color(154, 205, 50));
			btnNewButton_2.setFont(new Font("타이포_스톰 B", Font.BOLD, 18));
			btnNewButton_2.setBounds(264, 41, 91, 23);
		}
		return btnNewButton_2;
	}
}
