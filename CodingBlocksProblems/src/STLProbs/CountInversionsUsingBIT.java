package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountInversionsUsingBIT {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		String[] str = br.readLine().split("\\s");
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = Integer.parseInt(str[i]);
		}
		
		System.out.print(getInversionCount(arr, n));
	}
	
	
	static void update(int[] BIT,int index,int val,int n)
	{
		while(index <=n)
		{
			BIT[index] += val;
			
			index+=(index &(-index));
		}
	}
	
	static int getSum(int[] BIT,int index)
	{
		int sum=0;
		while(index>0)
		{
			sum+=BIT[index];
			index -= (index &(-index));
		}
		
		return sum;
	}
	
	static int getInversionCount(int[] arr,int n)
	{
		int invCount=0;
		convert(arr,n);
		//Print(arr);
		int[] BIT=new int[n+1];
		
		for(int i=n-1;i>=0;i--)
		{
			invCount += getSum(BIT,arr[i]-1);
			update(BIT,arr[i],1,n);
		}
		return invCount;
	}
	
	static void convert(int[] arr,int n)
	{
		int[] temp = new int[n];
		for(int i=0;i<n;i++)
		{
			temp[i] = arr[i];
		}
		
		Arrays.sort(temp);
		for(int i=0;i<n;i++)
		{
			arr[i]= lower_boundnew(temp,0,n-1,arr[i]) + 1;
		}
	}
	
	static int lower_boundnew(int[] arr,int start,int end,int value)
	{
		int low =start;
		int high = end;
		int mid =0;
		while(low<=high)
		{
			mid = low + (high-low)/2;
			if(arr[mid]>=value && ((mid==0)|| arr[mid-1]<value))
			{
				return mid;
			}
			else if(arr[mid]>=value)
			{
				high=mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return mid;
	}
	
	static int lower_bound(int[] temp,int start,int end,int value)
	{
		int low = start;
		int high =end;
		while(low < high)
		{
			int mid = low + (high-low)/2;
			if(temp[mid]==value)
			{
				return mid;
			}
			if(temp[mid]<value)
			{
				low = mid+1;
			}
			else {
				high=mid;
			}
		}
		return low;
	}
	
	static void Print(int[] arr)
	{
		for(int j=0;j<arr.length;j++)
		{
			System.out.print(arr[j]+" ");
		}
	}

}
