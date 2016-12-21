package ex5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ex2_3.Strategy;
import ex4.AbstractTaskRunner;

public class PrintTaskRunner extends AbstractTaskRunner {

	public PrintTaskRunner(Strategy str) {
		super(str);
	}

	@Override
	public void executeAll()
	{
		if(a==null) return;
		
		while(a.isEmpty()==false)
		{
			a.pop().execute();
			action();
		}
	}
	
	@Override
	protected void action() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println();
		System.out.println("Task executed at: "+dateFormat.format(date));
	}
	
	

}
