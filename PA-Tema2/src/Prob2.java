import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class Prob2 {

	public enum Color{
		BLACK,WHITE,RED,BLUE
	}
	
	public int N,K,A,B,MAXINT=Integer.MAX_VALUE;

	class Pair implements Comparable<Pair>{
		
		int u,v;
		public Pair(int u,int v){
			this.u=u;
			this.v=v;
		}
		@Override
		public int compareTo(Pair p) {
			
			if(p.u<this.u)
				return 1;
			else if(p.u==this.u){
				if(p.v<this.v)
					return 1;
				else if(p.v==this.v)
					return 0;
				else return -1;
			}
			else return -1;
					}
	}
	
	class Node{
		
		int id;
		Color c;
		int D;
		ArrayList<Integer> succs;
		
		public Node(int id){
			this.id = id;
			c=Color.WHITE;
			this.D=0;
			succs = new ArrayList<Integer>();
			succs.add(null);
		}
		
	}
	
	ArrayList<Pair> edges;
	ArrayList<Node> nodes;
	
	private void readData ( String filename ) {
		Scanner scanner = null;

		try {

			scanner = new Scanner(new File(filename));
			N=scanner.nextInt();
			K=scanner.nextInt();
			A=scanner.nextInt();
			B=scanner.nextInt();
			
			edges = new ArrayList<Pair>();
			
			int u,v;
			for(int i=0;i<K;i++){
				u=scanner.nextInt();
				v=scanner.nextInt();
				
				edges.add(new Pair(u,v));
			}
				
				//pozitia 0 nu se completeaza
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/* trebuie sa inchidem buffered reader-ul */
			try {
				if (scanner != null) scanner.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void printEdges(){
		
		PrintWriter pw=null;
		try {
			pw = new PrintWriter(new File ("edges.out"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		for(int i=0;i<K;i++){
			pw.printf("%d %d\n",edges.get(i).u,edges.get(i).v);
		}
		pw.close();
		
	}
	
	public void createUndirected(){
		
		
		
		
		
		
	/*	int k=0;
		int u =1;
		while(k<K){
			int u2 = edges.get(k).u;
						
			u=u2;
			int v = u+1;
			while(edges.get(k).u==u){
				for(int i=v;i<edges.get(k).v;i++){
					nodes.get(u).succs.add(i);
					nodes.get(i).succs.add(u);
				}
				v=edges.get(k).v+1;
				k++;
				if (k==K)
					break;
			}
			
		}
		
		if(u<N){
			for(int i=u+1;i<N;i++){
				for(int j=i+1;j<=N;j++){
					nodes.get(i).succs.add(j);
					nodes.get(j).succs.add(i);
				}
			}
		}
		*/
	}
	
	public void createNodes(){
		nodes = new ArrayList<Node>();
		nodes.add(null);
		for(int i=1;i<=N;i++){
			nodes.add(new Node(i));
		}
	}
	
	public int BFS(){
		
		LinkedList<Node> queue = new LinkedList<Node>();
		
		Node src = nodes.get(1);
		src.c=Color.BLUE;
		src.D=0;
		Node dst = nodes.get(N);
		dst.c=Color.RED;
		dst.D=0;
		
		queue.add(src);
		queue.add(dst);
		
		boolean found=false;
		
		while(!queue.isEmpty() && !found){
			Node u = queue.peek();
			for(int i=1;i<u.succs.size();i++){
				
				int v = u.succs.get(i);
				
				if(u.c==Color.BLUE && nodes.get(v).c==Color.RED){
					nodes.get(v).D=nodes.get(v).D+u.D+A;
					//System.out.println("s-au intalnit la "+u.id);
					found = true;
					return nodes.get(v).D;
				}
				
				if(u.c==Color.RED && nodes.get(v).c==Color.BLUE){
					nodes.get(v).D=nodes.get(v).D+u.D+A;
					//System.out.println("s-au intalnit la "+u.id);
					found=true;
					return nodes.get(v).D;
				}
				
				if(nodes.get(v).c==Color.WHITE){
					nodes.get(v).D=u.D+A;
					nodes.get(v).c=u.c;
					queue.add(nodes.get(v));
				}
			}
			u.c=Color.BLACK;
			queue.poll();
		}
		return B;
	}
	
	public static void main(String[] args) {
		Prob2 p = new Prob2();
		PrintWriter pw=null;
		try {
			 pw= new PrintWriter(new File("vecini.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long d= System.currentTimeMillis();
		
		p.readData("scrisori27.in");
		
		Collections.sort(p.edges);
		p.printEdges();
		p.createNodes();
		p.createUndirected();
		for(int i=1;i<=p.N;i++){
			pw.printf("%d: ",p.nodes.get(i).id);
			for(int j=1;j< p.nodes.get(i).succs.size();j++){
				pw.printf("%d ",p.nodes.get(i).succs.get(j));
			}
			pw.println();
		}
		System.out.println();
		
		System.out.println(p.BFS());
		
		System.out.println("cost: "+(System.currentTimeMillis()-d));
		
	}

}
