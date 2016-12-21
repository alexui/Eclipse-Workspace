package ex2_3;

public class ContainerFactory implements IFactory{

	private Container a;
	public static ContainerFactory INSTANCE;
	
	private ContainerFactory()
	{	}
	
	private ContainerFactory(Strategy str)
	{	
		this.a=this.create(str);
	}
	
	public static ContainerFactory getInstance()
	{
		if(INSTANCE==null) { INSTANCE = new ContainerFactory();}
		return INSTANCE;
	}
	
	public static ContainerFactory getInstance(Strategy str)
	{
		if(INSTANCE==null) { INSTANCE = new ContainerFactory(str);}
		return INSTANCE;
	}
	
	@Override
	public Container create(Strategy str) { // ar fi mai potrivit private
		
		if(str==Strategy.FIFO)
			a = new Stack();
		if(str==Strategy.LIFO)
			a = new Queue();
		return a;
	}

	public Container getContainer()
	{
		return a;
	}
}
