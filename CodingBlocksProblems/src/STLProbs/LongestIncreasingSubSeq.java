package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestIncreasingSubSeq {
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = Integer.parseInt(str[i]);
		}
		
		int subseq = longestSubsequence(n,arr);
		System.out.println("Length of longest increasing subsequence is: "+subseq);
		
	}
	
	static int longestSubsequence(int n,int[] arr)
	{
		int[] lis = new int[n];
		int res = 0;
		// Minimum length for each index is 1
		for(int i=0;i<n;i++)
		{
			lis[i] = 1;
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arr[i] > arr[j] && lis[i]<lis[j]+1)
				{
					lis[i] = lis[j] + 1;
				}
					
			}
		}
		
		// find max of LIS array
		for(int i=0;i<n;i++)
		{
			if(res < lis[i])
			{
				res = lis[i];
			}
		}
		
		// print LIS 
		printLIS(res,arr,lis);
		
		return res;
	}
	
	static void printLIS(int res,int[] arr,int[] lis)
	{
		int prev = Integer.MAX_VALUE;
		
		for(int i=arr.length-1;i>=0;i--)
		{
			if(lis[i] == res && arr[i] < prev)
			{
				System.out.print(arr[i]+" ");
				res--;
				prev = arr[i];
			}
		}
		System.out.println();
		
	}
}
