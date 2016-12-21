package ex4;

public class Test {

	/**
	 * @param args
	 */
	public static String arrayToString(int [] a)
	{
		String s="";
		for (int i=0;i<a.length;i++)
			s+=a[i]+" ";
		return s;
	}
	
	public static void main(String[] args) {

		boolean added,removed;
		// inserare si eliminare de elemente
		System.out.println("Adding and removing:");
		Array v = new Array();
		
		v.registerObserver(v.getObserver());
		
		ListEvent e = v.new add(2);
		
		added=v.getAllObservers().get(0).elementAdded(e);

		removed=v.getAllObservers().get(0).elementRemoved(e);
		System.out.println("Added: "+added+" Removed: "+removed );
		
		ListEvent f = v.new remove();
		
		v.registerObserver(v.getObserver());
		added=v.getAllObservers().get(1).elementAdded(f);
		removed=v.getAllObservers().get(1).elementRemoved(f);
		System.out.println("Added: "+added+" Removed: "+removed );
		
		ListEvent g = v.new add(12);
		System.out.println("Number of elements: "+v.getNr_elem());
		
		System.out.println("Operation 1: "+e.getElement()+" "+arrayToString(e.getList())+" "+e.getDuration());
		System.out.println("Operation 2: "+f.getElement()+" "+arrayToString(f.getList())+" "+f.getDuration());
		System.out.println("Operation 3: "+g.getElement()+" "+arrayToString(g.getList())+" "+g.getDuration());

		
		ListEvent h = v.new remove();
		System.out.println("Operation 4: "+h.getElement()+" "+arrayToString(h.getList())+" "+h.getDuration());

		
		System.out.println("Number of elements: "+v.getNr_elem());

		
	// test observator
		
		System.out.println("\nObserver test:");
		
		
		
		
	}

}
