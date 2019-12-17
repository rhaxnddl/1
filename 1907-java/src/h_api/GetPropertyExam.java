package h_api;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;
import java.awt.event.ActionEvent;

public class GetPropertyExam extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetPropertyExam frame = new GetPropertyExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void view() {
		String msg = "";
		
		String osName = System.getProperty("os.name");
		
		msg +="운영체제 이름: " + osName + "\n";
		msg +="사용자 이름 : " + System.getProperty("user.name") + "\n";
		msg +="사용자 홈 : " + System.getProperty("user.home") + "\n";
		msg += "--------------------------------------\n";
		msg +="[ key ] value \n";
		msg += "--------------------------------------\n";
		Properties props = System.getProperties();
		
		Set keys = props.keySet();
		for(Object objkey : keys) {
			String key = (String)objkey;
			String value = System.getProperty(key);
			msg += "["+ key + "]" + value + "\n";
			msg += String.format("[%s] %s \n", key,value);
		}
		
		textArea.setText(msg);
	}
	
	public void viewClass() {
		String msg = "";
		Student st = new Student(0);
		Class cls = st.getClass();
		msg += "Class full name : " + cls.getName() + "\n";
		msg += "class name : " + cls.getSimpleName() + "\n";
		msg += "packge name : " + cls.getPackage().getName() + "\n";
		msg += "\n--------------------------------------\n";
		
		try {
			Class cls2 = Class.forName("h_api.Student");
			msg += "Class full name : " + cls2.getName() + "\n";
			msg += "Class name : " + cls2.getSimpleName() + "\n";
			msg += "packge name : " + cls2.getPackage().getName() + "\n";
			msg += "\n--------------------------------------\n";
			
		}catch(Exception ex){
			
		}
		textArea.setText(msg);
	}
	
	public void viewReflect() throws ClassNotFoundException {
		String msg = "";
		Class cls = Class.forName("h_api.Student");
		msg += "[클래스명]" + cls.getName() + "\n";
		
		msg += "[생성자 정보] \n";
		Constructor[] constructors = cls.getDeclaredConstructors();
		for(Constructor constructor : constructors) {
			msg += constructor.getName() + "(";			
			Class[] parameters = constructor.getParameterTypes();
			msg += printParameters(parameters) + ")";
			msg += "\n--------------------------------------\n";			
		}
		
		msg +="[필드정보]\n";
		Field[] fields = cls.getDeclaredFields();
		for(Field field : fields) {
			msg += field.getType().getSimpleName() + " " + field.getName() + "\n";
		}
		
		msg +="[메소드 정보]\n";
		Method[] methods = cls.getDeclaredMethods();
		for(Method method : methods) {
			msg += method.getName() + "(";
			Class[] parameters = method.getParameterTypes();
			msg += printParameters(parameters);
			msg += "\n--------------------------------------\n";			
		}
		textArea.setText(msg);
	}
	
	private String printParameters(Class[] parameters) {
		String str = "";
		for(int i=0;i<parameters.length; i++) {
			str += parameters[i].getName();
			if(i<parameters.length-1) str +=",";
		}
		return str;
	}

	/**
	 * Create the frame.
	 */
	public GetPropertyExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnNewButton());
			panel.add(getBtnNewButton_1());
			panel.add(getBtnNewButton_2());
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC18D\uC131\uBCF4\uAE30");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view();
					
				}
			});
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Class");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					viewClass();
				}
			});
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uB9AC\uD50C\uB809\uC158");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						viewReflect();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return btnNewButton_2;
	}
}
