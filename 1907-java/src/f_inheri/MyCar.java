// 2019.12.11 이현경
package f_inheri;

public class MyCar {
   KumhoTire[] frount = new KumhoTire[2];
   HankuTire[] back = new HankuTire[2];
   
	Tire[] tire = new Tire[4];
	
	public static void main(String[] args) {
		MyCar m = new MyCar();
		m.tire[0] = new KumhoTire();
		m.back[0] = new HankuTire();
		// m.frount[0] = new HankuTire(); / m.back[0] = new KumhoTire();
		// 위의 두개는 타입이 다르기 때문에 실행 불가
		// tire은 HankuTire, KumhoTire의 객체를 받아 오류가 뜨지 않음.
		
        m.tire[0].run();
        
        // 객체가 HankuTire로 만들어져 있는 경우 참
        Tire h1 = new HankuTire();
        if(h1 instanceof KumhoTire) {
        	System.out.println("금호 타이어로 만들어짐");
        } else {
        	System.out.println("금호 타이어로 만들어지지 않음");
        }
        
	}

}
