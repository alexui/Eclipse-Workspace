package ex2_3;


public class ex_Factory_Pattern {

	public static ex_Factory_Pattern INSTANCE;
	
	private ex_Factory_Pattern()
	{	}
	
	
	public static ex_Factory_Pattern getInstance()
	{
		if(INSTANCE==null) { INSTANCE = new ex_Factory_Pattern();}
		return INSTANCE;
	}
	
	
	public Container getContainer(Fact invoker)
	{
		return invoker.create();
	}
}
