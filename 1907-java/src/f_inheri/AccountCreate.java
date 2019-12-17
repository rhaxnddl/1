package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AccountCreate extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField sNo;
	private JLabel lblNewLabel_2;
	private JTextField mName;
	private JLabel lblNewLabel_3;
	private JTextField amount;
	private JButton btnNewButton;
	private JLabel status;

	/**
	 * Create the panel.
	 */
	public AccountCreate() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getSNo());
		add(getLblNewLabel_2());
		add(getMName());
		add(getLblNewLabel_3());
		add(getAmount());
		add(getBtnNewButton());
		add(getStatus());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uACC4\uC815 \uC0DD\uC131");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(SystemColor.activeCaption);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
			lblNewLabel.setBounds(12, 10, 327, 34);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uACC4\uC88C \uBC88\uD638");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(12, 63, 72, 28);
		}
		return lblNewLabel_1;
	}
	private JTextField getSNo() {
		if (sNo == null) {
			sNo = new JTextField();
			sNo.setBounds(96, 67, 110, 21);
			sNo.setColumns(10);
		}
		return sNo;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC608\uAE08\uC8FC");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(12, 101, 72, 28);
		}
		return lblNewLabel_2;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(96, 105, 110, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC608\uAE08\uC561");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(12, 139, 72, 28);
		}
		return lblNewLabel_3;
	}
	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setBounds(96, 143, 110, 21);
			amount.setColumns(10);
		}
		return amount;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCD94\uAC00");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 모든 항목이 입력되었는가? 체크
					if(!sNo.getText().equals("") && !mName.getText().equals("") && !amount.getText().equals(""))
					{ 
						// try {  }catch(Exception ex)
						try {			
							//계좌번호의 중복 여부 체크
							for(int i=0; i<Bank.count; i++) {
								Account a = Bank.ac[i];
								if(a.getsNo().equals(sNo.getText())) {
									throw new IOException("계좌번호가 중복되었습니다.");
								}
							}
							// 예금액이 숫자로만 이루어졌는지 체크

						Long amt = Long.parseLong(amount.getText());
						Account ac = new Account(mName.getText(),sNo.getText(),amt);
			            Bank.ac[Bank.count] = ac;
			            Bank.count++;
			            
			            status.setText(Bank.count + " 번째 고객이 등록되었습니다.");
			            mName.setText("");
			            amount.setText("");
			            sNo.requestFocus();
			            sNo.selectAll();    
			            //  선택 영역.requestFocus(); : 선택한 곳으로 커서이동
			            // 선택 영역.selectAll(); : 선택한 곳을 모두 선택
						}catch(IOException ex2) {
							status.setText(ex2.getMessage());
							sNo.requestFocus();
							sNo.selectAll();
			            
						} catch(Exception ex) {
							status.setText("예금액에 문자나 공백이 있습니다.");
							amount.requestFocus(); 
							amount.selectAll();
						}
					} else {
						status.setText("입력항목을 확인하세요.");
						amount.requestFocus();
					}
				}
			});
			btnNewButton.setBounds(147, 174, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setOpaque(true);
			status.setBackground(SystemColor.activeCaption);
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setBounds(12, 207, 343, 28);
		}
		return status;
	}
}
