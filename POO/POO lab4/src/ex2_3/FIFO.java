package ex2_3;

public class FIFO implements Fact{

	@Override
	public Container create() {
		return new Stack();
	}

}
