package j_collection;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class MemberSearch extends JInternalFrame {
	List<MemberVo>list;
	
	private JPanel panel;
	private JTextField findStr;
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
					MemberSearch frame = new MemberSearch();
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
	public MemberSearch() {
		super("회원 검색", false, true, true, true);
		setVisible(true);
		setBounds(500, 300, 386, 300);
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);
	}
	
	public MemberSearch(List<MemberVo> list) {
		this();
		this.list = list;
	}
	
	public void search() {
		textArea.setText("");
		String find = findStr.getText();
		
		for(int i=0; i<list.size(); i++) {
			MemberVo vo = list.get(i);
			
			if(vo.getmId().indexOf(find) >=0 || vo.getmName().indexOf(find) >=0 || vo.getPhone().indexOf(find) >=0) {			
			textArea.append(vo.toString()); // textArea.append(vo.getmName() + "\n"); 이렇게도 작성가능
			// MemberVo 클래스 toString을 재정의 하여 출력
			}
		}
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 26));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getFindStr(), BorderLayout.CENTER);
			panel.add(getBtnNewButton(), BorderLayout.EAST);
		}
		return panel;
	}
	private JTextField getFindStr() {
		if (findStr == null) {
			findStr = new JTextField();
			findStr.setBackground(new Color(230, 230, 250));
			findStr.setColumns(10);
		}
		return findStr;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(100, 149, 237));
			btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					search();
				}
			});
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setForeground(new Color(255, 255, 255));
			textArea.setBackground(new Color(173, 216, 230));
		}
		return textArea;
	}
}
