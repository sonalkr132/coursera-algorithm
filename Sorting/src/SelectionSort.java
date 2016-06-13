
public class SelectionSort extends Array{

	SelectionSort(int n){
		super(n);
	}
	
	public void sort(){
		int n = ary.length;
		for(int i = 0; i < n; i++){
			//find minimum in i to n
			int min = Integer.MAX_VALUE, min_idx = -1;
			for(int j = i; j < n; j++){
				if(min > ary[j]){
					min = ary[j];
					min_idx = j;
				}
			}
			//swap minimum element with current ith element
			//obs: elements before i are sorted 
			swap(i, min_idx);
		}
	}
	
	public static void main(String[] args){
		SelectionSort s = new SelectionSort(10);
		s.sort();
		s.print();
	}
}
