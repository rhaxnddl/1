package l_ftp;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.awt.Color;

public class FileTransfer extends JPanel implements Runnable{
	long fileSize;
	String ip;
	int port; // 파일 전송을 하기 위한 port
	
	private JLabel fileName;
	private JProgressBar progressBar;
	private JLabel status;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public FileTransfer() {
		setPreferredSize(new Dimension(435, 70));
		setLayout(null);
		add(getFileName());
		add(getProgressBar());
		add(getStatus());
		add(getBtnNewButton());

	}
		
	public FileTransfer(String file) {
		this();
		getFileName().setText(file);
		File f = new File(file);
		fileSize = f.length();
		getStatus().setText("0/" + fileSize);
	}
	
	@Override
	public void run() {
		// 지정된 파일을 FileInputString으로 읽어서
	   // Socket의 DataOutoutStream으로 전송
		byte[] readData = new byte[4096]; // 4kb (4키로 바이트)
		int readSize = 0;
		long readTotSize = 0;
		getProgressBar().setValue(0);
		try {
		Socket socket = new Socket(ip, port);
		OutputStream os = socket.getOutputStream();
		
		FileInputStream fis = new FileInputStream(getFileName().getText());
		while((readSize = fis.read(readData)) != -1) {
			readTotSize += readSize;
			getStatus().setText(readTotSize + "/" + fileSize);
			getProgressBar().setValue((int)((double)readTotSize/fileSize*100));
			os.write(readData, 0, readSize);
		 }
		os.flush();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	JLabel getFileName() {
		if (fileName == null) {
			fileName = new JLabel("\uD30C\uC77C\uBA85 \uD45C\uC2DC");
			fileName.setBounds(12, 10, 364, 15);
		}
		return fileName;
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setBounds(11, 26, 364, 15);
		}
		return progressBar;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uC9C4\uD589 \uC0C1\uD0DC");
			status.setHorizontalAlignment(SwingConstants.RIGHT);
			status.setBounds(11, 45, 364, 15);
		}
		return status;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("X");
			btnNewButton.setForeground(new Color(255, 51, 0));
			btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 11));
			btnNewButton.setBounds(379, 26, 44, 15);
		}
		return btnNewButton;
	}
}
