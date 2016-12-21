

public interface Visitable {
	/**
	 * 
	 * @param v
	 * @return valoeare de tip {@link Float}
	 * @throws SyntacticException
	 * @throws EvaluatorException
	 * accepta visitator
	 */
	public double accept(Visitor v) throws SyntacticException,EvaluatorException;
}
