package Ex1Bonus;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static <T extends Comparable<T>> void copyAll(List<T> src,PriorityQue<T> dest){
		
		for(int i=0;i<src.size();i++){
			dest.enque(src.get(i));
		}
	}
	
	public static void main(String[] args) {
		
		int n;
		ArrayList<Student> list  = new ArrayList<Student>(); // lista cu valorile initiale
		System.out.println("Number of students: ");
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		for(int i =0;i<n;i++){
			System.out.println("Name (String), Mark(Float)");
			list.add(i,new Student(s.next(),s.nextFloat()));
		}
		//System.out.println(list.toString());
		
		PriorityQue<Student> q = new PriorityQue<Student>();
		System.out.println("--Test--");
		//q.enqueAll(list);
		copyAll(list,q);
		System.out.println(q.queSize());
		q.printList();
		while(q.iterator().hasNext())
			System.out.println(q.iterator().next().getNota());
		System.out.println();
		System.out.println(q.deque());
		System.out.println("--EndTest--");
		
		
		s.close();
	}
}
