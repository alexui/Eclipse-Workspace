package ex2;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Encrypter enc = EncrypterFactory.getInstance().get();
		System.out.println(enc.encrypt("alex"));
		System.out.println(enc.decrypt(enc.encrypt("alex")));
	}

}
