package ex1_elf;

import java.util.Comparator;


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
	
	public class CompareTo implements Comparator<Student>{
		

		@Override
		public int compare(Student o1, Student o2) {
				
			if(o1.nota < o2.nota)
				return 1;
			else
				if(o1.nota==o2.nota)
					return new Persoana.CompareTo().compare(o1, o2);
				else
					return -1;
		}
	}
}
