package ex1;


public class IncrementContor implements Task{

	public static int val;

	@Override
	public void execute() {
		
		val++;
		System.out.println("Incremented value: "+val);
	}

	public int getVal() {
		return val;
	}
	
	
}
