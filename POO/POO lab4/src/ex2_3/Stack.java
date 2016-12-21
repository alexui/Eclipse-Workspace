package ex2_3;

import ex1.Task;

public class Stack extends AbstractContainer{

	private int size;
	//private Task sp; //stack pointer
	private Task[] s = new Task[0];
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public void push(Task t) {
		
		s=reallocStack(size+1);
		s[size]=t;
		//sp=s[size];
		size++;
	}

	@Override
	public Task pop() {
		
		if(this.isEmpty())
			return null;
		Task el=s[size-1];
		reallocStack(size-1);
		size--;
		//sp=s[size];
		return el;
	}

	private Task[] reallocStack(int new_size)
	{
		if(new_size<0)
			return null;
		int old_size=size;
		int preserveLength=Math.min(new_size, old_size);
		Task[] aux = new Task[new_size];
		System.arraycopy(s, 0, aux, 0, preserveLength);
		return aux;
	}
}
