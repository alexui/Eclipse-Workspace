

public class Logaritm extends NodeStructure{

	public Logaritm(Node l, String s, Node r) {
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
