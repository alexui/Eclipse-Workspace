

public class Sin extends NodAbstract{

	public Sin(Nod l, String s, Nod r) {
		super(l, s, r);
	}

	@Override
	public double accept(Vizitator v) {
		return v.viziteaza(this);
	}

	@Override
	public Nod getNod() {
		return this;
	}
}