package ex5;

import ex2_3.Strategy;

public class PrintTaskRunnerDelay extends PrintTaskRunner {

	private int delay;
	public PrintTaskRunnerDelay(Strategy str,int miliseconds) {
		super(str);
		delay = miliseconds;
	}

	@Override
	public void executeAll()
	{
		if(a==null) return;
		
		while(a.isEmpty()==false)
		{
			try {
			    Thread.sleep(delay); // milisecunde
			    a.pop().execute();
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
		}
	}
}
