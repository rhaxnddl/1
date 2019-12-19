package j_collection;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class MemberMain extends JFrame {
	
	List<MemberVo> list = new ArrayList<MemberVo>(); // size´Â 10°³, °¹¼ö°¡ 11°³°¡ µÉ¶§ 20°³·Î ´Ã¾î³² 
	
	private JDesktopPane contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMain frame = new MemberMain();
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
	public MemberMain() {
		setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		setTitle("\uD68C\uC6D0 \uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 434);
		setJMenuBar(getMenuBar_1());
		contentPane = new JDesktopPane();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// sample data insert
		for(int i=0; i<500; i++) {
			MemberVo vo = new MemberVo("no"+i, "pwd"+i, "name"+i, "010-1111-"+i);
			list.add(vo);
		}
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(new Color(100, 149, 237));
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uD68C\uC6D0 \uAD00\uB9AC");
			mnNewMenu.setBackground(new Color(100, 149, 237));
			mnNewMenu.setForeground(new Color(255, 255, 255));
			mnNewMenu.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem_2());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uC785\uB825");
			mntmNewMenuItem.setForeground(new Color(255, 255, 255));
			mntmNewMenuItem.setBackground(new Color(100, 149, 237));
			mntmNewMenuItem.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { // ÀÔ·Â					
					MemberInput m = new MemberInput(list);
					contentPane.add(m);
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uC870\uD68C");
			mntmNewMenuItem_1.setForeground(new Color(255, 255, 255));
			mntmNewMenuItem_1.setBackground(new Color(100, 149, 237));
			mntmNewMenuItem_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { // Á¶È¸					
					MemberSearch m = new MemberSearch(list);
					contentPane.add(m);
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uC218\uC815&\uC0AD\uC81C");
			mntmNewMenuItem_2.setForeground(new Color(255, 255, 255));
			mntmNewMenuItem_2.setBackground(new Color(100, 149, 237));
			mntmNewMenuItem_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { // ¼öÁ¤&»èÁ¦					
					MemberModify m = new MemberModify(list);
					contentPane.add(m);
				}
			});
		}
		return mntmNewMenuItem_2;
	}
}
