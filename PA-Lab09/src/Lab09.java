
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


class Muchie implements Comparable{
    int u;
    int v;
    int cost;

    public Muchie(int u, int v, int cost) {
        this.u=u;
        this.v=v;
        this.cost=cost;
    }

    @Override
    public int compareTo(Object o) {
        Muchie m=(Muchie) o;
        if (this.cost >= m.cost)
            return 1;
        else
            return -1;
    }
    
    public boolean contains(int n){
    	if (this.u==n || this.v==n)
    		return true;
    	return false;
    }

    @Override
    public String toString() {
        return "[("+u+", "+v+"):"+cost+"]";
    }
    
    @Override
    public boolean equals(Object o){
    	Muchie m = (Muchie)o;
    	if(m.u==this.u && m.v==this.v)
    		return true;
    	else return false;
    }
     
}

class Nod{
	int id;
	ArrayList<Nod> succs;
	Color c;
	enum Color{
		Black,White,Grey
	}
	
	public Nod(int id){
		this.id = id;
		succs = new ArrayList<Nod>();
		c= Color.White;
	}
	
	public Nod(int id,int cost){
		this.id = id;
		succs = new ArrayList<Nod>();
		c= Color.White;
	}
	
	public String toString(){
		return ""+this.id;
	}
}

public class Lab09 {
    // Flux pentru datele de intrare
    BufferedReader in = null;
    
    // Numarul de de varfuri
    int n = 0;
    //Numarul de muchii
    int m=0;
    
    // array de varfuri
    ArrayList<Integer> varfuri = new ArrayList<>();
    // array de muchii
    ArrayList<Muchie> muchii = new ArrayList<Muchie>();
    HashMap<String,Nod> noduri = new HashMap<String,Nod>();
    
    //array de subarbori
    ArrayList<ArrayList<Integer>> arbori=new ArrayList<>();
    
    //se citesc date din fisier
    public Lab09() throws FileNotFoundException, IOException {
        String filepath = "lab9";
        in = new BufferedReader(new FileReader(filepath));
        String line = null;
        int lineNum = 0;

        while ((line = in.readLine()) != null) {
            lineNum++;
            if (lineNum == 1) {
                String[] tokens = line.split(" ");
                n = Integer.parseInt(tokens[0]);
                m = Integer.parseInt(tokens[1]);
            } else {
                String[] tokens = line.split(" ");
                muchii.add(new Muchie(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));
            }
        }
        for(int i=0;i<n;i++){
            varfuri.add(i+1);
            noduri.put(String.valueOf(i+1),new Nod(i+1));
        }
    }
    
    ArrayList<Integer> MakeSet(int v){
        ArrayList<Integer> newSet=new ArrayList<>();
        newSet.add(v);
        return newSet;
    }
    
    boolean FindSet(Muchie m){
        for(int i=0;i<arbori.size();i++){
            if (arbori.get(i).contains(m.u) && arbori.get(i).contains(m.v)){
                return false;
            }
        }
        return true;
    }
    
    void Union(int u, int v){

        
        ArrayList<Integer> aux=new ArrayList<>();
        
        for(int i=0;i<arbori.size();i++){
            if (arbori.get(i).contains(u)){
                aux.addAll(arbori.get(i));
            }
            if (arbori.get(i).contains(v)){
                aux.addAll(arbori.get(i));
            }
        }
        for (int i=0;i<arbori.size();i++){
            if (arbori.get(i).contains(u)){
                arbori.remove(i);
            }
        }
        for (int i=0;i<arbori.size();i++){
            if (arbori.get(i).contains(v)){
                arbori.remove(i);
            }
        }
        arbori.add(aux);
    }
    
    ArrayList<Muchie> Kruskal(){
        ArrayList<Muchie> muchiiAMA=new ArrayList<>();
        
        for(int i:varfuri){
            arbori.add(MakeSet(i));
        }
        
        Collections.sort(muchii);
        
        for (Muchie m:muchii){
            if (FindSet(m)==true){
                muchiiAMA.add(m);
                Union(m.u, m.v);
                //System.out.println(arbori);
            }
        }
        
        return muchiiAMA;
    }
    
