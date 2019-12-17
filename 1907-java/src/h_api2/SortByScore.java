package h_api2;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.TextArea;
import java.util.Objects;

public class SortByScore extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private TextArea textArea;
	private JLabel lblNewLabel_1;
	public JLabel status;

	/**
	 * Create the panel.
	 */
	public SortByScore(JLabel status) {
		this();
		this.status = status;
		sortList();
	}
	public SortByScore() {
		setLayout(null);
		add(getLblNewLabel());
		add(getScrollPane());
	}
	
	public void sortList() {
		Student temp = null;
		int result = 0;
		Student s1 = null, s2 = null;
		for(int i=0; i<StudentApp.count-1; i++) {
			for(int j=(i+1);j<StudentApp.count;j++) {
				s1 = StudentApp.student[i];
				s2 = StudentApp.student[j];
				result = Objects.compare(s1, s2, new StudentComp('s'));
				if(result<0) {// 성적을 내림차순
					temp = StudentApp.student[i];
					StudentApp.student[i] = StudentApp.student[j];
					StudentApp.student[j] = temp;
				} // if
			} // j
		} // i
		textArea.setText("");
		for(int i=0; i<StudentApp.count;i++) {
			textArea.append(StudentApp.student[i] + "\n");
		}
		status.setText("성적순으로 정렬되었습니다.");
		}
	

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801\uC21C \uC815\uB82C");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(255, 204, 0));
			lblNewLabel.setBounds(12, 10, 296, 34);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 60, 296, 208);
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getLblNewLabel_1());
		}
		return scrollPane;
	}
	private TextArea getTextArea() {
		if (textArea == null) {
			textArea = new TextArea();
		}
		return textArea;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD559\uBC88      \uC774\uB984           \uC131\uC801");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			lblNewLabel_1.setBackground(new Color(255, 204, 0));
		}
		return lblNewLabel_1;
	}
}
