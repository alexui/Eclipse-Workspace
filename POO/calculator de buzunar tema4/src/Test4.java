import java.util.LinkedHashMap;


public class Test4 {

	public class BinaryOperators{ //clasa contine un map se asociaza fiecarui operator binar  gradul de prioritate ->+ are prioritatea cea mai mare
		
		public LinkedHashMap<String, Integer> map;
		
		public BinaryOperators(){
			
			map = new LinkedHashMap<String,Integer>();
			map.put("+",1);
			map.put("-",2);
			map.put("/",3);
			map.put("*",4);
			map.put("^",5);
		}
		
		
	}

	public static void main(String[] args) {
		
		Test4 t3 = new Test4();
		Test4.BinaryOperators bo = t3.new BinaryOperators();
		System.out.println(bo.map.keySet());
		
		System.out.println(bo.map.entrySet());
		
	}
}
