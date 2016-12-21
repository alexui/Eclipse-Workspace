package lab6;

public class Tema1 {

	public static void main(String args[])
	{ // To create a new instance class 

		Simple sim = new Simple(); 
		// To show the result of the addNumbers 
		System.out.println("The result is " + Integer.toString(sim.addNumbers(5,1,2)));
		// To display message 
		sim.displayMessage();
	}
}
