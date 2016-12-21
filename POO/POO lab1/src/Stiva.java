
public class Stiva {

	private int d;
	private char c;
	private final int I=1,C=2;
	private int type;
	
	
	public Stiva(int val)
	{
		this.d=val;
		this.type=I;
	}
	
	public Stiva(char val)
	{
		this.c=val;
		this.type=C;
	}
	
	public int Type()
	{
		if(type==C)return C;
		if(type==I)return I;
		return -1;
	}
	
	
	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
		this.type=I;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
		this.type=C;
	}
	

}
