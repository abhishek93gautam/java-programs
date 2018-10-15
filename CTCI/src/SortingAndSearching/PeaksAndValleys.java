package SortingAndSearching;

import java.util.Arrays;

public class PeaksAndValleys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {9,1,0,4,8,7};
		int[] array = {9,1,0,4,8,7};
		int[] array2 = {9,1,0,4,8,7};
		//int[] array = {5,3,1,2,3};
		sortValleyPeakUnSorted(array1);
		sortValleyPeak(array);
		sortValleyPeakSorted(array2);
		PrintArray(array1);
		PrintArray(array);

	}
	
	static void PrintArray(int[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	public static void sortValleyPeak(int[] array) {
		Arrays.sort(array);
		for (int i = 1; i < array.length; i += 2) {
			swap(array, i - 1, i);
		}
	}
	
	public static void sortValleyPeakSorted(int[] array) {
		Arrays.sort(array);
		int i=0;
		int j=array.length-1;
		while(i<j)
		{
			System.out.print(array[j]+" "+array[i]+" ");
			i++;
			j--;
		}
		if(array.length%2!=0)
		{
			System.out.println(array[i]+" ");
		}
		else {
			System.out.println();
		}
		
	}
	
	static void sortValleyPeakUnSorted(int[] array)
	{
		for(int i=1;i<array.length;i+=2)
		{
			int maxIndex = maxIndex(array,i-1,i,i+1);
			if(i!=maxIndex)
			{
				swap(array,i,maxIndex);
			}
		}
	}
	static int maxIndex(int[] array,int a,int b,int c)
	{
		int len = array.length;
		int aVal = a>=0 && a<len ?array[a] : Integer.MIN_VALUE;
		int bVal = b>=0 && b<len ?array[b] : Integer.MIN_VALUE;
		int cVal = c>=0 && c<len ?array[c] : Integer.MIN_VALUE;
		int max = Math.max(aVal, Math.max(bVal, cVal));
		
		if(aVal==max)
		{
			return a;
		}
		else if(bVal==max)
		{
			return b;
		}
		else {
			return c;
		}
	}
	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

}
