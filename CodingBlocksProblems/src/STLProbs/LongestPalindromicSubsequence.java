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
		
		System.out.print(SubSeq(str,0,n-1,dp));

	}
	
	public static int SubSeq(String seq,int i,int j,int[][] dp)
	{
		if(dp[i][j]!=-1)
		{
			return dp[i][j];
		}
		
		else if(i==j)
		{
			dp[i][j]=1;
		}
		else if(i==j-1 && seq.charAt(i)==seq.charAt(j))
		{
			dp[i][j]=2;
		}
		else if(seq.charAt(i)==seq.charAt(j))
		{
			dp[i][j] = SubSeq(seq,i+1,j-1,dp)+2;
		}
		else {
			dp[i][j] = Math.max(SubSeq(seq,i+1,j,dp), SubSeq(seq,i,j-1,dp));
		}
		
		return dp[i][j];
	}

}
