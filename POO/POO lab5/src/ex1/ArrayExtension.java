package ex1; 

public class ArrayExtension extends Array implements Iterator{

	int index = 0;
	@Override
	public boolean hasNext() {
		
		if(this.getNr_elem()==0 || index==getNr_elem())
			return false;
		return true;
	}

	@Override
	public int next() {
		
		if(this.hasNext()){
			
			this.index++;
			return this.get(index-1);
		}
		else 
			return 0;
	}

	
		
}
