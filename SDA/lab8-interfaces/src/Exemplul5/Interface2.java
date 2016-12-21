package Exemplul5;

public class Interface2 implements check{

	/**
	 * @param args
	 */
	int [] array = {45,20,41,3,8,9};
	public static void main(String[] args) {

		check alpha = new Interface2();
		alpha.message();
	}

	public void message() {
		System.out.println("Iata un algoritm de sortare - Bubblesort: ");
		int counter,index,temp;
		for(counter=0;counter<array.length;counter++)
		{
			for(index=0;index<array.length-1-counter;index++)
			if(array[index]<array[index+1])
			{
				temp = array[index];
				array[index]= array[index+1];
				array[index+1]=temp;
			}
			System.out.print(array[index]+" ");
		}
	}

}
