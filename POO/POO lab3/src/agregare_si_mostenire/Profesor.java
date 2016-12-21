package agregare_si_mostenire;

public class Profesor extends Persoana{

	private String materie=null;

	public Profesor() {
		super();
	}

	
	public Profesor(String materie) {
		super();
		this.materie = materie;
	}
	
	public Profesor(String nume,String materie) {
		super(nume);
		this.materie = materie;
	}


	@Override
	public String toString() {
		
		return ""+this.getClass().getSimpleName()+": "+super.toString()+", "+this.materie;
		
	}
	
	public void preda()
	{
		System.out.println(super.toString()+" preda.");
	}
	
	
	
}
