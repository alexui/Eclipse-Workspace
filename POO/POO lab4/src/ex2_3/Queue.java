package ex2_3;

import java.util.ArrayList;

import ex1.Task;



public class Queue extends AbstractContainer{

	ArrayList<Task> q = new ArrayList<Task>();
	private int size;
	
	@Override
	public int size() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	@Override
	public void push(Task t) {
		
		q.add(t);
		size++;
	}
	@Override
	public Task pop() {
		
		if(this.isEmpty()) return null;
		
		Task el=q.get(0);
		q.remove(0);
		size--;
		return el;
	}	

}
