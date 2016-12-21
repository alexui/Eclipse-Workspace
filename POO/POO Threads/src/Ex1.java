
public class Ex1 {

	static int length;
	static int lastNum;
	
	public static void run1(){
		for(int i =1;i<=length;i++){
			System.out.println(" "+i);
			Thread.yield();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void run2(){
		
		Thread t = new Thread(new PrintChar2('c',40));
		Thread p = new Thread(new PrintInt(4,40));
		//p.setPriority(Thread.MAX_PRIORITY);
		//t.setPriority(Thread.MAX_PRIORITY);
		//System.out.println(t.isAlive()); //false
		t.start();
		
		//System.out.println("Interrupted:"+t.isInterrupted()); //true
		System.out.println(t.isAlive()); //true
		
		p.start();
		for(int i=1;i<lastNum;i++){
			System.out.println(" "+i);
			if(i==40){
				//t.start();
				try {
					//t.join();
					p.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //asteapta ca threadul t sa se termine
			}
		}
		
	}
		
	public static void main(String[] args) {

		/*System.out.println("--Test1--");
		length = 10;
		run1();*/
		System.out.println("--Test2--");
		lastNum=50;
		run2();
	}

}
