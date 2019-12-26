package j_collection;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

public class ScoreInput extends JInternalFrame {
	
	Map<String, List<ScoreVo>> map;
	
	private JLabel lblNewLabel;
	private InputPanel panel;
	private JButton btnNewButton;
	private JLabel status;
	private JSeparator separator;
	 MemberMain mm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreInput frame = new ScoreInput();
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
	public ScoreInput() {
		super("성적 입력", false, true, true, true);
		getContentPane().setBackground(new Color(250, 240, 230));
		setVisible(true);
		setBounds(100, 100, 265, 407);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getPanel());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getStatus());
		getContentPane().add(getSeparator());

	}

	public ScoreInput(Map<String, List<ScoreVo>> map, MemberMain mm) {
		this();
		this.map = map;
		this.mm = mm;
	}
	
	public void sync() { // 성적이 추가되면 자동으로 조회 프레임의 내용 수정
		Object[] obj = mm.getContentPane().getComponents();
		for(int i=0; i<obj.length; i++) {
			if(obj[i] instanceof ScoreSearch) {
				ScoreSearch ss = (ScoreSearch)obj[i];
				ss.btnFind.doClick();
			}
		}
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801\uC785\uB825");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("타이포_스톰 B", Font.BOLD, 30));
			lblNewLabel.setBounds(12, 10, 225, 43);
		}
		return lblNewLabel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new InputPanel();
			panel.setBounds(12, 53, 225, 240);
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 무결성 체크
					String sno = panel.tSno.getText();
					String mName = panel.tmName.getText();
					int kor = Integer.parseInt(panel.tKor.getText());
					int eng = Integer.parseInt(panel.tEng.getText());
					int mat = Integer.parseInt(panel.tMat.getText());
					String exam = "";
					int grade = 0;
					if(panel.rExam1.isSelected()) {
						exam = "중간";
					}else {
						exam = "기말";
					}
					
					grade = panel.cGrade.getSelectedIndex()+1;
					
					ScoreVo vo = new ScoreVo(sno, mName, exam, grade, kor, eng, mat);
					panel.tTot.setText(vo.getTot()+"");
					panel.tAvg.setText(String.format("%5.1f", vo.getAvg()));
					
					ScoreDao dao = new ScoreDao(map);
					boolean b = dao.insert(vo);
					if(b) {
						status.setText("데이터가 저장되었습니다.");
						sync();
					} else {
						status.setText("저장 중 오류가 발생했습니다.");
					}
				}
			});
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			btnNewButton.setBackground(new Color(154, 205, 50));
			btnNewButton.setBounds(79, 303, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uC815\uBCF4\uB97C \uC785\uB825\uD558\uC138\uC694");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setForeground(new Color(255, 255, 255));
			status.setOpaque(true);
			status.setBackground(new Color(154, 205, 50));
			status.setFont(new Font("타이포_스톰 B", Font.BOLD, 18));
			status.setBounds(12, 335, 225, 33);
		}
		return status;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(new Color(154, 205, 50));
			separator.setOpaque(true);
			separator.setBackground(new Color(154, 205, 50));
			separator.setBounds(12, 51, 225, 2);
		}
		return separator;
	}
}
