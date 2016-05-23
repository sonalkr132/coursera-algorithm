import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private int N; //keeps track of size of list
    private Node first, last; //so that we can add and remove from both ends

    // helper double linked list class
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    /**
     * Initializes an empty Deque.
     */
    public Deque() {
        first = null; last = null;
        N = 0;
    }

	
	public boolean isEmpty(){
		return first == null || last == null;
	}
	
	public int size(){
		return N;
	}
	
	public void addFirst(Item item){
		if (item == null) throw new NullPointerException();
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst; first.prev = null;
		if(isEmpty()) last = first;
		N++;
	}
	
	public void addLast(Item item){
		if (item == null) throw new NullPointerException();
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null; last.prev = oldLast;
		if(isEmpty()) first = last;
		else          oldLast.next = last;
		N++;
	}
	
	public Item removeFirst(){
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		Node tmp = first;
		first = first.next;
		tmp.next = null; first.prev = null;
		N--;
		return tmp.item;
	}
	
	public Item removeLast(){
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		Node tmp = last;
		last = last.prev;
		last.next = null; tmp.prev = null;
		N--;
		return tmp.item;
	}
	
	
	public Iterator<Item> iterator()  { return new ListIterator();  }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    
    public static void main(String[] args){
    	Deque<String> dq = new Deque<String>();
    	System.out.println(dq.isEmpty());
    	
    	dq.addFirst("a");
    	dq.addFirst("b");
    	dq.addFirst("c");
    	
    	for(String s:dq) System.out.print(s + " ");
    	System.out.println("");
    	dq.addLast("a");
    	dq.addLast("b");
    	dq.addLast("c");
    	
    	for(String s:dq) System.out.print(s + " ");
    	System.out.println("");
    	
    	dq.removeFirst();
    	dq.removeLast();
    	
    	for(String s:dq) System.out.print(s + " ");
    	System.out.println("");
    }
}
