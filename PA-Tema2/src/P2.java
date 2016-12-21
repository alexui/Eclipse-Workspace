import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class P2 {
	
	public int N,K,A,B,MAXINT=Integer.MAX_VALUE;
	public ArrayList<Node> nodes;
	public PriorityQueue<Node> queue;
	
	public class Node{
		int id;
		int P;//parent
		int D;//distance
		ArrayList<Integer> succs;
		boolean S;
		
		public Node(int id,int p,int d,ArrayList<Integer> succs){
			this.id=id;
			this.P=p;
			this.D=d;
			this.S=false;
			this.succs=succs;
		}
		
		public void setS(boolean s){
			this.S=s;
		}
		
		@Override
		public boolean equals(Object o){
			
			Node n = (Node) o;
			if(id == n.id)
				return true;
			return false;
		}
	}
	
	
	ArrayList<ArrayList<Integer>> matrix;
	
	private void readData ( String filename ) {
		Scanner scanner = null;

		try {

			scanner = new Scanner(new File(filename));
			N=scanner.nextInt();
			K=scanner.nextInt();
			A=scanner.nextInt();
			B=scanner.nextInt();
			
			queue = new PriorityQueue<>(N, new Comparator<Node>() {

				@Override
				public int compare(Node n1, Node n2) {
					if (n1.D>n2.D)
						return 1;
					else if (n1.D==n2.D)
						return 0;
					else return -1;
				}
			});
			
			nodes = new ArrayList<Node>();
			nodes.add(null);
			
			matrix = new ArrayList<ArrayList<Integer>>(N+1);
			matrix.add(null);
			for(int i=1;i<N+1;i++){
				ArrayList<Integer> line = new ArrayList<Integer>(N+1);
				line.add(null);
				
					for(int j=1;j<N+1;j++)
						if(i!=j){
							line.add(new Integer(A));
							}
						else line.add(null);
				
				matrix.add(line);	
				
				if(i==1)
					nodes.add(new Node(1,0,0,matrix.get(1))); //S setat 0
				else {
					Node node = new Node(i,1,matrix.get(1).get(i),matrix.get(i));
					nodes.add(node);
				}
			}
			
			for(int i=0;i<K;i++){
				int u,v;
				u=scanner.nextInt();
				v=scanner.nextInt();
				
				if(u==1)
					nodes.get(v).D=B;	//distantele minime de la sursa la nod curent
				
				matrix.get(u).set(v, B);
				matrix.get(v).set(u, B);
			}
			
			for(int i=2;i<N+1;i++){
				queue.add(nodes.get(i));
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

	private void printMatrix(){
	
		int i,j;
		for(i=1;i<N+1;i++){
			for(j=1;j<nodes.get(i).succs.size();j++){
				int n=0;
				if(nodes.get(i).succs.get(j)!=null)
					n=nodes.get(i).succs.get(j);
				System.out.printf("%5d  ",n);
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	private int shortestPath(int s){
		
		Node src = nodes.get(s);
		src.S=true;
		for(int i=2;i<nodes.size();i++){
			Node k = queue.poll();
			k.S=true;
						
			for(int j =1;j<nodes.get(k.id).succs.size();j++)
			{
				if(nodes.get(j).S==false && (k.D+nodes.get(k.id).succs.get(j))<nodes.get(j).D){
					queue.remove(nodes.get(j));
					nodes.get(j).D=(k.D+nodes.get(k.id).succs.get(j));
					nodes.get(j).P=k.id;

					queue.add(nodes.get(j));
				}
			}
			
		}
		
		/*for(int i=1;i<N+1;i++)
		{
			System.out.printf("%d ",nodes.get(i).D);
			System.out.printf("%d ",nodes.get(i).P);
			System.out.println();
		}*/
		
		Node n= nodes.get(N);
				
	/*	do{
			System.out.print(n.id+ " ");
			n=nodes.get(n.P);			
		}while(n.P!=0);*/
		
		return nodes.get(N).D;
		
	}
	
	public static void main(String[] args) {
		
		P2 p = new P2();
		p.readData("scrisori5.in");
		//p.printMatrix();
		/*
		
		for(Node n : p.nodes){
			if(n!=null)
			System.out.printf("%d ",n.D);
		}
		System.out.println();
	/*	boolean v=p.queue.remove(p.nodes.get(2));
		System.out.println(p.nodes.get(2).id);
		System.out.println(v);*/
		
/*
		System.out.println(p.queue.poll().D);
		System.out.println(p.queue.poll().D);
		System.out.println(p.queue.poll().D);*/

		System.out.println("result: "+p.shortestPath(1));
	}

}
