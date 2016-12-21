import java.util.ArrayList;

/**
 * Clasa ce reprezinta o solutie partiala pentru problema de rezolvat. Aceste
 * solutii partiale constituie task-uri care sunt introduse in workpool.
 */
class PartialSolution {
	// ...
		
	public ArrayList<String> wordsList;
	public String cuv;
	
	public PartialSolution(ArrayList<String> list ,String cuvant){
		wordsList = list;
		cuv = cuvant;
	}
	
	public String toString() {
		return ("nr elemente :"+wordsList.size());
	}
}

/**
 * Clasa ce reprezinta un thread worker.
 */
class Worker extends Thread {
	WorkPool wp;
	int counter=0;
	public Worker(WorkPool workpool) {
		this.wp = workpool;
	}

	/**
	 * Procesarea unei solutii partiale. Aceasta poate implica generarea unor
	 * noi solutii partiale care se adauga in workpool folosind putWork().
	 * Daca s-a ajuns la o solutie finala, aceasta va fi afisata.
	 */
	void processPartialSolution(PartialSolution ps) {
			if(ps.wordsList.size()==0)
				return;
			else
			if(ps.wordsList.size()==1){
				if(ps.wordsList.get(0).compareTo(ps.cuv)==0)
					counter++;
			}
			else{
				int mid;
				mid = ps.wordsList.size()/2;
							
				ArrayList<String> first = new ArrayList<String>();
				ArrayList<String> sec = new ArrayList<String>();
				
				for(int i=0;i<mid;i++)
					first.add(ps.wordsList.get(i));
				for(int i=mid;i<ps.wordsList.size();i++)
					sec.add(ps.wordsList.get(i));
				
				wp.putWork(new PartialSolution(first,ps.cuv));
				wp.putWork(new PartialSolution(sec,ps.cuv));
				
			}
				
	}
	
	public void run() {
		System.out.println("Thread-ul worker " + this.getName() + " a pornit...");
		while (true) {
			PartialSolution ps = wp.getWork();
			if (ps == null)
				break;
			
			processPartialSolution(ps);
		}
		System.out.println("Thread-ul worker " + this.getName() + " s-a terminat...");
	}

	
}


public class ReplicatedWorkers {

	public static void main(String args[]) throws InterruptedException {
		
		int cores = Runtime.getRuntime().availableProcessors();
		
		String cuv="ala ";
		ArrayList<String> list = new ArrayList<String>();
		
		PartialSolution ps = new PartialSolution(list,cuv);
				
		
		ps.wordsList.add("ala ");
		ps.wordsList.add("bala ");
		ps.wordsList.add("portocala ");
		ps.wordsList.add("ala ");
		ps.wordsList.add("bala ");
		ps.wordsList.add("portocala ");
		ps.wordsList.add("ala ");
		ps.wordsList.add("bala ");
		ps.wordsList.add("portocala ");
		ps.wordsList.add("ala ");
		ps.wordsList.add("bala ");
		ps.wordsList.add("portocala ");
		ps.wordsList.add("ala ");
		ps.wordsList.add("bala ");
		ps.wordsList.add("portocala ");
		ps.cuv=cuv;
		
		WorkPool wp = new WorkPool(cores);
		wp.putWork(ps);
		
		ArrayList<Worker> workers = new ArrayList<Worker>();
		
		for(int i=0;i<cores;i++){
			workers.add(new Worker(wp));
		}
		
		for(int i=0;i<workers.size();i++){
			workers.get(i).start();
		}
		
		for(int i=0;i<workers.size();i++){
			workers.get(i).join();
		}
		
		int total=0;
		for(int i=0;i<workers.size();i++){
			total+=workers.get(i).counter;
		}
		
		System.out.println("counts: "+total);
	}
	
}


