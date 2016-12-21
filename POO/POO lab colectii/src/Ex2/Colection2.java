package Ex2;

import Ex1.MyLinkedHashSet;
//a)
public class Colection2 {

	public static void main(String[] args) {

		MyLinkedHashSet<Student> set = new MyLinkedHashSet<Student>();
		set.add(new Student("Razvan",7.60f));
		set.add(new Student("Marian",6.90f));
		set.add(new Student("Alex",8.80f));
		for(Student s : set){
			System.out.println(s.toString());
		}
		set.add(new Student("Alex",8.80f));
		set.add(new Student("Razvan",7.60f));
		System.out.println();
		for(Student s : set){
			System.out.println(s.toString()); //Obs se accepta elemente identice
		}
		
		
	}

}
