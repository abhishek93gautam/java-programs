package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RustAndMurderer {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			String[] nm = br.readLine().trim().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			HashSet<Integer>[] adj = new HashSet[n+1];
			for(int z=1;z<=n;z++) {
				adj[z] = new HashSet<Integer>();
			}
			for(int j=0;j<m;j++) {
				String[] edge = br.readLine().trim().split(" ");
				int u = Integer.parseInt(edge[0]);
				int v = Integer.parseInt(edge[1]);
				
				adj[u].add(v);
				adj[v].add(u);
			}
			
			int s = Integer.parseInt(br.readLine().trim());
			int[] distance = getDistanceMatrix(adj,s,n);
			//System.out.println();
			for(int k=1;k<=n;k++) {
				if(k!=s) {
					System.out.print(distance[k]+" ");
				}
			}
			System.out.println();
		}
		
		

	}
	static int[] getDistanceMatrix(HashSet<Integer>[] adj,int source,int n) {
		int[] distance = new int[n+1];
		HashSet<Integer> unvisited = new HashSet<Integer>();
		for(int i=1;i<=n;i++) {
			distance[i] = Integer.MAX_VALUE;
			unvisited.add(i);
		}
		distance[source] = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(source);
		unvisited.remove((Object)source);
		while(!unvisited.isEmpty()) {
			int u = q.remove();
			HashSet<Integer> removeAll = new HashSet<Integer>();
			for (Iterator<Integer> iterator = unvisited.iterator(); iterator.hasNext();) {
				Integer i = iterator.next();
				if(!adj[u].contains(i)) {
					distance[i] = distance[u]+1;
					removeAll.add(i);
					q.add(i);
				}
			}
			unvisited.removeAll(removeAll);
			
		}
		
		return distance;
		
	}
}
