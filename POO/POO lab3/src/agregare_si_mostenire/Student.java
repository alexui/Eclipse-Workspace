package agregare_si_mostenire;

public class Student extends Persoana{

	private int nota;

	public Student() {
		super();
	}

	public Student(int nota) {
		super();
		this.nota = nota;
	}
	
	public Student(String nume,int nota) {
		super(nume);
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		
		return ""+this.getClass().getSimpleName()+": "+super.toString()+", "+this.nota;
	}
	
	public boolean equals(int nota)
	{
		if(this.nota==nota)
			return true;
		return false;
	}
	
	public void invata()
	{
		System.out.println(super.toString()+" invata.");
	}
}
