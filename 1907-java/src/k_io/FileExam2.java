package k_io;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FileExam2 extends JFrame {

	private JDesktopPane contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileExam2 frame = new FileExam2();
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
	public FileExam2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 539);
		contentPane = new JDesktopPane();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getMenuBar_1());
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(new Color(153, 102, 204));
			menuBar.setBounds(0, 0, 840, 29);
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
			menuBar.add(getMnNewMenu_2());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("File");
			mnNewMenu.setForeground(new Color(255, 255, 255));
			mnNewMenu.setOpaque(true);
			mnNewMenu.setBackground(new Color(153, 102, 204));
			mnNewMenu.setFont(new Font("타이포_쌍문동 B", Font.BOLD, 18));
			mnNewMenu.add(getMntmNewMenuItem());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uD30C\uC77C\uBCF5\uC0AC");
			mntmNewMenuItem.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			mntmNewMenuItem.setForeground(new Color(255, 255, 255));
			mntmNewMenuItem.setOpaque(true);
			mntmNewMenuItem.setBackground(new Color(153, 102, 204));
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FileCopy panel = new FileCopy();
					contentPane.add(panel);
					panel.toFront();
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("\uD30C\uC77C \uD3B8\uC9D1");
			mnNewMenu_1.setForeground(Color.WHITE);
			mnNewMenu_1.setOpaque(true);
			mnNewMenu_1.setBackground(new Color(153, 102, 204));
			mnNewMenu_1.setFont(new Font("타이포_쌍문동 B", Font.BOLD, 18));
			mnNewMenu_1.add(getMntmNewMenuItem_1());
			mnNewMenu_1.add(getMntmNewMenuItem_2());
			mnNewMenu_1.add(getMntmNewMenuItem_3());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uBD88\uB7EC\uC624\uAE30");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JFileChooser fc = new JFileChooser();
					int flag = fc.showOpenDialog(FileExam2.this);
					if(flag == JFileChooser.APPROVE_OPTION) {
						String fileName = fc.getSelectedFile().getPath();
						TextEditor panel = new TextEditor(fileName);
						contentPane.add(panel);
						panel.toFront();
					}
					
				}
			});
			mntmNewMenuItem_1.setOpaque(true);
			mntmNewMenuItem_1.setBackground(new Color(153, 102, 204));
			mntmNewMenuItem_1.setForeground(Color.WHITE);
			mntmNewMenuItem_1.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uC800\uC7A5\uD558\uAE30");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {					
					JInternalFrame frame = contentPane.getSelectedFrame();
					if(frame instanceof TextEditor) {
						TextEditor te = (TextEditor)frame;
						
						// 새로만들기를 한 경우엔 TextEditor의 fileName이 null
						if(te.fileName == null) {
							JFileChooser fc = new JFileChooser();
							int flag = fc.showSaveDialog(FileExam2.this);
							
							if(flag == JFileChooser.APPROVE_OPTION) {
								te.fileName = fc.getSelectedFile().getPath();
								te.setTitle(te.fileName);
							}else {
								te.getStatus().setText("파일 저장 작업이 취소되었습니다.");
								return;
							}
						}
						
						boolean b = te.save();
						if(b) {
							te.getStatus().setText("파일이 정상적으로 저장됨");
						}else {
							te.getStatus().setText("파일 저장중 오류 발생");
						}
					}
				}
			});
			mntmNewMenuItem_2.setOpaque(true);
			mntmNewMenuItem_2.setBackground(new Color(153, 102, 204));
			mntmNewMenuItem_2.setForeground(Color.WHITE);
			mntmNewMenuItem_2.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
		}
		return mntmNewMenuItem_2;
	}
	private JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("\uC0C8\uB85C\uB9CC\uB4E4\uAE30");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TextEditor panel = new TextEditor();
					contentPane.add(panel);
					panel.toFront();
				}
			});
			mntmNewMenuItem_3.setOpaque(true);
			mntmNewMenuItem_3.setBackground(new Color(153, 102, 204));
			mntmNewMenuItem_3.setForeground(Color.WHITE);
			mntmNewMenuItem_3.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
		}
		return mntmNewMenuItem_3;
	}
	private JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("\uD68C\uC6D0\uAD00\uB9AC");
			mnNewMenu_2.setForeground(Color.WHITE);
			mnNewMenu_2.setFont(new Font("타이포_쌍문동 B", Font.BOLD, 18));
			mnNewMenu_2.setOpaque(true);
			mnNewMenu_2.setBackground(new Color(153, 102, 204));
			mnNewMenu_2.add(getMntmNewMenuItem_4());
			mnNewMenu_2.add(getMntmNewMenuItem_5());
			mnNewMenu_2.add(getMntmNewMenuItem_6());
		}
		return mnNewMenu_2;
	}
	private JMenuItem getMntmNewMenuItem_4() {
		if (mntmNewMenuItem_4 == null) {
			mntmNewMenuItem_4 = new JMenuItem("\uD68C\uC6D0 \uC785\uB825");
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberInput panel = new MemberInput();
					contentPane.add(panel);
					panel.toFront();
				}
			});
			mntmNewMenuItem_4.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			mntmNewMenuItem_4.setForeground(Color.WHITE);
			mntmNewMenuItem_4.setOpaque(true);
			mntmNewMenuItem_4.setBackground(new Color(153, 102, 204));
		}
		return mntmNewMenuItem_4;
	}
	private JMenuItem getMntmNewMenuItem_5() {
		if (mntmNewMenuItem_5 == null) {
			mntmNewMenuItem_5 = new JMenuItem("\uD68C\uC6D0 \uC870\uD68C");
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberSearch panel = new MemberSearch();
					contentPane.add(panel);
					panel.toFront();
				}
			});
			mntmNewMenuItem_5.setForeground(Color.WHITE);
			mntmNewMenuItem_5.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			mntmNewMenuItem_5.setOpaque(true);
			mntmNewMenuItem_5.setBackground(new Color(153, 102, 204));
		}
		return mntmNewMenuItem_5;
	}
	private JMenuItem getMntmNewMenuItem_6() {
		if (mntmNewMenuItem_6 == null) {
			mntmNewMenuItem_6 = new JMenuItem("\uD68C\uC6D0 \uC218\uC815/\uC0AD\uC81C");
			mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {				
					MemberModify panel = new MemberModify();
					contentPane.add(panel);
					panel.toFront();
				}
			});
			mntmNewMenuItem_6.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			mntmNewMenuItem_6.setForeground(Color.WHITE);
			mntmNewMenuItem_6.setOpaque(true);
			mntmNewMenuItem_6.setBackground(new Color(153, 102, 204));
		}
		return mntmNewMenuItem_6;
	}
}
