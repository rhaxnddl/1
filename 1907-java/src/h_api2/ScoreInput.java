package h_api2;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import f_inheri.Account;
import f_inheri.Bank;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreInput extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField mName;
	private JTextField sno;
	private JTextField score;
	private JButton btnNewButton;
	public JLabel status;
	/**
	 * Create the panel.
	 */
	public ScoreInput(JLabel status) {
		this();
		this.status = status;
	}
	public ScoreInput() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getMName());
		add(getSno());
		add(getScore());
		add(getBtnNewButton());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801\uC785\uB825");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(255, 204, 0));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 296, 39);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC131\uBA85");
			lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(22, 124, 57, 21);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uD559\uBC88");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			lblNewLabel_2.setBounds(22, 68, 57, 21);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC131\uC801");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			lblNewLabel_3.setBounds(22, 180, 57, 21);
		}
		return lblNewLabel_3;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(122, 126, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JTextField getSno() {
		if (sno == null) {
			sno = new JTextField();
			sno.setBounds(122, 70, 116, 21);
			sno.setColumns(10);
		}
		return sno;
	}
	private JTextField getScore() {
		if (score == null) {
			score = new JTextField();
			score.setBounds(122, 182, 116, 21);
			score.setColumns(10);
		}
		return score;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC785\uB825\uC644\uB8CC");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int no = Integer.parseInt(sno.getText());
					String irum = mName.getText();
					int s = Integer.parseInt(score.getText());
					
					Student std = new Student(no, irum, s);
					StudentApp.student[StudentApp.count] = std;
					StudentApp.count++;
					
					status.setText(StudentApp.count + "¹øÂ° ¼ºÀûÀÌ Ãß°¡µÊ");
					
				}
			});
			btnNewButton.setBounds(112, 245, 97, 23);
		}
		return btnNewButton;
	}
}
