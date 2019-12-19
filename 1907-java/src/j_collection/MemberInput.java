package j_collection;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MemberInput extends JInternalFrame {
	List<MemberVo> list;
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
		getContentPane().setBackground(new Color(173, 216, 230));
		setVisible(true);
		setBounds(30, 500, 323, 308);
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
	}
	public MemberInput(List<MemberVo> list) {
		this();
		this.list = list;
	}
	
	public void input() {
		String id = mId.getText();
		String p = pwd.getText();
		String n = mName.getText();
		String ph = phone.getText();
		
		MemberVo vo = new MemberVo(id,p,n,ph);
		this.list.add(vo);
		
		pwd.setText("");
		mName.setText("");
		phone.setText("");
		
		mId.requestFocus();
		mId.selectAll();
		
		status.setText("회원정보가 추가 입력되었습니다.(" + list.size() + " 건 )");
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(100, 149, 237));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(40, 22, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uBE44\uBC00 \uBC88\uD638");
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.setBackground(new Color(100, 149, 237));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(40, 61, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC131\uBA85");
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.setOpaque(true);
			lblNewLabel_2.setBackground(new Color(100, 149, 237));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(40, 96, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC5F0\uB77D\uCC98");
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setOpaque(true);
			lblNewLabel_3.setBackground(new Color(100, 149, 237));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(40, 135, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(100, 149, 237));
			btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { // 저장버튼
					input();
				}
			});
			btnNewButton.setBounds(89, 173, 151, 44);
		}
		return btnNewButton;
	}
	private JTextField getMId() {
		if (mId == null) {
			mId = new JTextField();
			mId.setBounds(149, 19, 116, 21);
			mId.setColumns(10);
		}
		return mId;
	}
	private JTextField getPwd() {
		if (pwd == null) {
			pwd = new JTextField();
			pwd.setBounds(149, 58, 116, 21);
			pwd.setColumns(10);
		}
		return pwd;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(149, 93, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setBounds(149, 132, 116, 21);
			phone.setColumns(10);
		}
		return phone;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uC815\uBCF4\uB97C \uC785\uB825\uD558\uC138\uC694");
			status.setForeground(new Color(255, 255, 255));
			status.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBackground(new Color(100, 149, 237));
			status.setBounds(12, 238, 283, 31);
		}
		return status;
	}
}
