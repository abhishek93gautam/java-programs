package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnapSack {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = br.readLine().split(" ");
		int s = Integer.parseInt(str1[0]);
		int n = Integer.parseInt(str1[1]);
		
		int[] w = new int[n];  // weight array
		int[] p = new int[n];  // profit array
		
		for(int i=0;i<n;i++)
		{
			String[] str = br.readLine().split(" ");
			w[i] = Integer.parseInt(str[0]);
			p[i] = Integer.parseInt(str[1]);
		}
		
		System.out.println("Maximum Knapsack profit is : "+maxProfit(s,n,w,p));
		System.out.println("Maximum Knapsack profit top down is : "+maxProfitTopDown(s,n,w,p));
		System.out.println("Maximum Knapsack profit bottom up is : "+maxProfitBottomUpHelper(s,n,w,p));
	}
	
	static int maxProfit(int s,int n,int[] w,int[] p)
	{
		if(n==0 || s==0)
		{
			return 0;
		}
		else if(w[n-1]>s){
			return maxProfit(s,n-1,w,p);
		}
		else {
			return Math.max(maxProfit(s,n-1,w,p),maxProfit(s-w[n-1],n-1,w,p)+p[n-1]);
		}
		
	}
	
	static int maxProfitTopDown(int s,int n,int[] w,int[] p)
	{
		int[][] dp= new int[n+1][s+1];
		return maxProfitTopDownHelper(s,n,w,p,dp);
	}
	
	static int maxProfitTopDownHelper(int s,int n,int[] w,int[] p,int[][] dp)
	{
		if(s==0 || n==0)
		{
			return 0;
		}
		
		if(dp[n][s]==0)
		{
			if(w[n-1]>s)
			{
				dp[n][s] = maxProfitTopDownHelper(s,n-1,w,p,dp);
			}
			else {
				dp[n][s] = Math.max(maxProfitTopDownHelper(s,n-1,w,p,dp),maxProfitTopDownHelper(s-w[n-1],n-1,w,p,dp)+p[n-1]);
			}
		}
		
		return dp[n][s];
	}
	
	static int maxProfitBottomUpHelper(int s,int n,int[] w,int[] p)
	{
		int[][] dp = new int[n+1][s+1];
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=s;j++)
			{
				if(w[i-1]>j)
				{
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]]+p[i-1]);
				}
			}
		}
		//printDp(dp);
		return dp[n][s];
		
	}
	
	static void printDp(int[][] dp)
	{
		for(int i=1;i<dp.length;i++)
		{
			for(int j=1;j<dp[0].length;j++)
			{
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}

}
