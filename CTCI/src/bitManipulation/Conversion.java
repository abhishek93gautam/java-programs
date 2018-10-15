package bitManipulation;

public class Conversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(BitsToFlip(9, 13));
		int[] arr= {1,1,2,2,4,3,3,5,6,6,5};
		System.out.println(SingleNumber(arr));
	}
	
	public static int BitsToFlip(int a,int b)
	{
		int count=0;
		for(int x=a^b;x!=0;x>>=1)
		{
			if((x&1)==1)
			{
				count++;
			}
		}
		
		return count;
	}
	
	
	public static int SingleNumber(int[] arr)
	{
		int n=0;
		for(int i=0;i<arr.length;i++)
		{
			n^=arr[i];
		}
		
		return n;
	}

}
