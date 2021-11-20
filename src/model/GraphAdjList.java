package model;

import java.util.Hashtable;
import java.util.LinkedList;

public class GraphAdjList<T> {
	private Hashtable<T,LinkedList<Edge<T>>> nodes;
	private boolean directed;
	
	public GraphAdjList(boolean directed) {
		nodes = new Hashtable<T,LinkedList<Edge<T>>>();
		this.directed = directed;
	}
	
	public void addVertex(T object) {
		nodes.put(object,new LinkedList<Edge<T>>());
	}
	
	public void addEdge(T start, T end,int weight) {
		if(!nodes.containsKey(start)) {
			addVertex(start);
		}
		if(!nodes.containsKey(end)) {
			addVertex(end);
		}
		
		nodes.get(start).add(new Edge<T>(end,weight));
		if(!directed) {
			nodes.get(end).add(new Edge<T>(start,weight));
		}
	}
	
	public boolean hasVertex(T object) {
		if(nodes.containsKey(object)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean hasEdge(T init,T end) {
		if(nodes.get(init).contains(end)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public void Dijstra() {
		
	}
	
	public void Floyd() {
		
	}
	
}
