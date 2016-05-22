public class FixedCapacityStackOfString {
	private String s[];
	private int N = 0;

	public FixedCapacityStackOfString(int capacity){
		s = new String[capacity];
	}

	public Boolean isEmpty(){
		return N == 0;
	}

	public void push(String item){
		s[N++] = item;
	}

	public String pop(){
		return s[--N];
	}
}
