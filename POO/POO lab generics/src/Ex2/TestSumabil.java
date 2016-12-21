package Ex2;

import java.util.ArrayList;
import java.util.List;

public class TestSumabil {

	public static <K extends Sumabil> Sumabil  sum(List<K> l){
		
		if(l.size()==0) return null;
		Sumabil result=l.get(0);
		for(int i=1;i<l.size();i++){
			result.addValue(l.get(i));
		}
		return result;
	}
	
	public static void main(String[] args) {

		
		System.out.println("--Test MyVector3--");
		ArrayList<MyVector3> list = new ArrayList <MyVector3>();
		list.add(new MyVector3(1,2,3));
		list.add(new MyVector3(0,2,1));
		list.add(new MyVector3(3,6,0));

		System.out.println(list.toString());
		
		Sumabil rez = sum(list);
		System.out.println(((MyVector3) rez));
		System.out.println("--End test--");
		
	}

}
