import java.util.Random;
import java.util.Vector;


public class Ex3 {

	
	private class task1 implements Runnable{

		public Vector<Character> v;
		
		public task1(){
			
			Random r = new Random();
			v = new Vector<Character>(20);
			for(int i =0;i<v.capacity();i++)
				v.add(i, (char)(r.nextInt(26)+97));
			
		}
		@Override
		public void run() {

			for(int i=0;i<v.size();i++)
				System.out.println(v.get(i));
		}
		
		
	}
	
	private class task2 implements Runnable{

		public Vector<Integer> v;
		
		public task2(){
			
			Random r = new Random();
			v = new Vector<Integer>(20);
			for(int i =0;i<v.capacity();i++)
				v.add(i, (r.nextInt(26)+97));
			
		}
		@Override
		public void run() {

			for(int i=0;i<v.size();i++)
				System.out.println(v.get(i));
		}
		
		
	}
	
	public static void main(String[] args) {

		Ex3 a = new Ex3();
		Thread t1 = new Thread(a.new task1());
		Thread t2 = new Thread(a.new task2());		//conteaza locul in care a fost declarat threadul
		t2.start();
		//t2.setPriority(Thread.MAX_PRIORITY); // t2 mai prioritar decat t1 ,dar t2 nu are prioritate totala astfel ca elemente din t1 se pot suprapune peste t2
		//t1.setPriority(Thread.MIN_PRIORITY);
		//System.out.println("priority"+t1.getPriority());
	/*	try {
			t2.join();								//threadul 1 asteapta threadul 2 sa se termine
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Thread.yield();
		t1.start();
		
	}

}
