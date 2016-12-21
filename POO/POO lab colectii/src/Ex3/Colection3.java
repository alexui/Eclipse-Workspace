package Ex3;
import java.util.Iterator;

import Ex1.MyLinkedHashSet;
import Ex2.Student;;

public class Colection3 {

	public static void main(String[] args) {
		
		MyLinkedHashSet<Student2> set = new MyLinkedHashSet<Student2>();
		set.add(new Student2("Razvan",7.60f));
		set.add(new Student2("Marian",6.90f));
		set.add(new Student2("Alex",8.80f));
		for(Student2 s : set){
			System.out.println(s.toString());
		}
		set.add(new Student2("Alex",8.80f));
		set.add(new Student2("Razvan",7.60f));
		System.out.println();
		for(Student s : set){
			System.out.println(s.toString()); //Obs se accepta elemente identice
		}
		
		System.out.println();
		
		Student2 myStudent = new Student2("Razvan",7.60f);
		Iterator<Student2> it = set.iterator();
		while(it.hasNext())
			{
			Student aux = it.next();
				if(myStudent.equals(aux))
					System.out.println("found1");
				if(((Object)aux).equals(aux)) //nu se poate face upcasting pentru metode suprascrise
					System.out.println("found2");
				(myStudent).message();
			}
		
	}
}
