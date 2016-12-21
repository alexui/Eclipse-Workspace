
public class Tangent extends NodeStructure {

	public Tangent(Node l, String s, Node r) {
		super(l, s, r);
	}

	@Override
	public double accept(Visitor v) throws SyntacticException,
			EvaluatorException {
		return v.visit(this);		
	}

	@Override
	public Node getNode() {
		return this;
	}

}
