package Ex1;


public class Student implements Comparable<Student>{

	private String nume;
	private Float nota;
	
	public Student(String nume,Float nota){
		this.nota= nota;
		this.nume = nume;
	}
	
	
	public String getNume() {
		return nume;
	}


	public void setNume(String nume) {
		this.nume = nume;
	}


	public Float getNota() {
		return nota;
	}


	public void setNota(Float nota) {
		this.nota = nota;
	}


	public boolean equals(Object o){
		Student s = (Student)o;
		if(s.nume==this.nume && s.nota==this.nota) return true;
		return false;
	}
	
	@Override
	public String toString(){
		
		return ("["+nume+","+nota+"]");
	}

	@Override
	public int compareTo(Student o) {
		if(this.nota<o.nota)
			return -1;
		if(this.nota == o.nota) return 0;
		else return 1;
	}


}
