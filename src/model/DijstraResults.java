package model;

import java.util.Hashtable;

public class DijstraResults<T> {
	private Hashtable<T, Integer> dist;
	private Hashtable<T, T> prev;
	
	public DijstraResults(Hashtable<T, Integer> dist, Hashtable<T, T> prev){
		this.setDist(dist);
		this.setPrev(prev);
	}

	public Hashtable<T, Integer> getDist() {
		return dist;
	}

	public void setDist(Hashtable<T, Integer> dist) {
		this.dist = dist;
	}

	public Hashtable<T, T> getPrev() {
		return prev;
	}

	public void setPrev(Hashtable<T, T> prev) {
		this.prev = prev;
	}
}
