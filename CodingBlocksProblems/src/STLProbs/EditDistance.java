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
		System.out.print(edits);
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
	
	

}
