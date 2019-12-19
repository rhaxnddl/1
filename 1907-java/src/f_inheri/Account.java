package f_inheri;

public class Account {
	// Value object - 값만 저장되어있음.
	private String mName;
	private String sNo;
	private long amount;
	
	public Account(String n, String no, long amt) {
		this.mName = n;
		this.sNo = no;
		this.amount = amt;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	
}
