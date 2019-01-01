package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromicSubstring {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n=str.length();
		
		System.out.println("Length of longest palindromic substring bottom up : "+SubString(str));

	}
	
	public static int SubString(String str)
	{
		int n = str.length();
		boolean[][] dp= new boolean[n][n];
		
		// Calculating for length 1
		for(int i=0;i<n;i++)
		{
			dp[i][i] = true;
		}
		
		// Calculating for length 2
		int maxlength = 1;
		int start = 0;
		for(int i=0;i<n-1;i++)
		{
			if(str.charAt(i)==str.charAt(i+1))
			{
				dp[i][i+1]=true;
				start = i;
				maxlength = 2;
			}
		}
		
		//calculating for length 3
		
		for(int k=3;k<=n;k++)
		{
			for(int i=0;i<=(n-k);i++)
			{
				int j = k+i-1;
				if( dp[i+1][j-1] && str.charAt(i)==str.charAt(j))
				{
					dp[i][j] = true;
					if(k>maxlength)
					{
						start = i;
						maxlength = k;
					}
					
				}
			}
		}
		
		System.out.println("Longest palindromic substring is : "+str.substring(start, start+maxlength));
		return maxlength;
	}

}
