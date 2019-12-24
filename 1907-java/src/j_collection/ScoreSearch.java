package j_collection;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ScoreSearch extends JInternalFrame {
	
	Map<String, List<ScoreVo>> map;
	DefaultListModel<String> modelSno = new DefaultListModel<String>();
	DefaultListModel<String> modelExam = new DefaultListModel<String>();
	List<ScoreVo> list;
	
	public JButton btnFind;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel status;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JList listSno;
	private JScrollPane scrollPane_1;
	private JList listExam;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private InputPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreSearch frame = new ScoreSearch();
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
	public ScoreSearch() {
		super("성적 수정/삭제", false, true, true, true);
		getContentPane().setBackground(new Color(250, 240, 230));
		setVisible(true);
		setBounds(100, 100, 496, 421);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnFind());
		getContentPane().add(getTextField());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getStatus());
		getContentPane().add(getSeparator());
		getContentPane().add(getScrollPane());
		getContentPane().add(getScrollPane_1());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getPanel());
	}
	
	public ScoreSearch(Map<String, List<ScoreVo>>map) {
		this();
		this.map = map;
		
		// 학번을 추출
		Set<String> set = map.keySet();
		
		// JList에 추가
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			modelSno.addElement(iter.next());
		}
		listSno.setModel(modelSno);
	}
	private JButton getBtnFind() {
		if (btnFind == null) {
			btnFind = new JButton("\uAC80\uC0C9");
			btnFind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String findStr = textField.getText();
					ScoreDao dao = new ScoreDao(map);
					Map<String, List<ScoreVo>> newMap = dao.list(findStr);
					
					Set<String> set = newMap.keySet();
					modelSno = new DefaultListModel<String>(); // modelSno.clear();
					
					Iterator<String> iter = set.iterator();
					while(iter.hasNext()) {
						modelSno.addElement(iter.next());
					}
					listSno.setModel(modelSno);
					modelExam.clear();
					
					// 상세 정보 삭제
					panel.tSno.setText("");
					panel.tmName.setText("");
					panel.tKor.setText("");
					panel.tEng.setText("");
					panel.tMat.setText("");
					panel.tTot.setText("");
					panel.tAvg.setText("");
					
				}
			});
			btnFind.setForeground(new Color(255, 255, 255));
			btnFind.setBackground(new Color(154, 205, 50));
			btnFind.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			btnFind.setBounds(400, 28, 66, 23);
		}
		return btnFind;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			textField.setBounds(239, 29, 149, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801 \uC218\uC815/\uC0AD\uC81C");
			lblNewLabel.setBackground(new Color(154, 205, 50));
			lblNewLabel.setFont(new Font("타이포_스톰 B", Font.BOLD, 30));
			lblNewLabel.setBounds(12, 10, 215, 41);
		}
		return lblNewLabel;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uAC80\uC0C9\uD558\uC138\uC694");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("타이포_스톰 B", Font.BOLD, 20));
			status.setForeground(new Color(255, 255, 255));
			status.setOpaque(true);
			status.setBackground(new Color(154, 205, 50));
			status.setBounds(12, 344, 456, 37);
		}
		return status;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(new Color(154, 205, 50));
			separator.setBackground(new Color(154, 205, 50));
			separator.setBounds(12, 61, 454, 2);
		}
		return separator;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 67, 97, 233);
			scrollPane.setViewportView(getListSno());
		}
		return scrollPane;
	}
	private JList getListSno() {
		if (listSno == null) {
			listSno = new JList();
			listSno.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent ev) {					
					String sno = (String)listSno.getSelectedValue();
					if(sno == null) return;
					
					list = map.get(sno);
					modelExam = new DefaultListModel<>();
					for(int i=0; i<list.size(); i++) {
						ScoreVo vo = list.get(i);
						String temp = String.format("%s:%d(%s)", vo.getmName(), vo.getGrade(), vo.getExam());
						modelExam.addElement(temp);
					}
					listExam.setModel(modelExam);					
				}
			});
			listSno.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
		}
		return listSno;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(113, 67, 126, 233);
			scrollPane_1.setViewportView(getListExam());
		}
		return scrollPane_1;
	}
	private JList getListExam() {
		if (listExam == null) {
			listExam = new JList();
			listExam.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent ev) {
					int index = listExam.getSelectedIndex();
					int grade = -1;
					if(index <0 ) {
						return;
					}					
					ScoreVo vo = list.get(index);
					panel.tSno.setText(vo.getSno());	
					panel.tmName.setText(vo.getmName());
					panel.tKor.setText(vo.getKor()+"");
					panel.tEng.setText(vo.getEng()+"");
					panel.tMat.setText(vo.getMat()+"");
					panel.tTot.setText(vo.getTot()+"");
					panel.tAvg.setText(String.format("%4.1f", vo.getAvg()));
					
					if(vo.getExam().equals("중간")) {
						panel.rExam1.setSelected(true);
					} else {
						panel.rExam2.setSelected(true);
					}
					// 학년 선택
					grade = vo.getGrade()-1;
					panel.cGrade.setSelectedIndex(grade);
				}
			});
			listExam.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
		}
		return listExam;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String key = panel.tSno.getText();
					int index = listExam.getSelectedIndex();
					
					String mName = panel.tmName.getText();
					int kor = Integer.parseInt(panel.tKor.getText());
					int eng = Integer.parseInt(panel.tEng.getText());
					int mat = Integer.parseInt(panel.tMat.getText());
					String exam = "";
					int grade = 0;
					if(panel.rExam1.isSelected()) {
						exam = "중간";
					}else {
						exam = "기말";
					} 
					grade = panel.cGrade.getSelectedIndex()+1;
					
					ScoreVo vo = new ScoreVo(key, mName, exam, grade, kor, eng, mat);
					
					ScoreDao dao = new ScoreDao(map);
					boolean b = dao.update(key, index, vo);
					if(b) {
						status.setText("자료가 정상적으로 수정되었습니다.");
					} else {
						status.setText("수정 중 오류가 발생했습니다.");
					}
					
				}
			});
			btnNewButton_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1.setBackground(new Color(154, 205, 50));
			btnNewButton_1.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			btnNewButton_1.setBounds(284, 311, 66, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC0AD\uC81C");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String key = panel.tSno.getText();
					int index = listExam.getSelectedIndex();
					
					ScoreDao dao = new ScoreDao(map);
					boolean b = dao.delete(key, index);
					if(b) {
						status.setText("자료가 삭제되었습니다.");
						
						// 상세 정보 삭제
						panel.tSno.setText("");
						panel.tmName.setText("");
						panel.tKor.setText("");
						panel.tEng.setText("");
						panel.tMat.setText("");
						panel.tTot.setText("");
						panel.tAvg.setText("");
						if(modelExam.size()>0) {
						modelExam.remove(index);
						}
					}else {
						status.setText("삭제중 오류가 발생하였습니다.");
					}
				}
			});
			btnNewButton_2.setForeground(new Color(255, 255, 255));
			btnNewButton_2.setBackground(new Color(154, 205, 50));
			btnNewButton_2.setFont(new Font("1훈새마을운동 R", Font.BOLD, 15));
			btnNewButton_2.setBounds(377, 311, 66, 23);
		}
		return btnNewButton_2;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new InputPanel();
			panel.tAvg.setBounds(102, 207, 65, 21);
			panel.setBounds(243, 61, 223, 240);
		}
		return panel;
	}
}
