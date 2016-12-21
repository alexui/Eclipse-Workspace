public class ExpressionParser {
	
	Operatori op = new Operatori();
			
	private double calculator(Nod n) throws EvaluatorException, SyntacticException{
		
		Vizitator v =new Vizitator();
		
				
		double stanga,dreapta;
		if(n.getStanga()!=null)
			{
			stanga=calculator(n.getStanga());
			n.getStanga().setRadacina(String.valueOf(stanga));
			}
		if(n.getDreapta()!=null)
			{
			dreapta=calculator(n.getDreapta());
			n.getDreapta().setRadacina(String.valueOf(dreapta));
			}
		return n.accept(v);
	}
	
	public float eval(String expression) throws SyntacticException, EvaluatorException{
		
		ArboreDeParsare Arb;
		Arb= new ArboreDeParsare(expression);
		Nod root = Arb.radacina();
		
		return (float) calculator(root);
	}
	
}
