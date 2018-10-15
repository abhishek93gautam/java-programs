package RecursionAndDP;

public class MagicIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {-10,-5,2,2,2,3,4,7,9,12,13};
		//int index = magicFastNormal(array);
		//System.out.print(index);
		int index = magicFastWithDuplicates(array);
		System.out.print(index);

	}
	
	public static int magicFastNormal(int[] array)
	{
		return magicFastNormal(array,0,array.length-1);
	}
	
	public static int magicFastNormal(int[] array,int start,int end)
	{
		if(end<start)
		{
			return -1;
			
		}
		
		int mid = (start+end)/2;
		
		if(array[mid]==mid)
		{
			return mid;
		}
		else if(array[mid]>mid)
		{
			return magicFastNormal(array, start, mid-1);
		}
		else {
			return magicFastNormal(array, mid+1, end);
		}
	}
	
	public static int magicFastWithDuplicates(int[] array)
	{
		return magicFastWithDuplicates(array,0,array.length-1);
	}
	public static int magicFastWithDuplicates(int[] array,int start,int last)
	{
		if(last<start)
		{
			return -1;
		}
		
		int mid = (start+last)/2;
		int midValue = array[mid];
		if(midValue==mid)
		{
			return mid;
		}
		
		int leftIndex = Math.min(mid-1, midValue);
		int left = magicFastWithDuplicates(array,start,leftIndex);
		if(left>=0)
		{
			return left;
		}
		
		int rightIndex = Math.max(mid+1, midValue);
		int right = magicFastWithDuplicates(array,rightIndex,last);
		return right;
		
	}
}
