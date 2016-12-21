

public class Index {
	
	/**
	 * metoda converteste un vector de valori intregi la sir de caractere
	 * @param a
	 * @return sir de caractere
	 */
	public static String arrayToString(int[] a)
	{
		String s= new String();
		int i;
		s=String.valueOf(a.length)+" ";
		for(i=0;i<a.length;i++)
			s+=a[i]+" ";
		return s;
	}
	
	/**
	 * Execution entry point.
	 *
	 * @param args two strings representing the name of the file that contains the text to index,
	 * and the name of the file containing words to lookup in the text.
	 */
	
	public static void main(String[] args) throws NullPointerException{
	
	/*	if (args.length != 2) {
			System.err.println("Usage: java -cp <classpath> Index <text file> <word file>");
			System.exit(1);
		}*/
		String word;
		int[] pos;
		
		CreateRT build = new CreateRT("text");
		RadixTree tree=build.getRadixTree();
				
		FileParser textFile = new FileParser("prefix");
		textFile.open();
		while ((word = textFile.getNextWord()) != null) {
			
			pos = build.search(tree,word);
			//build.printRadixTree(tree, 0);
			if(pos!=build.NOT_FOUND)
				System.out.println(arrayToString(pos));
			else
				System.out.println(0);
		}
		textFile.close();
		
	}

}
