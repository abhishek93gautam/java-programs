package topFiftyQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MedianOfArrays {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = br.readLine().split(" ");
		String[] str2 = br.readLine().split(" ");
		
		int[] arr1 = new int[str1.length];
		int[] arr2 = new int[str2.length];
		
		for(int i=0;i<str1.length;i++)
		{
			arr1[i] = Integer.parseInt(str1[i]);
		}
		
		for(int i=0;i<str2.length;i++)
		{
			arr2[i] = Integer.parseInt(str2[i]);
		}
		
		double m = median(arr1,arr2);
		
		System.out.println("The median is : "+m);
	}

	public static double median(int[] arr1,int[] arr2)
	{
		if(arr1.length==0 || arr1.length!=arr2.length)
		{
			throw new IllegalArgumentException();
		}
		return median(Subarray.fromArray(arr1),Subarray.fromArray(arr2));
	}
	
	private static double median(Subarray arr1,Subarray arr2)
	{
		if(arr1.getSize()==1)
		{
			return (arr1.getFirst()+arr2.getFirst())/2.0;
		}
		
		if(arr1.getSize()==2)
		{
			return (Math.max(arr1.getFirst(),arr2.getFirst())+Math.min(arr1.getLast(), arr2.getLast()))/2.0;
		}
		
		double median1 = arr1.getMedian();
		double median2 = arr2.getMedian();
		
		if(median1==median2)
		{
			return median1;
		}
		else if(median1>median2)
		{
			return median(arr1.subarray(0, arr1.getSize()/2+1),arr2.subarray((arr2.getSize()-1)/2, arr2.getSize()));
		}
		else {
			return median(arr1.subarray((arr1.getSize()-1)/2, arr1.getSize()),arr2.subarray(0, arr2.getSize()/2+1));
		}
		
		
	}
	
	// Helper class
	public static class Subarray
	{
		private int[] underlying;
		private int start;
		private int size;
		
		private static Subarray fromArray(int[] arr)
		{
			Subarray s = new Subarray();
			s.underlying = arr;
			s.start = 0;
			s.size = arr.length;
			return s;
		}
		
		
		private Subarray subarray(int i,int j)
		{
			if(i>j) 
			{
				throw new IllegalArgumentException();
			}
			if(j>this.size)
			{
				throw new IndexOutOfBoundsException();
			}
			
			Subarray s = new Subarray();
			s.underlying = this.underlying;
			s.start = this.start + i;
			s.size = j-i;
			return s;
		}
		
		private int getSize()
		{
			return size;
		}
		
		private int getFirst()
		{
			return underlying[start];
		}
		
		private int getLast()
		{
			return underlying[start+size-1];
		}
		
		private double getMedian()
		{
			if(size%2==0)
			{
				return (underlying[start+size/2 -1] + underlying[start+size/2])/2.0;
			}
			return underlying[start+size/2];
		}
	}
}
