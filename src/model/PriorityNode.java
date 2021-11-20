package model;

public class PriorityNode<T> implements Comparable<PriorityNode<T>>{
	private T object;
	private int priority;
	
	public PriorityNode(T obj, int pri){
		setObject(obj);
		setPriority(pri);
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public int compareTo(PriorityNode<T> o) {
		if(priority > o.getPriority()) {
			return 1;
		}else if(priority < o.getPriority()){
			return -1;
		}else {
			return 0;			
		}
	}
	
	
}
