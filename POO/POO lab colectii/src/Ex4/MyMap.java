package Ex4;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;


public class MyMap{


	private TreeMap<Integer,LinkedList<Student>> map = null;
	
	
	
	public MyMap(int n,Comparator<Integer> comp){
		
		this.map =new TreeMap<Integer,LinkedList<Student>>(comp);
		for(int i=0;i<=n;i++)
		{
			map.put(i, null);
		}
	}
	
	private int aproximate(Float val){
		if(val-val.intValue()>0 && val -val.intValue()<0.50)
			return val.intValue();
		else return val.intValue()+1;
	}
	
	public Student add(Float key,Student value){
		
		int position=aproximate(key); // se aproximeaza media
	/*	int position=0; //pozitia bucketului in care se va face inserarea
		Iterator<Integer> it = map.keySet().iterator(); // se incearca sa se ajunga la lista asociata mediei aproximate cu un iterator
		while(it.hasNext() && position !=k){
			position = it.next();
		}*/
		
		LinkedList<Student> values = map.get(position); // se obtine lista asocoiata mediei aproximate
		
		if(values==null){									// daca in lista nu se gasesc elemente
			values = new LinkedList<Student>();			// se creaza o noua lista
			values.add(value);								// se adauga valoare si se returneaza null
			map.put(position, values);
			return null;
		}
		
		else{
			if(values.contains(value)==false){				// daca in lista se gasesc elemente 
				values.add(value);							//daca elmentul nu se gaseste in lista se adauga element si se returneaza null
				return null;
			}
			else{
					Iterator<Student> it2 = values.iterator(); // se creaza un iterator pt a ajunge la studentul cu numele din value
					Student s=null;
					while(it2.hasNext())
					{
						s=it2.next();
						if(s.equals(value))
						{
							System.out.println("Exisiting element:"+s+","+position);
						}					
					}
					return s;
					
			}
		}
	}

	public TreeMap<Integer, LinkedList<Student>> getMap(){
		return this.map;
	}
	
}