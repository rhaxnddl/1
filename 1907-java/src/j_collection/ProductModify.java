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
		setVisible(true);
		setBounds(100, 100, 320, 283);
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
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	private JRadioButton getImBtn() {
		if (imBtn == null) {
			imBtn = new JRadioButton("\uC785\uACE0");
			imBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			imBtn.setBounds(72, 6, 62, 23);
			group.add(imBtn);
			imBtn.setSelected(true);
		}
		return imBtn;
	}
	private JRadioButton getExBtn() {
		if (exBtn == null) {
			exBtn = new JRadioButton("\uCD9C\uACE0");
			exBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			exBtn.setBounds(138, 7, 63, 23);
			group.add(exBtn);
		}
		return exBtn;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("serial");
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_1.setBounds(12, 35, 57, 18);
		}
		return lblNewLabel_1;
	}
	private JTextField getSerial() {
		if (serial == null) {
			serial = new JTextField();
			serial.setBounds(74, 32, 116, 21);
			serial.setColumns(10);
		}
		return serial;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {					
					search();
				}
			});
			btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			btnNewButton.setBounds(202, 31, 81, 23);
		}
		return btnNewButton;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(new Color(255, 204, 0));
			separator.setBounds(12, 60, 280, 2);
		}
		return separator;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC81C\uD488 \uCF54\uB4DC");
			lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_2.setBounds(12, 72, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC81C\uD488 \uBA85");
			lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_3.setBounds(12, 97, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC218\uB7C9");
			lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_4.setBounds(12, 122, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uB0A0\uC9DC");
			lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_5.setBounds(12, 147, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JTextField getPCode() {
		if (pCode == null) {
			pCode = new JTextField();
			pCode.setBounds(72, 69, 147, 21);
			pCode.setColumns(10);
		}
		return pCode;
	}
	private JTextField getPName() {
		if (pName == null) {
			pName = new JTextField();
			pName.setBounds(74, 94, 209, 21);
			pName.setColumns(10);
		}
		return pName;
	}
	private JTextField getEa() {
		if (ea == null) {
			ea = new JTextField();
			ea.setBounds(74, 119, 81, 21);
			ea.setColumns(10);
		}
		return ea;
	}
	private JTextField getNal() {
		if (nal == null) {
			nal = new JTextField();
			nal.setBounds(74, 144, 116, 21);
			nal.setColumns(10);
		}
		return nal;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					update();
				}
			});
			btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			btnNewButton_1.setBounds(72, 175, 62, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC0AD\uC81C");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					delete();
				}
			});
			btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			btnNewButton_2.setBounds(157, 175, 62, 23);
		}
		return btnNewButton_2;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
			status.setOpaque(true);
			status.setBackground(new Color(255, 204, 0));
			status.setBounds(12, 211, 280, 33);
		}
		return status;
	}
}
