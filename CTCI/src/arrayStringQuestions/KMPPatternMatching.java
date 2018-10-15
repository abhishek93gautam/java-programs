package arrayStringQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMPPatternMatching {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String pattern = br.readLine();
		int n = input.length();
		int m = pattern.length();
		int[] lps = GenerateLPS(pattern);
		KMPMatcher(input,pattern,n,m,lps);
		//PrintArray(lps);

	}
	
	static void KMPMatcher(String s,String pattern,int n,int m,int[] lps)
	{
		int i=0;
		int j=0;
		while(i<n)
		{
			// If both match
			if(s.charAt(i)==pattern.charAt(j))
			{
				i++;
				j++;
			}
			if(j==m)
			{
				System.out.println("Pattern found at index: "+(i-j));
				j=lps[j-1];
			}
			else if(i<n && s.charAt(i)!=pattern.charAt(j))
			{
				if(j!=0)
				{
					j=lps[j-1];
				}
				else {
					i++;
				}
			}
		}
	}
	
	static int[] GenerateLPS(String s)
	{
		int[] lps = new int[s.length()];
		lps[0]=0;
		int len=0;
		int i=1;
		while(i<s.length())
		{
			if(s.charAt(i)==s.charAt(len))
			{
				len++;
				lps[i]=len;
				i++;
			}
			else {
				if(len>0)
				{
					len = lps[len-1];
				}
				else {
					lps[i]=0;
					i++;
				}
			}
		}
		return lps;
	}
	
	static void PrintArray(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

}
