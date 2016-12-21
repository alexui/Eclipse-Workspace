import java.io.IOException;


public class NewExample {

	public class MyException extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public void describe(){
			System.out.println("--I'm a stupid error.--");
		}
	}
	
	public void run() throws IOException{
		System.out.println("salut sunt eu picasso");
		throw new IOException();
		
	}
	
	public static void main(String[] args) {
		
		NewExample e = new NewExample();
		try {
			e.run();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Exception was caught.");
		
		//List<String> stringList = new ArrayList<String>(); // 1
		//List<Object> objectList = stringList;              // 2
		
	}
}
