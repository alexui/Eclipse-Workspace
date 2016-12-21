package Ex3;

import Ex2.Student;

public class Student2 extends Student{

	public Student2(String nume, float media) {
		super(nume, media);
	}

	
	@Override
	public boolean equals(Object o){
		
		return false;
	}
	
	@Override
	public int hashCode(){
		return this.nume.hashCode()+(int)media;
	}
}
