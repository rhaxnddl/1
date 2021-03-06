package k_io;

import java.awt.Rectangle;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread{
	String mId; 
	ServerFrame frame;
	Socket socket;
	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	public ServerThread(ServerFrame frame, Socket socket) {
		this.frame = frame;
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			while(true) {
				ChattData cd = (ChattData)ois.readObject();
				String html = "";
				switch(cd.getCommand()) {
				// 접속, 연결
				case ChattData.LOGIN:
					this.mId = cd.getmId(); // 자신과 연결된 클라이언트의 mId를 저장
					html = "<font color='#00ff00'>" + cd.getmId() + "님이 접속하였습니다.</font>";
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					
					// 먼저 자신과 연결된 oos에게 기존 접속자 목록을 전송
					ChattData cd2 = new ChattData();
					List<String> users = new ArrayList<String>();
					for(int i=0; i<frame.model.size(); i++) {
						users.add(frame.model.get(i));
					}
					cd2.setCommand(ChattData.LOGIN);
					cd2.setUsers(users);
					oos.writeObject(cd2);
					oos.flush();
					
					// 자신의 아이디를 model에 추가
					frame.model.addElement(cd.getmId());
					
					// 모든 접속자에게 현재 자신의 아이디를 전송
					cd2 = new ChattData();
					cd2.setCommand(ChattData.LOGIN);
					users = new ArrayList<String>();
		
					users.add(cd.getmId());
					cd2.setUsers(users);
					sendAll(cd2);
					
					break;
				// 메세지 전송
				case ChattData.MESSAGE:
					html = "<div style='border:1px solid #6666ff; padding:3px;"
								+ "background-color:#ffff00;width:150px'>" + cd.toString() + "</div>";
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					
					sendAll(cd);
					
					break;
					
				case ChattData.LOGOUT:
					throw new Exception();
				
				}
				frame.getTextPane().scrollRectToVisible(new Rectangle(0, frame.getTextPane().getHeight()+100, 1, 1));
			}
			
		}catch(Exception ex) {
			int index = frame.clients.indexOf(ServerThread.this);
			frame.model.remove(index);
			frame.clients.remove(index);
			// 다른 모든 유저에게 본인의 logout된 사실을 통보
			ChattData cd = new ChattData();
			cd.setCommand(ChattData.LOGOUT);
			cd.setmId(this.mId);
			try {
			sendAll(cd);
			} catch(Exception e) {
				
			}
		}
	}
	
	public void sendAll(ChattData cd) throws Exception{
		for(ServerThread st : frame.clients) {
			st.oos.writeObject(cd);
			st.oos.flush();
		}
	}
}