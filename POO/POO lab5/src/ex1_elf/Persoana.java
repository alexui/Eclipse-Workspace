package ex1_elf;

import java.util.Comparator;

public class Persoana implements Comparator<Persoana>{

	private String nume=null;
	
	public Persoana()
	{
		
	}
	
	public Persoana(String nume)
	{
		this.nume=nume;
	}
	
	public String toString()
	{
		return this.nume;
	}
	

	public class CompareTo implements Comparator<Persoana>{
				

		@Override
		public int compare(Persoana o1, Persoana o2) {
				
			if(o1.nume.compareTo(o2.nume)>0)
				return 1;
			else
				if(o1.nume.compareTo(o2.nume)==0)
					return 0;
				else
					return -1;
		}
	}


	@Override
	public int compare(Persoana o1, Persoana o2) {
		
		if(o1.nume.compareTo(o2.nume)>0)
			return 1;
		else
			if(o1.nume.compareTo(o2.nume)==0)
				return 0;
			else
				return -1;
	}
}
