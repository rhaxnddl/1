package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.text.DecimalFormat;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AccountList extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public AccountList() {
		setLayout(null);
		add(getLblNewLabel());
		add(getScrollPane());
		showList();
	}
	
	public void showList(){
		String str = "";
		DecimalFormat df = new DecimalFormat("##,###,###,###.#");
		
		
		for(int i = 0; i<Bank.count; i++) {
			Account a = Bank.ac[i];
			str +=a.getsNo();		
			str += "\t" + a.getmName();
			str += "\t" + df.format(a.getAmount());
			str += "\n";
		}
		textArea.setText(str);// textArea에 들어있는 값을 다시 설정해라(setText)
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uACC4\uC815 \uBAA9\uB85D");
			lblNewLabel.setForeground(SystemColor.activeCaption);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
			lblNewLabel.setBounds(12, 10, 385, 40);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 60, 385, 203);
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getLblNewLabel_1());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uACC4\uC88C \uBC88\uD638           \uC608\uAE08\uC8FC                 \uC608\uAE08 \uC794\uC561");
		}
		return lblNewLabel_1;
	}
}
