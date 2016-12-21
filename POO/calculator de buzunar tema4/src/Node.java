

public abstract class Node implements Visitable{

	public abstract Node getNode();
	public abstract String getRoot();
	public abstract Node getLeft();
	public abstract Node getRight();
	public abstract void setRoot(String s);
}
