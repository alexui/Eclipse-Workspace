package Ex4;

import java.util.ArrayList;

import Ex3.Calculator;
import Ex3.OverflowException;
import Ex3.UnderflowException;

public class FinallyExample {

	static final int Error = Integer.MAX_VALUE;
	
	public static int result(ArrayList<Integer> l)
	{
		Calculator c = new Calculator();
		try {
			System.out.println("Trying to get the average value.");
			return c.average(l);
		} catch (OverflowException e) {
			e.getExceptionDetails();
		} catch (UnderflowException e) {
			e.getExceptionDetails();
		}
		
		finally{
			System.out.println("The list has the following elements:");
			System.out.println(l.toString());
		}
		
		return Error;
	}
	
	public static void main(String[] args) {
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(20);
		list.add(1);
		list.add(1);
		//list.add(Integer.MAX_VALUE);
		
		System.out.println("Result: "+((result(list)!=Error)?result(list):"Error"));
		
	}

}
