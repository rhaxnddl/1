package e_class;

public class ArrayParam {
	
   ArrayParam(int[] s){	  
	   for(int i=0; i<s.length; i++) {
		   System.out.println(s[i]);
	   }
   }
   
   int arraySum(int[] s) {
	   int sum = 0;
	   for(int i=0; i<s.length; i++) {
		   sum +=s[i];
	   }
	   return sum;
   }
   // 전달 받은 배열에서 최대값을 구하여 리턴
   // int []안에는 데이터 유형이 오기 때문에 숫자를 쓸수 없음.
  int arrayMax(int[] s ) {
	int max = s[0];
	
	for(int i = 1; i<s.length; i++) {
		if( max < s[i] ) max = s[i];
	}
	return max;
  }
  
  //전달 받은 배열에서 최소값을 추출하여 반환
  int arrayMin(int[] s) {
	  int min = s[0];
	  
	  for(int i = 1; i<s.length; i++) {
		  if(min> s[i]) min = s[i];
	  }
	  return min;
	  // return문장 뒤에서는프로그램 실행 안된다.
	  // return 문장을 두번 쓸수는 없다.
  }
  
  int [] maxMin(int[] s) {
	  int[] m = new int [2];
	 m[0] = s[0];   // max
//  max = s[0];
	 m[1] = s[0];   // min
//  min = s[0];	  
	  for(int i = 1; i<s.length; i++) {
		  if(m[0]>s[i]) m[0] = s[i];		
	 //  if(max>s[i]) max = a[i];
		  if(m[1]<s[i]) m[1] = s[i];		  
	//   if(min<s[i]) min = s[i];
	  }	  
//    m = new int[] {max,min}
	  return m;
  }
   
	public static void main(String[] args) {
		int[] abc = {111, 2, 3, 4, 511, 6, 7, 8, 9, -10};
		ArrayParam ap1 = new ArrayParam(abc); // 생성자가 abc(정수형 배열타입)  
		int hap = ap1.arraySum(abc);
		System.out.println(hap);
		
		int m = ap1.arrayMax(abc);
		System.out.println("최대값  : " + m);
		
		m = ap1.arrayMin(abc);
		System.out.println("최소값 : " + m);
		
		System.out.println("----------------------------");
		int[] r = ap1.maxMin(abc);
		System.out.println("최대값r[0] : " + r[0]);
		System.out.println("최소값r[1] :" + r[1]);		
	}

}
