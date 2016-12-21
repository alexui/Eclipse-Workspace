package Ex1;

import java.util.LinkedHashSet;

public class MyLinkedHashSet<K> extends LinkedHashSet<K>{

	private static final long serialVersionUID = 1L;
	
	@Override
	public boolean add(K element){
		
	/*	if(super.contains(element)==true)
			{
			System.out.println("--Error.Existing element--");
			return false;
			}
		else{
			super.add(element);
			return true;
		}*/
		if(super.add(element)==true){
			return true;
		}
		else
		{
			System.out.println("--Error.Existing element--");
			return false;
		}
	}

}
