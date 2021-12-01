package model;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class GraphAdjListTest {
	private Maps park;
	public void setupScenary1() {
		park = new Maps();
	}
	
	@Test
	void testAddVertex() {
		setupScenary1();
		assertEquals(park.getAtracctionsList().size(),18);
		assertEquals(park.getPark().getVertices().size(),18);
		Atracction at=new Atracction("Salida", 10, 15);
		park.getAtracctionsList().add(at);
		park.getPark().add(at,park.getAtracctionsList().get(1),10);
		assertEquals(park.getAtracctionsList().size(),19);
		assertEquals(park.getPark().getVertices().size(),19);
		assertEquals(park.getAtracctionsList().get(18).getName(),"Salida");
	}
	
	@Test
	void pathTest() {
		setupScenary1();
		Atracction temp1= park.getAtracctionsList().get(0);
		Atracction temp2= park.getAtracctionsList().get(5);
		assertEquals(park.getPark().getPath(temp1, temp2).size(),3);
		temp1= park.getAtracctionsList().get(0);
		temp2= park.getAtracctionsList().get(10);
		assertEquals(park.getPark().getPath(temp1, temp2).size(),5);
	}
	
	@Test
	void getShortestPathTest() {
		setupScenary1();
		ArrayList<Atracction> at = new ArrayList<>();
		at.add(new Atracction("Karts Dobles", 0, 0));
		at.add(new Atracction("Ciclon", 0, 0));
		at.add(new Atracction("Karts", 0, 0));
		assertEquals(park.getPath(park.getAtracctionsList().get(17),at).size(),8);
	}
	
	


}
