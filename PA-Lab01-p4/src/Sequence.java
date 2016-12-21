
public class Sequence {
	
	int left,right,sum;
	
	public Sequence(int l,int r){
		left = l;
		right =r;
	}
	
	public String getSequence(int[] v){
		String s = "";
		for(int i =left;i<=right;i++)
			s+=v[i]+" ";
		return s;
	}
	
	public int getSum(int v[]){
		int s=0;
		for(int i=left;i<=right;i++)
			s+=v[i];
		return s;
	}
}