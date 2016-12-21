package ex2_3;

public class LIFO implements Fact{

	@Override
	public Container create() {
		return new Queue();
	}

}