    //afla costul total al unui arbore minim de acoperire
    public int cost(ArrayList<Muchie> edges){
    	int cost =0;
    	for(Muchie m : edges){
    		cost+=m.cost;
    	}
    	return cost;
    }

    //metoda primeste un AMA sub forma unor liste, se incearca construirea unui graf pe baza acestor muchii
    public Nod createTree(ArrayList<Muchie> edges,int srcId){
    	for(Muchie m : edges){
    		Nod n1=noduri.get(String.valueOf(m.u));
    		Nod n2=noduri.get(String.valueOf(m.v));
    		n1.succs.add(n2);
    		n2.succs.add(n1);
    	}
    	return noduri.get(String.valueOf(srcId));
    }
    
   /* public void pathDFS(int srcId,int dstId,ArrayList<Muchie> edges,ArrayList<Muchie> path){//intr-un arbore nu vom avea noduri negre
    	
    	Nod u = noduri.get(String.valueOf(srcId));
    	u.c = Nod.Color.Grey;	//nod in curs de explorare
    	for(Nod v : u.succs){
    		if(v.c==Nod.Color.White)
    		{
    			ArrayList<Muchie> copy = copyList(edges);
    			copy.add(edges.get(edges.indexOf(new Muchie(u.id,v.id,0))));
    		}
    	}
    }*/
    
    //cauta o alta cale de intre cele doua noduricontinute de o muchie
    public ArrayList<Muchie> findPath(Muchie m,ArrayList<Muchie> edges){
    	
    	ArrayList<Muchie> path = new ArrayList<Muchie>();
    	
    	for(Muchie e:edges){
    		if(e.contains(m.u)){
    			path.add(e);
    			
    		}
    		if(e.contains(m.v)){
    			path.add(e);
    		}
    	}
		return path; 	
    }
    
    //creaza copie a unei liste de muchii
    public ArrayList<Muchie> copyList(ArrayList<Muchie> edges){
    	ArrayList<Muchie> copy = new ArrayList<Muchie>();
    	for(Muchie m:edges){
    		copy.add(m);
    	}
    	return copy;
    }
    
    //afla un alt arbore de cost minim
    public ArrayList<Muchie> findSecondAMA(ArrayList<Muchie> edges){
    	ArrayList<Muchie> AMA = new ArrayList<Muchie>();
    	ArrayList<Muchie> copy;
    	int mincost = 2*cost(edges);
    	
    	for(Muchie m : muchii){
    		if(edges.contains(m)==false){
    			copy = copyList(edges);
    			Muchie e=maxCost(findPath(m, edges));
    			copy.remove(e);
    			copy.add(m);
    			
    			int c;
				if((c =cost(copy))<mincost){
    				mincost = c;
    				AMA = copyList(copy);
    			}
    		}
    	}
    	
		return AMA;    	
    }
    
    //afla costul maxim al unei muchii dintr-o lista de muchii
    public Muchie maxCost(ArrayList<Muchie> edges){
    	int max = 0;
        Muchie maxCostEdge=null;
    	for(Muchie m:edges){
    		if(m.cost>max){
    			max = m.cost;
    			maxCostEdge = m;
    	  }
    	}
    	return maxCostEdge;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Lab09 o=new Lab09();
        //aplica algoritm AMA Kruskal
        ArrayList<Muchie> edges = o.Kruskal();
        System.out.println(edges);
        System.out.println(o.cost(edges));
        ArrayList<Muchie> path = o.findPath(new Muchie(2,4,4), edges);
        
        //gaseste un alt AMA
        edges = o.findSecondAMA(edges);
        System.out.println(edges);
        System.out.println(o.cost(edges));
        
        
    }
}
