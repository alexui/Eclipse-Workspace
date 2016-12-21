

public class Node {

	private int findSet;
	private String name;
	private int id;
	
	public Node(String name ,int id){
		this.name=name;
		this.id =id;
		findSet= id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	public int getFindSet() {
		return findSet;
	}

	public void setFindSet(int findSet) {
		this.findSet = findSet;
	}

	@Override
	public boolean equals(Object o){
		Node n = (Node)o;
		if(n.getName().equals(this.name))
			return true;
		return false;	
	}
	
	public String toString(){
		return this.name;
	}
}

