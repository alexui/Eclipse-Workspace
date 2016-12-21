package Ex3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Calculator {


	public int add(int a,int b) throws OverflowException, UnderflowException
	{
		long c=(long)a+(long)b;
		if(c>Integer.MAX_VALUE)
			throw new OverflowException();
		if(c<Integer.MIN_VALUE)
			throw new UnderflowException();
		return a+b;
	}
	
	public int divide(int a,int b)
	{
		if(b==0)
			throw new ArithmeticException();
		return a/b;
	}
	
	public int average(Collection<Integer> a) throws OverflowException, UnderflowException
	{
		Iterator<Integer> i=a.iterator();
		int sum=0;
		int size=a.size();
		while(i.hasNext()==true)
			try {
				sum=this.add(sum, i.next());
			} catch (OverflowException e) {
				throw e;
			}catch (UnderflowException e){
				throw e;
			}
			
		return divide(sum,size);
	}
	
	public static void main(String[] args) {
		
		Calculator c = new Calculator();
		
		try {
			System.out.println("Result: "+c.add(5, 7));
		} catch (OverflowException e) {
			e.getExceptionDetails();
		} catch (UnderflowException e) {
			e.getExceptionDetails();
		}
		
		
		try {
			System.out.println("Result: "+c.add(Integer.MAX_VALUE, 1));
		} catch (OverflowException e) {
			e.getExceptionDetails();
		} catch (UnderflowException e) {
			e.getExceptionDetails();
		}
		
		try {
			System.out.println("Result: "+c.add(Integer.MIN_VALUE, -1));
		} catch (OverflowException e) {
			e.getExceptionDetails();
		} catch (UnderflowException e) {
			e.getExceptionDetails();
		}
		
		try{
			System.out.println("Result: "+c.divide(5, 2));
		}
		catch(ArithmeticException e)
		{
			e.getMessage();
		}
		
		try{
			System.out.println("Result: "+c.divide(5, 0));
		}
		catch(ArithmeticException e)
		{
			System.out.println("--Eroare la impartire.--");
			e.getMessage();
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(4);
		list.add(Integer.MAX_VALUE);
		try {
			System.out.println("Result: "+c.average(list));
		} catch (OverflowException e) {
			e.getExceptionDetails();
		} catch (UnderflowException e) {
			e.getExceptionDetails();
		}
		
	}

}
