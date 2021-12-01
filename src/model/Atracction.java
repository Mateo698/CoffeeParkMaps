package model;

public class Atracction implements Comparable<Atracction>{
	private String name;
	private int averagePeople;
	private int averageMinutes;
	
	
	public Atracction(String name, int averagePeople, int averageMinutes) {
		this.name = name;
		this.averagePeople = averagePeople;
		this.averageMinutes = averageMinutes;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAveragePeople() {
		return averagePeople;
	}


	public void setAveragePeople(int averagePeople) {
		this.averagePeople = averagePeople;
	}


	public int getAverageMinutes() {
		return averageMinutes;
	}


	public void setAverageMinutes(int averageMinutes) {
		this.averageMinutes = averageMinutes;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
