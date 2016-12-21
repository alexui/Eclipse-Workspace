public class Factory {
	
	public Nod take(Nod st,String cuv,Nod dr) {
		
		switch (cuv){
		
		case "+": 
			return new Adunare(st,cuv,dr);
		case "-":
			return new Scadere(st,cuv,dr);
		case "*":
			return new Inmultire(st,cuv,dr);
		case "/":
			return new Impartire(st,cuv,dr);
		case "^":
			return new Putere(st,cuv,dr);
		case "sin":
			return new Sin(st,cuv,dr);
		case "cos":
			return new Cos(st,cuv,dr);
		case "log":
			return new Log(st,cuv,dr);
		case "sqrt":
			return new Radical(st,cuv,dr);
		default :
			return new Atom(st,cuv,dr);
		}
		
	}

}
