package h_api;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class PatternExam2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField id;
	private JTextField pwd;
	private JTextField mName;
	private JTextField phone;
	private JTextField email;
	private JTextField zip;
	private JButton btnNewButton;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatternExam2 frame = new PatternExam2();
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
	public PatternExam2() {
		setTitle("\uD68C\uC6D0\uAC00\uC785(Pattern Check)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 255, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblNewLabel_5());
		contentPane.add(getId());
		contentPane.add(getPwd());
		contentPane.add(getMName());
		contentPane.add(getPhone());
		contentPane.add(getEmail());
		contentPane.add(getZip());
		contentPane.add(getBtnNewButton());
		contentPane.add(getStatus());
	}
	public void check() {
		String regexp = "";
		String value = "";
		
		
		// 아이디
		regexp = "[\\w+$!]{4,10}";	// 기호포함가능	
		regexp = "[\\w+](?=.*[!$_]){3,9}";// 기호 반드시 포함 (소괄호 안의 한글자를 반드시 포함)
		value = id.getText();
		if(!Pattern.matches(regexp, value)) {
			status.setText("아이디에 오류가 있습니다.");
			id.requestFocus();
			id.selectAll();			
		}		
		//암호
		regexp = "[\\w+!$]{4,10}";
		value = pwd.getText();
		if(!Pattern.matches(regexp, value)) {
			status.setText("패스워드에 오류가 있습니다.");
			pwd.requestFocus();
			pwd.selectAll();
		}		
		// 성명
		regexp = "[가-힣]{2,20}";
		value = mName.getText();
		if(!Pattern.matches(regexp, value)) {
			status.setText("성명에 오류가 있습니다.");
			mName.requestFocus();
			mName.selectAll();
		}
		
		// 연락처
		regexp = "\\d{2,3}-\\d{3,4}-\\d{4}";
		value = phone.getText();
		if(Pattern.matches(regexp, value));{		
			status.setText("연락처에 오류가 있습니다.");
			phone.requestFocus();
			phone.selectAll();
		}		
		// 우편번호
		regexp = "\\d{2}-\\d{3}";
		value = zip.getText();
		if(!Pattern.matches(regexp, value)); {
			status.setText("우편번호에 오류가 있습니다.");
			zip.requestFocus();
			zip.selectAll();
		}
		
		
		 //이메일 체크
		regexp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		value = email.getText();
		if(!Pattern.matches(regexp, value)) {
			status.setText("이메일에 오류가 있습니다.");
			email.requestFocus();
			email.selectAll();
		}
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 28, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC554\uD638");
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(12, 53, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC131\uBA85");
			lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(12, 89, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC5F0\uB77D\uCC98");
			lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(12, 114, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC774\uBA54\uC77C");
			lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setBounds(12, 151, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uC6B0\uD3B8\uBC88\uD638");
			lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(12, 186, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JTextField getId() {
		if (id == null) {
			id = new JTextField();
			id.setBounds(77, 26, 116, 21);
			id.setColumns(10);
		}
		return id;
	}
	private JTextField getPwd() {
		if (pwd == null) {
			pwd = new JTextField();
			pwd.setBounds(77, 56, 116, 21);
			pwd.setColumns(10);
		}
		return pwd;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(77, 87, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setBounds(77, 118, 116, 21);
			phone.setColumns(10);
		}
		return phone;
	}
	private JTextField getEmail() {
		if (email == null) {
			email = new JTextField();
			email.setBounds(77, 149, 116, 21);
			email.setColumns(10);
		}
		return email;
	}
	private JTextField getZip() {
		if (zip == null) {
			zip = new JTextField();
			zip.setBounds(77, 184, 116, 21);
			zip.setColumns(10);
		}
		return zip;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("check");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {					
					check();
				}
			});
			btnNewButton.setBounds(77, 228, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uCCB4\uD06C\uD558\uC138\uC694");
			status.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			status.setForeground(Color.WHITE);
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBackground(Color.LIGHT_GRAY);
			status.setBounds(12, 290, 215, 62);
		}
		return status;
	}
}
