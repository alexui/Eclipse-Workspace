package ex1_elf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListOfStudents {

	ArrayList<Student> list;
	
	public ListOfStudents()
	{
		this.list= new ArrayList<Student>();
		
	}
	
	public void addToList(Student val)
	{
		this.list.add(val);
	}
	
	public ArrayList<Student> getList()
	{
		return this.list;
	}
	
	public void SortByMark()
	{
		Student p = new Student();
		Comparator<Student>comp = p.new CompareTo();
		Collections.sort(list,comp);
		
	}

}
