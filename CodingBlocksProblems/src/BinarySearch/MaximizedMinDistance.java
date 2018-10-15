package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MaximizedMinDistance {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inputString = br.readLine().split("\\s");
		int[] array = new int[n];
		for(int i=0;i<n;i++)
		{
			array[i] = Integer.parseInt(inputString[i]);
		}
		int k = Integer.parseInt(br.readLine());
		Arrays.sort(array);
		
		int result = findDistance(array, n, k);
		System.out.print(result);
	}
	
	static int findDistance(int[] arr,int n,int k)
	{
		int sum =0 ;
		for(int i=0;i<n;i++)
		{
			sum+=arr[i];
		}
		
		int start = 0;
		int end = sum;
		int result = Integer.MIN_VALUE;
		while(start<end)
		{
			int mid = (start+end)/2;
			if(IsFeasible(arr,mid,k))
			{
				result = Math.max(result, mid);
				start = mid + 1;
			}
			
			else {
				end = mid;
			}
		}
		return result;
	}
	
	static boolean IsFeasible(int[] arr,int mid,int k)
	{
		int numbersUsed = 1;
		int curr = arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]-curr >=  mid)
			{
				curr = arr[i];
				numbersUsed++;
				if(numbersUsed==k)
				{
					return true;
				}
			}
			
		}
		return false;
	}

}
