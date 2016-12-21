
public class Test4 {

	public static void main(String[] args) {
		int x=0;
		int [] primes = {1,2,3,5};
		for(int i:primes){
			System.out.println(i);
			switch(i){
				case 1:x+=i;
				case 5:x+=i;
				case 2:x+=i;
				default:x+=i;
			}}
		System.out.println(x);
	}
}
