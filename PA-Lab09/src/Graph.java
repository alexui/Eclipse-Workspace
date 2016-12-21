import java.util.ArrayList;
import java.util.HashMap;


public class Graph {

	private HashMap<String, Node> nodes;
	private ArrayList<Pair> edges;
	
	public Graph(){
		nodes=new HashMap<String,Node>();
		edges = new ArrayList<Pair>();
	}

	public HashMap<String, Node> getNodes() {
		return nodes;
	}

	public ArrayList<Pair> getEdges() {
		return edges;
	}
	
}
