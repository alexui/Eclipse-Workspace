package agregare_si_mostenire;

public class Stiva extends Array{

	public Stiva()
	{
		super();
	}
	
	public Stiva(int n)
	{
		super(n);
	}
	
	public void push(int val)
	{
		super.set(super.getNr_elem(), val);
		incNr_Elem();
	}
	
	public int pop()
	{
		int val=super.get(getNr_elem()-1);
		if(val!=Error)
			this.decNr_elem();
		return val;
	}
	
}
