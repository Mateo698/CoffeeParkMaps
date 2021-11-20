package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

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
	
	
	public void Dijstra(T src,ArrayList<T> keys) {
		Hashtable<T, Integer> dist = new Hashtable<>();
		dist.put(src, 0);
		for (int i = 1; i < keys.size(); i++) {
			dist.put(keys.get(i), Integer.MAX_VALUE);
		}
		PriorityQueue<PriorityNode<T>> pq = new PriorityQueue<PriorityNode<T>>();
		for (int i = 0; i < keys.size(); i++) {
			pq.add(new PriorityNode<T>(keys.get(i),dist.get(keys.get(i))));
		}
		Hashtable<T, T> prev = new Hashtable<>();
		for (int i = 0; i < keys.size(); i++) {
			prev.put(keys.get(i), null);
		}
		
		
		while(!pq.isEmpty()) {
			PriorityNode<T> u = pq.poll();
		}
		
	}
	
	public void Floyd() {
		
	}
	
}
