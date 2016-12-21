import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
    	Vector<Complex> v;
    	
        /* Citeste date de test. */
        v = Complex.readData("date.in");
        System.out.println("Vectorul initial:");
        Complex.writeVector(v);
        
        /* Verifica sortarea. */
        Vector<Complex> sorted = getSorted(v);
        System.out.println("Vectorul sortat:");
        Complex.writeVector(sorted);

        /* Verifica maparea. */
        HashMap<Complex,Integer> mapping = getMapping(v);
        System.out.println("Maparea:");
        for (Complex element : v) {
        	System.out.println(String.format("%s e pe pozitia %d", element, mapping.get(element)));
        }
    }
    
    private static class ComplexComparator implements Comparator<Complex> {

    	/**
    	 * Functie ce compara doua numere complexe: intai compara partea reala
    	 * si daca ambele numere au aceeasi parte reala, atunci compara partea imaginara 
    	 */
		@Override
		public int compare(Complex a, Complex b) {
			
			if(a.r<b.r)
				return -1;
			else if(a.r==b.r){
				if(a.i<b.i)
					return -1;
				else if(a.i==b.i)
					return 0;
				else 
					return 1;
			}
			else return 1;	    
		}
    }

    /** 
     * Functie ce sorteaza crescator elementele unui vector de numere complexe
     * @param v		vectorul de numere complexe de intrare
     * @return		vectorul de numere complexe sortat descrescator
     */
    private static Vector<Complex> getSorted( Vector<Complex> v ) {
    	Vector<Complex> res = new Vector<Complex>();	// vectorul rezultat
    	
    	/*Folosind PriorityQueue, adaugati elementele din v in ordine crescatoare.
    	 * Pentru PriorityQueue folositi comparatorul definit mai sus */
    	
    	PriorityQueue<Complex> q = new PriorityQueue<>(v.capacity(), new ComplexComparator());
    	
    	for(Complex a : v){
    		q.add(a);
    	}
    	    	
    	while(!q.isEmpty()){ // for each e gresitdin cauza iteratorului
    		res.add(q.poll());
    	}
    	
        return res;
    }
    
    /**
     * Functie ce construieste un HashMap: pentru fiecare element complex atribuie pozitia sa 
     * in vectorul sortat
     * @param v		vectorul de elemente complexe, nesortat
     * @return		HashMap care atribuie pentru fiecare element pozitia sa in vectorul sortat
     */
    private static HashMap<Complex, Integer> getMapping ( Vector<Complex> v) {
    	HashMap<Complex, Integer> res = new HashMap<>();
    	
    	Vector<Complex> v_res = getSorted(v);
    	/*TODO Adaugati in map, pentru fiecare element din v, pozitia sa in vectorul sortat. */
        for(Complex a :v){
        	res.put(a, v_res.indexOf(a));
        }
    	
        return res;
    }
    
    
}