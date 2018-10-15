import java.util.Arrays;

public class MeetMiddleSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {3,34,4,12,5,2};
		int[] arr1= {7,9,11,13};
		int[] arr2 = {1,4,6,10,12};
		int sum =10;
		int n =arr.length;
		System.out.println("lower bound less than equal to:" + lower_bound_lessThanEqual(arr1, 0, arr1.length-1, 5));
		System.out.println("Array binary search:" + Arrays.binarySearch(arr2, 5));
//		System.out.println("lower bound in duplicates :" +lower_bound(arr1, 0, arr1.length-1, 2));
//		System.out.println("lower bound new in duplicates: "+lower_boundnew(arr1, 0, arr1.length-1, 2));
//		System.out.println("upper bound in duplicates :" + upper_bound(arr1, 0, arr1.length-1, 3));
//		System.out.println("First Index in duplicates :" + firstIndex(arr1, 0, arr1.length-1, 3));
//		System.out.println("last Index in duplicates :" + lastIndex(arr1, 0, arr1.length-1, 3));
//		System.out.println("Number of elements are: "+ (lastIndex(arr1, 0, arr1.length-1, 3)-firstIndex(arr1, 0, arr1.length-1, 3)+1));
//		System.out.println(SolveLargestValue(arr,n,sum));

	}
	
	static void calculateSubarray(int[] arr,int[] x,int n,int c)
	{
		for(int i=0;i<(1<<n);i++)
		{
			int s = 0;
			for(int j=0;j<n;j++)
			{
				if((i&(1<<j))!=0)
				{
					s+=arr[j+c];
				}
			}
			x[i]=s;
		}
	}
	
	static int SolveLargestValue(int[] arr,int n,int sum)
	{
		int size_X = 1<<(n/2);
		int size_Y = 1<<(n-n/2);
		
		int[] X = new int[size_X];
		int[] Y = new int[size_Y];
		
		calculateSubarray(arr,X,n/2,0);
		calculateSubarray(arr,Y,n-n/2,n/2);
		
		Arrays.sort(Y);
		
		int max = 0;
		
		for(int i=0;i<size_X;i++)
		{
			if(X[i]<=sum)
			{
				int p = lower_boundnew(Y,0,size_Y-1, sum-X[i]);
				
//				if((p==size_Y) || Y[p]!=(sum-X[i]))
//				{
//					p--;
//				}
				if(Y[p]!=(sum-X[i]))
				{
					p--;
				}
				//System.out.println(Y[p]);
				if(Y[p]+X[i] > max)
				{
					max = Y[p]+X[i];
				}
			}
			
		}
		
		return max;
	}
	
	//Returns lower bound in non - duplicate array
	static int lower_bound(int[] arr,int start,int end,int value)
	{
		int low = start;
		int high = end;
		while(low<high){
			int mid = low + (high-low)/2;
			if(arr[mid]==value){
				return mid;
			}
			else if(arr[mid] < value)
			{
				low = mid+1;
			}
			else {
				high = mid;
			}
		}
		return low;
	}
	
	// Returns lower bound in duplicate array
	static int lower_boundnew(int[] arr,int start,int end,int value)
	{
		int low= start;
		int high = end;
		int mid=0;
		while(low<=high)
		{
			mid = low+((high-low)/2);
			if(arr[mid]>=value && ((mid==0)|| arr[mid-1]<value))
			{
				return mid;
			}
			else if(arr[mid]>=value)
			{
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return mid;
	}
	
	static int lower_bound_lessThanEqual(int[] arr,int start,int end,int value)
	{
		int low= start;
		int high = end;
		int mid=0;
		while(low<=high)
		{
			mid = low+((high-low)/2);
			if(arr[mid]<=value && ((mid==end)|| arr[mid+1]>value))
			{
				return mid;
			}
			else if(arr[mid]<=value)
			{
				low = mid+1;
			}
			else {
				high=mid-1;
			}
		}
		return mid;
	}
	
	// Returns upper bound in duplicate array
	static int upper_bound(int[] arr,int start,int end,int value)
	{
		int low= start;
		int high = end;
		int mid=0;
		while(low<=high)
		{
			mid = low+((high-low)/2);
			if(arr[mid]>value && ((mid==end)|| arr[mid-1]<=value))
			{
				return mid;
			}
			else if(arr[mid]>value)
			{
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return mid;
	}
	
	// Returns first index of element in duplicate array
	static int firstIndex(int[] arr,int start,int end,int value)
	{
		int low= start;
		int high = end;
		int ans=-1;
		while(low<=high)
		{
			int mid = low+((high-low)/2);
			if(arr[mid]==value)
			{
				ans = mid;
				high = mid-1;
			}
			else if(arr[mid]>value)
			{
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return ans;
	}
	
	// Returns last index of element in duplicate array
	static int lastIndex(int[] arr,int start,int end,int value)
	{
		int low= start;
		int high = end;
		int ans=-1;
		while(low<=high)
		{
			int mid = low+((high-low)/2);
			if(arr[mid]==value)
			{
				ans = mid;
				low = mid+1;
			}
			else if(arr[mid]>value)
			{
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return ans;
	}
}
