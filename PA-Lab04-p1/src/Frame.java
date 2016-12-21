import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Frame {

	public static final int MOD = 40009;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] v = new int[3];
		Frame frame = new Frame();
		v = frame.readData("matrix2.in");
		int n = countFrames(v[0], v[1], v[2]);
		
		BufferedWriter buf;
		try {
			buf = new BufferedWriter(new FileWriter(new File("date.out")));
			buf.write(n + " ");

			buf.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	
	private static int countFrames(int n, int m, int k) {
		
		int[][] matrix = new int[k+1][k+1];
		ArrayList<Integer> v = new ArrayList<Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for (int i = 0; i < k+1; i++) {
			matrix[0][i] = 1;
		}
		
		for (int i = 1; i < k+1; i++)
			for (int j = 0; j < k+1; j++) {
				if (i-1 == j)
					matrix[i][j] = 1;
				else matrix[i][j] = 0;
			}
		
		v.add(logPowNumber(2, k+1) - 1);
		
		for (int i=1; i < k+1; i++) {
			v.add(logPowNumber(2, k+1-i));
		}
		
		res = multiplyMatrixVector(logPowMatrix(matrix, n-k-1), v);
		
		return logPowNumber(res.get(0), m);
	}
	
	
	private static int logPowNumber(int n, int p) {
		
		int aux = 1;
		
		if (p == 1)
        	return n % MOD;
        else {
        	aux = logPowNumber(n, p/2);
        	if (p % 2 == 0)
        		return (aux * aux) % MOD;
        	else return (((aux * aux) % MOD) * (n % MOD)) % MOD;
        }
		
	}
	
	//Inmulteste matricele A si B. Operatiile sunt modulo MOD.
	private static int[][] multiplyMatrix(int[][] A, int[][] B) {
        final int N = A.length;
        final int M = B[0].length;
        final int K = A[0].length;

        int[][] Res = new int[N][M];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                for (int k = 0; k < K; ++k) {
                    Res[i][j] = (Res[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }

        return Res;
    }
	
	
	//Inmulteste matricea A cu vectorul v. Operatiile sunt modulo MOD
    private static ArrayList<Integer> multiplyMatrixVector(int[][] A, ArrayList<Integer> v) {
        final int N = A.length;
        final int M = v.size();
        
        ArrayList<Integer> vRes = new ArrayList<Integer>();
        
        for (int i = 0; i < N; ++i) {
        	int elem = 0;
            for (int j = 0; j < M; ++j) {
                elem = (elem + A[i][j] * v.get(j)) % MOD;
            }
            vRes.add(elem);
        }

        return vRes;
    }
	
    
  //Ridica la puterea p matricea patratica A. Operatiile sunt modulo MOD.
    private static int[][] logPowMatrix(int[][] A, int p) {
        int[][] Res = new int[A.length][A.length];

        for (int i = 0; i < Res.length; ++i) {
            Res[i][i] = 1;
        }
        if (p == 1)
        	return A;
        else {
        	Res = logPowMatrix(A, p/2);
        	if (p % 2 == 0) 
        		return multiplyMatrix(Res, Res);
        	else {
        		int[][] aux = multiplyMatrix(Res, Res);
        		return multiplyMatrix(aux, A);
        	}
        	
        }
        
    }
	
    
    private int[] readData(String filename)
	{

		Scanner scanner = null;
		int[] v = new int[3];

		/* you should use try-catch for proper error handling! */
		try {

			scanner = new Scanner(new File(filename));
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int k = scanner.nextInt();
			
			v[0] = n;
			v[1] = m;
			v[2] = k;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/* trebuie sa inchidem buffered reader-ul */
			try {
				if (scanner != null)
					scanner.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return v;
	}
	

}
