package c_control;

public class ForExam8 {
   ForExam8() {
	   int s1 = 0;
	   int s10 = 0;
	   int s20 = 0;
	   int s30 = 0;
	   int s40 = 0;
	   int s50 = 0;
	   int s60 = 0;
	   int s70 = 0;
	   int s80 = 0;
	   int s90 = 0;
	   
	   for (int b = 1; b<=1000; b++) {
		   int s = (int)(Math.random()*100) + 1;
	      
		            if (s>=0 && s<10) { s1++;}
		      else if (s>=10 && s<20) { s10++;}
		      else if (s>=20 && s<30) { s20++;}
		      else if (s>=30 && s<40) { s30++;}
	          else if (s>=40 && s<50) { s40++;}  
	          else if (s>=50 && s<60) { s50++;}        	    
	          else if (s>=60 && s<70) { s60++;}
	          else if (s>=70 && s<80) { s70++;}          
	          else if (s>=80 && s<90) { s80++;}      
	          else                    { s90++;}
	   }  
		   System.out.println("단자리 : "+ s1 + "개");
		   System.out.println("10자리 : "+ s10 + "개");
		   System.out.println("20자리 : "+ s20 + "개");
		   System.out.println("30자리 : "+ s30 + "개");
		   System.out.println("40자리 : "+ s40 + "개");
		   System.out.println("50자리 : "+ s50 + "개");
		   System.out.println("60자리 : "+ s60 + "개");
		   System.out.println("70자리 : "+ s70 + "개");
		   System.out.println("80자리 : "+ s80 + "개");
		   System.out.println("90자리 : "+ s90 + "개");
   }
}