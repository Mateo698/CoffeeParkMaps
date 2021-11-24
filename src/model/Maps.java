package model;

import java.util.ArrayList;

public class Maps {
	
	private ArrayList<Atracction> atracctionsList;
	private GraphAdjList<Atracction> park;
	
	public Maps() {
		park = new GraphAdjList<>(false);
		atracctionsList = new ArrayList<>();
		atracctionsList.add(new Atracction("Ciclon", 0, 0));			//0
		atracctionsList.add(new Atracction("Karts Dobles", 0, 0));		//1
		atracctionsList.add(new Atracction("Montana Acuatica", 0, 0));	//2
		atracctionsList.add(new Atracction("Montana Rusa", 0, 0));		//3
		atracctionsList.add(new Atracction("Karts", 0, 0));				//4
		atracctionsList.add(new Atracction("Cumbre", 0, 0));			//5
		atracctionsList.add(new Atracction("Botes Chocones", 0, 0));	//6
		atracctionsList.add(new Atracction("Carros Chocones", 0, 0));	//7
		atracctionsList.add(new Atracction("Caballos", 0, 0));			//8
		atracctionsList.add(new Atracction("Rapidos", 0, 0));			//9
		atracctionsList.add(new Atracction("Yipe", 0, 0));				//10
		atracctionsList.add(new Atracction("Krater", 0, 0));			//11
		atracctionsList.add(new Atracction("Bosque de mitos", 0, 0));	//12
		atracctionsList.add(new Atracction("Cafetal tradicional", 0, 0));//13
		atracctionsList.add(new Atracction("Museo del cafe", 0, 0));	//14
		atracctionsList.add(new Atracction("Estacion tren plaza", 0, 0));//15
		atracctionsList.add(new Atracction("Estacion tren caballos", 0, 0));	//16
		for (int i = 0; i < atracctionsList.size(); i++) {
			park.addVertex(atracctionsList.get(i));
		}
		park.addEdge(atracctionsList.get(14), atracctionsList.get(12), 5);
		park.addEdge(atracctionsList.get(14), atracctionsList.get(13), 10);
		park.addEdge(atracctionsList.get(14), atracctionsList.get(15), 5);
		park.addEdge(atracctionsList.get(13), atracctionsList.get(12), 7);
		park.addEdge(atracctionsList.get(12), atracctionsList.get(15), 10);
		park.addEdge(atracctionsList.get(13), atracctionsList.get(15), 10);
		park.addEdge(atracctionsList.get(15), atracctionsList.get(0), 5);
		park.addEdge(atracctionsList.get(15), atracctionsList.get(1), 5);
		park.addEdge(atracctionsList.get(0), atracctionsList.get(0), 0);
		park.addEdge(atracctionsList.get(0), atracctionsList.get(0), 0);
		park.addEdge(atracctionsList.get(0), atracctionsList.get(0), 0);
		park.addEdge(atracctionsList.get(0), atracctionsList.get(0), 0);
		park.addEdge(atracctionsList.get(0), atracctionsList.get(0), 0);
		park.addEdge(atracctionsList.get(0), atracctionsList.get(0), 0);
		park.addEdge(atracctionsList.get(0), atracctionsList.get(0), 0);
		park.addEdge(atracctionsList.get(0), atracctionsList.get(0), 0);
		park.addEdge(atracctionsList.get(0), atracctionsList.get(0), 0);
		
	}
}
