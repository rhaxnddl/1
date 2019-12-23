//2019.12.19
package j_collection;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class MemberMain extends JFrame {
	
	List<MemberVo> list = new ArrayList<MemberVo>(); // size는 10개, 갯수가 11개가 될때 20개로 늘어남 

	// Product에 관련된 생성자
	Set<ProductVo> piList = new HashSet<ProductVo>(); // 입고 리스트
	Set<ProductVo> peList = new HashSet<ProductVo>(); // 출고 리스트
	
	Map<String,ScoreVo> score = new HashMap<String,ScoreVo>(); // 성적
	
	static int iSerial = 1; // 입고의 순번
	static int eSerial = 1; // 출고의 순번
	
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
	private JMenu menu;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;

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
		setFont(new Font("맑은 고딕", Font.BOLD, 15));
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
		
		// 입고 (iSerial), 출고 (eSerial) sample data
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0; i<100; i++) {
			String tempSerial = sdf.format(new Date()) + "-" + MemberMain.iSerial;
			ProductVo vo = new ProductVo(tempSerial, "pCode" + i, "pName" + i, 3000, new Date());
			piList.add(vo);
			peList.add(vo);
			MemberMain.iSerial++;
			MemberMain.eSerial++;
		}
//		for(int i=0; i<100; i++) {
//			ScoreVo svo= new ScoreVo("sno"+i, "mName"+i, "exam"+i, 1, 80, 50, 90, );
//			score.add(svo);
//			
//		}
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(new Color(154, 205, 50));
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
			menuBar.add(getMenu());
			menuBar.add(getMnNewMenu_2());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uD68C\uC6D0 \uAD00\uB9AC");
			mnNewMenu.setBackground(new Color(154, 205, 50));
			mnNewMenu.setForeground(new Color(255, 255, 255));
			mnNewMenu.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
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
			mntmNewMenuItem.setBackground(new Color(154, 205, 50));
			mntmNewMenuItem.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { // 입력					
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
			mntmNewMenuItem_1.setBackground(new Color(154, 205, 50));
			mntmNewMenuItem_1.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { // 조회					
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
			mntmNewMenuItem_2.setBackground(new Color(154, 205, 50));
			mntmNewMenuItem_2.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { // 수정&삭제					
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
			mnNewMenu_1.setBackground(new Color(154, 205, 50));
			mnNewMenu_1.setForeground(Color.WHITE);
			mnNewMenu_1.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
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
					panel.toFront();
				}
			});
			mntmNewMenuItem_3.setBackground(new Color(154, 205, 50));
			mntmNewMenuItem_3.setForeground(Color.WHITE);
			mntmNewMenuItem_3.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
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
					panel.toFront();
				}
			});
			mntmNewMenuItem_4.setBackground(new Color(154, 205, 50));
			mntmNewMenuItem_4.setForeground(Color.WHITE);
			mntmNewMenuItem_4.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
		}
		return mntmNewMenuItem_4;
	}
	private JMenuItem getMntmNewMenuItem_5() {
		if (mntmNewMenuItem_5 == null) {
			mntmNewMenuItem_5 = new JMenuItem("\uC870\uD68C");
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProductSearch panel = new ProductSearch(piList, peList);
					contentPane.add(panel);
					panel.toFront();
				}
			});
			mntmNewMenuItem_5.setBackground(new Color(154, 205, 50));
			mntmNewMenuItem_5.setForeground(Color.WHITE);
			mntmNewMenuItem_5.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
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
					panel.toFront();
				}
			});
			mntmNewMenuItem_6.setForeground(new Color(255, 255, 255));
			mntmNewMenuItem_6.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			mntmNewMenuItem_6.setBackground(new Color(154, 205, 50));
		}
		return mntmNewMenuItem_6;
	}
	private JMenu getMenu() {
		if (menu == null) {
			menu = new JMenu("");
		}
		return menu;
	}
	private JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("\uC131\uC801 \uAD00\uB9AC");
			mnNewMenu_2.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			mnNewMenu_2.setForeground(new Color(255, 255, 255));
			mnNewMenu_2.setBackground(new Color(154, 205, 50));
			mnNewMenu_2.add(getMntmNewMenuItem_7());
			mnNewMenu_2.add(getMntmNewMenuItem_8());
		}
		return mnNewMenu_2;
	}
	private JMenuItem getMntmNewMenuItem_7() {
		if (mntmNewMenuItem_7 == null) {
			mntmNewMenuItem_7 = new JMenuItem("\uC785\uB825");
			mntmNewMenuItem_7.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			mntmNewMenuItem_7.setForeground(new Color(255, 255, 255));
			mntmNewMenuItem_7.setBackground(new Color(154, 205, 50));
			mntmNewMenuItem_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreInput s = new ScoreInput();
					contentPane.add(s);
				}
			});
		}
		return mntmNewMenuItem_7;
	}
	private JMenuItem getMntmNewMenuItem_8() {
		if (mntmNewMenuItem_8 == null) {
			mntmNewMenuItem_8 = new JMenuItem("\uC870\uD68C");
			mntmNewMenuItem_8.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			mntmNewMenuItem_8.setForeground(new Color(255, 255, 255));
			mntmNewMenuItem_8.setBackground(new Color(154, 205, 50));
			mntmNewMenuItem_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreSearch s = new ScoreSearch();
					contentPane.add(s);
				}
			});
		}
		return mntmNewMenuItem_8;
	}
}
