package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCSFruits {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine().toUpperCase();
		String str2 = br.readLine().toUpperCase();
		
		int m = str1.length();
		int n=str2.length();
		int lcs = LCS(str1,str2,m,n);
		//System.out.println();
		System.out.print("Length of common subsequence : "+lcs);

	}
	
	public static int LCS(String str1,String str2,int m,int n)
	{

		// Finding the length of LCS
		int[][] dp = new int[m+1][n+1];
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(str1.charAt(i-1) ==str2.charAt(j-1))
				{
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		// Getting the LCS array
		int i=m,j=n;
		int index = dp[m][n];
		char[] lcs_array = new char[index];
		while(i>0 && j>0)
		{
			if(str1.charAt(i-1) == str2.charAt(j-1))
			{
				lcs_array[index-1]=str1.charAt(i-1);
				i--;
				j--;
				index--;
			}
			
			else if(dp[i-1][j]> dp[i][j-1]){
				i--;
			}
			else {
				j--;
			}
		}
		System.out.println(lcs_array);
		printLongestCommonSuperSequence(str1,str2,dp,lcs_array);
		return dp[m][n];
	}
	
	static void printLongestCommonSuperSequence(String str1,String str2,int[][] dp,char[] lcs_array) {
		StringBuilder result = new StringBuilder();
		int m = str1.length();
		int n = str2.length();
		int index = 0;
		int l = dp[m][n]-1;
		int i = m-1;
		int j=n-1;
		while(i>=0 || j>=0)
		{
			if(l>=index)
			{
				while(j>=0 && str2.charAt(j)!=lcs_array[l])
				{
					result.append(str2.charAt(j));
					j--;
				}
				while(i>=0 && str1.charAt(i)!=lcs_array[l])
				{
					result.append(str1.charAt(i));
					i--;
				}
				result.append(lcs_array[l]);
				l--;
				i--;
				j--;
				
			}
			else {
				while(j>=0)
				{
					result.append(str2.charAt(j));
					j--;
				}
				while(i>=0)
				{
					result.append(str1.charAt(i));
					i--;
				}
			}
		}
		System.out.println("Longest common supersequence is: "+result.reverse());
		
	}

}
