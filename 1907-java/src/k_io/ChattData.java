package k_io;

import java.io.Serializable;
import java.util.List;

public class ChattData implements Serializable{
	
	public static long serialVersionUID = 2L;
	
	public static final int LOGIN = 1; // 로그인
	public static final int LOGOUT = 2; // 로그아웃
	public static final int USERS = 3; // 유저 목록
	public static final int MESSAGE = 4; // 일반 메세지
	public static final int WHISPER = 5; // 귓속말
	public static final int GETOUT = 6; // 강퇴
	
	String message;
	List<String> users;
	int command;
	String mId;
	
	public ChattData() { // 매개변수가 없는 생성자
		
	}
	
	public ChattData(String mId, int command, String msg) {
		this.mId = mId;
		this.command = command;
		this.message = msg;
	}
	
	public String toString() {
		return mId + " > " + message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getUsers() {
		return users;
	}
	public void setUsers(List<String> users) {
		this.users = users;
	}
	public int getCommand() {
		return command;
	}
	public void setCommand(int command) {
		this.command = command;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}	
}
