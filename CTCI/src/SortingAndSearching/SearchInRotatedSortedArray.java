package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str=br.readLine().split("\\s");
		int[] arr= new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = Integer.parseInt(str[i]);
		}
		
		int res = BinarySearch(arr, 0, n-1, 25);
		System.out.print("Index: "+res);

	}
	
	static int BinarySearch(int[] arr,int low,int high,int value)
	{
		while(low<high)
		{
			int mid = low+(high-low)/2;
			
			if(arr[mid]==value)
			{
				return mid;
			}
			else if(arr[mid]>arr[low])
			{
				if(arr[mid]>value && value>=arr[low])
				{
					high=mid;
				}
				else {
					low = mid+1;
				}
			}
			else if(arr[mid]<arr[low])
			{
				if(arr[mid]<value && value<=arr[high])
				{
					low=mid+1;
				}
				else {
					high=mid;
				}
			}
		}
		return -1;
	}

}
