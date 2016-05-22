import java.util.Scanner;

public class UF {
	private int[] id, sz;
	
	public UF(int N){
		id = new int[N];
		sz = new int[N];
		//initialize the array with index = id
		//0 1 2 3 4 5 .. N
		//and size of each tree = 1 (initially all nodes are individual)
		for(int i = 0; i < N; i++){
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public boolean connected(int p, int q){
		//p and q are connected if they have same id/root
		return root(p) == root(q);
	}
	
	private int root(int i){
		//keep on looping until you reach the point where the id
		//does not change. when connecting two trees, only the id of root
		//node of smaller tree changes. Rest of ids in the smaller tree
		//remains same.
		while (i != id[i]){
			id[i] = id[id[i]]; //when traversing if we are not done yet, then point the
			                   //child to its grand parent. it will make the tree flatter
			i = id[i];
		}
		return i;
	}
	
	public void union(int p, int q){
		int pid = id[p];
		int qid = id[q];
		
		if(pid == qid) return;
		
		//id with smaller tree goes under.
		//ie it changes its id so that it now points
		//to new root
		if(sz[pid] < sz[qid]){
			id[pid] = qid; //set the id of smaller tree
			sz[qid] += sz[pid]; //increase size of larger tree
		} else {
			id[qid] = pid;
			sz[pid] += sz[qid];
		}
		printArray();
	}
	
	//for debugging purposes
	public void printArray(){
		for(int i = 0; i < id.length; i++){
			System.out.print(id[i] + " ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		//first enter size of array
		UF uf = new UF(N);
		while(in.hasNext()){
			//then nodes between which link is to be found or made
			int p = in.nextInt();
			int q = in.nextInt();
			if(!uf.connected(p, q)){
				uf.union(p, q);
				System.out.println(p + " " + q);
			}
		}
		in.close();
	}
}
