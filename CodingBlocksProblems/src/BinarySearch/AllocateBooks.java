package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllocateBooks {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inputString = br.readLine().split("\\s");
		int[] array = new int[n];
		for(int i=0;i<n;i++)
		{
			array[i] = Integer.parseInt(inputString[i]);
		}
		int m = Integer.parseInt(br.readLine());
		
		
		// calculate minimum of max pages
		int minPages= findpages(array,n,m);
//		int countPages = 0;
//		for(int i=0;i<=n-m;i++)
//		{
//			int maxPages = 0;
//			countPages += array[i];
//			maxPages = Math.max(countPages, sum-countPages);
//			minPages = Math.min(minPages, maxPages);
//		}
		
		System.out.println(minPages);
	}
	
	static int findpages(int[] arr,int n,int m)
	{
		int sum =0 ;
		for(int i=0;i<n;i++)
		{
			sum+=arr[i];
		}
		
		int start = 0;
		int end = sum;
		int result = Integer.MAX_VALUE;
		while(start<=end)
		{
			int mid = (start+end)/2;
			if(isPossible(arr,n,m, mid))
			{
				result = Math.min(result, mid);
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		
		return result;
	}
	
	static boolean isPossible(int[] arr,int n, int m,int mid)
	{
		int noOfstudents = 1;
		int cur_sum = 0 ;
		for(int i=0;i<n;i++)
		{
			if(arr[i]> mid)
			{
				return false;
			}
			
			if(cur_sum+arr[i]>mid)
			{
				noOfstudents++;
				cur_sum = cur_sum+arr[i];
				if(noOfstudents > m )
				{
					return false;
				}
			}
			else {
				cur_sum = cur_sum+arr[i];
			}
		}
		return true;
	}
	

}
