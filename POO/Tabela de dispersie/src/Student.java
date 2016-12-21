
public class Student {

	private String nume;
	private int varsta;
	
	
	public Student(String nume, int varsta) {
		super();
		this.nume = nume;
		this.varsta = varsta;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	@Override
	public int hashCode()
	{
		int h = nume.hashCode();
		return h = 37 * h + varsta;
	}
	
	@Override
	public boolean equals(Object o)
	{
		Student s = (Student)o;
		if(s.getNume()==this.nume && s.getVarsta()==this.varsta)
			return true;
		else 
			return false;
	}
}
