package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class JackGoesToRapturePQ {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] gNodesEdges = br.readLine().replaceAll("\\s+$", "").split(" ");
        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);
        LinkedList<Pair<HeapNodePQ,Integer>>[] adj = new LinkedList[gNodes+1];
        for(int i=1;i<=gNodes;i++)
        {
            adj[i] = new LinkedList<Pair<HeapNodePQ,Integer>>();
        }
        for (int i = 0; i < gEdges; i++) {
            String[] edgesRowItems = br.readLine().split(" ");
            int u = Integer.parseInt(edgesRowItems[0]);
            int v = Integer.parseInt(edgesRowItems[1]);
            int w = Integer.parseInt(edgesRowItems[2]);
            if(adj[u]==null) {
            	adj[u] = new LinkedList<Pair<HeapNodePQ,Integer>>();
            }
            
            if(adj[v]==null) {
            	adj[v] = new LinkedList<Pair<HeapNodePQ,Integer>>();
            }

            Pair p1 = new Pair(new HeapNodePQ(v),w); 
            Pair p2 = new Pair(new HeapNodePQ(u),w);
            
            adj[u].add(p1);
            adj[v].add(p2);
            
        }

        getCost(adj,gNodes);

	}
	
	public static void getCost(LinkedList<Pair<HeapNodePQ,Integer>>[] adj,int gNodes) {
	    // Print your answer within the function and return nothing
	        long[] distance = new long[gNodes+1];
	        for(int i=1;i<=gNodes;i++) {
	        	distance[i] = Long.MAX_VALUE;
	        }
	        boolean[] visited = new boolean[gNodes+1];
	        distance[1] = 0;
	        PriorityQueue<HeapNodePQ> q = new PriorityQueue<HeapNodePQ>(gNodes,new HeapNodePQComparator());
	        q.add(new HeapNodePQ(1,0));
	        while(!q.isEmpty()){
	        	HeapNodePQ extractedNode = q.poll();
	            long u = extractedNode.distance;
	            int vertex = extractedNode.vertex;
	            visited[vertex] = true;
	            
	            for(Pair<HeapNodePQ,Integer> neighBor : adj[vertex]){
	                long newDistance = neighBor.getValue() - u;
	                if(newDistance<0){
	                    newDistance = 0;
	                }

	                if(!visited[neighBor.getKey().vertex] && u+newDistance < neighBor.getKey().distance ){
	                	neighBor.getKey().distance = u+newDistance;
	                	if(distance[neighBor.getKey().vertex]>neighBor.getKey().distance) {
	                		distance[neighBor.getKey().vertex]=neighBor.getKey().distance;
	                	}
	                	q.add(neighBor.getKey());
	                }
	            }
	        }
	        if(distance[gNodes]!=Long.MAX_VALUE) {
	        	System.out.println(distance[gNodes]);
	        }
	        else {
	        	System.out.println("NO PATH EXISTS");
	        }
	        
	    }
	    
}

class HeapNodePQ implements Comparable<HeapNodePQ>{
	int vertex;
	long distance;
	
	public HeapNodePQ(int vertex)
    {
		this.vertex = vertex;
		distance = Long.MAX_VALUE;
    }
	
	public HeapNodePQ(int vertex,long distance)
    {
		this.vertex = vertex;
		this.distance = distance;
    }
	
	@Override
	public int compareTo(HeapNodePQ arg1) {
		if(this.distance > arg1.distance)
			return 1;
		else if(this.distance < arg1.distance)
			return -1;
		return 0;
	}

}

class HeapNodePQComparator implements Comparator<HeapNodePQ>{

	@Override
	public int compare(HeapNodePQ arg0, HeapNodePQ arg1) {
		if(arg0.distance > arg1.distance)
			return 1;
		else if(arg0.distance < arg1.distance)
			return -1;
		return 0;
	}
	
}
