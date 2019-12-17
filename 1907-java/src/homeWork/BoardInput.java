package homeWork;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BoardInput extends JInternalFrame {
   private JLabel lblNewLabel;
   private JLabel lblNewLabel_1;
   private JLabel lblNewLabel_2;
   private JLabel lblNewLabel_3;
   private JLabel lblNewLabel_4;
   private JLabel lblNewLabel_5;
   private JTextField no;
   private JTextField subject;
   private JTextField mId;
   private JTextField mDate;
   private JTextField cnt;
   private JButton btnNewButton;
   private JScrollPane scrollPane;
   private JTextArea content;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               BoardInput frame = new BoardInput();
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
   public BoardInput() {
      super("게시물 입력", false, true, true, true);  // 최소, 최대창, 창 닫기 버튼을 생성
      setVisible(true);
            
      setBounds(100, 100, 321, 300);
      getContentPane().setLayout(null);
      getContentPane().add(getLblNewLabel());
      getContentPane().add(getLblNewLabel_1());
      getContentPane().add(getLblNewLabel_2());
      getContentPane().add(getLblNewLabel_3());
      getContentPane().add(getLblNewLabel_4());
      getContentPane().add(getLblNewLabel_5());
      getContentPane().add(getNo());
      getContentPane().add(getSubject());
      getContentPane().add(getMId());
      getContentPane().add(getMDate());
      getContentPane().add(getCnt());
      getContentPane().add(getBtnNewButton());
      getContentPane().add(getScrollPane());
      
      // 초기값
      String str = Integer.toString(BoardMain.count + 1);
      no.setText(str);
      Date now = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      mDate.setText(sdf.format(now));
   }

   private JLabel getLblNewLabel() {
      if (lblNewLabel == null) {
         lblNewLabel = new JLabel("\uAC8C\uC2DC\uBB3C \uBC88\uD638");
         lblNewLabel.setBounds(12, 10, 84, 15);
      }
      return lblNewLabel;
   }
   private JLabel getLblNewLabel_1() {
      if (lblNewLabel_1 == null) {
         lblNewLabel_1 = new JLabel("\uC81C\uBAA9");
         lblNewLabel_1.setBounds(12, 35, 57, 15);
      }
      return lblNewLabel_1;
   }
   private JLabel getLblNewLabel_2() {
      if (lblNewLabel_2 == null) {
         lblNewLabel_2 = new JLabel("\uB0B4\uC6A9");
         lblNewLabel_2.setBounds(12, 60, 57, 15);
      }
      return lblNewLabel_2;
   }
   private JLabel getLblNewLabel_3() {
      if (lblNewLabel_3 == null) {
         lblNewLabel_3 = new JLabel("\uC791\uC131\uC790 ID");
         lblNewLabel_3.setBounds(12, 133, 57, 15);
      }
      return lblNewLabel_3;
   }
   private JLabel getLblNewLabel_4() {
      if (lblNewLabel_4 == null) {
         lblNewLabel_4 = new JLabel("\uC791\uC131\uC77C");
         lblNewLabel_4.setBounds(12, 158, 57, 15);
      }
      return lblNewLabel_4;
   }
   private JLabel getLblNewLabel_5() {
      if (lblNewLabel_5 == null) {
         lblNewLabel_5 = new JLabel("\uC870\uD68C\uC218");
         lblNewLabel_5.setBounds(12, 183, 57, 15);
      }
      return lblNewLabel_5;
   }
   private JTextField getNo() {
      if (no == null) {
         no = new JTextField();
         no.setEditable(false);
         no.setBounds(91, 7, 116, 21);
         no.setColumns(10);
      }
      return no;
   }
   private JTextField getSubject() {
      if (subject == null) {
         subject = new JTextField();
         subject.setBounds(91, 32, 200, 21);
         subject.setColumns(10);
      }
      return subject;
   }
   private JTextField getMId() {
      if (mId == null) {
         mId = new JTextField();
         mId.setBounds(91, 130, 116, 21);
         mId.setColumns(10);
      }
      return mId;
   }
   private JTextField getMDate() {
      if (mDate == null) {
         mDate = new JTextField();
         mDate.setBounds(91, 155, 116, 21);
         mDate.setColumns(10);
      }
      return mDate;
   }
   private JTextField getCnt() {
      if (cnt == null) {
         cnt = new JTextField();
         cnt.setBounds(91, 180, 116, 21);
         cnt.setColumns(10);
      }
      return cnt;
   }
   private JButton getBtnNewButton() {
      if (btnNewButton == null) {
         btnNewButton = new JButton("\uC785\uB825");
         btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {               
               BoardMain.data[BoardMain.count] = new BoardVo((BoardMain.count + 1), subject.getText(),
                     content.getText(), mId.getText(), mDate.getText(), Integer.parseInt(cnt.getText()));
               BoardMain.count++; // 게시물 개수 증가
               
               // textField 초기화
               subject.setText("");
               content.setText("");
               mId.setText("");
               cnt.setText("");
               
               // 게시물 번호, 작성일 다시 설정
               no.setText(Integer.toString(BoardMain.count + 1));
               //Date now = new Date();
               //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
               //mDate.setText(sdf.format(now));
            }
         });
         btnNewButton.setBounds(12, 211, 279, 50);
      }
      return btnNewButton;
   }
   private JScrollPane getScrollPane() {
      if (scrollPane == null) {
         scrollPane = new JScrollPane();
         scrollPane.setBounds(91, 60, 200, 60);
         scrollPane.setViewportView(getContent());
      }
      return scrollPane;
   }
   private JTextArea getContent() {
      if (content == null) {
         content = new JTextArea();
      }
      return content;
   }
}