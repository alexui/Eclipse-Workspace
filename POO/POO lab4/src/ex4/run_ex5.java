package ex4;

import ex1.IncrementContor;
import ex1.PrintMessege;
import ex1.RandGen;
import ex2_3.Strategy;
import ex5.CountTaskRunner;
import ex5.PrintTaskRunner;
import ex5.PrintTaskRunnerDelay;
import ex5.RedoTaskRunner;

public class run_ex5 {


	public static void main(String[] args) {

		System.out.println("\nCountTaskRunner\n");
		CountTaskRunner taskRunner = new CountTaskRunner(Strategy.FIFO);
		taskRunner.addTask(new PrintMessege("msg 1"));
		taskRunner.addTask(new RandGen(40));
		taskRunner.addTask(new IncrementContor());
		
		System.out.println("number of tasks:"+taskRunner.getNumbOfTasks());
		taskRunner.executeAll();
		System.out.println("number of executed tasks:"+taskRunner.getNumbOfTasks());

		taskRunner.addTask(new RandGen(40));
		taskRunner.executeAll();
		System.out.println("number of executed tasks:"+taskRunner.getNumbOfTasks());
		
		System.out.println("\nPrintTaskRunner\n");
		PrintTaskRunner taskRunner2 = new PrintTaskRunner(Strategy.LIFO);
		taskRunner2.addTask(new PrintMessege("msg 2"));
		taskRunner2.addTask(new RandGen(40));
		taskRunner2.addTask(new IncrementContor());
		
		taskRunner2.executeAll();
		
		System.out.println("\nRedoTaskRunner\n");
		RedoTaskRunner taskRunner3 = new RedoTaskRunner(Strategy.LIFO);
		taskRunner3.addTask(new PrintMessege("msg 3"));
		taskRunner3.addTask(new RandGen(40));
		taskRunner3.addTask(new IncrementContor());
		
		taskRunner3.executeAll();
		taskRunner3.reexecute();
		taskRunner3.reexecute(); // nu se executa
		
		System.out.println("\nPrintTaskRunnerDelay\n");
		PrintTaskRunnerDelay taskRunner4 = new PrintTaskRunnerDelay(Strategy.LIFO,2000);
		taskRunner4.addTask(new PrintMessege("msg 3"));
		taskRunner4.addTask(new RandGen(40));
		taskRunner4.addTask(new IncrementContor());
		
		taskRunner4.executeAll();
	}

}
