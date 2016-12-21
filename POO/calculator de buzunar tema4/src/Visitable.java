

public interface Visitable {
	public double accept(Visitor v) throws SyntacticException,EvaluatorException;
}
