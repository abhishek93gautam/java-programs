package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baadshah {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("\\s");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		int[] arr=new int[n];
		String[] str1 = br.readLine().split("\\s");
		for(int i=0;i<n;i++)
		{
			arr[i]=Integer.parseInt(str1[i]);
		}
		
		int[] BIT = new int[n+1];
		int max = Integer.MIN_VALUE;
		for(int j=0;j<n;j++)
		{
			if(max<arr[j])
			{
				max = arr[j];
			}
		}
		
		constructBIT(BIT,arr,max);
		//Print(BIT);
		//return;
		
		for(int j=0;j<m;j++)
		{
			String[] str2 = br.readLine().split("\\s");
			int param = Integer.parseInt(str2[0]);
			if(param==1)
			{
				int index = Integer.parseInt(str2[1]);
				int value = Integer.parseInt(str2[2]);
				Update(BIT,index,value-arr[index-1],max);
				arr[index-1]=value;
				Print(BIT);
			}
			else if(param==2)
			{
				int valueToFound =Integer.parseInt(str2[1]);
				//System.out.print(valueToFound);
				int res = BinarySearch(BIT,1,BIT.length,valueToFound);
				//System.out.print(res);
				if(res==-1)
				{
					System.out.print("Not Found");
				}
				else {
					System.out.print("Found: "+res);
				}
			}
		}

	}
	
	static int BinarySearch(int[] BIT,int start,int end,int value)
	{
		while(start<end)
		{
			int mid = start + (end-start)/2;
			if(getSum(BIT,mid) == value)
			{
				return mid;
			}
			else if(BIT[mid] < value)
			{
				start=mid+1;
			}
			else {
				end = mid;
			}
		}
		return -1;
	}
	
	static void Update(int[] BIT,int index,int value,int n)
	{
		while(index<=n)
		{
			BIT[index]+=value;
			index+=(index & (-index));
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
	
	static void constructBIT(int[] BIT,int[] arr,int max)
	{
		for(int i=1;i<=arr.length;i++)
		{
			Update(BIT,i,arr[i-1],max);
		}
	}
	static void Print(int[] arr)
	{
		for(int j=0;j<arr.length;j++)
		{
			System.out.print(arr[j]+" ");
		}
	}

}
