package c_control;

public class SwitchExample3 {
	
   public SwitchExample3 (){
    	
	   char grade = 'B';
    	String a = "";
    	
    	switch (grade) {
    	case 'A':
    	case 'a':
    	  a = "우수회원 입니다.";
    	  break;
    	  
    	case 'B':
    	case 'b':
    		a = "일반회원 입니다.";
    		break;
    		
        default:
    		a = "손님입니다.";
    	}
    	System.out.println(a);
    }
  
}
