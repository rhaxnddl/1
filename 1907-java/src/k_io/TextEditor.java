package k_io;

import java.awt.EventQueue;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextEditor extends JInternalFrame {
	String fileName;
	public JLabel status;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	boolean modifyFlag = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEditor frame = new TextEditor();
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
	public TextEditor() {
		super("noname", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 332, 267);
		getContentPane().add(getStatus(), BorderLayout.SOUTH);
		getContentPane().add(getScrollPane_1(), BorderLayout.CENTER);

	}
	public TextEditor(String fileName) {
		this();
		this.fileName = fileName;
		setTitle(fileName);
		load();
	}
	public void load() {
		try {
			FileReader fr = new FileReader(fileName);
			char[] data = new char[100];
			int readData = 0; // 읽은 데이터의 크기
			textArea.setText("");
			while((readData = fr.read(data)) != -1) {
				String temp = new String(data, 0, readData);
				textArea.append(temp);
			}
			fr.close();
		}catch(Exception ex) {
			
		}
	}
	public boolean save() {
		boolean b = true;
		
		if(modifyFlag) return b;
		
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(textArea.getText());
			fw.flush();
			fw.close();
			setTitle(fileName);
			
		}catch(Exception ex) {
			b = false;
		}
		return b;
	}
	public JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setForeground(Color.WHITE);
			status.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			status.setOpaque(true);
			status.setBackground(new Color(153, 102, 204));
			status.setPreferredSize(new Dimension(0, 25));
			status.setSize(new Dimension(25, 25));
			status.setLocation(new Point(25, 0));
		}
		return status;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	private JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent ev) {
					modifyFlag = true;
					if(ev.getKeyCode() != KeyEvent.VK_SHIFT && 
					   ev.getKeyCode() != KeyEvent.VK_ALT && 
					   ev.getKeyCode() != KeyEvent.VK_CONTROL &&
					   ev.getKeyCode() != KeyEvent.VK_HOME && 
					   ev.getKeyCode() != KeyEvent.VK_END && 
					   ev.getKeyCode() != KeyEvent.VK_PAGE_UP &&
					   ev.getKeyCode() != KeyEvent.VK_PAGE_DOWN &&
					   ev.getKeyCode() != KeyEvent.VK_LEFT && 
					   ev.getKeyCode() != KeyEvent.VK_RIGHT &&
					   ev.getKeyCode() != KeyEvent.VK_UP &&
					   ev.getKeyCode() != KeyEvent.VK_DOWN) {
						
						modifyFlag = true;
						if(fileName == null) {
							setTitle("noname(*)");
						}else {
						setTitle(fileName + "(*)");
						}
					}
				}
			});
			textArea.setBackground(new Color(204, 204, 255));
		}
		return textArea;
	}
}
