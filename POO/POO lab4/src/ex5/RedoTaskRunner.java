package ex5;

import ex1.Task;
import ex2_3.Container;
import ex2_3.Stack;
import ex2_3.Strategy;
import ex4.AbstractTaskRunner;

public class RedoTaskRunner extends AbstractTaskRunner {

	private Container aux = new Stack();
	private Task task;
	
	public RedoTaskRunner(Strategy str) {
		super(str);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeAll()
	{
		if(a==null) return;
		
		while(a.isEmpty()==false)
		{
			task=a.pop();
			aux.push(task);
			task.execute();
		}
	}
	
	@Override
	protected void action() {

		if(aux==null) return;
		
		while(aux.isEmpty()==false)
		{
			aux.pop().execute();
		}
	}
	
	public void reexecute()
	{
		action();
	}

	
}
