//qqqq
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
						// 목록이 갱신되지 않는 경우
						//frame.getList().updateUI();
						frame.getList().paint(frame.getList().getGraphics()); // 클라이언트 리스트가 가지고 있는 그래픽을 가지고 가서 페인트를 다시 해라 , 새롭게 다시 그려라 
						
					}
					break;
				case ChattData.LOGOUT:
					frame.model.removeElement(cd.getmId());
					break;
					
				case ChattData.GETOUT:
					// 서버의 중지 or 특정유저의 강퇴
					if(cd.getUsers() == null) { // 서버의 중지
						frame.model.clear();
						throw new Exception();
					} else { // 강퇴
						for(String mId : cd.getUsers()) {
							if(mId.equals(frame.getTmId().getText())) {
								frame.model.clear();
								throw new Exception();
							} else {
								frame.model.removeElement(mId);
							}
						}
					}
				}
				frame.getTextPane().scrollRectToVisible(new Rectangle(0, frame.getTextPane().getHeight()+100, 1, 1));
			}
		}catch(Exception ex) {
			try {
				ois.close();
				oos.close();
				socket.close();
				
				ois = null;
				oos = null;
				socket = null;
			} catch(Exception ex2) {
				
			}
		}
	}
}
