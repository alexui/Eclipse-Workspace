package ex1_elf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListOfPersons {

	ArrayList<Persoana> list;
	
	public ListOfPersons()
	{
		this.list= new ArrayList<Persoana>();
		
	}
	
	public void addToList(Persoana val)
	{
		this.list.add(val);
	}
	
	public ArrayList<Persoana> getList()
	{
		return this.list;
	}
	
	public void SortByName()
	{
		Persoana p = new Persoana();
		Comparator<Persoana>comp = p.new CompareTo();
		Collections.sort(list,comp);
	}

	public void SortByMark()
	{
		Student p =new Student();
		ArrayList<Student> list_students = new ArrayList<Student>();
		for(int i=0;i<this.list.size();i++)
			if (list.get(i) instanceof Student)
			{
				list_students.add((Student) list.get(i));
				list.set(i, null);
			}
		Comparator<Student>comp = p.new CompareTo();
		Collections.sort(list_students,comp);
		
		for(int i=0;i<this.list.size();i++)
		{
			if(list.get(i)==null)
				{
				list.set(i, list_students.get(0));
				list_students.remove(0);
				}
		}
		
		list_students.clear();
	}

}
