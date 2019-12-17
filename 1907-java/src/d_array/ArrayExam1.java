package d_array;

public class ArrayExam1 {
   ArrayExam1() {
	   //배열을 선언하면서 초기값을 대입
	   int[] scores = {11,12,13,14,15,};
	   System.out.println(scores[4]); // 처음 시작이 0이기 때문에 숫자 하나씩 적게 선언
	   
	   // 문자열형 배열을 선언하고 임의의 성명을 3개 저장
	   String[] names = {"홍","김","이"};
	   System.out.println(names[0]);
	   System.out.println(names[1]);
	   System.out.println(names[2]);
	   System.out.println("-----------------------------------");
	   
	   names[0] = "hong";
	   names[1] = "kim";
	   names[2] = "lee";
	   System.out.println(names[0]);
	   System.out.println(names[1]);
	   System.out.println(names[2]);
	   System.out.println("-----------------------------------");
	   
	   // 배열을 선언한 후에 초기값을 설정할때 	   
	  // double[] height = new double[ ]{150.5, 160, 165.5 };
		double[] height = null;	 
	   height = new double[ ]{150.5, 160, 165.5 };
        System.out.println(height[0]);
        System.out.println(height[1]);
        System.out.println(height[2]);
        System.out.println("-----------------------------------");
        
        //10명의 몸무게를 저장할 수 있는 실수형 배열을 선언
        double[] w = new double[10];
        
        //랜덤함수를 사용하여 몸무게를 발생시켜 배열w에 저장
        for(int i = 0; i<10; i++) {
        	double d = Math.random()*100;
        	w[i] = d;
        }
        for(int i=0; i<10; i++) {
        	System.out.printf ("%5.1f \n", w[i]);
           
        } 
        System.out.println("-----------------------------------");
        //몸무게의 합계와 평균 계산
        double hap = 0;
        for(int i = 0; i<w.length ; i++) {
        	hap += w[i];
        }
        double avg = hap/w.length;
        
        System.out.printf("합계 = %8.2f \n", hap);
        System.out.printf("평균 = %7.2f \n", avg);
        System.out.println("-----------------------------------");
       }
	   
   public static void main(String[] args) {
	   new ArrayExam1();
   }
}
