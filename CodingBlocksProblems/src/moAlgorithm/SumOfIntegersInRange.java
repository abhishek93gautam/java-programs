package moAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class SumOfIntegersInRange {
	
	static int n,m,blockSize;
	static int[] count,a,ans;
	static int res=0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		blockSize = (int)Math.sqrt(n);
		String[] str= br.readLine().split("\\s");
		a = new int[n];
		
		for(int i=0;i<n;i++)
		{
			a[i] = Integer.parseInt(str[i]);
		}
		
		count = new int[1000001];
		
		m = Integer.parseInt(br.readLine());
		Query[] q = new Query[m];
		for(int i=0;i<m;i++)
		{
			String[] str2 = br.readLine().split("\\s");
			q[i] = new Query(Integer.parseInt(str2[0]), Integer.parseInt(str2[1]), i);
		}
		
		ans = new int[m];
		
		Arrays.sort(q);
		int l=0; 
		int r=0;
		
		for(Query query : q)
		{
			while(l < query.l)
			{
				remove(l);
				l++;
			}
			
			while(l> query.l)
			{
				update(l);
				l--;
			}
			
			while(r <= query.r)
			{
				update(r);
				r++;
			}
			
			while(r > query.r+1)
			{
				remove(r);
				r--;
			}
			
			ans[query.index] = res; 
		}
		
		for(int i : ans)
		{
			System.out.print(i+" ");
		}
		

	}
	
	static void update(int i)
	{
		res+=a[i];
	}
	
	static void remove(int i)
	{
		res-= a[i];
	}
	static class Query implements Comparable<Query>
	{
		int l,r,index;
		Query(int l,int r,int index)
		{
			this.l=l;
			this.r=r;
			this.index = index;
		}

		@Override
		public int compareTo(Query o) {
			if(l/blockSize != o.l/blockSize)
			{
				return l/blockSize - o.l/blockSize;
			}
			return r-o.r;
		}
		
	}
	

}
