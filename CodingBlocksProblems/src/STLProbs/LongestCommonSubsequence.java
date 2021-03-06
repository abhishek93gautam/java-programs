package STLProbs;

import java.io.BufferedReader;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		//int len = lenCommonSubseq(s1,s2);
		//System.out.println("Length of commom subsequence top down: "+len);
		//lenCommonSeqBottomUp(s1,s2);
		lenCommonSeqBottomUpLCSProblem(s1, s2);
		
	}
	
	static int lenCommonSubseq(String s1,String s2)
	{
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		return lenCommonSubseqTopDownHelper(s1,s2,s1.length()-1,s2.length()-1,dp);
	}
	
	static int lenCommonSubseqTopDownHelper(String s1,String s2,int m,int n,int[][] dp)
	{
		if(m<0 || n<0)
		{
			return 0;
		}
		
		if(dp[m][n]==0)
		{
			if(s1.charAt(m)==s2.charAt(n))
			{
				dp[m][n] = 1+lenCommonSubseqTopDownHelper(s1,s2,m-1,n-1,dp);
			}
			else {
				dp[m][n] = Math.max(lenCommonSubseqTopDownHelper(s1,s2,m-1,n,dp),lenCommonSubseqTopDownHelper(s1,s2,m,n-1,dp));
			}
		}
		
		return dp[m][n];
	}
	
	static void lenCommonSeqBottomUp(String s1,String s2)
	{
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<=s1.length();i++)
		{
			for(int j=1;j<=s2.length();j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		for(int i=1;i<=s1.length();i++)
		{
			for(int j=1;j<=s2.length();j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Length of commom subsequence bottom up: "+dp[s1.length()][s2.length()]);
		
		// Printing the longest subsequence
		int i = s1.length();
		int j = s2.length();
		StringBuilder result = new StringBuilder();
		int index = dp[i][j];
		while(i>0 && j>0)
		{
			if(s1.charAt(i-1)==s2.charAt(j-1))
			{
				result.append(s1.charAt(i-1));
				i--;
				j--;
				index--;
			}
			else if(dp[i-1][j] > dp[i][j-1])
			{
				i=i-1;
			}
			else {
				j=j-1;
			}
		}
		System.out.println("Longest common subsequence is : "+result.reverse());
		
	}
	
	static void lenCommonSeqBottomUpLCSProblem(String s1,String s2)
	{
		int m = s1.length();
		int n = s2.length();
		HashMap<Character,ArrayList<Integer>> map = new HashMap<Character,ArrayList<Integer>>();
		for(int i=0;i<n;i++) {
			if(map.containsKey(s2.charAt(i))) {
				map.get(s2.charAt(i)).add(i);
			}
			else {
				ArrayList<Integer> lst = new ArrayList();
				lst.add(i);
				map.put(s2.charAt(i), lst);
			}
		}
		
		int[][] dp = new int[m+1][n+1];
		int[][] dpReverse =new  int[m+1][n+1];
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		
		for(int i=1;i<=s1.length();i++)
		{
			for(int j=1;j<=s2.length();j++)
			{
				if(s1.charAt(m-i)==s2.charAt(n-j))
				{
					dpReverse[i][j] = 1+dpReverse[i-1][j-1];
				}
				else {
					dpReverse[i][j] = Math.max(dpReverse[i-1][j],dpReverse[i][j-1]);
				}
			}
		}
		int LCS = dp[m][n];
		int ans=0;
		for(int i=0;i<=m;i++) {
			for(Character key : map.keySet()) {
				ArrayList<Integer> lst = map.get(key);
				for(int j=0;j<lst.size();j++) {
					if(dp[i][lst.get(j)]+dpReverse[m-i][n-lst.get(j)-1]==LCS) {
						ans++;
						break;
					}
				}
				
			}
		}
		System.out.println(LCS+" "+ans);
		PrintArray(dp);
		PrintArray(dpReverse);
		
		
	}
	
	static void PrintArray(int[][] dp) {
		for(int i=1;i<dp.length;i++)
		{
			for(int j=1;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}

}
