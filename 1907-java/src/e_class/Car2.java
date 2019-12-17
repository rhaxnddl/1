package e_class;

public class Car2 {
   int gas;
   
   public void setGas(int gas) { // setGas 는 셋터. 셋터는 set으로 시작 , 반드시 매개변수가 하나가 있어야 한다.
	   this.gas = gas;
   }
   public boolean isLeftGas() {
	   if(gas==0) {
		   System.out.println("gas가 없습니다.");
		   return false;
	   } else {
	       System.out.println("gas가 있습니다.");
	       return true;
	  }
   }
   public void run() {
	   while(true) {
		   if(gas>0) {
			   System.out.println("달립니다. (gas 잔량 : " + gas + ")");
			   gas -= 1;
		   } else {
			   System.out.println("멈춥니다. (gas 잔량 :" + gas + ")");
			   return;
		   }
	   }
   }
}
