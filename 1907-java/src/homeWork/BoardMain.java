package homeWork;

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
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class BoardMain extends JFrame {

   private JDesktopPane contentPane;

   public static BoardVo[] data;
   public static int count;
   private JMenuBar menuBar;
   private JMenu mnNewMenu;
   private JMenuItem mntmNewMenuItem;
   private JMenuItem mntmNewMenuItem_1;
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               BoardMain frame = new BoardMain();
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
   public BoardMain() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 795, 587);
      setJMenuBar(getMenuBar_1());
      contentPane = new JDesktopPane();
      contentPane.setBackground(SystemColor.inactiveCaption);
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      data = new BoardVo[100];
      count = 0;
   }

   private JMenuBar getMenuBar_1() {
      if (menuBar == null) {
         menuBar = new JMenuBar();
         menuBar.add(getMnNewMenu());
      }
      return menuBar;
   }
   private JMenu getMnNewMenu() {
      if (mnNewMenu == null) {
         mnNewMenu = new JMenu("Menu");
         mnNewMenu.add(getMntmNewMenuItem());
         mnNewMenu.add(getMntmNewMenuItem_1());
      }
      return mnNewMenu;
   }
   private JMenuItem getMntmNewMenuItem() {
      if (mntmNewMenuItem == null) {
         mntmNewMenuItem = new JMenuItem("\uC785\uB825");
         mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               BoardInput bi = new BoardInput();
               contentPane.add(bi);
            }
         });
      }
      return mntmNewMenuItem;
   }
   private JMenuItem getMntmNewMenuItem_1() {
      if (mntmNewMenuItem_1 == null) {
         mntmNewMenuItem_1 = new JMenuItem("\uC870\uD68C");
         mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               BoardSearch bs = new BoardSearch();
               contentPane.add(bs);
            }
         });
      }
      return mntmNewMenuItem_1;
   } 
  }
