package d_array;

public class AdvanceForExam {

	 AdvanceForExam(){
		 int[] s = {23,235,23,42,52,34,23,5,25,6,34,52,342,4};
		 int sum = 0;
		 double avg = 0;
		 
		 for(int k : s) {
			 sum +=k;
		 }
		 avg = (double)sum/s.length;
		 
		 System.out.println("ÇÕ°è : " + sum);
		 System.out.println("Æò±Õ : " + avg);
		 
	 }
	public static void main(String[] args) {
		new AdvanceForExam();
		
	}
}
