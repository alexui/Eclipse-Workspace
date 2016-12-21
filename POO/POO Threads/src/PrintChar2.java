
public class PrintChar2 implements Runnable {

	private char c;
	int nr;
	public PrintChar2(char c,int nr){
		this.c=c;	
		this.nr=nr;
	}
	
	@Override
	public void run() {
		
		System.out.println("Method run from PrintChar.");
		System.out.println("character:"+c);
	}

}
