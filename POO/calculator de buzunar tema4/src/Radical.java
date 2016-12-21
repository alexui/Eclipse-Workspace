

public class Radical extends NodeStructure{

	public Radical(Node l, String s, Node r) {
		super(l,s,r);
	}

	@Override
	public double accept(Visitor v) {
		return v.visit(this);
	}

	@Override
	public Node getNode() {
		return this;
	}
}
