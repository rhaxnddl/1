/*
 * 2019.12.03 이현경
 * while문 
 * */
package c_control;

public class WhileExam1 {
    WhileExam1 () {
    	//type 1 (출력 후 i를 증감시킬 때)
    	int i = 1;
    	while (i<=10) {
    		System.out.println(i);    		
    		i++;    		
    	}    	
    	System.out.println("----------------------");
    	//type 2 (l을 증감시킨 후 출력할 때)
    	int l = 0;
    	while (l<10) {
    		l++;
    		System.out.println(l);
    	}
    }
}

