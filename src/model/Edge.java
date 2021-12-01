package model;

public class Edge<T> {
	private T adjNode;
	private int weight;
	
	public Edge(T adjNode,int w) {
		this.adjNode = adjNode;
		this.weight = w;
	}
	
	
	public T getValue() {
		return adjNode;
	}
	
	public int getWeight() {
		return weight;
	}
	
}
