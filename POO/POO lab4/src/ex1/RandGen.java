package ex1;

public class RandGen implements Task{

	private int nr;

	public RandGen(int max) {
		
		this.nr=(int)(Math.random()*max);
	}

	@Override
	public void execute() {

		System.out.println("Nr.Generat: "+this.nr);
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}
	
}
