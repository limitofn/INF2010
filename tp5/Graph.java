import java.util.ArrayList;
import java.util.List;



public class Graph {

	private List<Node> nodes; // Noeuds
	private List<Edge> edges; // Les arcs
	
	public Graph() {
		this.nodes = null;
		this.edges = null;
	}
	
	public List<Edge> getEdgesGoingFrom(Node source) {

		ArrayList <Edge> beginningEdges = new ArrayList<Edge>();

		for (Edge i : edges)
		{
			if(i.getSource() == source)
				beginningEdges.add(i);
		}

		return beginningEdges;
		
	}
	public List<Edge> getEdgesGoingTo(Node dest) {

		ArrayList <Edge> edgesEnd = new ArrayList<Edge>();
		for (Edge i : edges)
		{
			if (i.getDestination() == dest)
				edgesEnd.add(i);
		}

		return edgesEnd;
	}
	
	// Accesseurs 
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
}
