package SortingAndSearching;

import java.util.BitSet;

public class FindDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,2,3,4,5,6,6,7,8,8,9};
		checkDuplicates(arr);

	}
	
	static void checkDuplicates(int[] arr)
	{
		BitSet bs = new BitSet(32000);
		for(int i=0;i<arr.length;i++)
		{
			int num = arr[i];
			int num0= num-1;
			
			if(bs.get(num0))
			{
				System.out.println(num);
			}
			else {
				bs.set(num0);
			}
		}
	}

}
