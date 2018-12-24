package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RodCuttingProblem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] p = new int[n];
		for(int i=0;i<n;i++)
		{
			p[i] = Integer.parseInt(str[i]);
		}
		
		System.out.println("Maximum revenue : "+ RodCut(p,n));
		System.out.println("Maximum revenue top down dp : "+ RodCutTopDown(p,n));
		System.out.println("Maximum revenue bottom up dp : "+ RodCutBottomUp(p,n));

	}
	
	static int RodCut(int[] p,int n)
	{
		int max_revenue = Integer.MIN_VALUE;
		if(n<=0)
		{
			return 0;
		}
		else {
			for(int i=1;i<=n;i++)
			{
				max_revenue = Math.max(RodCut(p, n-i)+p[i-1], max_revenue);
			}
		}
		
		return max_revenue;
	}
	
	static int RodCutTopDown(int[] p,int n)
	{
		int[] dp = new int[n+1];
		return RodCutTopDownHelper(p,n,dp);
	}
	
	static int RodCutTopDownHelper(int[] p,int n,int[] dp)
	{
		if(n<=0)
		{
			return 0;
		}
		
		if(dp[n]==0)
		{
			for(int i=1;i<=n;i++)
			{
				dp[n] = Math.max(dp[n], RodCutTopDownHelper(p,n-i,dp)+p[i-1]);
			}
		}
		
		return dp[n];
	}
	
	static int RodCutBottomUp(int[] p,int n)
	{
		int[] dp = new int[n+1];
		dp[0] = 0;
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				dp[i] = Math.max(dp[i], dp[i-j]+p[j-1]);
			}
			
		}
		return dp[n];
	}
}
