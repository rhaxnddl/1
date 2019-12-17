package h_api2;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import java.util.Objects;
import java.awt.Label;

public class SortBySno extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private TextArea textArea;
	private Label label;
	public JLabel status;
	/**
	 * Create the panel.
	 */	
	public SortBySno(JLabel status) {
		this();
		this.status = status;
		sortList();
	}
	public SortBySno() {
		setLayout(null);
		add(getLblNewLabel());
		add(getScrollPane());
	}
	
	public void sortList() { // 객체형 배열 정렬
		Student temp = null;
		int result = 0;
		for(int i=0; i<StudentApp.count-1; i++) {
			for(int j=(i+1); j<StudentApp.count; j++) {
				Student s1 = StudentApp.student[i];
				Student s2 = StudentApp.student[j];
				result = Objects.compare(s1, s2, new StudentComp('n'));
				if(result>0) {
					temp = StudentApp.student[i];
					StudentApp.student[i] = StudentApp.student[j];
					StudentApp.student[j] = temp;	
				} // if
			} // j
		} // i
		textArea.setText(""); //기존의 표시된 내용을 모두 삭제
		for(int i=0; i<StudentApp.count;i++) {
			textArea.append(StudentApp.student[i] + "\n");
		}
		status.setText("데이터가 학번순으로 정렬되었습니다");
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uBC88\uC21C \uC815\uB82C");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(255, 204, 0));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 296, 34);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 58, 296, 216);
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getLabel());
		}
		return scrollPane;
	}
	private TextArea getTextArea() {
		if (textArea == null) {
			textArea = new TextArea();
		}
		return textArea;
	}
	private Label getLabel() {
		if (label == null) {
			label = new Label("\uD559\uBC88      \uC774\uB984              \uC131\uC801");
			label.setForeground(Color.WHITE);
			label.setAlignment(Label.CENTER);
			label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			label.setBackground(new Color(255, 204, 0));
		}
		return label;
	}
}
