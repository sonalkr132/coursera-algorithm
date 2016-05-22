public class ResizingQueueOfString {
	private String s[];
	private int head, tail, N;

	ResizingQueueOfString(){
		s = new String[2];
		head = 0;
		tail = 0;
		N = 0;
	}

	public Boolean isEmpty(){
		return N == 0;
	}

	public void enqueue(String item){
		if(N == s.length) resize(s.length * 2);
		s[tail++] = item;
		if(tail == s.length) tail = 0;
		N++;
		printArray();
	}

	public String dequeue(){
		String item = s[head];
		s[head] = null;
		N--;
		head++;
		if(head == s.length) head = 0;
		if(N > 0 && N == s.length/4) resize(s.length/2);
		printArray();
		return item;
	}

	// used to shrink or grow the array to passed capacity
	private void resize(int capacity){
		String copy[] = new String[capacity];
		for(int i = 0; i < N; i++){
			copy[i] = s[(i + head) % s.length];
		}

		head = 0; tail = N;
		s = copy;
	}

	//for debugging purposes
	public void printArray(){
		for(int i = 0; i < s.length; i++){
			System.out.print(s[i] + " ");
		}
		System.out.println("\nhead " + head + " tail " + tail+ "\n");
	}

	public static void main(String args[]){
		ResizingQueueOfString rq = new ResizingQueueOfString();
		System.out.println(rq.isEmpty());
		rq.enqueue("a");
		rq.enqueue("b");
		rq.enqueue("c");
		rq.enqueue("d");
		rq.enqueue("e");
		rq.dequeue();
		rq.dequeue();
		rq.dequeue();
		rq.enqueue("u");
		rq.enqueue("t");
		rq.enqueue("s");
		rq.enqueue("r");
		rq.enqueue("q");
		rq.enqueue("p");
		rq.enqueue("u");
		rq.enqueue("t");
		rq.enqueue("s");
		rq.enqueue("r");
		rq.enqueue("q");
		rq.enqueue("p");
	}
}
