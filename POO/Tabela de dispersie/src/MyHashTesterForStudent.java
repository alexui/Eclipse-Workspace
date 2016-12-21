import java.io.PrintWriter;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyHashTesterForStudent {

	
	private ArrayList<Student> myInstances;
	private ArrayList<Student> whatToGet;
	private MyHashMapImpl<Student, Integer> hashmap;

	/**
	 * Constructor pentru {@link MyHashTesterForStudent}
	 */
	public MyHashTesterForStudent() {

	}

	/**
	 * Getter pentru tabela de dispersie.
	 * @return tabela de dispersie de tip {@link MyHashMapImpl} sau null.
	 */
	public MyHashMapImpl<Student, Integer> getHashMap() { //este o implementare gresita. cheia ar trebui sa fie un camp 
														//al clasei Student si nu intregul obiect
		return this.hashmap;
	}

	/**
	 * Getter pentru lista de tip Student.
	 * Lista contine elementele ce vor fi stocate in tabela de dispersie.
	 * @return lista de tip {@link Student}
	 */
	public ArrayList<Student> getMyInstances() {
		return myInstances;
	}

	/**
	 * Getter pentru lista de tip {@link Student}.
	 * Lista contine elementele ce vor fi extrase din tabela de dispersie.
	 * @return lista de tip {@link Student}
	 */
	public ArrayList<Student> getWhatToGet() {
		return whatToGet;
	}

	/**
	 * Metoda introduce elemente de tip {@link Student} generate aleator in lista myInstances.
	 * @param max_val
	 */
	private void putRandomInstances(int max_val) {
		myInstances = new ArrayList<Student>();
		for (int i = 0; i < max_val; i++) {
			myInstances.add(new Student(getRandomString(),
					(int) (Math.random() * 10) + 17));
		}
	}

	/**
	 * Metoda extrage elemente de tip {@link Student} generate aleator in lista myInstances si le introduce in lista whatToGet.
	 * @param max_val
	 */
	private void getRandomInstances(int max_val) {

		int index;
		whatToGet = new ArrayList<Student>();
		for (int i = 0; i < max_val; i++) {
			index = (int) (Math.random() * myInstances.size());
			whatToGet.add(myInstances.get(index));
		}
	}

	/**
	 * Metoda creaza un tabel de dispersie pe baza listei de obiecte {@link Student} myInstance.
	 */
	private void createHashMap() {
		if (myInstances == null)
			return;

		for (int i = 0; i < myInstances.size(); i++) {
			this.hashmap.put(myInstances.get(i), myInstances.get(i).getVarsta());
		}
	}

	/**
	 * Metoda afiseaza tabela de dispersie in fisierul specificat.
	 * @param filepath sursa fisier
	 */
	private void printHashMap(String filepath) {

		if (hashmap.getBuckets() == null)
			return;
		PrintWriter out = null;
		try {
			out = new PrintWriter(filepath);
			int i = 0;

			for (i = 0; i < hashmap.getBuckets().size(); i++) {
				out.write(String.valueOf(i));
				out.println();
				System.out.println(String.valueOf(i));
				if (hashmap.getBuckets().get(i) != null) {

					out.format("%25s  %10s  %10s %30s %50s\n\n", "Nume",
							"Varsta", "Value", "Hascode", "Hashcode translatat");
				/*	System.out
							.format("%25s  %10s  %10s %30s %50s\n\n", "Nume",
									"Varsta", "Value", "Hascode",
									"Hashcode translatat");*/

					for (int j = 0; j < hashmap.getBuckets().get(i)
							.getEntries().size(); j++)

					{
						// %25s face conversia automata la string
						out.format(
								"%25s  %10s  %10s %30s %50s\n",
								(hashmap.getBuckets().get(i).getEntries()
										.get(j).getKey().getNume()),
								(hashmap.getBuckets().get(i).getEntries()
										.get(j).getKey().getVarsta()),
								(hashmap.getBuckets().get(i).getEntries()
										.get(j).getValue()),
								(hashmap.getBuckets().get(i).getEntries()
										.get(j).getKey().hashCode()),
								(translate(hashmap.getBuckets().get(i)
										.getEntries().get(j).getKey()
										.hashCode(), hashmap.getBuckets()
										.size())));

					/*	System.out.format(
								"%25s  %10s  %10s %30s %50s\n",
								(hashmap.getBuckets().get(i).getEntries()
										.get(j).getKey().getNume()),
								(hashmap.getBuckets().get(i).getEntries()
										.get(j).getKey().getVarsta()),
								(hashmap.getBuckets().get(i).getEntries()
										.get(j).getValue()),
								(hashmap.getBuckets().get(i).getEntries()
										.get(j).getKey().hashCode()),
								(translate(hashmap.getBuckets().get(i)
										.getEntries().get(j).getKey()
										.hashCode(), hashmap.getBuckets()
										.size())));*/
					} // end for
				}// end if
			}// end for
		}// end try
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * 
	 * @return un {@link String} generat aleator. 
	 */
	private String getRandomString() {
		Random r = new Random();
		StringBuffer buf = new StringBuffer();
		String s = new String();

		buf.delete(0, buf.length());
		int length = r.nextInt(5) + 5; // avoid 0 length strings

		for (int i = 0; i < length; i++) {
			char c = (char) (r.nextInt(26) + 97);
			buf.append(c);
		}

		s = buf.toString();

		return s;
	}

	/**
	 * 
	 * @param hashcode
	 * @param num_buckets
	 * @return HashCode translatat conform numarului maxim de elemente din bucket.
	 */
	private int translate(int hashcode, int num_buckets) {
		return Math.abs(hashcode) % num_buckets;
	}

	/**
	 * Metoda testeaza dispersia corecta si calculeaza timpul in care se fac number_of_seeks cautari. 
	 *
	 * @param hm - o instanta a clasei {@link MyHashMapImpl} parametrizata cu elemente de tip {@link Student} is {@link Integer}.
	 * @param number_of_instances - numarul de instante de tip {@link Student} ce vor fi generate aleator si stocate in lista myInstances.
	 * @param filepath - fisierul in care se va afisa tabela de dispersie creata.
	 * @param number_of_seeks - numarul de cautari facute in tabela de dispersie.
	 */
	public void run(MyHashMapImpl<Student, Integer> hm,
			int number_of_instances, String filepath, int number_of_seeks) {

		this.hashmap = hm;
		if (myInstances == null) {
			putRandomInstances(number_of_instances); //se creaza nuber_of_instances instante ce vor fi salvate in lista myInstances
		}
		createHashMap(); //se creaza tabel de disperise ce baza obiectelor din lista myInstances
		printHashMap(filepath); // afisarea tabelei intr-un fisier

		getRandomInstances(number_of_seeks); // se extrag nuber_of_seeks instante din lista myInstances ce vor fi salvate in lista whatToGet

		System.out.println("/nWhat to get:"); // se afiseaza obiectele ce vor fi extrase

		int i;
	/*	for (i = 0; i < whatToGet.size(); i++) // extragerea elementelor mentionate in lista whatToGet din tabela de dispersie si afisarea lor pe ecran. 
			System.out.format(
					"%25s %10s %30s %50s\n\n",
					whatToGet.get(i).getNume(),
					whatToGet.get(i).getVarsta(),
					whatToGet.get(i).hashCode(),
					translate(whatToGet.get(i).hashCode(), hashmap.getBuckets()
							.size()));*/

		long d = new Date().getTime();

		for (i = 0; i < whatToGet.size(); i++) {
			System.out.print("\nSearching for '" + whatToGet.get(i).getNume()
					+ "' : ");  						//cautare (cheia este obiectul de tip student)
			System.out.println("Value: " + getValue(whatToGet.get(i))); //afisarea valorii gasite asociate numelui
		}
		System.out.println("Time elapsed: " + (new Date().getTime() - d)
				+ " miliseconds"); // masurarea timpului scurs pe parcursul cautarii valorii unui obiect pe baza unei chei

	}

	/**
	 * 
	 * @param key
	 * @return vloarea sociata cheii
	 */
	private Integer getValue(Student key) {

		List<? extends MyHashMap.Bucket<Student, Integer>> buckets = hashmap
				.getBuckets();
		int hashcode = translate(key.hashCode(), buckets.size()); // se obtine
																	// codul
																	// translatat
		List<? extends MyHashMap.Entry<Student, Integer>> entries = hashmap
				.getBuckets().get(hashcode).getEntries();
		for (MyHashMap.Entry<Student, Integer> entry : entries) {
			if (entry.getKey().equals(key))
				return entry.getValue();
		}
		return null;
	}

}
