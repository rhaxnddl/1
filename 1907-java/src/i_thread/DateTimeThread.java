package i_thread;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;

public class DateTimeThread extends Thread{
	JTextField txt = new JTextField();
	
	
	
	@Override
	public void run() {	
		while(true) {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd(E) hh:mm:ss");
			String txt = sdf.format(now);
			try {
			Thread.sleep(1000);
			} catch(InterruptedException ex) {}
			TimeWatch tw = new TimeWatch(txt);
		}
	} 
}

