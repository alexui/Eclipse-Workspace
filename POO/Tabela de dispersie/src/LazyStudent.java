
public class LazyStudent extends Student{

	public final int Constant=1;
	
	public LazyStudent(String nume, int varsta) {
		super(nume, varsta);
	}
	
	@Override
	public int hashCode()
	{
		return this.Constant;
	}
}
