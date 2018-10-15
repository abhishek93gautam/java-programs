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
		System.out.println();
		System.out.print(lcs);

	}
	
	public static int LCS(String str1,String str2,int m,int n)
	{

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
		
		int i=m,j=n;
		int index = dp[m][n];
		char[] lcs_array = new char[index];
//		for(int a=1;a<=m;a++)
//		{
//			for(int b=1;b<=n;b++)
//			{
//				System.out.print(dp[a][b]+" ");
//			}
//			System.out.println();
//		}
//		
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
//		for(int k=0;k<lcs_array.length;k++)
//		{
//			System.out.print(lcs_array[k]);
//		}
		
		i=m-1;j=n-1;
		int l=dp[m][n]-1;
		index = 0;
		String ans="";
		
		while(i>=0 || j>=0)
		{
			if(l>=index)
			{

				while(j>=0 && str2.charAt(j)!= lcs_array[l])
				{
					ans+=str2.charAt(j--);
				}
				while(i>=0 && str1.charAt(i)!=lcs_array[l])
				{
					ans+=str1.charAt(i--);
				}
				
				ans+=lcs_array[l--];
				j--;
				i--;
			}
			else {
				
				while(j>=0)
				{
					ans+=str2.charAt(j--);
				}
				while(i>=0)
				{
					ans+=str1.charAt(i--);
				}
				
			}
		}
		
		for(int z=ans.length()-1;z>=0;z--)
		{
			System.out.print(ans.charAt(z));
		}
		
		return dp[m][n];
	}

}
