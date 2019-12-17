package e_class;

public class Exam1 {
	
    int sum (int x, int y) {
    	int sum = 0;
    	 sum = x+y;
    //	 System.out.println(sum);
    	 return sum;
    	 }

    int sum2(int x, int y) {
    	int sum2 = 0;
    	
    	for (int i = x ; i<=y ; i++) {
    	sum2 +=i;
        	}
    	return sum2;
    	}
    
    double sum3(double x, double y) {
    	double sum3 = 0;
    	sum3 = x*y;
    	return sum3;
        }
    
    String gugudan(int dan) {
    	String r = "";
    	for(int i = 1; i<=9; i++) {
    		int result = dan*i;
    		r +=(dan+"*" + i + "=" + result);
    		r += "\n";
    	}
   	return r;
    }
    }
    
   
