
public class Vizitator {

	public double viziteaza(Adunare x) {
		
		return Float.parseFloat(x.getStanga().getRadacina())+Float.parseFloat(x.getDreapta().getRadacina());
	}

	
	public double viziteaza(Scadere x) {
		
		return Float.parseFloat(x.getStanga().getRadacina())-Float.parseFloat(x.getDreapta().getRadacina());
	}

	
	public double viziteaza(Inmultire x) {
		
		return Float.parseFloat(x.getStanga().getRadacina())*Float.parseFloat(x.getDreapta().getRadacina());
	}

	
	public double viziteaza(Impartire x) {
		
		float left = Float.parseFloat(x.getStanga().getRadacina());
		float right = Float.parseFloat(x.getDreapta().getRadacina());
		if(right == 0)
			throw new EvaluatorException();
		return left/right;
	}

	
	public double viziteaza(Sin x) {
		
			return Math.sin(Float.parseFloat(x.getStanga().getRadacina()));
	}

	
	public double viziteaza(Cos x) {
		
			return  Math.cos(Float.parseFloat(x.getStanga().getRadacina()));
	}

	
	public double viziteaza(Log x) {
		
		float val;
		val = Float.parseFloat(x.getStanga().getRadacina());
		if(val==0)
			throw new EvaluatorException();
		return  Math.log10(val);
	}

	
	public double viziteaza(Radical x) {
		
		float val;
		val = Float.parseFloat(x.getStanga().getRadacina());
		if(val<0)
			throw new EvaluatorException();
		return Math.sqrt(val);
	}

	
	public double viziteaza(Putere x) {
		
		return  Math.pow(Float.parseFloat(x.getStanga().getRadacina()), Float.parseFloat(x.getDreapta().getRadacina()));
	}

	
	public double viziteaza(Atom x) throws SyntacticException{
		
		float val;
		try{
			val =Float.parseFloat(x.getRadacina());	
		}
		catch(NumberFormatException nfe)
		{
			throw new SyntacticException();
		}
		return  val;
	}
	
	

}
