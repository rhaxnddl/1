package j_collection;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class ScoreInput extends JInternalFrame {
	Set<ScoreVo> score;
	
	ButtonGroup group = new ButtonGroup();
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField sno;
	private JTextField mName;
	private JTextField kor;
	private JTextField mat;
	private JTextField eng;
	private JTextField tot;
	private JTextField avg;
	private JButton btnNewButton;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel status;
	private JRadioButton exam1Btn;
	private JRadioButton exam2Btn;
	private JSeparator separator;
	private JSeparator separator_1;
	private JComboBox grade;
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
		setVisible(true);
		setBounds(100, 100, 265, 486);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getLblNewLabel_5());
		getContentPane().add(getLblNewLabel_6());
		getContentPane().add(getSno());
		getContentPane().add(getMName());
		getContentPane().add(getKor());
		getContentPane().add(getMat());
		getContentPane().add(getEng());
		getContentPane().add(getTot());
		getContentPane().add(getAvg());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getLblNewLabel_7());
		getContentPane().add(getLblNewLabel_8());
		getContentPane().add(getLblNewLabel_9());
		getContentPane().add(getStatus());
		getContentPane().add(getExam1Btn());
		getContentPane().add(getExam2Btn());
		getContentPane().add(getSeparator());
		getContentPane().add(getSeparator_1());
		getContentPane().add(getGrade());

	}
	public ScoreInput(Set<ScoreVo> score) {
		this();
		this.score = score;
	}
	
	public void input() {
		String s = sno.getText();
		String n = mName.getText();
		String g = grade.getText();
		int k =  Integer.parseInt(kor.getText());
		int e = Integer.parseInt(eng.getText());
		int m = Integer.parseInt(mat.getText());
		
		ScoreVo vo = new ScoreVo(s,n,g,k,e,m);
		this.score.add(vo);
		
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC2DC\uD5D8\uC885\uB958");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel.setBounds(12, 176, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD559\uB144");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_1.setBounds(12, 201, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uAD6D\uC5B4");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_2.setBounds(12, 226, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC218\uD559");
			lblNewLabel_3.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(12, 257, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC601\uC5B4");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_4.setBounds(12, 288, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uCD1D\uC810");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_5.setBounds(12, 319, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("\uD3C9\uADE0");
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_6.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_6.setBounds(12, 350, 57, 15);
		}
		return lblNewLabel_6;
	}
	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setBounds(81, 115, 116, 21);
			sno.setColumns(10);
		}
		return sno;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(81, 146, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JTextField getKor() {
		if (kor == null) {
			kor = new JTextField();
			kor.setBounds(81, 223, 116, 21);
			kor.setColumns(10);
		}
		return kor;
	}
	private JTextField getMat() {
		if (mat == null) {
			mat = new JTextField();
			mat.setBounds(81, 254, 116, 21);
			mat.setColumns(10);
		}
		return mat;
	}
	private JTextField getEng() {
		if (eng == null) {
			eng = new JTextField();
			eng.setBounds(81, 285, 116, 21);
			eng.setColumns(10);
		}
		return eng;
	}
	private JTextField getTot() {
		if (tot == null) {
			tot = new JTextField();
			tot.setBounds(81, 316, 116, 21);
			tot.setColumns(10);
		}
		return tot;
	}
	private JTextField getAvg() {
		if (avg == null) {
			avg = new JTextField();
			avg.setBounds(81, 347, 116, 21);
			avg.setColumns(10);
		}
		return avg;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(154, 205, 50));
			btnNewButton.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					input();
				}
			});
			btnNewButton.setBounds(81, 378, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("\uC131\uBA85");
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_7.setBounds(12, 151, 57, 15);
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("\uD559\uBC88");
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_8.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_8.setBounds(12, 116, 57, 18);
		}
		return lblNewLabel_8;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("\uC131\uC801 \uC785\uB825");
			lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_9.setFont(new Font("타이포_스톰 B", Font.BOLD, 40));
			lblNewLabel_9.setBounds(12, 10, 230, 71);
		}
		return lblNewLabel_9;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uC815\uBCF4\uB97C \uC785\uB825\uD558\uC138\uC694");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setForeground(new Color(255, 255, 255));
			status.setOpaque(true);
			status.setBackground(new Color(154, 205, 50));
			status.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			status.setBounds(12, 411, 230, 36);
		}
		return status;
	}
	private JRadioButton getExam1Btn() {
		if (exam1Btn == null) {
			exam1Btn = new JRadioButton("\uC911\uAC04");
			exam1Btn.setFont(new Font("1훈새마을운동 R", Font.BOLD, 12));
			exam1Btn.setBounds(77, 173, 49, 23);
			group.add(exam1Btn);
			exam1Btn.setSelected(true);
		}
		return exam1Btn;
	}
	private JRadioButton getExam2Btn() {
		if (exam2Btn == null) {
			exam2Btn = new JRadioButton("\uAE30\uB9D0");
			exam2Btn.setFont(new Font("1훈새마을운동 R", Font.BOLD, 12));
			exam2Btn.setBounds(142, 173, 49, 23);
			group.add(exam2Btn);
		}
		return exam2Btn;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(new Color(154, 205, 50));
			separator.setOpaque(true);
			separator.setForeground(new Color(154, 205, 50));
			separator.setBounds(68, 91, 1, 274);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setOpaque(true);
			separator_1.setBackground(new Color(154, 205, 50));
			separator_1.setBounds(12, 91, 230, 2);
		}
		return separator_1;
	}
	private JComboBox getGrade() {
		if (grade == null) {
			grade = new JComboBox();
			grade.setBounds(81, 198, 116, 21);
		}
		return grade;
	}
}
