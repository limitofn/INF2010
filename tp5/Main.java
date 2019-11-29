import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		System.out.println("TP05 : Graphes");
		
		// Partie 1: Création du graphe

		//Creation des noeuds
		Node nodeA = new Node(0, "A");
		Node nodeB = new Node(1, "B");
		Node nodeC = new Node(2, "C");
		Node nodeD = new Node(3, "D");
		Node nodeE = new Node(4, "E");
		Node nodeF = new Node(5, "F");
		Node nodeG = new Node(6, "G");

		//Creation des edges
		Edge edgeAB = new Edge(nodeA,nodeB,2);
		Edge edgeAC = new Edge(nodeA,nodeC,1);
		Edge edgeBE = new Edge(nodeB,nodeE,3);
		Edge edgeBC = new Edge(nodeB,nodeC,2);
		Edge edgeCE = new Edge(nodeC,nodeE,3);
		Edge edgeBD = new Edge(nodeB,nodeD,1);
		Edge edgeCD = new Edge(nodeC,nodeD,4);
		Edge edgeCF = new Edge(nodeC,nodeF,5);
		Edge edgeEF = new Edge(nodeE,nodeF,1);
		Edge edgeDF = new Edge(nodeD,nodeF,6);
		Edge edgeDG = new Edge(nodeD,nodeG,5);
		Edge edgeFG = new Edge(nodeF,nodeG,2);

		//Ajout des noeuds
		ArrayList <Node> nodeList = new ArrayList<Node>();
		nodeList.add(nodeA);
		nodeList.add(nodeB);
		nodeList.add(nodeC);
		nodeList.add(nodeD);
		nodeList.add(nodeE);
		nodeList.add(nodeF);
		nodeList.add(nodeG);

		g.setNodes(nodeList);

		//Ajout des edges
		ArrayList<Edge>edgesList = new ArrayList<Edge>();
		edgesList.add(edgeAB);
		edgesList.add(edgeAC);
		edgesList.add(edgeBE);
		edgesList.add(edgeBC);
		edgesList.add(edgeCE);
		edgesList.add(edgeBD);
		edgesList.add(edgeCD);
		edgesList.add(edgeCF);
		edgesList.add(edgeEF);
		edgesList.add(edgeDF);
		edgesList.add(edgeDG);
		edgesList.add(edgeFG);

		g.setEdges(edgesList);



		// Partie 2: Implémentation de l’algorithme Dijkstra
		
		Dijkstra d = new Dijkstra(g);
		
		d.findPath(nodeA, nodeG);
		
		d.showTable();

		// Partie 3 : Afficher le chemin le plus court
		System.out.println(d.printShortPath(nodeA, nodeG));
	
	}
}
