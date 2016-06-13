
public class ShellSort extends Array{
	ShellSort(int n){
		super(n);
	}
	
	public void sort(){
		int n = ary.length;
		int h = 1;
		//find the largest number required for h-sort sequence
		while(h < n/3) h = (3 * h + 1);
		
		while(h >= 1){
			// 3-sort, some iteration where i was at 9 
			// 2 4 18 3 67 12 9 20
			//       j-h     i,j    <- first itr of inner loop
			//j-h     j       i     <- second itr of inner loop
			for(int i = h; i < n; i++){
				for(int j = i; j >= h; j -= h) //for insertion sort h = 1; ie: for(int j = i; j >= 1; j--)
					// when j is smaller than (j - h), swap (Note: j is ahead of j - h in array)
					if(ary[j] < ary[j - h]) swap(j, j - h);
			}
			h = h/3; //next number in sequence
		}
	}
	
	public static void main(String[] args){
		ShellSort s = new ShellSort(10);
		s.sort();
		s.print();
	}
}
