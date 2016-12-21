package Ex3;

public class UnderflowException extends Exception {
	
public UnderflowException(){
		
		System.out.println("--Integer underflow.--");
	}

private static final long serialVersionUID = 1L;
	
	public void getExceptionDetails()
	{
		System.out.println(this.getClass().getCanonicalName());
		System.out.println("I am extended from Exception Class.");
	}
}
