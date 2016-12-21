import java.util.Scanner;
public class Friend extends Contact{


	private String homeAdress;


	public void print()
	{
		System.out.println(this.getName() + " " + this.getSurname() + " " + this.getNumber() +
				" " + this.getClass());
	}
	
	public void edit(int option)
	{
		switch(option)
		{
		case 1: setName();
		case 2: setSurname();
		case 3: setNumber();
		case 4: setHomeAdress();
		default: System.out.println("Wrong option");		
		}
	}
	
	private void setHomeAdress()
	{
		System.out.println("Insert Home Adress: ");
		Scanner in = new Scanner(System.in);
		homeAdress = in.nextLine();
		in.close();
	}
	public String getHomeAdress()
	{
		return homeAdress;
	}
}