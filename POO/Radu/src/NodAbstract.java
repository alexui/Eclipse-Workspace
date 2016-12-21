

public abstract class NodAbstract implements Nod{
	
	String radacina;
	Nod stanga;
	Nod dreapta;
	
	public NodAbstract(Nod l,String s,Nod r){
		this.stanga=l;
		this.radacina=s;
		this.dreapta=r;
	}

	@Override
	public String getRadacina() {
		return radacina;
	}

	@Override
	public Nod getStanga() {
		return stanga;
	}

	@Override
	public Nod getDreapta() {
		return dreapta;
	}
	
	@Override
	public void setRadacina(String s){
		this.radacina=s;
	}
}
