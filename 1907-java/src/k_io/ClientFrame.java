package k_io;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClientFrame extends JFrame implements Runnable{ // 부모, 자식간의 관계(is a)

	Socket socket;
	
	HTMLEditorKit kit = new HTMLEditorKit();
	HTMLDocument doc = new HTMLDocument();
	
	ClientThread ct;
	
	DefaultListModel<String> model = new DefaultListModel<String>();
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField serverIP;
	private JLabel lblNewLabel_1;
	private JTextField port;
	private JLabel lblNewLabel_2;
	private JTextField tmId;
	private JLabel lblNewLabel_3;
	private JTextField tPwd;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane_1;
	private JTextPane textPane;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_2;
	private JComboBox comboBox;
	private JTextField message;
	private JButton btnNewButton_3;
	// 멤버들이 가지고 있는관계 (has a)
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
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
	public ClientFrame() {
		setTitle("\uCC44\uD305 \uD074\uB77C\uC774\uC5B8\uD2B8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getServerIP());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPort());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getTmId());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getTPwd());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getComboBox());
		contentPane.add(getMessage());
		contentPane.add(getBtnNewButton_3());
	}
	
	@Override
	public void run() {
		try {
			String ip = serverIP.getText();
			int p = Integer.parseInt(port.getText());
			socket = new Socket(ip,p); // socket을 만드는 순간 접속 (연결)
			
			ct = new ClientThread(ClientFrame.this, socket);
			ct.start();
		
		}catch(Exception ex) {
			System.out.println("ClientFrame.run()....");
			ex.printStackTrace();
		}
	}
	
	public void login() throws Exception{
		String mid = tmId.getText();
		String pwd = tPwd.getText(); // 현재 사용하지 않음
		String msg = "방가...";
		int cmd = ChattData.LOGIN;
		
		ChattData cd = new ChattData(mid, cmd, msg);
		ct.oos.writeObject(cd);
		ct.oos.flush();
	}
	
	public void send() {
		try {
			String mid = tmId.getText();
			String msg = message.getText();
			int cmd = ChattData.MESSAGE;
			ChattData cd = new ChattData(mid, cmd, msg);
			
			if(socket.isConnected()) {
				ct.oos.writeObject(cd);
				ct.oos.flush();
			}
			
		}catch(Exception ex) {
			
		}
		message.setText("");
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC11C\uBC84");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 43, 21);
		}
		return lblNewLabel;
	}
	private JTextField getServerIP() {
		if (serverIP == null) {
			serverIP = new JTextField();
			serverIP.setBounds(67, 7, 116, 21);
			serverIP.setColumns(10);
			
			try{
				InetAddress local = InetAddress.getLocalHost();
				serverIP.setText(local.getHostAddress());
			}catch(Exception ex) {
				
			}
		}
		return serverIP;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("PORT");
			lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(209, 10, 54, 21);
		}
		return lblNewLabel_1;
	}
	private JTextField getPort() {
		if (port == null) {
			port = new JTextField();
			port.setText("4444");
			port.setBounds(264, 7, 116, 21);
			port.setColumns(10);
		}
		return port;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 18));
			lblNewLabel_2.setBounds(12, 41, 54, 21);
		}
		return lblNewLabel_2;
	}
	private JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setText("Lee");
			tmId.setBounds(67, 38, 116, 24);
			tmId.setColumns(10);
		}
		return tmId;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC554\uD638");
			lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 18));
			lblNewLabel_3.setBounds(209, 35, 43, 27);
		}
		return lblNewLabel_3;
	}
	private JTextField getTPwd() {
		if (tPwd == null) {
			tPwd = new JTextField();
			tPwd.setText("1234");
			tPwd.setBounds(264, 38, 116, 24);
			tPwd.setColumns(10);
		}
		return tPwd;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC811\uC18D");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Thread t = new Thread(ClientFrame.this);
					t.start();
				}
			});
			btnNewButton.setBounds(392, 4, 67, 27);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uD574\uC81C");
			btnNewButton_1.setBounds(392, 36, 67, 27);
		}
		return btnNewButton_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 83, 148, 252);
			scrollPane.setViewportView(getList());
			scrollPane.setColumnHeaderView(getLblNewLabel_4());
		}
		return scrollPane;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setModel(model);
		}
		return list;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC811\uC18D\uC790 \uBAA9\uB85D");
		}
		return lblNewLabel_4;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(172, 83, 287, 282);
			scrollPane_1.setViewportView(getTextPane());
			scrollPane_1.setColumnHeaderView(getLblNewLabel_5());
		}
		return scrollPane_1;
	}
	public JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setContentType("text/html"); // mime type
			
			textPane.setEditorKit(kit);
			textPane.setDocument(doc);
		}
		return textPane;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uBA54\uC138\uC9C0");
		}
		return lblNewLabel_5;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uD574\uC81C");
			btnNewButton_2.setBounds(12, 345, 148, 23);
		}
		return btnNewButton_2;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(12, 378, 148, 21);
			
			comboBox.addItem("전체");
			comboBox.addItem("귓속말");
		}
		return comboBox;
	}
	private JTextField getMessage() {
		if (message == null) {
			message = new JTextField();
			message.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					send();
					}
				}
			});
			message.setBounds(172, 375, 216, 21);
			message.setColumns(10);
		}
		return message;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("\uC804\uC1A1");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					send();
				}
			});
			btnNewButton_3.setBounds(392, 377, 67, 23);
		}
		return btnNewButton_3;
	}
}
