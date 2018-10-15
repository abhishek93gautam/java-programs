package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DPBlockedGrid {

	static int[][] dp = new int[1001][1001];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("\\s");
		int m = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		int p= Integer.parseInt(str[2]);
		
		for(int i=0;i<p;i++)
		{
			String[] str1 = br.readLine().split("\\s");
			int x = Integer.parseInt(str1[0]);
			int y = Integer.parseInt(str1[1]);
			dp[x-1][y-1]=-1;
			
		}
		
		System.out.println(NumOfWays(m,n,dp));
//		for(int i=0;i<m;i++)
//		{
//			for(int j=0;j<n;j++)
//			{
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
		

	}
	
	public static int NumOfWays(int m,int n,int[][] dp)
	{
		//Initial block is blocked
		if(dp[0][0]==-1)
		{
			return 0;
		}
		
		//Number of ways for first row
		for(int j=0;j<n;j++)
		{
			if(dp[0][j]==-1)
			{
				break;
			}
			dp[0][j]=1;
		}
		
		//Number of ways for first column
		for(int i=0;i<m;i++)
		{
			if(dp[i][0]==-1)
			{
				break;
			}
			dp[i][0]=1;
		}
		
		for(int i=1;i<m;i++)
		{
			for(int j=1;j<n;j++)
			{
				if(dp[i][j]==-1)
				{
					continue;
				}
				
				if(dp[i][j-1]!=-1)
				{
					dp[i][j]+=dp[i][j-1];
				}
				
				if(dp[i-1][j]!=-1)
				{
					dp[i][j]+=dp[i-1][j];
				}
			}
		}
		
		if(dp[m-1][n-1]==-1)
		{
			return 0;
		}
		return dp[m-1][n-1];
	}

}
