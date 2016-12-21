
public class PrintInt implements Runnable {

	int nr;
	int val;
	
	public PrintInt(int val,int nr){
		this.val=val;
		this.nr=nr;
	}
	
	@Override
	public void run() {

		System.out.println("Method run from PrintInt.");
		System.out.println("character:"+val);
	}

}
