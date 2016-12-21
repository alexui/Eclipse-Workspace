
public class class1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello, World");
		String c=new String ();
		c="Salut";
		String d=new String("Another string");
		String e=String.valueOf(1.23);	
		
		System.out.println(d);
		System.out.println(e);
		System.out.println(c);
		
		int m;
		m=3;
		System.out.println(m + 1 + 2 + 3);
		System.out.println("answer = " + (1+2+3));
		
		StringBuffer buffer = new StringBuffer(15); //obiect
		buffer.append("This is ") ;
		buffer.append("String") ;
		buffer.insert(7," a");
		buffer.append('.');
		System.out.println("buffer: "+ buffer);
		System.out.println(buffer.length()); // 17
		System.out.println(buffer.capacity()); // 32
		System.out.println(buffer); //transforma la sir de caracter
		String output = buffer.toString() ;
		System.out.println(output); // "This is a String."
		}

}
