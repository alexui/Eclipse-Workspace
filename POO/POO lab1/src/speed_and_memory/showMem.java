package speed_and_memory;

public class showMem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(System.nanoTime()/Math.pow(10, 9)/3600);
		double val = Runtime.getRuntime().maxMemory();
		System.out.println("max Memory = "+val/1024/1024+" MB");
		
		val=Runtime.getRuntime().totalMemory();
		System.out.println("total Memory = "+val/1024/1024+" MB");
		
		val=Runtime.getRuntime().freeMemory();
		System.out.println("free Memory = "+val/1024/1024+" MB");
	}

}
