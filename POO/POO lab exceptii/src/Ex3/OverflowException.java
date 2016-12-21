package Ex3;

public class OverflowException extends Exception {

	public OverflowException(){
		
		System.out.println("--Integer overflow.--");
	}
	
	private static final long serialVersionUID = 1L;
	
	public void getExceptionDetails()
	{
		System.out.println(this.getClass().getCanonicalName());
		System.out.println("I am extended from Exception Class.");
	}
	

}
