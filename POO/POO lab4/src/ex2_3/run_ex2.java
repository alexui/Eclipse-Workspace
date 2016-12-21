package ex2_3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ex1.IncrementContor;
import ex1.PrintMessege;
import ex1.RandGen;
import ex1.Task;


public class run_ex2 {
	
	public static void checkInstance(Task t)
	{
		if(t instanceof IncrementContor)
			System.out.println("Valoare:"+((IncrementContor)t).getVal());
		if(t instanceof PrintMessege)
			System.out.println("Mesaj: "+((PrintMessege)t).getS());
		if(t instanceof RandGen)
			System.out.println("Numar generat: "+((RandGen)t).getNr());
	}

	public static void main(String[] args) {

		//ContainerFactory factory = ContainerFactory.getInstance();
		//Container cont = factory.create(Strategy.FIFO);
		
		//ex_Factory_Pattern.getInstance().setContainer(new LIFO());
		Container cont = ex_Factory_Pattern.getInstance().getContainer(new LIFO());
		
		cont.push(new IncrementContor());
		cont.push(new PrintMessege("This is a message"));
		cont.push(new RandGen(9));
		cont.push(new IncrementContor());
		cont.push(new PrintMessege("Alex"));
		cont.push(new IncrementContor());
		cont.push(new IncrementContor());
		cont.push(new IncrementContor());
		
		Task t;
		
		System.out.println("container size:"+cont.size() );
		t=cont.pop();
		t.execute();
		
		System.out.println("container size:"+cont.size() );
		t=cont.pop();
		t.execute();
		
		System.out.println("container size:"+cont.size() );
		t=cont.pop();
		t.execute();
		
		System.out.println("container size:"+cont.size() );
		t=cont.pop();
		t.execute();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		//checkInstance(t);
	}

}
