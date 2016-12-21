import java.util.*;
public class Colleague extends Contact{


	private String faculty;


	public void print()
	{
		System.out.println(this.getName() + " " + this.getSurname() + " " + this.getNumber() +
				" " + this.getFaculty());
	}
	
	public void edit(int option)
	{
		switch(option)
		{
		case 1: setName();
		case 2: setSurname();
		case 3: setNumber();
		case 4: setFaculty();
		default: System.out.println("Wrong option");		
		}
	}
	
	private void setFaculty()
	{
		System.out.println("Insert Workplace: ");
		Scanner in = new Scanner(System.in);
		faculty = in.nextLine();
		in.close();
	}
	public String getFaculty()
	{
		return faculty;
	}
}