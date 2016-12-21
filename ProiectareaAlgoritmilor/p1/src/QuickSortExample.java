import java.util.Comparator;
import java.util.Vector;


public class QuickSortExample implements Comparator<Integer>{

	
	Vector<Integer> v ;
	
	public QuickSortExample(){
		v = new Vector<Integer>();
	}
	
	public void QuickSort(Vector<Integer> v,int left,int right){
		
		if(left>=right)
			return;
		
		int pivot = left;
		int lastSmall=left;
		
		for(int i=left+1;i<right;i++){
			if(compare(v.get(i),v.get(pivot))<0){
				swap(v,i,lastSmall+1);				
				lastSmall++;
			}	
		}
		swap(v,pivot,lastSmall);
		
		QuickSort(v,left,lastSmall);
		QuickSort(v,lastSmall+1,right);
	}
	
	private void swap(Vector<Integer> v,int i,int j)
	{
		int aux = v.get(i);
		v.set(i, v.get(j));
		v.set(j, aux);
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		
		if(o1<o2)
			return -1;
		else if(o1.equals(o2))
			 	return 0;
		else return 1;
	}
	
	public void print(Vector<Integer> v){
		
		for(Integer i:v)
			System.out.printf("%d ",i);
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		QuickSortExample qse = new QuickSortExample();
		Vector<Integer> v= new Vector<Integer>();
		v.add(8);
		v.add(5);
		v.add(1);
		v.add(9);
		
		System.out.println("Vector:");
		qse.print(v);
		
		System.out.println("Vector sortat:");
		qse.QuickSort(v, 0, v.size());
		qse.print(v);
		
	}
}
