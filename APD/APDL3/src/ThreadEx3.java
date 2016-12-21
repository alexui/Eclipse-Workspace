//tampon
public class ThreadEx3{
	
	int buffer;
	boolean emptyBuffer=true;
	
	//numai un singur thread poate sa produca
	public synchronized void produce(int val){
		
		if(!emptyBuffer)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		{
			System.out.println("i produce:"+val);
			buffer=val;
			emptyBuffer = false;
			notify(); //notify consumer
		}
		
	}
	
	//numai un singur thread poate sa consume
	public synchronized int consume(){
		

		if(emptyBuffer){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		emptyBuffer=true;
		notify();
		return buffer;
	}
	
	public static void main(String[] args) {
		
		ThreadEx3 t = new ThreadEx3();
		Producer p = new Producer(t);
		Consumer c = new Consumer(t);
		System.out.println("salut");
		p.start();
		c.start();
		
		/*try {
			p.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
}

class Producer extends Thread{
	
	ThreadEx3 tampon;
	public Producer(ThreadEx3 tampon){
		this.tampon=tampon;
	}
	
	public void run(){
		for(int i=0;i<14;i++)
			tampon.produce(i);
	}

}

class Consumer extends Thread{
	
	ThreadEx3 tampon;
	public Consumer(ThreadEx3 tampon){
		this.tampon=tampon;
	}
	
	public void run(){
		while(true){
			int val = tampon.consume();
			System.out.println("I consume:"+val);
		}
		
			
	}

}


