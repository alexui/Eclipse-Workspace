import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Problema1 {

	Pair[] pairs;
	int salary=0;
	
	SortedList<Integer> Masters;	//aici se vor retine indicii perechilor din care au fost selectati stapanii
	SortedList<Integer> Slaves;		//aici se vor retine indicii perechilor din care au fost selectati sclavii
	PriorityQueue<Pair> q;
	
	private class Pair{
		
		int no;
		int Master;
		int Slave;
		int dif;
		
		
		public Pair(int no,int master,int slave){
			this.no=no;
			this.Master=master;
			this.Slave=slave;
			this.dif=master-slave;
		}
	}
	
	//metoda pentru citirea datelor din fisier
	private void readData ( String filename ) {
		Scanner scanner = null;

		try {

			scanner = new Scanner(new File(filename));
			
				int n = scanner.nextInt();
				pairs = new Pair[n+1];
				for (int i=1;i<=n;i++) {
					pairs[i] = new Pair(i,scanner.nextInt(), scanner.nextInt());
				}
				//pozitia 0 nu se completeaza
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

	private int minSalary(Pair[] pairs){
		
		int salary=0;
		
		//listele de indici vor avea elementele sortate crescator
		Masters = new SortedList<Integer>();
		Slaves = new SortedList<Integer>();
		q=new PriorityQueue<Pair>(pairs.length/2, new Comparator<Pair>() {


			@Override
			public int compare(Pair a, Pair b) {
				if(a.dif>b.dif)
					return -1;
				else if (a.dif<b.dif)
					return 1;
				else return 0;
			}
		});
		
		//se parcurge vectorul de perechi astfel:
		//se selecteaza perechile doua cate doua si pentru respectarea ordinii (indice sclav<indice stapan)
		//se impune ca din prima pereche sa fie selectat sclavul si din a doua stapanul
		
		Slaves.add(1);
		salary+=pairs[1].Slave;
		Masters.add(2);
		salary+=pairs[2].Master;
		
		q.add(pairs[2]);
		
		for(int i=3;i<pairs.length;i+=2){
			
		
			//verificam daca din perechea i va fi ales sclavul sau stapanul
			//comparand diferenta maxima dintre stapan si sclav in randul perechilor de unde au fost alesi
			//stapanii anteriori cu diferenta dintre stapan si sclav din perechea curenta i
			
			Pair p = pairs[i];
						
			//cautam o diferenta mai mare in randul perechilor de unde au fost alesi stapanii
				
			if(p.dif<q.peek().dif)
			
			//dupa ce gasim diferenta maxima in randul perechilor de unde au fost alesi stapanii
			//stapanul de pe pozitia unde s-a gasit diferenta maxima devine sclav
			//si elementul curent devine stapan
			{  
				Masters.add(i);
				salary+=pairs[i].Master;
				Masters.remove(new Integer(q.peek().no));
				salary-=q.peek().Master;
				Slaves.add(q.peek().no);
				salary+=q.peek().Slave;
				q.poll();
				q.add(p);
			}
			//daca nu elementul curent devine sclav
			else
				{
				Slaves.add(i);
				salary+=pairs[i].Slave;
				}
	
			//cum sunt citite cate doua elemente al doilea se considera mereu ca este stapan
			Masters.add(i+1);
			salary+=pairs[i+1].Master;
			q.add(pairs[i+1]);
		}
		
		return salary;
	}
	
	public static void main(String[] args) {

		PrintWriter out = null;

		Problema1 s = new Problema1();
		s.readData("date.in");
		s.salary=s.minSalary(s.pairs);

		//elementele din listele ce contin indicii au un numar egal de elemente

		try {
			out = new PrintWriter("date.out");
			out.print(s.salary);
			out.println();
			for(int i=0;i<s.Masters.size();i++)
			{
				out.printf("%d %d\n", s.Masters.get(i),s.Slaves.get(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(out!=null)
				out.close();
		}
	}

}
