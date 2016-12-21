import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Clasa pentru o tabela de dispersie asociativa ce implementeaza interfata {@link MyHashMap}.
 * 
 * @author Alex Budau
 *
 * @param <K> tipul cheilor
 * @param <V> tipul valorilor
 */

public class MyHashMapImpl<K,V> implements MyHashMap<K, V>{

	private ArrayList<myBucket> bucket_list;
	
	public MyHashMapImpl(int NUM_BUCKETS){
		this.bucket_list = new ArrayList<myBucket>();
		for(int i=0;i<NUM_BUCKETS;i++)
			bucket_list.add(i, null);
	}
	
	/**
	 * Bucket al tabelei de dispersie implementeaza interfata {@link MyHashMap.Bucket}.
	 * @author Alex Budau
	 * @param <K> tipul cheilor
	 * @param <V> tipul valorilor
	 */
	
	public class myBucket implements MyHashMap.Bucket<K, V>
	{
		public final int KEY_NOT_FOUND =-1;
		
		ArrayList<myEntry> entries; // este necesar ca ArrayList-ul de obiecte entry sa fie continut in bucket deoarece prin i
									//intermediul bucket-ului avem acces la intrari sau putem introduce intrari
		// se observa ca metoda getEntries intoarce un o lista parametrizata cu elemente de tip <myEntry> deci lista va primi
		// obiecte de tip <myEntry> si nu de tip <?extends Entry> adica null
		
		/**
		 * Constructor pentru bucket.
		 */
		public myBucket(){
			entries = new ArrayList<myEntry>();
		}
		
		/**
		 * Adauga o intrare in bucket.
		 * @param entry
		 */
		public void addEntry(myEntry entry){
			entries.add(entry);
		}
		
		/**
		 * Cauta intrare cu cheie specificata.
		 * @param key
		 * @return Pozitia in lista de intrari pe care s-a gasit intrarea cu cheia cautata.
		 */
		public int containskey(K key)
		{
			int i=0;
			for(i=0;i<entries.size();i++)
				if(entries.get(i).getKey().equals(key))
					return i;
			return KEY_NOT_FOUND;
		}
		
		/**
		 * Intoarce lista de intrari continute de acest bucket.
		 * 
		 * @return
		 */
		@Override
		/**
		 * Getter pentru lista de intrari a unui bucket.
		 * @return Lista de tip {@link MyHashMap.Entry}
		 */
		public List<? extends MyHashMap.Entry<K, V>> getEntries() {
			return this.entries;
		}
		
	}
	
	/**
	 * Intrare in tabela de dispersie (asociere cheie-valoare) implementeaza interfata {@link MyHashMap.Entry}.
	 * 
	 * @author Alex Budau
	 *
	 * @param <K>
	 * @param <V>
	 */
	public class myEntry implements MyHashMap.Entry<K, V>{

		private K key;
		private V value;
		
		public myEntry(K key, V value){
			this.key = key;
			this.value= value;
		}
		
		/**
		 * Intoarce cheia intrarii.
		 * 
		 * @return
		 */
		@Override
		public K getKey() {
			return key;
		}

		/**
		 * Intoarce valoarea intrarii.
		 * 
		 * @return
		 */
		@Override
		public V getValue() {
			return value;
		}

		/**
		 * Setter pentru valoare.
		 * 
		 * @param value
		 */
		public void setValue(V value) {
			this.value = value;
		}
		
	}
	
	/**
	 * Obtine valoarea asociata cheii key.
	 * 
	 * @param key cheia cautata
	 * @return valoarea SAU null daca cheia nu exista
	 */
	@Override
	public V get(K key) {
		
		int hashcode =this.getHashcode(key);
		
		if(bucket_list.get(hashcode)==null) //daca nu exista nici un bucket pe pozitia hashcode
			return null;
		
		else{
			myBucket bucket = bucket_list.get(hashcode); // daca exista bucket pentru hascode se preia referinta
			if(bucket.containskey(key)==bucket.KEY_NOT_FOUND)  // daca cheia cautata nu se afla in bucket
				return null;
			else
			{
				int index=bucket.containskey(key); // se cauta pozitia in lista la care se afla cheia
				myEntry entry = (myEntry) bucket.getEntries().get(index); //se obtine intrarea care contine cheia
				V val = entry.getValue(); // se obtine valoarea asociata cheii
				return val;
			}
		}
	}
	
