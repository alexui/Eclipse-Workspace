import java.io.File;
import java.util.Scanner;

public class Monede {

	public int m,n;
	public int Map[][];
	public Pair[] pair;
	public Pair[] path;
	public int result[][];
	
	private class Pair{
		int i,j;
		public Pair(int i,int j){
			this.i=i;
			this.j=j;
		}
		
		public String toString(){
			
			String s="";
			return s +"["+i+","+j+"]";
		}
	}
	
	private void readData ( String filename ) {
		Scanner scanner = null;

		/* you should use try-catch for proper error handling! */
		try {

			scanner = new Scanner(new File(filename));
			
			n=scanner.nextInt();
			m= scanner.nextInt();
			Map = new int[n][m];
			pair= new Pair[Math.max(m, n)];
			path = new Pair[m+n];
			
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++){
					Map[i][j]=scanner.nextInt();
				}

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

	private void printMatrix(){
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++){
				System.out.printf("%3d",Map[i][j]);
			}
			System.out.println();
		}
	}
	
	private int bestPath(int matrix[][]){
		
		int n = matrix.length;
		int m = matrix[0].length;
		result = new int[n][m];
		for(int i =0;i<n;i++)
			for(int j=0;j<m;j++){
				if(i ==0 && j==0){
					if(matrix[i][j]!=-1)
						result[i][j]=matrix[i][j];  // in [0][0] nu putem ajunge decat luand in cosiderare valoraea sa
					else 
						result[i][j]=0;
				}
				else if(i==0){
					if(matrix[i][j]!=-1)
						result[i][j]=matrix[i][j]+result[i][j-1];	//initializam prima linie
				}
				else if(j==0){
					if(matrix[i][j]!=-1)
						result[i][j]=matrix[i][j]+result[i-1][j];	//initializam prima coloana
				}
				else if(matrix[i][j]!=-1){
					result[i][j]= matrix[i][j]+Math.max(result[i-1][j], result[i][j-1]);
				}
				//verificam daca in punctul result[i][j] suma maxima se obtine venind de sus sau din stanga		
			}
			return result[n-1][m-1];
	}
	
	private int buildPath(){
		
		int k=0;
		int i = n-1;
		int j = m-1;
		path[k++]=new Pair(i,j);
		while(i!=0 && j!=0){
			if(result[i-1][j]>result[i][j-1])
				i--;
			else 
				j--;
			path[k++]= new Pair(i,j);
		}
		return k;
	}
	
	public static void main(String[] args) {
		
		Monede m = new Monede();
		m.readData("matrix.txt");
		m.printMatrix();
		System.out.println(m.bestPath(m.Map));
		int k = m.buildPath();
		
		for(int i=k-1;i>=0;i--){
			System.out.print(" "+ m.path[i]);
		}
	}

}
