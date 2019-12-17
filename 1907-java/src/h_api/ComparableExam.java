package h_api;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class ComparableExam extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private TextArea textArea;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComparableExam frame = new ComparableExam();
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
	
	public void sortNum() { // 숫자 정렬1
		String[] temp = textField.getText().split(",");
		Integer[] intArray = new Integer[temp.length];
		for(int i=0; i<temp.length;i++) {
			intArray[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(intArray);
		
		StringBuilder sd = new StringBuilder(1024);
		
		for(int i=0; i<intArray.length; i++) {
			String str = String.format("[%2d]=%s\n", i, intArray[i]);
			sd.append(str);
		}
		
		// how 1(bubble sort 방법으로 내림차 정렬)
		boolean sort = true;
		int lastIndex = intArray.length-1;
		while(sort) {
			sort = false; // sort그만 할꺼라고 선언
			for(int i=0; i<lastIndex; i++) {
				if(intArray[i] < intArray[i+1]) {
					int t = intArray[i];
					intArray[i] = intArray[i+1];
					intArray[i+1] = t;
					sort = true; // 교환이 이루어졌으면 sort는 계속 되어야한다고 선언
				} // end if
			} // end for
			lastIndex--;// lastIndex의 값을 하나씩 줄인다.교환하는 숫자의 수가 줄어든다.
		} // end while
		sd.append("\n\n bubble sort 내림차 정렬 결과----------\n\n");
		for(int i=0; i<intArray.length; i++) {
			String str = String.format("[%2d]=%s\n", i, intArray[i]);
			sd.append(str);
		}
		
		// how 2 java API
		// 원본이 내림차순 정렬되었기 때문에 reverse하면 다시 오름차순 정렬된다.
		
		Collections.reverse(Arrays.asList(intArray));
		// Arrays는 reverse랑 직접적인 관계가 없기 때문에 asList를 사용
		
		sd.append("\n\nJava API를 사용한 reverse\n\n");
		for(int i=0; i<intArray.length; i++) {
			String str = String.format("[%2d]=%s\n", i, intArray[i]);
			sd.append(str);
		}			
		textArea.setText(sd.toString());
	}
	
	public void sortStr() { // 문자 정렬1
		String[] temp = textField.getText().split(",");
		Arrays.sort(temp);
		
		textArea.setText("");
		for(int i=0;i<temp.length;i++) {
			textArea.append(i + " = " + temp[i] + "\n");
		}
		
		textArea.append("\n\n java API를 사용한 내림차순\n\n");
		Arrays.sort(temp, Collections.reverseOrder());
		for(int i=0;i<temp.length;i++) {
			textArea.append(i + " = " + temp[i] + "\n");
		}
	}
	
	public void sortObj() { // 객체 정렬1 (Score Class 사용)
		String[] temp = textField.getText().split(",");
		Score[] sArray = new Score[temp.length];
		
		for(int i=0; i<temp.length; i++) {
			sArray[i] = new Score(temp[i]);
		}
		Collections.sort(Arrays.asList(sArray));
		Collections.reverse(Arrays.asList(sArray));
		
		textArea.setText("");
		for(int i=0; i<sArray.length; i++) {
			textArea.append(sArray[i].toString());
		}
		
		
	}
	
	public ComparableExam() {
		setTitle("ComparableExam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 80));
			panel.setLayout(null);
			panel.add(getTextField());
			panel.add(getBtnNewButton());
			panel.add(getBtnNewButton_1());
			panel.add(getBtnNewButton_2());
			panel.add(getBtnNewButton_3());
			panel.add(getBtnNewButton_4());
			panel.add(getBtnNewButton_5());
		}
		return panel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setText("21,1546,413,6465,561,79,1,8,998,122564");
			textField.setBounds(12, 10, 458, 17);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC22B\uC790 \uC815\uB82C");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	
					// 숫자 정렬
					String r = "";
					String[] str = (textField.getText().split(","));
					int[] n = new int[str.length];
					for(int i=0; i<str.length; i++) {
						n[i] = Integer.parseInt(str[i]);
					}
					Arrays.sort(n);
					
					for(int j=0; j<n.length; j++) {
						r +=n[j]+"\n";
					}
					textArea.setText(r);
				}
				});
			btnNewButton.setBounds(12, 36, 97, 19);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uBB38\uC790 \uC815\uB82C");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
					// 문자 정렬
					String r = "";
					String[] str = (textField.getText().split(","));
					Arrays.sort(str, Collections.reverseOrder());
					
					for(int i=0; i<str.length; i++) {
						r += str[i] + "\n";
					}
					textArea.setText(r);
				}
			});
			btnNewButton_1.setBounds(173, 36, 97, 19);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uAC1D\uCCB4 \uC815\uB82C");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
					// 객체 정렬 (Score2 Class 사용)
					String r = "";
					String[] str = (textField.getText().split(","));
					int[] n = new int [str.length];
					Score2[] score = new Score2 [str.length];
						for(int i=0; i<n.length;i++) {
							n[i] = Integer.parseInt(str[i]);
							Score2 sc1 = new Score2(n[i]);
							score[i] = sc1;
						}
						Arrays.sort(score);
						for(int i=0; i<score.length;i++) {
							r += score[i].kor + "\n";
						}
					textArea.setText(r);
					}
				});
			btnNewButton_2.setBounds(335, 35, 97, 21);
		}
		return btnNewButton_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private TextArea getTextArea() {
		if (textArea == null) {
			textArea = new TextArea();
		}
		return textArea;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("\uC22B\uC790 \uC815\uB82C1");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 숫자 정렬1
					sortNum();
				}
			});
			btnNewButton_3.setBounds(12, 59, 97, 21);
		}
		return btnNewButton_3;
	}
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("\uBB38\uC790 \uC815\uB82C1");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 문자 정렬1
					sortStr();
				}
			});
			btnNewButton_4.setBounds(173, 59, 97, 20);
		}
		return btnNewButton_4;
	}
	private JButton getBtnNewButton_5() {
		if (btnNewButton_5 == null) {
			btnNewButton_5 = new JButton("\uAC1D\uCCB4 \uC815\uB82C1");
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 객체 정렬1
					sortObj();
				}
			});
			btnNewButton_5.setBounds(335, 59, 97, 21);
		}
		return btnNewButton_5;
	}
}
