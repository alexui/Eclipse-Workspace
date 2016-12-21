
class Interpretation {
	private boolean[] v;  
	public Interpretation (){
		v = new boolean [100];
	}
	public void set (int var, boolean val){
		this.v[var]=val;
	}
	public boolean get (int var){
		return this.v[var];
	}
}

class Formula {

	public static final int ATOM = 0, NEGATION = 1, CONJUNCTION = 2;

	private int value;
	private Formula left, right;


	public Formula (int var){
		this.value = var;
	}
	public Formula (Formula phi){
		this.left = phi;
	}
	public Formula (Formula phi1, Formula phi2){
		this.left = phi1;
		this.right = phi2;
	}
	public int type (){
		if (this.left == null)
			return ATOM;
		else if (this.right == null)
				return NEGATION;
		else return CONJUNCTION;
	}
	public int getAtom (){
		return value;
	}
	@Override
	public String toString (){
		switch (type()){
		case ATOM: return String.valueOf(value);
		case NEGATION: if (left.type() == ATOM) return "~"+left.toString();
					   else	return "~(" + left.toString()+")";
		default: return left.toString() + " ^ "+right.toString();
		}
	}
	public Formula getSubformula() {
		return this.left;
	}
	public Formula getLeftSubformula(){
		return this.getSubformula();
	}
	public Formula getRightSubformula(){
		return this.right;
	}
}

public class Solution {
	
	public static final int X = 0, Y = 1, Z = 2;
	/**
	 * @param args
	 */
	public static boolean entails (Interpretation I, Formula phi){
		switch (phi.type()){
		case Formula.ATOM: return I.get(phi.getAtom());
		case Formula.NEGATION: return !entails(I,phi.getSubformula());
		default: return entails(I,phi.getLeftSubformula()) && entails(I,phi.getRightSubformula());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Formula f = new Formula(new Formula(Z), new Formula (new Formula (new Formula(X),new Formula (new Formula (Y)))));
		System.out.println(f);
		Interpretation I = new Interpretation ();
		I.set(2, false);
		I.set(0, true);
		System.out.println(entails(I,f));
		
	}

}
