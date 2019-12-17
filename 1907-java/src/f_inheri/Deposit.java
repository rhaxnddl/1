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

public class Deposit extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField sNo;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JTextField mName;
	private JLabel lblNewLabel_3;
	private JTextField amount;
	private JButton btnNewButton_1;
	private int pos;
	private JLabel status;

	/**
	 * Create the panel.
	 */
	public Deposit() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getSNo());
		add(getBtnNewButton());
		add(getLblNewLabel_2());
		add(getMName());
		add(getLblNewLabel_3());
		add(getAmount());
		add(getBtnNewButton_1());
		add(getStatus());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC608\uAE08");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(SystemColor.activeCaption);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
			lblNewLabel.setBounds(12, 10, 340, 46);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uACC4\uC88C \uBC88\uD638");
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_1.setBounds(22, 66, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getSNo() {
		if (sNo == null) {
			sNo = new JTextField();
			sNo.setBounds(91, 66, 116, 21);
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
					pos = -1;					
					for(int i=0; i<Bank.count; i++) {
						Account a = Bank.ac[i];

						  if(a.getsNo().equals(find)) {
							mName.setText(a.getmName());
							pos = i;
							} else {
							status.setText("계좌정보가 없습니다.");
							amount.requestFocus(); 
							amount.selectAll();
						}
															
				}
			 }
				
			});
			btnNewButton.setBounds(219, 63, 66, 23);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC608\uAE08\uC8FC");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_2.setBounds(22, 110, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setEditable(false);
			mName.setBounds(91, 107, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC608\uAE08\uC561");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_3.setBounds(22, 147, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setBounds(91, 145, 116, 21);
			amount.setColumns(10);
		}
		return amount;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC785\uAE08 \uCC98\uB9AC");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!amount.getText().equals("")) {
						try {
					Long amt = Long.parseLong(amount.getText());
					// 문자열은 숫자열이 될 수 없다. 반드시 형변환을 사용 
					if(pos>=0) { 
					Account a = Bank.ac[pos];
					long temp = a.getAmount()+ amt;
					a.setAmount(temp);
					} 
					} catch(Exception ex) {
						status.setText("예금액에 문자나 공백이 있습니다.");
						amount.requestFocus(); 
						amount.selectAll();}
					
					} else {
						status.setText("입력항목을 확인하세요.");
						amount.requestFocus();					
					}
				}
			});
			btnNewButton_1.setBounds(128, 198, 97, 23);
		}
		return btnNewButton_1;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setOpaque(true);
			status.setBackground(SystemColor.activeCaption);
			status.setBounds(12, 231, 340, 27);
		}
		return status;
	}
}
