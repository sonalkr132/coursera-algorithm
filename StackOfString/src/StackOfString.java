import java.util.Scanner;

public class StackOfString {
	private Node first = null;

	private class Node{
		String item;
		Node next;
	}

	public String pop(){
		String item = first.item;
		first = first.next;
		return item;
	}

	public void push(String item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}

	public Boolean isEmpty(){
		return first == null;
	}

	public static void main(String args[]){
		StackOfString stack = new StackOfString();
		Scanner in = new Scanner(System.in);


		while(in.hasNext()){
			String input = in.nextLine();
			if(input.equals("-")) System.out.println(stack.pop());
			else stack.push(input);
		}
		in.close();
	}
}
