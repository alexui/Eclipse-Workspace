

public interface Factory {

	/**
	 * 
	 * @param left
	 * @param operator
	 * @param right
	 * @return nod de tip {@link Node}
	 * in functie de parametrul operator metoda returneaza un nod de tip:
	 * 	- {@link Plus}
	 * 	- {@link Minus}
	 * 	- {@link Ori}
	 *  - {@link Impartit}
	 *  - {@link Putere}
	 *  - {@link Sinus}
	 *  - {@link Cosinus}
	 *  - {@link Radical}
	 *  - {@link Logaritm}
	 */
	public Node getNode(Node left,String operator, Node right);
}
