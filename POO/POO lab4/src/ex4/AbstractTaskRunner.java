package ex4;

import ex1.Task;
import ex2_3.Container;
import ex2_3.ContainerFactory;
import ex2_3.Strategy;

public abstract class AbstractTaskRunner {

	protected Container a;
	
	public AbstractTaskRunner(Strategy str)
	{
		/*if(str == Strategy.FIFO)
			a= new Stack();
		if(str == Strategy.LIFO)
			a= new Queue();*/
		a= ContainerFactory.getInstance().create(str);
	}	
	
	public void addTask(Task t)
	{
		a.push(t);
	}
	
	public void executeAll()
	{
		if(a==null) return;
		
		while(a.isEmpty()==false)
		{
			a.pop().execute();
		}
	}
	
	protected abstract void action();
}
