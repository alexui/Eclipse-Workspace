package Ex5;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class MyHashSet<K> extends HashSet<Integer> {


	private static final long serialVersionUID = 1L;
	
	private int n=0; // number of values
	
	public int getN(){
		return this.n;
	}

	@Override
	public boolean add(Integer e){

		System.out.println("added to set");
		boolean val = super.add(e);
		if(val==false)
			return val;
		else{
			n++;
			return val;
		}
	}
	
	@Override
	public boolean addAll(Collection<? extends Integer> c){
		
		return super.addAll(c);
	/*	Iterator<? extends Integer> it = c.iterator();
		Integer nr;
		boolean val=false;
		while(it.hasNext()){
			nr = it.next();
			val = val | add(nr);
		}
		return val;*/
	}
}
