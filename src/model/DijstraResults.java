package model;

import java.util.Hashtable;

public class DijstraResults<T> {
	private Hashtable<T, Integer> dist;
	private Hashtable<T, T> prev;
	private T lastOne;
	
	public DijstraResults(Hashtable<T, Integer> dist, Hashtable<T, T> prev,T lastOne){
		this.setDist(dist);
		this.setPrev(prev);
		this.setLastOne(lastOne);
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

	public T getLastOne() {
		return lastOne;
	}

	public void setLastOne(T lastOne) {
		this.lastOne = lastOne;
	}
}
