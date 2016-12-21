package Ex5;

import java.util.ArrayList;

public class Colection5 {

	public static void main(String[] args) {
		
		MyHashSet<Integer> set = new MyHashSet<Integer>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		MyLinkedList<Integer> set2 = new MyLinkedList<Integer>();

		
		System.out.println("\nAdaugare in set:");
		System.out.println("Set:");
		set.add(5);
		set.add(6);
		System.out.println(set.toString());
		System.out.println(set.getN());
		
		array.add(8); 
		array.add(2);
		
		set.addAll(array);
		System.out.println(set.toString());
		
		System.out.println(set.getN());
		
		System.out.println("\nAdaugare in list:");
		System.out.println("List:");
		
		set2.add(5);
		set2.add(6);
		System.out.println(set2.toString());
		System.out.println(set2.getN());
		
		array.add(3); 
		array.add(2);
		
		set2.addAll(array);
		System.out.println(set2.toString());
		
		System.out.println(set2.getN());
		
	//Obs: intr-un set elementele trebuie sa fie distincte, de asemenea ele sunt asezate in ordine crescatoare
	//Obs: intr-o lista putem avea elemente identice 
	//OBS: SET.ADDALL FOLOSESTE METODA SET.ADD 
	//OBS: LINKEDLIST.ADDALL NU FOLOSESTE METODA LIST.ADD
	}

}
