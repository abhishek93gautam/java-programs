package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JeanieRoutes {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		
		int[] dests = new int[k];
		String[] kdests = br.readLine().split(" ");
		for(int i=0;i<k;i++) {
			dests[i] = Integer.parseInt(kdests[i]);
		}
		ArrayList<CityNode> cities = new ArrayList<CityNode>(n+1);
		for(int i=0;i<=n;i++) {
			cities.add(0,new CityNode());
		}
		for(int i=1;i<n;i++) {
			String[] edge = br.readLine().split(" ");
			int u = Integer.parseInt(edge[0]);
			int v = Integer.parseInt(edge[1]);
			int d = Integer.parseInt(edge[2]);
			
			CityNode getNode1 = cities.get(u);
			getNode1.roads.add(new Distance(v, d));
			
			CityNode getNode2 = cities.get(v);
			getNode2.roads.add(new Distance(u, d));
		}
		
		for(int i : dests) {
			CityNode node = cities.get(i);
			node.visit = true;
		}
		
		IntegerObj total = new IntegerObj(0);
		MarkNodesWithInPath(cities,dests[0],total);
		clearCities(cities);
		Distance d1 = LongestDiameter(cities, dests[0], 0);
		clearCities(cities);
		Distance d2 = LongestDiameter(cities, d1.destination, 0);
		System.out.println(2*total.value - d2.distance);
		
	}
	
	// It marks nodes which are non-letter also in to be visit list and adds distance in total
	static boolean MarkNodesWithInPath(ArrayList<CityNode> cities,int current,IntegerObj total) {
		CityNode currentNode = cities.get(current);
		boolean found = false;
		currentNode.visited = true;
		
		for(Distance road : currentNode.roads) {
			CityNode destination = cities.get(road.destination);
			if(!destination.visited) {
				if(MarkNodesWithInPath(cities,road.destination,total)) {
					destination.visit = true;
					total.value+=road.distance;
					found=true;
				}
			}
			
		}
		
		return found || currentNode.visit;
	}
	
	static Distance LongestDiameter(ArrayList<CityNode> cities,int current,int total) {
		CityNode currentNode = cities.get(current);
		Distance max = new Distance(current, total);
		currentNode.visited = true;
		
		for(Distance road : currentNode.roads) {
			CityNode destination = cities.get(road.destination);
			if(!destination.visited && destination.visit) {
				Distance distance = LongestDiameter(cities,road.destination,total+road.distance);
				if(distance.distance>max.distance) {
					max=distance;
				}
			}
		}
		
		return max;
	}
	
	// Clear citites to calculate the diameter
	static void clearCities(ArrayList<CityNode> cities)
	{
		for(CityNode node : cities) {
			node.visited = false;
		}
	}

}

class Distance{
	int destination;
	int distance;
	Distance(int destination,int distance){
		this.destination=destination;
		this.distance=distance;
	}
}

class CityNode{
	LinkedList<Distance> roads = new LinkedList<Distance>();
	boolean visit=false;
	boolean visited=false;
}

class IntegerObj {
    int value;
    IntegerObj(int val) {
        this.value = val;
    }
}