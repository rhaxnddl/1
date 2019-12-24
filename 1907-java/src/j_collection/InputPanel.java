package j_collection;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;

public class InputPanel extends JPanel {
	
	ButtonGroup group = new ButtonGroup();
	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	
	public JTextField tSno;
	public JTextField tmName;
	public JRadioButton rExam1;
	public JRadioButton rExam2;
	public JTextField tKor;
	public JComboBox cGrade;
	public JTextField tEng;
	public JTextField tMat;
	public JTextField tTot;
	public JTextField tAvg;
	private JSeparator separator_1;

	/**
	 * Create the panel.
	 */
	public InputPanel() {
		setBackground(new Color(250, 240, 230));
		setLayout(null);
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getLblNewLabel_4());
		add(getLblNewLabel_5());
		add(getLblNewLabel_6());
		add(getLblNewLabel_7());
		add(getLblNewLabel_8());
		add(getLblNewLabel_9());
		add(getTSno());
		add(getTmName());
		add(getRExam1());
		add(getRExam2());
		add(getTKor());
		add(getCGrade());
		add(getTEng());
		add(getTMat());
		add(getTTot());
		add(getTAvg());
		add(getSeparator_1());

	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD559\uBC88");
			lblNewLabel_1.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(12, 10, 65, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC131\uBA85");
			lblNewLabel_2.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(12, 35, 65, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC2DC\uD5D8\uC885\uB958");
			lblNewLabel_3.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(12, 60, 65, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uD559\uB144");
			lblNewLabel_4.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setBounds(12, 85, 65, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uAD6D\uC5B4 \uC131\uC801");
			lblNewLabel_5.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(12, 110, 65, 15);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("\uC601\uC5B4 \uC131\uC801");
			lblNewLabel_6.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_6.setBounds(12, 135, 65, 15);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("\uC218\uD559 \uC131\uC801");
			lblNewLabel_7.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setBounds(12, 160, 65, 15);
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("\uCD1D\uC810");
			lblNewLabel_8.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_8.setBounds(12, 185, 65, 15);
		}
		return lblNewLabel_8;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("\uD3C9\uADE0");
			lblNewLabel_9.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_9.setBounds(12, 210, 65, 15);
		}
		return lblNewLabel_9;
	}
	private JTextField getTSno() {
		if (tSno == null) {
			tSno = new JTextField();
			tSno.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			tSno.setBounds(102, 7, 116, 21);
			tSno.setColumns(10);
		}
		return tSno;
	}
	private JTextField getTmName() {
		if (tmName == null) {
			tmName = new JTextField();
			tmName.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			tmName.setBounds(102, 32, 65, 21);
			tmName.setColumns(10);
		}
		return tmName;
	}
	private JRadioButton getRExam1() {
		if (rExam1 == null) {
			rExam1 = new JRadioButton("\uC911\uAC04");
			rExam1.setBackground(new Color(250, 240, 230));
			rExam1.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			rExam1.setBounds(102, 56, 57, 23);
			
			group.add(rExam1);
			rExam1.setSelected(true);
		}
		return rExam1;
	}
	private JRadioButton getRExam2() {
		if (rExam2 == null) {
			rExam2 = new JRadioButton("\uAE30\uB9D0");
			rExam2.setBackground(new Color(250, 240, 230));
			rExam2.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			rExam2.setBounds(163, 56, 57, 23);
			
			group.add(rExam2);
		}
		return rExam2;
	}
	private JTextField getTKor() {
		if (tKor == null) {
			tKor = new JTextField();
			tKor.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			tKor.setBounds(102, 107, 65, 21);
			tKor.setColumns(10);
		}
		return tKor;
	}
	private JComboBox getCGrade() {
		if (cGrade == null) {
			cGrade = new JComboBox();
			cGrade.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			cGrade.setBounds(102, 82, 65, 21);
			cGrade.addItem("1학년");
			cGrade.addItem("2학년");
			cGrade.addItem("3학년");
			cGrade.addItem("4학년");
			cGrade.setSelectedIndex(0);
		}
		return cGrade;
	}
	private JTextField getTEng() {
		if (tEng == null) {
			tEng = new JTextField();
			tEng.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			tEng.setBounds(102, 132, 65, 21);
			tEng.setColumns(10);
		}
		return tEng;
	}
	private JTextField getTMat() {
		if (tMat == null) {
			tMat = new JTextField();
			tMat.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			tMat.setBounds(102, 157, 65, 21);
			tMat.setColumns(10);
		}
		return tMat;
	}
	private JTextField getTTot() {
		if (tTot == null) {
			tTot = new JTextField();
			tTot.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			tTot.setEnabled(false);
			tTot.setBounds(102, 182, 65, 21);
			tTot.setColumns(10);
		}
		return tTot;
	}
	private JTextField getTAvg() {
		if (tAvg == null) {
			tAvg = new JTextField();
			tAvg.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			tAvg.setEnabled(false);
			tAvg.setBounds(102, 207, 116, 21);
			tAvg.setColumns(10);
		}
		return tAvg;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setOpaque(true);
			separator_1.setBackground(new Color(154, 205, 50));
			separator_1.setBounds(89, 0, 2, 239);
		}
		return separator_1;
	}
}
