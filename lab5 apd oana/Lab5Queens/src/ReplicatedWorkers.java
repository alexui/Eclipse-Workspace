import java.util.ArrayList;

/**
 * Clasa ce reprezinta o solutie partiala pentru problema de rezolvat. Aceste
 * solutii partiale constituie task-uri care sunt introduse in workpool.
 */
class PartialSolution {
	int[] asezare;
	int index = 0;
	
	public PartialSolution(int[] asezare, int index){
		this.asezare = asezare;
		this.index = index;
	}
	
	public String toString() {
		String s = new String();
		for( int i = 0 ; i < asezare.length; i++){
			s = s + asezare[i] + " ";
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
	ArrayList<int[]> solutions = new ArrayList<>();
	
	public Worker(WorkPool workpool) {
		this.wp = workpool;
	}

	/**
	 * Procesarea unei solutii partiale. Aceasta poate implica generarea unor
	 * noi solutii partiale care se adauga in workpool folosind putWork().
	 * Daca s-a ajuns la o solutie finala, aceasta va fi afisata.
	 */
	void processPartialSolution(PartialSolution ps) {
		if(ps.index == ReplicatedWorkers.length){
			boolean valid = true;
			for( int i = 0 ; i < ReplicatedWorkers.length - 1; i ++){
				for( int j = i + 1 ; j < ReplicatedWorkers.length; j ++)
					if(ps.asezare[i] == ps.asezare[j] || 
							Math.abs(ps.asezare[i] - ps.asezare[j]) == 
								Math.abs(j - i))
						valid = false;
			}
			if(valid) solutions.add(ps.asezare);
			return;
		}
		for( int i = 0 ; i < ReplicatedWorkers.length ; i++){
			int[] asezare = ps.asezare.clone();
			asezare[ps.index] = i;
			wp.putWork(new PartialSolution(asezare,  ps.index + 1));
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

	public static String word = "bla";
	public static int length = 4;
	
	public static void main(String args[]) {
		int[] asezare = new int[4];
		PartialSolution ps = new PartialSolution(asezare, 0);
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
		for(int i = 0; i < processors ; i++){
			for( int j = 0 ; j < workers[i].solutions.size(); j++){
				System.out.println("\nSolutie: ");
				for( int k = 0 ; k < length ; k++)
					System.out.print( " " + workers[i].solutions.get(j)[k]);
			}
		}
	}
	
}


