package model;

public class GraphAdjMatrix {
	private int[][] matrix;
	private boolean directed;
	
	public GraphAdjMatrix(boolean directed,int vertexAm) {
		this.directed = directed;
		matrix = new int[vertexAm][vertexAm];
	}
}
