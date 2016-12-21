import java.util.ArrayList;
import java.util.HashMap;

public class Operatori {

	public HashMap<String, Integer> operatori_binari;
	public ArrayList<String> operatori_unari;
	
	public Operatori(){
		
		operatori_binari = new HashMap<String,Integer>();
		operatori_binari.put("+",0);
		operatori_binari.put("-",1);
		operatori_binari.put("*",2);
		operatori_binari.put("/",3);
		operatori_binari.put("^",4);
		
		operatori_unari = new ArrayList<String>();
		operatori_unari.add("sin");
		operatori_unari.add("log");
		operatori_unari.add("sqrt");
		operatori_unari.add("cos");
	}
}