	/**
	 * Adauga o asociere cheie-valoare.
	 * 
	 * @param key
	 * @param value
	 * @return valoarea anterioara asociata cheii key SAU null daca cheia nu exista.
	 */
	@Override
	public V put(K key, V value) {

		int hashcode =this.getHashcode(key);
		
		if(bucket_list.get(hashcode)==null) // daca nu exista bucket pentru hascode-ul specificat se creaza un nou bucket
		{
			myBucket bucket = new myBucket();
			bucket.addEntry(new myEntry(key,value)); //se adauga o noua intrare in bucket
			bucket_list.set(hashcode, bucket); // bucketul nou creat se afla pe pozitia 'hashcode' in lista
			return null;
		}
		
		else
		{
			myBucket bucket = bucket_list.get(hashcode); // daca exista bucket pentru hascode se preia referinta
			if(bucket.containskey(key)==bucket.KEY_NOT_FOUND)  // daca cheia cautata nu se afla in bucket
			{
				bucket.addEntry(new myEntry(key,value)); //se adauga o noua intrare in bucket
				return null;
			}
			else //daca cheia cautata se afla in bucket
			{
				int index=bucket.containskey(key); // se cauta pozitia in lista la care se afla cheia
				myEntry entry = (myEntry) bucket.getEntries().get(index); //se obtine intrarea care contine cheia
				V val = entry.getValue(); // se obtine valoarea asociata cheii
				entry.setValue(value); // se seteaza noua valoare
				return val;
			}
		}
	}

	/**
	 * Inlatura asocierea.
	 * 
	 * @param key
	 * @return valoarea asociata cu cheia key SAU null daca cheia nu exista.
	 */
	@Override
	public V remove(K key) {
		
		int hashcode =this.getHashcode(key);
		
		if(bucket_list.get(hashcode)==null) // daca nu exista bucket pentru hascode-ul specificat se returneaza null
		{
			return null;
		}
		
		else
		{
			myBucket bucket = bucket_list.get(hashcode); // daca exista bucket pentru hashcode se preia referinta
			if(bucket.containskey(key)==bucket.KEY_NOT_FOUND)  // daca cheia cautata nu se afla in bucket
			{
				return null;
			}
			else //daca cheia cautata se afla in bucket
			{
				int index=bucket.containskey(key); // se cauta pozitia in lista la care se afla cheia
				myEntry entry = (myEntry) bucket.getEntries().get(index); //se obtine intrarea care contine cheia
				V val = entry.getValue(); // se obtine valoarea asociata cheii
				bucket.getEntries().remove(index); //inlatura asocierea din lista de intrari
				
				if(bucket.getEntries().size()==0)
					bucket_list.set(hashcode, null);
				return val;
			}
		}	}

	/**
	 * Intoarce dimensiunea tabelei.
	 *  
	 * @return numarul de chei
	 */
	@Override
	public int size() {
		
		int size=0;
		for(int i=0;i<this.bucket_list.size();i++)
		{
			if(bucket_list.get(i)!=null)
				size++;
		}
		return size;
	}
	
	/**
	 * Intoarce lista de bucket-uri din tabela.
	 * 
	 * @return o lista de tip {@link MyHashMap.Bucket}
	 */
	@Override
	public List<? extends MyHashMap.Bucket<K, V>> getBuckets() {
		return this.bucket_list;
	}
	
	/**
	 * Metoda ce calculeaza HashCode-ul pentru cheia specificata.
	 * @param key
	 * @return HashCode-ul translatat de tip intreg.
	 */
	private int getHashcode(K key)
	{
		/*String s= String.valueOf(key.toString().charAt(0)).toLowerCase();  // cheia dupa care se a face cautarea este primul caracter din String
		int hashcode = translate(s.hashCode()); // se calculeaza hashcode-ul pentru cheie
		return hashcode;*/
		return translate(key.hashCode());
	}
	
	/**
	 * Metoda ce translateaza HashCode-ul. Face ca o cheie sa aiba un HashCode care sa nu depaseasca numarul maxim de bucket-uri.
	 * @param hashcode
	 * @return Valoare de tip intreg.
	 */
	private int translate(int hashcode)
	{
		return Math.abs(hashcode)%bucket_list.size();
	}

}
