package LAB02;

// Clasa pentru generarea de parole personalizate

public class PasswordMaker {
	private static final int MAGIC_NUMBER=30;
	private final String password; // blank final, initializat in constructor
	
	// Constructor care primeste string-uri : firstName, lastName, age(int)
	public PasswordMaker(String firstName, String lastName, int age) {
		RandomStringGenerator gt = new RandomStringGenerator(MAGIC_NUMBER, "farfurie");
		password = firstName.substring(firstName.length() - age % 3 - 1) + gt.next() + (age + lastName.length());
		
		
	}

	public String getPassword() {
		return password;
	}
	
	public static void main(String[] args) {
		PasswordMaker pm = new PasswordMaker("Luke", "Nathan", 12);
		System.out.println("ex 6");
		System.out.println("Parola generata: ");		
		System.out.println(pm.getPassword());
		

	}

}
