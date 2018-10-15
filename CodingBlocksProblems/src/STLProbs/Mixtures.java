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
		
		System.out.print(NoOfWays(arr,0,n-1,dp));

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
			sum%=100;
		}
		
		return sum;
	}
	
	
	
}
