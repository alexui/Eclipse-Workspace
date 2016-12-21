import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class P1 {

	ArrayList<Integer> primes;

	//metoda primeste un numar de maxim 10^12 cifre,salveaza cifrele intr-o lista si apeleaza o metoda backtracking ce calculeaza 
	//		numarul pitiprim maxim
	public int getMaxPitiPrime(Long number){
		
		ArrayList<Integer> digits = new ArrayList<Integer>();
		
		while(number!=0){
			digits.add(new Integer((int) (number%10)));
			number/=10;
		}
		
		Integer res = new Integer(0);
		
		res = doBKT(res,digits);
		
		return res;
			
	}
		
	public static ArrayList<Integer> makeListCopy(ArrayList<Integer> cells) {

	        ArrayList<Integer> result = new ArrayList<Integer>();
	        for (Integer c : cells) {
	            result.add(new Integer(c.intValue()));
	        }
	        return result;
	}
	
	//verifica daca numarul n este pitiprim
	//stim ca lista de numere pitiprime este sortata inca de cand a fost incarcata, de aceea se poate aplica o cautare binara
	public boolean isPitiPrime(int n){
		
		if(Collections.binarySearch(primes, n)>=0)
			return true;
		return false;
	}
	
	//metoda primeste un numar intreg : rezultatul - initial 0, si o lista de cifre care se pot atasa la rezultat
	public Integer doBKT(Integer result, ArrayList<Integer> cells){
		
		//max se initializeaza cu rezultatul curent (initial 0)
		int max = result;
		
		//se creaza un vector de numere marcate astfel incat la un pas de baktracking sa nu se intre in recursivitate 
		// 	de mai multe ori pentru o cifra care a fost tratata la un alt pas
		//	el retine daca 0,1,...9 au fost tratate
		boolean[] marked = new boolean[11];
		for(int i=1;i<11;i++)
			marked[i]=false;

		//se parcurge lista de cifre
		for(Integer c:cells){
			int temp;
			//pentru fiecare cifra din lista , ataseaza cifra la rezultat (atasare la dreapta)
			temp = result*10+c;
			
			//daca numarul nou format e pitiprim iar el nu a fost tratat la  un alt pas anterior de backtracking
			//	se creaza o copie a cifrelor (domeniului), din care se va elimina cifra care s-a atasat
			//	rezultatul nou obtinut (temp) ,impreuna cu copia vor fi trimise ca parametri unui nou apel al metodei doBKT()
			//	valoarea de return a metodei va fi comparata cu maximul curent pentru a actualiza numarul pitiprim maxim
			
			//un pas de backracking se va opri atunci cand se termina de parcurs toata lista de cifre
			//daca nici o cifra din lista nu se poate adauga la dreapta atunci valoarea lui max (si implicit cea de return) va fi 
			//	valoarea rezultatului curent (cel primit ca parametru)
			if(isPitiPrime(temp) && !marked[c]){		
								
				ArrayList<Integer> cells_copy = makeListCopy(cells);
				cells_copy.remove(new Integer(c));
				marked[c]=true;
				
				int k = doBKT(temp,cells_copy);
				
				if(k>max)
					max=k;
			}
			
		}
		return max;
			
	}

	//incarca numerele pitiprime dintr-un fisier dat ca parametru
	//numerele pitiprime din fisier au fost generate cu un program separat creat de mine
	public void loadPitiPrimes(String filename){
		Scanner scanner = null;

		try {

			scanner = new Scanner(new File(filename));
			while(scanner.hasNext()){
				int i = scanner.nextInt();
				primes.add(i);
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
	
	public static void main(String[] args) {
		
		P1 p = new P1();
		p.primes = new ArrayList<Integer>();
		
		//numerele pitiprime de la 0 la 8*10^7 sunt salvate in fisierul prime.txt in ordine crescatoare
		
		//se citesc din fisierul 'primes.txt' numerele pitiprime si se salveaza intr-o lista
		p.loadPitiPrimes("prime.txt");
		
		
		Scanner scanner = null;
		PrintWriter pw=null;
		try {
			pw = new PrintWriter(new File ("pitiprim.out"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		//se citeste n
		//apoi se citesc n numere intre 0 si 10^12
		//se prelucreasa fiecare numar , apoi se afiseaza in fisierul de output
		try {

			scanner = new Scanner(new File("pitiprim2.in"));
			
				int n = scanner.nextInt();
				for(int i=0;i<n;i++){
					Long val = scanner.nextLong();
					//gaseste numarul maxim pitiprim care se poate forma cu cifrele din 'val' si il afiseaza in fisier
					//metoda : backtracking
					pw.print(p.getMaxPitiPrime(val));
					
					pw.println();
				}	
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/* trebuie sa inchidem buffered reader-ul */
			try {
				if (scanner != null) scanner.close();
				if (pw!=null) pw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		

	}

}
