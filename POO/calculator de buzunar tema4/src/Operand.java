

public class Operand extends NodeStructure{

	public Operand(Node l, String s, Node r) {
		super(l, s, r);
	}

	@Override
	public double accept(Visitor v) throws SyntacticException {
		return v.visit(this);
	}

	@Override
	public Node getNode() {
		return this;
	}
}
