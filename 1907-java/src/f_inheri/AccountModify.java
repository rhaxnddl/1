package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountModify extends JPanel {
	private JLabel lblNewLabel;
	private JTextField sNo;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField mName;
	private JTextField amount;
	private JButton btnNewButton_1;

	private int pos; // 검색된 고객의 위치 번호
	private JLabel status;

	/**
	 * Create the panel.
	 */
	public AccountModify() {
		setLayout(null);
		add(getLblNewLabel());
		add(getSNo());
		add(getBtnNewButton());
		add(getLblNewLabel_1());
		add(getMName());
		add(getLblNewLabel_2());
		add(getAmount());
		add(getBtnNewButton_1());
		add(getStatus());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uACC4\uC815 \uC815\uBCF4 \uC218\uC815");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(SystemColor.activeCaption);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
			lblNewLabel.setBounds(12, 10, 426, 35);
		}
		return lblNewLabel;
	}
	private JTextField getSNo() {
		if (sNo == null) {
			sNo = new JTextField();
			sNo.setBounds(102, 55, 165, 21);
			sNo.setColumns(10);
		}
		return sNo;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String find = sNo.getText();
					pos = -1; //검색버튼이 클릭될때마다 pos의 정수값을 찾지 못했다.
					for(int i= 0; i<Bank.count; i++) {
						Account a = Bank.ac[i];
						if(a.getsNo().equals(find)) {
							mName.setText(a.getmName());
							amount.setText(a.getAmount()+"");
							pos = i; // 클릭될때 바다 pos가 초기화 되기 전 i의 값을 찾았다.
							break;
						}
					}
				}
			});
			btnNewButton.setBounds(279, 54, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC608\uAE08\uC8FC");
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(12, 104, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC608\uAE08\uC561");
			lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(12, 149, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(69, 101, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setBounds(69, 146, 116, 21);
			amount.setColumns(10);
		}
		return amount;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815 \uD655\uC778");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(!mName.getText().equals("") && !amount.getText().equals("")) {
					  try {						  					  					
					if(pos>=0) {
					Account a = Bank.ac[pos];
					Long amt = Long.parseLong(amount.getText());
					a.setmName(mName.getText());
					a.setAmount(amt);
					}
				   } catch(Exception ex) {
					   status.setText("예금액에 문자나 공백이 있습니다.");
					   amount.requestFocus();
					   amount.selectAll();
				   }
				  } else {
					  status.setText("입력항목을 확인하세요");
					  amount.requestFocus();
				  }
				}
			});
			btnNewButton_1.setBounds(158, 216, 97, 23);
		}
		return btnNewButton_1;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setOpaque(true);
			status.setBackground(SystemColor.activeCaption);
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setBounds(12, 255, 413, 35);
		}
		return status;
	}
}
