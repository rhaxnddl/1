package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Withdraw extends JPanel {
	private JLabel lblNewLabel;
	private JTextField sNo;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField mName;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField amount;
	private JLabel lblNewLabel_4;
	private JTextField wAmt;
	private JButton btnNewButton_1;
	
	private int pos;
	private JLabel status;

	/**
	 * Create the panel.
	 */
	public Withdraw() {
		setLayout(null);
		add(getLblNewLabel());
		add(getSNo());
		add(getBtnNewButton());
		add(getLblNewLabel_1());
		add(getMName());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getAmount());
		add(getLblNewLabel_4());
		add(getWAmt());
		add(getBtnNewButton_1());
		add(getStatus());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uCD9C\uAE08");
			lblNewLabel.setForeground(SystemColor.activeCaption);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
			lblNewLabel.setBounds(12, 10, 296, 35);
		}
		return lblNewLabel;
	}
	private JTextField getSNo() {
		if (sNo == null) {
			sNo = new JTextField();
			sNo.setBounds(70, 55, 116, 21);
			sNo.setColumns(10);
		}
		return sNo;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DecimalFormat df = new DecimalFormat("##,###,###,###.#");
					String find = sNo.getText();
					pos = -1;
					for(int i=0; i<Bank.count; i++) {
						Account a = Bank.ac[i];
												
						if(a.getsNo().equals(find)) {
							mName.setText(a.getmName());
							amount.setText(df.format(a.getAmount()));
							pos = i;
							break;	
							// 계좌 정보가 없을때 출력
					   }else {
							status.setText("계좌 정보가 없습니다.");
							sNo.requestFocus(); 
							sNo.selectAll();
						}
					}
				}
			});
			btnNewButton.setBounds(198, 55, 63, 21);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC608\uAE08\uC8FC");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_1.setBounds(12, 95, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setEditable(false);
			mName.setBounds(70, 92, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uACC4\uC88C \uBC88\uD638");
			lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_2.setBounds(12, 55, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uD604 \uC794\uC561");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_3.setBounds(12, 131, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setEditable(false);
			amount.setBounds(70, 128, 116, 21);
			amount.setColumns(10);
		}
		return amount;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uCD9C\uAE08\uC561");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_4.setBounds(12, 168, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getWAmt() {
		if (wAmt == null) {
			wAmt = new JTextField();
			wAmt.setBounds(70, 165, 116, 21);
			wAmt.setColumns(10);
		}
		return wAmt;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uCD9C\uAE08 \uCC98\uB9AC");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					// 출금액에 문자나 공백이 있을때 출력
					try {
					long amt = Long.parseLong(wAmt.getText());
					if(pos>=0) { 
						Account a = Bank.ac[pos];
						// 출금액이 예금액보다 많을 때 출력
						if(a.getAmount()>=amt) {
							long temp = a.getAmount() - amt;
							a.setAmount(temp);							
						} else {
							status.setText("출금액이 예금액보다 많습니다.");
							wAmt.requestFocus();
						}
					} 
				} catch (Exception ex) {
					status.setText("출금액에 문자나 공백이 있습니다.");
					wAmt.requestFocus(); 
					wAmt.selectAll();
				} 
			   }
			});
			btnNewButton_1.setBounds(80, 196, 97, 23);
		}
		return btnNewButton_1;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setOpaque(true);
			status.setBackground(SystemColor.activeCaption);
			status.setBounds(12, 229, 296, 26);
		}
		return status;
	}
}
