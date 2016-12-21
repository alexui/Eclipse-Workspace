import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Problema2 {

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
	
	/* structura unui nod
	 * id
	 * culoare - alb,negru, rosu daca e vizitat din sursa, albastru daca e vizitat din destinatie
	 * distanta de la sursa pana la el-D
	 * lista sortata de vecini
	 */
	class Node{
		
		int id;
		Color c;
		int D;
		SortedList<Integer> succs;
		
		public Node(int id){
			this.id = id;
			c=Color.WHITE;
			this.D=0;
			succs = new SortedList<Integer>();
		}
		
	}
	
	ArrayList<Node> nodes;
	
	private void readData ( String filename ) {
		Scanner scanner = null;

		//se citesc N,K,A,B si cele K muchii care se adauga in listele de adiacenta a nodurilor ce alcatuiesc muchia
		try {

			scanner = new Scanner(new File(filename));
			N=scanner.nextInt();
			K=scanner.nextInt();
			A=scanner.nextInt();
			B=scanner.nextInt();
			
			createNodes();
			
			int u,v;
			for(int i=0;i<K;i++){
				u=scanner.nextInt();
				v=scanner.nextInt();
				nodes.get(u).succs.add(v);
				nodes.get(v).succs.add(u);
			}
				
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
	


	//se initializeaza lista de noduri
	public void createNodes(){
		nodes = new ArrayList<Node>();
		nodes.add(null);
		for(int i=1;i<=N;i++){
			nodes.add(new Node(i));
		}
	}
	
	//se va aplica BFS pe graful format neorientat format numai din muchiile de cost A (minim)
	//se introduc initial in coada atat sursa cat si destinatia pentru a eficientiza BFS-ul
	//nodurile vizitate din sursa vor avea o culoare diferita de cele vizitate din destinatie , in timpul parcurgerii
	public int BFS(){
		
		//se creaza coada
		LinkedList<Node> queue = new LinkedList<Node>();
		
		//se adauga sursa si destinatia in coada
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
			//se cauta acei vecini cu care nodul u este legat printr-o muchide de cost A - se aplica cautare binara pe lista de adiacenta
			for(int i=1;i<N;i++){
				
				if(Collections.binarySearch(nodes.get(u.id).succs, i)<0){
					
					//nodurile care nu se gasesc in lista de adiacenta a nodului u au cost minim si intra in calculul drumului minim
					Node v = new Node(i);
					
					//daca un nod vizitat din sursa este adiacent cu un nod vizitat din destinatie => s-a gasit rezultat
					//cautarea a luat sfarsit; se aduna distantele D ale fiecarui nod + costul muchiei adiacente, care este A
					if(u.c==Color.BLUE && nodes.get(v.id).c==Color.RED){
						nodes.get(v.id).D=nodes.get(v.id).D+u.D+A;
						found = true;
						return nodes.get(v.id).D;
					}
					
					if(u.c==Color.RED && nodes.get(v.id).c==Color.BLUE){
						nodes.get(v.id).D=nodes.get(v.id).D+u.D+A;
						found=true;
						return nodes.get(v.id).D;
					}
					
					//daca nodul este nevizitat , se adauga in coada
					if(nodes.get(v.id).c==Color.WHITE){
						nodes.get(v.id).D=u.D+A;
						nodes.get(v.id).c=u.c;
						queue.add(nodes.get(v.id));
					}
				}
			}
			//dupa ce un nod este tratat este scos din coada; lui i se va asocia culoarea pentru nodurile vizitate (negru)
			u.c=Color.BLACK;
			queue.poll();
		}
		return B;
	}
	
	public static void main(String[] args) {
		Problema2 p = new Problema2();
		PrintWriter pw=null;
		try {
			 pw= new PrintWriter(new File("scrisori.out"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		p.readData("scrisori.in");
		
		pw.print(p.BFS());
		pw.close();
		
	}

}
