import java.util.Scanner;


public class Contact {
	
	private String name;
	private String surname;
	private String number;

	public void print()
	{
		System.out.println(this.getName() + " " + this.getSurname() + " " + this.getNumber());
	}
	
	public void setName()
	{
		System.out.println("Insert new Name: ");
		Scanner in = new Scanner(System.in);
		name = in.nextLine();
		in.close();
	}
	
	public String getName()
	{
		return name;
	}
	public void setSurname()
	{
		System.out.println("Insert new Surname: ");
		Scanner in = new Scanner(System.in);
		surname = in.nextLine();
		in.close();
	}
	
	public String getSurname()
	{
		return surname;
	}
	public void setNumber()
	{
		System.out.println("Insert new Number: ");
		Scanner in = new Scanner(System.in);
		number = in.nextLine();
		in.close();
	}
	
	public String getNumber()
	{
		return number;
	}

}
