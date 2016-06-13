import java.util.Random;

public class Array {
	public int[] ary;
	
	Array(int n){
		ary = new int[n];
		Random randomGenerator = new Random();
		for (int idx = 0; idx < n; ++idx){
	      ary[idx] = randomGenerator.nextInt(100);
	    }
	}
	
	public void swap(int i, int j){
		int tmp = ary[i];
		ary[i] = ary[j];
		ary[j] = tmp;
	}
	public void print(){
		for(int i = 0; i < ary.length; i++)
			System.out.print(ary[i] + " ");
	}
}
