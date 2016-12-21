import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Kruskal {

	int N;
	int M;
	Graph g;
	
	ArrayList<ArrayList<Pair>> trees;
	
	ArrayList<Pair> copyList(ArrayList<Pair> list){
		ArrayList<Pair> new_list = new ArrayList<Pair>();
		for(Pair p: list)
			new_list.add(p);
		return new_list;
	}
	
	public Kruskal(){
		g = new Graph();
		trees = new ArrayList<ArrayList<Pair>>();
	}
	
	//metoda pentru citirea datelor din fisier
		private void readData ( String filename ) {
			Scanner scanner = null;

			try {

				scanner = new Scanner(new File(filename));
				N = scanner.nextInt();
				M= scanner.nextInt();
				for(int i=1;i<=N;i++){
					g.getNodes().put(String.valueOf(i), new Node(String.valueOf(i),i));
				}
				
				for(int i=0;i<M;i++){
					int n1 = scanner.nextInt();
					int n2 = scanner.nextInt();
					int cost = scanner.nextInt();
					
					g.getEdges().add(new Pair(
							g.getNodes().get(String.valueOf(n1)),
							g.getNodes().get(String.valueOf(n2)),
							cost)
					);
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
		
	public void kruskal(ArrayList<Pair> AMA,PriorityQueue<Pair> q){
		
		if(q.isEmpty()){
			trees.add(AMA);
			return;
		}
		
		Pair p;
		do{
			p=q.poll();
		}while(p.getNode1().getFindSet()==p.getNode2().getFindSet());
		
		int min = Math.min(p.getNode1().getFindSet(), p.getNode2().getFindSet());
		p.getNode1().setFindSet(min);
		p.getNode2().setFindSet(min);
		
		/*if(q.size()>1)
			if(q.peek().getCost()==p.getCost()){
				ArrayList<Pair> AMAcopy = new ArrayList<Pair>();
				AMAcopy = copyList(AMA);
				System.out.println("Ama:"+AMA);
				kruskal(AMAcopy,q);
				}*/
		
		
		AMA.add(p);
		ArrayList<Pair> AMAcopy = new ArrayList<Pair>();
		AMAcopy = copyList(AMA);
		kruskal(AMA,q);
				
	}
	
	public static void main(String[] args) {
		Kruskal k = new Kruskal();
		
		ArrayList<Pair> AMAedges  = new ArrayList<Pair>();	//MuchiiAMA <- multimea vida
		k.readData("lab9");									//fiecare nod din graf e un arbore diferit
		//sortare muchii dupa cost
		PriorityQueue<Pair> q = new PriorityQueue<Pair>(k.M,new Comparator<Pair>() {	//sort(E)

			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.getCost()>o2.getCost())
					return 1;
				else if(o1.getCost()<o2.getCost())
					return -1;
				return 0;
			}
		});
		
		q.addAll(k.g.getEdges());
		
		k.kruskal(AMAedges,q);				//afla toti arborii de acoperire 
		
		System.out.println("Arbori de acoperire:");
		for(int i=0;i<k.trees.size();i++){
			System.out.println(k.trees.get(i));
		}
		
		System.out.println(k.g.getEdges());
	}

}
