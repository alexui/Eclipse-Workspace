package ex1_elf;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ListOfPersons myList = new ListOfPersons();
		myList.addToList(new Persoana("Alex"));
		myList.addToList(new Persoana("Stefan"));
		myList.addToList(new Persoana("Gigel"));
		myList.addToList(new Persoana("Mircea"));
		myList.addToList(new Persoana("Vasile"));
		myList.addToList(new Student("George", 10));
		myList.addToList(new Student("Ion", 5));
		myList.addToList(new Student("Gigi", 6));
		myList.addToList(new Student("Cancel", 1));
		
		//myList.SortByName();

		//System.out.println(myList.getList().toString());
		
		myList.SortByMark();
		System.out.println(myList.getList().toString());

		
		ListOfStudents yourList = new ListOfStudents();
		
		yourList.addToList(new Student("Alex",8));
		yourList.addToList(new Student("Geo",10));
		yourList.addToList(new Student("Stefan",10));
		yourList.addToList(new Student("Vasile",10));
		yourList.addToList(new Student("Andrei",10));
		yourList.SortByMark();
		System.out.println(yourList.getList().toString());

	}

}
