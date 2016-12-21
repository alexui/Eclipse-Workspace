
public class Pair{
	
	private Node node1;
	private Node node2;
	private int cost;
	
	public Pair(Node n1,Node n2,int cost){
		this.node1=n1;
		this.node2=n2;
		this.cost=cost;
	}
	
	public boolean contains(Node n){
		if(n.equals(node1) || n.equals(node2))
			return true;
		return false;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String toString(){
		return "[("+node1+","+node2+"):"+cost+"]";
	}

	public Node getNode1() {
		return node1;
	}

	public void setNode1(Node node1) {
		this.node1 = node1;
	}

	public Node getNode2() {
		return node2;
	}

	public void setNode2(Node node2) {
		this.node2 = node2;
	}
	
}