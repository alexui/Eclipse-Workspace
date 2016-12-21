

public interface Visitable {
	public double accept(Vizitator v) throws SyntacticException,EvaluatorException;
}
