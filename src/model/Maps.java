package model;

import java.util.ArrayList;
import java.util.List;

public class Maps {
	
	private ArrayList<Atracction> atracctionsList;

	private GraphAdjList<Atracction> park;
	
	public Maps() {
		park = new GraphAdjList<Atracction>();
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
		atracctionsList.add(new Atracction("Entrada", 0, 0));	//17
		
		park.add(atracctionsList.get(14), atracctionsList.get(12), 5);
		park.add(atracctionsList.get(14), atracctionsList.get(13), 10);
		park.add(atracctionsList.get(14), atracctionsList.get(15), 5);
		park.add(atracctionsList.get(13), atracctionsList.get(12), 7);
		park.add(atracctionsList.get(12), atracctionsList.get(15), 10);
		park.add(atracctionsList.get(13), atracctionsList.get(15), 10);
		park.add(atracctionsList.get(15), atracctionsList.get(0), 5);
		park.add(atracctionsList.get(15), atracctionsList.get(1), 5);
		park.add(atracctionsList.get(0), atracctionsList.get(1), 3);
		park.add(atracctionsList.get(15), atracctionsList.get(3), 9);
		park.add(atracctionsList.get(15), atracctionsList.get(2), 7);
		park.add(atracctionsList.get(3), atracctionsList.get(2), 5);
		park.add(atracctionsList.get(3), atracctionsList.get(4), 7);
		park.add(atracctionsList.get(2), atracctionsList.get(4), 7);
		park.add(atracctionsList.get(4), atracctionsList.get(5), 5);
		park.add(atracctionsList.get(5), atracctionsList.get(9), 10);
		park.add(atracctionsList.get(9), atracctionsList.get(10), 5);
		park.add(atracctionsList.get(9), atracctionsList.get(11), 5);
		park.add(atracctionsList.get(10), atracctionsList.get(11), 5);
		park.add(atracctionsList.get(5), atracctionsList.get(16), 9);
		park.add(atracctionsList.get(16), atracctionsList.get(6), 5);
		park.add(atracctionsList.get(16), atracctionsList.get(7), 5);
		park.add(atracctionsList.get(16), atracctionsList.get(8), 5);
		park.add(atracctionsList.get(6), atracctionsList.get(7), 4);
		park.add(atracctionsList.get(7), atracctionsList.get(8), 4);
		park.add(atracctionsList.get(15), atracctionsList.get(16), 10);
		park.add(atracctionsList.get(17), atracctionsList.get(0), 20);
		park.add(atracctionsList.get(17), atracctionsList.get(1), 10);
	}
	
	
	public GraphAdjList<Atracction> getPark() {
		return park;
	}

	public ArrayList<Atracction> getAtracctionsList() {
		return atracctionsList;
	}

	public ArrayList<String> getPath(Atracction src, ArrayList<Atracction> desiredAt) {
		ArrayList<String> path = new ArrayList<>();
		for(int i = 0;i<desiredAt.size();i++) {
			List<String> subPath = park.getPath(src, desiredAt.get(i));
			for (int j = 0; j < subPath.size(); j++) {
				path.add(subPath.get(j));
			}
			src = desiredAt.get(i);
		}
		return path;
	}

	
}
