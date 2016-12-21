import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class K_one_seq {

	int[] v;
	PrintWriter out = null;
	
	public K_one_seq(int dim){
		v = new int[dim];
		try {
			out = new PrintWriter("seq1.out");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean cont(int[] v,int k){
		int seq=0;
		for(int i=0;i<v.length;i++){
			if(v[i]==1)
				seq++;
			else seq=0;
			
			if(seq>k)
				return false;
		}
		return true;
	}
	
	public void show(int[] v,int n){
			for(int i=0;i<n;i++){
				out.printf("%d ", v[i]);
			}
			out.println();		
	}
	
	public void back(int n,int k,int level){
		
		for(int i=0;i<2;i++){
			v[level]=i;
			if(level!=n-1)
				back(n,k,level+1);
			else
				if(cont(v,k)){
					show(v,n);					
			}
		}
	}
	
	public static void main(String[] args) {
		int n=4;
		int k=2;
		K_one_seq one = new K_one_seq(n);
		one.back(n,k,0);
		one.out.close();
	}

}
