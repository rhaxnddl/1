package k_io;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Rectangle;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ServerFrame extends JFrame implements Runnable{

	ServerSocket server;
	
	HTMLEditorKit kit = new HTMLEditorKit(); 
	HTMLDocument doc = new HTMLDocument();  
	
	List<ServerThread> clients = new ArrayList<ServerThread>();
	DefaultListModel<String> model = new DefaultListModel<String>();
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField port;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_1;
	private JTextPane textPane;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JComboBox comboBox;
	private JTextField message;
	private JButton btnNewButton_4;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame frame = new ServerFrame();
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
	public ServerFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				serverStop();
			}
		});
		setTitle("\uCC44\uD305 \uC11C\uBC84");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPort());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getBtnNewButton_3());
		contentPane.add(getComboBox());
		contentPane.add(getMessage());
		contentPane.add(getBtnNewButton_4());
	}
	
	@Override
	public void run() {
		try {
			int p = Integer.parseInt(port.getText());
			server = new ServerSocket(p);
			String html = "<font size='5' color='#0000ff'>서버가 시작됨</font>";
			kit.insertHTML(doc, doc.getLength(), html, 0, 0, null);
			
			
			while(true) {
				html = "[클라이언트 접속 대기중]";
				kit.insertHTML(doc, doc.getLength(), html, 0, 0, null);
				
				Socket clientSocket = server.accept();// 클라이언트가 접속될때까지 대기, 접속 후 아래 코드 출력 // 데이터를 접속만 하는 스레드
				ServerThread st = new ServerThread(ServerFrame.this, clientSocket);
				st.start();
				clients.add(st);
				
				InetSocketAddress addr = (InetSocketAddress)clientSocket.getRemoteSocketAddress();
				html = "<div style='border:1px solid #ff0000;padding:5px;width:150px'>"
						+ addr.getAddress().getHostAddress() + " 님이 접속함" + "</div>";
				kit.insertHTML(doc, doc.getLength(), html, 0, 0, null);
				
				textPane.scrollRectToVisible(new Rectangle(0, textPane.getHeight()+100, 1, 1));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void send() { // enter, 전송 버틍
		ChattData cd = new ChattData();
		cd.setmId("SERVER");
		cd.setCommand(ChattData.MESSAGE);
		cd.setMessage(message.getText());
		sendAll(cd);
		
		message.setText("");
	}
	
	public void sendAll(ChattData cd) {
		for(ServerThread st : clients) {
			try {
			st.oos.writeObject(cd);
			st.oos.flush();
			} catch(Exception ex) {
				
			}
		}
	}
	
	public void SendAll(int[] to) { // 귓속말
		
	}
	
	// 1. 모든 유저들에게 서버 종료를 통보 (GETOUT)
	// 2. clients의 ServerThread를 종료
	// 3. 접속자 목록을 모두 종료
	// 4. serverSocket 종료
	public void serverStop() {
		ChattData cd = new ChattData();
		cd.setCommand(ChattData.GETOUT);
		cd.setmId("SERVER");
		sendAll(cd); // 1번
		
		clients.clear();
		clients = new ArrayList<ServerThread>(); // 2번
		
		model.clear();
		
		try {
		server.close();
		server = null;
		} catch(Exception ex) {
			
		}
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("IP");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 28, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(52, 7, 94, 21);
			textField.setColumns(10);
			
			try{
				InetAddress local = InetAddress.getLocalHost();
				textField.setText(local.getHostAddress());
			}catch(Exception ex) {
				
			}
		}
		return textField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("PORT");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(158, 10, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getPort() {
		if (port == null) {
			port = new JTextField();
			port.setText("4444");
			port.setBounds(224, 7, 116, 21);
			port.setColumns(10);
		}
		return port;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC2DC\uC791");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Thread t = new Thread(ServerFrame.this);
					t.start();					
				}
			});
			btnNewButton.setFont(new Font("굴림", Font.PLAIN, 15));
			btnNewButton.setBounds(352, 8, 69, 20);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC885\uB8CC");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					serverStop();
				}
			});
			btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 15));
			btnNewButton_1.setBounds(433, 6, 69, 23);
		}
		return btnNewButton_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 53, 152, 296);
			scrollPane.setViewportView(getList());
			scrollPane.setColumnHeaderView(getLblNewLabel_2());
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
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC811\uC18D\uC790 \uBAA9\uB85D");
			lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 15));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_2;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(176, 51, 326, 331);
			scrollPane_1.setViewportView(getTextPane());
			scrollPane_1.setColumnHeaderView(getLblNewLabel_3());
		}
		return scrollPane_1;
	}
	public JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setContentType("text/html");
			textPane.setEditorKit(kit);
			textPane.setDocument(doc);
		}
		return textPane;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uAC15\uD1F4");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Object[] indexs = getList().getSelectedValues();
					ChattData cd = new ChattData();
					cd.setCommand(ChattData.GETOUT);
					cd.setmId("SERVER");
					List<String> users = new ArrayList<String>();
					for(int i=0; i<indexs.length; i++) {
						users.add((String)indexs[i]);
					}
					cd.setUsers(users);
					sendAll(cd);					
				}
			});
			btnNewButton_2.setBounds(12, 359, 73, 23);
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("\uD574\uC81C");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getList().clearSelection();
				}
			});
			btnNewButton_3.setBounds(88, 359, 73, 23);
		}
		return btnNewButton_3;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(12, 392, 152, 21);
			
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
			message.setBounds(176, 392, 260, 21);
			message.setColumns(10);
		}
		return message;
	}
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("\uC804\uC1A1");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					send();
				}
			});
			btnNewButton_4.setBounds(440, 391, 62, 23);
		}
		return btnNewButton_4;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uBA54\uC138\uC9C0");
			lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 15));
		}
		return lblNewLabel_3;
	}
}
