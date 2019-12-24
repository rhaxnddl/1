package j_collection;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class ProductOutput extends JInternalFrame {
	Set<ProductVo> peList;		
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField pCode;
	private JTextField pName;
	private JTextField ea;
	private JTextField nal;
	private JButton btnNewButton;
	private JLabel status;
	private JLabel lblNewLabel_4;
	private JSeparator separator;
	private JSeparator separator_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductOutput frame = new ProductOutput();
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
	public ProductOutput() {
		super("제품 출고", false, true, true, true);
		getContentPane().setBackground(new Color(250, 240, 230));
		setVisible(true);
		setBounds(100, 100, 267, 306);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getPCode());
		getContentPane().add(getPName());
		getContentPane().add(getEa());
		getContentPane().add(getNal());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getStatus());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getSeparator());
		getContentPane().add(getSeparator_1());

	}
	public ProductOutput(Set<ProductVo> pe) {
		this();
		this.peList = pe;
	}
	
	public void output() {
		// 폼의 값을 가져다 ProductVo 생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		
		// 입력항목이 공백인 경우
		if(pCode.getText().equals("")|| pName.getText().equals("")||ea.getText().equals("")||nal.getText().equals("")) {
			status.setText("입력항목에 오류가 있습니다.");
			pCode.requestFocus();
			return;
		}
		
		try {
		String serial = sdf.format(new Date()) + "-" + MemberMain.eSerial;
		String pC = pCode.getText();
		String pN = pName.getText();
		int e = Integer.parseInt(ea.getText());
			Date n = sdf.parse(nal.getText());
			ProductVo vo = new ProductVo(serial, pC, pN, e, n);
			// peList에 추가
			peList.add(vo);
			
			MemberMain.eSerial++;
			status.setText("출고자료가 정상적으로 입력되었습니다.");
			pName.setText("");
			ea.setText("");
			pCode.requestFocus();
			pCode.selectAll();			
		} catch (ParseException e1) {
			status.setText("날짜 형식을 yyy-MM-dd로 입력해 주세요");
			nal.requestFocus();
			nal.selectAll();
		} catch (NumberFormatException e2) {
			status.setText("숫자만 입력하세요");
			ea.requestFocus();
			ea.selectAll();
		};
		
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC81C\uD488 \uCF54\uB4DC");
			lblNewLabel.setBackground(new Color(250, 240, 230));
			lblNewLabel.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel.setBounds(12, 74, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC81C\uD488\uBA85");
			lblNewLabel_1.setBackground(new Color(250, 240, 230));
			lblNewLabel_1.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_1.setBounds(12, 105, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uCD9C\uACE0 \uC218\uB7C9");
			lblNewLabel_2.setBackground(new Color(250, 240, 230));
			lblNewLabel_2.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_2.setBounds(12, 136, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uCD9C\uACE0 \uC77C\uC790");
			lblNewLabel_3.setBackground(new Color(250, 240, 230));
			lblNewLabel_3.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_3.setBounds(12, 167, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getPCode() {
		if (pCode == null) {
			pCode = new JTextField();
			pCode.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			pCode.setBounds(94, 72, 145, 21);
			pCode.setColumns(10);
		}
		return pCode;
	}
	private JTextField getPName() {
		if (pName == null) {
			pName = new JTextField();
			pName.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			pName.setBounds(94, 103, 145, 21);
			pName.setColumns(10);
		}
		return pName;
	}
	private JTextField getEa() {
		if (ea == null) {
			ea = new JTextField();
			ea.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			ea.setBounds(94, 134, 116, 21);
			ea.setColumns(10);
		}
		return ea;
	}
	private JTextField getNal() {
		if (nal == null) {
			nal = new JTextField();
			nal.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			nal.setBounds(94, 165, 116, 21);
			nal.setColumns(10);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			nal.setText(sdf.format(new Date()));
			
		}
		return nal;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCD9C\uACE0");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(154, 205, 50));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					output();
				}
			});
			btnNewButton.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			btnNewButton.setBounds(91, 196, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uC815\uBCF4\uB97C \uC785\uB825\uD558\uC138\uC694.");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setForeground(new Color(255, 255, 255));
			status.setFont(new Font("1훈새마을운동 R", Font.BOLD, 18));
			status.setOpaque(true);
			status.setBackground(new Color(154, 205, 50));
			status.setBounds(12, 229, 227, 38);
		}
		return status;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC81C\uD488 \uCD9C\uACE0");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("타이포_스톰 B", Font.BOLD, 35));
			lblNewLabel_4.setBounds(12, 10, 227, 40);
		}
		return lblNewLabel_4;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOpaque(true);
			separator.setForeground(new Color(154, 205, 50));
			separator.setBackground(new Color(154, 205, 50));
			separator.setBounds(12, 60, 227, 2);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(new Color(154, 205, 50));
			separator_1.setBackground(new Color(154, 205, 50));
			separator_1.setOpaque(true);
			separator_1.setBounds(81, 60, 2, 137);
		}
		return separator_1;
	}
}
