
public class TryOut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Actor1 hamlet = new Actor1();
	    Actor2 juliet = new Actor2();
	    tryout(hamlet);
	    tryout(juliet);
	}
	  private static void tryout(Act actor) {
		    actor.act();
		  }


}
