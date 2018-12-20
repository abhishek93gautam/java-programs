package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine().toUpperCase();
		String str2 = br.readLine().toUpperCase();
		
		int m = str1.length();
		int n=str2.length();
		
		int edits = MinEdits(str1,str2,m,n);
		System.out.println("Min edits top down dp : "+edits);
		System.out.println("Min edits bottom up dp : "+MinEditsBottomUpDp(str1, str2));
	}
	
	static int MinEdits(String str1,String str2,int m,int n)
	{
		int[][] dp=new int[m+1][n+1];
		MinEditsHelper(str1,str2,m,n,dp);
		return dp[m][n];
	}
	
	static int MinEditsHelper(String str1,String str2,int m,int n,int[][] dp)
	{
		if(m==0 && n==0)
		{
			return 0;
		}
		else if(m==0)
		{
			dp[m][n]=n;
		}
		else if(n==0)
		{
			dp[m][n]=m;
		}
		else if(str1.charAt(m-1)==str2.charAt(n-1))
		{
			dp[m][n]=MinEditsHelper(str1,str2,m-1,n-1,dp);
		}
		
		else if(dp[m][n]==0)
		{
			dp[m][n]=1+Math.min(Math.min(MinEditsHelper(str1,str2,m,n-1,dp),MinEditsHelper(str1,str2,m-1,n,dp)),MinEditsHelper(str1,str2,m-1,n-1,dp));
		}
		
		return dp[m][n];
	}
	
	static int MinEditsBottomUpDp(String str1,String str2)
	{
		int m = str1.length();
		int n = str2.length();
		
		int[][] dp= new int[m+1][n+1];
		
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				// When either of str length is 0
				if(i==0)
				{
					dp[i][j]=j;
				}
				else if(j==0)
				{
					dp[i][j]=i;
				}
				else if(str1.charAt(i-1)==str2.charAt(j-1))
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = 1+Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
				}
			}
		}
		
		return dp[m][n];
	}

}
