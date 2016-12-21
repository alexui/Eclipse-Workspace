
/**
 * clasa abstracta de tip {@link Node}
 * @author aless
 *
 */
public abstract class NodeStructure implements Node{
	
	private String root;
	private Node left;
	private Node right;
	
	public NodeStructure(Node l,String s,Node r){
		this.left=l;
		this.root=s;
		this.right=r;
	}

	@Override
	public String getRoot() {
		return root;
	}

	@Override
	public Node getLeft() {
		return left;
	}

	@Override
	public Node getRight() {
		return right;
	}
	
	@Override
	public void setRoot(String s){
		this.root=s;
	}
}
