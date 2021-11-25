package model;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class GraphAdjListTest {
	
	ArrayList<Atracction> atracctionsList;
	GraphAdjList<Atracction> park;
	Atracction g1,g2,g3;
	
	public void setupScenary1() {
		atracctionsList = new ArrayList<>();
		park = new GraphAdjList<Atracction>(false);
		g1 = new Atracction("Ciclon", 25, 10);
		g2 =new Atracction("Cumbre", 40, 45);
		g3 = new Atracction("Rapidos", 30, 25);
		atracctionsList.add(g1);
		atracctionsList.add(g2);
		atracctionsList.add(g3);
		park.addVertex(g1);
		park.addVertex(g2);
		park.addVertex(g3);
		park.addEdge(g1, g2, 12);
	}
	
	@Test
	void testAddVertex() {
		setupScenary1();
		assertEquals(park.getNodesAmount(),3);
		atracctionsList.add(new Atracction("Caballos", 10, 15));
		park.addVertex(new Atracction("Caballos", 10, 15));
		assertEquals(park.getNodesAmount(),4);
	}
	
	@Test
	void testAddEdge() {
		setupScenary1();
		park.addEdge(g2, g3, 38);
		park.addEdge(g3, g1, 50);
		assertEquals(park.getNodes().get(g1).get(0).getWeight(),12);
		assertEquals(park.getNodes().get(g1).get(1).getWeight(),50);
		assertEquals(park.getNodes().get(g2).get(0).getWeight(),12);
		assertEquals(park.getNodes().get(g2).get(1).getWeight(),38);
		assertEquals(park.getNodes().get(g3).get(0).getWeight(),38);
		assertEquals(park.getNodes().get(g3).get(1).getWeight(),50);

	}
	
	@Test
	void djistraTest() {
		setupScenary1();
		park.addEdge(g2, g3, 38);
		park.addEdge(g3, g1, 50);
		assertEquals(park.Dijstra(g1, atracctionsList).getDist().get(g1),0);
		assertEquals(park.Dijstra(g1, atracctionsList).getDist().get(g2),12);
		assertEquals(park.Dijstra(g1, atracctionsList).getDist().get(g3),50);
	}
	
	@Test
	void floydTest() {
		setupScenary1();
		park.addEdge(g2, g3, 38);
		park.addEdge(g3, g1, 50);
		int[][] a = park.Floyd();
		assertEquals(a[0][0],0);
	}

}
