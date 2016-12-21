
public class Compute implements Visitor {

	@Override
	public double visit(Plus operator) {
		
		return Double.parseDouble(operator.getLeft().getRoot())+Double.parseDouble(operator.getRight().getRoot());
	}

	@Override
	public double visit(Minus operator) {
		
		return Double.parseDouble(operator.getLeft().getRoot())-Double.parseDouble(operator.getRight().getRoot());
	}

	@Override
	public double visit(Ori operator) {
		
		return Double.parseDouble(operator.getLeft().getRoot())*Double.parseDouble(operator.getRight().getRoot());
	}

	@Override
	public double visit(Impartit operator) {
		
		double left = Double.parseDouble(operator.getLeft().getRoot());
		double right = Double.parseDouble(operator.getRight().getRoot());
		if(right == 0)
			throw new EvaluatorException();
		return left/right;
	}

	@Override
	public double visit(Sinus operator) {
		
		if(operator.getRight()!=null)
			return Math.sin(Double.parseDouble(operator.getRight().getRoot()));
		else
			return Math.sin(Double.parseDouble(operator.getLeft().getRoot()));
	}

	@Override
	public double visit(Cosinus operator) {
		
		if(operator.getRight()!=null)
			return  Math.cos(Double.parseDouble(operator.getRight().getRoot()));
		else
			return  Math.cos(Double.parseDouble(operator.getLeft().getRoot()));
	}

	@Override
	public double visit(Logaritm operator) {
		
		double val;
		if(operator.getRight()!=null){
			
			val = Double.parseDouble(operator.getRight().getRoot());
			if(val<=0)
				throw new EvaluatorException();
			return  Math.log10(val);
		}
		else{
			val = Float.parseFloat(operator.getLeft().getRoot());
			if(val<=0)
				throw new EvaluatorException();
			return  Math.log10(val);
		}
	}

	@Override
	public double visit(Radical operator) {
		
		double val;
		if(operator.getRight()!=null){
			val=Double.parseDouble(operator.getRight().getRoot());
			if(val<0)
				throw new EvaluatorException();
			return Math.sqrt(val);
		}
		else{
			val = Double.parseDouble(operator.getLeft().getRoot());
			if(val<0)
				throw new EvaluatorException();
			return Math.sqrt(val);
		}
	}

	@Override
	public double visit(Putere operator) {
		
		return  Math.pow(Double.parseDouble(operator.getLeft().getRoot()), Double.parseDouble(operator.getRight().getRoot()));
	}

	@Override
	public double visit(Operand operator) throws SyntacticException{
		
		double value;
		try{
			value =Double.parseDouble(operator.getRoot());	
		}
		catch(NumberFormatException nfe)
		{
			throw new SyntacticException();
		}
		return  value;
	}

	@Override
	public double visit(Tangent operator) {
		if(operator.getRight()!=null)
			return Math.tan(Double.parseDouble(operator.getRight().getRoot()));
		else
			return Math.tan(Double.parseDouble(operator.getLeft().getRoot()));
	}

	@Override
	public double visit(Cotangent operator) {
		if(operator.getRight()!=null)
			return 1/Math.tan(Double.parseDouble(operator.getRight().getRoot()));
		else
			return 1/Math.tan(Double.parseDouble(operator.getLeft().getRoot()));
	}
	

}
