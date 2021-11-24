package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class GraphAdjList<T> {
	private Hashtable<T,LinkedList<Edge<T>>> nodes;
	private ArrayList<T> keys;
	private boolean directed;
	
	public GraphAdjList(boolean directed) {
		nodes = new Hashtable<T,LinkedList<Edge<T>>>();
		this.directed = directed;
		keys = new ArrayList<T>();
	}
	
	public void addVertex(T object) {
		nodes.put(object,new LinkedList<Edge<T>>());
		keys.add(object);
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
		for (int i = 0; i < keys.size(); i++) {
			if(keys.get(i)!=src) {
				dist.put(keys.get(i), Integer.MAX_VALUE);				
			}
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
			LinkedList<Edge<T>> adjNodes = nodes.get(u.getObject());
			for (int i = 0; i < adjNodes.size(); i++) {
				T v = adjNodes.get(i).getValue();
				int alt = dist.get(u.getObject()) + adjNodes.get(i).getWeight();
				if(alt<dist.get(v)) {
					dist.put(v, alt);
					prev.put(v, u.getObject());
					pq = updateQueue(pq);
				}
			}
		}
		
	}
	
	public void Floyd() {
		int dist[][] = new int[nodes.keySet().size()][nodes.keySet().size()];
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist.length; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < dist.length; i++) {
			dist[i][i] = 0;
		}
		for (int i = 0; i < dist.length; i++) {
			LinkedList<Edge<T>> edges = nodes.get(keys.get(i));
			for (int j = 0; j < edges.size(); j++) {
				int posJ = keys.indexOf(edges.get(j));
				dist[i][posJ] = edges.get(j).getWeight();
			} 
		}
		for (int k = 0;  k< dist.length; k++) {
			for (int i = 0; i < dist.length; i++) {
				for (int j = 0; j < dist.length; j++) {
					if(dist[i][j]>(dist[i][k]+dist[k][j])) {
						dist[i][j] = dist[i][k]+dist[k][j];
					}
				}
			}
		}
	}
	
	
	private PriorityQueue<PriorityNode<T>> updateQueue(PriorityQueue<PriorityNode<T>> queue){
		ArrayList<PriorityNode<T>> list = new ArrayList<>();
		while(!queue.isEmpty()) {
			list.add(queue.poll());
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			queue.add(list.get(i));
		}
		return queue;
	}
}
