//2019.12.19
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class MemberMain extends JFrame {
	
	List<MemberVo> list = new ArrayList<MemberVo>(); // size´Â 10°³, °¹¼ö°¡ 11°³°¡ µÉ¶§ 20°³·Î ´Ã¾î³² 

	// Product¿¡ °ü·ÃµÈ »ý¼ºÀÚ
	Set<ProductVo> piList = new HashSet<ProductVo>(); // ÀÔ°í ¸®½ºÆ®
	Set<ProductVo> peList = new HashSet<ProductVo>(); // Ãâ°í ¸®½ºÆ®
	static int iSerial = 1; // ÀÔ°íÀÇ ¼ø¹ø
	static int eSerial = 1; // Ãâ°íÀÇ ¼ø¹ø
	
	private JDesktopPane contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_3;
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
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// sample data insert
		for(int i=0; i<500; i++) {
			MemberVo vo = new MemberVo("no"+i, "pwd"+i, "name"+i, "010-1111-"+i);
			list.add(vo);
		}
		
		// ÀÔ°í (iSerial), Ãâ°í (eSerial) sample data
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0; i<100; i++) {
			String tempSerial = sdf.format(new Date()) + "-" + MemberMain.iSerial;
			ProductVo vo = new ProductVo(tempSerial, "pCode" + i, "pName" + i, 3000, new Date());
			piList.add(vo);
			peList.add(vo);
			MemberMain.iSerial++;
			MemberMain.eSerial++;
		}
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(new Color(100, 149, 237));
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
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
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("\uC790\uC7AC \uAD00\uB9AC");
			mnNewMenu_1.setBackground(new Color(100, 149, 237));
			mnNewMenu_1.setForeground(Color.WHITE);
			mnNewMenu_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			mnNewMenu_1.add(getMntmNewMenuItem_3());
			mnNewMenu_1.add(getMntmNewMenuItem_4());
			mnNewMenu_1.add(getMntmNewMenuItem_5());
			mnNewMenu_1.add(getMntmNewMenuItem_6());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("\uC785\uACE0");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProductInput panel = new ProductInput(piList);
					contentPane.add(panel);
				}
			});
			mntmNewMenuItem_3.setBackground(new Color(100, 149, 237));
			mntmNewMenuItem_3.setForeground(Color.WHITE);
			mntmNewMenuItem_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		}
		return mntmNewMenuItem_3;
	}
	private JMenuItem getMntmNewMenuItem_4() {
		if (mntmNewMenuItem_4 == null) {
			mntmNewMenuItem_4 = new JMenuItem("\uCD9C\uACE0");
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProductOutput panel = new ProductOutput(peList);
					contentPane.add(panel);
				}
			});
			mntmNewMenuItem_4.setBackground(new Color(100, 149, 237));
			mntmNewMenuItem_4.setForeground(Color.WHITE);
			mntmNewMenuItem_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		}
		return mntmNewMenuItem_4;
	}
	private JMenuItem getMntmNewMenuItem_5() {
		if (mntmNewMenuItem_5 == null) {
			mntmNewMenuItem_5 = new JMenuItem("\uC870\uD68C");
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProductSearch panel = new ProductSearch(peList, piList);
					contentPane.add(panel);
				}
			});
			mntmNewMenuItem_5.setBackground(new Color(100, 149, 237));
			mntmNewMenuItem_5.setForeground(Color.WHITE);
			mntmNewMenuItem_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		}
		return mntmNewMenuItem_5;
	}
	private JMenuItem getMntmNewMenuItem_6() {
		if (mntmNewMenuItem_6 == null) {
			mntmNewMenuItem_6 = new JMenuItem("\uC218\uC815&\uC0AD\uC81C");
			mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProductModify panel = new ProductModify(piList, peList);
					contentPane.add(panel);
				}
			});
			mntmNewMenuItem_6.setForeground(new Color(255, 255, 255));
			mntmNewMenuItem_6.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			mntmNewMenuItem_6.setBackground(new Color(100, 149, 237));
		}
		return mntmNewMenuItem_6;
	}
}
