package ex1;

public class PrintMessege implements Task{

	private String s;

	public PrintMessege(String s) {
		this.s = s;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public void execute() {

		System.out.println("Messege:"+this.s);
	}
		
}
