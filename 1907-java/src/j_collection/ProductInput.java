package j_collection;

import java.awt.EventQueue;
import java.util.Date;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ProductInput extends JInternalFrame {
	Set<ProductVo> piList;
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
					ProductInput frame = new ProductInput();
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
	public ProductInput() {
		super("제품 입고", false, true, true, true);
		getContentPane().setBackground(new Color(250, 240, 230));
		setVisible(true);
		setBounds(100, 100, 256, 309);
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
	public ProductInput(Set<ProductVo> pi) {
		this(); // 자기 자신의 생성자를 부를때, 생성자안에서 실행문의 첫번째 문장에 작성해야한다.
		this.piList = pi;
		}
		
	public void input() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		
		if(pCode.getText().equals("")|| pName.getText().equals("")||ea.getText().equals("")||nal.getText().equals("")) {
//			status.setBackground(Color.RED);
			status.setText("입력항목에 오류가 있습니다.");
			pCode.requestFocus();
			return;
		}		
		try {
		String serial = sdf.format(new Date()) + "-" + MemberMain.iSerial;
		String pC = pCode.getText();
		String pN = pName.getText();
		int e = Integer.parseInt(ea.getText());
		Date n = sdf.parse(nal.getText());
		
		ProductVo vo = new ProductVo(serial, pC, pN, e, n);
		piList.add(vo);
		MemberMain.iSerial++;
//		status.setBackground(Color.BLUE);
		status.setText("출고자료가 정상적으로 입력되었습니다.");
		pName.setText("");
		ea.setText("");
		pCode.requestFocus();
		pCode.selectAll();			
		}catch(ParseException e1) {
			
			status.setText("날짜 형식을 yyy-MM-dd로 입력해 주세요");
			nal.requestFocus();
			nal.selectAll();
		}catch(NumberFormatException e2) {
			status.setText("숫자만 입력하세요");
			ea.requestFocus();
			ea.selectAll();
		};
	}
		
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC81C\uD488 \uCF54\uB4DC");
			lblNewLabel.setBackground(new Color(250, 235, 215));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel.setBounds(12, 67, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC81C\uD488 \uBA85");
			lblNewLabel_1.setBackground(new Color(250, 240, 230));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_1.setBounds(12, 98, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC218\uB7C9");
			lblNewLabel_2.setBackground(new Color(250, 240, 230));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_2.setBounds(12, 129, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC785\uACE0\uC77C\uC790");
			lblNewLabel_3.setBackground(new Color(250, 240, 230));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_3.setBounds(12, 160, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getPCode() {
		if (pCode == null) {
			pCode = new JTextField();
			pCode.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			pCode.setBounds(81, 64, 147, 21);
			pCode.setColumns(10);
			
			
		}
		return pCode;
	}
	private JTextField getPName() {
		if (pName == null) {
			pName = new JTextField();
			pName.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			pName.setBounds(81, 95, 147, 21);
			pName.setColumns(10);
		}
		return pName;
	}
	private JTextField getEa() {
		if (ea == null) {
			ea = new JTextField();
			ea.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			ea.setBounds(81, 126, 72, 21);
			ea.setColumns(10);
		}
		return ea;
	}
	private JTextField getNal() {
		if (nal == null) {
			nal = new JTextField();
			nal.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			nal.setBounds(81, 157, 116, 21);
			nal.setColumns(10);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			nal.setText(sdf.format(new Date()));
			
		}
		return nal;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC785\uACE0");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			btnNewButton.setBackground(new Color(154, 205, 50));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					input();
				}
			});
			btnNewButton.setBounds(68, 200, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uC815\uBCF4\uB97C \uC785\uB825\uD558\uC138\uC694.");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setForeground(new Color(255, 255, 255));
			status.setFont(new Font("타이포_스톰 B", Font.BOLD, 18));
			status.setOpaque(true);
			status.setBackground(new Color(154, 205, 50));
			status.setBounds(12, 233, 221, 33);
		}
		return status;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC81C\uD488 \uC785\uACE0");
			lblNewLabel_4.setFont(new Font("타이포_스톰 B", Font.PLAIN, 35));
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setBounds(12, 10, 221, 47);
		}
		return lblNewLabel_4;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(new Color(154, 205, 50));
			separator.setBackground(new Color(154, 205, 50));
			separator.setBounds(12, 55, 216, 2);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setOpaque(true);
			separator_1.setBackground(new Color(154, 205, 50));
			separator_1.setForeground(new Color(154, 205, 50));
			separator_1.setBounds(68, 55, 2, 134);
		}
		return separator_1;
	}
}
