package Ex1Bonus;

import java.util.Iterator;
import java.util.List;

public class PriorityQue<ComparableObject extends Comparable<ComparableObject>>implements Iterable<ComparableObject>{

	private SimpleLinkedList<? extends Comparable<ComparableObject>> list;
	
	public PriorityQue(){
		list = new SimpleLinkedList<ComparableObject>();
	}
	
	private class SimpleLinkedList<K extends Comparable<ComparableObject>>{
		
		private class Nod<T> {

			public T value;
			public Nod<T> next;
			@Override
			public String toString(){
				return ""+value+" ";	
				}
		}
		
		private Nod<ComparableObject> cap;
		private int size;
		private int IteratorIndex;
		
		public SimpleLinkedList(){
			this.cap = new Nod<ComparableObject>();
			this.size = 0;
			this.IteratorIndex=0;
		}
				
		public void add(ComparableObject val){ // adaugare ordonata crescator
			
			Nod<ComparableObject> newNod = new Nod<ComparableObject>();
			newNod.value = val;
			newNod.next = null;
			
			if(size==0){
				this.cap=newNod;
				size++;
				return;
			}
			
			if(val.compareTo(cap.value)<0){
				newNod.next = cap;
				this.cap = newNod;
				size++;
				return;
			}
			
			Nod<ComparableObject> nod=cap;
			while((nod.next !=null) && nod.next.value.compareTo(val)<0){
				nod = nod.next;
			}
			newNod.next=nod.next;
			nod.next=newNod;
			size++;
		}

		public ComparableObject get(){
			
			if(size==0) return null;
			
			if(size==1){
				Nod<ComparableObject> aux;
				aux = cap;
				cap = null;
				size--;
				return aux.value;
			}
			
			Nod<ComparableObject> nod;
			nod = cap;
			cap=cap.next;
			size--;
			return nod.value;
		}
		
				
		public ComparableObject get(int i){
			
			if(i==0)
				return cap.value;
			
			Nod<ComparableObject> nod=cap;
			for(;i>0;i--){
				nod=nod.next;
			}
			return nod.value;
		}
		
		public ComparableObject next(int i){
			
			if(i==0){
				return cap.value;
			}
			
			Nod<ComparableObject> nod=cap;
			for(;i>0;i--){
				nod=nod.next;
			}
			return nod.value;
		}
			
		public int size(){
			return size;
		}
	
	}

	public void enque(ComparableObject o){
		list.add(o);
	}

	public void printList(){
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i));
		}
		System.out.println();
	}
	
	public ComparableObject deque(){
		return list.get();
	}
	
	@Override
	public Iterator<ComparableObject> iterator() {
		//clasa anonima
		return new Iterator<ComparableObject>() {

			
			@Override
			public boolean hasNext() {
				if (list.IteratorIndex<list.size)
					return true;
				return false;
			}

			@Override
			public ComparableObject next() {
				
				list.IteratorIndex++;
				return list.next(list.IteratorIndex-1);
			}

			@Override
			public void remove() {
				return;
				// aceasta metoda nu se defineste		
			}
		};
	}
	
	public void enqueAll(List<? extends ComparableObject> l){
	
		for(int i=0;i<l.size();i++)
			enque(l.get(i));
	}
	
	public int queSize(){
		return list.size();
	}
}
