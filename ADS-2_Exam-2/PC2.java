
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


class Vertex implements Comparable<Vertex> 
{
	private int n;
	private List<Edge> adjacenciesList;
	private boolean visited;
	private Vertex p;
	private int distance = Integer.MAX_VALUE;

	public Vertex(int n) {
		this.n  = n;
		this.adjacenciesList = new ArrayList<>();
	}

	public void addNeighbour(Edge edge) {
		this.adjacenciesList.add(edge);
	}

	public int getName() {
		return n;
	}

	public void setName(int n) {
		this.n = n;
	}

	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}

	public void setAdjacenciesList(List<Edge> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex getPredecessor() {
		return p;
	}

	public void setPredecessor(Vertex p) {
		this.p = p;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
		public int compareTo(Vertex otherVertex) {
		return Integer.compare(this.distance, otherVertex.getDistance());
	}
}
class Edge {
	private int weight;
	private Vertex startVertex;
	private Vertex targetVertex;
	
	public Edge(int weight, Vertex startVertex, Vertex targetVertex) {
		this.weight = weight;
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}

	public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}

	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}
}


public class PC2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		int b = Integer.parseInt(sc.nextLine());
		Vertex v[] = new Vertex[b];
		for (int i = 0; i < a; i++) 
		{
			v[i] = new Vertex(i);
		}
		for (int j = 0; j < b; j++) {
			String s1 = sc.nextLine();
			String s2[] = s1.split(" ");
			Vertex v1 = getVertex(v,Integer.parseInt(s2[0]));
			Vertex v2 = getVertex(v,Integer.parseInt(s2[1]));
			v1.addNeighbour(new Edge(Integer.parseInt(s2[2]), v1, v2));
			v2.addNeighbour(new Edge(Integer.parseInt(s2[2]), v2, v1));
		}
		String caseToGo = sc.nextLine();
		switch (caseToGo) 
		{
		case "Graph":
			System.out.println(a+" vertices "+b+" edges");
			for(int i=0; i<a; i++)
			{
				System.out.print(i+":");
				System.out.println(v[i].getName());
				System.out.println(v[i].getAdjacenciesList());
			}
			break;

		case "DirectedPaths":
				break;

		case "ViaPaths":
			break;

		}

	}

	private static Vertex getVertex(Vertex[] v, int parseInt) 
	{
		for (int i = 0; i < v.length; i++)
		{
			return v[i];
		}	
		return null;
	}
}