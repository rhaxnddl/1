// 2019.12.11
package homeWork;

public class ProductExam {

	public static void main(String[] args) {
		
		Product pro = new Product();
		Radio radio = new Radio();
		Video video = new Video();
		TV tv = new TV();
		
		radio.getProductName();
		video.getProductName();
		tv.getProductName();
		
		// Video 와 Radio 형 변환		
//			Video vi1 = new Video();
//	        Radio r1 = (Radio) vi1;			// 오류 발생
		
		// Product형 변환  
		try {
	   Product r = (Product)radio;
	   Product v = (Product)video;
	   Product t = (Product)tv;
		}catch(ClassCastException ex) {
			System.out.println("형변환 오류");
		}finally {
			System.out.println("형변환 성공");
		}	   
	}		
}