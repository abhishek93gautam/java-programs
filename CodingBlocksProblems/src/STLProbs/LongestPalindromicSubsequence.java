package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n=str.length();
		int[][] dp = new int[n][n];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				dp[i][j]=-1;
			}
		}
		
		System.out.println("Longest palindromic subseq top down : "+SubSeq(str,0,n-1,dp));
		System.out.println("Longest palindromic subseq bottom up : "+SubSeqBottomUp(str));

	}
	
	public static int SubSeq(String seq,int i,int j,int[][] dp)
	{
		if(i>j)
		{
			return 0;
		}
		if(i==j)
		{
			return 1;
		}
		
		if(dp[i][j]!=-1)
		{
			return dp[i][j];
		}
		if(seq.charAt(i)==seq.charAt(j))
		{
			dp[i][j] = 2 + SubSeq(seq,i+1,j-1,dp);
		}
		else {
			dp[i][j] = Math.max(SubSeq(seq,i,j-1,dp), SubSeq(seq,i+1,j,dp));
		}
		
		return dp[i][j];
	}
	
	static int SubSeqBottomUp(String str)
	{
		int n = str.length();
		int[][] dp = new int[n][n];
		
		//For length 1 - Every character is palindromic subseq of length 1
		for(int i=0;i<n;i++)
		{
			dp[i][i] = 1;
		}
		
		// Check for each length
		for(int k=2;k<=n;k++)
		{
			for(int i=0;i<=(n-k);i++)
			{
				int j = k+i-1;
				if(k==2 && str.charAt(i)==str.charAt(j))
				{
					dp[i][j] = 2;
				}
				else {
					if(str.charAt(i)==str.charAt(j))
					{
						dp[i][j] = 2+dp[i+1][j-1];
					}
					else {
						dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
					}
				}
			}
		}
		
		print(dp);
		return dp[0][n-1];
	}
	
	static void print(int[][] dp)
	{
		for(int i=0;i<dp.length;i++)
		{
			for(int j=0;j<dp[0].length;j++)
			{
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}

}
