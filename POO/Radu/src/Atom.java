

public class Atom extends NodAbstract{

	public Atom(Nod l, String s, Nod r) {
		super(l, s, r);
	}

	@Override
	public double accept(Vizitator v) throws SyntacticException {
		return v.viziteaza(this);
	}

	@Override
	public Nod getNod() {
		return this;
	}
}
