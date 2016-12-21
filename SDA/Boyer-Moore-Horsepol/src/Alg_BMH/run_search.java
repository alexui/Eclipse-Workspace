package Alg_BMH;

import java.io.IOException;

public class run_search {

	
	
	public static void main(String[] args) {

		String file="search";
		String pat="alex";
		BMH_search s = new BMH_search(pat, file);
		try {
			int pos;
			pos=s.search();
			
			if(pos!=s.NOT_FOUND)
				System.out.println("\""+pat+"\" "+"found"+" in file:"+"\""+file+"\" "+"pos:"+pos+" on line:"+s.getLineFound()+".");
			else System.out.println("\""+pat+"\" "+"not found in file:"+"\""+file+"\".");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
