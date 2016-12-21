package arrays;

import java.util.Random;

public class test2MyArrayList {

	public static void main(String[] args) {

		System.out.println("Inserare valori aleatoare:");
		MyArrayList v =new MyArrayList(5);
		Random r = new Random();
		int i,index;
		float val;
		for(i=0;i<10;i++)
			v.add((int)(10+r.nextFloat()*(20-10)));
		System.out.println(v.toString());
		
		System.out.println("Cautare valori aleatoare:");
		for(i=0;i<5;i++)
		{
			val=((int)(10+r.nextFloat()*(20-10)));
			System.out.printf("Valoarea "+val+"%s"+"a fost gasita.\n",v.contains(val)?" ":" nu ");
		}
		System.out.println(v.toString());

		
		System.out.println("\nEliminare valori aleatoare:");
		for(i=0;i<5;i++)
		{
			index=r.nextInt(v.size());
			System.out.println("Valoarea "+v.get(index)+" a fost eliminata.");
			v.remove(index);
		}
		System.out.println(v.toString());

	}

}
