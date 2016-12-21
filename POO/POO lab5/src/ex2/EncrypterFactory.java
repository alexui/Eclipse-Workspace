package ex2;

public class EncrypterFactory {
	
	private static EncrypterFactory instance;
	
	private EncrypterFactory()
	{
		
	}
	
	static public EncrypterFactory getInstance()
	{
		if(instance==null)
			instance = new EncrypterFactory();
		return instance;
	}
	
	class Encrypter1 implements Encrypter
	{

		@Override
		public String encrypt(String s) {
			
			char [] aux = s.toCharArray();
			for(int i=0;i<aux.length;i++)
			{
				aux[i]=(char)(aux[i]+1);
			}
			s= String.valueOf(aux);
			return s;
		}

		@Override
		public String decrypt(String s) {

			char [] aux = s.toCharArray();
			for(int i=0;i<aux.length;i++)
			{
				aux[i]=(char)(aux[i]-1);
			}
			s= String.valueOf(aux);
			return s;
		}
		
	}
	
	class Encrypter2 implements Encrypter
	{

		@Override
		public String encrypt(String s) {
			
			char [] aux = s.toCharArray();
			for(int i=0;i<aux.length;i++)
			{
				aux[i]=(char)(aux[i]-5);
			}
			s= String.valueOf(aux);
			return s;
		}

		@Override
		public String decrypt(String s) {

			char [] aux = s.toCharArray();
			for(int i=0;i<aux.length;i++)
			{
				aux[i]=(char)(aux[i]+5);
			}
			s= String.valueOf(aux);
			return s;
		}
		
	}

	public Encrypter get()
	{
		return (int)(Math.random()*2)==0 ? new Encrypter1() : new Encrypter2();
	}
}
