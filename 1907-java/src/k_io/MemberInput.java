//2019.12.19
package k_io;

import java.awt.EventQueue;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JSeparator;

public class MemberInput extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JTextField mId;
	private JTextField pwd;
	private JTextField mName;
	private JTextField phone;
	private JLabel status;
	private JSeparator separator;
	private JLabel lblNewLabel_4;
	private JSeparator separator_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInput frame = new MemberInput();
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
	public MemberInput() {
		super("회원 입력", false, true, true, true);
		setVisible(true);
		getContentPane().setBackground(new Color(204, 204, 255));
		setBounds(30, 500, 323, 319);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getMId());
		getContentPane().add(getPwd());
		getContentPane().add(getMName());
		getContentPane().add(getPhone());
		getContentPane().add(getStatus());
		getContentPane().add(getSeparator());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getSeparator_1());
	}

	public void input() {
		String id = mId.getText();
		String p = pwd.getText();
		String n = mName.getText();
		String ph = phone.getText();
				
		boolean flag =
				Pattern.matches(FileExam2.idCheck, id)&&
				Pattern.matches(FileExam2.pwdCheck, p)&&
				Pattern.matches(FileExam2.nameCheck, n)&&
				Pattern.matches(FileExam2.phoneCheck, ph);
				
		if(!flag) {
			status.setText("데이터에 오류가 있습니다..");
			return;
		}
		MemberVo vo = new MemberVo(id,p,n,ph);
		MemberDao dao = new MemberDao();
		boolean b = dao.insert(vo);		
		
		if(b) {
		pwd.setText("");
		mName.setText("");
		phone.setText("");
		
		mId.requestFocus();
		mId.selectAll();
		
		status.setText("회원정보가 추가 입력되었습니다.");
		} else {
			status.setText("데이터 저장중 오류가 발생되었습니다.");
		}
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel.setForeground(new Color(102, 0, 153));
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(204, 204, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(40, 76, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uBE44\uBC00 \uBC88\uD638");
			lblNewLabel_1.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_1.setForeground(new Color(102, 0, 153));
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.setBackground(new Color(204, 204, 255));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(40, 101, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC131\uBA85");
			lblNewLabel_2.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_2.setForeground(new Color(102, 0, 153));
			lblNewLabel_2.setOpaque(true);
			lblNewLabel_2.setBackground(new Color(204, 204, 255));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(40, 126, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC5F0\uB77D\uCC98");
			lblNewLabel_3.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_3.setForeground(new Color(102, 0, 153));
			lblNewLabel_3.setOpaque(true);
			lblNewLabel_3.setBackground(new Color(204, 204, 255));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(40, 151, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(153, 102, 204));
			btnNewButton.setFont(new Font("타이포_스톰 B", Font.BOLD, 25));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { // 저장버튼
					input();
				}
			});
			btnNewButton.setBounds(89, 192, 151, 44);
		}
		return btnNewButton;
	}
	private JTextField getMId() {
		if (mId == null) {
			mId = new JTextField();
			mId.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			mId.setBounds(149, 73, 116, 21);
			mId.setColumns(10);
		}
		return mId;
	}
	private JTextField getPwd() {
		if (pwd == null) {
			pwd = new JTextField();
			pwd.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			pwd.setBounds(149, 98, 116, 21);
			pwd.setColumns(10);
		}
		return pwd;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			mName.setBounds(149, 126, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			phone.setBounds(149, 151, 146, 21);
			phone.setColumns(10);
		}
		return phone;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uC815\uBCF4\uB97C \uC785\uB825\uD558\uC138\uC694");
			status.setForeground(new Color(255, 255, 255));
			status.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBackground(new Color(153, 102, 204));
			status.setBounds(12, 249, 283, 31);
		}
		return status;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOpaque(true);
			separator.setForeground(new Color(153, 102, 204));
			separator.setBackground(new Color(153, 102, 204));
			separator.setBounds(120, 64, 2, 120);
		}
		return separator;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uD68C\uC6D0 \uC785\uB825");
			lblNewLabel_4.setForeground(new Color(102, 0, 153));
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("타이포_스톰 B", Font.BOLD, 35));
			lblNewLabel_4.setBounds(12, 10, 283, 50);
		}
		return lblNewLabel_4;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setOpaque(true);
			separator_1.setForeground(new Color(153, 102, 204));
			separator_1.setBackground(new Color(153, 102, 204));
			separator_1.setBounds(12, 64, 283, 2);
		}
		return separator_1;
	}
}
