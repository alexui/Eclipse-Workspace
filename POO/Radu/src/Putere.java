

public class Putere extends NodAbstract{

	public Putere(Nod l, String s, Nod r) {
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
