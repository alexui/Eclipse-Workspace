import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Problema2 {

	int N;
	int M;
	int K;
	int MOD=40009;
	int[][] I;

    
	
	public void readData(String filename){
		Scanner scanner = null;

		try {

			scanner = new Scanner(new File(filename));
			 N = scanner.nextInt();
			 M = scanner.nextInt();
			 K = scanner.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/* trebuie sa inchidem buffered reader-ul */
			try {
				if (scanner != null) scanner.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	 private int[][] logPowMatrix(int[][] A, int p) {
	       
		 	int[][] Mat_Res,Res;
	        //System.out.println(I.length-1);
	        if(p==0)
		       return I;
	        
	        if(p==1)
	        	return A;
	        
	        Mat_Res = logPowMatrix(A, p/2);
	        Res=multiplyMatrix(Mat_Res, Mat_Res);
	        if(p%2==0){
	        	return Res;
	        }
	        else
	        	return multiplyMatrix(A,Res);
	    }
	 
	 private int logPowInt(int n,int p){
		 if(p==0)
			 return 1;
		 if(p==1)
			 return n%MOD;
		 
		 int part_res =logPowInt(n, p/2) % MOD;
		 int res = (part_res*part_res) % MOD;
		 if(p%2==0)
			 return res%MOD ;
		 else
			 return (res * (n%MOD))%MOD; 

	 }
	 
	  private int[][] multiplyMatrix(int[][] A, int[][] B) {
	        final int N = A.length;
	        final int M = B[0].length;
	        final int K = A[0].length;

	        int[][] Res = new int[N][M];

	        for (int i = 0; i <N; ++i) {
	            for (int j = 0; j <M; ++j) {
	                for (int k = 0; k <K; ++k) {
	                    Res[i][j] = (Res[i][j] + (A[i][k] * B[k][j])) %MOD;
	                }
	            }
	        }

	        return Res;
	    }
	  
	  private int getResult(){

			Integer[] v = new Integer[K+1];
			int[][]A = new int[K+1][K+1];
			I = new int[K+1][K+1];
			for (int i = 0; i < I.length; i++) {
		            I[i][i] = 1;
		    }
			
			for(int i=0;i<K;i++)
				{
				v[i]=logPowInt(2, i+1);
				}
			
			v[K]=logPowInt(2,K+1)-1;
			
			
			if(N<=K+1)
				return logPowInt(v[N],M);
			else{
				
				for(int j=0;j<K;j++){
						A[0][j]=1;
						A[j+1][j]=1;
					}
				A[0][K]=1;
				
				
				A=logPowMatrix(A, N-K-1);
				
				
				int result=0;
				for(int j=0;j<K+1;j++){
					result=((result+A[0][j]*v[K-j])%MOD) ;
				}
							
				return logPowInt(result, M);
				}
	}
  
	
	public static void main(String[] args) {
	
		Problema2 p = new Problema2();
		p.readData("date.in");
		PrintWriter out = null;
		try {
			out = new PrintWriter("date.out");
			out.print(p.getResult());
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(out!=null)
				out.close();
		}
	}
}
