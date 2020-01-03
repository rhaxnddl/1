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
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.Color;

public class FileTransferReceive extends JPanel implements Runnable{
	long fileSize;
	
	int port;
	FileOutputStream fos;
	Socket socket;
	InputStream is;
	
	private JLabel fileName;
	private JProgressBar progressBar;
	private JLabel status;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public FileTransferReceive() {
		setPreferredSize(new Dimension(435, 70));
		setLayout(null);
		add(getFileName());
		add(getProgressBar());
		add(getStatus());
		add(getBtnNewButton());
	}
		
	public FileTransferReceive(int port, String file, long fileSize) {
		this();
		this.port = port;
		this.fileSize = fileSize;
		
		getFileName().setText(file);
		getStatus().setText("0/" + fileSize);
		
		try {
			ServerSocket ss = new ServerSocket(port);
			socket = ss.accept();
			Thread t = new Thread(this);
			t.start();
		}catch(Exception ex) {
			
		}
		
	}
	
	@Override
	public void run() {
		// 지정된 파일을 FileInputString으로 읽어서
	   // Socket의 DataOutoutStream으로 전송
		byte[] readData = new byte[4096]; // 4키로 바이트
		int readSize = 0;
		long readTotSize = 0;
		try {
		FileOutputStream fos = new FileOutputStream(getFileName().getText());
		is = socket.getInputStream();
		while((readSize = is.read(readData)) != -1) {
			readTotSize += readSize;
			getStatus().setText(readTotSize + "/" + fileSize);
			getProgressBar().setValue((int)((double)readTotSize/fileSize*100));
			
			fos.write(readData, 0, readSize);
		 }
		fos.flush();
		fos.close();
		is.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private JLabel getFileName() {
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
