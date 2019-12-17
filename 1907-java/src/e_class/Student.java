package e_class;

public class Student {
	String irum = null;
	String address ;
	String phone ;
	
	Student (){   
		this.irum = "홍길동";
		this.address = "종로구";
		this.phone = "010-1111-1111";
	}
	Student (String irum){ 
		this.irum = irum;
	}			
//	Student (String irum, String address) {
//		this.irum = irum;
//		this.address = address;
//		
//	}
	Student (String irum, String address, String phone) { 
		this.irum = irum;
		this.address = address;
		this.phone = phone;	
	}
		
	void prn() {
		 System.out.println("성명 : " + this.irum);
		 System.out.println("주소 : " + this.address);
		 System.out.println("연락처 : " + this.phone);
		 System.out.println("---------------------------------------------");
	}
	
  public static void main(String[] args) {
	  Student s1 = new Student ( ); 
	  s1.prn();
	  
//	  System.out.println("성명 : " + s1.irum);
//	  System.out.println("주소 : " + s1.address);
//	  System.out.println("연락처 : " + s1.phone);
//	  System.out.println("---------------------------------------------");
	  
	  Student s2 = new Student("일지매");
	  s2.prn();
	  
//	  System.out.println("성명 : " + s2.irum);
//	  System.out.println("주소 : " + s2.address);
//	  System.out.println("연락처 : " + s2.phone);
//	  System.out.println("---------------------------------------------");
	  
	  Student s3 = new Student("춘향이", "남원", "010-8282-1234");
	  s3.prn();
	  
//	  System.out.println("성명 : " + s3.irum);
//	  System.out.println("주소 : " + s3.address);
//	  System.out.println("연락처 : " + s3.phone);
	  
	  
  }
}
