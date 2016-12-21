

public class Ori extends NodeStructure{

	public Ori(Node l, String s, Node r) {
		super(l, s, r);
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