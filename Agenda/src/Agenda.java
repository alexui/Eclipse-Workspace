import java.util.*;
public class Agenda {

	private String owner;
	private Contact Contacte[] = new Contact[100];
	static private int nElem = 0;
	
	public Agenda()
	{
		setOwner();
	}
	
	public void setOwner()
	{
		System.out.println("Insert owner: ");
		Scanner in = new Scanner(System.in);
		owner = in.nextLine();
		in.close();
		System.out.println("The owner has been changed;");
	}
	
	public String getOwner()
	{
		return owner;
	}

	public void addContact()
	{
		System.out.println("Insert contact: ");
		Scanner in = new Scanner(System.in);
		Contacte[nElem++].setName();
		Contacte[nElem++].setSurname();
		Contacte[nElem++].setNumber();
		in.close();
		System.out.println("The contact has been added;");
	}
	
	public void deleteContact(int position)
	{

		int index=0;
		for(index=position;index<nElem;index++)
		{
			Contacte[index]=Contacte[index+1];
		}
		nElem--;
		System.out.println("The contact has been removed;");
	}
	
	public void searchName()
	{
		System.out.println("Insert name: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		int index =0;
		System.out.println("Results: ");
		for(index=0;index<nElem;index++)
		{
			if(name.compareTo(Contacte[index].getName())==0)
			{
				Contacte[index].print();
			}
			
		}
		System.out.println("End! ");
		in.close();
		
	}
	
	public void print()
	{
		int index=0;
		for(index=0;index<nElem;index++)
		{
			Contacte[index].print();
		}
	}
	
	
}
