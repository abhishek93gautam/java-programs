import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class BeautifulTripletsProducts {

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
		
		// find max element next to an element
		int[] maxi=new int[n];
		maxi[n-1] = arr[n-1];
		for(int i=n-2;i>=0;i--)
		{
			maxi[i] = Math.max(arr[i], maxi[i+1]);
		}
		
		//PrintArray(maxi);
		// Make a set in which we will find the upper bound for the given value - maximum element on left side of middle
		// to make array sorted for binary search we will insert negative values in HashSet
		
		SortedSet<Integer> set =new TreeSet<Integer>();
		
		set.add(-arr[0]);
		int ans = 0;
		for(int i=1;i+1<n;i++)
		{
			int upperbound = UpperBoundNew(set,0,set.size()-1,-arr[i]);
			//System.out.print(upperbound+" ");
			if(-(upperbound)<arr[i] && maxi[i+1] > arr[i])
			{
				ans = Math.max(ans, -(upperbound)* arr[i] * maxi[i+1]);
			}
			set.add(-arr[i]);
		}
		System.out.println(ans);

	}
	
	static int UpperBoundNew(SortedSet<Integer> set,int start,int end,int value)
	{
		Integer[] arrayToSearch = new Integer[set.size()];
		arrayToSearch = set.toArray(arrayToSearch);
		int low= start;
		int high = end;
		int mid = 0;
		while(low<=high)
		{
			mid = low + (high-low)/2;
			if(arrayToSearch[mid]>value && ((mid==0)|| arrayToSearch[mid-1]<=value))
			{
				return arrayToSearch[mid];
			}
			else if(arrayToSearch[mid]>value)
			{
				high=mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return arrayToSearch[mid];
	}
	static int UpperBound(SortedSet<Integer> set,int start,int end,int value)
	{
		Integer[] arrayToSearch = new Integer[set.size()];
		arrayToSearch = set.toArray(arrayToSearch);
		int low= start;
		int high = end;
		//boolean flag = false;
		while(low<=high)
		{
			if(low==high)
			{
				return arrayToSearch[low];
			}
			int mid = low+(high-low)/2;
			if(value >= arrayToSearch[mid])
			{
				low= mid+1;
				//flag =true;
			}
			else {
				high = mid-1;
			}
			
		}
		return arrayToSearch[low];
		
	}
	
	static void PrintArray(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
}
