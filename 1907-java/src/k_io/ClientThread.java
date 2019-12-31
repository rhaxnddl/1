package k_io;

import java.awt.Rectangle;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
// 데이터가 언제 들어올지 몰라서 항상 대기
public class ClientThread extends Thread{

	ClientFrame frame;
	Socket socket;
	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	public ClientThread(ClientFrame frame, Socket socket){
		this.frame = frame;
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			frame.login();
			
			while(true) {
				ChattData cd = (ChattData)ois.readObject();
				String html = "";
				switch(cd.getCommand()) {
				case ChattData.MESSAGE:
					html = "<div style='border:1px solid #0000ff;background-color:#ffff00;" 
								+ "padding:3px;width:150px;margin-left:60px'>"
								+ cd.toString() + "</div>";
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					
					break;
				case ChattData.LOGIN:
					for(int i=0; i<cd.getUsers().size(); i++) {
						String mId = cd.getUsers().get(i);
						frame.model.addElement(mId);
					}
					break;
				}
				frame.getTextPane().scrollRectToVisible(new Rectangle(0, frame.getTextPane().getHeight()+100, 1, 1));
			}
		}catch(Exception ex) {
			
		}
	}
}
