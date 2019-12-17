package homeWork;

public class BoardVo {

	int no;
	String subject;
	String content;
	String mId;
	String mDate;
	int cnt;
	
	BoardVo(int no, String subject, String content, String mId, String mDate, int cnt) {
		this.no = no;
		this.subject = subject;
		this.content = content;
		this.mId = mId;
		this.mDate = mDate;
		this.cnt = cnt;
		
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubjest(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {		
		return "\t"+ no + "\t" + subject + "\t" + content + "\t" + mId + "\t" + mDate + "\t" + cnt;
	}

}
