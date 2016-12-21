import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;


public class ThreadEx2 extends Thread{
	final Object lock = new Object();
	static Vector<Integer> list;
	Integer threadNum;
	Integer numThreads;
	static final int MAXLUNG =100;
	Random r;
	
	public ThreadEx2(Integer num_thread,Integer num_threads){
		
		this.threadNum = num_thread;
		this.numThreads = num_threads;
		r = new Random();
	}
	
	public static void initialize(int nr){
			//add face altceva
			list.set(nr,nr*nr);
	}
	
	public void run(){
		
		int pos =threadNum;
		//synchronized (list) 
		{	
			while(pos<MAXLUNG){
				initialize(pos);
				pos+=numThreads;
			}
		}
	}
	
	public static void main(String[] args) {
		
		list = new Vector<Integer>();
		for (int i=0;i<ThreadEx2.MAXLUNG;i++){
			list.add(0);
		}
		
		int cores = Runtime.getRuntime().availableProcessors();
		
		ArrayList<ThreadEx2> threads = new ArrayList<ThreadEx2>();
		for(int i=0;i<cores;i++){
			threads.add(new ThreadEx2(i,cores));
		}
		
		System.out.println("nr of threads: "+cores);
		
		for(int i=0;i<cores;i++){
			//if(i==3)
				threads.get(i).start();
		}
		
		for(int i=0;i<cores;i++){
			try {
				threads.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(list);
	}
}
