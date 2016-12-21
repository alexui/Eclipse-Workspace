package Ex1;

public class Colection1 {

	
	public static void main(String[] args) {

		MyLinkedHashSet<String> set = new MyLinkedHashSet<String>();
		set.add("eu");
		set.add("tu");
		set.add("el");
		set.add("ea");
		for(String s :set){
			System.out.println(s);
		}
		set.add("eu");
	}

}
