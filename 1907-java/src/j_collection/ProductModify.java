package j_collection;

import java.awt.EventQueue;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ProductModify extends JInternalFrame {
	Set<ProductVo> piList;
	Set<ProductVo> peList;
	Set<ProductVo> list; // 검색, 수정, 삭제에서 사용해야함.	
	ButtonGroup group = new ButtonGroup();
	ProductVo oldVo; // 수정 전
	
	private JLabel lblNewLabel;
	private JRadioButton imBtn;
	private JRadioButton exBtn;
	private JLabel lblNewLabel_1;
	private JTextField serial;
	private JButton btnNewButton;
	private JSeparator separator;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField pCode;
	private JTextField pName;
	private JTextField ea;
	private JTextField nal;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel status;
	private JLabel lblNewLabel_6;
	private JSeparator separator_1;
	private JSeparator separator_2;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductModify frame = new ProductModify();
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
	public ProductModify() {
		super("제품 수정&삭제", false, true, true, true);
		getContentPane().setBackground(new Color(250, 240, 230));
		setVisible(true);
		setBounds(100, 100, 320, 372);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getImBtn());
		getContentPane().add(getExBtn());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getSerial());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getSeparator());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getLblNewLabel_5());
		getContentPane().add(getPCode());
		getContentPane().add(getPName());
		getContentPane().add(getEa());
		getContentPane().add(getNal());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getStatus());
		getContentPane().add(getLblNewLabel_6());
		getContentPane().add(getSeparator_1());
		getContentPane().add(getSeparator_2());
	}
	
	public ProductModify(Set<ProductVo> pi, Set<ProductVo> pe) {
		this();
		this.piList = pi;
		this.peList = pe;
	}
	
	public void search() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		if(imBtn.isSelected()) {
			list = piList;
		} else {
			list = peList;
		}
		String s = serial.getText();
		oldVo = null;
		status.setText("자료가 없습니다");
		for(ProductVo vo : list) {
			if(vo.getSerial().equals(s)){
				oldVo = vo;
				pCode.setText(vo.getpCode());
				pName.setText(vo.getpName());
				ea.setText(String.valueOf(vo.getEa())); // vo.getEa() + ""
				nal.setText(sdf.format(vo.getNal())); 
				status.setBackground(Color.BLUE);
				status.setText("자료를 찾았습니다");
				break;
			}
		}
		if(oldVo == null) {
			pCode.setText("");
			pName.setText("");
			ea.setText("");
			nal.setText("");
			status.setBackground(Color.RED);
			status.setText("자료가 없습니다.");
		}
	}
	
	public void update() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		if(oldVo != null) {
			try {
				String s = serial.getText();
				String pC = pCode.getText();
				String pN = pName.getText();
				int e = Integer.parseInt(ea.getText());
				Date n = sdf.parse(nal.getText());
				
				list.remove(oldVo);
				ProductVo newVo = new ProductVo(s, pC, pN, e, n);
				list.add(newVo);
				
				status.setText("자료가 수정되었습니다.");
				serial.requestFocus();
				serial.selectAll();
			}catch(ParseException ex) {
				status.setText("날짜 형식은 yyy-MM-dd 로 해주세요.");
				nal.requestFocus();
				nal.selectAll();
			}catch(NumberFormatException ex2) {
				status.setText("수량을 확인해 주세요");
				ea.requestFocus();
				ea.selectAll();
			};
		}else {
			status.setText("먼저 검색 후 수정하세요.");
		}
	}
	
	public void delete() {
		if(oldVo != null) {
			list.remove(oldVo);
			pCode.setText("");
			pName.setText("");
			ea.setText("");
			nal.setText("");
			status.setText("자료가 삭제되었습니다.");
		} else {
			status.setText("먼저 검색 후 삭제하세요.");
		}
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uAD6C\uBD84");
			lblNewLabel.setBackground(new Color(250, 240, 230));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel.setBounds(12, 77, 57, 15);
		}
		return lblNewLabel;
	}
	private JRadioButton getImBtn() {
		if (imBtn == null) {
			imBtn = new JRadioButton("\uC785\uACE0");
			imBtn.setBackground(new Color(250, 240, 230));
			imBtn.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			imBtn.setBounds(90, 73, 62, 23);
			group.add(imBtn);
			imBtn.setSelected(true);
		}
		return imBtn;
	}
	private JRadioButton getExBtn() {
		if (exBtn == null) {
			exBtn = new JRadioButton("\uCD9C\uACE0");
			exBtn.setBackground(new Color(250, 240, 230));
			exBtn.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			exBtn.setBounds(156, 73, 63, 23);
			group.add(exBtn);
		}
		return exBtn;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("serial");
			lblNewLabel_1.setBackground(new Color(250, 240, 230));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_1.setBounds(12, 102, 57, 18);
		}
		return lblNewLabel_1;
	}
	private JTextField getSerial() {
		if (serial == null) {
			serial = new JTextField();
			serial.setBounds(87, 102, 116, 21);
			serial.setColumns(10);
		}
		return serial;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setBackground(new Color(154, 205, 50));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {					
					search();
				}
			});
			btnNewButton.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			btnNewButton.setBounds(211, 100, 81, 23);
		}
		return btnNewButton;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(new Color(154, 205, 50));
			separator.setForeground(new Color(154, 205, 50));
			separator.setBounds(12, 133, 280, 2);
		}
		return separator;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC81C\uD488 \uCF54\uB4DC");
			lblNewLabel_2.setBackground(new Color(250, 240, 230));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_2.setBounds(12, 145, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC81C\uD488 \uBA85");
			lblNewLabel_3.setBackground(new Color(250, 240, 230));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_3.setBounds(12, 176, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC218\uB7C9");
			lblNewLabel_4.setBackground(new Color(250, 240, 230));
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_4.setBounds(12, 207, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uB0A0\uC9DC");
			lblNewLabel_5.setBackground(new Color(250, 240, 230));
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			lblNewLabel_5.setBounds(12, 238, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JTextField getPCode() {
		if (pCode == null) {
			pCode = new JTextField();
			pCode.setBounds(94, 143, 147, 21);
			pCode.setColumns(10);
		}
		return pCode;
	}
	private JTextField getPName() {
		if (pName == null) {
			pName = new JTextField();
			pName.setBounds(95, 174, 185, 21);
			pName.setColumns(10);
		}
		return pName;
	}
	private JTextField getEa() {
		if (ea == null) {
			ea = new JTextField();
			ea.setBounds(93, 205, 87, 21);
			ea.setColumns(10);
		}
		return ea;
	}
	private JTextField getNal() {
		if (nal == null) {
			nal = new JTextField();
			nal.setBounds(94, 236, 116, 21);
			nal.setColumns(10);
		}
		return nal;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1.setBackground(new Color(154, 205, 50));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					update();
				}
			});
			btnNewButton_1.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			btnNewButton_1.setBounds(72, 267, 62, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC0AD\uC81C");
			btnNewButton_2.setBackground(new Color(154, 205, 50));
			btnNewButton_2.setForeground(new Color(255, 255, 255));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					delete();
				}
			});
			btnNewButton_2.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			btnNewButton_2.setBounds(157, 267, 62, 23);
		}
		return btnNewButton_2;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uAC80\uC0C9\uD558\uC138\uC694.");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setForeground(new Color(255, 255, 255));
			status.setFont(new Font("타이포_스톰 B", Font.BOLD, 18));
			status.setOpaque(true);
			status.setBackground(new Color(154, 205, 50));
			status.setBounds(12, 300, 280, 33);
		}
		return status;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("\uC81C\uD488 \uC218\uC815/\uC0AD\uC81C");
			lblNewLabel_6.setFont(new Font("타이포_스톰 B", Font.BOLD, 35));
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_6.setBounds(12, 10, 280, 45);
		}
		return lblNewLabel_6;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(new Color(154, 205, 50));
			separator_1.setBackground(new Color(154, 205, 50));
			separator_1.setBounds(12, 65, 280, 2);
		}
		return separator_1;
	}
	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setOpaque(true);
			separator_2.setForeground(new Color(154, 205, 50));
			separator_2.setBackground(new Color(154, 205, 50));
			separator_2.setBounds(72, 133, 2, 129);
		}
		return separator_2;
	}
}
