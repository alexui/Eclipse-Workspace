import java.util.Scanner;
public class Acquaintance extends Contact{


	private String workplace;


	public void print()
	{
		System.out.println(this.getName() + " " + this.getSurname() + " " + this.getNumber() +
				" " + this.getWorkplace());
	}
	
	public void edit(int option)
	{
		switch(option)
		{
		case 1: setName();
		case 2: setSurname();
		case 3: setNumber();
		case 4: setWorkplace();
		default: System.out.println("Wrong option");		
		}
	}
	
	private void setWorkplace()
	{
		System.out.println("Insert Workplace: ");
		Scanner in = new Scanner(System.in);
		workplace = in.nextLine();
		in.close();
	}
	public String getWorkplace()
	{
		return workplace;
	}
}