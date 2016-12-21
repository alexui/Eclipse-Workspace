
public class Vector { //arrays are passed by refference

	int [] a;
	
	public Vector(){
		this.a = new int [10];
	}
	
	public void setVector(int[] a){
		this.a=a;//a.clone rezolva situatia
	}
	
	public int[] getVector(){
		return this.a;
	}
	
	@Override
	public String toString(){
		String s="";
		for(int e : a){
			s=s+e+",";
		}
		return s;
	}
}
