package homeWork;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoardSearch extends JInternalFrame {
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardSearch frame = new BoardSearch();
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
	public BoardSearch() {
		super("Board Search", false, true, true, true);
		setVisible(true);
		setTitle("Board Search");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getScrollPane_1());

	}
	
	public void BoardList() {
//		BoardVo temp = null;
//		int result = 0;
//		for(int i = 0; i<BoardMain.count-1; i++) {
//			for(int j=(i+1); j<BoardMain.count; j++) {
//				BoardVo s1 = BoardMain.data[i];
//				BoardVo s2 = BoardMain.data[j];
//				result = Objects.compare(s1, s2, new BoardComparator('n'));
//				if(result<0) {
//					temp = BoardMain.data[i];
//					BoardMain.data[i] = BoardMain.data[j];
//					BoardMain.data[j] = temp;
//				} // if
//			} // j
//		} // i
//		
	Collections.sort(Arrays.asList(BoardMain.data),new BoardComparator());
		
		textArea.setText("");
		for(int i=0; i<BoardMain.count;i++) {
			textArea.append(BoardMain.data[i].toString() + "\n");
		}
		
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uB0B4\uB9BC\uCC28\uC21C \uC815\uB82C");
			lblNewLabel.setBounds(0, 0, 434, 28);
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC870\uD68C");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BoardList();
				}
			});
			btnNewButton.setBounds(162, 38, 97, 23);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 71, 410, 190);
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	private JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
