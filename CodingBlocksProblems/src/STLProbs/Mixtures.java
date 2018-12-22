package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mixtures {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split("\\s");
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = Integer.parseInt(str[i]);
		}
		
		long[][] dp = new long[n+1][n+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=n;j++)
			{
				dp[i][j]=-1;
			}
		}
		
		System.out.println("Min cost top down: "+NoOfWays(arr,0,n-1,dp));
		System.out.println("Min cost bottom down: "+MinCostMixturesBottomUp(arr,n));

	}
	
	public static long NoOfWays(int[] arr,int i,int j,long[][] dp)
	{
		if(i>=j)
		{
			return 0;
		}
		
		if(dp[i][j]!=-1)
		{
			return dp[i][j];
		}
		
		dp[i][j]= Long.MAX_VALUE;
		for(int k=i;k<j;k++)
		{
			dp[i][j] = Math.min(dp[i][j], NoOfWays(arr,i,k,dp)+NoOfWays(arr,k+1,j,dp)+(sum(i,k,arr)*sum(k+1,j,arr)));
		}
		
		return dp[i][j];
	}
	
	public static long sum(int s,int e,int[] arr)
	{
		long sum=0;
		for(int z=s;z<=e;z++)
		{
			sum+=arr[z];
			//sum%=100;
		}
		return sum;
	}
	
	public static long MinCostMixturesBottomUp(int[] arr,int n)
	{
		long[][] dp = new long[n][n];
		
		//Make the cummulative sum array
		long[] sum = new long[n];
		sum[0] = arr[0];
		for(int i=1;i<n;i++)
		{
			sum[i] = (sum[i-1]+arr[i]);
		}
		//System.out.println("Working fine");
		for(int i=n-1;i>=0;i--)
		{
			for(int j=0;j<n;j++)
			{
				if(i<j)
				{
					dp[i][j] = Long.MAX_VALUE;
					for(int k=i;k<j;k++)
					{
						long sumLeft = (sum[k] - ((i-1)>0?sum[i-1]:0));
						long sumRight = (sum[j]-sum[k]);
						//System.out.println(sumLeft+" "+sumRight);
						dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + (sumLeft*sumRight));
					}
				}
				
			}
		}
		
		return dp[0][n-1];
	}
	
	
	
}
