package speed_and_memory;

public class usedMem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long d=Runtime.getRuntime().freeMemory();
		System.out.println("memory:"+d);
		int a=4;
		d=Runtime.getRuntime().freeMemory();
		System.out.println("memory:"+d);
		System.out.println("ocupied:"+d+" by a: "+a);
	}

}
