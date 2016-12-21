package ex5;

import ex2_3.Strategy;
import ex4.AbstractTaskRunner;

public class CountTaskRunner extends AbstractTaskRunner {

	private int number_of_tasks;
	
	public CountTaskRunner(Strategy str) {
		super(str);
	}

	@Override
	public void executeAll()
	{
		action();
		if(a==null) return;
		
		while(a.isEmpty()==false)
		{
			a.pop().execute();
		}
	}
	
	@Override
	protected void action() {

		this.number_of_tasks+=a.size();
	}
	
	public int getNumbOfTasks()
	{
		return this.number_of_tasks;
	}

}
