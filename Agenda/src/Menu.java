import java.util.*;
public class Menu {
	
	public void printMenu()
	{
		System.out.println("1.Afiseaza agenda");
		System.out.println("2.Schimba proprietar");
		System.out.println("3.Adaugare contact");
		System.out.println("4.Stergere contact");
		System.out.println("5.Cautare contact dupa nume");
	}

	public static void main(String[] args) {
		
		//Menu menu = new Menu();
		Agenda myagenda = new Agenda();
		System.out.println("Owner: "+myagenda.getOwner());
		//menu.printMenu();
		double option;
		System.out.println("Introduceti optiune:");
		Scanner in = new Scanner(System.in);
		option = in.nextDouble();
		switch((int)(option))
		{
		case 1:myagenda.print();
		case 2:myagenda.setOwner();
		case 3:myagenda.addContact();
		case 4:myagenda.deleteContact(1);
		case 5:myagenda.searchName();
		default: //menu.printMenu();
		}
		in.close();
	}

}
