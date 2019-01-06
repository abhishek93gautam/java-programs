package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixChainMultiplication {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] p= new int[n+1];
		String[] str = br.readLine().split(" ");
		for(int i=0;i<=n;i++)
		{
			p[i] = Integer.parseInt(str[i]);
		}
		
		System.out.println("Minimum cost for matrix multiplication is : "+Matrix_Chain(p,1,n));
		System.out.println("Minimum cost for matrix multiplication top down is : "+Matrix_ChainTopDown(p,1,n));
		System.out.println("Minimum cost for matrix multiplication bottom up is : "+Matrix_ChainBottomUp(p,n));

	}
	
	static int Matrix_Chain(int[] p,int i,int j)
	{
		int min_cost = Integer.MAX_VALUE;
		if(i==j)
		{
			return 0;
		}
		else {
			for(int k=i;k<j;k++)
			{
				min_cost = Math.min(min_cost, Matrix_Chain(p,i,k)+Matrix_Chain(p,k+1,j)+(p[i-1]*p[k]*p[j]));
			}
		}
		
		return min_cost;
		
	}
	
	static int Matrix_ChainTopDown(int[] p,int i,int j)
	{
		int[][] dp=new int[j+1][j+1];
		return Matrix_ChainTopDownHelper(p,i,j,dp);
	}
	
	static int Matrix_ChainTopDownHelper(int[] p,int i,int j,int[][] dp)
	{
		int min_cost = Integer.MAX_VALUE;
		if(dp[i][j]!=0)
		{
			return dp[i][j];
		}
		
		if(i==j)
		{
			return 0;
		}
		else 
		{
			for(int k=i;k<j;k++)
			{
				min_cost = Math.min(min_cost, Matrix_ChainTopDownHelper(p,i,k,dp)+Matrix_ChainTopDownHelper(p,k+1,j,dp)+(p[i-1]*p[k]*p[j]));
			}
			dp[i][j] = min_cost;
		}
		return min_cost;
	}
	
	static int Matrix_ChainBottomUp(int[] p,int n)
	{
		int[][] dp = new int[n+1][n+1];
		
		int min_cost = Integer.MAX_VALUE;
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=n;j++)
			{
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i=1;i<=n;i++)
		{
			dp[i][i] = 0;
		}
		
		// calculate for length start from 2
		for(int l=2;l<=n;l++)
		{
			for(int i=1;i<=(n-l+1);i++)
			{
				int j = i+l-1;
				for(int k=i;k<j;k++)
				{
					dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+(p[i-1]*p[k]*p[j]));
				}
			}
		}
		
		return dp[1][n];
	}

}
