import java.util.*;


public class Dijkstra {

	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	private Stack<Edge> path;
	

	public Dijkstra (Graph g) {
		this.graph = g;
	}

	public void findPath(Node s, Node d) {

		dijkstraTable = new HashMap[graph.getNodes().size()];
		path = new Stack<Edge>();

		ArrayList<Node> knownNodes = new ArrayList<>();

		// Init du hashmap
		for(int i =0; i< graph.getNodes().size(); i++){
			dijkstraTable[i] = new HashMap<Node,Edge>();
		}

		// Nb Lignes iteration djikstra
		int size = graph.getNodes().size();

		// Premiere iteration manuelle :
		dijkstraTable[0].put(s, new Edge(s,s,0));
		Node position = getMinimum(dijkstraTable[0]);

		for (int i = 1; i < size; i++  ){
			List<Edge> adjacentEdge = graph.getEdgesGoingFrom(position);
			for (Edge edge : adjacentEdge){
				if(!isKnown(position,knownNodes)){
					int dist = edge.getDistance() + dijkstraTable[i-1].get(edge.getSource()).getDistance();
					if (dijkstraTable[i-1].containsKey(edge.getDestination())){
						if (dijkstraTable[i-1].get(edge.getDestination()).getDistance() > dist) {
							dijkstraTable[i].put(edge.getDestination(), new Edge(edge.getSource(), edge.getDestination(), dist));
						}
					}
					// Si il ne contient pas la clef a l'iteration precedente ( premier chemin vers le noeud )
					else
						dijkstraTable[i].put(edge.getDestination(), new Edge(edge.getSource(), edge.getDestination(), dist));
				}
			}

			knownNodes.add(position);
			for (Node element : dijkstraTable[i-1].keySet()){
				if (!dijkstraTable[i].containsKey(element) && !isKnown(element,knownNodes)){
					dijkstraTable[i].put(element, dijkstraTable[i-1].get(element));
				}
			}

			// update de la position pour la prochaine iteration
			position = getMinimum(dijkstraTable[i]);

		}

		// Construction du path en partant de la fin
		position = d;
		while(position.getId() != s.getId()){
			for (int i = size - 1; i > 0; i--){
				if(dijkstraTable[i].containsKey(position)){
					path.push(dijkstraTable[i].get(position));
					position = dijkstraTable[i].get(position).getSource();
					break;
				}
			}
		}

		
	}

	private boolean isKnown(Node n, ArrayList<Node> array){
		for(Node node : array){
			if (node.getId() == n.getId()){
				return true;
			}
		}
		return false;
	}

	private Node getMinimum(Map<Node, Edge> map) {
		Edge min = null;
		for (Node Key : map.keySet()) {
			if ( min == null || map.get(Key).getDistance() < min.getDistance()) {
				min = map.get(Key); 
			}
		}
		return min.getDestination();
	}

	private Edge getMinimum (Edge e1, Edge e2) {
		if (e1.getDistance() < e2.getDistance())
			return e1;
		else
			return e2;
	}
	
	public String printShortPath(Node source, Node destination) {
		this.findPath(source, destination);
		String track = new String();
		int pathLenght = 0;
		int pathSize = path.size();
		//On entre les noeuds dans la variable track pour affichage
		for (int i = path.size(); i > 0; i--){
			Edge edgeTmp = path.pop();
			if (i == pathSize)
				track += edgeTmp.getSource().getName() + "->";
			else if(i>1)
				track += edgeTmp.getDestination().getName() + "->";
			else if (i==1) {
				track += edgeTmp.getDestination().getName();
				pathLenght = edgeTmp.getDistance();
			}
		}
		System.out.print ("La longueur du chemin le plus court est: " + pathLenght + "\n");
		return ("Le plus court chemin est " + track);
	}

	public void showTable() {
		List<Node> nodes = this.graph.getNodes();
		String[][] table = new String [dijkstraTable.length][nodes.size()];

		// Premiere ligne pour voir bon fonctionnement
		for (int i = 0; i < nodes.size(); i++){
			table[0][i] = nodes.get(i).getName()+ " ";
		}
		System.out.print("Tableau de Dijkstra" + "\n");
		System.out.println("Iterations" + Arrays.deepToString(table[0]));

		//Remplissage du tableau avec les noeuds et les distances
		for (int i = 0; i < dijkstraTable.length; i++)
		{
			for(int j = 0; j < nodes.size(); j++)
			{
				if (dijkstraTable[i].containsKey(nodes.get(j)))
					table[i][j] = dijkstraTable[i].get(nodes.get(j)).getDistance() + dijkstraTable[i].get(nodes.get(j)).getSource().getName();
				else
					table[i][j] = "\t";
			}
		}
		//Print du tableau
		for (int i = 0; i < dijkstraTable.length; i++)
			System.out.println("         " + (i+1) + Arrays.deepToString(table[i]));
	}
}
