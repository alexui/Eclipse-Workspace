import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;


public class ThreadEx1 extends Thread {

	public String location;
	public PrintWriter pr;
	public Random randomGen;
	
	public ThreadEx1(String l){
		location = l;
		try {
			pr = new PrintWriter(location);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		randomGen = new Random();
		
	}
	
	public void run(){
		
		for (int i=0;i<1000;i++){
			int val = randomGen.nextInt();
			pr.print(val);
			pr.println();
			//System.out.println(val);
		}
		pr.close();
		
	}
	
	
	public static void main(String[] args) {

		int cores = Runtime.getRuntime().availableProcessors();
		
		ArrayList<ThreadEx1> threads = new ArrayList<ThreadEx1>();
		for(int i=0;i<cores;i++){
			String fileName = "location"+i;
			threads.add(new ThreadEx1(fileName));
		}
		
		System.out.println("nr of threads: "+cores);
		
		for(int i=0;i<cores;i++){
			threads.get(i).start();
		}
		
		for(int i=0;i<cores;i++){
			try {
				threads.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
