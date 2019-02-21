package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSConnectedComponents {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Graph g = new Graph(2*n);
		for (int i = 0; i < n; i++) {
			String[] edge = br.readLine().split(" ");
			g.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
		}
		
		g.connectedComponents();

	}

}

class Graph{
	private static final String ArrayList = null;
	int V;
	LinkedList<Integer>[] adj;
	
	Graph(int v){
		this.V=v;
		adj = new LinkedList[V];
		
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	void addEdge(int src,int des) {
		adj[src-1].add(des-1);
		adj[des-1].add(src-1);
	}
	
	void connectedComponents() {
		ArrayList<Integer> lst = new ArrayList<>();
		boolean[] visited = new boolean[V];
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				int count=DFSUtil(i,visited);
				if(count!=1)
				{
					lst.add(count);
				}
			}
			
		}
		int max=0;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<lst.size();i++)
		{
			if(lst.get(i)>max) {
				max=lst.get(i);
			}
			if(lst.get(i)<min) {
				min=lst.get(i);
			}
		}
		
		System.out.println(min+" "+max);
	}
	
	int DFSUtil(int v,boolean[] visited) {
		visited[v] = true;
		//System.out.print(v+" ");
		int count=1;
		for(int x:adj[v]) {
			if(!visited[x]) {
				count+=DFSUtil(x,visited);
			}
		}
		return count;
	}
}