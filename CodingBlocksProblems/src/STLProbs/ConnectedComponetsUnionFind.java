package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConnectedComponetsUnionFind {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Subset[] subset = new Subset[2*n+1];
		for(int i=1;i<=2*n;i++) {
			subset[i] = new Subset();
			subset[i].rank=1;
			subset[i].parent=i;
		}
		
		for(int i=0;i<n;i++) {
			String[] edge = br.readLine().split(" ");
			Edge e = new Edge();
			e.src = Integer.parseInt(edge[0]);
			e.dest = Integer.parseInt(edge[1]);
			
			int x = find(subset,e.src);
			int y = find(subset,e.dest);
			if(x==y) {
				continue;
			}
			Union(subset,x,y);
		}
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=2*n;i++) {
			if(subset[i].rank!=1) {
				if(subset[i].rank<min) {
					min = subset[i].rank;
				}
				if(subset[i].rank>max) {
					max = subset[i].rank;
				}
			}
		}
		
//		for(int i=1;i<=2*n;i++) {
//			System.out.println(subset[i].rank);
//		}
		
		System.out.print(min+" "+max);

	}
	
	static int find(Subset[] subset,int i) {
		if(subset[i].parent!=i) {
			subset[i].parent = find(subset,subset[i].parent);
		}
		return subset[i].parent;
	}
	
	static void Union(Subset[] subset,int x,int y) {
		int xroot = find(subset,x);
		int yroot = find(subset,y);
		
		if(subset[xroot].rank<subset[yroot].rank) {
			subset[xroot].parent = yroot;
			subset[yroot].rank += subset[xroot].rank;
			subset[xroot].rank=1;
		}
		else if(subset[xroot].rank>subset[yroot].rank)
		{
			subset[yroot].parent = xroot;
			subset[xroot].rank += subset[yroot].rank;
			subset[yroot].rank=1;
		}
		else {
			subset[xroot].parent = yroot; 
	        subset[yroot].rank+=subset[xroot].rank; 
	        subset[xroot].rank=1;
		}
	}
	
	
	
}

class Edge{
	int src,dest;
}

class Subset{
	int rank;
	int parent;
	
}
