package c_control;

public class SwitchExample5 {
   public SwitchExample5() {
	   int score = 50;
	    char grade = ' ';
	    
	   switch (score/10) {
	    case 10:   
	    case 9:
	    	grade = 'A';
	    	break;
	    	
	    case 8:
	    	grade = 'B';
	    	break;
	    	
	    case 7:
	    	grade = 'C';
	    	break;
	    	
	    case 6:
	    	grade = 'D';
	    	break;
	    	
	    default:
	    	grade = 'F';
	   }
	   System.out.println("성적 : " + score);
	   System.out.println("학점 : " + grade);
	   System.out.println("-------------------");
	   
	   //switch -> if
	   if (score >=90) grade = 'A';
	   else if (score >=80) grade = 'B';
	   else if (score >=70) grade = 'C';
	   else if (score >=60) grade = 'D';
	   else                 grade = 'F';
	   
	   System.out.println("\n[switch문을 if문으로 변형]\n");
	   System.out.println("성적 : " + score);
	   System.out.println("학점 : " + grade);
   }
}
