


public interface Visitor {
	
	public double visit(Plus operator);
	public double visit(Minus operator);
	public double visit(Ori operator);
	public double visit(Impartit operator);
	public double visit(Sinus operator);
	public double visit(Cosinus operator);
	public double visit(Logaritm operator);
	public double visit(Radical operator);
	public double visit(Putere operator);
	public double visit(Operand operand) throws SyntacticException;
	public double visit(Tangent operator);
	public double visit(Cotangent operator);
}
