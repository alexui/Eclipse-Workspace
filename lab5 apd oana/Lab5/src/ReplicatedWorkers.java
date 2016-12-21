/**
 * Clasa ce reprezinta o solutie partiala pentru problema de rezolvat. Aceste
 * solutii partiale constituie task-uri care sunt introduse in workpool.
 */
class PartialSolution {
	String[] work;
	
	public PartialSolution(String[] work){
		this.work = work;
	}
	
	public String toString() {
		String s = new String();
		for( int i = 0 ; i < work.length; i++){
			s = s + work[i] + " ";
		}
		return s;
	}
}

/**
 * Clasa ce reprezinta un thread worker.
 */
class Worker extends Thread {
	WorkPool wp;
	int counter = 0 ;
	
	public Worker(WorkPool workpool) {
		this.wp = workpool;
	}

	/**
	 * Procesarea unei solutii partiale. Aceasta poate implica generarea unor
	 * noi solutii partiale care se adauga in workpool folosind putWork().
	 * Daca s-a ajuns la o solutie finala, aceasta va fi afisata.
	 */
	void processPartialSolution(PartialSolution ps) {
		if(ps.work.length == 0){
			return;
		}
		if(ps.work.length == 1){
			if(ReplicatedWorkers.word.equals(ps.work[0]))
				counter ++;
			return;
		}
		int mid = ps.work.length / 2;
		System.out.println(mid);
		String[] first = new String[mid];
		String[] last = new String[ps.work.length - mid];
		
		for( int i = 0 ; i < mid; i++){
			first[i] = new String(ps.work[i]);
		}
		for( int i = mid; i < ps.work.length  ; i++){
			last[i - mid] = ps.work[i];
		}
	
		wp.putWork(new PartialSolution(first));
		wp.putWork(new PartialSolution(last));
		
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

	public static String word = "bla";
	
	public static void main(String args[]) {
		String[] text = {"ala", "bla", "portocala", "bla", "bla", "bla"};
		PartialSolution ps = new PartialSolution(text);
		int processors = Runtime.getRuntime().availableProcessors();
		WorkPool pool = new WorkPool(processors);
		pool.putWork(ps);
		Worker[] workers = new Worker[processors];
		for(int i = 0; i < processors ; i++){
			workers[i] = new Worker(pool);
			workers[i].start();
			
		}
		for(int i = 0; i < processors ; i++){
			try {
				workers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int count = 0;
		for(int i = 0; i < processors ; i++){
			count += workers[i].counter;
		}
		System.out.println(" final: " + count);
	}
	
}


