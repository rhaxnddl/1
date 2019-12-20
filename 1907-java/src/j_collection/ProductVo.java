// 자재번호
package j_collection;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductVo {
	private String serial; // yy-MM-dd-serial
	private String pCode;
	private String pName;
	private int ea; // 수량
	private Date nal; // 입고, 출고일자
	
	// 생성자 정의
	public ProductVo() { 	} 
	
	public ProductVo(String s, String pC, String pN, int ea, Date nal) {
		this.serial = s;
		this.pCode = pC;
		this.pName = pN;
		this.ea = ea;
		this.nal = nal;
	}
	@Override
	public int hashCode() {
		return this.serial.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj instanceof ProductVo) {
			ProductVo vo = (ProductVo)obj;
			result = serial.indexOf(vo.getSerial()) > -1||
						pCode.indexOf(vo.getpCode()) > -1||
						pName.indexOf(vo.getpName()) > -1;				
		}		
		return result;
	}
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###,###");
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd(E)");
		
		String tempEa = df.format(this.ea);
		String tempDate = sdf.format(this.nal);
		
		String temp = String.format("%s\t%s\t%s\t%s\t%s\n", this.serial, this.pCode, this.pName, tempEa, tempDate);
		return temp;
	}
		
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public Date getNal() {
		return nal;
	}
	public void setNal(Date nal) {
		this.nal = nal;
	}	
}
