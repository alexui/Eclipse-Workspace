

public class NodeFactory implements Factory {

	private Node node;
	
	@Override
	public Node getNode(Node left,String operator,Node right) {
		
		switch (operator){
		
		case "+": 
			node = new Plus(left,operator,right);
			break;
		case "-":
			node = new Minus(left,operator,right);
			break;
		case "*":
			node = new Ori(left,operator,right);
			break;
		case "/":
			node = new Impartit(left,operator,right);
			break;
		case "^":
			node = new Putere(left,operator,right);
			break;
		case "sin":
			node = new Sinus(left,operator,right);
			break;
		case "cos":
			node = new Cosinus(left,operator,right);
			break;
		case "log":
			node = new Logaritm(left,operator,right);
			break;
		case "sqrt":
			node = new Radical(left,operator,right);
			break;
		case "tan":
			node = new Tangent(left, operator, right);
			break;
		case "cot":
			node = new Cotangent(left, operator, right);
			break;
		default :
			node = new Operand(left,operator,right);
			break;
		}
		
		return this.node;
	}

}
