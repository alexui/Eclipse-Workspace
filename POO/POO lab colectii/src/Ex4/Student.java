package Ex4;


public class Student implements Comparable<Student>{

	protected String nume;
	protected float media;
	
	public Student(String nume,float media){
		this.nume= nume;
		this.media = media;
	}
	
	@Override
	public String toString(){
		return ""+nume+","+media;
	}
	
	@Override
	public boolean equals(Object s){
		
		return(this.nume==((Student) s).getNume() && this.media == ((Student) s).getMedia());
	}

	public String getNume() {
		return nume;
	}

	public float getMedia() {
		return media;
	}
	
	@Override
	public int hashCode(){
		return this.nume.hashCode()+(int)media;
	}
	
	public void message(){
		System.out.println("sunt student");
	}

	@Override
	public int compareTo(Student o) {
		return this.getNume().compareTo(o.getNume());
	}
}
