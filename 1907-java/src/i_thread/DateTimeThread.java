package i_thread;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DateTimeThread extends Thread{
	JLabel watch;

	public DateTimeThread(JLabel watch) {
		this.watch = watch;
	}
	
	public void run() {	
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd(E) hh:mm:ss");
		while(true) {
			watch.setText(sdf.format(new Date()));
		}
	} 
}

