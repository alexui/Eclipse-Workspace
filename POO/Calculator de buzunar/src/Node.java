
/**
 * clasa de tip {@link Visitable}
 * @author aless
 *
 */
public interface Node extends Visitable{

	/**
	 * getter pentru element de tip {@link Node}
	 * @return nod
	 */
	public Node getNode();
	/**
	 * getter pentru radacina
	 * @return valoare de tip {@link String}
	 */
	public String getRoot();
	/**
	 * getter pentru nod adiacent stanga de tip {@link Node}
	 * @return nod
	 */
	public Node getLeft();
	/**
	 * getter pentru nod adiacent dreapta de tip {@link Node}
	 * @return nod
	 */
	public Node getRight();
	/**
	 * setter pentru radacina
	 * @param s de tip {@link String}
	 */
	public void setRoot(String s);
}
