package Ex2;

public class NewClass {

	private boolean FullMemory;
	private boolean StackOverflow;
	private String s = "dead";
	
	public NewClass(boolean mem,boolean stackof)
	{
		this.FullMemory=mem;
		this.StackOverflow=stackof;
	}
	
	private void endless()
	{
		int a=1;
		endless();
		a= a+1;
		a=a-1;
	}
	
	public void met1() // incearca sa modifice varaibila s
	{
		System.out.println("Hi, i'm method1.");
		if(this.FullMemory==true)
			{
			long[] values =new long[Integer.MAX_VALUE];
			System.out.println("Array of long values created. Size: "+values.length);
			}

		System.out.println("Hi, me again. We are not out of memory.");
		
		if(this.StackOverflow==true)
			{
			this.endless();
			}
		
		System.out.println("Hi, me again. We are not out of memory, and the stack is still working.\n");
		this.s="alive";
	}
	
	public String getS()
	{
		return this.s;
	}
	
	public static void main(String[] args) {

		MyClass o1 = new MyClass(false, false);
		try{
			o1.met1();
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("\n--Fatal error--\n");
		}   // programul functioneaza fara blocul try catch doar ca se incheie executia.
		catch(StackOverflowError e)
		{
			System.out.println("\n--Fatal error--\n");
		} 
		finally{
			System.out.println("Variable : "+o1.getS()+"\n");
		}
		
		
		
		MyClass o2 = new MyClass(true, false);
		try{
			o2.met1();
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("\n--Fatal error--\n");
			//throw e; // daca se arunca din nou 'e' se executa finally dar exceptia aruncata nu mai este prinsa
		}   // programul functioneaza fara blocul try catch doar ca se incheie executia.
		
		catch(StackOverflowError e)
		{
			System.out.println("\n--Fatal error--\n");
		} 
		finally{
			System.out.println("Variable : "+o2.getS()+"\n");
		}
		
		
		MyClass o3 = new MyClass(false, true);
		try{
			o3.met1();
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("\n--Fatal error--\n");
		} 
		catch(StackOverflowError e)
		{
			System.out.println("\n--Fatal error--\n");
		} 
		finally
		{
			System.out.println("Variable : "+o3.getS()+"\n");
		}
		
		
		System.out.println("The laboratory can go on.");
	}

}