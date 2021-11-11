package model;

import java.util.Hashtable;

public class Graph<K,V> {
	private Hashtable<K, V> nodes;
	private boolean directed;
	
	public Graph() {
		nodes = new Hashtable<K,V>();
	}
	
	public void addVertex(K key, V value) {
		nodes.put(key, value);
	}
	
	
	
}
