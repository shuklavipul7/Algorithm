package customgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/*We are creating a graph of cities here
 * We will connect the cities by road network
 * If a road is created between any two cities, it will be a Bi-directional road
 * Hence we are implementing Un-Directed Graph here*/
public class CityRoadsGraph {
	
	class CityMap{
		Map<String, LinkedList<String>>mapOfCities;
	}
	
	public CityMap initializeCityMap(List<String> cityList){
		CityMap cityMap=new CityMap();
		cityMap.mapOfCities=new HashMap<>();
		for(String cityName : cityList)
			cityMap.mapOfCities.put(cityName, new LinkedList());
		return cityMap;	
	}
	
	public void createRoadBetweenCities(CityMap mapOfCities, String sourceCity, String destinationCity){
		for(String cityName : mapOfCities.mapOfCities.keySet()){
			if(cityName.equals(sourceCity)){
				LinkedList linkedCities = mapOfCities.mapOfCities.get(cityName);
				linkedCities.addFirst(destinationCity);
			}else if(cityName.equals(destinationCity)){
				LinkedList linkedCities = mapOfCities.mapOfCities.get(cityName);
				linkedCities.addFirst(sourceCity);
			}
		}
	}
	
	public void printRoadGraph(CityMap cityMap){
		for(String cityName : cityMap.mapOfCities.keySet()){
			System.out.println(cityName +" ==> "+cityMap.mapOfCities.get(cityName));
		}
	}

	public static void main(String[] args) {
		CityRoadsGraph cityRoadsGraph = new CityRoadsGraph();
		
		List listOfCities=new ArrayList<String>();
		listOfCities.add("Delhi");
		listOfCities.add("Kanpur");
		listOfCities.add("Lucknow");
		listOfCities.add("Ranchi");
		listOfCities.add("Banglore");
		CityMap cityMap = cityRoadsGraph.initializeCityMap(listOfCities);
		cityRoadsGraph.printRoadGraph(cityMap);
		System.out.println("===============");
		cityRoadsGraph.createRoadBetweenCities(cityMap, "Delhi", "Kanpur");
		cityRoadsGraph.createRoadBetweenCities(cityMap, "Delhi", "Banglore");
		cityRoadsGraph.createRoadBetweenCities(cityMap, "Delhi", "Ranchi");
		cityRoadsGraph.createRoadBetweenCities(cityMap, "Delhi", "Lucknow");
		cityRoadsGraph.createRoadBetweenCities(cityMap, "Kanpur", "Lucknow");
		cityRoadsGraph.printRoadGraph(cityMap);
	}

}
