package d_array;

public class Exam8 {
   Exam8() {
	   int[][] n = new int[5][5];
	   int sum = 0;
	   int max = 0;
	   int min = 200;
	   
	   System.out.println("[전체 배열]");
	   
	    for(int i=0; i<n.length; i++) {
	    	for( int j=0; j<n.length; j++) {
	    	n[i][j]  = (int)(Math.random()*101 )+ 100;
	   		    	
	    	System.out.print( n[i][j] + " ");
	    	
	    	sum += n[i][j];
	    	
	    	if(n[i][j]>max) { max = n[i][j]; }
	    	if(n[i][j]<min) { min = n[i][j]; }
		  }
	    	System.out.println();	    	
	    }
	        System.out.println();
	    	System.out.println("전체 값들의 합 : " + sum);
	    	System.out.println("전체 값들 중 최대 값 : " + max);
	    	System.out.println("전체 값들 중 최소 값 : " + min);
	    	System.out.println();
	   
	    for(int i=0; i<n.length; i++) { 
	    	max = 0;	    		    	
	    	for(int j=0; j<n.length; j++) {
	    		if(n[i][j]> max) { max = n[i][j]; }
	    	}
	    	System.out.println((i+1)+"행의 최대 값 : "+max);
	    }	    
   } public static void main(String[] args) {
	   new Exam8();
  }
}
